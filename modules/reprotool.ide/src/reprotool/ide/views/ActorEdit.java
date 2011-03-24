package reprotool.ide.views;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ActorEdit extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text textAcronym;
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
		shell.setMinimumSize(new Point(400, 550));
		shell.setSize(400, 500);
		shell.setText(getText());
		FormLayout fl_shell = new FormLayout();
		fl_shell.marginWidth = 5;
		fl_shell.marginHeight = 5;
		shell.setLayout(fl_shell);
		
		Label lblEntityName = new Label(shell, SWT.NONE);
		FormData fd_lblEntityName = new FormData();
		fd_lblEntityName.top = new FormAttachment(0, 0);
		fd_lblEntityName.left = new FormAttachment(0, 0);
		fd_lblEntityName.right = new FormAttachment(100, 0);
		lblEntityName.setLayoutData(fd_lblEntityName);
		lblEntityName.setText("Entity name");
		
		text = new Text(shell, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.top = new FormAttachment(lblEntityName, 5);
		fd_text.left = new FormAttachment(0, 0);
		fd_text.right = new FormAttachment(100, 0);
		text.setLayoutData(fd_text);
		
		Label lblAcronym = new Label(shell, SWT.NONE);
		FormData fd_lblAcronym = new FormData();
		fd_lblAcronym.top = new FormAttachment(text, 5);
		fd_lblAcronym.left = new FormAttachment(0);
		lblAcronym.setLayoutData(fd_lblAcronym);
		lblAcronym.setText("Acronym");
		
		textAcronym = new Text(shell, SWT.BORDER);
		FormData fd_textAcronym = new FormData();
		fd_textAcronym.top = new FormAttachment(lblAcronym, 5);
		fd_textAcronym.left = new FormAttachment(0, 0);
		fd_textAcronym.right = new FormAttachment(100, 0);
		textAcronym.setLayoutData(fd_textAcronym);
		
		Label lblEntityDescription = new Label(shell, SWT.NONE);
		FormData fd_lblEntityDescription = new FormData();
		fd_lblEntityDescription.top = new FormAttachment(textAcronym, 5);
		fd_lblEntityDescription.left = new FormAttachment(0, 0);
		lblEntityDescription.setLayoutData(fd_lblEntityDescription);
		lblEntityDescription.setText("Entity description");
		
		textDescription = new Text(shell, SWT.BORDER | SWT.MULTI);
		FormData fd_textDescription = new FormData();
		fd_textDescription.top = new FormAttachment(lblEntityDescription, 5);
		fd_textDescription.left = new FormAttachment(0, 0);
		fd_textDescription.right = new FormAttachment(100, 0);
		fd_textDescription.bottom = new FormAttachment(lblEntityDescription, 100);
		textDescription.setLayoutData(fd_textDescription);
		
		Label lblParent = new Label(shell, SWT.NONE);
		FormData fd_lblParent = new FormData();
		fd_lblParent.top = new FormAttachment(textDescription, 5);
		fd_lblParent.left = new FormAttachment(0, 0);
		fd_lblParent.right = new FormAttachment(100, 0);
		lblParent.setLayoutData(fd_lblParent);
		lblParent.setText("Parent");
		
		Combo comboParent = new Combo(shell, SWT.NONE);
		FormData fd_combo = new FormData();
		fd_combo.top = new FormAttachment(lblParent, 5);
		fd_combo.left = new FormAttachment(0, 0);
		fd_combo.right = new FormAttachment(100, 0);
		comboParent.setLayoutData(fd_combo);
		
		Label lblChildren = new Label(shell, SWT.NONE);
		FormData fd_lblChildren = new FormData();
		fd_lblChildren.top = new FormAttachment(comboParent, 5);
		fd_lblChildren.left = new FormAttachment(0, 0);
		fd_lblChildren.right = new FormAttachment(100, 0);
		lblChildren.setLayoutData(fd_lblChildren);
		lblChildren.setText("Children");
		
		Button btnSave = new Button(shell, SWT.NONE);
		FormData fd_SaveButton = new FormData();
		fd_SaveButton.bottom = new FormAttachment(100, -5);
		fd_SaveButton.right = new FormAttachment(100, -5);
		btnSave.setLayoutData(fd_SaveButton);
		btnSave.setText("Save");
		
		List list = new List(shell, SWT.BORDER);
		FormData fd_list = new FormData();
		fd_list.bottom = new FormAttachment(btnSave, -5);
		fd_list.top = new FormAttachment(lblChildren, 5);
		fd_list.left = new FormAttachment(0, 0);
		fd_list.right = new FormAttachment(100, 0);
		list.setLayoutData(fd_list);
	}
}
