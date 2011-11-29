package reprotool.uc.tempeditor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import lts2.AbortState;
import lts2.State;
import lts2.StateMachine;
import lts2.Transition;
import lts2.TransitionalState;
import lts2.impl.LTSGeneratorImpl;

import org.apache.commons.lang.WordUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.SWTEventDispatcher;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.SWT;
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
import org.eclipse.ui.part.Page;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.CGraphNode;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphItem;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;

import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.usecase.Condition;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.annotate.StepAnnotation;


public class LTSContentOutlinePage extends Page implements IContentOutlinePage {
	private GraphViewer viewer;
	private Composite graphParent;
	private FigureProvider figureProvider;
	private UseCase useCase;
	private StateMachine machine;
	
	HashMap<State, GraphNode> state2Node = new HashMap<State, GraphNode>();
	
	/*
	 * List of machines corresponding to the included use cases.
	 */
	private List<StateMachine> includedMachines = new ArrayList<StateMachine>();
	private List<UseCase> includedUseCases = new ArrayList<UseCase>();
	private HashMap<StateMachine, UseCase> machine2UseCase = new HashMap<StateMachine, UseCase>();
	private HashMap<UseCase, StateMachine> useCase2Machine = new HashMap<UseCase, StateMachine>();
	
	private HashMap<UseCaseStep, Transition> ucStep2Trans = null;
	private HashMap<Transition, GraphNode> trans2Node = new HashMap<Transition, GraphNode>();
	private List<Transition> gotoTransitions = null;	
	private HashMap<Transition, GraphConnection> trans2Edge = new HashMap<Transition, GraphConnection>();
	
	public LTSContentOutlinePage(UseCase uc) {
		super();
		useCase = uc;
		figureProvider = new FigureProvider();
		regenerateLTS();
	}
	
	private void generateIncludedMachines(List<UseCase> roots) {
		Queue<UseCase> ucQueue = new LinkedList<UseCase>(roots);
		includedUseCases.clear();
		includedMachines.clear();
		
		machine2UseCase.put(machine, useCase);
		useCase2Machine.put(useCase, machine);
		
		while (!ucQueue.isEmpty()) {
			UseCase u = ucQueue.poll();
			if ((u == null) || (u == useCase)) {
				continue;
			}
			if (!includedUseCases.contains(u)) {
				includedUseCases.add(u);
				LTSGeneratorImpl g = new LTSGeneratorImpl();
				g.processUseCase(u);
				includedMachines.add(g.getLabelTransitionSystem());
				ucQueue.addAll(g.getLtsCache().getIncludedUseCases());
				ucStep2Trans.putAll(g.getLtsCache().getUCStep2Trans());
				gotoTransitions.addAll(g.getLtsCache().getGotoTransitions());
				machine2UseCase.put(g.getLabelTransitionSystem(), u);
				useCase2Machine.put(u, g.getLabelTransitionSystem());
			}
		}
	}
	
	private void regenerateLTS() {
		LTSGeneratorImpl generator = new LTSGeneratorImpl();
		generator.processUseCase(useCase);
		machine = generator.getLabelTransitionSystem();
		ucStep2Trans = generator.getLtsCache().getUCStep2Trans();
		gotoTransitions = generator.getLtsCache().getGotoTransitions();
		generateIncludedMachines(generator.getLtsCache().getIncludedUseCases());
	}
	
	public void handleEditorUCStepSelected(List<UseCaseStep> selection) {
		GraphItem[] items = new GraphItem[selection.size()];
		int i = 0;
		for (UseCaseStep step: selection) {
			Transition t = ucStep2Trans.get(step);
			GraphConnection con = trans2Edge.get(t);
			items[i++] = con;
		}
		try {
			viewer.getGraphControl().setSelection(items);
		} catch (org.eclipse.swt.SWTException e) {
			// Just ignore it...
		}
	}
	
	public void selectStates(List<State> states) {
		Iterator<State> i1 = states.iterator();
		State oldState = i1.next();
		State newState = oldState;
		while (i1.hasNext()) {
			oldState = newState;
			newState = i1.next();
			for (Object obj: viewer.getGraphControl().getConnections()) {
				GraphConnection con = (GraphConnection) obj;
				if (
						(con.getSource() == state2Node.get(oldState)) &&
						(con.getDestination() == state2Node.get(newState))
				) {
					con.setLineColor(ColorConstants.red);
					break;
				}
			}
		}		
	}
	
	public void emfModelChanged() {
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
		ucStep2Trans.clear();
		gotoTransitions.clear();
		trans2Node.clear();
		trans2Edge.clear();
		state2Node.clear();
		machine2UseCase.clear();
		useCase2Machine.clear();
		
		regenerateLTS();
		
		// Create a new graph.
		createLtsGraph(graphParent, machine);
		
		// TODO: saving LTS to file
//		ResourceSet rs = new ResourceSetImpl();
//		URI fileURI = URI.createPlatformResourceURI("repro1/testik.lts", true);
//		Resource resource = rs.createResource(fileURI);
//		resource.getContents().add(machine);
//
//		try {
//			resource.save(null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	private void generateGraphNodes(StateMachine m) {
		figureProvider.setMachine(m);
		for (State s: m.getTransitionalStates()) {
			GraphNode node = new CGraphNode(viewer.getGraphControl(), SWT.NONE,
				figureProvider.getFigure(s));
			node.setData(s);
			state2Node.put(s, node);
		}
		
		State s = m.getInitialState();
		GraphNode node = new CGraphNode(viewer.getGraphControl(), SWT.NONE,
			figureProvider.getFigure(s));
		node.setData(s);
		state2Node.put(s, node);
		
		s = m.getFinalState();
		node = new CGraphNode(viewer.getGraphControl(), SWT.NONE,
			figureProvider.getFigure(s));
		node.setData(s);
		state2Node.put(s, node);
	}
	
