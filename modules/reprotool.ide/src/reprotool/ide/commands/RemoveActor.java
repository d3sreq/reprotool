package reprotool.ide.commands;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;

/**
 * Command to remove selected actor from project. Used in project explorer.
 * 
 * @author jvinarek
 * 
 */
public class RemoveActor extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		// //the current selection in the project explorer
		IStructuredSelection selection = (IStructuredSelection) page.getSelection(IPageLayout.ID_PROJECT_EXPLORER);

		if (!selection.isEmpty()) {
			Iterator iter = selection.iterator();
			SoftwareProject project = (SoftwareProject) ((Actor) selection.getFirstElement()).eContainer();

			while (iter.hasNext()) {
				Actor actor = (Actor) iter.next();
				project.getActors().remove(actor);
			}

			try {
				project.eResource().save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				// TODO - jvinarek - add logging
				e.printStackTrace();
			}
		}

		return null;
	}
}
