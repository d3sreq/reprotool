package reprotool.uc.tempeditor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.Assert;

import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.lts.LtsFactory;
import reprotool.model.lts.State;
import reprotool.model.lts.StateMachine;
import reprotool.model.lts.Transition;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;

public class LTSGenerator {
	private Scenario scenario;
	private StateMachine machine;
	private State initialState;
	private State abortState;
	
	/*
	 * Maps a use-case step to a state to which it leads in the LTS model.
	 */
	private HashMap<UseCaseStep, State> ucStep2State = new HashMap<UseCaseStep, State>();
	
	/*
	 * Maps a use-case step to a state where the corresponding edge starts in
	 * the LTS model.
	 */
	private HashMap<UseCaseStep, State> ucStep2SrcState = new HashMap<UseCaseStep, State>();
	
	/*
	 * I process the graph from upside down. That means whenever I process an
	 * extension, I can not add to the LST the edge leading from the last state
	 * of the extension to the state following the extension. This is because
	 * the state following the extension has not yet been created - it will be
	 * created in the next iteration.
	 * So whenever I finish an extension, I save the last state of that
	 * extension. Then in the next iteration, when the new state is already
	 * created I add the edge.
	 */
	private HashMap<State, List<State>> registerExtClosure = new HashMap<State, List<State>>();
	
	/*
	 * Maps a use-case step to a state where the corresponding edge comes from
	 * in the LTS model.
	 */
	private List<UseCaseStep> gotoSteps = new ArrayList<UseCaseStep>();
	
	
	private State processScenario(Scenario s, State init, State next) {
		if ((s == null) || (s.getSteps().isEmpty())) {
			return null;
		}
		
		State srcState = init;
		
		for(UseCaseStep ucStep: s.getSteps()) {
			ucStep2SrcState.put(ucStep, srcState);
			State tgtState = LtsFactory.eINSTANCE.createState();
			
			if (
					(srcState != init) &&
					(registerExtClosure.containsKey(srcState))
			) {
				for (State src: registerExtClosure.get(srcState)) {
					Transition t = LtsFactory.eINSTANCE.createActionTransition();
					t.setSource(src);
					t.setTarget(tgtState);
					machine.getAllTransitions().add(t);
				}
				registerExtClosure.remove(srcState);
			}

			// Variations are attached to the source state.
			if (!ucStep.getVariations().isEmpty()) {
				for (int i = 0; i < ucStep.getVariations().size(); i++) {
					Scenario sc = ucStep.getVariations().get(i);
					processScenario(sc, srcState, tgtState);
				}
			}
			
			if (ucStep.getAction() instanceof AbortUseCase) {				
				Transition t = LtsFactory.eINSTANCE.createActionTransition();
				t.setSource(srcState);
				ucStep2State.put(ucStep, machine.getAbortState());
				t.setTarget(machine.getAbortState());
				machine.getAllTransitions().add(t);
				continue;
			}
			
			if( ucStep.getAction() instanceof Goto ) {
				gotoSteps.add(ucStep);
				continue;
			}
			
			
			Transition t = LtsFactory.eINSTANCE.createActionTransition();
			t.setSource(srcState);
			ucStep2State.put(ucStep, tgtState);
			
			machine.getAllStates().add(tgtState);
			t.setTarget(tgtState);
			machine.getAllTransitions().add(t);
			
			// Extensions are attached to the target state
			if (!ucStep.getExtensions().isEmpty()) {
				registerExtClosure.put(tgtState, new ArrayList<State>());
				
				for (int i = 0; i < ucStep.getExtensions().size(); i++) {
					Scenario sc = ucStep.getExtensions().get(i);
					if (!sc.getSteps().isEmpty()) {
						UseCaseStep lastStep = sc.getSteps().get(sc.getSteps().size() - 1);
						State st = processScenario(sc, tgtState, null);
						if (
							(!(lastStep.getAction() instanceof Goto)) &&
							(!(lastStep.getAction() instanceof AbortUseCase))
						) {
							Assert.isNotNull(registerExtClosure.get(tgtState));
							registerExtClosure.get(tgtState).add(st);
						}
					}
				}
			} 
			
			// iterate.
			srcState = tgtState;
		}
		
		UseCaseStep lastStep = s.getSteps().get(s.getSteps().size() - 1);
		
		if (
				(!(lastStep.getAction() instanceof Goto)) &&
				(!(lastStep.getAction() instanceof AbortUseCase)) &&
				(next != null)
		) {
			Transition t = LtsFactory.eINSTANCE.createActionTransition();
			t.setSource(srcState);
			t.setTarget(next);
			machine.getAllTransitions().add(t);
		}
		
		return srcState;
	}
	
	/*
	 * We can not process the goto steps while processing the scenario
	 * because at that time some goto targets may not be known yet.
	 * Thus we process the goto steps only after all steps have been visited.
	 */
	private void processGotoSteps() {
		for (UseCaseStep ucStep: gotoSteps) {
			Assert.isTrue(ucStep.getAction() instanceof Goto);
			Goto gotoAction = (Goto) ucStep.getAction();
			State src = ucStep2SrcState.get(ucStep);
			State dst = ucStep2SrcState.get(gotoAction.getGotoTarget());
			Assert.isNotNull(src);
			Assert.isNotNull(dst);
			Transition t = LtsFactory.eINSTANCE.createActionTransition();
			t.setSource(src);
			t.setTarget(dst);
			machine.getAllTransitions().add(t);
		}
	}
	
	public LTSGenerator(Scenario s) {
		scenario = s;
		machine = LtsFactory.eINSTANCE.createStateMachine();
		
		initialState = LtsFactory.eINSTANCE.createState();
		abortState = LtsFactory.eINSTANCE.createState();
		machine.getAllStates().add(initialState);
		machine.getAllStates().add(abortState);
		machine.setInitialState(initialState);
		machine.setAbortState(abortState);
		
		processScenario(scenario, initialState, null);
		processGotoSteps();
	}
	
	public StateMachine getLabelTransitionSystem() {
		return machine;
	}
	
	public HashMap<UseCaseStep, State> getUCStep2StateMap() {
		return ucStep2State;
	}

}
