package reprotool.ide.editors.project;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;


public class ProjectEditorFormPage extends FormPage {

	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	public ProjectEditorFormPage(String id, String title) {
		super(id, title);
	}

	/**
	 * Create the form page.
	 * @param editor
	 * @param id
	 * @param title
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public ProjectEditorFormPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Project <name not set>");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(managedForm.getForm().getBody(), SWT.NONE);
		managedForm.getToolkit().adapt(sashForm);
		managedForm.getToolkit().paintBordersFor(sashForm);
		
		Composite composite = managedForm.getToolkit().createComposite(sashForm, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(composite);
		composite.setLayout(new GridLayout(1, false));
		
		NameDescriptionSectionPart nameDescriptionSectionPart = new NameDescriptionSectionPart(composite, managedForm.getToolkit(), Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		Section sctnNameAndDescription = nameDescriptionSectionPart.getSection();
		sctnNameAndDescription.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().paintBordersFor(sctnNameAndDescription);
		
		ItemsSectionPart sctnUseCases = new ItemsSectionPart(composite, managedForm.getToolkit(), Section.TITLE_BAR | Section.EXPANDED);
		Section sctnNewSectionpart_2 = sctnUseCases.getSection();
		sctnNewSectionpart_2.setText("Use cases");
		sctnNewSectionpart_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		managedForm.getToolkit().paintBordersFor(sctnNewSectionpart_2);
		
		Composite composite_1 = managedForm.getToolkit().createComposite(sashForm, SWT.NONE);
		managedForm.getToolkit().paintBordersFor(composite_1);
		composite_1.setLayout(new GridLayout(1, true));
		
		ItemsSectionPart sctnActors = new ItemsSectionPart(composite_1, managedForm.getToolkit(), Section.TITLE_BAR | Section.EXPANDED);
		Section sctnNewSectionpart = sctnActors.getSection();
		sctnNewSectionpart.setText("Actors");
		sctnNewSectionpart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		managedForm.getToolkit().paintBordersFor(sctnNewSectionpart);
		
		ItemsSectionPart sctnConceptualObjects = new ItemsSectionPart(composite_1, managedForm.getToolkit(), Section.TITLE_BAR | Section.EXPANDED);
		Section sctnNewSectionpart_1 = sctnConceptualObjects.getSection();
		sctnNewSectionpart_1.setText("Conceptual objects");
		sctnNewSectionpart_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		managedForm.getToolkit().paintBordersFor(sctnNewSectionpart_1);
		sashForm.setWeights(new int[] {373, 218});
		
		
	}
}
