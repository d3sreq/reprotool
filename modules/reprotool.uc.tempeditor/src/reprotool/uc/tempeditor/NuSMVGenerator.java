package reprotool.uc.tempeditor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.usecase.UseCaseStep;

import lts2.State;
import lts2.StateMachine;
import lts2.Transition;
import lts2.TransitionalState;

public class NuSMVGenerator {
	private NuSMVWrapper nusmv;
	
	private String fileName;
	private StateMachine machine;
	private Transition finalTransition;
	private LTSContentOutlinePage outline;
	private List<String> states = new ArrayList<String>();
	private HashMap<String, Transition> label2Trans = new HashMap<String, Transition>();
	private HashMap<Transition, String> trans2Label = new HashMap<Transition, String>();
	private HashMap<State, String> state2Label = new HashMap<State, String>();
	private HashMap<String, State> label2State = new HashMap<String, State>();
	
	public NuSMVGenerator(StateMachine m, LTSContentOutlinePage outline) {
		nusmv = new NuSMVWrapper();
		
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
        URL fileURL = bundle.getEntry("nusmv");
        String dirName = null;
        try {
			dirName = FileLocator.resolve(fileURL).getFile();
		} catch (IOException e) {
			dirName = fileURL.toExternalForm();
		}
		fileName = dirName + "/test.smv";
        
		machine = m;
		this.outline = outline;
		loadStates();
	}
	
	private void loadStates() {
		label2State.put("s0", machine.getInitialState());
		state2Label.put(machine.getInitialState(), "s0");
		
		for (Transition t: machine.getInitialState().getTransitions()) {
			if (t.getTargetState() == machine.getFinalState()) {
				finalTransition = t;
			}
			UseCaseStep ucStep = t.getRelatedStep();
			if (
					(ucStep != null) &&
					(!(ucStep.getAction() instanceof Goto)) &&
					(!(ucStep.getAction() instanceof AbortUseCase))
			) {
				String label = "s" + t.getRelatedStep().getLabel();
				states.add(label);
				label2Trans.put(label, t);
				trans2Label.put(t, label);
				state2Label.put(t.getTargetState(), label);
				label2State.put(label, t.getTargetState());
			}
		}
		
		for (TransitionalState tState: machine.getTransitionalStates()) {
			for (Transition t: tState.getTransitions()) {
				if (t.getTargetState() == machine.getFinalState()) {
					finalTransition = t;
				}
				UseCaseStep ucStep = t.getRelatedStep();
				if (
						(ucStep != null) &&
						(!(ucStep.getAction() instanceof Goto)) &&
						(!(ucStep.getAction() instanceof AbortUseCase))
				) {
					String label = "s" + t.getRelatedStep().getLabel();
					states.add(label);
					label2Trans.put(label, t);
					trans2Label.put(t, label);
					state2Label.put(t.getTargetState(), label);
					label2State.put(label, t.getTargetState());
				}
			}
		}
	}
	
