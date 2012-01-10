package reprotool.ide.editors.usecase;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;
import org.eclipse.zest.layouts.dataStructures.InternalNode;
import org.eclipse.zest.layouts.dataStructures.InternalRelationship;

import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

import lts2.State;
import lts2.StateMachine;
import lts2.Transition;


public class LTSLayoutAlgorithm extends AbstractLayoutAlgorithm {
	private double verSpacing = 30;
	private double horSpacing = 80;
	private int verticalLineSize;
	private Point rootPos;
	
	private Scenario mainScenario;
	private State initialState;
	private Set<State> abortStates = new HashSet<State>();
	
	private HashMap<Integer, Set<Integer>> occupiedCols = new HashMap<Integer, Set<Integer>>();
	private HashMap<State, InternalNode> state2Node = new HashMap<State, InternalNode>();
	private HashMap<Transition, GraphNode> trans2Node = new HashMap<Transition, GraphNode>();
	private HashMap<UseCaseStep, Transition> ucStep2TransLayout = new HashMap<UseCaseStep, Transition>();
	private HashMap<UseCaseStep, Transition> ucStep2TransOriginal = new HashMap<UseCaseStep, Transition>();
	private HashMap<GraphNode, InternalNode> graph2Internal = new HashMap<GraphNode, InternalNode>();
	
	private StateMachine workingMachine;
	private List<StateMachine> includedMachines;
	private List<StateMachine> includeTargets = new ArrayList<StateMachine>();
	private HashMap<StateMachine, UseCase> machine2UseCase;
	private HashMap<UseCase, StateMachine> useCase2Machine;
	
	private List<BoardNode> boardNodes = new ArrayList<BoardNode>();
	private HashMap<InternalNode, BoardNode> internal2Board = new HashMap<InternalNode, BoardNode>();
	private List<MachineInclude> ltsIncludes = new ArrayList<MachineInclude>();
	private List<Point> occupiedPositions = new ArrayList<Point>();
	private List<StateMachine> drawnMachines = new ArrayList<StateMachine>();
	
	private void initMapping(InternalNode[] entitiesToLayout) {
		for (InternalNode node: entitiesToLayout) {
			BoardNode bNode = new BoardNode(node);
			boardNodes.add(bNode);
			internal2Board.put(node, bNode);
			
			GraphNode gNode = (GraphNode) node.getLayoutEntity().getGraphData();
			State s = (State) gNode.getData();
			if (abortStates.contains(s)) {
				graph2Internal.put(gNode, node);
			} else {
				state2Node.put(s, node);
			}
		}
	}
	
	private InternalNode findMappedNode(UseCaseStep step) {
		return state2Node.get(ucStep2TransLayout.get(step).getTargetState());
	}
	
	private int stepForward(int pos, SpanDirection dir) {
		switch (dir) {
		case LEFT:
			return (pos - 1);
		case RIGHT:
			return (pos + 1);
		}
		
		throw new RuntimeException("API misuse");
	}
	
	private boolean isFreeColumn(int column, int y, int size) {
		boolean found = false;
		
		Set<Integer> col = occupiedCols.get(column);
		if ((col == null) || (col.isEmpty())) {
			return true;
		}
		
		for (int c = 0; c < size; c++) {
			if (col.contains(y + c)) {
				found = true;
				break;
			}
		}
		
		return (!found);
	}
	
	private int findFreeColumn(int x0, int y0, int size, SpanDirection dir) {
		int col = x0;
		
		while ((col == 0) || (!isFreeColumn(col, y0, size))) {
			col = stepForward(col, dir);
		}
		
		return col;
	}
	
