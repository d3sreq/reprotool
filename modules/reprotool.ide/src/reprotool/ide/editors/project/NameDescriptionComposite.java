package reprotool.ide.editors.project;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class NameDescriptionComposite extends Composite {
	private final FormToolkit toolkit = new FormToolkit(Display.getDefault());

	private Text txtName;
	private Text txtDescription;
	private Label lblName;
	private Label lblDescription;

	private Section section;
	
	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NameDescriptionComposite(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		section = toolkit.createSection(this, Section.TWISTIE | Section.TITLE_BAR);
		toolkit.paintBordersFor(section);
		section.setExpanded(true);

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

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Text getTxtName() {
		return txtName;
	}

	public Text getTxtDescription() {
		return txtDescription;
	}

	public Section getSection() {
		return section;
	}
	
}
