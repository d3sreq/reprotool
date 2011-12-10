package reprotool.ide.editors.project.action;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

public class AbstractRemoveAction extends BaseSelectionListenerAction {

	private ImageDescriptor imageDescriptor;
	
	public AbstractRemoveAction(String text) {
		super(text);
		imageDescriptor = PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE);
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return imageDescriptor;
	}
	
}
