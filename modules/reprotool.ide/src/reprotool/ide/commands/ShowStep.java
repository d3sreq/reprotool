package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import reprotool.ide.editors.UseCaseEditor;
import reprotool.ide.views.ParsedTreeView;
import reprotool.ide.views.UcStepView;

public class ShowStep extends AbstractHandler
{
	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		UcStepView view = (UcStepView) page.findView(UcStepView.ID);
		
		UseCaseEditor editor = UseCaseEditor.getUseCaseEditor();
		if (view != null && editor != null)
			view.setStep(editor.getSelectedStep());
		
		ParsedTreeView treeView = (ParsedTreeView) page.findView(ParsedTreeView.ID);
		if (treeView != null && editor != null && editor.getSelectedStep() != null) {
			treeView.showTree(editor.getSelectedStep().getParsedSentence());
		}
		
		return null;
	}
}
