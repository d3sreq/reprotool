package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import reprotool.ide.views.ProjectView;



/**
 * Command to add actor. Proof of concept
 * 
 * @author jvinarek
 *
 */
public class AddActor extends AbstractHandler {

	private static int counter = 0;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO - show dialog
//		ModelProvider.INSTANCE.getActors().add(new Actor("actor " + counter));
		counter++;
		
		// Updating the display in the view
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		ProjectView view = (ProjectView) page.findView(ProjectView.ID);
		view.getTreeViewer().refresh();
		
		return null;
	}

	

}
