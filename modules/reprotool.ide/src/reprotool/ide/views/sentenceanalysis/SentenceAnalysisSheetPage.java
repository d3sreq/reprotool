package reprotool.ide.views.sentenceanalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;

import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.Action;
import reprotool.model.linguistic.action.ActionFactory;
import reprotool.model.linguistic.action.ActionPackage;
import reprotool.model.linguistic.action.FromSystem;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.linguistic.action.InternalAction;
import reprotool.model.linguistic.action.ToSystem;
import reprotool.model.linguistic.action.Unknown;
import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.linguistic.actionpart.ActionpartPackage;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

/**
 * @author jvinarek
 *
 */
public class SentenceAnalysisSheetPage extends Page implements ISentenceAnalysisSheetPage {

	private BoxContainer boxContainer;
	private WritableValue writableValue = new WritableValue();
	
	// TODO jvinarek - remove ?
	private DataBindingContext m_bindingContext;
	
	private AdapterFactoryEditingDomain editingDomain;
	
	
	/**
	 * Create the PageBookView Page.
	 */
	public SentenceAnalysisSheetPage(AdapterFactoryEditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	protected DataBindingContext initDataBindings() {
		// fill combobox with values
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
		UpdateValueStrategy comboToEmfStrategy = new UpdateValueStrategy();
		// TODO - add validator to repaint view ?
		comboToEmfStrategy.setConverter(new ComboToActionConverter());
		UpdateValueStrategy emfToComboStrategy = new UpdateValueStrategy();
		emfToComboStrategy.setConverter(new ActionToComboConverter());
		bindingContext.bindValue(comboValue, emfValue, comboToEmfStrategy, emfToComboStrategy);
		
		//
		// binds value to visibility of the action boxes	
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getSenderBox(), "sender");
		// TODO - jvinarek - discuss and repair "activity" box
//		bindBoxVisibility(bindingContext, emfValue, boxContainer.getActivityBox(), "verb");
		boxContainer.getActivityBox().setVisible(false);
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getReceiverBox(), "receiver");
		// TODO - jvinarek - discuss and repair "action param" box
//		bindBoxVisibility(bindingContext, emfValue, boxContainer.getReceiverBox(), "actionParam");
		boxContainer.getActionParamBox().setVisible(false);
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getGotoUseCaseStepBox(), "gotoTarget");
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getIncludeUseCaseBox(), "includeTarget");
		
		// bind marked text
		// FIXME jvinarek
		bindMarkedText(bindingContext, boxContainer.getSenderBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.TO_SYSTEM__SENDER});
		// TODO - jvinarek - discuss and repair "activity" box
//		bindMarkedText(bindingContext, boxContainer.getVerbBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.SEND__VERB, ActionPackage.Literals.RECEIVE__VERB, ActionPackage.Literals.INTERNAL__VERB});
		bindMarkedText(bindingContext, boxContainer.getReceiverBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.FROM_SYSTEM__RECEIVER});
		// TODO - jvinarek - multiple values allowed in action param
//		bindMarkedText(bindingContext, boxContainer.getActionParamBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.COMMUNICATION__ACTION_PARAM});
		bindMarkedText(bindingContext, boxContainer.getGotoUseCaseStepBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.GOTO__GOTO_TARGET});
		bindMarkedText(bindingContext, boxContainer.getIncludeUseCaseBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.USE_CASE_INCLUDE__INCLUDE_TARGET});
		
		// bind actors to the combo boxes - create combo boxes content
		bindActorsContentToCombo(bindingContext, boxContainer.getSenderBox().getComboViewer());
		// TODO - jvinarek - multiple values allowed in action param