	private void processTransition(Transition transition, AbortState abort) {
		if (
				(transition.getRelatedStep() != null) &&
				(transition.getRelatedStep().getAction() instanceof UseCaseInclude)
		) {
			UseCaseInclude inc = (UseCaseInclude) transition.getRelatedStep().getAction();
			UseCase uc = inc.getIncludeTarget();
			if (uc != null) {
				StateMachine mach = useCase2Machine.get(uc);
				Assert.isNotNull(mach);
				State st1 = mach.getInitialState();
				State st2 = mach.getFinalState();
				Assert.isNotNull(st1);
				Assert.isNotNull(st2);
				Assert.isNotNull(state2Node.get(st1));
				Assert.isNotNull(state2Node.get(st2));
				GraphConnection c1 =
					new GraphConnection(viewer.getGraphControl(),
						ZestStyles.CONNECTIONS_DIRECTED, state2Node.get(transition.getSourceState()), state2Node.get(st1));
				GraphConnection c2 =
					new GraphConnection(viewer.getGraphControl(),
						ZestStyles.CONNECTIONS_DIRECTED, state2Node.get(st2), state2Node.get(transition.getTargetState()));
				
				Shape shape = (Shape) c1.getConnectionFigure();
				shape.setAntialias(SWT.ON);
				shape.setLineStyle(SWT.LINE_CUSTOM);
				shape.setLineDash(new float[] {7.0f, 5.0f});
				
				shape = (Shape) c2.getConnectionFigure();
				shape.setAntialias(SWT.ON);
				shape.setLineStyle(SWT.LINE_CUSTOM);
				shape.setLineDash(new float[] {7.0f, 5.0f});
			}
		}
		
		GraphConnection con = null;
		
		if (transition.getTargetState() == abort) {
			GraphNode node = new CGraphNode(viewer.getGraphControl(), SWT.NONE,
					figureProvider.getFigure(abort));
			node.setData(abort);
			trans2Node.put(transition, node);
			con = new GraphConnection(viewer.getGraphControl(), ZestStyles.CONNECTIONS_DIRECTED,
					state2Node.get(transition.getSourceState()), node);
			trans2Edge.put(transition, con);
		} else {
			con = new GraphConnection(viewer.getGraphControl(), ZestStyles.CONNECTIONS_DIRECTED,
						state2Node.get(transition.getSourceState()), state2Node.get(transition.getTargetState()));
			trans2Edge.put(transition, con);
			if (gotoTransitions.contains(transition)) {
				con.setCurveDepth(16);
			}
		}
		
		if (transition.getRelatedStep() != null) {
			IFigure toolTip = new Label();
			

			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("Label: " + transition.getRelatedStep().getLabel());
			stringBuffer.append("\n");
			stringBuffer.append("Text: " + WordUtils.wrap( transition.getRelatedStep().getContent(), 40) );
			
			List<StepAnnotation> annots = transition.getRelatedStep().getAnnotations();
			if (!annots.isEmpty()) {
				con.setImage(figureProvider.getStarImage());
				stringBuffer.append("\n");
				stringBuffer.append("Annots: ");
				int c = 0;
				for (StepAnnotation a : annots) {
					c++;
					stringBuffer.append(a.getAnnotationType().getName() + "_" + a.getId());
					if (c < annots.size()) {
						stringBuffer.append(", ");
					}
				}
			}
			
			Scenario scenario = (Scenario) transition.getRelatedStep().eContainer();
			EList<Condition> preconditions = scenario.getPreconditions();
			if (!preconditions.isEmpty()) {
				stringBuffer.append("\n");
				stringBuffer.append("Cond: " + preconditions.get(0).getContent());
			}
			((Label) toolTip).setText(stringBuffer.toString());
			con.setTooltip(toolTip);
		}
	}
	
	private void generateGraphEdges(StateMachine m) {
		figureProvider.setMachine(m);
		for (Transition t: m.getInitialState().getTransitions()) {
			processTransition(t, m.getAbortState());
		}
		
		for (TransitionalState tState: m.getTransitionalStates()) {
			for (Transition t: tState.getTransitions()) {
				processTransition(t, m.getAbortState());
			}
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
		viewer.getGraphControl().getLightweightSystem().setEventDispatcher(
				new SWTEventDispatcher() {
					@Override
					public void dispatchMouseMoved(org.eclipse.swt.events.MouseEvent me) {
						// Do nothing. This disables nodes replacing with mouse.
					}
				}
		);
		
		// Firstly we need to generate all nodes
		generateGraphNodes(machine);
		for (StateMachine m: includedMachines) {
			generateGraphNodes(m);
		}
		
		// Only after nodes are ready we can create edges.
		generateGraphEdges(machine);
		for (StateMachine m: includedMachines) {
			generateGraphEdges(m);
		}

		includedMachines.add(0, machine);

		// layout algorithm
		LayoutAlgorithm ltsLayout = new LTSLayoutAlgorithm(trans2Node,
			ucStep2Trans, includedMachines, machine2UseCase, useCase2Machine);
		
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
				
				if (selected == null) {
					return;
				}
			        
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
				if (e.button == 1) {
					viewer.getGraphControl().setSelection(null);
				}
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
}