package reprotool.ide.views.sentenceanalysis.step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;

import reprotool.ide.views.sentenceanalysis.ISentenceAnalysisSheetPage;
import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.Action;
import reprotool.model.linguistic.action.ActionFactory;
import reprotool.model.linguistic.action.ActionPackage;
import reprotool.model.linguistic.action.Communication;
import reprotool.model.linguistic.action.FromSystem;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.linguistic.action.InternalAction;
import reprotool.model.linguistic.action.ToSystem;
import reprotool.model.linguistic.action.Unknown;
import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.linguistic.actionpart.ActionpartFactory;
import reprotool.model.linguistic.actionpart.ActionpartPackage;
import reprotool.model.linguistic.actionpart.TextRange;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

/**
 * Page of the sentence analysis view.
 * <p>
 * For more information about EMF databinding look at 
 * http://tomsondev.bestsolution.at/2009/06/06/galileo-improved-emf-databinding-support/
 * 
 * @author jvinarek
 *
 */
public class SentenceAnalysisSheetPage extends Page implements ISentenceAnalysisSheetPage {

	private BoxContainer boxContainer;
	private WritableValue writableValue = new WritableValue();
	
	// binding context is used by binding framework  
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;
	
	private AdapterFactoryEditingDomain editingDomain;
	private CommandStackListener commandStackListener;
	
	
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
		
		bindSender(bindingContext, emfValue);
		bindSentenceActivity(bindingContext, emfValue);
		bindReceiver(bindingContext, emfValue);
		bindGoto(bindingContext, emfValue);
		bindInclude(bindingContext, emfValue);
		bindActionParams(bindingContext, emfValue);
		
