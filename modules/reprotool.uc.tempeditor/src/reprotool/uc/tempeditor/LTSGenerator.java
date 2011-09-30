package reprotool.uc.tempeditor;

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
	
	private void processScenario(Scenario s, State init) {
		State srcState = init;
		
		for(UseCaseStep ucStep: s.getSteps()) {
			
			// Variations are attached to the source state.
			if (!ucStep.getVariations().isEmpty()) {
				for (int i = 0; i < ucStep.getVariations().size(); i++) {
					Scenario sc = ucStep.getVariations().get(i).getScenario();
					processScenario(sc, srcState);
				}
			} 
			
			Transition t = LtsFactory.eINSTANCE.createActionTransition();
			t.setSource(srcState);
			State tgtState = LtsFactory.eINSTANCE.createState();
			machine.getAllStates().add(tgtState);
			t.setTarget(tgtState);
			machine.getAllTransitions().add(t);
			
			// Extensions are attached to the target state
			if (!ucStep.getExtensions().isEmpty()) {
				for (int i = 0; i < ucStep.getExtensions().size(); i++) {
					Scenario sc = ucStep.getExtensions().get(i).getScenario();
					processScenario(sc, tgtState);
				}
			} 
			
			// iterate.
			srcState = tgtState;
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
		
		processScenario(scenario, initialState);
	}
	
	public StateMachine getLabelTransitionSystem() {
		return machine;
	}

}
