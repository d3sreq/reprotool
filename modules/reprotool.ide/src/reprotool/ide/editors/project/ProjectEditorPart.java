package reprotool.ide.editors.project;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.presentation.ReprotoolEditorPlugin;

public class ProjectEditorPart extends EditorPart implements IMenuListener, IEditingDomainProvider {

	private ProjectEditorComposite composite;
	protected ProjectEditor parentEditor;

	// used by binding framework
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;

	public ProjectEditorPart(ProjectEditor parent) {
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
		composite = new ProjectEditorComposite(parent, SWT.NONE);
//		TreeViewer viewer = composite.getTreeViewer();
//
//		viewer.setColumnProperties(new String[] { "a", "b" });
//		viewer.setContentProvider(new AdapterFactoryContentProvider(getAdapterFactory()));
//
//		// set custom provider instead of AdapterFactoryLabelProvider
//		composite.getLabelColumn().setLabelProvider(new UsecaseEMFLabelProvider.LabelColumnProvider());
//
//		composite.getTextColumn().setLabelProvider(new UsecaseEMFLabelProvider.TextColumnProvider());
//		composite.getTextColumn().setEditingSupport(new UseCaseStepEditingSupport(composite.getTreeViewer()));
//
//		createContextMenuFor(viewer);
//		getEditorSite().setSelectionProvider(viewer);
//
		// try to get use case from the input and set it into viewer
		SoftwareProject softwareProject = getSoftwareProject();
		if (softwareProject != null) {
			// set use case to viewer
//			this.setInput(useCase);

			// add binding
			m_bindingContext = initDataBindings(softwareProject);
		}
//
//		// add command stack listener to refresh tree
//		// TODO - jvinarek - add somewhere remove listener ?
//		getCommandStack().addCommandStackListener(new CommandStackListener() {
//			
//			public void commandStackChanged(final EventObject event) {
//				
//				// prevent refresh during writing of the text in cell editor
//				// FIXME jvinarek
////				Command mostRecentCommand = getCommandStack().getMostRecentCommand();				
////				if (!isContentSetting(mostRecentCommand)) {
////					parentEditor.getContainer().getDisplay().asyncExec(new Runnable() {
////						public void run() {
////							UsecaseEMFEditorPart.this.composite.getTreeViewer().refresh();
////
////						}
////					});
////				}
//			}
//
//			private boolean isContentSetting(Command command) {
//				return (command instanceof SetCommand)
//						&& ((SetCommand) command).getFeature() == UsecasePackage.Literals.PARSEABLE_ELEMENT__CONTENT;
//			}
//			
//		});
//
//		composite.getTreeViewer().expandAll();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	private SoftwareProject getSoftwareProject() {
		// TODO jvinarek - add checks
		Resource resource = parentEditor.getEditingDomain().getResourceSet().getResources().get(0);
		SoftwareProject softwareProject = (SoftwareProject)resource.getContents().get(0);
		return softwareProject;
	}

	private DataBindingContext initDataBindings(SoftwareProject softwareProject) {
		DataBindingContext bindingContext = new DataBindingContext();

		bindName(bindingContext, softwareProject);
		bindDescription(bindingContext, softwareProject);
		bindTitle(bindingContext, softwareProject);
		bindActors(bindingContext, softwareProject);
		bindConceptualObjects(bindingContext, softwareProject);
		bindUseCases(bindingContext, softwareProject);
		
		return bindingContext;
	}

	private void bindName(DataBindingContext bindingContext, SoftwareProject project) {
		IObservableValue emfValue = EMFEditProperties.value(getEditingDomain(),
				SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME).observe(project);
		IObservableValue textValue = WidgetProperties.text(SWT.Modify).observe(composite.getScntNameAndDescription().getTxtName());
		bindingContext.bindValue(textValue, emfValue);
	}
	
	private void bindDescription(DataBindingContext bindingContext, SoftwareProject project) {
		IObservableValue emfValue = EMFEditProperties.value(getEditingDomain(),
				SwprojPackage.Literals.DESCRIBED_ELEMENT__DESCRIPTION).observe(project);
		IObservableValue textValue = WidgetProperties.text(SWT.Modify).observe(composite.getScntNameAndDescription().getTxtDescription());
		bindingContext.bindValue(textValue, emfValue);
	}

	private void bindTitle(DataBindingContext bindingContext, SoftwareProject project) {
		IObservableValue emfValue = EMFEditProperties.value(getEditingDomain(),
				SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME).observe(project);
		IObservableValue titleValue = PojoObservables.observeValue(composite.getForm(), "text");
		bindingContext.bindValue(titleValue, emfValue);
	}
	
	private void bindUseCases(DataBindingContext bindingContext, SoftwareProject softwareProject) {
		TableViewer tableViewer = composite.getSctnUseCases().getTableViewer();
		
		IObservableList emfList = EMFEditProperties.list(getEditingDomain(), SwprojPackage.Literals.SOFTWARE_PROJECT__USE_CASES).observe(softwareProject);
		IValueProperty labelProperty = EMFEditProperties.value(getEditingDomain(), SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME);
	
		ViewerSupport.bind(tableViewer, emfList, labelProperty);
	}

	private void bindActors(DataBindingContext bindingContext, SoftwareProject softwareProject) {
		TableViewer tableViewer = composite.getSctnActors().getTableViewer();
		
		IObservableList emfList = EMFEditProperties.list(getEditingDomain(), SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS).observe(softwareProject);
		IValueProperty labelProperty = EMFEditProperties.value(getEditingDomain(), SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME);
	
		ViewerSupport.bind(tableViewer, emfList, labelProperty);
	}

	private void bindConceptualObjects(DataBindingContext bindingContext, SoftwareProject softwareProject) {
		TableViewer tableViewer = composite.getSctnConceptualObjects().getTableViewer();
		
		IObservableList emfList = EMFEditProperties.list(getEditingDomain(), SwprojPackage.Literals.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS).observe(softwareProject);
		IValueProperty labelProperty = EMFEditProperties.value(getEditingDomain(), SwprojPackage.Literals.DESCRIBED_ELEMENT__NAME);
	
		ViewerSupport.bind(tableViewer, emfList, labelProperty);
	}
	
}
