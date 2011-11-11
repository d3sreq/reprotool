package reprotool.fm.nusmv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import reprotool.fm.nusmv.lang.nuSmvInputLanguage.AssignConstraint;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.BooleanType;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.EnumType;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.FormalParameter;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.InitConstraint;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.MainModule;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.Model;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.NextBody;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.NextExpression;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.NuSmvInputLanguageFactory;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.OtherModule;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.SyncrProcessType;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.VarBody;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.VariableDeclaration;
import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.annotate.StepAnnotation;

import lts2.State;
import lts2.StateMachine;
import lts2.Transition;
import lts2.TransitionalState;
import lts2.impl.LTSGeneratorImpl;

public class NuSMVGeneratorModel {
	private String useCaseId;
	private boolean hasAbort = false;
	private StateMachine machine;
	private UseCase useCase;
	private Transition finalTransition;
	private NuSmvInputLanguageFactory factory;
	private OtherModule module;
	
	private List<String> states = new ArrayList<String>();
	private List<UseCase> includedUseCases = new ArrayList<UseCase>();
	private HashMap<String, Transition> label2Trans = new HashMap<String, Transition>();
	private HashMap<Transition, String> trans2Label = new HashMap<Transition, String>();
	private HashMap<State, String> state2Label = new HashMap<State, String>();
	private HashMap<String, State> label2State = new HashMap<String, State>();
	private HashMap<UseCase, String> useCase2Label = new HashMap<UseCase, String>();
	
	private HashMap<String, AnnotationEntry> annotationTracker = new 
		HashMap<String, AnnotationEntry>();
	
	public NuSMVGeneratorModel(UseCase uc) {
		factory = NuSmvInputLanguageFactory.eINSTANCE;
		useCase = uc;
		LTSGeneratorImpl lts = new LTSGeneratorImpl();
		lts.processUseCase(useCase);
		machine = lts.getLabelTransitionSystem();
		this.useCaseId = uc2id(useCase);
		loadStates();
		generateAutomaton();
	}
	
