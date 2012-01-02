package reprotool.ide.editors.usecase.sentenceanalysis.action;

import org.eclipse.jface.action.IAction;

import reprotool.ide.Activator;
import reprotool.ide.editors.usecase.MarkingService;

public class IncludeUseCaseAction extends AbstractMarkingAction {

	public IncludeUseCaseAction(String text, IAction refreshEditorAction) {
		super(text, refreshEditorAction);
		imageDescriptor = Activator.getImageDescriptor("icons/include_use_case-sq-16x16.png");
	}

	@Override
	public void run() {
		MarkingService.getInstance().markIncludeUseCase();
		refreshEditorAction.run();
	}
}
