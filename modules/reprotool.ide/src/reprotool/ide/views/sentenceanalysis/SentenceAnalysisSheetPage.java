package reprotool.ide.views.sentenceanalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
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
		DataBindingContext bindingContext = new DataBindingContext();
		
		IEMFValueProperty mProp = EMFEditProperties.value(editingDomain, UsecasePackage.Literals.USE_CASE_STEP__ACTION);
		IObservableValue emfValue = mProp.observeDetail(writableValue);

		// action type combobox
		bindActionTypeList();
		bindActionSelection(bindingContext, emfValue);
		
		// sender
		// @formatter:off
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getSenderBox(), "sender");
		bindMarkedText(bindingContext, 
				boxContainer.getSenderBox().getLblMarkedText(),
				FeaturePath.fromList(
					UsecasePackage.Literals.USE_CASE_STEP__ACTION, 
					ActionPackage.Literals.TO_SYSTEM__SENDER, 
					ActionpartPackage.Literals.ACTION_PART__TEXT, 
					ActionpartPackage.Literals.TEXT_RANGE__CONTENT
				)				
		);
		bindActorList(bindingContext, boxContainer.getSenderBox().getComboViewer());
		bindComboSelection(bindingContext, 
				boxContainer.getSenderBox().getComboViewer(), 
				FeaturePath.fromList(new EReference[] {
					UsecasePackage.Literals.USE_CASE_STEP__ACTION, 
					ActionPackage.Literals.TO_SYSTEM__SENDER, 
					ActionpartPackage.Literals.SENTENCE_ACTOR__ACTOR
				} 
		));
		// @formatter:on
		
		// activity (verb)
		// TODO - jvinarek - discuss and repair "activity" box
//		bindBoxVisibility(bindingContext, emfValue, boxContainer.getActivityBox(), "verb");
//		boxContainer.getActivityBox().setVisibleAndInclude(false);
//		bindMarkedText(bindingContext, boxContainer.getVerbBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.SEND__VERB, ActionPackage.Literals.RECEIVE__VERB, ActionPackage.Literals.INTERNAL__VERB});
		
		// receiver
		// @formatter:off
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getReceiverBox(), "receiver");
		bindActorList(bindingContext, boxContainer.getReceiverBox().getComboViewer());
		bindMarkedText(bindingContext, 
				boxContainer.getReceiverBox().getLblMarkedText(),
				FeaturePath.fromList(
					UsecasePackage.Literals.USE_CASE_STEP__ACTION, 
					ActionPackage.Literals.FROM_SYSTEM__RECEIVER, 
					ActionpartPackage.Literals.ACTION_PART__TEXT, 
					ActionpartPackage.Literals.TEXT_RANGE__CONTENT
				)
		);
		bindComboSelection(bindingContext, 
				boxContainer.getReceiverBox().getComboViewer(), 
				FeaturePath.fromList(new EReference[] {
					UsecasePackage.Literals.USE_CASE_STEP__ACTION, 
					ActionPackage.Literals.FROM_SYSTEM__RECEIVER, 
					ActionpartPackage.Literals.SENTENCE_ACTOR__ACTOR
				} 
		));
		// @formatter:on
		
		// action param
		// TODO - jvinarek - discuss and repair "action param" box
//		bindBoxVisibility(bindingContext, emfValue, boxContainer.getReceiverBox(), "actionParam");
//		boxContainer.getActionParamBox().setVisibleAndInclude(false);
		// TODO - jvinarek - multiple values allowed in action param
