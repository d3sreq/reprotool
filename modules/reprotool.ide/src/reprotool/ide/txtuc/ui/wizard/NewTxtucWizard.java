package reprotool.ide.txtuc.ui.wizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

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

		openEditor(file);

		return file != null;
	}

	private void openEditor(IFile file) {
		FileEditorInput editorInput = new FileEditorInput(file);

		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();

		IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry()
				.findEditor("reprotool.ide.txtuc.TxtUseCase");

		try {
			page.openEditor(editorInput, desc.getId());
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

}
