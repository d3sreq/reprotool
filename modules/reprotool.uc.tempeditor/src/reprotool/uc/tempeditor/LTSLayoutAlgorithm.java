package reprotool.uc.tempeditor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
	
	private HashMap<Integer, Integer> occupiedCols = new HashMap<Integer, Integer>();
	private HashMap<State, InternalNode> state2Node = new HashMap<State, InternalNode>();
	private HashMap<Transition, GraphNode> trans2Node = new HashMap<Transition, GraphNode>();
	private HashMap<UseCaseStep, Transition> ucStep2Trans = new HashMap<UseCaseStep, Transition>();
	private HashMap<GraphNode, InternalNode> graph2Internal = new HashMap<GraphNode, InternalNode>();
	
	private StateMachine workingMachine;
	private List<StateMachine> includedMachines;
	private HashMap<StateMachine, UseCase> machine2UseCase;
	private HashMap<UseCase, StateMachine> useCase2Machine;
	
	private List<BoardNode> boardNodes = new ArrayList<BoardNode>();
	private HashMap<InternalNode, BoardNode> internal2Board = new HashMap<InternalNode, BoardNode>();
	private Queue<MachineInclude> ltsIncludes = new LinkedList<MachineInclude>();
	
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
				ltsIncludes.add(new MachineInclude(x, y, useCase2Machine.get(uc)));
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
			System.out.println("Node [" + bNode.getX() + ", " + bNode.getY()+ "] found");
			node.setLocation(rootPos.getX() + ((x + bNode.getX()) * horSpacing),
				rootPos.getY() + ((y + bNode.getY()) * verticalLineSize));
		}
	}
	
	private void processInitialState() {
		InternalNode node = state2Node.get(initialState);
		Assert.isNotNull(initialState);
		Assert.isNotNull(node);
		internal2Board.get(node).setLocation(0, 0);
	}
	
	public LTSLayoutAlgorithm(HashMap<Transition, GraphNode> trans2Node,
			HashMap<UseCaseStep, Transition> ucStep2Trans,
			List<StateMachine> includedMachines,
			HashMap<StateMachine, UseCase> machine2UseCase,
			HashMap<UseCase, StateMachine> useCase2Machine)
	{
		super(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		
		workingMachine = includedMachines.remove(0);
		UseCase u = machine2UseCase.get(workingMachine);
		
		mainScenario = u.getMainScenario();
		this.ucStep2Trans = ucStep2Trans;
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
		
		for (StateMachine m: includedMachines) {
			workingMachine = m;
			occupiedCols.clear();
			initialState = workingMachine.getInitialState();
			processInitialState();
			processScenario(machine2UseCase.get(workingMachine).getMainScenario(), 0,
					1 , SpanDirection.BOTH);
		}
		
		while (!ltsIncludes.isEmpty()) {
			MachineInclude mi = ltsIncludes.poll();
			workingMachine = mi.getMachine();
			layoutBoard(mi.getX() + 2, mi.getY());
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
	
	MachineInclude(int x, int y, StateMachine m) {
		this.x = x;
		this.y = y;
		this.m = m;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
	
	StateMachine getMachine() {
		return m;
	}
}