	/*
	 * Goto steps do not use their own graph nodes - they should
	 * not be counted to the scenario graphics size.
	 */
	private int countEffectiveSize(Scenario s) {
		if ((s == null) || s.getSteps().isEmpty()) {
			return 0;
		}
		
		int prolong = 0; 
		
		for (UseCaseStep step: s.getSteps()) {
			
			for (Scenario ext: step.getExtensions()) {
				UseCaseStep lastExtStep = ext.getSteps().get(ext.getSteps().size() - 1);
				if (
						(!(lastExtStep.getAction() instanceof Goto)) &&
						(!(lastExtStep.getAction() instanceof AbortUseCase))
				) {
					prolong++;
					break;
				}
			}
		}
		
		UseCaseStep lastStep = s.getSteps().get(s.getSteps().size() - 1);
		if (lastStep.getAction() instanceof Goto) {
			return s.getSteps().size() - 1 + prolong;
		}
		
		return s.getSteps().size() + prolong;
	}
	
	private void processScenario(Scenario s, int x0, int y0, SpanDirection span) {
		if (s == null) {
			return;
		}
		
		int x = x0;
		int y = y0 + (countEffectiveSize(s) - 1);
		
		SpanDirection extensionSpan = span;
		SpanDirection variationSpan = span;
		
		if (span == SpanDirection.BOTH) {
			extensionSpan = SpanDirection.RIGHT;
			variationSpan = SpanDirection.LEFT;
		}
		
		State prediction = null;
		for (int i = s.getSteps().size() - 1; i >= 0; --i) {
			UseCaseStep step = s.getSteps().get(i);
						
			if (step.getAction() instanceof Goto) {
				continue;
			}
			
			InternalNode node = findMappedNode(step);
			
			if ((prediction != null)) {
				InternalNode missing = state2Node.get(prediction);
				Assert.isNotNull(missing);
				internal2Board.get(missing).setLocation(x, y);
				y--;
			}
			
			if (ucStep2TransLayout.get(step) != ucStep2TransOriginal.get(step)) {
				prediction = ucStep2TransLayout.get(step).getSourceState();
			} else {
				prediction = null;
			}
			
			if (step.getAction() instanceof AbortUseCase) {
				Transition t = ucStep2TransOriginal.get(step);
				Assert.isNotNull(t);
				GraphNode gNode = trans2Node.get(t);
				Assert.isNotNull(gNode);
				node = graph2Internal.get(gNode);
				Assert.isNotNull(node);
			}
			
			if (step.getAction() instanceof UseCaseInclude) {
				UseCase uc = ((UseCaseInclude) step.getAction()).getIncludeTarget();
				StateMachine m = useCase2Machine.get(uc);
				if (!includeTargets.contains(m)) {
					ltsIncludes.add(new MachineInclude(x, y, workingMachine, m));
					includeTargets.add(m);
				}
			}
			
			internal2Board.get(node).setLocation(x, y);
			
			if (!step.getExtensions().isEmpty()) {
				int yy = y + 1;
				for (Scenario sc: step.getExtensions()) {
					UseCaseStep lStep = sc.getSteps().get(sc.getSteps().size() - 1);
					if (
							(!(lStep.getAction() instanceof Goto)) &&
							(!(lStep.getAction() instanceof AbortUseCase))
						) {
						yy--;
						break;
					}
				}
				for (Scenario scenario: step.getExtensions()) {
					int xx = findFreeColumn(x0, yy, countEffectiveSize(scenario), extensionSpan);					
					occupyColumns(scenario, xx, yy);
					processScenario(scenario, xx, yy, extensionSpan);
				}
			}
			
			y--;
			
			if (!step.getVariations().isEmpty()) {
				int yy = y + 1;
				for (Scenario sc: step.getExtensions()) {
					UseCaseStep lStep = sc.getSteps().get(sc.getSteps().size() - 1);
					if (
							(!(lStep.getAction() instanceof Goto)) &&
							(!(lStep.getAction() instanceof AbortUseCase))
						) {
						yy--;
						break;
					}
				}
				for (Scenario scenario: step.getVariations()) {
					int xx = findFreeColumn(x0, yy, countEffectiveSize(scenario), variationSpan);
					occupyColumns(scenario, xx, yy);
					processScenario(scenario, xx, yy, variationSpan);
				}
			}
		}
		
		if ((prediction != null)) {
			InternalNode missing = state2Node.get(prediction);
			Assert.isNotNull(missing);
			internal2Board.get(missing).setLocation(x, y);
		}
	}
	
