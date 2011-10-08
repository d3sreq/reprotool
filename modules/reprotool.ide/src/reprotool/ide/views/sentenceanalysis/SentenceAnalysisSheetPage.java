package reprotool.ide.views.sentenceanalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditListProperty;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;

import reprotool.model.linguistic.action.Action;
import reprotool.model.linguistic.action.ActionFactory;
import reprotool.model.linguistic.action.ActionPackage;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.linguistic.action.Internal;
import reprotool.model.linguistic.action.Unknown;
import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.linguistic.actionpart.ActionpartPackage;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

/**
 * @author jvinarek
 *
 */
public class SentenceAnalysisSheetPage extends Page implements ISentenceAnalysisSheetPage {

	private BoxContainer boxContainer;
	private WritableValue writableValue = new WritableValue();
	private IWorkbenchPart sourcePart;
	
	private DataBindingContext m_bindingContext;
	
	private AdapterFactoryEditingDomain editingDomain;
	
	
	/**
	 * Create the PageBookView Page.
	 */
	public SentenceAnalysisSheetPage(AdapterFactoryEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	protected DataBindingContext initDataBindings(AdapterFactoryEditingDomain editingDomain) {
		bindActionTypeCombo();
		
		DataBindingContext bindingContext = new DataBindingContext();
		//
		// binds value to action box combo
		IEMFValueProperty mProp = EMFEditProperties.value(editingDomain, UsecasePackage.Literals.USE_CASE_STEP__ACTION);
		IObservableValue emfValue = mProp.observeDetail(writableValue);
		IObservableValue comboValue = ViewersObservables.observeSingleSelection(boxContainer.getActionTypeBox().getComboViewer());
//		emfValue.addValueChangeListener(new IValueChangeListener() {
//			
//			@Override
//			public void handleValueChange(ValueChangeEvent event) {
//				
//			}
//		});
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		// TODO - add validator to repaint view ?
		strategy.setConverter(new ComboToActionConverter());
		UpdateValueStrategy strategy_1 = new UpdateValueStrategy();
		strategy_1.setConverter(new ActionToComboConverter());
		bindingContext.bindValue(comboValue, emfValue, strategy, strategy_1);
	
		//
		// binds value to visibility of the action boxes	
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getSubjectBox(), "subject");
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getVerbBox(), "verb");
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getDirectObjectBox(), "representativeObject");
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getIndirectObjectBox(), "indirectObject");
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getGotoUseCaseStepBox(), "gotoTarget");
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getIncludeUseCaseBox(), "include");
		
		// bind marked text
		// FIXME jvinarek
//		bindMarkedText(bindingContext, boxContainer.getSubjectBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.SEND__SUBJECT, ActionPackage.Literals.RECEIVE__SUBJECT});
//		bindMarkedText(bindingContext, boxContainer.getVerbBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.SEND__VERB, ActionPackage.Literals.RECEIVE__VERB, ActionPackage.Literals.INTERNAL__VERB});
//		bindMarkedText(bindingContext, boxContainer.getDirectObjectBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.SEND__REPRESENTATIVE_OBJECT, ActionPackage.Literals.RECEIVE__REPRESENTATIVE_OBJECT, ActionPackage.Literals.INTERNAL__REPRESENTATIVE_OBJECT});
//		bindMarkedText(bindingContext, boxContainer.getIndirectObjectBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.SEND__INDIRECT_OBJECT});
//		bindMarkedText(bindingContext, boxContainer.getGotoUseCaseStepBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.GOTO__GOTO_TARGET});
//		bindMarkedText(bindingContext, boxContainer.getIncludeUseCaseBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.USE_CASE_INCLUDE__INCLUDE});
		
		// bind actors to the combo boxes - create combo boxes content
		bindActorsContentToCombo(bindingContext, boxContainer.getSubjectBox().getComboViewer());
		bindActorsContentToCombo(bindingContext, boxContainer.getDirectObjectBox().getComboViewer());
		bindActorsContentToCombo(bindingContext, boxContainer.getIndirectObjectBox().getComboViewer());
		
		return bindingContext;
	}
	
	private void bindActorsContentToCombo(DataBindingContext bindingContext, ComboViewer comboViewer) {
		IObservableList comboList = WidgetProperties.items().observe(comboViewer.getCombo());
		
		// FIXME jvinarek
//		IEMFEditListProperty emfProperty = EMFEditProperties.list(editingDomain, 
//				FeaturePath.fromList(
//						UsecasePackage.Literals.USE_CASE_STEP__SOFTWARE_PROJECT, 
//						SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS						 
//				)).values(SwprojPackage.Literals.ACTOR__NAME);
//		IObservableList emfList = emfProperty.observeDetail(writableValue);
//		bindingContext.bindList(comboList, emfList);
	}

	private void bindActionTypeCombo() {
		ComboViewer comboViewer = boxContainer.getActionTypeBox().getComboViewer();
		List<EComboActionType> list = new ArrayList<EComboActionType>(Arrays.asList(EComboActionType.values()));
		WritableList input = new WritableList(list, EComboActionType.class);
		ViewerSupport.bind(comboViewer, input, PojoProperties.value("name"));
	}

