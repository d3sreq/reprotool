package reprotool.fm.nusmv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.annotate.StepAnnotation;

import lts2.State;
import lts2.StateMachine;
import lts2.Transition;
import lts2.TransitionalState;

public class NuSMVGenerator {

//	private MyNuSMVWrapper nusmv;	
//	private String fileName;
	
	private String useCaseId;
	private StateMachine machine;
	private Transition finalTransition;
	private List<String> states = new ArrayList<String>();
	private HashMap<String, Transition> label2Trans = new HashMap<String, Transition>();
	private HashMap<Transition, String> trans2Label = new HashMap<Transition, String>();
	private HashMap<State, String> state2Label = new HashMap<State, String>();
	private HashMap<String, State> label2State = new HashMap<String, State>();
	
	private HashMap<String, AnnotationEntry> annotationTracker = new 
		HashMap<String, AnnotationEntry>();
	
	public NuSMVGenerator(StateMachine m, String useCaseID) {
//		nusmv = new MyNuSMVWrapper();
		
//		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
//        URL fileURL = bundle.getEntry("nusmv");
//        String dirName = null;
//        try {
//			dirName = FileLocator.resolve(fileURL).getFile();
//		} catch (IOException e) {
//			dirName = fileURL.toExternalForm();
//		}
//		fileName = dirName + "/test.smv";
        
		machine = m;
		this.useCaseId = useCaseID;
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
				
				EList<StepAnnotation> annots = ucStep.getAnnotations();
				if (!annots.isEmpty()) {
					for (StepAnnotation a: annots) {
						String tag = a.getAnnotationType().getName() + "_" + a.getId();
						AnnotationEntry aEntry = annotationTracker.get(tag);
						if (aEntry == null) {
							aEntry = new AnnotationEntry();
							aEntry.automatonID = useCaseId;
							aEntry.states = new ArrayList<String>();
							annotationTracker.put(tag, aEntry);
						}
						aEntry.states.add(label);
					}
				}
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

					EList<StepAnnotation> annots = ucStep.getAnnotations();
					if (!annots.isEmpty()) {
						for (StepAnnotation a: annots) {
							String tag = a.getAnnotationType().getName() + "_" + a.getId();
							AnnotationEntry aEntry = annotationTracker.get(tag);
							if (aEntry == null) {
								aEntry = new AnnotationEntry();
								aEntry.automatonID = useCaseId;
								aEntry.states = new ArrayList<String>();
								annotationTracker.put(tag, aEntry);
							}
							aEntry.states.add(label);
						}
					}
				}
			}
		}
	}
	
	public HashMap<String, AnnotationEntry> getAnnotationsTracker() {
		return annotationTracker;
	}
	
	public String getUseCaseId() {
		return useCaseId;
	}
	
	public String getProcess() {
		StringBuffer buf = new StringBuffer();
		
		buf.append("	-- Process\n");
		buf.append("	VAR x" + useCaseId + " : UC_" + useCaseId + "(self, x" + useCaseId + "run);\n");
		buf.append("	VAR x"  + useCaseId + "run: boolean;\n");
		buf.append("	INIT x" + useCaseId + "run in FALSE;\n");
		buf.append("	ASSIGN next(x" + useCaseId + "run) := case\n");
		buf.append("		p=p" + useCaseId + " : TRUE;\n");
		buf.append("		TRUE : x" + useCaseId + "run;\n");
		buf.append("	esac;");
		
		return buf.toString();
	}
	
