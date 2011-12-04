package reprotool.ide.editors.project;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

public class NameDescriptionSectionPart extends SectionPart {
	private Text txtName;
	private Text txtDescription;
	private Label lblName;
	private Label lblDescription;

	/**
	 * Create the SectionPart.
	 * @param parent
	 * @param toolkit
	 * @param style
	 */
	public NameDescriptionSectionPart(Composite parent, FormToolkit toolkit, int style) {
		super(parent, toolkit, style);
		createClient(getSection(), toolkit);
	}

	/**
	 * Fill the section.
	 */
	private void createClient(Section section, FormToolkit toolkit) {
		section.setText("Name and Description");
		Composite container = toolkit.createComposite(section);

		section.setClient(container);
		container.setLayout(new GridLayout(2, false));
		
		lblName = toolkit.createLabel(container, "Name:", SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtName = toolkit.createText(container, "New Text", SWT.BORDER);
		txtName.setText("");
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		lblDescription = toolkit.createLabel(container, "Description:", SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		
		txtDescription = toolkit.createText(container, "New Text", SWT.BORDER | SWT.MULTI);
		txtDescription.setText("");
		GridData gd_txtNewText_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtNewText_1.heightHint = 52;
		txtDescription.setLayoutData(gd_txtNewText_1);
	}

	public Text getTxtName() {
		return txtName;
	}

	public Text getTxtDescription() {
		return txtDescription;
	}
	
}
