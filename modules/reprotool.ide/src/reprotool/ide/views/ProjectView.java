package reprotool.ide.views;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.rcp.databinding.BeansListObservableFactory;
import org.eclipse.wb.rcp.databinding.TreeBeanAdvisor;
import org.eclipse.wb.rcp.databinding.TreeObservableLabelProvider;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;

import reprotool.ide.service.Service;
import reprotool.model.specification.Actor;

public class ProjectView extends ViewPart {
	private DataBindingContext m_bindingContext;
	
	private Service service = Service.INSTANCE;
	
	public static final String ID = "cz.cuni.mff.reprotool.ide.view_project";

	private Text text;
	private TreeViewer treeViewer;

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

		text = new Text(grpDescription, SWT.BORDER | SWT.MULTI);

		Group grpActorsStakeholders = new Group(sashForm, SWT.NONE);
		grpActorsStakeholders.setText("Actors and stakeholders");

		Button buttonAdd = new Button(grpActorsStakeholders, SWT.NONE);
		buttonAdd.addSelectionListener(new SelectionAdapter() {
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
		buttonAdd.setText("Add");

		Button buttonEdit = new Button(grpActorsStakeholders, SWT.NONE);
		buttonEdit.setText("Edit");

		Button buttonDelete = new Button(grpActorsStakeholders, SWT.NONE);
		buttonDelete.addSelectionListener(new SelectionAdapter() {
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
		buttonDelete.setText("Delete");

		Composite composite = new Composite(grpActorsStakeholders, SWT.NONE);
		TreeColumnLayout tcl_composite = new TreeColumnLayout();
		composite.setLayout(tcl_composite);

		treeViewer = new TreeViewer(composite, SWT.BORDER);

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
										.add(buttonAdd,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.add(buttonEdit,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.add(GroupLayout.TRAILING,
												buttonDelete,
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
												.add(buttonAdd)
												.addPreferredGap(
														LayoutStyle.RELATED)
												.add(buttonEdit)
												.addPreferredGap(
														LayoutStyle.RELATED)
												.add(buttonDelete)
												.addContainerGap(116,
														Short.MAX_VALUE)))));
		grpActorsStakeholders.setLayout(gl_grpActorsStakeholders);

		Group grpUseCases = new Group(sashForm, SWT.NONE);
		grpUseCases.setText("Use cases");
		GroupLayout gl_grpUseCases = new GroupLayout(grpUseCases);
		gl_grpUseCases.setHorizontalGroup(gl_grpUseCases.createParallelGroup(
				GroupLayout.TRAILING).add(0, 588, Short.MAX_VALUE));
		gl_grpUseCases.setVerticalGroup(gl_grpUseCases.createParallelGroup(
				GroupLayout.LEADING).add(0, 222, Short.MAX_VALUE));
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
		return treeViewer;
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		BeansListObservableFactory treeObservableFactory = new BeansListObservableFactory(Actor.class, "compoundActor");
		TreeBeanAdvisor treeAdvisor = new TreeBeanAdvisor(Actor.class, null, "compoundActor", null);
		ObservableListTreeContentProvider treeContentProvider = new ObservableListTreeContentProvider(treeObservableFactory, treeAdvisor);
		treeViewer.setContentProvider(treeContentProvider);
		//
		treeViewer.setLabelProvider(new TreeObservableLabelProvider(treeContentProvider.getKnownElements(), Actor.class, "name", null));
		//
		treeViewer.setInput(service.getActors());
		//
		return bindingContext;
	}
}