//	public String getAnnotations() {
//		StringBuffer buf = new StringBuffer();
//		
//		for (String tag: annotationTracker.keySet()) {
//			AnnotationEntry aEntry = annotationTracker.get(tag);
//			buf.append("	VAR " + tag + " : boolean;\n");
//			buf.append("	INIT " + tag + " in FALSE;\n");
//			buf.append("	ASSIGN next(" + tag + ") := FALSE\n");
//			buf.append("		| x" + aEntry.automatonID + ".s in {" );
//			int c = 0;
//			for (String state: aEntry.states) {
//				if (c > 0) {
//					buf.append(",");
//				}
//				c++;
//				buf.append(state);
//			}
//			buf.append("}\n");
//			buf.append("		;\n\n");
//		}
//		
//		return buf.toString();
//	}
	
	public String getAutomaton() {
		StringBuffer buf = new StringBuffer();

		buf.append("MODULE UC_" + useCaseId + "(top, run)\n");
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
		buf.append("	esac;");
		
		return buf.toString();
	}
	
//	String getContents() {
//		StringBuffer buf = new StringBuffer();
//		
//		buf.append("MODULE main\n\n");
//		
//		buf.append("	-- FairnessConstraint\n");
//		buf.append("	FAIRNESS p=p1;\n\n");
//		
//		buf.append("	VAR p : {none,p1};\n");
//		buf.append("	INIT p in none;\n");
//		buf.append("	ASSIGN next(p) := case\n");
//		buf.append("		p=none : {p1};\n");
//		buf.append("		TRUE : none;\n");
//		buf.append("	esac;\n\n");
//		
//		buf.append(getProcess(useCaseId));
//		buf.append(getAnnotations());
//		buf.append(getAutomaton());
//		
//		return buf.toString();
//	}
	
//	private void displayCounterPath(List<String> states) {
//		List<State> lStates = new ArrayList<State>();
//		for (String label: states) {
//			State state = label2State.get(label);
//			if (state != null) {
//				lStates.add(state);
//			}
//		}
//		outline.selectStates(lStates);
//	}
	
//	public void performTest() {
//		nusmv.clearConsole();
//		nusmv.loadModelFile(fileName);
//		
//		try {
//			nusmv.checkCTLSpec( "After 'open' there should always be 'close'",
//					"AG(open_file -> AF(close_file))" );
//			if (!nusmv.getTestResult()) {
//				displayCounterPath(nusmv.getStateTrace());
//				return;
//			}
//			
//			nusmv.checkCTLSpec( "No multi-open without close",
//					"AG(open_file -> AX(A[!open_file U close_file]))" );
//			if (!nusmv.getTestResult()) {
//				displayCounterPath(nusmv.getStateTrace());
//				return;
//			}
//			
//			nusmv.checkCTLSpec( "No multi-close without open",
//					"AG(close_file -> AX(A[!close_file U open_file | !AF(close_file) ]))" );
//			if (!nusmv.getTestResult()) {
//				displayCounterPath(nusmv.getStateTrace());
//				return;
//			}
//			
//			nusmv.checkCTLSpec( "First 'open' then 'close'",
//					"A[!close_file U open_file | !AF(close_file)]" );
//			if (!nusmv.getTestResult()) {
//				displayCounterPath(nusmv.getStateTrace());
//				return;
//			}
//			
//			/*
//			nusmv.checkCTLSpec( "After 'create' there must be some branch containing 'use'",
//					"AG( create_item -> EF(use_item) )" );
//			if (!nusmv.getTestResult()) {
//				displayCounterPath(nusmv.getStateTrace());
//				return;
//			}
//			
//			nusmv.checkCTLSpec( "Only one 'create'",
//					"AG( create_item -> AX(AG(!create_item)) )" );
//			if (!nusmv.getTestResult()) {
//				displayCounterPath(nusmv.getStateTrace());
//				return;
//			}
//			
//			nusmv.checkCTLSpec( "No 'use' before 'create'",
//					"A[ !use_item U create_item | !AF(use_item)]" );
//			if (!nusmv.getTestResult()) {
//				displayCounterPath(nusmv.getStateTrace());
//				return;
//			}
//			*/
//			
//		} catch(Exception e) {
//			nusmv.printMessage( e.getMessage() );
//		}
//	}

}

class AnnotationEntry {
	String automatonID;
	List<String> states = new ArrayList<String>();
}