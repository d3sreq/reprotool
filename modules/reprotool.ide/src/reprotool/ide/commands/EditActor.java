package reprotool.ide.commands;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;

import reprotool.ide.Activator;
import reprotool.ide.dialogs.ActorDetail;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;

/**
 * Command to remove selected actor from project. Used in project explorer.
 * 
 * @author jvinarek
 * 
 */
public class EditActor extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveWorkbenchWindow(event)
				.getActivePage().getSelection();

		if (!selection.isEmpty()) {
			Shell shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();

			Actor actor = (Actor) selection.getFirstElement();
			SoftwareProject project = (SoftwareProject) ((Actor) selection.getFirstElement()).eContainer();

			Actor newActor = EcoreUtil.copy(actor);

			// TODO - remove parent actors to prevent cycles
			ActorDetail actorDetail = new ActorDetail(shell, newActor, project.getActors());

			if (actorDetail.open() == Window.OK) {
				updateActor(newActor, actor);

				try {
					final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
					saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
							Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
					project.eResource().save(saveOptions);
				} catch (IOException e) {
					StatusManager.getManager().handle(
							new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Saving of the edited actor "
									+ actor.getName() + " failed", e), StatusManager.BLOCK | StatusManager.LOG);
				}
			}
		}

		return null;
	}

	private void updateActor(Actor srcActor, Actor tgtActor) {
		tgtActor.setName(srcActor.getName());
		tgtActor.setDescription(srcActor.getDescription());
		tgtActor.setParentActor(srcActor.getParentActor());
	}
}
