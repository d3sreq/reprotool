package reprotool.uc.tempeditor;

import java.awt.Point;
import java.util.HashMap;

import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.layouts.algorithms.AbstractLayoutAlgorithm;
import org.eclipse.zest.layouts.dataStructures.InternalNode;
import org.eclipse.zest.layouts.dataStructures.InternalRelationship;

import reprotool.model.linguistic.action.Goto;
import reprotool.model.lts.State;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;


public class LTSLayoutAlgorithm extends AbstractLayoutAlgorithm {
	private double verSpacing = 30;
	private double horSpacing = 80;
	
	private Point rootPos = new Point();

	private Scenario mainScenario;
	private State initialState;
	
	private HashMap<UseCaseStep, State> ucStep2State;
	private HashMap<State, InternalNode> state2Node = new HashMap<State, InternalNode>();
	private HashMap<Integer, Integer> occupiedCols = new HashMap<Integer, Integer>();
	private int verticalLineSize;
	
	private void initMapping(InternalNode[] entitiesToLayout) {
		for (InternalNode node: entitiesToLayout) {
			GraphNode gNode = (GraphNode) node.getLayoutEntity().getGraphData();
			State s = (State) gNode.getData();
			state2Node.put(s, node);
		}
	}
	
	private InternalNode findMappedNode(UseCaseStep step) {
		return state2Node.get(ucStep2State.get(step));
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
			node.setLocation(x, y);
						
			if (!step.getExtensions().isEmpty()) {
				double yy = y + verticalLineSize;
				for (Scenario scenario: step.getExtensions()) {
					
					int k = findFreeColumn(c, scenario.getSteps().size(), extensionSpan);
					double xx = rootPos.getX() + (extensionStep * k);
					occupiedCols.put(k, c);
					layoutScenario(scenario, xx, yy, extensionSpan);
					k = stepForward(k, extensionSpan);
					xx += extensionStep;
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
	
	public LTSLayoutAlgorithm(int styles, Scenario s, HashMap<UseCaseStep, State> map,
			State initialState) {
		super(styles);
		mainScenario = s;
		ucStep2State = map;
		this.initialState = initialState;
	}

	@Override
	public void setLayoutArea(double x, double y, double width, double height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isValidConfiguration(boolean asynchronous,
			boolean continuous) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void postLayoutAlgorithm(InternalNode[] entitiesToLayout,
			InternalRelationship[] relationshipsToConsider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int getTotalNumberOfLayoutSteps() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getCurrentLayoutStep() {
		// TODO Auto-generated method stub
		return 0;
	}

}

enum SpanDirection {
	LEFT, RIGHT, BOTH
}
