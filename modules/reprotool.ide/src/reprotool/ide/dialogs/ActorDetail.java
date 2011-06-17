package reprotool.ide.dialogs;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ComboViewer;
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
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.emf.databinding.EMFObservables;
import reprotool.model.swproj.SwprojPackage.Literals;
import org.eclipse.jface.databinding.viewers.ViewersObservables;

public class ActorDetail extends Dialog {

	private DataBindingContext m_bindingContext;
	private Actor actor;
	private Text descriptionText;
	private Text nameText;
	private Label labelParentActor;
	private List<Actor> parentActorList;
	private Combo combo;
	private ComboViewer comboViewer;

	/**
	 * @wbp.parser.constructor
	 */
	public ActorDetail(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE);
	}

	public ActorDetail(Shell parentShell, Actor newActor, List<Actor> parentActorList) {
		this(parentShell);
		this.parentActorList = parentActorList;
		this.actor = newActor;
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
		labelParentActor.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		labelParentActor.setText("Parent actor");

		comboViewer = new ComboViewer(container, SWT.READ_ONLY);
		combo = comboViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

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
		m_bindingContext = initDataBindings();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(360, 220);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Actor detail");
	}

	public Actor getActor() {
		return actor;
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		comboViewer.setContentProvider(listContentProvider);
		//
		IObservableMap observeMap = PojoObservables.observeMap(listContentProvider.getKnownElements(), Actor.class, "name");
		comboViewer.setLabelProvider(new ObservableMapLabelProvider(observeMap));
		//
		WritableList writableList = new WritableList(parentActorList, Actor.class);
		comboViewer.setInput(writableList);
		//
		IObservableValue nameTextObserveTextObserveWidget = SWTObservables.observeText(nameText, SWT.Modify);
		IObservableValue actorNameObserveValue = EMFObservables.observeValue(actor, Literals.ACTOR__NAME);
		bindingContext.bindValue(nameTextObserveTextObserveWidget, actorNameObserveValue, null, null);
		//
		IObservableValue descriptionTextObserveTextObserveWidget = SWTObservables.observeText(descriptionText, SWT.Modify);
		IObservableValue actorDescriptionObserveValue = EMFObservables.observeValue(actor, Literals.ACTOR__DESCRIPTION);
		bindingContext.bindValue(descriptionTextObserveTextObserveWidget, actorDescriptionObserveValue, null, null);
		//
		IObservableValue comboViewerObserveSingleSelection = ViewersObservables.observeSingleSelection(comboViewer);
		IObservableValue actorParentActorObserveValue = EMFObservables.observeValue(actor, Literals.ACTOR__PARENT_ACTOR);
		bindingContext.bindValue(comboViewerObserveSingleSelection, actorParentActorObserveValue, null, null);
		//
		return bindingContext;
	}
}
