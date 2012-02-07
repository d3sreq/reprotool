package reprotool.txtimport.importWizards;

import java.io.IOException;
import java.util.Collections;
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
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import reprotool.ide.txtuc.txtUseCase.UseCase;
import reprotool.model.swproj.SoftwareProject;
import reprotool.txtimport.UseCaseGenerator;


public class ImportWizard extends Wizard implements IImportWizard {
	private InputSelectionPage inputSelectionPage;
	private OutputSelectionPage outputSelectionPage;
	
	public ImportWizard() {
		super();
	}
	
	private void storeUseCase(UseCase u) {
		UseCaseGenerator gen = new UseCaseGenerator(u);
		reprotool.model.usecase.UseCase useCase = gen.generateUseCase();
		IPath projectPath = new Path(outputSelectionPage.existingProjectPath());
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		Assert.isTrue(ws.getRoot().getLocation().isPrefixOf(projectPath));
		IPath relativePath = projectPath.makeRelativeTo(ws.getRoot().getLocation());
		URI uri = URI.createPlatformResourceURI(relativePath.toOSString(), true);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		Object obj = resource.getContents().get(0);
		Assert.isTrue(obj instanceof SoftwareProject);
		
		SoftwareProject swProj = (SoftwareProject) obj;
		swProj.getUseCases().add(useCase);
		
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean performFinish() {
		if (outputSelectionPage.useExistingProj()) {
			List<String> useCases = inputSelectionPage.getSeelctedUseCases();
			String fileName = useCases.get(0);
			IPath useCasePath = new Path(fileName);

			System.out.println("Loading use-case " + fileName);
			UseCase model = null;
			URI uri = null;
			
			IWorkspace ws = ResourcesPlugin.getWorkspace();
			if (ws.getRoot().getLocation().isPrefixOf(useCasePath)) {
				System.out.println("Use-case is already in the workspace.");
				IPath relativePath = useCasePath.makeRelativeTo(ws.getRoot().getLocation());
				System.out.println("The relative path is: " + relativePath);
				uri = URI.createPlatformResourceURI(relativePath.toOSString(), true);
			} else {
				IProject project = ws.getRoot().getProject("External-Files");
				try {
					if (!project.exists()) {
						project.create(null, IResource.HIDDEN, null);
					}
					if (!project.isOpen()) {
					    project.open(null);
					}
					IFile file = project.getFile(useCasePath.lastSegment());
					file.createLink(useCasePath, IResource.REPLACE | IResource.HIDDEN, null);
					IPath relativePath = file.getFullPath();
					uri = URI.createPlatformResourceURI(relativePath.toOSString(), true);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("The generated uri is: " + uri.path());								
			model = (UseCase) Platform.getAdapterManager().getAdapter(uri, UseCase.class);

			if (model == null) {
				System.out.println("Adaptation failed.");
			} else {
				System.out.println("Adaptation performed successfully.");
				System.out.println("UC name: " + model.getName());
				
				storeUseCase(model);
			}
		}
		
        return true;
	}
	
	public boolean canFinish() {
		return outputSelectionPage.canFinish();
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