package reprotool.ide.editors;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.wb.rcp.databinding.EMFBeansListObservableFactory;
import org.eclipse.wb.rcp.databinding.EMFTreeBeanAdvisor;
import org.eclipse.wb.rcp.databinding.EMFTreeObservableLabelProvider;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;

import reprotool.ide.service.Service;
import reprotool.model.specification.Actor;
import reprotool.model.specification.SoftwareProject;
import reprotool.model.specification.SpecificationPackage.Literals;
import reprotool.model.specification.impl.SoftwareProjectImpl;

/**
 * @author jvinarek
 * 
 */
public class ProjectEditor extends EditorPart {
	private DataBindingContext m_bindingContext;

	private ResourceSet resourceSet = new ResourceSetImpl();

	public static final String ID = "cz.cuni.mff.reprotool.ide.editors.ProjectEditor"; //$NON-NLS-1$

	private Text textDescription;
	private TreeViewer treeViewer;
	private ListViewer listViewer;

	// TODO jvinarek - bind to project
	private SoftwareProject softwareProject = Service.INSTANCE
			.getSoftwareProject();
	private boolean dirty = false;

	/**
	 * Resources that have been saved. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected Collection<Resource> savedResources = new ArrayList<Resource>();

	/**
	 * Map to store the diagnostic associated with a resource. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	/**
	 * Controls whether the problem indication should be updated. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected boolean updateProblemIndication = true;

	/**
	 * @wbp.parser.constructor
	 */
	public ProjectEditor() {
		// TODO - nahradit wizardem, slouzi k testovani
		URI fileURI = URI.createFileURI(new File("c:\\tmp\\sp.xml")
				.getAbsolutePath());

		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(softwareProject);
		resourceSet.getResources().add(resource);
	}

