package reprotool.ide.txtuc.ui.wizard;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import reprotool.ide.Activator;

public class NewTxtucWizardPage extends WizardNewFileCreationPage {

	public NewTxtucWizardPage(IStructuredSelection selection) {
        super("NewTxtucFileWizardPage", selection);
        setTitle("Text use case file");
        setDescription("Creates a new Text use case file");
        setFileExtension("txtuc");
    }

    @Override
    protected InputStream getInitialContents() {
        try {
            return Activator.getDefault().getBundle().getEntry("/resources/empty.txtuc").openStream();
        } catch (IOException e) {
        	e.printStackTrace();
            return null; // ignore and create empty comments
        }
    }
}
