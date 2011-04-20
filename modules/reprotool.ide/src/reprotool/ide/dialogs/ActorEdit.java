package reprotool.ide.dialogs;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

public class ActorEdit extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text textDescription;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ActorEdit(Shell parent, int style) {
		super(parent, style);
		setText("Edit actor");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.RESIZE);
		shell.setMinimumSize(new Point(400, 200));
		shell.setSize(400, 250);
		shell.setText(getText());
		FormLayout fl_shell = new FormLayout();
		fl_shell.marginWidth = 5;
		fl_shell.marginHeight = 5;
		shell.setLayout(fl_shell);
		
		Label lblActorName = new Label(shell, SWT.NONE);
		FormData fd_lblActorName = new FormData();
		fd_lblActorName.top = new FormAttachment(0, 0);
		fd_lblActorName.left = new FormAttachment(0, 0);
		fd_lblActorName.right = new FormAttachment(100, 0);
		lblActorName.setLayoutData(fd_lblActorName);
		lblActorName.setText("Actor name");
		
		text = new Text(shell, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.top = new FormAttachment(lblActorName, 5);
		fd_text.left = new FormAttachment(0, 0);
		fd_text.right = new FormAttachment(100, 0);
		text.setLayoutData(fd_text);
		
		Label lblEntityDescription = new Label(shell, SWT.NONE);
		FormData fd_lblEntityDescription = new FormData();
		fd_lblEntityDescription.top = new FormAttachment(text, 5);
		fd_lblEntityDescription.left = new FormAttachment(0, 0);
		lblEntityDescription.setLayoutData(fd_lblEntityDescription);
		lblEntityDescription.setText("Actor description");
		
		textDescription = new Text(shell, SWT.BORDER | SWT.MULTI);
		FormData fd_textDescription = new FormData();
		fd_textDescription.top = new FormAttachment(lblEntityDescription, 5);
		fd_textDescription.left = new FormAttachment(0, 0);
		fd_textDescription.right = new FormAttachment(100, 0);
		
		Button btnSave = new Button(shell, SWT.NONE);
		FormData fd_SaveButton = new FormData();
		fd_SaveButton.bottom = new FormAttachment(100, -5);
		fd_SaveButton.right = new FormAttachment(100, -5);
		btnSave.setLayoutData(fd_SaveButton);
		btnSave.setText("Save");
		
		fd_textDescription.bottom = new FormAttachment(btnSave, -5);
		textDescription.setLayoutData(fd_textDescription);
	}
}
