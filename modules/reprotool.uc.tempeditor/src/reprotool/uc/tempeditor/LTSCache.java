package reprotool.uc.tempeditor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

import lts2.State;
import lts2.Transition;
import lts2.TransitionalState;

public class LTSCache {
	private List<Transition> gotoTransitions = new ArrayList<Transition>();
	private List<UseCase> includedUseCases = new ArrayList<UseCase>();
	private List<UseCaseStep> gotoSteps = new ArrayList<UseCaseStep>();
	private HashMap<UseCaseStep, Transition> ucStep2Trans = new HashMap<UseCaseStep, Transition>();
	private HashMap<UseCaseStep, Transition> ucStep2TransLayout = new HashMap<UseCaseStep, Transition>();
	private HashMap<UseCaseStep, State> ucStep2SrcState = new HashMap<UseCaseStep, State>();
	private HashMap<State, List<TransitionalState>> extClosures = 
			new HashMap<State, List<TransitionalState>>();


	public List<Transition> getGotoTransitions() {
		return gotoTransitions;
	}
	
	public List<UseCase> getIncludedUseCases() {
		return includedUseCases;
	}
	
	public List<UseCaseStep> getGotoSteps() {
		return gotoSteps;
	}
	
	public HashMap<UseCaseStep, Transition> getUCStep2Trans() {
		return ucStep2Trans;
	}
	
	public HashMap<UseCaseStep, Transition> getUCStep2TransLayout() {
		return ucStep2TransLayout;
	}
	
	public HashMap<UseCaseStep, State> getUCStep2TSrcState() {
		return ucStep2SrcState;
	}
	
	public HashMap<State, List<TransitionalState>> getExtClosures() {
		return extClosures;
	}
}
