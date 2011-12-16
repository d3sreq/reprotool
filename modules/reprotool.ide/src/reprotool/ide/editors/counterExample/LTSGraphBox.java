package reprotool.ide.editors.counterExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lts2.StateMachine;
import lts2.Transition;

import org.eclipse.zest.core.widgets.GraphNode;

import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

public class LTSGraphBox {
	private HashMap<Transition, GraphNode> trans2Node;
	private HashMap<UseCaseStep, Transition> ucStep2TransLayout;
	private HashMap<UseCaseStep, Transition> ucStep2TransOriginal;
	private List<StateMachine> includedMachines;
	private HashMap<StateMachine, UseCase> machine2UseCase;
	private HashMap<UseCase, StateMachine> useCase2Machine;
	
	public HashMap<Transition, GraphNode> getTrans2Node() {
		return trans2Node;
	}
	
	public void setTrans2Node(HashMap<Transition, GraphNode> trans2Node) {
		this.trans2Node = new HashMap<Transition, GraphNode> (trans2Node);
	}
	
	public HashMap<UseCaseStep, Transition> getUcStep2TransLayout() {
		return ucStep2TransLayout;
	}
	
	public void setUcStep2TransLayout(HashMap<UseCaseStep, Transition> ucStep2TransLayout) {
		this.ucStep2TransLayout = new HashMap<UseCaseStep, Transition> (ucStep2TransLayout);
	}

	public HashMap<UseCaseStep, Transition> getUcStep2TransOriginal() {
		return ucStep2TransOriginal;
	}
	
	public void setUcStep2TransOriginal(HashMap<UseCaseStep, Transition> ucStep2TransOriginal) {
		this.ucStep2TransOriginal = new HashMap<UseCaseStep, Transition> (ucStep2TransOriginal);
	}
	
	public List<StateMachine> getIncludedMachines() {
		return includedMachines;
	}
	
	public void setIncludedMachines(List<StateMachine> includedMachines) {
		this.includedMachines = new ArrayList<StateMachine>(includedMachines);
	}
	
	public HashMap<StateMachine, UseCase> getMachine2UseCase() {
		return machine2UseCase;
	}
	
	public void setMachine2UseCase(HashMap<StateMachine, UseCase> machine2UseCase) {
		this.machine2UseCase = new HashMap<StateMachine, UseCase>(machine2UseCase);
	}
	
	public HashMap<UseCase, StateMachine> getUseCase2Machine() {
		return useCase2Machine;
	}
	
	public void setUseCase2Machine(HashMap<UseCase, StateMachine> useCase2Machine) {
		this.useCase2Machine = new HashMap<UseCase, StateMachine>(useCase2Machine);
	}
}
