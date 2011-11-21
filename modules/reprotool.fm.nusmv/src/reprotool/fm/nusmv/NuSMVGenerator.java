package reprotool.fm.nusmv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lts2.State;
import lts2.StateMachine;
import lts2.Transition;
import lts2.TransitionalState;
import lts2.impl.LTSGeneratorImpl;

import org.eclipse.emf.common.util.EList;

import reprotool.fm.nusmv.lang.nuSmvLang.AssignConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.BooleanType;
import reprotool.fm.nusmv.lang.nuSmvLang.EnumType;
import reprotool.fm.nusmv.lang.nuSmvLang.FormalParameter;
import reprotool.fm.nusmv.lang.nuSmvLang.InitConstraint;
import reprotool.fm.nusmv.lang.nuSmvLang.NextBody;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangFactory;
import reprotool.fm.nusmv.lang.nuSmvLang.OtherModule;
import reprotool.fm.nusmv.lang.nuSmvLang.SyncrProcessType;
import reprotool.fm.nusmv.lang.nuSmvLang.VarBody;
import reprotool.fm.nusmv.lang.nuSmvLang.VariableDeclaration;
import reprotool.model.linguistic.action.AbortUseCase;
import reprotool.model.linguistic.action.Goto;
import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.annotate.StepAnnotation;

public class NuSMVGenerator {
	private String useCaseId;
	private boolean hasAbort = false;
	private StateMachine machine;
	private UseCase useCase;
	private Transition finalTransition;
	private NuSmvLangFactory factory;
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
	
