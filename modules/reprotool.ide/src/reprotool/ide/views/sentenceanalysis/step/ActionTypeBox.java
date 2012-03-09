package reprotool.ide.views.sentenceanalysis.step;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.jface.viewers.ComboViewer;

/**
 * Composite for action type selection.
 * 
 * @author jvinarek
 *
 */
public class ActionTypeBox extends Composite {
	private Group grpActionType;
	private ComboViewer comboViewer;

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
		
		comboViewer = new ComboViewer(grpActionType, SWT.READ_ONLY);
		Combo combo = comboViewer.getCombo();
		FormData fd_combo = new FormData();
		fd_combo.top = new FormAttachment(0, 10);
		fd_combo.left = new FormAttachment(0, 10);
		fd_combo.right = new FormAttachment(100, -7);
		combo.setLayoutData(fd_combo);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	public Group getGrpActionType() {
		return grpActionType;
	}
	public ComboViewer getComboViewer() {
		return comboViewer;
	}
}
