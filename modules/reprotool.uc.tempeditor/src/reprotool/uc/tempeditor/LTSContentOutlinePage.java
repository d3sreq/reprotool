package reprotool.uc.tempeditor;

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.part.Page;

import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.CGraphNode;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.swt.SWT;

import reprotool.model.lts.State;
import reprotool.model.lts.StateMachine;
import reprotool.model.lts.Transition;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;


public class LTSContentOutlinePage extends Page implements IContentOutlinePage {
	
	private GraphViewer viewer;
	private Composite graphParent;
	private FigureProvider figureProvider;
	private Scenario mainScenario;
	private StateMachine machine;
	private HashMap<UseCaseStep, State> ucStep2State = null;
	
	private LTSContentViewer contentViewer;
	private AdapterFactory adapterFactory;
	
	LTSContentOutlinePage(Scenario s, AdapterFactory aFactory) {
		super();
		mainScenario = s;
		adapterFactory = aFactory;
		figureProvider = new FigureProvider();
		regenerateLTS();
	}
	
	private void regenerateLTS() {
		LTSGenerator generator = new LTSGenerator(mainScenario);
		machine = generator.getLabelTransitionSystem();
		figureProvider.setMachine(machine);
		ucStep2State = generator.getUCStep2StateMap();
	}
	
	private void emfModelChanged() {
		// Remove the old graph.
		while (viewer.getGraphControl().getNodes().size() > 0) {
			GraphNode node = (GraphNode) viewer.getGraphControl().getNodes().get(0);
			if (node != null && !node.isDisposed()) {
				node.dispose();
			}
		}
		while (viewer.getGraphControl().getConnections().size() > 0) {
			GraphConnection connection = (GraphConnection) viewer.getGraphControl().getConnections().get(0);
			if (connection != null && !connection.isDisposed()) {
				connection.dispose();
			}
		}
		ucStep2State.clear();
		
		regenerateLTS();
		
		// Create a new graph.
		createLtsGraph(graphParent, machine);
		
		// TODO: saving LTS to file
		ResourceSet rs = new ResourceSetImpl();
		URI fileURI = URI.createPlatformResourceURI("Test6/testik.lts", true);
		Resource resource = rs.createResource(fileURI);
		resource.getContents().add(machine);

		try {
			resource.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @param graphParent
	 *            Where to paint the graph
	 * @param machine
	 *            Which StateMachine to show
	 */
	private void createLtsGraph(final Composite graphParent, StateMachine machine) {
		
		// Create a new graph
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		viewer.getGraphControl().getLightweightSystem().setEventDispatcher(
				new SWTEventDispatcher() {
					@Override
					public void dispatchMouseMoved(org.eclipse.swt.events.MouseEvent me) {
						// Do nothing. This disables nodes replacing with mouse.
					}
				}
		);
		
		HashMap<State, GraphNode> state2Node = new HashMap<State, GraphNode>();
		
		for (State s: machine.getAllStates()) {
			GraphNode node = new CGraphNode(viewer.getGraphControl(), SWT.NONE,
				figureProvider.getFigure(s));
			node.setData(s);
			state2Node.put(s, node);
		}
		
		for (Transition t: machine.getAllTransitions()) {
			new GraphConnection(viewer.getGraphControl(), ZestStyles.CONNECTIONS_DIRECTED,
					state2Node.get(t.getSource()), state2Node.get(t.getTarget()));
		}

		// layout algorithm
		LayoutAlgorithm ltsLayout = new LTSLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING,
				mainScenario, ucStep2State, machine.getInitialState());
		viewer.setLayoutAlgorithm(ltsLayout, false);
		
		viewer.getGraphControl().setNodeStyle(ZestStyles.NODES_NO_ANIMATION);
		viewer.applyLayout();

		// popup menu
		final Menu menu = new Menu(graphParent);
		MenuItem saveItem = new MenuItem(menu, SWT.PUSH);
		saveItem.setText("save image");
		
		saveItem.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell s = graphParent.getShell();
				FileDialog fd = new FileDialog(s, SWT.SAVE);
				fd.setFilterExtensions(new String[] {"*.png"});
				fd.setText("Save");
				String selected = fd.open();
			        
				Graph g = viewer.getGraphControl();
				Point size = new Point(g.getContents().getSize().width, g.getContents().getSize().height);
				final Image image = new Image(null, size.x, size.y);
				GC gc = new GC(image);
				SWTGraphics swtGraphics = new SWTGraphics(gc);
				g.getViewport().paint(swtGraphics);
				gc.dispose();

				ImageLoader loader = new ImageLoader();
				loader.data = new ImageData[] {image.getImageData()};
				loader.save(selected, SWT.IMAGE_PNG);
			}
			
		});
		
		viewer.getGraphControl().addMouseListener(new MouseAdapter() {
			
			public void mouseDown(MouseEvent e) {
				if (e.button == 3) {
					menu.setVisible(true);
				}
			}
			
		});
	}
	
	@Override
	public void createControl(Composite parent) {
		graphParent = parent;
		viewer = new GraphViewer(graphParent, SWT.NONE);
		createLtsGraph(parent, machine);
		contentViewer = new LTSContentViewer(parent);
		contentViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		contentViewer.setInput(null);
	}

	@Override
	public void dispose() {
	}

	@Override
	public Control getControl() {
		return viewer.getControl();
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
	}

	@Override
	public ISelection getSelection() {
		return null;
	}

	@Override
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
	}

	@Override
	public void setSelection(ISelection selection) {
	}
	
	class LTSContentViewer extends ContentViewer {
		private Control control;
		
		public LTSContentViewer(Control c) {
			control = c;
		}

		@Override
		public Control getControl() {
			return control;
		}

		@Override
		public ISelection getSelection() {
			return null;
		}

		@Override
		public void refresh() {
			emfModelChanged();
		}

		@Override
		public void setSelection(ISelection selection, boolean reveal) {
			// Do nothing
		}
		
	}

}
