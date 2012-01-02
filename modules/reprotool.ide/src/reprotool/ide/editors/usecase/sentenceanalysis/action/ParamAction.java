package reprotool.ide.editors.usecase.sentenceanalysis.action;

import org.eclipse.jface.action.IAction;

import reprotool.ide.Activator;
import reprotool.ide.editors.usecase.MarkingService;

public class ParamAction extends AbstractMarkingAction {

	public ParamAction(String text, IAction refreshEditorAction) {
		super(text, refreshEditorAction);
		imageDescriptor = Activator.getImageDescriptor("icons/param-sq-16x16.png");
	}

	@Override
	public void run() {
		MarkingService.getInstance().markParam();
		refreshEditorAction.run();
	}
}
