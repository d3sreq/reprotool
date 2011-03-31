package reprotool.ide.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
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
		
		UseCaseEditor editor = (UseCaseEditor) page.getActiveEditor();
		UcStepView view = (UcStepView) page.findView(UcStepView.ID);
		if (view != null)
			view.lblStepSentence.setText(editor.getSelectedStep());
		
		return null;
	}
}
