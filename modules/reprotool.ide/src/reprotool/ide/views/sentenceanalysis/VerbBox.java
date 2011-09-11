package reprotool.ide.views.sentenceanalysis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class VerbBox extends Composite {
	private Label lblMarkedText;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public VerbBox(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Group grpVerb = new Group(this, SWT.NONE);
		grpVerb.setText("Verb");
		grpVerb.setLayout(new FormLayout());
		
		lblMarkedText = new Label(grpVerb, SWT.NONE);
		FormData fd_lblMarkedText = new FormData();
		fd_lblMarkedText.top = new FormAttachment(0, 10);
		fd_lblMarkedText.left = new FormAttachment(0, 10);
		lblMarkedText.setLayoutData(fd_lblMarkedText);
		lblMarkedText.setText("Marked verb");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	public Label getLblMarkedText() {
		return lblMarkedText;
	}
}
