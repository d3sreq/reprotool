package reprotool.ide.views.sentenceanalysis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class TextWithComboBox extends Composite {
	private Combo cmbMarkedText;
	private Label lblMarkedText;
	private Group grpActionPart;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TextWithComboBox(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		grpActionPart = new Group(this, SWT.NONE);
		grpActionPart.setText("Action part");
		grpActionPart.setLayout(new FormLayout());
		
		lblMarkedText = new Label(grpActionPart, SWT.NONE);
		FormData fd_lblMarkedText = new FormData();
		fd_lblMarkedText.top = new FormAttachment(0, 10);
		fd_lblMarkedText.left = new FormAttachment(0, 10);
		lblMarkedText.setLayoutData(fd_lblMarkedText);
		lblMarkedText.setText("Marked text");
		
		cmbMarkedText = new Combo(grpActionPart, SWT.READ_ONLY);
		FormData fd_cmbMarkedText = new FormData();
		fd_cmbMarkedText.top = new FormAttachment(lblMarkedText, -3, SWT.TOP);
		fd_cmbMarkedText.left = new FormAttachment(lblMarkedText, 6);
		fd_cmbMarkedText.right = new FormAttachment(100, -7);
		cmbMarkedText.setLayoutData(fd_cmbMarkedText);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	public Combo getCmbMarkedText() {
		return cmbMarkedText;
	}
	public Label getLblMarkedText() {
		return lblMarkedText;
	}
	public Group getGrpActionPart() {
		return grpActionPart;
	}
}
