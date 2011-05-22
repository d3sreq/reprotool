package reprotool.ide.views;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import reprotool.ide.service.Service;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;

public class ActorsContentProvider implements ITreeContentProvider {

	// private static final String UCPROJ_EXT = "ucproj";
	private static final Object[] NO_CHILDREN = new Object[0];
	// private static final Object[] ACTORS = new String[] { "Actors" };
	// private static final Object[] DUMMY_ACTORS = new String[] { "Clerk",
	// "Account manager", "Bank information system"};

	// TODO - jvinarek - mock only
	private static final SoftwareProject[] PROJECT = new SoftwareProject[] { Service.INSTANCE.getSoftwareProject() };

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IProject) {
			// TODO - jvinarek - test only, change
			return PROJECT;
		}
		if (parentElement instanceof SoftwareProject) {
			((SoftwareProject)parentElement).getActors().toArray(); 
		}
		return NO_CHILDREN;
	}

	@Override
	public Object getParent(Object element) {
		// TODO - dummy implementation
		if (element instanceof Actor) {
			return PROJECT[0];
		}
		
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		
		if (element instanceof IProject) {
			return true;
		}
		
		if (element instanceof SoftwareProject) {
			return !((SoftwareProject)element).getActors().isEmpty();
		}

		return false;
	}

}