		return bindingContext;
	}

	private void bindInclude(DataBindingContext bindingContext, IObservableValue emfValue) {
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
	}

	private void bindGoto(DataBindingContext bindingContext, IObservableValue emfValue) {
//		bindBoxVisibility(bindingContext, emfValue, boxContainer.getGotoUseCaseStepBox(), "gotoTarget");
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
	}

	private void bindReceiver(DataBindingContext bindingContext, IObservableValue emfValue) {
		// @formatter:off
//		bindBoxVisibility(bindingContext, emfValue, boxContainer.getReceiverBox(), "receiver");
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
	}

	private void bindSentenceActivity(DataBindingContext bindingContext, IObservableValue emfValue) {
		// @formatter:off
//		bindBoxVisibility(bindingContext, emfValue, boxContainer.getSentenceActivityBox(), "sentenceActivity");
		bindMarkedText(bindingContext, 
				boxContainer.getSentenceActivityBox().getLblMarkedText(),
				FeaturePath.fromList(
					UsecasePackage.Literals.USE_CASE_STEP__ACTION, 
					ActionPackage.Literals.COMMUNICATION__SENTENCE_ACTIVITY, 
					ActionpartPackage.Literals.ACTION_PART__TEXT, 
					ActionpartPackage.Literals.TEXT_RANGE__CONTENT
				)
		);
		// @formatter:on
	}

	private void bindSender(DataBindingContext bindingContext, IObservableValue emfValue) {
		// @formatter:off
//		bindBoxVisibility(bindingContext, emfValue, boxContainer.getSenderBox(), "sender");
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
	}

	private void bindActionParams(DataBindingContext bindingContext, IObservableValue emfValue) {
		TableViewer tableViewer = boxContainer.getActionParamBox().getTableViewer();

		// get action from use case step
		IObservableValue actionValue = EMFEditObservables.observeDetailValue(Realm.getDefault(), editingDomain, writableValue, UsecasePackage.Literals.USE_CASE_STEP__ACTION);
		
		// FIXME - jvinarek - this is BAD! Params should be only in communication. workaround for table
		IObservableList emfList = EMFEditObservables.observeDetailList(Realm.getDefault(), editingDomain, actionValue, ActionPackage.Literals.ACTION__ACTION_PARAM);
		
		// prepare value from "SentenceActionParam" to the "Content" property of the "TextRange" 
		FeaturePath featurePathTextRangeContent = FeaturePath.fromList(new EStructuralFeature[] {
				ActionpartPackage.Literals.ACTION_PART__TEXT,
				ActionpartPackage.Literals.TEXT_RANGE__CONTENT
		});
		IEMFValueProperty textRangeProperty = EMFEditProperties.value(editingDomain, featurePathTextRangeContent);
		
		// prepare value from "SentenceActionParam" to the "Name" property of the "ConceptualObject" 
		FeaturePath featurePathConceptualObjectNames = FeaturePath.fromList(new EStructuralFeature[] {
				ActionpartPackage.Literals.SENTENCE_ACTION_PARAM__CONCEPTUAL_OBJECT,
				SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME
		});
		IEMFValueProperty conceptualObjectProperty = EMFEditProperties.value(editingDomain, featurePathConceptualObjectNames);
		// @formatter:on
		
		// bind param list to the viewer, use feature paths for columns
		ViewerSupport.bind(tableViewer, emfList, new IValueProperty[] { textRangeProperty, conceptualObjectProperty });
		
		// bind editing support - handles combobox property getting/setting
		IEMFValueProperty elementProperty = EMFEditProperties.value(editingDomain, ActionpartPackage.Literals.SENTENCE_ACTION_PARAM__CONCEPTUAL_OBJECT);
		ComboBoxViewerCellEditor cellEditor = new ComboBoxViewerCellEditor(tableViewer.getTable(), SWT.READ_ONLY);
		EditingSupport comboEditingSupport = new ParamBox.ComboColumnEditingSupport(tableViewer, bindingContext, elementProperty, cellEditor); 
		boxContainer.getActionParamBox().getComboColumn().setEditingSupport(comboEditingSupport);
		
		// bind items - values from which user selects
		bindConceptualObjectsList(bindingContext, cellEditor.getViewer());
	}

	private void bindActionSelection(DataBindingContext bindingContext, IObservableValue emfValue) {
		//
		// binds value to action box combo
		final ComboViewer comboViewer = boxContainer.getActionTypeBox().getComboViewer();
		IObservableValue comboValue = ViewersObservables.observeSingleSelection(comboViewer);

		UpdateValueStrategy comboToEmfStrategy = new UpdateValueStrategy();
		comboToEmfStrategy.setConverter(new ComboToActionConverter(writableValue, editingDomain));
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
		EStructuralFeature detailValue = SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME;

		bindComboListCommon(bindingContext, comboViewer, featurePath, detailValue);
	}
	
	private void bindConceptualObjectsList(DataBindingContext bindingContext, ComboViewer comboViewer) {
		FeaturePath featurePath = FeaturePath.fromList(
				UsecasePackage.Literals.USE_CASE_STEP__SOFTWARE_PROJECT_SHORTCUT, 
				SwprojPackage.Literals.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS						 
		);
		EStructuralFeature detailValue = SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME;

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
		EStructuralFeature detailValue = SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME;

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
	 * Create contents of the PageBookView Page.
	 * @param parent
	 */
	@Override
	public void createControl(Composite parent) {
		{
			boxContainer = new BoxContainer(parent, SWT.NONE);
		}
		
		getSite().getPage().addSelectionListener(this);
		
		if (editingDomain != null) {
			m_bindingContext = initDataBindings();
		}
		
		
		commandStackListener = new CommandStackListener() {
			
			@Override
			public void commandStackChanged(EventObject event) {
				boxContainer.redraw();
				boxContainer.layout();
				boxContainer.redraw();
				
				// refresh goto list (bound to derived feature, no notification about it's change is generated)
				boxContainer.getGotoUseCaseStepBox().getComboViewer().refresh(true);
			}
		};
		
		editingDomain.getCommandStack().addCommandStackListener(commandStackListener);
		
		// action type change listener
		boxContainer.getActionTypeBox().getComboViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection)event.getSelection();
				
				EComboActionType actionType = null;
				if (selection != null) {
					actionType = (EComboActionType)selection.getFirstElement();
				}
				setBoxVisibility(actionType);
				boxContainer.layout(true);
				boxContainer.redraw();
			}
		});
	}
	
	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		editingDomain.getCommandStack().removeCommandStackListener(commandStackListener);
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
			
			setBoxVisibility(EComboActionType.createEnum(useCaseStep.getAction()));
			
			boxContainer.layout();
		}
	}
	
	private void setBoxVisibility(EComboActionType comboActionType) {
		boxContainer.getSentenceActivityBox().setVisibleAndInclude(
				comboActionType == EComboActionType.FROM_SYSTEM 
				|| comboActionType == EComboActionType.TO_SYSTEM 
				|| comboActionType == EComboActionType.INTERNAL);
		boxContainer.getIncludeUseCaseBox().setVisibleAndInclude(
				comboActionType == EComboActionType.USE_CASE_INCLUDE);
		boxContainer.getGotoUseCaseStepBox().setVisibleAndInclude(
				comboActionType == EComboActionType.GOTO);
		boxContainer.getReceiverBox().setVisibleAndInclude(
				comboActionType == EComboActionType.FROM_SYSTEM);
		boxContainer.getActionParamBox().setVisibleAndInclude(
				comboActionType == EComboActionType.FROM_SYSTEM 
				|| comboActionType == EComboActionType.TO_SYSTEM 
				|| comboActionType == EComboActionType.INTERNAL);
		boxContainer.getSenderBox().setVisibleAndInclude(				 
				comboActionType == EComboActionType.TO_SYSTEM);
	}

	protected ISaveablePart getSaveablePart() {
		return null;
	}
	
	public static class ComboToActionConverter extends Converter {

		private WritableValue writableValue;
		private EditingDomain editingDomain;

		public ComboToActionConverter(WritableValue writableValue, EditingDomain editingDomain) {
			super(EComboActionType.class, Action.class);
			this.writableValue = writableValue;
			this.editingDomain = editingDomain;
		}

		@Override
		public Object convert(Object fromObject) {
			if (fromObject == null) {
				return null;
			}
			
			UseCaseStep useCaseStep = (UseCaseStep)writableValue.getValue();
			removeTextNodes(useCaseStep);
			
			EComboActionType comboActionType = (EComboActionType)fromObject;
			return comboActionType.createAction();
		}

		private void removeTextNodes(UseCaseStep useCaseStep) {
			CompoundCommand compoundCommand = new CompoundCommand();
			
			for (TextRange textRange : useCaseStep.getTextNodes()) {
				// remove text range
				RemoveCommand removeCommand = new RemoveCommand(editingDomain, useCaseStep, UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, textRange);
				compoundCommand.append(removeCommand);				
			}
			
			editingDomain.getCommandStack().execute(compoundCommand);
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
			if (fromObject == null) {
				return false;
			}
			
			Action action = (Action) fromObject;

			for (EReference reference : action.eClass().getEAllReferences()) {
				if (reference.getName().equals(referenceName)) {
					return true;
				}
			}
			
			return false;
		}
	}
	
	public static class ActionParamBoxVisibleConverter extends Converter {

		public ActionParamBoxVisibleConverter() {
			super(Action.class, Boolean.class);
		}

		@Override
		public Object convert(Object fromObject) {
			if (fromObject == null) {
				return false;
			}
			
			Action action = (Action) fromObject;
			return action instanceof Communication;
		}
	}
	
	private enum EComboActionType {
		TO_SYSTEM {
			@Override
			Action createAction() {
				ToSystem toSystem = ActionFactory.eINSTANCE.createToSystem();
				toSystem.setSender(ActionpartFactory.eINSTANCE.createSentenceActor());
				toSystem.setSentenceActivity(ActionpartFactory.eINSTANCE.createSentenceActivity());
				return toSystem;
			}

			@Override
			public String getName() {
				return "To system";
			}
		},
		FROM_SYSTEM {
			@Override
			Action createAction() {
				FromSystem fromSystem = ActionFactory.eINSTANCE.createFromSystem();
				fromSystem.setReceiver(ActionpartFactory.eINSTANCE.createSentenceActor());
				fromSystem.setSentenceActivity(ActionpartFactory.eINSTANCE.createSentenceActivity());
				return fromSystem;
			}

			@Override
			public String getName() {
				return "From system";
			}
		},
		INTERNAL {
			@Override
			Action createAction() {
				InternalAction internalAction = ActionFactory.eINSTANCE.createInternalAction();
				internalAction.setSentenceActivity(ActionpartFactory.eINSTANCE.createSentenceActivity());
				return internalAction;
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
