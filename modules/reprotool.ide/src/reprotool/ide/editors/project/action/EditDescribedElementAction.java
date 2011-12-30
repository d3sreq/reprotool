package reprotool.ide.editors.project.action;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import reprotool.ide.editors.project.ItemDialog;
import reprotool.model.swproj.DescribedElement;
import reprotool.model.swproj.SwprojPackage;

/**
 * Opens dialog with item dialog and changes items's properties using EMF
 * command if user hits "OK".
 * 
 * @author jvinarek
 */
public class EditDescribedElementAction extends BaseSelectionListenerAction {

	private EditingDomain editingDomain;
	private String title;

	public EditDescribedElementAction(EditingDomain editingDomain, String title) {
		super("Edit item");
		this.editingDomain = editingDomain;
		this.title = title;
	}

	@Override
	public void run() {
		// get edited item
		IStructuredSelection selection = getStructuredSelection();
		
		DescribedElement item = (DescribedElement)selection.getFirstElement();
		ItemDialog itemDialog = new ItemDialog(title, Display.getCurrent().getActiveShell());
		itemDialog.setName(item.getName() == null ? "" : item.getName());
		itemDialog.setDescription(item.getDescription() == null ? "" : item.getDescription());
		
		if (itemDialog.open() == Window.OK) {
			// change item using EMF command
			Command changeNameCommand = new SetCommand(editingDomain, item,
					SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME, itemDialog.getName());
			
			Command changeDescriptionCommand = new SetCommand(editingDomain, item,
					SwprojPackage.Literals.DESCRIBED_ELEMENT__DESCRIPTION, itemDialog.getDescription());
			
			CompoundCommand compoundCommand = new CompoundCommand();
			compoundCommand.append(changeNameCommand);
			compoundCommand.append(changeDescriptionCommand);
			
			editingDomain.getCommandStack().execute(compoundCommand);
		}
	}
}
