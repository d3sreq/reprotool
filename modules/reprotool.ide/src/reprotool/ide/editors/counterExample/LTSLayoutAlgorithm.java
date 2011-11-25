package reprotool.ide.editors.counterExample;

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
	private int nextStart;
	
	private Scenario mainScenario;
	private State initialState;
	private Set<State> abortStates = new HashSet<State>();
	
	private HashMap<Integer, Integer> occupiedCols = new HashMap<Integer, Integer>();
	private HashMap<State, InternalNode> state2Node = new HashMap<State, InternalNode>();
	private HashMap<Transition, GraphNode> trans2Node = new HashMap<Transition, GraphNode>();
	private HashMap<UseCaseStep, Transition> ucStep2Trans = new HashMap<UseCaseStep, Transition>();
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
	
	private List<LTSGraphBox> ltsParams;
	
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
		return state2Node.get(ucStep2Trans.get(step).getTargetState());
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
	
	private int findFreeColumn(int row, int size, SpanDirection dir) {
		int col = 0;
		int nextCol = stepForward(col, dir);
		
		if (row == -1) {
			return nextCol;
		}
		
		while (
				occupiedCols.containsKey(nextCol) && 
				((row - size) < occupiedCols.get(nextCol))
		) {
			nextCol = stepForward(nextCol, dir);
		}
		
		return nextCol;
	}
	
	/*
	 * Goto steps do not use their own graph nodes - they should
	 * not be counted to the scenario graphics size.
	 */
	private int countEffectiveSize(Scenario s) {
		if ((s == null) || s.getSteps().isEmpty()) {
			return 0;
		}
		UseCaseStep lastStep = s.getSteps().get(s.getSteps().size() - 1);
		if (lastStep.getAction() instanceof Goto) {
			return s.getSteps().size() - 1;
		}
		
		return s.getSteps().size();
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
		
		int c = -1;
		for (int i = s.getSteps().size() - 1; i >= 0; --i) {
			UseCaseStep step = s.getSteps().get(i);
			
			if (step.getAction() instanceof Goto) {
				continue;
			}
			
			InternalNode node = findMappedNode(step);
			
			if (step.getAction() instanceof AbortUseCase) {
				Transition t = ucStep2Trans.get(step);
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
				for (Scenario scenario: step.getExtensions()) {
					int k = findFreeColumn(c, countEffectiveSize(scenario), extensionSpan);
					int xx = k;
					occupiedCols.put(k, c);
					processScenario(scenario, xx, yy, extensionSpan);
				}
			}
			
			y--;
			c++;
			
			if (!step.getVariations().isEmpty()) {
				int yy = y + 1;
				for (Scenario scenario: step.getVariations()) {
					int k = findFreeColumn(c, countEffectiveSize(scenario), variationSpan);
					int xx = k;
					occupiedCols.put(k, c);
					processScenario(scenario, xx, yy, variationSpan);
				}
			}
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
	
	private int freeStartingPosition(int y0) {		
		while (!isFreePosition(0, y0)) {
			y0++;
		}
		
		return y0;
	}
	
	private void processInitialState() {
		InternalNode node = state2Node.get(initialState);
		Assert.isNotNull(initialState);
		Assert.isNotNull(node);
		internal2Board.get(node).setLocation(0, 0);
	}
	
	public LTSLayoutAlgorithm(List<LTSGraphBox> ltsParams) {
		super(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		this.ltsParams = ltsParams;
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
		nextStart = 0;
		for (LTSGraphBox box: ltsParams) {
			for (StateMachine mach: box.getIncludedMachines()) {
				abortStates.add(mach.getAbortState());
			}
		}
		
		initMapping(entitiesToLayout);
		verticalLineSize = (int) (entitiesToLayout[0].getLayoutEntity().getHeightInLayout() + verSpacing);
		rootPos = new Point((int) boundsWidth / 2, (int) verSpacing / 2);
		
		for (LTSGraphBox box: ltsParams) {
			includeTargets.clear();
			drawnMachines.clear();
			occupiedCols.clear();
			
			this.ucStep2Trans = box.getUcStep2Trans();
			this.trans2Node = box.getTrans2Node();
			this.includedMachines = box.getIncludedMachines();
			this.machine2UseCase = box.getMachine2UseCase();
			this.useCase2Machine = box.getUseCase2Machine();
			
			workingMachine = includedMachines.remove(0);
			this.initialState = workingMachine.getInitialState();
			UseCase u = machine2UseCase.get(workingMachine);
			includeTargets.add(workingMachine);
			mainScenario = u.getMainScenario();

			processInitialState();
			processScenario(mainScenario, 0, 1, SpanDirection.BOTH);
			int y0 = freeStartingPosition(nextStart);
			layoutBoard(0, y0);
			nextStart = y0 + countEffectiveSize(mainScenario) + 1;
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