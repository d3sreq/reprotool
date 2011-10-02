package reprotool.ide.views.sentenceanalysis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * Groups parts of the one action (use case step).
 * 
 * @author jvinarek
 * 
 */
public class BoxContainer extends Composite {
	private ActionTypeBox actionTypeBox;
	private VerbBox verbBox;
	private TextWithComboBox includeUseCaseBox;
	private TextWithComboBox gotoUseCaseStepBox;
	private TextWithComboBox indirectObjectBox;
	private TextWithComboBox directObjectBox;
	private TextWithComboBox subjectBox;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public BoxContainer(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm = new SashForm(this, SWT.NONE);

		actionTypeBox = new ActionTypeBox(sashForm, SWT.NONE);

		subjectBox = new TextWithComboBox(sashForm, SWT.NONE);
		subjectBox.getGrpActionPart().setText("Subject");

		verbBox = new VerbBox(sashForm, SWT.NONE);

		directObjectBox = new TextWithComboBox(sashForm, SWT.NONE);
		directObjectBox.getGrpActionPart().setText("Direct object");

		indirectObjectBox = new TextWithComboBox(sashForm, SWT.NONE);
		indirectObjectBox.getGrpActionPart().setText("Indirect object");

		gotoUseCaseStepBox = new TextWithComboBox(sashForm, SWT.NONE);
		gotoUseCaseStepBox.getGrpActionPart().setText("Goto target");

		includeUseCaseBox = new TextWithComboBox(sashForm, SWT.NONE);
		includeUseCaseBox.getGrpActionPart().setText("Include use case");

		sashForm.setWeights(new int[] { 1, 2, 1, 2, 2, 2, 2 });

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public ActionTypeBox getActionTypeBox() {
		return actionTypeBox;
	}

	public VerbBox getVerbBox() {
		return verbBox;
	}

	public TextWithComboBox getIncludeUseCaseBox() {
		return includeUseCaseBox;
	}

	public TextWithComboBox getGotoUseCaseStepBox() {
		return gotoUseCaseStepBox;
	}

	public TextWithComboBox getIndirectObjectBox() {
		return indirectObjectBox;
	}

	public TextWithComboBox getDirectObjectBox() {
		return directObjectBox;
	}

	public TextWithComboBox getSubjectBox() {
		return subjectBox;
	}
}
