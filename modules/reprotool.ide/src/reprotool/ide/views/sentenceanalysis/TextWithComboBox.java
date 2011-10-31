package reprotool.ide.views.sentenceanalysis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.viewers.ComboViewer;

/**
 * Composite showing text and combobox selection.
 * 
 * @author jvinarek
 *
 */
public class TextWithComboBox extends Composite {
	private Label lblMarkedText;
	private Group grpActionPart;
	private Combo combo;
	private ComboViewer comboViewer;
	private RowData rowData;
	
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
		fd_lblMarkedText.top = new FormAttachment(0, 13);
		fd_lblMarkedText.left = new FormAttachment(0, 10);
		lblMarkedText.setLayoutData(fd_lblMarkedText);
		lblMarkedText.setText("Marked text");
		
		comboViewer = new ComboViewer(grpActionPart, SWT.READ_ONLY);
		combo = comboViewer.getCombo();
		FormData fd_combo = new FormData();
		fd_combo.left = new FormAttachment(lblMarkedText, 6);
		fd_combo.top = new FormAttachment(0, 10);
		fd_combo.right = new FormAttachment(100, -7);
		combo.setLayoutData(fd_combo);

		// TODO - jvinarek - comment
		rowData = new RowData();
		setLayoutData(rowData);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	public Label getLblMarkedText() {
		return lblMarkedText;
	}
	public Group getGrpActionPart() {
		return grpActionPart;
	}
	public ComboViewer getComboViewer() {
		return comboViewer;
	}
	
	public void setVisibleAndInclude(boolean visibleAndInclude) {
		this.setVisible(visibleAndInclude);
		this.rowData.exclude = !visibleAndInclude;
	}
}
