package reprotool.ide.views;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.PartInitException;

import reprotool.ide.natures.ReprotoolProjectNature;
import reprotool.model.swproj.SoftwareProject;

/**
 * Provides additional content (actors hierarchy) for the navigator (project
 * explorer).
 * 
 * @author jvinarek
 * 
 */
public class ActorsContentProvider implements ITreeContentProvider, IResourceChangeListener, IResourceDeltaVisitor {

	private ResourceSet resourceSet;
	private Viewer inputChangedViewer;
	private static final Object[] NO_CHILDREN = new Object[0];

	public ActorsContentProvider() {
		resourceSet = new ResourceSetImpl();
		// listener to refresh project explorer view when actor is added/removed
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
	}

	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
		this.inputChangedViewer = viewer;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IProject) {
			IProject project = (IProject) parentElement;
			try {
				if (project.hasNature(ReprotoolProjectNature.NATURE_ID)) {
					return loadSwProjectModel(project);
				} else {
					return NO_CHILDREN;
				}
			} catch (CoreException e) {
				// TODO - jvinarek - log
				e.printStackTrace();
			} catch (IOException e) {
				// TODO - jvinarek - log
				e.printStackTrace();
			}
		}
		if (parentElement instanceof SoftwareProject) {
			return ((SoftwareProject) parentElement).getActors().toArray();
		}
		return NO_CHILDREN;
	}

	private SoftwareProject[] loadSwProjectModel(IProject project) throws IOException, CoreException {
		String filePath = project.getFile("project.ucproj").getFullPath().toString();
		URI uri = URI.createPlatformResourceURI(filePath, true);
		Resource resource = resourceSet.getResource(uri, true);
		resource.load(resourceSet.getLoadOptions());

		if (resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof SoftwareProject)) {
			throw new PartInitException("File does not contain a reprotool project");
		}

		SoftwareProject softwareProject = (SoftwareProject) resource.getContents().get(0);
		return new SoftwareProject[] { softwareProject };
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {

		if (element instanceof IProject) {
			return true;
		}

		if (element instanceof SoftwareProject) {
			return !((SoftwareProject) element).getActors().isEmpty();
		}

		return false;
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource changedResource = delta.getResource();
		if (changedResource.getType() == IResource.FILE && changedResource.getFileExtension().equals("ucproj")) {
			try {
				String path = ((IFile) changedResource).getFullPath().toString();
				URI uri = URI.createPlatformResourceURI(path, true);
				Resource res = resourceSet.getResource(uri, true);
				res.unload();
				res.load(resourceSet.getLoadOptions());

				inputChangedViewer.refresh();
			} catch (IOException ie) {
				System.out.println("Error reloading resource - " + ie.toString());
			}
			// return false;
		}
		return true;
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		// TODO Auto-generated method stub
		try {
			IResourceDelta delta = event.getDelta();
			delta.accept(this);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

}
