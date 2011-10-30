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
	private ActivityBox activityBox;
	private TextWithComboBox includeUseCaseBox;
	private TextWithComboBox gotoUseCaseStepBox;
	private TextWithComboBox receiverBox;
	private TextWithComboBox actionParamBox;
	private TextWithComboBox senderBox;
	private SashForm sashForm;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public BoxContainer(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		sashForm = new SashForm(this, SWT.NONE);

		actionTypeBox = new ActionTypeBox(sashForm, SWT.NONE);

		senderBox = new TextWithComboBox(sashForm, SWT.NONE);
		senderBox.getGrpActionPart().setText("Sender");

		activityBox = new ActivityBox(sashForm, SWT.NONE);
		activityBox.getLblMarkedText().setText("Marked activity");

		actionParamBox = new TextWithComboBox(sashForm, SWT.NONE);
		actionParamBox.getGrpActionPart().setText("Action parameter");

		receiverBox = new TextWithComboBox(sashForm, SWT.NONE);
		receiverBox.getGrpActionPart().setText("Receiver");

		gotoUseCaseStepBox = new TextWithComboBox(sashForm, SWT.NONE);
		gotoUseCaseStepBox.getGrpActionPart().setText("Goto target");

		includeUseCaseBox = new TextWithComboBox(sashForm, SWT.NONE);
		includeUseCaseBox.getGrpActionPart().setText("Include use case");
		sashForm.setWeights(new int[] { 1, 1, 1, 1, 1, 1, 1 });
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public ActionTypeBox getActionTypeBox() {
		return actionTypeBox;
	}

	public ActivityBox getActivityBox() {
		return activityBox;
	}

	public TextWithComboBox getIncludeUseCaseBox() {
		return includeUseCaseBox;
	}

	public TextWithComboBox getGotoUseCaseStepBox() {
		return gotoUseCaseStepBox;
	}

	public TextWithComboBox getReceiverBox() {
		return receiverBox;
	}

	public TextWithComboBox getActionParamBox() {
		return actionParamBox;
	}

	public TextWithComboBox getSenderBox() {
		return senderBox;
	}

	public SashForm getSashForm() {
		return sashForm;
	}
}
