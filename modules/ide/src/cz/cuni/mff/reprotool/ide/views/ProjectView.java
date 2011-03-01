package cz.cuni.mff.reprotool.ide.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.jface.viewers.TableTreeViewer;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ProjectView extends ViewPart {
	private Text text;

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
		
		Button button_3 = new Button(grpActorsStakeholders, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		button_3.setText("Add");
		
		Button button_4 = new Button(grpActorsStakeholders, SWT.NONE);
		button_4.setText("Edit");
		
		Button button_5 = new Button(grpActorsStakeholders, SWT.NONE);
		button_5.setText("Delete");
		
		Composite composite = new Composite(grpActorsStakeholders, SWT.NONE);
		composite.setLayout(new TreeColumnLayout());
		
		TreeViewer treeViewer = new TreeViewer(composite, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		GroupLayout gl_grpActorsStakeholders = new GroupLayout(grpActorsStakeholders);
		gl_grpActorsStakeholders.setHorizontalGroup(
			gl_grpActorsStakeholders.createParallelGroup(GroupLayout.LEADING)
				.add(GroupLayout.TRAILING, gl_grpActorsStakeholders.createSequentialGroup()
					.add(composite, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(gl_grpActorsStakeholders.createParallelGroup(GroupLayout.LEADING, false)
						.add(button_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.add(button_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.add(GroupLayout.TRAILING, button_5, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_grpActorsStakeholders.setVerticalGroup(
			gl_grpActorsStakeholders.createParallelGroup(GroupLayout.LEADING)
				.add(gl_grpActorsStakeholders.createSequentialGroup()
					.addContainerGap()
					.add(gl_grpActorsStakeholders.createParallelGroup(GroupLayout.LEADING)
						.add(composite, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.add(gl_grpActorsStakeholders.createSequentialGroup()
							.add(button_3)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(button_4)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(button_5)
							.addContainerGap(116, Short.MAX_VALUE))))
		);
		grpActorsStakeholders.setLayout(gl_grpActorsStakeholders);
		
		Group grpUseCases = new Group(sashForm, SWT.NONE);
		grpUseCases.setText("Use cases");
		GroupLayout gl_grpUseCases = new GroupLayout(grpUseCases);
		gl_grpUseCases.setHorizontalGroup(
			gl_grpUseCases.createParallelGroup(GroupLayout.TRAILING)
				.add(0, 588, Short.MAX_VALUE)
		);
		gl_grpUseCases.setVerticalGroup(
			gl_grpUseCases.createParallelGroup(GroupLayout.LEADING)
				.add(0, 222, Short.MAX_VALUE)
		);
		grpUseCases.setLayout(gl_grpUseCases);
		sashForm.setWeights(new int[] {109, 238, 239});
		// TODO Auto-generated method stub

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
