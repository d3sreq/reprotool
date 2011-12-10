package reprotool.ide.editors.project.action;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import reprotool.ide.editors.project.ItemDialog;
import reprotool.model.swproj.ConceptualObject;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.swproj.SwprojPackage;

/**
 * Opens dialog with actor dialog and adds conceptual object using EMF command if user hits "OK".
 * 
 * @author jvinarek
 */
public class AddConceptualObjectAction extends AbstractAddAction {

	private SoftwareProject softwareProject;
	private EditingDomain editingDomain;

	public AddConceptualObjectAction(EditingDomain editingDomain, SoftwareProject softwareProject) {
		super("Add conceptual object");
		this.editingDomain = editingDomain;
		this.softwareProject = softwareProject;
	}

	@Override
	public void run() {
		ItemDialog itemDialog = new ItemDialog("Add conceptual object", Display.getCurrent().getActiveShell());
		if (itemDialog.open() == Window.OK) {
			// create actor
			ConceptualObject conceptualObject = SwprojFactory.eINSTANCE.createConceptualObject();
			conceptualObject.setName(itemDialog.getName());
			conceptualObject.setDescription(itemDialog.getDescription());

			// add actor to the project using command
			Command addCommand = new AddCommand(editingDomain, softwareProject, SwprojPackage.Literals.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS, conceptualObject);
			editingDomain.getCommandStack().execute(addCommand);
		}
	}
}
