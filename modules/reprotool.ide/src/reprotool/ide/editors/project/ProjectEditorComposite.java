package reprotool.ide.editors.project;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

public class ProjectEditorComposite extends Composite {
	private final FormToolkit formToolkit;
	private final Form form;
	
	private final ItemsSectionPart sctnConceptualObjects;
	private final ItemsSectionPart sctnActors;
	private final ItemsSectionPart sctnUseCases;
	private final NameDescriptionSectionPart scntNameAndDescription;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ProjectEditorComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		formToolkit = new FormToolkit(Display.getDefault());
		
		form = formToolkit.createForm(this);
		formToolkit.paintBordersFor(form);
		formToolkit.decorateFormHeading(form);
		form.setText("Use case");
		form.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(form.getBody(), SWT.NONE);
		formToolkit.adapt(sashForm);
		formToolkit.paintBordersFor(sashForm);
		
		Composite leftComposite = formToolkit.createComposite(sashForm, SWT.NONE);
		formToolkit.paintBordersFor(leftComposite);
		leftComposite.setLayout(new GridLayout(1, false));
		
		scntNameAndDescription = new NameDescriptionSectionPart(leftComposite, formToolkit, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		Section sctnNewSectionpart_0 = scntNameAndDescription.getSection();
		sctnNewSectionpart_0.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		formToolkit.paintBordersFor(sctnNewSectionpart_0);
		
		sctnUseCases = new ItemsSectionPart(leftComposite, formToolkit, Section.TITLE_BAR | Section.EXPANDED);
		Section sctnNewSectionpart_2 = sctnUseCases.getSection();
		sctnNewSectionpart_2.setText("Use cases");
		sctnNewSectionpart_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(sctnNewSectionpart_2);
		
		Composite rightComposite = formToolkit.createComposite(sashForm, SWT.NONE);
		formToolkit.paintBordersFor(rightComposite);
		rightComposite.setLayout(new GridLayout(1, true));
		
		sctnActors = new ItemsSectionPart(rightComposite, formToolkit, Section.TITLE_BAR | Section.EXPANDED);
		Section sctnNewSectionpart = sctnActors.getSection();
		sctnNewSectionpart.setText("Actors");
		sctnNewSectionpart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(sctnNewSectionpart);
		
		sctnConceptualObjects = new ItemsSectionPart(rightComposite, formToolkit, Section.TITLE_BAR | Section.EXPANDED);
		Section sctnNewSectionpart_1 = sctnConceptualObjects.getSection();
		sctnNewSectionpart_1.setText("Conceptual objects");
		sctnNewSectionpart_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(sctnNewSectionpart_1);
		sashForm.setWeights(new int[] {373, 218});
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public ItemsSectionPart getSctnConceptualObjects() {
		return sctnConceptualObjects;
	}

	public ItemsSectionPart getSctnActors() {
		return sctnActors;
	}

	public ItemsSectionPart getSctnUseCases() {
		return sctnUseCases;
	}

	public NameDescriptionSectionPart getScntNameAndDescription() {
		return scntNameAndDescription;
	}

	public Form getForm() {
		return form;
	}
	
}
