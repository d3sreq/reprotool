package reprotool.fm.nusmv.actions;

import java.io.IOException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.console.MessageConsoleStream;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import reprotool.fm.nusmv.Activator;
import reprotool.fm.nusmv.LogicFormulaType;
import reprotool.fm.nusmv.NuSMVWrapper;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangFactory;
import reprotool.fm.nusmv.mapping.NuSMVProj;
import reprotool.model.swproj.CounterExample;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.utils.xtend.ReprotoolMappingExtensions;


/**
 * The implementation class of the "Run the NuSMV verification" action.
 * 
 * @author rudo
 */
public class RunNuSMV implements IWorkbenchWindowActionDelegate {
	final private MessageConsoleStream consoleOut = Activator.getDefault().findConsole().newMessageStream();	
	private ISelection sel;
	private NuSMVProj nusmvProj;
		
	private boolean loadNuSMVProject(IPath projectFile) {
		final ResourceSet rs = new ResourceSetImpl();
		
		// Converting IFile to URI: see http://wiki.eclipse.org/index.php/EMF/FAQ#How_do_I_map_between_an_EMF_Resource_and_an_Eclipse_IFile.3F
		final URI uri = URI.createPlatformResourceURI(projectFile.toString(), true);
		final Resource resource = rs.getResource(uri, true);
		
		if(resource.getContents().size() == 0)
			return false;
		
		// show the console
		consoleOut.getConsole().clearConsole();
		consoleOut.getConsole().activate();
		
		EObject rootEObj = resource.getContents().get(0);
		
		if(!(rootEObj instanceof SoftwareProject)) {
			consoleOut.println("[NuSMV] Not a Software Project : " + rootEObj);
			return false;
		}

		final SoftwareProject swproj = (SoftwareProject) rootEObj;
		consoleOut.println("[NuSMV] found software Project : " + swproj.getName());
		
		// configuring injector
		Injector injector = Guice.createInjector( new AbstractModule() {
			@Override
			protected void configure() {
				bind(NuSmvLangFactory.class).toInstance(NuSmvLangFactory.eINSTANCE);
				bind(SoftwareProject.class).toInstance(swproj);
				bind(MessageConsoleStream.class).toInstance(consoleOut);
				bind(ReprotoolMappingExtensions.class).toInstance(new ReprotoolMappingExtensions());
			}
		});
		
		nusmvProj = injector.getInstance(NuSMVProj.class);
		
		try {
			nusmvProj.initializeSoftwareProject();
		} catch (RuntimeException e) {
			consoleOut.println("[NuSMV] Error: " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	@Override
	public void run(IAction action) {
		if(sel instanceof TreeSelection) {
			TreeSelection tsel = (TreeSelection) sel;
			IFile file = (IFile) tsel.getFirstElement();
			IPath filePath = file.getFullPath();
			while(!"swproj".equals(filePath.getFileExtension())) {
				IPath newFilePath = filePath.removeFileExtension();
				if(newFilePath == filePath) {
					checkArbitrarySmvModel(file);
					return;
				}
				filePath = newFilePath;
			}
			if (!loadNuSMVProject(filePath)) {
				return;
			}
			
			NuSMVWrapper nusmv = Activator.getDefault().getNuSMVWrapper();
			nusmv.loadModelFile( file );
			boolean counterExampleGenerated = false;
			
			if (nusmvProj.containsCTLFormulas()) {
				counterExampleGenerated = nusmv.checkInlineSpec(nusmvProj, LogicFormulaType.CTL);
			}
			
			if ((!counterExampleGenerated) && (nusmvProj.containsLTLFormulas())) {
				counterExampleGenerated = nusmv.checkInlineSpec(nusmvProj, LogicFormulaType.LTL);
			}
			
			if (!counterExampleGenerated) {
				if ((!nusmvProj.containsCTLFormulas()) && (!nusmvProj.containsLTLFormulas())) {
					consoleOut.println("[NuSMV] Your project does not contain any CTL/LTL specifications.");
					consoleOut.println("[NuSMV] You probably have not added any annotations to the project yet.");
				}
				return;
			}
			
			CounterExample counterExample = nusmv.getCounterExample();
			
			ResourceSet rs = new ResourceSetImpl();
			IPath fileName = file.getFullPath().removeFileExtension().addFileExtension("cexmp");
			URI fileURI = URI.createPlatformResourceURI(fileName.toString(), true);
			Resource resource = rs.createResource(fileURI);
			resource.getContents().add(counterExample);
	
			try {
				resource.save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void checkArbitrarySmvModel(IFile file) {
		NuSMVWrapper nusmv = Activator.getDefault().getNuSMVWrapper();
		nusmv.loadModelFile( file );
		nusmv.execCommand("go");
		nusmv.execCommand("check_ctlspec");
		System.err.println();
		nusmv.execCommand("check_ltlspec");
		System.err.println();
		try {
			nusmv.collectCheckerResults();
			nusmv.printMessage("[NuSMV] Verification finished");
		} catch (Exception e) {
			nusmv.printMessage(e.getMessage());
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		sel = selection;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}
}