	/**
	 * Helper method that derives identifier of a use-case.
	 * @param useCase
	 * @return The derived identifier 
	 */
	private String uc2id(UseCase useCase) {
		return useCase.getName().replaceAll(" +", "_");
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
				if (ucStep.getAction() instanceof UseCaseInclude) {
					UseCaseInclude ui = (UseCaseInclude) ucStep.getAction();
					includedUseCases.add(ui.getIncludeTarget());
					useCase2Label.put(ui.getIncludeTarget(), "s0");
				}
				
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
			
			if ((ucStep != null) && (ucStep.getAction() instanceof AbortUseCase)) {
				hasAbort = true;
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
					if (ucStep.getAction() instanceof UseCaseInclude) {
						UseCaseInclude ui = (UseCaseInclude) ucStep.getAction();
						includedUseCases.add(ui.getIncludeTarget());
						useCase2Label.put(ui.getIncludeTarget(), state2Label.get(tState));
					}
					
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
				
				if ((ucStep != null) && (ucStep.getAction() instanceof AbortUseCase)) {
					hasAbort = true;
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
	
	public UseCase getUseCase() {
		return useCase;
	}
	
	public void addProcess(MainModule module, Model model) {
		VariableDeclaration xVar = factory.createVariableDeclaration();
		xVar.setVar("VAR");
		VarBody xBody = factory.createVarBody();
		xBody.setId("x" + useCaseId);
		SyncrProcessType xType = factory.createSyncrProcessType();
		xType.setModule(getModule());
		xType.getParams().add("self");
		xType.getParams().add("x" + uc2id(useCase) + "run");
		xBody.setType(xType);
		xVar.getVars().add(xBody);
		module.getModuleElement().add(xVar);
				
		VariableDeclaration runVar = factory.createVariableDeclaration();
		runVar.setVar("VAR");	
		VarBody runBody = factory.createVarBody();
		runBody.setId("x" + useCaseId + "run");
		BooleanType runType = factory.createBooleanType();
		runBody.setType(runType);
		runVar.getVars().add(runBody);
		module.getModuleElement().add(runVar);
		
		InitConstraint initConstraint = factory.createInitConstraint();
		initConstraint.setInitExpression("x" + useCaseId + "run in FALSE");
		module.getModuleElement().add(initConstraint);
		
		StringBuffer nextExpr = new StringBuffer();
		
		if (
				(useCase.getPrecedingUseCases() == null) ||
				(useCase.getPrecedingUseCases().isEmpty())
		) {
			nextExpr.append("case\n\t\tp=p" + useCaseId + " : TRUE;\n");
		
		} else {
			nextExpr.append("case\n\t\tp=p" + useCaseId);
			for (UseCase pred: useCase.getPrecedingUseCases()) {
				nextExpr.append(" & x" + uc2id(pred) + ".s = sFin");
			}
			nextExpr.append(" : TRUE;\n");
		}		
		nextExpr.append("\t\tTRUE : x" + useCaseId + "run;\n\tesac");
		
		AssignConstraint assignConstraint = factory.createAssignConstraint();
		NextBody nextBody = factory.createNextBody();
		nextBody.setVar("x" + useCaseId + "run");
		NextExpression nextExpression = factory.createNextExpression();
		nextExpression.setSimpleExpression(nextExpr.toString());
		nextBody.setNext(nextExpression);
		assignConstraint.getBodies().add(nextBody);
		module.getModuleElement().add(assignConstraint);
	}
	
	public List<UseCase> getIncludedUseCases() {
		return includedUseCases;
	}
	
	public OtherModule getModule() {
		return module;
	}
	
	public void fillAutomaton(HashMap<UseCase, NuSMVGeneratorModel> uc2gen) {
		int c = 0;
		for (UseCase include: getIncludedUseCases()) {
			c++;
			String tag = Integer.toString(c);
			
			VariableDeclaration runVar = factory.createVariableDeclaration();
			runVar.setVar("VAR");	
			VarBody runBody = factory.createVarBody();
			runBody.setId("y" + tag + "run");
			BooleanType runType = factory.createBooleanType();
			runBody.setType(runType);
			runVar.getVars().add(runBody);
			module.getModuleElement().add(runVar);
			
			InitConstraint initConstraint = factory.createInitConstraint();
			initConstraint.setInitExpression("y" + tag + "run in FALSE");
			module.getModuleElement().add(initConstraint);
			
			VariableDeclaration yVar = factory.createVariableDeclaration();
			yVar.setVar("VAR");
			VarBody yBody = factory.createVarBody();
			yBody.setId("y" + tag);
			SyncrProcessType yType = factory.createSyncrProcessType();
			yType.setModule(uc2gen.get(include).getModule());
			yType.getParams().add("top");
			yType.getParams().add("y" + tag + "run");
			yBody.setType(yType);
			yVar.getVars().add(yBody);
			module.getModuleElement().add(yVar);
						
			AssignConstraint assignConstraint = factory.createAssignConstraint();
			NextBody nextBody = factory.createNextBody();
			nextBody.setVar("y" + tag + "run");
			NextExpression nextExpression = factory.createNextExpression();
			nextExpression.setSimpleExpression("(s=" + useCase2Label.get(include) + ")");
			nextBody.setNext(nextExpression);
			assignConstraint.getBodies().add(nextBody);
			module.getModuleElement().add(assignConstraint);
		}
		
		VariableDeclaration sVar = factory.createVariableDeclaration();
		sVar.setVar("VAR");
		
		VarBody sBody = factory.createVarBody();
		sBody.setId("s");
		
		EnumType sType = factory.createEnumType();
		sType.getVal().add("s0");
		for (String s: states) {
			sType.getVal().add(s);
		}
		if (hasAbort) {
			sType.getVal().add("sAbort");
		}
		sType.getVal().add("sFin");
		
		sBody.setType(sType);
		
		sVar.getVars().add(sBody);
		module.getModuleElement().add(sVar);
		
		InitConstraint initConstraint = factory.createInitConstraint();
		initConstraint.setInitExpression("s in s0");
		module.getModuleElement().add(initConstraint);
		
		StringBuffer nextExpr = new StringBuffer();
		
		nextExpr.append("case\n");
		nextExpr.append("		s=s0 & !run : s0;\n");
		nextExpr.append("		s=s0 & run : {");
		
		c = 0;
		for (Transition t: machine.getInitialState().getTransitions()) {
			String label = trans2Label.get(t);
			if (label == null) {
				continue;
			}
			if (c > 0) {
				nextExpr.append(",");
			}
			c++;
			nextExpr.append(label);
		}
		nextExpr.append("};\n");
		
		for(String state: states) {
			Transition t = label2Trans.get(state);
			State tgt = t.getTargetState();
			if (tgt instanceof TransitionalState) {
				TransitionalState tgtTransitional = (TransitionalState) tgt;
				EList<Transition> transitions = tgtTransitional.getTransitions();
				if (
						(!transitions.isEmpty()) &&
						(transitions.get(0).getRelatedStep() != null) &&
						(transitions.get(0).getRelatedStep().getAction() instanceof UseCaseInclude)
				) {
					Transition tr = transitions.get(0);
					String label = trans2Label.get(tr);
					if (label == null) {
						label = state2Label.get(tr.getTargetState());
					}
					UseCaseInclude ui = (UseCaseInclude)tr.getRelatedStep().getAction();
					int i = includedUseCases.indexOf(ui.getIncludeTarget()) + 1;
					String tag = Integer.toString(i);
					nextExpr.append("		s=" + state + " & y" + tag +  ".s != sFin : " + state + ";\n");
					nextExpr.append("		s=" + state + " & y" + tag +  ".s = sFin : " + label + ";\n");
					continue;
				}
				
				boolean onAnnotation = false;
				List<Transition> skips = new ArrayList<Transition>();
				String traceTag = null;
				
				for (Transition tr: transitions) {
					UseCaseStep step = tr.getRelatedStep();
					if (step != null) {
						for (StepAnnotation a: step.getAnnotations()) {
							if ("on".equals(a.getAnnotationType().getName())) {
								onAnnotation = true;
								skips.add(tr);
								traceTag = "trace_" + a.getId();
							}
						}
					}
				}
				
				if (onAnnotation) {
					nextExpr.append("		s=" + state + " & !top." + traceTag + ": {");
					c = 0;
					for (Transition tr: transitions) {
						if (skips.contains(tr)) {
							continue;
						}
						UseCaseStep step = tr.getRelatedStep();
						String label = trans2Label.get(tr);
						if ((step != null) && (step.getAction() instanceof AbortUseCase)) {
							label = "sAbort";
						}
						if (label == null) {
							label = state2Label.get(tr.getTargetState());
						}
						if (c > 0) {
							nextExpr.append(",");
						}
						c++;
						nextExpr.append(label);
					}
					nextExpr.append("};\n");
					
					nextExpr.append("		s=" + state + " & top." + traceTag + ": {");
					c = 0;
					for (Transition tr: skips) {
						UseCaseStep step = tr.getRelatedStep();
						String label = trans2Label.get(tr);
						if ((step != null) && (step.getAction() instanceof AbortUseCase)) {
							label = "sAbort";
						}
						if (label == null) {
							label = state2Label.get(tr.getTargetState());
						}
						if (c > 0) {
							nextExpr.append(",");
						}
						c++;
						nextExpr.append(label);
					}
					nextExpr.append("};\n");
				} else {
					nextExpr.append("		s=" + state + " : {");
					c = 0;
					for (Transition tr: transitions) {
						UseCaseStep step = tr.getRelatedStep();
						String label = trans2Label.get(tr);
						if ((step != null) && (step.getAction() instanceof AbortUseCase)) {
							label = "sAbort";
						}
						if (label == null) {
							label = state2Label.get(tr.getTargetState());
						}
						if (c > 0) {
							nextExpr.append(",");
						}
						c++;
						nextExpr.append(label);
					}
					nextExpr.append("};\n");
				}
			}
		}
		
		nextExpr.append("		s=" + trans2Label.get(finalTransition) + " : sFin;\n");
		nextExpr.append("		s=sFin : sFin;\n");
		if (hasAbort) {
			nextExpr.append("		s=sAbort : sAbort;\n");			
		}
		nextExpr.append("	esac");
			
		AssignConstraint assignConstraint = factory.createAssignConstraint();
		NextBody nextBody = factory.createNextBody();
		nextBody.setVar("s");
		NextExpression nextExpression = factory.createNextExpression();
		nextExpression.setSimpleExpression(nextExpr.toString());
		nextBody.setNext(nextExpression);
		assignConstraint.getBodies().add(nextBody);
		module.getModuleElement().add(assignConstraint);
	}
	
	private void generateAutomaton() {
		module = factory.createOtherModule();
		module.setName("UC_" + uc2id(useCase));
		
		FormalParameter p1 = factory.createFormalParameter();
		p1.setId("top");
		module.getParams().add(p1);
		
		FormalParameter p2 = factory.createFormalParameter();
		p2.setId("run");
		module.getParams().add(p2);
	}
	
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
	
	AnnotationEntry(AnnotationEntry a) {
		automatonID = a.automatonID;
		states = a.states;
	}
	
	AnnotationEntry() {}
}