//	private List<Actor> getActorList() {
//		Object value = writableValue.getValue();
//		
//		if (value == null) {
//			return new ArrayList<Actor>();
//		}
//		
//		UseCaseStep useCaseStep = (UseCaseStep)value;
//		
//		Scenario scenario;
//		while (true) {
//			scenario = (Scenario)useCaseStep.eContainer();
//			if (scenario == null) {
//				return new ArrayList<Actor>();
//			}
//			
//			EObject container = scenario.eContainer();
//			if (container == null) {
//				return new ArrayList<Actor>();
//			}
//			
//			if (container instanceof UseCase) {
//				break;
//			} else { // container instanceof Guard
//				Guard guard = (Guard)container;
//				useCaseStep = (UseCaseStep)guard.eContainer();
//			}
//		}
//		
//		UseCase useCase = (UseCase)useCaseStep.eContainer();
//		if (useCase == null) {
//			return new ArrayList<Actor>();
//		}
//		
//		SoftwareProject softwareProject = (SoftwareProject)useCase.eContainer();
//		if (softwareProject == null) {
//			return new ArrayList<Actor>();
//		}
//		
//		return softwareProject.getActors();
//		
////		Actor actor1 = SwprojFactory.eINSTANCE.createActor();
////		actor1.setName("John");
////		List<Actor> list = new ArrayList<Actor>();
////		list.add(actor1);
////		return list;
//	}
	
	private void bindMarkedText(DataBindingContext bindingContext, Label lblMarkedText, EReference[] eReferences) {
		IObservableValue widgetObservableValue = SWTObservables.observeText(lblMarkedText);
		
		final IObservableValue[] emfObservableValues = new IObservableValue[eReferences.length];
		for (int i = 0; i < eReferences.length; i++) {
			IEMFEditValueProperty property = EMFEditProperties.value(editingDomain, 
					FeaturePath.fromList(
							UsecasePackage.Literals.USE_CASE_STEP__ACTION, 
							eReferences[i], 
							ActionpartPackage.Literals.ACTION_PART__TEXT, 
							ActionpartPackage.Literals.TEXT__CONTENT
					));		
			emfObservableValues[i] = property.observeDetail(writableValue);
		}
		
		IObservableValue emfCompoundObservableValue = new ComputedValue() {
			
			@Override
			protected Object calculate() {
				for (IObservableValue observableValue : emfObservableValues) {
					Object value = observableValue.getValue();
					if (value != null) {
						return value;
					}
				}

				return null;
			}
		};
		// this is strange but it works
		// emfCompoundObservableValue and widgetObservableValue should be in reverse order
		bindingContext.bindValue(emfCompoundObservableValue, widgetObservableValue, new UpdateValueStrategy(), new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER));		
	}

	private void bindBoxVisibility(DataBindingContext bindingContext, IObservableValue valueActionObserveDetailValue, Composite box, String referenceName) {
		IObservableValue boxContainergetSubjectBoxObserveVisibleObserveWidget = SWTObservables.observeVisible(box);
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setConverter(new BoxVisibleConverter(referenceName));
		bindingContext.bindValue(boxContainergetSubjectBoxObserveVisibleObserveWidget, valueActionObserveDetailValue, null, strategy);
	}
	
	/**
	 * Create contents of the PageBookView Page.
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		{
			boxContainer = new BoxContainer(parent, SWT.NONE);
		}
		
		getSite().getPage().addSelectionListener(this);
		
		// TODO jvinarek
		if (editingDomain != null) {
			m_bindingContext = initDataBindings(editingDomain);
		}
	}
	
	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
	}

	@Override
	public Control getControl() {
		return boxContainer;
	}

	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}

		IStructuredSelection structuredSelection = (IStructuredSelection) selection;

		Object object = structuredSelection.getFirstElement();
		if (object instanceof UseCaseStep) {
			UseCaseStep useCaseStep = (UseCaseStep)object; 
			writableValue.setValue(useCaseStep);
		}
	}

	protected ISaveablePart getSaveablePart() {
		return null;
	}
	
	public static class ComboToActionConverter extends Converter {

		public ComboToActionConverter() {
			super(EComboActionType.class, Action.class);
		}

		@Override
		public Object convert(Object fromObject) {
			if (fromObject == null) {
				return null;
			}
			EComboActionType comboActionType = (EComboActionType)fromObject;
			return comboActionType.createAction();
		}

	}
	
	public static class ActionToComboConverter extends Converter {

		public ActionToComboConverter() {
			super(Action.class, EComboActionType.class);
		}

		@Override
		public Object convert(Object fromObject) {
			if (fromObject == null) {
				return null;
			}
			Action action = (Action) fromObject;			
			return EComboActionType.createEnum(action);
		}

	}
	
	public static class BoxVisibleConverter extends Converter {

		private String referenceName;

//		 public BoxVisibleConverter() {
//		 super(Action.class, Boolean.class);
//		 }

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
	
//	public static class MarkedTextConverter extends Converter {
//
//		private String referenceName;
//
//		public MarkedTextConverter() {
//			super(Action.class, String.class);
//		}
//
//		public MarkedTextConverter(String referenceName) {
//			super(Action.class, String.class);
//			this.referenceName = referenceName;
//		}
//
//		@Override
//		public Object convert(Object fromObject) {
//			Action action = (Action) fromObject;
//
//			EReference namedReference = null;
//			for (EReference reference : action.eClass().getEReferences()) {
//				if (reference.getName().equals(referenceName)) {
//					namedReference = reference;
//					break;
//				}
//			}
//
//			if (namedReference == null || namedReference.eContents().isEmpty()) {
//				return "";
//			}
//
//			ActionPart actionPart = (ActionPart) namedReference.eContents().get(0);
//			Text text = actionPart.getText();
//
//			return text == null ? "" : text.getContent();
//		}
//	}
	
	private enum EComboActionType {
		SEND {
			@Override
			Action createAction() {
				// FIXME jvinarek
				return null;
				//return ActionFactory.eINSTANCE.createSend();
			}

			@Override
			public String getName() {
				return "Send";
			}
		},
		RECEIVE {
			@Override
			Action createAction() {
				// FIXME jvinarek
				return null;
//				return ActionFactory.eINSTANCE.createReceive();
			}

			@Override
			public String getName() {
				return "Receive";
			}
		},
		INTERNAL {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createInternal();
			}

			@Override
			public String getName() {
				return "Internal";
			}
		},
		GOTO {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createGoto();
			}

			@Override
			public String getName() {
				return "Goto";
			}
		},
		USE_CASE_INCLUDE {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createUseCaseInclude();
			}

			@Override
			public String getName() {
				return "Use case include";
			}
		},
		TERMINATE_USE_CASE {
			@Override
			Action createAction() {
				// FIXME jvinarek
				return null;
//				return ActionFactory.eINSTANCE.createTerminateUseCase();
			}

			@Override
			public String getName() {
				return "Terminate use case";
			}
		},
		TERMINATE_BRANCH {
			@Override
			Action createAction() {
				// FIXME jvinarek
				return null;
//				return ActionFactory.eINSTANCE.createTerminateBranch();
			}

			@Override
			public String getName() {
				return "Terminate branch";
			}
		},
		UNKNOWN {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createUnknown();
			}

			@Override
			public String getName() {
				return "Unknown";
			}
		};

		static EComboActionType createEnum(Action action) {
			// FIXME jvinarek
//			if (action instanceof Send) {
//				return SEND;
//			} else if (action instanceof Receive) {
//				return RECEIVE;
//			} else if (action instanceof Internal) {
//				return INTERNAL;
//			} else if (action instanceof Goto) {
//				return GOTO;
//			} else if (action instanceof UseCaseInclude) {
//				return USE_CASE_INCLUDE;
//			} else if (action instanceof TerminateUseCase) {
//				return TERMINATE_USE_CASE;
//			} else if (action instanceof TerminateBranch) {
//				return TERMINATE_BRANCH;
//			} else if (action instanceof Unknown) {
//				return UNKNOWN;
//			}
			return null;
		}

		abstract Action createAction();

		public abstract String getName();
	}

}
