package reprotool.ide.editors.usecase.action;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import reprotool.ide.Activator;
import reprotool.ide.editors.usecase.MarkingService;

public class ParamAction extends BaseSelectionListenerAction {

	private ImageDescriptor imageDescriptor;
	
	public ParamAction(String text) {
		super(text);
		imageDescriptor = Activator.getImageDescriptor("icons/param-sq-16x16.png");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return imageDescriptor;
	}
	
	@Override
	public void run() {
		MarkingService.getInstance().markParam();
	}
}
