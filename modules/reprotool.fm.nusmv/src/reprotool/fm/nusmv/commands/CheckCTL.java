package reprotool.fm.nusmv.commands;

import java.io.IOException;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import reprotool.fm.nusmv.Activator;
import reprotool.fm.nusmv.NuSMVWrapper;
import reprotool.fm.nusmv.NuSMVProject;
import reprotool.model.swproj.CounterExample;
import reprotool.model.swproj.SoftwareProject;

public class CheckCTL implements IHandler {
	
	private void loadNuSMVProject(IPath projectFile) {
		final ResourceSet rs = new ResourceSetImpl();
		
		// Converting IFile to URI: see http://wiki.eclipse.org/index.php/EMF/FAQ#How_do_I_map_between_an_EMF_Resource_and_an_Eclipse_IFile.3F
		final URI uri = URI.createPlatformResourceURI(projectFile.toString(), true);
		final Resource resource = rs.getResource(uri, true);
		
		if(resource.getContents().size() == 0)
			return;
		
		EObject rootEObj = resource.getContents().get(0);
		
		if( ! (rootEObj instanceof SoftwareProject) ) {
			System.out.println("NOT a SWPROJ : " + rootEObj);
			return;
		}

		SoftwareProject swproj = (SoftwareProject) rootEObj;
		System.out.println("FOUND SWPROJ : " + swproj);
				
		NuSMVProject nusmvProj = new NuSMVProject(swproj);
		Activator.getDefault().setNuSMVProject(nusmvProj);
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if(sel instanceof TreeSelection) {
			TreeSelection tsel = (TreeSelection) sel;
			IFile file = (IFile) tsel.getFirstElement();
			
			if (Activator.getDefault().getNuSMVProject() == null) {
				loadNuSMVProject(file.getFullPath().removeFileExtension());
			}
			
			NuSMVWrapper nusmv = Activator.getDefault().getNuSMVWrapper();
			nusmv.clearConsole();
			nusmv.loadModelFile( file );
			nusmv.checkInlineCTLSpec();
			
			CounterExample counterExample = nusmv.getCounterExample();
			
			ResourceSet rs = new ResourceSetImpl();
			IPath fileName = file.getFullPath().removeFileExtension().addFileExtension("cexmp");
			URI fileURI = URI.createPlatformResourceURI(fileName.toString(), true);
			Resource resource = rs.createResource(fileURI);
			resource.getContents().add(counterExample);
	
			try {
				resource.save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}
	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
