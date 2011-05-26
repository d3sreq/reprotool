package reprotool.ide.views;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import reprotool.ide.natures.ReprotoolProjectNature;
import reprotool.ide.service.Service;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.impl.SoftwareProjectImpl;
import reprotool.model.swproj.impl.SwprojFactoryImpl;

public class ActorsContentProvider implements ITreeContentProvider {

	// private static final String UCPROJ_EXT = "ucproj";
	private static final Object[] NO_CHILDREN = new Object[0];
	// private static final Object[] ACTORS = new String[] { "Actors" };
	// private static final Object[] DUMMY_ACTORS = new String[] { "Clerk",
	// "Account manager", "Bank information system"};

	private SoftwareProject[] swProjectModelArray;
	
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
			IProject project = (IProject)parentElement;
			try {
				if (project.hasNature(ReprotoolProjectNature.NATURE_ID)) {
					if (swProjectModelArray == null) {
						swProjectModelArray = loadSwProjectModel(project);
					}
					return swProjectModelArray; 
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
			return ((SoftwareProject)parentElement).getActors().toArray(); 
		}
		return NO_CHILDREN;
	}

	private SoftwareProject[] loadSwProjectModel(IProject project) throws IOException, CoreException {
		XMIResourceImpl resource = new XMIResourceImpl();
		IFile file = project.getFile("project.ucproj");
		
		HashMap<Object, Object> options = new HashMap<Object, Object>(); 
		resource.load(file.getContents(), options);
		SoftwareProject softwareProject = (SoftwareProject)resource.getContents().get(0);
		
		return new SoftwareProject[] { softwareProject };
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
