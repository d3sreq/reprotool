package reprotool.txtimport.importWizards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.console.MessageConsoleStream;

import reprotool.ide.txtuc.txtUseCase.UseCase;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojFactory;
import reprotool.txtimport.Activator;
import reprotool.txtimport.ModelGenerator;
import reprotool.txtimport.UseCaseGenerator;


public class ImportWizard extends Wizard implements IImportWizard {
	final private MessageConsoleStream consoleOut = Activator.getDefault().findConsole().newMessageStream();	
	private InputSelectionPage inputSelectionPage;
	private OutputSelectionPage outputSelectionPage;
	private Resource projRes;
	private SoftwareProject swProj;
	private SwprojFactory swProjFactory = SwprojFactory.eINSTANCE;

	private HashMap<String, Actor> swProjActors = new HashMap<String, Actor>();
	private HashMap<String, reprotool.model.usecase.UseCase> ucMap = new HashMap<String,
			reprotool.model.usecase.UseCase>();
	private List<UseCase> ucModels = new ArrayList<UseCase>();
	
	public ImportWizard() {
		super();
	}
	
	private void loadProjectModel() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = createPlatformResourceURI(getProjectPath());
		
		if (outputSelectionPage.useExistingProj()) {
			projRes = resourceSet.getResource(uri, true);
			Object obj = projRes.getContents().get(0);
			Assert.isTrue(obj instanceof SoftwareProject);
			swProj = (SoftwareProject) obj;
			for (Actor actor: swProj.getActors()) {
				swProjActors.put(actor.getName(), actor);
			}
			for (reprotool.model.usecase.UseCase uc: swProj.getUseCases()) {
				ucMap.put(uc.getName(), uc);
			}
		} else {
			String projName = outputSelectionPage.newProjectName();
			projRes = resourceSet.createResource(uri);
			swProj = swProjFactory.createSoftwareProject();
			swProj.setName(projName);
			projRes.getContents().add(swProj);
		}		
	}
	
	private void saveProjectModel() {
		try {
			projRes.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private IPath getProjectPath() {
		IWorkspace ws = ResourcesPlugin.getWorkspace();

		if (outputSelectionPage.createNewProj()) {
			String projName = outputSelectionPage.newProjectName();
			IProject project = ws.getRoot().getProject(projName);
			try {
				if (!project.exists()) {
						project.create(null);
				}
				if (!project.isOpen()) {
				    project.open(null);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
			IPath absolutePath = project.getLocation();
			return absolutePath.append(new Path(projName).addFileExtension("swproj"));
		} else {
			return new Path(outputSelectionPage.existingProjectPath());
		}
	}
	
	private URI createPlatformResourceURI(IPath filePath) {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		
		if (ws.getRoot().getLocation().isPrefixOf(filePath)) {
			IPath relativePath = filePath.makeRelativeTo(ws.getRoot().getLocation());		
			return URI.createPlatformResourceURI(relativePath.toOSString(), true);
		} 
		
		IProject project = ws.getRoot().getProject("External-Files");
		IPath relativePath = null;
		
		try {
			if (!project.exists()) {
				project.create(null, IResource.HIDDEN, null);
			}
			if (!project.isOpen()) {
			    project.open(null);
			}
			IFile file = project.getFile(filePath.lastSegment());
			file.createLink(filePath, IResource.REPLACE | IResource.HIDDEN, null);
			relativePath = file.getFullPath();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
		return URI.createPlatformResourceURI(relativePath.toOSString(), true);
	}

	public boolean performFinish() {
		loadProjectModel();
		
		consoleOut.getConsole().clearConsole();
		consoleOut.getConsole().activate();
		
		for (String fileName: inputSelectionPage.getSelctedUseCases()) {
			IPath useCasePath = new Path(fileName);
			consoleOut.println("[Import] Loading use-case in file " + fileName);				
			URI uri = createPlatformResourceURI(useCasePath);
						
			ModelGenerator generator = new ModelGenerator(consoleOut);
			UseCase model = generator.getUseCase(uri);

			if (model == null) {
				System.out.println("Adaptation failed.");
			} else {
				System.out.println("Adaptation performed successfully.");
				consoleOut.println("[Import] Loaded use-case with name: \"" + model.getName() + "\"");
				ucModels.add(model);
				UseCaseGenerator gen = new UseCaseGenerator(model, consoleOut);
				reprotool.model.usecase.UseCase uc = gen.generateUseCase();
				ucMap.put(uc.getName(), uc);
				swProj.getUseCases().add(uc);
				
				String primaryActor = model.getHeader().getPrimaryActor();
				if ((primaryActor != null) && (!primaryActor.isEmpty())) {
					if (!swProjActors.containsKey(primaryActor)) {
						Actor a = swProjFactory.createActor();
						a.setName(primaryActor);
						swProjActors.put(primaryActor, a);
						swProj.getActors().add(a);
						consoleOut.println("[Import] Added actor \"" + primaryActor + "\" to the project.");
					}
					uc.setPrimaryActor(swProjActors.get(primaryActor));
				}
			}
		}
		
		for (UseCase model: ucModels) {
			reprotool.model.usecase.UseCase uc = ucMap.get(model.getName());
			for (String pred: model.getHeader().getPrecedingUseCases()) {
				if (ucMap.containsKey(pred)) {
					uc.getPrecedingUseCases().add(ucMap.get(pred));
				} else {
					consoleOut.println("[Import] Preceding use-case \"" + pred + "\" not found in the project.");
				}
			}
		}
		
		saveProjectModel();
		
		consoleOut.println("[Import] Import Finished.");
		
        return true;
	}
	
	public boolean canFinish() {
		return (
			(outputSelectionPage == getContainer().getCurrentPage()) &&
			outputSelectionPage.canFinish()
		);
	}
	 
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("File Import Wizard");
		setNeedsProgressMonitor(true);
		
		inputSelectionPage = new InputSelectionPage();
		outputSelectionPage = new OutputSelectionPage();
	}
	
    public void addPages() {
        super.addPages(); 
        addPage(inputSelectionPage);
        addPage(outputSelectionPage);
    }
}