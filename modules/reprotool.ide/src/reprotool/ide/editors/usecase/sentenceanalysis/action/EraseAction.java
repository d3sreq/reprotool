package reprotool.ide.editors.usecase.sentenceanalysis.action;

import org.eclipse.jface.action.IAction;

import reprotool.ide.Activator;
import reprotool.ide.editors.usecase.MarkingService;

public class EraseAction extends AbstractMarkingAction {

	public EraseAction(String text, IAction refreshEditorAction) {
		super(text, refreshEditorAction);
		imageDescriptor = Activator.getImageDescriptor("icons/erase-sq-16x16.png");
	}

	@Override
	public void run() {
		MarkingService.getInstance().erase();
		refreshEditorAction.run();
	}
}