	private void occupyColumns(Scenario s, int x0, int y0) {
		Set<Integer> col = null;
		col = occupiedCols.get(x0);
		if (col == null) {
			col = new HashSet<Integer>();
			occupiedCols.put(x0, col);
		}
		
		int c = 0;

		for (UseCaseStep step: s.getSteps()) {
			col.add(y0 + c);
			if (!step.getExtensions().isEmpty()) {
				c++;
				col.add(y0 + c);
			}
			c++;
		}
	}
	
	private boolean stateIsActive(State s) {
		if (workingMachine == null) {
			return false;
		}
		return (
			workingMachine.getTransitionalStates().contains(s)	||
			(workingMachine.getInitialState() == s)				||
			(workingMachine.getFinalState() == s)				||
			(workingMachine.getAbortState() == s)
		);
	}
	
	private void layoutBoard(int x, int y) {
		for (BoardNode bNode: boardNodes) {
			InternalNode node = bNode.getNode();
			GraphNode gNode = (GraphNode) node.getLayoutEntity().getGraphData();
			State s = (State) gNode.getData();
			
			if (!stateIsActive(s)) {
				continue;
			}
			
			Assert.isNotNull(s);
			node.setLocation(rootPos.getX() + ((x + bNode.getX()) * horSpacing),
				rootPos.getY() + ((y + bNode.getY()) * verticalLineSize));
			occupiedPositions.add(new Point(x + bNode.getX(), y + bNode.getY()));
		}
		
		for (MachineInclude mi: ltsIncludes) {
			if (mi.getOrigin() == workingMachine) {
				mi.setLocation(mi.getX() + x, mi.getY() + y);
			}
		}
	}
	
	boolean isFreePosition(int x, int y) {
		for (BoardNode bNode: boardNodes) {
			InternalNode node = bNode.getNode();
			GraphNode gNode = (GraphNode) node.getLayoutEntity().getGraphData();
			State s = (State) gNode.getData();
			
			if (!stateIsActive(s)) {
				continue;
			}
						
			if (occupiedPositions.contains(new Point(x + bNode.getX(), y + bNode.getY()))) {
				return false;
			}
		}
		
		return true;
	}
	
	private Point findFreePosition(int x, int y) {		
		Point leftTop = new Point(x - 1, y - 1);
		Point rightTop = new Point(x + 1, y - 1);
		Point leftDown = new Point(x - 1, y + 1);
		Point rightDown = new Point(x + 1, y + 1);
		
		do {
			// Check the top line.
			for (int ix = (int) leftTop.getX(); ix <= rightTop.getX(); ix++) {
				if (isFreePosition(ix, (int) leftTop.getY())) {
					return new Point(ix, (int) leftTop.getY());
				}
			}
			
			// Check the right side line
			for (int iy = (int) rightTop.getY(); iy <= rightDown.getY(); iy++) {
				if (isFreePosition((int) rightTop.getX(), iy)) {
					return new Point((int) rightTop.getX(), iy);
				}
			}
			
			// Check the bottom line.
			for (int ix = (int) leftDown.getX(); ix <= rightDown.getX(); ix++) {
				if (isFreePosition(ix, (int) leftDown.getY())) {
					return new Point(ix, (int) leftDown.getY());
				}
			}
			
			// Check the left side line
			for (int iy = (int) leftTop.getY(); iy <= leftDown.getY(); iy++) {
				if (isFreePosition((int) leftTop.getX(), iy)) {
					return new Point((int) leftTop.getX(), iy);
				}
			}
						
			leftTop.setLocation(leftTop.getX() - 1, leftTop.getY() - 1);
			rightTop.setLocation(rightTop.getX() + 1, rightTop.getY() - 1);
			leftDown.setLocation(leftDown.getX() - 1, leftDown.getY() + 1);
			rightDown.setLocation(rightDown.getX() + 1, rightDown.getY() + 1);
		} while (true);
		
	}
	
	private void processInitialState() {
		InternalNode node = state2Node.get(initialState);
		Assert.isNotNull(initialState);
		Assert.isNotNull(node);
		internal2Board.get(node).setLocation(0, 0);
	}
	
