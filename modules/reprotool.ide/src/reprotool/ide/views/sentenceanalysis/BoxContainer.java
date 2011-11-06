package reprotool.ide.views.sentenceanalysis;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * Groups parts of the one action (use case step).
 * 
 * @author jvinarek
 * 
 */
public class BoxContainer extends Composite {
	private ActionTypeBox actionTypeBox;
	private ActivityBox sentenceActivityBox;
	private TextWithComboBox includeUseCaseBox;
	private TextWithComboBox gotoUseCaseStepBox;
	private TextWithComboBox receiverBox;
	private TextWithComboBox actionParamBox;
	private TextWithComboBox senderBox;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public BoxContainer(Composite parent, int style) {
		super(parent, style);
		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.fill = true;
		setLayout(rowLayout);

		actionTypeBox = new ActionTypeBox(this, SWT.NONE);

		senderBox = new TextWithComboBox(this, SWT.NONE);
		senderBox.getGrpActionPart().setText("Sender");

		sentenceActivityBox = new ActivityBox(this, SWT.NONE);
		RowData rd_activityBox = new RowData(SWT.DEFAULT, SWT.DEFAULT);
		sentenceActivityBox.setLayoutData(rd_activityBox);
		sentenceActivityBox.getLblMarkedText().setText("Marked activity");

		actionParamBox = new TextWithComboBox(this, SWT.NONE);
		// TODO - jvinarek - temporarily excluded
		RowData rd_actionParamBox = new RowData(SWT.DEFAULT, SWT.DEFAULT);
		rd_actionParamBox.exclude = true;
		actionParamBox.setLayoutData(rd_actionParamBox);
		actionParamBox.getGrpActionPart().setText("Action parameter");

		receiverBox = new TextWithComboBox(this, SWT.NONE);
		receiverBox.getGrpActionPart().setText("Receiver");

		gotoUseCaseStepBox = new TextWithComboBox(this, SWT.NONE);
		gotoUseCaseStepBox.getGrpActionPart().setText("Goto target");

		includeUseCaseBox = new TextWithComboBox(this, SWT.NONE);
		includeUseCaseBox.getGrpActionPart().setText("Include use case");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public ActionTypeBox getActionTypeBox() {
		return actionTypeBox;
	}

	public ActivityBox getSentenceActivityBox() {
		return sentenceActivityBox;
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

}
