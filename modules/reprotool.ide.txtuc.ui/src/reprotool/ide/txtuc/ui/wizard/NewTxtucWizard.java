package reprotool.ide.txtuc.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class NewTxtucWizard extends Wizard implements INewWizard {

	private IStructuredSelection selection;
	private NewTxtucWizardPage newFileWizardPage;

	public NewTxtucWizard() {
		setWindowTitle("New text use case file");
	}

	@Override
	public void addPages() {
		newFileWizardPage = new NewTxtucWizardPage(selection);
		addPage(newFileWizardPage);
	}

	@Override
	public boolean performFinish() {
		IFile file = newFileWizardPage.createNewFile();
		return file != null;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
	
}
