package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import reprotool.ide.editors.UseCaseEditor;
import reprotool.ide.views.ParsedTreeView;
import reprotool.ling.LingTools;
import reprotool.model.usecase.UseCaseStep;

public class ShowStep extends AbstractHandler
{
	/*
	 * LingTools is just a temporary stupid implementation of a sentence parsing
	 * and tree building.
	 * When the real linguistic tools are added to this project, they will be used. 
	 */
	private static final LingTools lingTools = new LingTools();
	
	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		if (window == null)
			return null;
		
		IWorkbenchPage page = window.getActivePage();
		
		UseCaseEditor editor = UseCaseEditor.getActiveUseCaseEditor();
		
		ParsedTreeView treeView = (ParsedTreeView) page.findView(ParsedTreeView.ID);
		if (treeView != null && editor != null && editor.getSelectedStep() != null) {
			UseCaseStep ucstep = editor.getSelectedStep();
			if (ucstep.getParsedSentence() == null) {
//				ucstep.setParsedSentence(lingTools.parseSentence(ucstep.getSentence()));
				// TODO - jvinarek - fix
				ucstep.setParsedSentence(lingTools.parseSentence(""));
			}
			treeView.showTree(editor.getSelectedStep().getParsedSentence());
		}
		
		return null;
	}
}
