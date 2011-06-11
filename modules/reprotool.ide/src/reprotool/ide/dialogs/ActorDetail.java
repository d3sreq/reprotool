package reprotool.ide.dialogs;

import java.util.List;

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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;

import reprotool.model.swproj.Actor;

public class ActorDetail extends Dialog {

	private DataBindingContext m_bindingContext;
	private Actor actor;
	private Text descriptionText;
	private Text nameText;
	private Label labelParentActor;
	private Combo parentActorCombo;
	private List<Actor> parentActorList;

	/**
	 * @wbp.parser.constructor
	 */
	public ActorDetail(Shell parentShell) {
		super(parentShell);
	}

	public ActorDetail(Shell parentShell, reprotool.model.swproj.Actor newActor) {
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

		Label labelName = new Label(container, SWT.NONE);
		labelName.setText("Name:");

		nameText = new Text(container, SWT.BORDER | SWT.SINGLE);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Label labelDescription = new Label(container, SWT.NONE);
		labelDescription.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		labelDescription.setText("Description:");

		descriptionText = new Text(container, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		GridData gd_descriptionText = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_descriptionText.heightHint = 40;
		descriptionText.setLayoutData(gd_descriptionText);

		labelParentActor = new Label(container, SWT.NONE);
		labelParentActor.setText("Parent actor");

		parentActorCombo = new Combo(container, SWT.NONE);
		parentActorCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

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
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(340, 175);
	}

	private DataBindingContext initDataBindings() {
		IObservableValue descriptionObserveWidget = SWTObservables.observeText(descriptionText, SWT.Modify);
		IObservableValue descriptionObserveValue = EMFObservables.observeValue(actor,
				reprotool.model.swproj.SwprojPackage.Literals.ACTOR__DESCRIPTION);
		
		IObservableValue nameObserveWidget = SWTObservables.observeText(nameText, SWT.Modify);
		IObservableValue nameObserveValue = EMFObservables.observeValue(actor,
				reprotool.model.swproj.SwprojPackage.Literals.ACTOR__NAME);
		
		// TODO - jvinarek - add parent actor
		
		//
		DataBindingContext bindingContext = new DataBindingContext();
		//
		bindingContext.bindValue(descriptionObserveWidget, descriptionObserveValue, null, null);
		bindingContext.bindValue(nameObserveWidget, nameObserveValue, null, null);
		//
		return bindingContext;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Actor detail");
	}

	public reprotool.model.swproj.Actor getActor() {
		return actor;
	}

	public void setActor(reprotool.model.swproj.Actor newActor) {
		setActor(newActor, true);
	}

	public void setActor(reprotool.model.swproj.Actor newActor, boolean update) {
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
