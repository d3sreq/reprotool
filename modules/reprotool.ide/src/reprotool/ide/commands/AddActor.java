package reprotool.ide.commands;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProduct;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.part.IPage;

import reprotool.ide.service.Service;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;

/**
 * Command to add actor. Proof of concept
 * 
 * @author jvinarek
 * 
 */
public class AddActor extends AbstractHandler {

	// private ResourceSet resourceSet = new ResourceSetImpl();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// TODO - softwareProject as command parameter ?
		// - project as command paramter ?
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null && selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			if (structuredSelection.getFirstElement() instanceof SoftwareProject) {
				SoftwareProject softwareProject = (SoftwareProject) structuredSelection.getFirstElement();
				Actor newActor = Service.INSTANCE.createActor();
				newActor.setName("test");
				softwareProject.getActors().add(newActor);

				try {
					final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
					saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
							Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
					softwareProject.eResource().save(saveOptions);
				} catch (IOException e) {
					e.printStackTrace();
				}

//				org.eclipse.ui.navigator.CommonViewer.
				
//				CommonNavigator.
				
//				c.getCommonViewer().re
//				CommonNagivator c;
				
				
				// softwareProject.eResource()
				// IFile file
				// selection.

//				Resource resource = softwareProject.eResource();
//				if (resource instanceof XMIResource) {
//					IFile projectFile = xmiResourceToIFile((XMIResource)resource);
//					try {
//						projectFile.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
//						
//					} catch (CoreException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}

				// TODO - notify navigator
				// org.eclipse.ui.navigator.CommonNavigator c;
				// c.getCommonViewer().refresh();
				// structuredSelection.

			}
		}

		return null;
	}

	private IFile xmiResourceToIFile(XMIResource xmiResource) {
		URI uri = xmiResource.getURI();
		uri = xmiResource.getResourceSet().getURIConverter().normalize(uri);
		String scheme = uri.scheme();

		if ("platform".equals(scheme) && uri.segmentCount() > 1 && "resource".equals(uri.segment(0))) {
			StringBuffer platformResourcePath = new StringBuffer();
			for (int j = 1, size = uri.segmentCount(); j < size; ++j) {
				platformResourcePath.append('/');
				platformResourcePath.append(uri.segment(j));
			}
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformResourcePath.toString()));
		} else {
			throw new RuntimeException("Unable to convert to IFile: " + xmiResource);
		}

	}

	private String getInputFilePath() {
		// return ((FileEditorInput)
		// getEditorInput()).getFile().getFullPath().toString();
		return "project.ucproj";
	}

}
