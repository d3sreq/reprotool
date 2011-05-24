package reprotool.lts.editor;

import java.util.Comparator;
import java.util.HashMap;

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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import reprotool.model.lts.State;
import reprotool.model.lts.StateMachine;
import reprotool.model.lts.Transition;
import reprotool.model.lts.presentation.ReprotoolEditorPlugin;

/**
 * This is extended LTS editor build upon the generated LtsEditor
 */
public class ExtendedLtsEditor
	extends reprotool.model.lts.presentation.LtsEditor {
	
	@Override
	public void createPages() {
		// Creates the model from the editor input
		//
		createModel();

		// Only creates the other pages if there is something that can be edited
		//
		if (!getEditingDomain().getResourceSet().getResources().isEmpty()) {
			// Create a page for the selection tree view.
			//
			{
				ViewerPane viewerPane =
					new ViewerPane(getSite().getPage(), ExtendedLtsEditor.this) {
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
				setPageText(pageIndex, ReprotoolEditorPlugin.INSTANCE.getString("_UI_SelectionPage_label"));
			}
			
			// Create a page for the Graph view.
			//
			{
				Resource resource = editingDomain.getResourceSet().getResources().get(0);
				Object obj = resource.getContents().get(0);
				
				StateMachine machine = (StateMachine) obj;
				
				Composite parent = getContainer();
				Graph graph;
				
				graph = new Graph(parent, SWT.NONE);
				graph.setNodeStyle(ZestStyles.NODES_NO_ANIMATION);
				graph.getLightweightSystem().setEventDispatcher(
						new SWTEventDispatcher() {
							@Override
							public void dispatchMouseMoved(org.eclipse.swt.events.MouseEvent me) {
								// Do nothing. This disables nodes replacing with mouse.
							}
						}
				);
				
				HashMap<State, GraphNode> map = new HashMap<State, GraphNode>();
				
				for (State s: machine.getAllStates()) {
					GraphNode gNode = new GraphNode(graph, SWT.NONE, "state");
					gNode.setData(s);
					gNode.setBackgroundColor(new Color(Display.getDefault(), 255, 255, 255));
					gNode.setHighlightColor(new Color(Display.getDefault(), 255, 255, 255));
					
					map.put(s, gNode);
				}
				
				for (Transition t: machine.getAllTransitions()) {
					GraphNode node1 = map.get(t.getSource());
					GraphNode node2 = map.get(t.getTarget());
										
					if (node1 != null && node2 != null) {
						GraphConnection conn = new GraphConnection(graph, ZestStyles.CONNECTIONS_DIRECTED,
								node1, node2);
						conn.setText(t.getSentence().getLabel());
					}
				}
				
				
				TreeLayoutAlgorithm tla = 
					new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
				
				tla.setComparator(new Comparator() {
					
					/* We just keep the original order */
					@Override
					public int compare (Object node1, Object node2) {
						return 0;
					}
					
				});
				
				graph.setLayoutAlgorithm(tla, true);
		
				int pageIndex = addPage(graph);
				setPageText(pageIndex, "Graph view");
			}


			getSite().getShell().getDisplay().asyncExec
				(new Runnable() {
					 public void run() {
						 setActivePage(0);
					 }
				 });
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener
			(new ControlAdapter() {
				boolean guard = false;
				@Override
				public void controlResized(ControlEvent event) {
					if (!guard) {
						guard = true;
						hideTabs();
						guard = false;
					}
				}
			 });

		getSite().getShell().getDisplay().asyncExec
			(new Runnable() {
				 public void run() {
					 updateProblemIndication();
				 }
			 });
	}
}