	String getContents() {
		StringBuffer buf = new StringBuffer();
		
		buf.append("MODULE main\n\n");
		
		buf.append("	-- FairnessConstraint\n");
		buf.append("	FAIRNESS p=p1;\n\n");
		
		buf.append("	VAR p : {none,p1};\n");
		buf.append("	INIT p in none;\n");
		buf.append("	ASSIGN next(p) := case\n");
		buf.append("		p=none : {p1};\n");
		buf.append("		TRUE : none;\n");
		buf.append("	esac;\n\n");
		
		buf.append("	-- Process\n");
		buf.append("	VAR x1 : UC_1(self, x1run);\n");
		buf.append("	VAR x1run: boolean;\n");
		buf.append("	INIT x1run in FALSE;\n");
		buf.append("	ASSIGN next(x1run) := case\n");
		buf.append("		p=p1 : TRUE;\n");
		buf.append("		TRUE : x1run;\n");
		buf.append("	esac;\n\n");
		
		buf.append("	VAR create_item : boolean;\n");
		buf.append("	INIT create_item in FALSE;\n");
		buf.append("	ASSIGN next(create_item) := FALSE\n");
		buf.append("		;\n\n");
		
		buf.append("	VAR use_item : boolean;\n");
		buf.append("	INIT use_item in FALSE;\n");
		buf.append("	ASSIGN next(use_item) := FALSE\n");
		buf.append("		;\n\n");
		
		buf.append("	VAR open_x : boolean;\n");
		buf.append("	INIT open_x in FALSE;\n");
		buf.append("	ASSIGN next(open_x) := FALSE\n");
		buf.append("		;\n\n");
		
		buf.append("	VAR close_x : boolean;\n");
		buf.append("	INIT close_x in FALSE;\n");
		buf.append("	ASSIGN next(close_x) := FALSE\n");
		buf.append("		;\n\n");
		
		buf.append("MODULE UC_1(top, run)\n");
		buf.append("	VAR s : {s0,");
		
		for (String s:states) {
			buf.append(s + ",");
		}
		
		buf.append("sFin};\n");
		buf.append("	INIT s in s0;\n\n");
		
		buf.append("	ASSIGN next(s) := case\n");
		buf.append("		s=s0 & !run : s0;\n");
		buf.append("		s=s0 & run : {");
		
		int c = 0;
		for (Transition t: machine.getInitialState().getTransitions()) {
			String label = trans2Label.get(t);
			if (label == null) {
				continue;
			}
			if (c > 0) {
				buf.append(",");
			}
			c++;
			buf.append(label);
		}
		buf.append("};\n");
		
		for(String state: states) {
			Transition t = label2Trans.get(state);
			State tgt = t.getTargetState();
			if (tgt instanceof TransitionalState) {
				buf.append("		s=" + state + " : {");
				TransitionalState tgtTransitional = (TransitionalState) tgt;
				c = 0;
				for (Transition tr: tgtTransitional.getTransitions()) {
					String label = trans2Label.get(tr);
					if (label == null) {
						label = state2Label.get(tr.getTargetState());
					}
					if (c > 0) {
						buf.append(",");
					}
					c++;
					buf.append(label);
				}
				buf.append("};\n");
			}
		}
		
		buf.append("		s=" + trans2Label.get(finalTransition) + " : sFin;\n");
		buf.append("		s=sFin : sFin;\n");
		buf.append("	esac;\n");
		
		return buf.toString();
	}
	
	public void writeToFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			out.write(getContents());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void displayCounterPath(List<String> states) {
		System.out.println("States: " + states);
		List<State> lStates = new ArrayList<State>();
		for (String label: states) {
			State state = label2State.get(label);
			if (state != null) {
				lStates.add(state);
			}
		}
		outline.selectStates(lStates);
	}
	
	public void performTest() {
		nusmv.clearConsole();
		nusmv.loadModelFile(fileName);
		
		try {
			nusmv.checkCTLSpec( "After 'open' there should always be 'close'",
					"AG(open_x -> AF(close_x))" );
			if (!nusmv.getTestResult()) {
				displayCounterPath(nusmv.getStateTrace());
				return;
			}
			
			nusmv.checkCTLSpec( "No multi-open without close",
					"AG(open_x -> AX(A[!open_x U close_x]))" );
			if (!nusmv.getTestResult()) {
				displayCounterPath(nusmv.getStateTrace());
				return;
			}
			
			nusmv.checkCTLSpec( "No multi-close without open",
					"AG(close_x -> AX(A[!close_x U open_x | !AF(close_x) ]))" );
			if (!nusmv.getTestResult()) {
				displayCounterPath(nusmv.getStateTrace());
				return;
			}
			
			nusmv.checkCTLSpec( "First 'open' then 'close'",
					"A[!close_x U open_x | !AF(close_x)]" );
			if (!nusmv.getTestResult()) {
				displayCounterPath(nusmv.getStateTrace());
				return;
			}
			
			nusmv.checkCTLSpec( "After 'create' there must be some branch containing 'use'",
					"AG( create_item -> EF(use_item) )" );
			if (!nusmv.getTestResult()) {
				displayCounterPath(nusmv.getStateTrace());
				return;
			}
			
			nusmv.checkCTLSpec( "Only one 'create'",
					"AG( create_item -> AX(AG(!create_item)) )" );
			if (!nusmv.getTestResult()) {
				displayCounterPath(nusmv.getStateTrace());
				return;
			}
			
			nusmv.checkCTLSpec( "No 'use' before 'create'",
					"A[ !use_item U create_item | !AF(use_item)]" );
			if (!nusmv.getTestResult()) {
				displayCounterPath(nusmv.getStateTrace());
				return;
			}
			
		} catch(Exception e) {
			nusmv.printMessage( e.getMessage() );
		}
	}

}