	public NuSMVGenerator(UseCase uc) {
		factory = NuSmvLangFactory.eINSTANCE;
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
	public String uc2id(UseCase useCase) {
		if (useCase.getName() == null) {
			throw new NullPointerException("Use-case name parameter is not set");
		}
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
					(!(ucStep.getAction() instanceof Goto))
			) {
				String label = "s" + t.getRelatedStep().getLabel();
				
				if (ucStep.getAction() instanceof UseCaseInclude) {
					UseCaseInclude ui = (UseCaseInclude) ucStep.getAction();
					includedUseCases.add(ui.getIncludeTarget());
					useCase2Label.put(ui.getIncludeTarget(), label + "__");
					states.add(label + "__");
				}
				
				states.add(label);
				states.add(label + "_");
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
					if (t.getRelatedStep() != null) {
						finalTransition = t;
					}
				}
				UseCaseStep ucStep = t.getRelatedStep();
				if (
						(ucStep != null) &&
						(!(ucStep.getAction() instanceof Goto))
				) {
					String label = "s" + t.getRelatedStep().getLabel();

					if (ucStep.getAction() instanceof UseCaseInclude) {
						UseCaseInclude ui = (UseCaseInclude) ucStep.getAction();
						includedUseCases.add(ui.getIncludeTarget());
						useCase2Label.put(ui.getIncludeTarget(), label + "__");
						states.add(label + "__");
					}
					
					states.add(label);
					states.add(label + "_");
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
	
	public Transition findTransition(State src, State dst) {
		for (Transition t: machine.getInitialState().getTransitions()) {
			State s1 = (State) t.getSourceState();
			State s2 = t.getTargetState();
			
			if ((s1 == src) && (s2 == dst)) {
				return t;
			}
		}
		
		for (TransitionalState ts: machine.getTransitionalStates()) {
			for (Transition t: ts.getTransitions()) {
				State s1 = (State) t.getSourceState();
				State s2 = t.getTargetState();
				
				if ((s1 == src) && (s2 == dst)) {
					return t;
				}
			}
		}
		
		return null;
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
	
	public HashMap<String, Transition> getLabel2Trans() {
		return label2Trans;
	}
		
	public List<UseCase> getIncludedUseCases() {
		return includedUseCases;
	}
	
	public OtherModule getModule() {
		return module;
	}
	
	public void fillAutomaton(HashMap<UseCase, NuSMVGenerator> uc2gen) {
		int c = 0;
		for (UseCase include: getIncludedUseCases()) {
			c++;
			String tag = Integer.toString(c);
			
			VariableDeclaration runVar = factory.createVariableDeclaration();
			VarBody runBody = factory.createVarBody();
			runBody.setVarId("y" + tag + "run");
			BooleanType runType = factory.createBooleanType();
			runBody.setType(runType);
			runVar.getVars().add(runBody);
			module.getModuleElement().add(runVar);
			
			InitConstraint initConstraint = factory.createInitConstraint();
			initConstraint.setInitExpr("y" + tag + "run in FALSE");
			module.getModuleElement().add(initConstraint);
			
			VariableDeclaration yVar = factory.createVariableDeclaration();
			VarBody yBody = factory.createVarBody();
			yBody.setVarId("y" + tag);
			SyncrProcessType yType = factory.createSyncrProcessType();
			yType.setModule(uc2gen.get(include).getModule());
			yType.getParams().add("top");
			yType.getParams().add("y" + tag + "run");
			yBody.setType(yType);
			yVar.getVars().add(yBody);
			module.getModuleElement().add(yVar);
						
			AssignConstraint assignConstraint = factory.createAssignConstraint();
			NextBody nextBody = factory.createNextBody();
			nextBody.setVarId("y" + tag + "run");
			nextBody.setNextExpr("(s=" + useCase2Label.get(include) + ")");
			assignConstraint.getBodies().add(nextBody);
			module.getModuleElement().add(assignConstraint);
		}
		
		VariableDeclaration sVar = factory.createVariableDeclaration();
		VarBody sBody = factory.createVarBody();
		sBody.setVarId("s");
		
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
		initConstraint.setInitExpr("s in s0");
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
			nextExpr.append(label + "_");
		}
		nextExpr.append("};\n");
		
		for(String state: states) {
			if (state.matches(".*__")) {
				continue;
			}
			if (state.matches(".*_")) {
				nextExpr.append("\t\ts=" + state + " : " + 
						state.substring(0, state.length() - 1) + ";\n");
				continue;
			}
			Transition t = label2Trans.get(state);
			State tgt = t.getTargetState();
			if (tgt instanceof TransitionalState) {
				TransitionalState tgtTransitional = (TransitionalState) tgt;
				EList<Transition> transitions = tgtTransitional.getTransitions();
								
				for (Transition tr: transitions) {
				
					if (
						(tr.getRelatedStep() != null) &&
						(tr.getRelatedStep().getAction() instanceof UseCaseInclude)
					) {
						String label = trans2Label.get(tr);
						if (label == null) {
							label = state2Label.get(tr.getTargetState());
						}
						UseCaseInclude ui = (UseCaseInclude)tr.getRelatedStep().getAction();
						int i = includedUseCases.indexOf(ui.getIncludeTarget()) + 1;
						String tag = Integer.toString(i);
						nextExpr.append("		s=" + label + "__ & y" + tag +  ".s != sFin : " + label + "__;\n");
						nextExpr.append("		s=" + label + "__ & y" + tag +  ".s  = sFin : " + label + "_;\n");
					}
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
						String label = trans2Label.get(tr);
						if (label != null) {
							label = label + "_";
							UseCaseStep step = tr.getRelatedStep();
							if ((step != null) && (step.getAction() instanceof UseCaseInclude)) {
								label = label + "_";
							}
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
						String label = trans2Label.get(tr);
						if (label != null) {
							label = label + "_";
							UseCaseStep step = tr.getRelatedStep();
							if ((step != null) && (step.getAction() instanceof UseCaseInclude)) {
								label = label + "_";
							}
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
						String label = trans2Label.get(tr);
						if (label != null) {
							label = label + "_";
							UseCaseStep step = tr.getRelatedStep();
							if ((step != null) && (step.getAction() instanceof UseCaseInclude)) {
								label = label + "_";
							}
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
			
			if (tgt == machine.getAbortState()) {
				nextExpr.append("\t\ts=" + state + " : sAbort;\n");
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
		nextBody.setVarId("s");
		nextBody.setNextExpr(nextExpr.toString());
		assignConstraint.getBodies().add(nextBody);
		module.getModuleElement().add(assignConstraint);
	}
	
	private void generateAutomaton() {
		module = factory.createOtherModule();
		module.setName("UC_" + uc2id(useCase));
		
		FormalParameter p1 = factory.createFormalParameter();
		p1.setParamId("top");
		module.getParams().add(p1);
		
		FormalParameter p2 = factory.createFormalParameter();
		p2.setParamId("run");
		module.getParams().add(p2);
	}
}