package reprotool.uc.tempeditor;

import java.awt.Point;
import java.util.HashMap;

import org.eclipse.core.runtime.Assert;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;
import org.eclipse.zest.layouts.dataStructures.InternalNode;
import org.eclipse.zest.layouts.dataStructures.InternalRelationship;

import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.lts.State;
import reprotool.model.lts.Transition;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;


public class LTSLayoutAlgorithm extends AbstractLayoutAlgorithm {
	private double verSpacing = 30;
	private double horSpacing = 80;
	private int verticalLineSize;
	
	private Point rootPos = new Point();

	private Scenario mainScenario;
	private State initialState;
	private State abortState;
	
	private HashMap<Integer, Integer> occupiedCols = new HashMap<Integer, Integer>();
	private HashMap<State, InternalNode> state2Node = new HashMap<State, InternalNode>();
	private HashMap<Transition, GraphNode> trans2Node = new HashMap<Transition, GraphNode>();
	private HashMap<UseCaseStep, Transition> ucStep2Trans = new HashMap<UseCaseStep, Transition>();
	private HashMap<GraphNode, InternalNode> graph2Internal = new HashMap<GraphNode, InternalNode>();
	
	private void initMapping(InternalNode[] entitiesToLayout) {
		for (InternalNode node: entitiesToLayout) {
			GraphNode gNode = (GraphNode) node.getLayoutEntity().getGraphData();
			State s = (State) gNode.getData();
			if (s == abortState) {
				graph2Internal.put(gNode, node);
			} else {
				state2Node.put(s, node);
			}
		}
	}
	
	private InternalNode findMappedNode(UseCaseStep step) {
		return state2Node.get(ucStep2Trans.get(step).getTarget());
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
		if (s.getSteps().isEmpty()) {
			return 0;
		}
		UseCaseStep lastStep = s.getSteps().get(s.getSteps().size() - 1);
		if (lastStep.getAction() instanceof Goto) {
			return s.getSteps().size() - 1;
		}
		
		return s.getSteps().size();
	}
	
	private void layoutScenario(Scenario s, double x0, double y0, SpanDirection span) {
		double x = x0;
		double y = y0 + (countEffectiveSize(s) - 1) * verticalLineSize;
		double extensionStep = 0;
		double variationStep = 0;
		
		SpanDirection extensionSpan = span;
		SpanDirection variationSpan = span;
		extensionStep = horSpacing;
		variationStep = horSpacing;
		
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
			
			node.setLocation(x, y);
						
			if (!step.getExtensions().isEmpty()) {
				double yy = y + verticalLineSize;
				for (Scenario scenario: step.getExtensions()) {
					int k = findFreeColumn(c, scenario.getSteps().size(), extensionSpan);
					double xx = rootPos.getX() + (extensionStep * k);
					occupiedCols.put(k, c);
					layoutScenario(scenario, xx, yy, extensionSpan);
					k = stepForward(k, extensionSpan);
				}
			}
			
			y -= verticalLineSize;
			c++;
			
			if (!step.getVariations().isEmpty()) {
				double yy = y + verticalLineSize;
				for (Scenario scenario: step.getVariations()) {
					int k = findFreeColumn(c, scenario.getSteps().size(), variationSpan);
					double xx = rootPos.getX() + (variationStep * k);
					occupiedCols.put(k, c);
					layoutScenario(scenario, xx, yy, variationSpan);
					k = stepForward(k, variationSpan);
					xx += variationStep;
				}
			}
		}
	}
	
	private void layoutInitialState() {
		InternalNode node = state2Node.get(initialState);
		node.setLocation(rootPos.getX(), rootPos.getY());
	}
	
	public LTSLayoutAlgorithm(int styles, Scenario s, HashMap<Transition, GraphNode> trans2Node,
			HashMap<UseCaseStep, Transition> ucStep2Trans,
			State initialState, State abortState) {
		super(styles);
		mainScenario = s;
		this.ucStep2Trans = ucStep2Trans;
		this.trans2Node = trans2Node;
		this.initialState = initialState;
		this.abortState = abortState;
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
			double boundsY, double boundsWidth, double boundsHeight) {
		
		initMapping(entitiesToLayout);
		verticalLineSize = (int) (entitiesToLayout[0].getLayoutEntity().getHeightInLayout() + verSpacing);
		
		rootPos.setLocation(boundsWidth / 2, verSpacing / 2);
		layoutInitialState();
		layoutScenario(mainScenario, rootPos.getX(),
				rootPos.getY() + verticalLineSize, SpanDirection.BOTH);
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