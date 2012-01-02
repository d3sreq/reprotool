package reprotool.ide.editors.usecase.sentenceanalysis.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

public abstract class AbstractMarkingAction extends BaseSelectionListenerAction {

	protected ImageDescriptor imageDescriptor;
	protected IAction refreshEditorAction;
	
	public AbstractMarkingAction(String text, IAction refreshEditorAction) {
		super(text);
		this.refreshEditorAction = refreshEditorAction;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return imageDescriptor;
	}
	
}
