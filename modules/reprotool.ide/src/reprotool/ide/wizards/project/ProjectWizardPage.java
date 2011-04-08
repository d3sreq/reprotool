package reprotool.ide.wizards.project;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

public class ProjectWizardPage extends WizardNewFileCreationPage {

	public ProjectWizardPage(String pageName, IStructuredSelection selection) {
		super(pageName, selection);
		// TODO Auto-generated constructor stub
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFile getModelFile() {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
	}

//	@Override
//	public IFile createNewFile() {
//		IFile file = super.createNewFile();
//		// add content to file
//		InputStream source = new InputStream() {
//			StringReader stringReader = new StringReader("abcd");
//			
//			@Override
//			public int read() throws IOException {				
//				return stringReader.read();
//			}
//		};
//		try {
//			file.appendContents(source, 0, null);
//		} catch (CoreException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return file;
//	}
	
	
	
//	/**
//	 * Create the wizard.
//	 */
//	public ProjectWizardPage() {
//		super("wizardPage");
//		setTitle("Wizard Page title");
//		setDescription("Wizard Page description");
//	}
//
//	/**
//	 * Create contents of the wizard.
//	 * @param parent
//	 */
//	public void createControl(Composite parent) {
//		Composite container = new Composite(parent, SWT.NULL);
//
//		setControl(container);
//	}

}
