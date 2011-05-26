package reprotool.lts.editor;

import java.util.Comparator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import reprotool.model.lts.StateMachine;
import reprotool.model.lts.presentation.LtsEditor;

public class LTSDebugEditor extends LtsEditor {
	
	private StateMachine machine;
	private GraphViewer viewer;
	private Composite graphParent;
	private TreeLayoutAlgorithm tla;
	
	
	@Override
	public boolean isDirty() {
		return 
			super.isDirty() ||
			((LTSDebugActionBarContributor)getActionBarContributor()).isSaveNeeded();
	}
	

	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		((LTSDebugActionBarContributor)getActionBarContributor()).clearDirty();
		super.doSave(progressMonitor);
	}
	
	
	public void fireChange() {
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}
		
	
	public void showGraph() {
		viewer.setInput(machine);
		viewer.getGraphControl().setNodeStyle(ZestStyles.NODES_NO_ANIMATION);
		viewer.applyLayout();
	}
	
	
	@Override
	public void createPages() {
		createModel();

		if (!getEditingDomain().getResourceSet().getResources().isEmpty()) {
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), LTSDebugEditor.this) {
					
						@Override
						public Viewer createViewer(Composite composite) {
							Tree tree = new Tree(composite, SWT.MULTI);
							TreeViewer newTreeViewer = new TreeViewer(tree);
							return newTreeViewer;
						}
						
						@Override
						public void requestActivation() {
							super.requestActivation();
							setCurrentViewerPane(this);
						}
					};
				viewerPane.createControl(getContainer());

				selectionViewer = (TreeViewer)viewerPane.getViewer();
				selectionViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));

				selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
				selectionViewer.setInput(editingDomain.getResourceSet());
				selectionViewer.setSelection(new StructuredSelection(editingDomain.getResourceSet().getResources().get(0)), true);
				viewerPane.setTitle(editingDomain.getResourceSet());

				new AdapterFactoryTreeEditor(selectionViewer.getTree(), adapterFactory);

				createContextMenuFor(selectionViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex, "Selection");
			}
			
			{
				Resource resource = editingDomain.getResourceSet().getResources().get(0);
				Object obj = resource.getContents().get(0);
				
				machine = (StateMachine) obj;				
				graphParent = getContainer();
				
				tla = new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
				
				tla.setComparator(new Comparator() {
					
					/* We just keep the original order */
					@Override
					public int compare (Object node1, Object node2) {
						return 0;
					}
					
				});
				
				// Create a new graph
				viewer = new GraphViewer(graphParent, SWT.NONE);
				viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
				viewer.getGraphControl().getLightweightSystem().setEventDispatcher(
						new SWTEventDispatcher() {
							@Override
							public void dispatchMouseMoved(org.eclipse.swt.events.MouseEvent me) {
								// Do nothing. This disables nodes replacing with mouse.
							}
						}
				);
				
				viewer.setContentProvider(new NodeContentProvider());
				viewer.setLabelProvider(new NodeLabelProvider());							
				viewer.setLayoutAlgorithm(tla, false);
				
				showGraph();

				int pageIndex = addPage(viewer.getGraphControl());
				setPageText(pageIndex, "Graph view");
			}	
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener(
			
			new ControlAdapter() {
				boolean guard = false;
				
				@Override
				public void controlResized(ControlEvent event) {
					if (!guard) {
						guard = true;
						hideTabs();
						guard = false;
					}
				}
			}
		);

		getSite().getShell().getDisplay().asyncExec(
			
			new Runnable() {
				public void run() {
					updateProblemIndication();
				}
			}
			
		);
	}
}