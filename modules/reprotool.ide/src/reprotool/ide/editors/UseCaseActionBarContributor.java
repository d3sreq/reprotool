package reprotool.ide.editors;

import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.LabelRetargetAction;
import org.eclipse.ui.part.EditorActionBarContributor;

public class UseCaseActionBarContributor extends EditorActionBarContributor {
	private LabelRetargetAction undo = new LabelRetargetAction(ActionFactory.UNDO.getId(), "");
	private LabelRetargetAction redo = new LabelRetargetAction(ActionFactory.REDO.getId(), "");

	public UseCaseActionBarContributor() {
	}

	@Override
	public void setActiveEditor(IEditorPart editor) {
		super.setActiveEditor(editor);
		IActionBars bars = getActionBars();
		if (bars != null) {
			hookActions(editor, bars);
		}
	}

	private void hookActions(IEditorPart editor, IActionBars bars) {
		bars.setGlobalActionHandler(ActionFactory.UNDO.getId(),
				((UseCaseEditor) editor).getUndoAction());
		bars.setGlobalActionHandler(ActionFactory.REDO.getId(),
				((UseCaseEditor) editor).getRedoAction());
		bars.updateActionBars();
	}

	@Override
	public void init(IActionBars bars, IWorkbenchPage page) {
		super.init(bars, page);
		bars.clearGlobalActionHandlers();
		page.addPartListener(undo);
		page.addPartListener(redo);
	}

	@Override
	public void dispose() {
		getPage().removePartListener(undo);
		getPage().removePartListener(redo);
		super.dispose();
	}
}
