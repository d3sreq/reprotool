package reprotool.ide.views.sentenceanalysis;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import reprotool.model.linguistic.action.Action;
import reprotool.model.linguistic.action.ActionFactory;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.linguistic.action.Receive;
import reprotool.model.linguistic.action.Send;
import reprotool.model.linguistic.action.TerminateBranch;
import reprotool.model.linguistic.action.TerminateUseCase;
import reprotool.model.linguistic.action.Unknown;
import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.linguistic.actionpart.ActionPart;
import reprotool.model.linguistic.actionpart.Text;
import reprotool.model.procases.InternalAction;
import reprotool.model.usecase.UseCaseStep;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.LabelProvider;

/**
 * Enables user to set details of the use case step (action).
 * 
 * @author jvinarek
 * 
 */
public class SentenceAnalysisView extends ViewPart implements ISelectionListener {
	private DataBindingContext m_bindingContext;

	public static final String ID = "reprotool.ide.views.sentenceanalysis.SentenceAnalysisView"; //$NON-NLS-1$

	private BoxContainer boxContainer;

	private SelectedUseCaseStepWrapper wrapper = new SelectedUseCaseStepWrapper();

	private ISelectionListener listener = new ISelectionListener() {
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			if (!(selection instanceof IStructuredSelection)) {
				return;
			}

			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			Object object = structuredSelection.getFirstElement();
			if (object instanceof UseCaseStep) {
				wrapper.setUseCaseStep((UseCaseStep) object);
//				boxContainer.getActionTypeBox().getComboViewer().setSelection(new StructuredSelection(EComboActionType.INTERNAL));
			}
		}
	};

	public SentenceAnalysisView() {
		// TODO - test
		// SoftwareProject softwareProject =
		// SwprojFactory.eINSTANCE.createSoftwareProject();
		//
		// Actor actor1 = SwprojFactory.eINSTANCE.createActor();
		// actor1.setName("Bob");
		// softwareProject.getActors().add(actor1);
		//
		// UseCase useCase = UsecaseFactory.eINSTANCE.createUseCase();
		// softwareProject.getUseCases().add(useCase);
		//
		// Scenario scenario = UsecaseFactory.eINSTANCE.createScenario();
		// useCase.setMainScenario(scenario);
		//
		// useCaseStep = UsecaseFactory.eINSTANCE.createUseCaseStep();
		// scenario.getSteps().add(useCaseStep);
		//
		// useCaseStep.setAction(ActionFactory.eINSTANCE.createSend());
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			boxContainer = new BoxContainer(parent, SWT.NONE);
		}

		createActions();
		initializeToolBar();
		initializeMenu();

		getSite().getPage().addSelectionListener(listener);

		// getSite().getPage().addSelectionListener(this);
		// TODO
		// selection =
		// ViewersObservables.observeSingleSelection(getSite().getSelectionProvider());
		m_bindingContext = initDataBindings();

		// TODO
		// ArrayContentProvider arrayContentProvider = new
		// ArrayContentProvider();

		ComboViewer comboViewer = getBoxContainer().getActionTypeBox().getComboViewer();
		comboViewer.setContentProvider(ArrayContentProvider.getInstance());
		comboViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				// TODO jvinarek - allow null in combobox ?
				if (element == null) {
					return "";
				}

				EComboActionType actionType = (EComboActionType) element;
				return actionType.getName();
			}
		});
		comboViewer.setInput(EComboActionType.values());
		comboViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) event.getSelection();
				EComboActionType actionType = (EComboActionType) selection.getFirstElement();
				changeUseCaseStepAction(actionType);
				boxContainer.pack();
			}
		});

		// TODO - jvinarek - enable editor specific selection listener
		// getSite().getPage().addSelectionListener("cz.cuni.mff.reprotool.ide.UseCaseEmfEditor",
		// this);

	}

	public void dispose() {
		getSite().getPage().removeSelectionListener(listener);
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection.isEmpty() || !(selection instanceof IStructuredSelection)) {
			return;
		}

		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object object = structuredSelection.getFirstElement();

		// TODO - jvinarek - make view empty ?
		if (!(object instanceof UseCaseStep)) {
			return;
		}

		// TODO - jvinarek - test
		// useCaseStep = (UseCaseStep)object;
	}

	public BoxContainer getBoxContainer() {
		return boxContainer;
	}

	private void changeUseCaseStepAction(EComboActionType actionType) {
		// TODO - jvinarek - allow null action ?
		if (actionType != null) {
			Action newAction = actionType.createAction();
			// this.useCaseStep.setAction(newAction);
		}
	}

	// private SoftwareProject getSoftwareProject() {
	// // TODO - jvinarek - move, get UseCase also from extensions
	// Scenario scenario = (Scenario) useCaseStep.eContainer();
	// UseCase useCase = (UseCase) scenario.eContainer();
	// SoftwareProject softwareProject = (SoftwareProject)useCase.eContainer();
	// return softwareProject;
	// }

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		// IToolBarManager toolbarManager =
		// getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		// IMenuManager menuManager =
		// getViewSite().getActionBars().getMenuManager();
	}

	private enum EComboActionType {
		SEND {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createSend();
			}

			@Override
			String getName() {
				return "Send";
			}
		},
		RECEIVE {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createReceive();
			}

			@Override
			String getName() {
				return "Receive";
			}
		},
		INTERNAL {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createInternal();
			}

			@Override
			String getName() {
				return "Internal";
			}
		},
		GOTO {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createGoto();
			}

			@Override
			String getName() {
				return "Goto";
			}
		},
		USE_CASE_INCLUDE {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createUseCaseInclude();
			}

			@Override
			String getName() {
				return "Use case include";
			}
		},
		TERMINATE_USE_CASE {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createTerminateUseCase();
			}

			@Override
			String getName() {
				return "Terminate use case";
			}
		},
		TERMINATE_BRANCH {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createTerminateBranch();
			}

			@Override
			String getName() {
				return "Terminate branch";
			}
		},
		UNKNOWN {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createUnknown();
			}

			@Override
			String getName() {
				return "Unknown";
			}
		};

		static EComboActionType createEnum(Action action) {
			if (action instanceof Send) {
				return SEND;
			} else if (action instanceof Receive) {
				return RECEIVE;
			} else if (action instanceof InternalAction) {
				return INTERNAL;
			} else if (action instanceof Goto) {
				return GOTO;
			} else if (action instanceof UseCaseInclude) {
				return USE_CASE_INCLUDE;
			} else if (action instanceof TerminateUseCase) {
				return TERMINATE_USE_CASE;
			} else if (action instanceof TerminateBranch) {
				return TERMINATE_BRANCH;
			} else if (action instanceof Unknown) {
				return UNKNOWN;
			}
			return null;
		}

		abstract Action createAction();

		abstract String getName();
	}

	public static class BoxVisibleConverter extends Converter {

		private String referenceName;

		// public BoxVisibleConverter() {
		// super(Action.class, Boolean.class);
		// }

		public BoxVisibleConverter(String referenceName) {
			super(Action.class, Boolean.class);
			this.referenceName = referenceName;
		}

		@Override
		public Object convert(Object fromObject) {
			Action action = (Action) fromObject;

			for (EReference reference : action.eClass().getEReferences()) {
				if (reference.getName().equals(referenceName)) {
					return true;
				}
			}
			return false;
		}
	}

	public static class MarkedTextConverter extends Converter {

		private String referenceName;

		public MarkedTextConverter() {
			super(Action.class, String.class);
		}

		public MarkedTextConverter(String referenceName) {
			super(Action.class, String.class);
			this.referenceName = referenceName;
		}

		@Override
		public Object convert(Object fromObject) {
			Action action = (Action) fromObject;

			EReference namedReference = null;
			for (EReference reference : action.eClass().getEReferences()) {
				if (reference.getName().equals(referenceName)) {
					namedReference = reference;
					break;
				}
			}

			if (namedReference == null || namedReference.eContents().isEmpty()) {
				return "";
			}

			ActionPart actionPart = (ActionPart) namedReference.eContents().get(0);
			Text text = actionPart.getText();

			return text == null ? "" : text.getContent();
		}
	}

	public static class NullConverter extends Converter {

		public NullConverter() {
			super(UseCaseStep.class, EComboActionType.class);
		}

		@Override
		public Object convert(Object fromObject) {
			if (fromObject == null) {
				return null;
			}
			UseCaseStep step = (UseCaseStep) fromObject;
			if (step.getAction() == null) {
				return null;
			}

			return EComboActionType.createEnum(step.getAction());
		}

	}

	public static class SelectedUseCaseStepWrapper implements PropertyChangeListener {

		private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
		private UseCaseStep useCaseStep;

		public UseCaseStep getUseCaseStep() {
			return useCaseStep;
		}

		public void setUseCaseStep(UseCaseStep useCaseStep) {
			propertyChangeSupport.firePropertyChange("useCaseStep", this.useCaseStep, this.useCaseStep = useCaseStep);
		}

		@Override
		public void propertyChange(PropertyChangeEvent arg0) {
		}

		public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
			propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
		}

		public void removePropertyChangeListener(PropertyChangeListener listener) {
			propertyChangeSupport.removePropertyChangeListener(listener);
		}
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue comboViewerObserveSingleSelection = ViewersObservables.observeSingleSelection(boxContainer.getActionTypeBox().getComboViewer());
		IObservableValue wrapperUseCaseStepObserveValue = BeansObservables.observeValue(wrapper, "useCaseStep");
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setConverter(new NullConverter());
		bindingContext.bindValue(comboViewerObserveSingleSelection, wrapperUseCaseStepObserveValue, null, strategy);
		//
		return bindingContext;
	}
}