//		bindActorsContentToCombo(bindingContext, boxContainer.getActionParamBox().getComboViewer());
		bindActorsContentToCombo(bindingContext, boxContainer.getReceiverBox().getComboViewer());
		
		// bind comboboxes selection
		
		
		return bindingContext;
	}
	
	/**
	 * Fills given combobox with actors found in project. 
	 * 
	 * @param bindingContext
	 * @param comboViewer
	 */
	private void bindActorsContentToCombo(DataBindingContext bindingContext, ComboViewer comboViewer) {
		IObservableList comboList = WidgetProperties.items().observe(comboViewer.getCombo());
		IEMFEditListProperty emfProperty = EMFEditProperties.list(editingDomain, 
				FeaturePath.fromList(
						UsecasePackage.Literals.USE_CASE_STEP__SOFTWARE_PROJECT, 
						SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS						 
				)).values(SwprojPackage.Literals.DOMAIN_ELEMENT__NAME);
		IObservableList emfList = emfProperty.observeDetail(writableValue);
		bindingContext.bindList(comboList, emfList);
	}

	/**
	 * Fills combobox with values of the {@link EComboActionType}.
	 */
	private void bindActionTypeCombo() {
		ComboViewer comboViewer = boxContainer.getActionTypeBox().getComboViewer();
		List<EComboActionType> list = new ArrayList<EComboActionType>(Arrays.asList(EComboActionType.values()));
		WritableList input = new WritableList(list, EComboActionType.class);
		ViewerSupport.bind(comboViewer, input, PojoProperties.value("name"));
	}
	
	/**
	 * Binds multiple features pointing to the same class to the given widget observable.
	 * Only one feature-path is expected to be active.
	 * 
	 * @param bindingContext
	 * @param lblMarkedText
	 * @param eReferences
	 */
	private void bindMarkedText(DataBindingContext bindingContext, Label lblMarkedText, EReference[] eReferences) {
		IObservableValue widgetObservableValue = SWTObservables.observeText(lblMarkedText);
		
		final IObservableValue[] emfObservableValues = new IObservableValue[eReferences.length];
		for (int i = 0; i < eReferences.length; i++) {
			IEMFEditValueProperty property = EMFEditProperties.value(editingDomain, 
					FeaturePath.fromList(
							UsecasePackage.Literals.USE_CASE_STEP__ACTION, 
							eReferences[i], 
							ActionpartPackage.Literals.ACTION_PART__TEXT, 
							ActionpartPackage.Literals.TEXT_RANGE__CONTENT
					));		
			emfObservableValues[i] = property.observeDetail(writableValue);
		}
		
		// computed chooses real observable value 
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

	/**
	 * Binds
	 * 
	 * @param bindingContext
	 * @param emfValue
	 * @param box
	 * @param referenceName
	 */
	private void bindBoxVisibility(DataBindingContext bindingContext, IObservableValue emfValue, Composite box, String referenceName) {
		IObservableValue widgetValue = WidgetProperties.visible().observe(box);
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		emfValue.addChangeListener(new IChangeListener() {
			
			@Override
			public void handleChange(ChangeEvent event) {
//				SentenceAnalysisSheetPage.this.boxContainer.pack(true);
//				SentenceAnalysisSheetPage.this.boxContainer.redraw();
			}
		});
		
		widgetValue.addChangeListener(new IChangeListener() {
			
			@Override
			public void handleChange(ChangeEvent event) {
//				SentenceAnalysisSheetPage.this.boxContainer.pack(true);
//				SentenceAnalysisSheetPage.this.boxContainer.redraw();
			}
		});
		
		strategy.setConverter(new BoxVisibleConverter(referenceName));
		bindingContext.bindValue(widgetValue, emfValue, null, strategy);
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
			m_bindingContext = initDataBindings();
		}
		
		boxContainer.getActionTypeBox().getComboViewer().addPostSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
//				SentenceAnalysisSheetPage.this.boxContainer.redraw();
//				SentenceAnalysisSheetPage.this.boxContainer.getGotoUseCaseStepBox().redraw();
//				SentenceAnalysisSheetPage.this.boxContainer.pack(true);
//				SentenceAnalysisSheetPage.this.boxContainer.redraw();
			}
		});
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
	
	private enum EComboActionType {
		TO_SYSTEM {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createToSystem();
			}

			@Override
			public String getName() {
				return "To system";
			}
		},
		FROM_SYSTEM {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createFromSystem();
			}

			@Override
			public String getName() {
				return "From system";
			}
		},
		INTERNAL {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createInternalAction();
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
		ABORT_USE_CASE {
			@Override
			Action createAction() {
				return ActionFactory.eINSTANCE.createAbortUseCase();
			}

			@Override
			public String getName() {
				return "Abort use case";
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
			if (action instanceof ToSystem) {
				return TO_SYSTEM;
			} else if (action instanceof FromSystem) {
				return FROM_SYSTEM;
			} else if (action instanceof InternalAction) {
				return INTERNAL;
			} else if (action instanceof Goto) {
				return GOTO;
			} else if (action instanceof UseCaseInclude) {
				return USE_CASE_INCLUDE;
			} else if (action instanceof AbortUseCase) {
				return ABORT_USE_CASE;
			} else if (action instanceof Unknown) {
				return UNKNOWN;
			}
			return null;
		}

		abstract Action createAction();

		public abstract String getName();
	}

}
