package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import reprotool.ide.dialogs.ActorDetail;
import reprotool.ide.editors.ProjectEditor;
import reprotool.ide.editors.UseCaseEditor;
import reprotool.ide.service.Service;
import reprotool.model.specification.Actor;
import reprotool.model.specification.SoftwareProject;

/**
 * Command to add actor. Proof of concept
 * 
 * @author jvinarek
 * 
 */
public class AddActor extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Actor newActor = Service.INSTANCE.createActor();
		ProjectEditor projectEditor = (ProjectEditor)HandlerUtil.getActiveEditor(event);
		
		ActorDetail dialog = new ActorDetail(null, newActor);

		if (dialog.open() == Window.OK) {
			projectEditor.getProject().getActors().add(dialog.getActor());
			projectEditor.markDirty();
		}

		return null;
	}

}
