package reprotool.ide.views;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.rcp.databinding.EMFBeansListObservableFactory;
import org.eclipse.wb.rcp.databinding.EMFTreeBeanAdvisor;
import org.eclipse.wb.rcp.databinding.EMFTreeObservableLabelProvider;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;

import reprotool.ide.service.Service;
import reprotool.model.specification.Actor;
import reprotool.model.specification.SoftwareProject;
import reprotool.model.specification.SpecificationPackage.Literals;
import reprotool.model.specification.UseCase;

public class ProjectView extends ViewPart {
	private DataBindingContext m_bindingContext;

	private Service service = Service.INSTANCE;

	public static final String ID = "cz.cuni.mff.reprotool.ide.view_project";

	private Text textDescription;
	private TreeViewer treeViewerActors;

	// TODO - test only
	private SoftwareProject project = service.getSoftwareProject();
	private ListViewer listViewer;

	public ProjectView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {

		SashForm sashForm = new SashForm(parent, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);

		Group grpDescription = new Group(sashForm, SWT.NONE);
		grpDescription.setText("Description");
		grpDescription.setLayout(new FillLayout(SWT.HORIZONTAL));

		textDescription = new Text(grpDescription, SWT.BORDER | SWT.MULTI);

		Group grpActorsStakeholders = new Group(sashForm, SWT.NONE);
		grpActorsStakeholders.setText("Actors and stakeholders");

		Button buttonActorAdd = new Button(grpActorsStakeholders, SWT.NONE);
		buttonActorAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IHandlerService handlerService = (IHandlerService) getSite()
						.getService(IHandlerService.class);
				try {
					handlerService.executeCommand("commands.addActor", null);
				} catch (Exception ex) {
					// TODO jvinarek - add logging
					throw new RuntimeException(
							"command with id \"commands.addActor\" not found");
				}
			}
		});
		buttonActorAdd.setText("Add");

		Button buttonActorEdit = new Button(grpActorsStakeholders, SWT.NONE);
		buttonActorEdit.setText("Edit");

		Button buttonActorDelete = new Button(grpActorsStakeholders, SWT.NONE);
		buttonActorDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IHandlerService handlerService = (IHandlerService) getSite()
						.getService(IHandlerService.class);
				try {
					handlerService.executeCommand("commands.removeActor", null);
				} catch (Exception ex) {
					// TODO jvinarek - add logging
					throw new RuntimeException(
							"command with id \"commands.removeActor\" not found");
				}
			}
		});
		buttonActorDelete.setText("Delete");

		Composite composite = new Composite(grpActorsStakeholders, SWT.NONE);
		TreeColumnLayout tcl_composite = new TreeColumnLayout();
		composite.setLayout(tcl_composite);

		treeViewerActors = new TreeViewer(composite, SWT.BORDER);
		treeViewerActors
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						// filters use cases according to selected primary actor

						TreeSelection treeSelection = (TreeSelection) event
								.getSelection();
						if (!treeSelection.isEmpty()) {
							final Actor actor = (Actor) treeSelection
									.getFirstElement();

							ViewerFilter[] filters = new ViewerFilter[] { new ViewerFilter() {

								@Override
								public boolean select(Viewer viewer,
										Object parentElement, Object element) {
									UseCase useCase = (UseCase) element;
									return useCase.getPrimaryActor().equals(
											actor);
								}

							} };
							listViewer.setFilters(filters);
						}
					}
				});

		GroupLayout gl_grpActorsStakeholders = new GroupLayout(
				grpActorsStakeholders);
		gl_grpActorsStakeholders.setHorizontalGroup(gl_grpActorsStakeholders
				.createParallelGroup(GroupLayout.TRAILING).add(
						gl_grpActorsStakeholders
								.createSequentialGroup()
								.add(composite, GroupLayout.DEFAULT_SIZE, 482,
										Short.MAX_VALUE)
								.addPreferredGap(LayoutStyle.RELATED)
								.add(gl_grpActorsStakeholders
										.createParallelGroup(
												GroupLayout.LEADING, false)
										.add(buttonActorAdd,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.add(buttonActorEdit,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.add(GroupLayout.TRAILING,
												buttonActorDelete,
												GroupLayout.PREFERRED_SIZE, 92,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		gl_grpActorsStakeholders.setVerticalGroup(gl_grpActorsStakeholders
				.createParallelGroup(GroupLayout.LEADING).add(
						gl_grpActorsStakeholders
								.createSequentialGroup()
								.addContainerGap()
								.add(gl_grpActorsStakeholders
										.createParallelGroup(
												GroupLayout.LEADING)
										.add(composite,
												GroupLayout.DEFAULT_SIZE, 199,
												Short.MAX_VALUE)
										.add(gl_grpActorsStakeholders
												.createSequentialGroup()
												.add(buttonActorAdd)
												.addPreferredGap(
														LayoutStyle.RELATED)
												.add(buttonActorEdit)
												.addPreferredGap(
														LayoutStyle.RELATED)
												.add(buttonActorDelete)
												.addContainerGap(116,
														Short.MAX_VALUE)))));
		grpActorsStakeholders.setLayout(gl_grpActorsStakeholders);

		Group grpUseCases = new Group(sashForm, SWT.NONE);
		grpUseCases.setText("Use cases");

		Button buttonUseCaseDelete = new Button(grpUseCases, SWT.NONE);
		buttonUseCaseDelete.setText("Delete");

		Button buttonUseCaseEdit = new Button(grpUseCases, SWT.NONE);
		buttonUseCaseEdit.setText("Edit");

		Button buttonUseCaseAdd = new Button(grpUseCases, SWT.NONE);
		buttonUseCaseAdd.setText("Add");

		listViewer = new ListViewer(grpUseCases, SWT.BORDER | SWT.V_SCROLL);
		listViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				// TODO - jvinarek - create command to open given use case
				UseCase useCase = (UseCase) ((StructuredSelection) event
						.getSelection()).getFirstElement();
				openEditor(useCase);
			}
		});
		List listUseCases = listViewer.getList();
		GroupLayout gl_grpUseCases = new GroupLayout(grpUseCases);
		gl_grpUseCases.setHorizontalGroup(gl_grpUseCases.createParallelGroup(
				GroupLayout.TRAILING).add(
				gl_grpUseCases
						.createSequentialGroup()
						.add(listUseCases, GroupLayout.DEFAULT_SIZE, 482,
								Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.RELATED)
						.add(gl_grpUseCases
								.createParallelGroup(GroupLayout.LEADING)
								.add(buttonUseCaseAdd,
										GroupLayout.PREFERRED_SIZE, 92,
										GroupLayout.PREFERRED_SIZE)
								.add(buttonUseCaseEdit,
										GroupLayout.PREFERRED_SIZE, 92,
										GroupLayout.PREFERRED_SIZE)
								.add(buttonUseCaseDelete,
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
										.add(listUseCases,
												GroupLayout.DEFAULT_SIZE, 150,
												Short.MAX_VALUE)
										.add(gl_grpUseCases
												.createSequentialGroup()
												.add(buttonUseCaseAdd)
												.add(7)
												.add(buttonUseCaseEdit)
												.add(7)
												.add(buttonUseCaseDelete)
												.addContainerGap(67,
														Short.MAX_VALUE)))));
		grpUseCases.setLayout(gl_grpUseCases);
		sashForm.setWeights(new int[] { 109, 238, 239 });
		m_bindingContext = initDataBindings();
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public TreeViewer getTreeViewer() {
		return treeViewerActors;
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue textObserveTextObserveWidget = SWTObservables
				.observeText(textDescription, SWT.Modify);
		IObservableValue projectDescriptionObserveValue = EMFObservables
				.observeValue(project, Literals.SOFTWARE_PROJECT__DESCRIPTION);
		bindingContext.bindValue(textObserveTextObserveWidget,
				projectDescriptionObserveValue, null, null);
		//
		EMFBeansListObservableFactory treeObservableFactory = new EMFBeansListObservableFactory(
				Actor.class, Literals.ACTOR__CHILDREN_ACTORS);
		EMFTreeBeanAdvisor treeAdvisor = new EMFTreeBeanAdvisor(null,
				Literals.ACTOR__CHILDREN_ACTORS, null);
		ObservableListTreeContentProvider treeContentProvider = new ObservableListTreeContentProvider(
				treeObservableFactory, treeAdvisor);
		treeViewerActors.setContentProvider(treeContentProvider);
		//
		treeViewerActors.setLabelProvider(new EMFTreeObservableLabelProvider(
				treeContentProvider.getKnownElements(), Literals.ACTOR__NAME,
				null));
		//
		IObservableList projectActorsObserveList = EMFObservables.observeList(
				Realm.getDefault(), project, Literals.SOFTWARE_PROJECT__ACTORS);
		treeViewerActors.setInput(projectActorsObserveList);
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
				.observeList(Realm.getDefault(), project,
						Literals.SOFTWARE_PROJECT__USE_CASES);
		listViewer.setInput(projectUseCasesObserveList);
		//
		return bindingContext;
	}

	// TODO - move method to eclipse "command", open real file 
	private void openEditor(UseCase useCase) {
		try {
			File fileToOpen = File.createTempFile("tmpUseCase", ".uc");
			fileToOpen.deleteOnExit();

			if (fileToOpen.exists() && fileToOpen.isFile()) {
				IFileStore fileStore = EFS.getLocalFileSystem().getStore(
						fileToOpen.toURI());
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();

				try {
					IDE.openEditorOnFileStore(page, fileStore);
				} catch (PartInitException e) {
					// Put your exception handler here if you wish to
				}
			} else {
				// Do something if the file does not exist
				System.out.println("file test.uc not found");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
