package reprotool.ide.editors.usecase;

import java.util.EventObject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UsecasePackage;
import reprotool.model.usecase.presentation.ReprotoolEditorPlugin;

/**
 * Page of the Use case editor containing tree with use case steps and editor to
 * change the use case step.
 * 
 * @author jvinarek
 * 
 */
public class UsecaseEMFEditorPart extends EditorPart implements IMenuListener, IEditingDomainProvider {

	private UsecaseEMFEditorComposite composite;
	protected UsecaseEMFEditor parentEditor;

	// used by binding framework
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;

	public UsecaseEMFEditorPart(UsecaseEMFEditor parent) {
		super();
		this.parentEditor = parent;
	}

	protected static String getString(String key) {
		return ReprotoolEditorPlugin.INSTANCE.getString(key);
	}

	public EditingDomain getEditingDomain() {
		return parentEditor.getEditingDomain();
	}

	protected BasicCommandStack getCommandStack() {
		return ((BasicCommandStack) getEditingDomain().getCommandStack());
	}

	protected AdapterFactory getAdapterFactory() {
		return parentEditor.getAdapterFactory();
	}

	protected void createContextMenuFor(StructuredViewer viewer) {
		MenuManager contextMenu = new MenuManager("#PopUp");
		contextMenu.add(new Separator("additions"));
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(this);
		Menu menu = contextMenu.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
		viewer.addDropSupport(dndOperations, transfers, new EditingDomainViewerDropAdapter(getEditingDomain(), viewer));
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// nothing to do here - this is handled by the parent editor
	}

