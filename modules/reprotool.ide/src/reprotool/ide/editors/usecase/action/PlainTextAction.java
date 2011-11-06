package reprotool.ide.editors.usecase.action;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import reprotool.ide.Activator;

public class PlainTextAction extends BaseSelectionListenerAction {

	private ImageDescriptor imageDescriptor;
	
	public PlainTextAction(String text) {
		super(text);
		imageDescriptor = Activator.getImageDescriptor("icons/plain_text-sq-16x16.png");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return imageDescriptor;
	}
}
