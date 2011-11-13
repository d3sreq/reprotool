package reprotool.fm.nusmv.actions;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.osgi.framework.Bundle;

import reprotool.fm.nusmv.Activator;
import reprotool.fm.nusmv.MyNuSMVWrapper;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.usecase.UseCase;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class NuSMVTest implements IWorkbenchWindowActionDelegate {
	
	/**
	 * Converts a file name relative to the bundle location to an absolute
	 * path to the file.
	 * 
	 * @param bundleFileString location relative to the bundle directory
	 * @return absolute path to the file within file system
	 */
	private String bundleFileToAbsoluteFile( String bundleId, String relativeFileName) {
		Bundle bundle = Platform.getBundle( bundleId );
        URL fileURL = bundle.getEntry(relativeFileName);
        
		try {
			return FileLocator.resolve(fileURL).getFile();
		} catch (IOException e) {
			return fileURL.toExternalForm();
		}
	}
	
	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		MyNuSMVWrapper nusmv = Activator.getDefault().getNuSMVWrapper();
		nusmv.clearConsole();
		
		SoftwareProject swproj = generateTestingReprotoolModel();
		for (UseCase useCase : swproj.getUseCases()) {
			System.out.println( "Found UseCase: " + useCase.getName() );
		}
		
		// ----
		String modelFile = bundleFileToAbsoluteFile(
				Activator.PLUGIN_ID, "examples/uctest3.smv");
		
		nusmv.loadModelFile(modelFile);
        // ----
        
		try {
			nusmv.checkCTLSpec( "After 'open' there should always be 'close'",
					"AG(open_x -> AF(close_x))" );
			
			nusmv.checkCTLSpec( "No multi-open without close",
					"AG(open_x -> AX(A[!open_x U close_x]))" );
			
			nusmv.checkCTLSpec( "No multi-close without open",
					"AG(close_x -> AX(A[!close_x U open_x | !AF(close_x) ]))" );
			
			nusmv.checkCTLSpec( "First 'open' then 'close'",
					"A[!close_x U open_x | !AF(close_x)]" );
			
			nusmv.checkCTLSpec( "After 'create' there must be some branch containing 'use'",
					"AG( create_item -> EF(use_item) )" );
			
			nusmv.checkCTLSpec( "Only one 'create'",
					"AG( create_item -> AX(AG(!create_item)) )" );
			
			nusmv.checkCTLSpec( "No 'use' before 'create'",
					"A[ !use_item U create_item | !AF(use_item)]" );
			
			// ------------------------------------------------------
			
//			checkCTLSpec( "All UCs must finish in future",
//					"AF( x1.s=sFin & x1.y.s=sFin & x3.s=sFin & x4.s=sFin & x5.s=sFin )" );
//			
//			checkCTLSpec( "All UCs must be set to 'not running'",
//					"AF( !x1run & !x1.yrun & !x3run & !x4run & !x5run)" );
//
//			checkCTLSpec( "UCs cannot run in parallel",
//					"AG( x1run & !x3run & !x4run & !x5run | !x1run & x3run & !x4run & !x5run | !x1run & !x3run & x4run & !x5run | !x1run & !x3run & !x4run & x5run | !x1run & !x3run & !x4run & !x5run)" );

			
//			checkCTLSpec( "Showing trace to final state of UC_5",
//					"!EF(x5.s = sFin)" );
		} catch(Exception e) {
			nusmv.printMessage( e.getMessage() );
		}
	}
	
	/**
	 * TODO: load sample project from XMI and generate SMV code
	 * @return model of a software project from XMI
	 */
	private SoftwareProject generateTestingReprotoolModel() {
		
		URI sampleModelUri = URI.createPlatformPluginURI("/reprotool.model/model/SampleSoftwareProject.xmi", true);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(sampleModelUri, true);

		return (SoftwareProject) resource.getContents().get(0);		
	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
	}
}