	@Override
	public void doSaveAs() {
		// nothing to do here - this is handled by the parent editor
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);

	}

	@Override
	public boolean isDirty() {
		return getCommandStack().isSaveNeeded();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	public void menuAboutToShow(IMenuManager manager) {
		// pass the request to show the context menu on to the parent editor
		((IMenuListener) parentEditor.getEditorSite().getActionBarContributor()).menuAboutToShow(manager);
	}

	@Override
	public void createPartControl(final Composite parent) {
		composite = new UsecaseEMFEditorComposite(parent, SWT.NONE);
		TreeViewer viewer = composite.getTreeViewer();

		viewer.setColumnProperties(new String[] { "a", "b" });
		viewer.setContentProvider(new AdapterFactoryContentProvider(getAdapterFactory()));

		// set custom provider instead of AdapterFactoryLabelProvider
		composite.getLabelColumn().setLabelProvider(new UsecaseEMFLabelProvider.LabelColumnProvider());

		composite.getTextColumn().setLabelProvider(new UsecaseEMFLabelProvider.TextColumnProvider());
		composite.getTextColumn().setEditingSupport(new UseCaseStepEditingSupport(composite.getTreeViewer()));

		createContextMenuFor(viewer);
		getEditorSite().setSelectionProvider(viewer);

		// try to get use case from the input and set it into viewer
		UseCase useCase = getInputUseCase();
		if (useCase != null) {
			// set use case to viewer
			this.setInput(useCase);

			// add binding
			m_bindingContext = initDataBindings(useCase);
		}

		// add command stack listener to refresh tree
		// TODO - jvinarek - add somewhere remove listener ?
		getCommandStack().addCommandStackListener(new CommandStackListener() {
			
			public void commandStackChanged(final EventObject event) {
				
				// prevent refresh during writing of the text in cell editor
				// FIXME jvinarek
//				Command mostRecentCommand = getCommandStack().getMostRecentCommand();				
//				if (!isContentSetting(mostRecentCommand)) {
//					parentEditor.getContainer().getDisplay().asyncExec(new Runnable() {
//						public void run() {
//							UsecaseEMFEditorPart.this.composite.getTreeViewer().refresh();
//
//						}
//					});
//				}
			}

			private boolean isContentSetting(Command command) {
				return (command instanceof SetCommand)
						&& ((SetCommand) command).getFeature() == UsecasePackage.Literals.PARSEABLE_ELEMENT__CONTENT;
			}
			
		});

		composite.getTreeViewer().expandAll();
	}

	private DataBindingContext initDataBindings(UseCase useCase) {
		DataBindingContext bindingContext = new DataBindingContext();

		bindName(bindingContext, useCase);
		bindDescription(bindingContext, useCase);
		bindTitle(bindingContext, useCase);
		bindPrimaryActorComboContent(bindingContext, useCase);
		bindPrimaryActorComboSelection(bindingContext, useCase);
		bindPrecedingUseCasesList(bindingContext, useCase);
		
		return bindingContext;
	}

	private void bindName(DataBindingContext bindingContext, UseCase useCase) {
		IObservableValue emfValue = EMFEditProperties.value(getEditingDomain(),
				SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME).observe(useCase);
		IObservableValue textValue = WidgetProperties.text(SWT.Modify).observe(composite.getUseCasePropertiesSectionPart().getTxtName());
		bindingContext.bindValue(textValue, emfValue);
	}
	
	private void bindDescription(DataBindingContext bindingContext, UseCase useCase) {
		IObservableValue emfValue = EMFEditProperties.value(getEditingDomain(),
				SwprojPackage.Literals.DESCRIBED_ELEMENT__DESCRIPTION).observe(useCase);
		IObservableValue textValue = WidgetProperties.text(SWT.Modify).observe(composite.getUseCasePropertiesSectionPart().getTxtDescription());
		bindingContext.bindValue(textValue, emfValue);
	}

	private void bindTitle(DataBindingContext bindingContext, UseCase useCase) {
		IObservableValue emfValue = EMFEditProperties.value(getEditingDomain(),
				SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME).observe(useCase);
		IObservableValue titleValue = PojoObservables.observeValue(composite.getForm(), "text");
		bindingContext.bindValue(titleValue, emfValue);
	}

	private void bindPrimaryActorComboContent(DataBindingContext bindingContext, UseCase useCase) {
		ComboViewer actorsCombo = composite.getUseCasePropertiesSectionPart().getComboViewer();
		
		FeaturePath actorsPath = FeaturePath.fromList(UsecasePackage.Literals.USE_CASE__SOFTWARE_PROJECT_SHORTCUT, SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS);
		IObservableList emfList = EMFEditProperties.list(getEditingDomain(), actorsPath).observe(useCase);
		
		IValueProperty labelProperty = EMFEditProperties.value(getEditingDomain(), SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME);

		ViewerSupport.bind(actorsCombo, emfList, labelProperty);
	}

	private void bindPrimaryActorComboSelection(DataBindingContext bindingContext, UseCase useCase) {
		ComboViewer actorsCombo = composite.getUseCasePropertiesSectionPart().getComboViewer();
		
		IObservableValue comboSelectionValue = ViewersObservables.observeSingleSelection(actorsCombo);
		IObservableValue emfValue = EMFEditProperties.value(getEditingDomain(), UsecasePackage.Literals.USE_CASE__PRIMARY_ACTOR).observe(useCase);
		
		bindingContext.bindValue(comboSelectionValue, emfValue);
	}
	
	private void bindPrecedingUseCasesList(DataBindingContext bindingContext, UseCase useCase) {
		TableViewer tableViewer = composite.getPrecedingUseCasesPart().getTableViewer();
		
		IObservableList emfList = EMFEditProperties.list(getEditingDomain(), UsecasePackage.Literals.USE_CASE__PRECEDING_USE_CASES).observe(useCase);
		IValueProperty labelProperty = EMFEditProperties.value(getEditingDomain(), SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME);

		ViewerSupport.bind(tableViewer, emfList, labelProperty);
	}

	private UseCase getInputUseCase() {
		IEditorInput input = getEditorInput();
		if (input instanceof URIEditorInput) {
			URIEditorInput uriEditorInput = (URIEditorInput) input;
	
			EObject object = getEditingDomain().getResourceSet().getEObject(uriEditorInput.getURI(), true);
			if (object instanceof UseCase) {
				return (UseCase) object;
			}
		}
	
		return null;
	}

	@Override
	public void setFocus() {
		composite.getTreeViewer().getTree().setFocus();
	}

	public void setInput(Object input) {
		Assert.isTrue(input instanceof UseCase, "Input must have type 'UseCase' but was:" + input);
		UseCase useCase = (UseCase) input;
		composite.getTreeViewer().setInput(useCase.getMainScenario());
	}

}