	public LTSLayoutAlgorithm(HashMap<Transition, GraphNode> trans2Node,
			HashMap<UseCaseStep, Transition> ucStep2TransLayout,
			HashMap<UseCaseStep, Transition> ucStep2TransOriginal,
			List<StateMachine> includedMachines,
			HashMap<StateMachine, UseCase> machine2UseCase,
			HashMap<UseCase, StateMachine> useCase2Machine)
	{
		super(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		
		workingMachine = includedMachines.remove(0);
		UseCase u = machine2UseCase.get(workingMachine);
		
		includeTargets.add(workingMachine);
		mainScenario = u.getMainScenario();
		this.ucStep2TransLayout = ucStep2TransLayout;
		this.ucStep2TransOriginal = ucStep2TransOriginal;
		this.trans2Node = trans2Node;
		this.initialState = workingMachine.getInitialState();
		this.includedMachines = includedMachines;
		this.machine2UseCase = machine2UseCase;
		this.useCase2Machine = useCase2Machine;
		abortStates.add(workingMachine.getAbortState());
				
		for (StateMachine mach: includedMachines) {
			abortStates.add(mach.getAbortState());
		}
	}

	@Override
	public void setLayoutArea(double x, double y, double width, double height) {
	}

	@Override
	protected boolean isValidConfiguration(boolean asynchronous,
			boolean continuous) {
		return true;
	}

	@Override
	protected void applyLayoutInternal(InternalNode[] entitiesToLayout,
			InternalRelationship[] relationshipsToConsider, double boundsX,
			double boundsY, double boundsWidth, double boundsHeight)
	{	
		initMapping(entitiesToLayout);
		verticalLineSize = (int) (entitiesToLayout[0].getLayoutEntity().getHeightInLayout() + verSpacing);
		rootPos = new Point((int) boundsWidth / 2, (int) verSpacing / 2);
		
		processInitialState();
		processScenario(mainScenario, 0, 1, SpanDirection.BOTH);
		layoutBoard(0, 0);
		drawnMachines.add(workingMachine);
		
		for (StateMachine m: includedMachines) {
			workingMachine = m;
			occupiedCols.clear();
			initialState = workingMachine.getInitialState();
			processInitialState();
			processScenario(machine2UseCase.get(workingMachine).getMainScenario(), 0,
					1 , SpanDirection.BOTH);
		}
				
		while (!ltsIncludes.isEmpty()) {
			MachineInclude t = null;
			
			for (MachineInclude mi: ltsIncludes) {
				if (drawnMachines.contains(mi.getOrigin())) {
					t = mi;
					workingMachine = mi.getMachine();
					Point pos = findFreePosition(mi.getX(), mi.getY());
					layoutBoard((int) pos.getX(), (int) pos.getY());	
					drawnMachines.add(workingMachine);
					break;
				}
			}
			
			if (t != null) {
				ltsIncludes.remove(t);
			}
		}
	}

	@Override
	protected void preLayoutAlgorithm(InternalNode[] entitiesToLayout,
			InternalRelationship[] relationshipsToConsider, double x, double y,
			double width, double height) {
	}

	@Override
	protected void postLayoutAlgorithm(InternalNode[] entitiesToLayout,
			InternalRelationship[] relationshipsToConsider) {
	}

	@Override
	protected int getTotalNumberOfLayoutSteps() {
		return 0;
	}

	@Override
	protected int getCurrentLayoutStep() {
		return 0;
	}

}

enum SpanDirection {
	LEFT, RIGHT, BOTH
}

class BoardNode {
	private int x;
	private int y;
	private InternalNode node;
	
	public BoardNode(InternalNode node) {
		this.node = node;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public InternalNode getNode() {
		return node;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class MachineInclude {
	private int x;
	private int y;
	private StateMachine m;
	private StateMachine origin;
	
	MachineInclude(int x, int y, StateMachine origin, StateMachine m) {
		this.x = x;
		this.y = y;
		this.m = m;
		this.origin = origin;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
	
	void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	StateMachine getMachine() {
		return m;
	}
	
	StateMachine getOrigin() {
		return origin;
	}
}