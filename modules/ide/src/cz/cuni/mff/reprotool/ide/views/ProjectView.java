package cz.cuni.mff.reprotool.ide.views;

import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
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
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;

import cz.cuni.mff.reprotool.ide.model.Actor;
import cz.cuni.mff.reprotool.ide.service.ModelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class ProjectView extends ViewPart {

	private static class ActorsViewerLabelProvider extends LabelProvider {
		public Image getImage(Object element) {
			return super.getImage(element);
		}

		public String getText(Object element) {
			Actor actor = (Actor) element;
			return actor.getName();
		}
	}

	private static class ActorsTreeContentProvider implements
			ITreeContentProvider {
		private Object[] emptyArray = new Object[] {};

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object inputElement) {
			return ModelProvider.INSTANCE.getActors().toArray();
			// return getChildren(inputElement);
		}

		public Object[] getChildren(Object parentElement) {
			// return new Object[] { "item_0", "item_1", "item_2" };
			return emptyArray;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
	}

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
		treeViewer.setLabelProvider(new ActorsViewerLabelProvider());
		treeViewer.setContentProvider(new ActorsTreeContentProvider());
		// TODO jvinarek - check this
		treeViewer.setInput(ModelProvider.INSTANCE.getActors());

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
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}
}
