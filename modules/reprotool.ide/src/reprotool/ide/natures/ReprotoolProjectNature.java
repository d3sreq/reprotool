package reprotool.ide.natures;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class ReprotoolProjectNature implements IProjectNature {

	/**
	 * ID of this project nature
	 */
	public static final String NATURE_ID = "reprotool.ide.natures.ReprotoolProjectNature";
	
	/**
	 * Here we keep the reference to the project to which this nature is attached
	 */
	private IProject project;
	
	@Override
	public void configure() throws CoreException {
		// nothing here
	}

	@Override
	public void deconfigure() throws CoreException {
		// nothing here
	}

	@Override
	public IProject getProject() {
		assert(project != null);
		return project;
	}

	@Override
	public void setProject(IProject project) {
		assert(project != null);
		this.project = project;
	}

	/**
	 * Helper static method.
	 * @param project
	 * @return TRUE if the given project has got the REPROTOOL Nature
	 */
	public static boolean hasThisNature(IProject project) {
		try {
			return project.hasNature(NATURE_ID);
		} catch (CoreException e) {
			return false;
		}
	}

}
