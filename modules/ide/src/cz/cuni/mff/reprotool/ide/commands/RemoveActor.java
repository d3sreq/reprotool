package cz.cuni.mff.reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import cz.cuni.mff.reprotool.ide.model.Actor;
import cz.cuni.mff.reprotool.ide.service.ModelProvider;
import cz.cuni.mff.reprotool.ide.views.ProjectView;

/**
 * Command to remove selected actor. Proof of concept.
 * 
 * @author jvinarek
 *
 */
public class RemoveActor extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get selected actor
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		ProjectView view = (ProjectView) page.findView(ProjectView.ID);
		IStructuredSelection selection = (IStructuredSelection)view.getTreeViewer().getSelection();
		if (!selection.isEmpty()) {
			Actor actor = (Actor)selection.iterator().next();
			
			// remove from model
			ModelProvider.INSTANCE.getActors().remove(actor);
	
			// reload view
			view.getTreeViewer().refresh();
		}

		return null;
	}

}
