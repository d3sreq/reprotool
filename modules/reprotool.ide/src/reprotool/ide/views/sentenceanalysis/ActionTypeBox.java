package reprotool.ide.views.sentenceanalysis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class ActionTypeBox extends Composite {
	private Combo cmbActionType;
	private Group grpActionType;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ActionTypeBox(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		grpActionType = new Group(this, SWT.NONE);
		grpActionType.setText("Action type");
		grpActionType.setLayout(new FormLayout());
		
		cmbActionType = new Combo(grpActionType, SWT.READ_ONLY);
		FormData fd_cmbActionType = new FormData();
		fd_cmbActionType.top = new FormAttachment(0, 10);
		fd_cmbActionType.left = new FormAttachment(0, 7);
		fd_cmbActionType.right = new FormAttachment(100, -7);
		cmbActionType.setLayoutData(fd_cmbActionType);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	public Combo getCmbActionType() {
		return cmbActionType;
	}
	public Group getGrpActionType() {
		return grpActionType;
	}
}
