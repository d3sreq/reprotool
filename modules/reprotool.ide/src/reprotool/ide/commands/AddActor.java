package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import reprotool.ide.service.Service;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;

/**
 * Command to add actor. Proof of concept
 * 
 * @author jvinarek
 * 
 */
public class AddActor extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null && selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			if (structuredSelection.getFirstElement() instanceof SoftwareProject) {
				SoftwareProject project = (SoftwareProject) structuredSelection.getFirstElement();
				Actor newActor = Service.INSTANCE.createActor();
				newActor.setName("test");
				project.getActors().add(newActor);

				// TODO - notify navigator
//				org.eclipse.ui.navigator.CommonNavigator c;
//				c.getCommonViewer().refresh();

			}
		}

		return null;
	}

}
