package reprotool.ide.dialogs;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SwprojPackage;

public class ActorDetail extends Dialog {

	private DataBindingContext m_bindingContext;
	private Actor actor;
	private Text nameText;

	/**
	 * @wbp.parser.constructor
	 */
	public ActorDetail(Shell parentShell) {
		super(parentShell);		 
	}

	public ActorDetail(Shell parentShell,
			Actor newActor) {
		super(parentShell);
		setActor(newActor, false);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(2, false));

		new Label(container, SWT.NONE).setText("Name:");

		nameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label lblParent = new Label(container, SWT.NONE);
		lblParent.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblParent.setText("Parent:");

		Combo parentCombo = new Combo(container, SWT.NONE);
		parentCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		if (actor != null) {
			m_bindingContext = initDataBindings();
		}
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(267, 154);
	}

	private DataBindingContext initDataBindings() {
		IObservableValue nameObserveWidget = SWTObservables.observeText(
				nameText, SWT.Modify);
		IObservableValue nameObserveValue = EMFObservables
				.observeValue(
						actor,
						SwprojPackage.Literals.ACTOR__NAME);
		//
		DataBindingContext bindingContext = new DataBindingContext();
		//
		bindingContext.bindValue(nameObserveWidget, nameObserveValue, null,
				null);
		//
		return bindingContext;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor newActor) {
		setActor(newActor, true);
	}

	public void setActor(Actor newActor,
			boolean update) {
		actor = newActor;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (actor != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}

}
