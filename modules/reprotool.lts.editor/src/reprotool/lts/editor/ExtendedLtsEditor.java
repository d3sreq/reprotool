package reprotool.lts.editor;

import java.net.URL;
import java.util.Comparator;
import java.util.HashMap;

import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.zest.core.widgets.CGraphNode;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;
import org.osgi.framework.Bundle;

import reprotool.model.lts.State;
import reprotool.model.lts.StateMachine;
import reprotool.model.lts.Transition;
import reprotool.model.lts.presentation.ReprotoolEditorPlugin;

/**
 * This is extended LTS editor build upon the generated LtsEditor
 */
public class ExtendedLtsEditor extends
		reprotool.model.lts.presentation.LtsEditor {

	private static Image IMG_INITIAL_STATE = createImageFromBundledIcon("initial-state-16x16.png");
	private static Image IMG_NORMAL_STATE = createImageFromBundledIcon("normal-state-16x16.png");
	private static Image IMG_ABORT_STATE = createImageFromBundledIcon("abort-state-16x16.png");
	private static Image IMG_SUCCESS_STATE = createImageFromBundledIcon("initial-state-16x16.png");
	
	/**
	 * Creates an Image object from the icon image located in "icons"
	 * directory of the bundle.
	 * Remember that content of a fragment is merged to the original plugin.
	 * You have to use name of the original plugin instead of the fragment's name
	 * (in this case use reprotool.model.editor instead of reprotool.lts.editor)
	 * @param iconName
	 */
	private static Image createImageFromBundledIcon(String iconName) {
		// because this is a fragment's code, we have to access the resources using the original plugin name 
		Bundle bundle = Platform.getBundle("reprotool.model.editor");
		
		// the icons dir in reprotool.lts.editor will be merged with icons dir in reprotool.model.editor
		URL url = bundle.getResource("icons/" + iconName);
		
		ImageDescriptor imgDescriptor = ImageDescriptor.createFromURL(url);
		return imgDescriptor.createImage();
	}
	
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
				ViewerPane viewerPane = new ViewerPane(getSite().getPage(),
						ExtendedLtsEditor.this) {
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

				selectionViewer = (TreeViewer) viewerPane.getViewer();
				selectionViewer
						.setContentProvider(new AdapterFactoryContentProvider(
								adapterFactory));

				selectionViewer
						.setLabelProvider(new AdapterFactoryLabelProvider(
								adapterFactory));
				selectionViewer.setInput(editingDomain.getResourceSet());
				selectionViewer.setSelection(new StructuredSelection(
						editingDomain.getResourceSet().getResources().get(0)),
						true);
				viewerPane.setTitle(editingDomain.getResourceSet());

				new AdapterFactoryTreeEditor(selectionViewer.getTree(),
						adapterFactory);

				createContextMenuFor(selectionViewer);
				int pageIndex = addPage(viewerPane.getControl());
				setPageText(pageIndex,
						ReprotoolEditorPlugin.INSTANCE
								.getString("_UI_SelectionPage_label"));
			}

			// Create a page for the Graph view.
			//
			{
				Resource resource = editingDomain.getResourceSet()
						.getResources().get(0);
				Object obj = resource.getContents().get(0);
				createLtsGraph(getContainer(), (StateMachine) obj);
			}

			getSite().getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {
					setActivePage(0);
				}
			});
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener(new ControlAdapter() {
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

		getSite().getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				updateProblemIndication();
			}
		});
	}

	static private final Color COLOR_WHITE = new Color(Display.getDefault(),
			255, 255, 255);

	/**
	 * @param parent
	 *            Where to paint the graph
	 * @param machine
	 *            Which StateMachine to show
	 */
	private void createLtsGraph(Composite parent, StateMachine machine) {

		Graph graph = new Graph(parent, SWT.NONE);

		int pageIndex = addPage(graph);
		setPageText(pageIndex, "Graph view");

		graph.setNodeStyle(ZestStyles.NODES_NO_ANIMATION);
		graph.getLightweightSystem().setEventDispatcher(
				new SWTEventDispatcher() {
					@Override
					public void dispatchMouseMoved(MouseEvent me) {
						// Do nothing. This disables nodes replacing with mouse.
					}
				});

		// which state is represented with which graph node
		HashMap<State, CGraphNode> map = new HashMap<State, CGraphNode>();
		
		// draw the states
		//TODO: this is just a proof of concept that nodes can be rendered with different images
		ImageFigure figNormalState = new ImageFigure(IMG_NORMAL_STATE);
		figNormalState.setSize(16, 16);
		
		ImageFigure figInitialState = new ImageFigure(IMG_INITIAL_STATE);
		figInitialState.setSize(16, 16);
		
		for (State s : machine.getAllStates()) {
			CGraphNode gNode;
			
			if(machine.getInitialState() == s)
				gNode = new CGraphNode(graph, SWT.NONE, figInitialState);
			else
				gNode = new CGraphNode(graph, SWT.NONE, figNormalState);
			
			gNode.setData(s);
			map.put(s, gNode);
		}
		
		// now connect the states with transitions
		for (Transition t : machine.getAllTransitions()) {
			GraphNode node1 = map.get(t.getSource());
			GraphNode node2 = map.get(t.getTarget());

			if (node1 != null && node2 != null) {
				GraphConnection conn = new GraphConnection(graph,
						ZestStyles.CONNECTIONS_DIRECTED, node1, node2);
				conn.setText(t.getSentence().getLabel());
			}
		}

		TreeLayoutAlgorithm tla = new TreeLayoutAlgorithm(
				LayoutStyles.NO_LAYOUT_NODE_RESIZING);

		tla.setComparator(new Comparator<Object>() {

			@Override
			public int compare(Object node1, Object node2) {
				// We just keep the original order
				return 0;
			}

		});

		graph.setLayoutAlgorithm(tla, true);
	}
}