	public void markDirty() {
		if (!dirty) {
			dirty = true;
			firePropertyChange(PROP_DIRTY);
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {

		// Save only resources that have actually changed.
		//
		final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
				Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

		// Do the work within an operation because this is a long running
		// activity that modifies the workbench.
		//
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			// This is the method that gets invoked when the operation runs.
			//
			@Override
			public void execute(IProgressMonitor monitor) {
				// Save the resources to the file system.
				//
				boolean first = true;
				for (Resource resource : resourceSet.getResources()) {
					if ((first || !resource.getContents().isEmpty() || isPersisted(resource))) {
						try {
							long timeStamp = resource.getTimeStamp();
							resource.save(saveOptions);
							if (resource.getTimeStamp() != timeStamp) {
								savedResources.add(resource);
							}
						} catch (Exception exception) {
							// TODO - jvinarek - enable problem analysis
							// resourceToDiagnosticMap.put(resource,
							// analyzeResourceProblems(resource, exception));
							// TODO - jvinarek - remove
							throw new RuntimeException(exception);
						}
						first = false;
					}
				}
			}
		};

		updateProblemIndication = false;
		try {
			// This runs the options, and shows progress.
			//
			new ProgressMonitorDialog(getSite().getShell()).run(true, false,
					operation);

			// Refresh the necessary state.
			//
			// ((BasicCommandStack)editingDomain.getCommandStack()).saveIsDone();
			dirty = false;
			firePropertyChange(IEditorPart.PROP_DIRTY);
		} catch (Exception exception) {
			// Something went wrong that shouldn't.
			//
			// TODO - jvinarek - enable logging
			// ReprotoolEditorPlugin.INSTANCE.log(exception);
		}
		updateProblemIndication = true;
		// TODO - jvinarek - enable problem indication
		// updateProblemIndication();
	}

	/**
	 * This returns whether something has been persisted to the URI of the
	 * specified resource. The implementation uses the URI converter from the
	 * editor's resource set to try to open an input stream. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected boolean isPersisted(Resource resource) {
		boolean result = false;
		try {
			InputStream stream = resourceSet.getURIConverter()
					.createInputStream(resource.getURI());
			if (stream != null) {
				result = true;
				stream.close();
			}
		} catch (IOException e) {
			// Ignore
		}
		return result;
	}

	/**
	 * This also changes the editor's input. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void doSaveAs() {
		SaveAsDialog saveAsDialog = new SaveAsDialog(getSite().getShell());
		saveAsDialog.open();
		IPath path = saveAsDialog.getResult();
		if (path != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			if (file != null) {
				doSaveAs(URI.createPlatformResourceURI(file.getFullPath()
						.toString(), true), new FileEditorInput(file));
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void doSaveAs(URI uri, IEditorInput editorInput) {
		resourceSet.getResources().get(0).setURI(uri);
		setInputWithNotify(editorInput);
		setPartName(editorInput.getName());
		// TODO - jvinarek - google more about action bars & eclipse
		// IProgressMonitor progressMonitor =
		// getActionBars().getStatusLineManager() != null ?
		// getActionBars().getStatusLineManager().getProgressMonitor() :
		// new NullProgressMonitor();
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		doSave(progressMonitor);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// Initialize the editor part
		setSite(site);
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return dirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void createPartControl(Composite parent) {
		// Creates the model from the editor input
		//
		createModel();

		SashForm sashForm = new SashForm(parent, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);

		Group group = new Group(sashForm, SWT.NONE);
		group.setText("Description");
		group.setLayout(new FillLayout(SWT.HORIZONTAL));

		textDescription = new Text(group, SWT.BORDER);

		Group grpActors = new Group(sashForm, SWT.NONE);
		grpActors.setText("Actors");

		Button btnAddActor = new Button(grpActors, SWT.NONE);
		btnAddActor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IHandlerService handlerService = (IHandlerService) getSite()
						.getService(IHandlerService.class);
				try {
					handlerService.executeCommand("commands.addActor", null);
				} catch (ExecutionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotDefinedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotEnabledException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotHandledException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAddActor.setText("Add");

		Button btnEditActor = new Button(grpActors, SWT.NONE);
		btnEditActor.setText("Edit");

		Button btnDeleteActor = new Button(grpActors, SWT.NONE);
		btnDeleteActor.setText("Delete");

		Composite composite = new Composite(grpActors, SWT.NONE);
		composite.setLayout(new TreeColumnLayout());
		GroupLayout gl_grpActors = new GroupLayout(grpActors);
		gl_grpActors.setHorizontalGroup(gl_grpActors.createParallelGroup(
				GroupLayout.LEADING).add(
				GroupLayout.TRAILING,
				gl_grpActors
						.createSequentialGroup()
						.add(composite, GroupLayout.DEFAULT_SIZE, 268,
								Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.RELATED)
						.add(gl_grpActors
								.createParallelGroup(GroupLayout.LEADING)
								.add(btnAddActor, GroupLayout.PREFERRED_SIZE,
										92, GroupLayout.PREFERRED_SIZE)
								.add(btnEditActor, GroupLayout.PREFERRED_SIZE,
										92, GroupLayout.PREFERRED_SIZE)
								.add(btnDeleteActor,
										GroupLayout.PREFERRED_SIZE, 92,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_grpActors
				.setVerticalGroup(gl_grpActors.createParallelGroup(
						GroupLayout.LEADING).add(
						gl_grpActors
								.createSequentialGroup()
								.addContainerGap()
								.add(gl_grpActors
										.createParallelGroup(
												GroupLayout.LEADING)
										.add(composite,
												GroupLayout.DEFAULT_SIZE, 117,
												Short.MAX_VALUE)
										.add(gl_grpActors
												.createSequentialGroup()
												.add(btnAddActor)
												.add(7)
												.add(btnEditActor)
												.add(7)
												.add(btnDeleteActor)
												.addContainerGap(34,
														Short.MAX_VALUE)))));

		treeViewer = new TreeViewer(composite, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		grpActors.setLayout(gl_grpActors);

		Group grpUseCases = new Group(sashForm, SWT.NONE);
		grpUseCases.setText("Use cases");

		Button btnAddUseCase = new Button(grpUseCases, SWT.NONE);
		btnAddUseCase.setText("Add");

		Button btnEditUseCase = new Button(grpUseCases, SWT.NONE);
		btnEditUseCase.setText("Edit");

		Button btnDeleteUseCase = new Button(grpUseCases, SWT.NONE);
		btnDeleteUseCase.setText("Delete");

		listViewer = new ListViewer(grpUseCases, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		GroupLayout gl_grpUseCases = new GroupLayout(grpUseCases);
		gl_grpUseCases.setHorizontalGroup(gl_grpUseCases.createParallelGroup(
				GroupLayout.LEADING).add(
				GroupLayout.TRAILING,
				gl_grpUseCases
						.createSequentialGroup()
						.add(list, GroupLayout.DEFAULT_SIZE, 268,
								Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.RELATED)
						.add(gl_grpUseCases
								.createParallelGroup(GroupLayout.LEADING)
								.add(btnAddUseCase, GroupLayout.PREFERRED_SIZE,
										92, GroupLayout.PREFERRED_SIZE)
								.add(btnEditUseCase,
										GroupLayout.PREFERRED_SIZE, 92,
										GroupLayout.PREFERRED_SIZE)
								.add(btnDeleteUseCase,
										GroupLayout.PREFERRED_SIZE, 92,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_grpUseCases
				.setVerticalGroup(gl_grpUseCases.createParallelGroup(
						GroupLayout.LEADING).add(
						gl_grpUseCases
								.createSequentialGroup()
								.addContainerGap()
								.add(gl_grpUseCases
										.createParallelGroup(
												GroupLayout.LEADING)
										.add(list, GroupLayout.DEFAULT_SIZE,
												117, Short.MAX_VALUE)
										.add(gl_grpUseCases
												.createSequentialGroup()
												.add(btnAddUseCase)
												.add(7)
												.add(btnEditUseCase)
												.add(7)
												.add(btnDeleteUseCase)
												.addContainerGap(34,
														Short.MAX_VALUE)))));
		grpUseCases.setLayout(gl_grpUseCases);
		sashForm.setWeights(new int[] { 74, 196, 216 });
		m_bindingContext = initDataBindings();
		// TODO Auto-generated method stub

		textDescription.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				descriptionModified(e);
			}
		});
	}

	private void createModel() {
		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		Resource resource = resourceSet.getResource(resourceURI, true);

		// ResourceSet resourceSet = new ResourceSetImpl();
		// URI fileURI =
		// URI.createFileURI(new File("mypo.xml").getAbsolutePath());
		// Resource poResource = resourceSet.getResource(fileURI, true);
		softwareProject = (SoftwareProject) resource.getContents().get(0);

		// TODO - jvinarek - diagnostic like in EMF editor

		// try {
		// // Load the resource through the editing domain.
		// //
		// resource = editingDomain.getResourceSet().getResource(resourceURI,
		// true);
		// }
		// catch (Exception e) {
		// exception = e;
		// resource = editingDomain.getResourceSet().getResource(resourceURI,
		// false);
		// }
		//
		// Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
		// if (diagnostic.getSeverity() != Diagnostic.OK) {
		// resourceToDiagnosticMap.put(resource,
		// analyzeResourceProblems(resource, exception));
		// }
		// editingDomain.getResourceSet().eAdapters().add(problemIndicationAdapter);
	}

	protected void descriptionModified(ModifyEvent e) {
		markDirty();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue textObserveTextObserveWidget = SWTObservables
				.observeText(textDescription, SWT.Modify);
		IObservableValue projectDescriptionObserveValue = EMFObservables
				.observeValue(softwareProject,
						Literals.SOFTWARE_PROJECT__DESCRIPTION);
		bindingContext.bindValue(textObserveTextObserveWidget,
				projectDescriptionObserveValue, null, null);
		//
		EMFBeansListObservableFactory treeObservableFactory = new EMFBeansListObservableFactory(
				Actor.class, Literals.ACTOR__CHILDREN_ACTORS);
		EMFTreeBeanAdvisor treeAdvisor = new EMFTreeBeanAdvisor(null,
				Literals.ACTOR__CHILDREN_ACTORS, null);
		ObservableListTreeContentProvider treeContentProvider = new ObservableListTreeContentProvider(
				treeObservableFactory, treeAdvisor);
		treeViewer.setContentProvider(treeContentProvider);
		//
		treeViewer.setLabelProvider(new EMFTreeObservableLabelProvider(
				treeContentProvider.getKnownElements(), Literals.ACTOR__NAME,
				null));
		//
		IObservableList projectActorsObserveList = EMFObservables.observeList(
				Realm.getDefault(), softwareProject,
				Literals.SOFTWARE_PROJECT__ACTORS);
		treeViewer.setInput(projectActorsObserveList);
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		listViewer.setContentProvider(listContentProvider);
		//
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] { Literals.USE_CASE__NAME });
		listViewer
				.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		//
		IObservableList projectUseCasesObserveList = EMFObservables
				.observeList(Realm.getDefault(), softwareProject,
						Literals.SOFTWARE_PROJECT__USE_CASES);
		listViewer.setInput(projectUseCasesObserveList);
		//
		return bindingContext;
	}

	// TODO - jvinarek - change
	public SoftwareProject getProject() {
		return softwareProject;
	}

}
