package reprotool.ide.editors.usecase.action;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import reprotool.ide.Activator;
import reprotool.ide.editors.usecase.MarkingService;

public class IncludeUseCaseAction extends BaseSelectionListenerAction {

	private ImageDescriptor imageDescriptor;
	
	public IncludeUseCaseAction(String text) {
		super(text);
		imageDescriptor = Activator.getImageDescriptor("icons/include_use_case-sq-16x16.png");
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return imageDescriptor;
	}
	
	@Override
	public void run() {
		MarkingService.getInstance().markIncludeUseCase();
	}
}
