package reprotool.ide.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.core.commands.AbstractHandler;

import reprotool.ide.editors.UseCaseEditor;
import reprotool.ide.views.UcStepView;

public class ShowStep extends AbstractHandler
{
	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		
		IEditorPart editor = page.getActiveEditor();
		UcStepView view = (UcStepView) page.findView(UcStepView.ID);
		if (view != null && editor != null && editor instanceof UseCaseEditor)
			view.lblStepSentence.setText(((UseCaseEditor)editor).getSelectedStep());
		
		return null;
	}
}
