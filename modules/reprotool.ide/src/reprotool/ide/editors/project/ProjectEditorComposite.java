package reprotool.ide.editors.project;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class ProjectEditorComposite extends Composite {
	private final FormToolkit formToolkit;
	private final Form form;
	private NameDescriptionComposite nameDescriptionComposite;
	private ItemsComposite useCasesComposite;
	private ItemsComposite conceptualObjectsComposite;
	private ItemsComposite actorsComposite;
	
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
		
		nameDescriptionComposite = new NameDescriptionComposite(leftComposite, SWT.NONE);
		nameDescriptionComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		formToolkit.adapt(nameDescriptionComposite);
		formToolkit.paintBordersFor(nameDescriptionComposite);
		
		useCasesComposite = new ItemsComposite(leftComposite, SWT.NONE);
		useCasesComposite.getSection().setText("Use cases");
		useCasesComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.adapt(useCasesComposite);
		formToolkit.paintBordersFor(useCasesComposite);
		
		Composite rightComposite = formToolkit.createComposite(sashForm, SWT.NONE);
		formToolkit.paintBordersFor(rightComposite);
		rightComposite.setLayout(new GridLayout(1, true));
		
		actorsComposite = new ItemsComposite(rightComposite, SWT.NONE);
		actorsComposite.getSection().setText("Actors");
		actorsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.adapt(actorsComposite);
		formToolkit.paintBordersFor(actorsComposite);
		
		conceptualObjectsComposite = new ItemsComposite(rightComposite, SWT.NONE);
		conceptualObjectsComposite.getSection().setText("Conceptual objects");
		conceptualObjectsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.adapt(conceptualObjectsComposite);
		formToolkit.paintBordersFor(conceptualObjectsComposite);
		
		sashForm.setWeights(new int[] {373, 218});
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Form getForm() {
		return form;
	}
	
	public NameDescriptionComposite getNameDescriptionComposite() {
		return nameDescriptionComposite;
	}
	public ItemsComposite getUseCasesComposite() {
		return useCasesComposite;
	}
	public ItemsComposite getConceptualObjectsComposite() {
		return conceptualObjectsComposite;
	}
	public ItemsComposite getActorsComposite() {
		return actorsComposite;
	}
}
