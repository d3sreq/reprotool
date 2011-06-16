package reprotool.ide.views;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;

/**
 * Provides labels for the content added by {@link ActorsContentProvider}.
 * 
 * @author jvinarek
 * 
 */
public class ActorsLabelProvider implements ILabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImage(Object element) {

		// if (element instanceof SoftwareProject) {
		// return Activator.getImageDescriptor("icons/diary.gif").createImage();
		// }
		// if (element instanceof Actor) {
		// return Activator.getImageDescriptor("icons/actor.gif").createImage();
		// }
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof Actor) {
			return ((Actor) element).getName();
		}
		if (element instanceof SoftwareProject) {
			return "Actors";
		}

		return null;
	}

}