//		bindActorsContentToCombo(bindingContext, boxContainer.getActionParamBox().getComboViewer());
//		bindMarkedText(bindingContext, boxContainer.getActionParamBox().getLblMarkedText(), new EReference[] {ActionPackage.Literals.COMMUNICATION__ACTION_PARAM});
		
		// goto
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getGotoUseCaseStepBox(), "gotoTarget");
		// bind goto
		// TODO - jvinarek - filter out selected use case step ?
		bindGotoList(bindingContext);
		// @formatter:off
		bindMarkedText(bindingContext,
				boxContainer.getGotoUseCaseStepBox().getLblMarkedText(), 
				FeaturePath.fromList(
					UsecasePackage.Literals.USE_CASE_STEP__ACTION, 
					ActionpartPackage.Literals.ACTION_PART__TEXT, 
					ActionpartPackage.Literals.TEXT_RANGE__CONTENT
				)
		);		
		bindComboSelection(bindingContext, 
				boxContainer.getGotoUseCaseStepBox().getComboViewer(), 
				FeaturePath.fromList(new EReference[] {
					UsecasePackage.Literals.USE_CASE_STEP__ACTION, 
					ActionPackage.Literals.GOTO__GOTO_TARGET
				} 
		));
		// @formatter:on
		
		// use case include
		bindBoxVisibility(bindingContext, emfValue, boxContainer.getIncludeUseCaseBox(), "includeTarget");
		// TODO - jvinarek - filter out selected use case step ?
		bindIncludeUseCaseList(bindingContext);
		// @formatter:off
		bindMarkedText(bindingContext, 
				boxContainer.getIncludeUseCaseBox().getLblMarkedText(), 
				FeaturePath.fromList(
					UsecasePackage.Literals.USE_CASE_STEP__ACTION, 
					ActionpartPackage.Literals.ACTION_PART__TEXT, 
					ActionpartPackage.Literals.TEXT_RANGE__CONTENT
				)
		);
		bindComboSelection(bindingContext, 
				boxContainer.getIncludeUseCaseBox().getComboViewer(), 
				FeaturePath.fromList(new EReference[] {
					UsecasePackage.Literals.USE_CASE_STEP__ACTION, 
					ActionPackage.Literals.USE_CASE_INCLUDE__INCLUDE_TARGET
				} 
		));
		// @formatter:on
		
		return bindingContext;
	}

	private void bindActionSelection(DataBindingContext bindingContext, IObservableValue emfValue) {
		//
		// binds value to action box combo
		IObservableValue comboValue = ViewersObservables.observeSingleSelection(boxContainer.getActionTypeBox().getComboViewer());

		UpdateValueStrategy comboToEmfStrategy = new UpdateValueStrategy();
		comboToEmfStrategy.setConverter(new ComboToActionConverter());
		UpdateValueStrategy emfToComboStrategy = new UpdateValueStrategy();
		emfToComboStrategy.setConverter(new ActionToComboConverter());

		bindingContext.bindValue(comboValue, emfValue, comboToEmfStrategy, emfToComboStrategy);
	}

	/**
	 * Fills given combobox with actors found in project. 
	 * 
	 * @param bindingContext
	 * @param comboViewer
	 */
	private void bindActorList(DataBindingContext bindingContext, ComboViewer comboViewer) {
		FeaturePath featurePath = FeaturePath.fromList(
				UsecasePackage.Literals.USE_CASE_STEP__SOFTWARE_PROJECT_SHORTCUT, 
				SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS						 
		);
		EStructuralFeature detailValue = SwprojPackage.Literals.DOMAIN_ELEMENT__NAME;

		bindComboListCommon(bindingContext, comboViewer, featurePath, detailValue);
	}

	private void bindGotoList(DataBindingContext bindingContext) {
		// @formatter:off
		FeaturePath featurePath = FeaturePath.fromList(
				UsecasePackage.Literals.USE_CASE_STEP__USE_CASE_SHORTCUT, 
				UsecasePackage.Literals.USE_CASE__ALL_USE_CASE_STEPS_SHORTCUT						 
		);
		// @formatter:on
		ComboViewer comboViewer = boxContainer.getGotoUseCaseStepBox().getComboViewer();
		EStructuralFeature detailValue = UsecasePackage.Literals.LABELLED_ELEMENT__LABEL;

		bindComboListCommon(bindingContext, comboViewer, featurePath, detailValue);
	}
	
	private void bindIncludeUseCaseList(DataBindingContext bindingContext) {
		// @formatter:off
		FeaturePath featurePath = FeaturePath.fromList(
				UsecasePackage.Literals.USE_CASE_STEP__SOFTWARE_PROJECT_SHORTCUT, 
				SwprojPackage.Literals.SOFTWARE_PROJECT__USE_CASES						 
		);
		// @formatter:on
		ComboViewer comboViewer = boxContainer.getIncludeUseCaseBox().getComboViewer();
		EStructuralFeature detailValue = UsecasePackage.Literals.USE_CASE__NAME;

		bindComboListCommon(bindingContext, comboViewer, featurePath, detailValue);
	}

	private void bindComboListCommon(DataBindingContext bindingContext, ComboViewer comboViewer, FeaturePath featurePath, EStructuralFeature detailValue) {
		IObservableList emfList = EMFEditProperties.list(editingDomain, featurePath).observeDetail(writableValue);
		IEMFValueProperty labelProperty = EMFEditProperties.value(editingDomain, detailValue);
		ViewerSupport.bind(comboViewer, emfList, labelProperty);
	}
	
	private void bindComboSelection(DataBindingContext bindingContext, ComboViewer comboViewer, FeaturePath featurePath) {
		IObservableValue comboSelectionValue = ViewersObservables.observeSingleSelection(comboViewer);
		IObservableValue emfValue = EMFEditProperties.value(editingDomain, featurePath).observeDetail(writableValue);
		bindingContext.bindValue(comboSelectionValue, emfValue);
	}

	/**
	 * Fills combobox with values of the {@link EComboActionType}.
	 */
	private void bindActionTypeList() {
		ComboViewer comboViewer = boxContainer.getActionTypeBox().getComboViewer();
		List<EComboActionType> list = new ArrayList<EComboActionType>(Arrays.asList(EComboActionType.values()));
		WritableList input = new WritableList(list, EComboActionType.class);
		ViewerSupport.bind(comboViewer, input, PojoProperties.value("name"));
	}
	
	
	private void bindMarkedText(DataBindingContext bindingContext, Label lblMarkedText, FeaturePath featurePath) {
		IObservableValue widgetValue = SWTObservables.observeText(lblMarkedText);
		IObservableValue emfValue = EMFEditProperties.value(editingDomain, featurePath).observeDetail(writableValue);
		bindingContext.bindValue(emfValue, widgetValue);
	}

	/**
	 * Binds visibility of the box to the given emfValue which is converted to boolean.  
	 * 
	 * @param bindingContext
	 * @param emfValue
	 * @param box
	 * @param referenceName
	 */
	private void bindBoxVisibility(DataBindingContext bindingContext, IObservableValue emfValue, Composite box, String referenceName) {
		IObservableValue widgetValue = PojoProperties.value("visibleAndInclude").observe(box);
		UpdateValueStrategy strategy = new UpdateValueStrategy();
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
		
		// TODO jvinarek - can be editingDomain null ?
		if (editingDomain != null) {
			m_bindingContext = initDataBindings();
		}
		
		boxContainer.getActionTypeBox().getComboViewer().addPostSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// some of the boxes are hidden after selection
				// call is needed to recompute layout.
				SentenceAnalysisSheetPage.this.boxContainer.layout();
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
			
			boxContainer.layout();
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
