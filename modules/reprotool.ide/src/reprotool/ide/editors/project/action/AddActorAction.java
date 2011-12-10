package reprotool.ide.editors.project.action;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import reprotool.ide.editors.project.ItemDialog;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.swproj.SwprojPackage;

/**
 * Opens dialog with actor dialog and adds actor using EMF command if user hits "OK".
 * 
 * @author jvinarek
 */
public class AddActorAction extends AbstractAddAction {

	private SoftwareProject softwareProject;
	private EditingDomain editingDomain;

	public AddActorAction(EditingDomain editingDomain, SoftwareProject softwareProject) {
		super("Add actor");
		this.editingDomain = editingDomain;
		this.softwareProject = softwareProject;
	}

	@Override
	public void run() {
		ItemDialog itemDialog = new ItemDialog("Add actor", Display.getCurrent().getActiveShell());
		if (itemDialog.open() == Window.OK) {
			// create actor
			Actor actor = SwprojFactory.eINSTANCE.createActor();
			actor.setName(itemDialog.getName());
			actor.setDescription(itemDialog.getDescription());

			// add actor to the project using command
			Command addCommand = new AddCommand(editingDomain, softwareProject, SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS, actor);
			editingDomain.getCommandStack().execute(addCommand);
		}
	}
}
