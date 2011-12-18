package reprotool.fm.nusmv;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lts2.State;
import lts2.Transition;
import lts2.TransitionalState;

import org.eclipse.core.runtime.Assert;

import reprotool.fm.nusmv.mapping.NuSMVProj;
import reprotool.model.swproj.CounterExample;
import reprotool.model.swproj.Step;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.swproj.UseCaseTransition;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

public class NuSMVParser {
	private static String getFirstId(String name) {
		String result = null;
		
		Pattern myPattern = Pattern.compile("([^.]+)\\..*");
		Matcher m = myPattern.matcher(name);
				
		if (m.find()) {
			result = m.group(1);
		}
		
		return result;
	}
	
	private static String getNextId(String name) {
		String result = null;
		
		Pattern myPattern = Pattern.compile("[^.]+\\.(.*)");
		Matcher m = myPattern.matcher(name);
				
		if (m.find()) {
			result = m.group(1);
		}
		
		return result;
	}
	
	private static int getFirstNumber(String name) {
		if (hasIncludedIds(name)) {
			name = getFirstId(name);
		}
		String number = name.substring(1);
		return Integer.parseInt(number);
	}
	
	private static boolean hasIncludedIds(String name) {
		return name.matches(".*\\..*");
	}
	
	private static String uc2id(UseCase useCase) {
		return useCase.getName().replaceAll(" +", "_");
	}
	
	static void processVariable(String name, String value, NuSMVProj nusmvProject,
			CounterExample counterExample, HashMap<UseCaseTransition, Step> branchingStep)
	{
		if (("s0".equals(value)) || ("sFin".equals(value)) || ("sAbort".equals(value))) {
			return;
		}
		
		if (value.matches(".*_")) {
			return;
		}
						
		Pattern myPattern = Pattern.compile("x(.*)\\.s");
		Matcher m = myPattern.matcher(name);
		
		String ucId = null;
		
		if (m.find()) {
			ucId = m.group(1);
		} else {
			return;
		}
		
		if (ucId.matches(".*\\.y[0-9]+")) {
			processIncludedUseCase(ucId, value, nusmvProject, counterExample, branchingStep);
			return;
		}
				
		UseCase uc = nusmvProject.getUseCaseById(ucId);
		UseCaseTransition ucTrans = null;
		
		for (UseCaseTransition t: counterExample.getUseCaseTransitions()) {
			if (uc == t.getUseCase()) {
				ucTrans = t;
			}
		}
				
		if (ucTrans == null) {
			ucTrans = SwprojFactory.eINSTANCE.createUseCaseTransition();
			ucTrans.setUseCase(uc);
			counterExample.getUseCaseTransitions().add(ucTrans);
		}
				
		NuSMVGenerator gen = nusmvProject.getGeneratorById(ucId);
		Transition t = gen.getLabel2Trans().get(value);
		
		Assert.isNotNull(t);
		
		String prevLabel = null;
		
		TransitionalState srcState = t.getSourceState();
		boolean continuous = false;
		
		State prevTarget = null;
		List<Step> stepPath = ucTrans.getSteps();
		if (!stepPath.isEmpty()) {
			prevLabel = stepPath.get(stepPath.size() - 1).getLabel();
			Transition prevTransition = null;
			if (prevLabel != null) {
				prevTransition = gen.getLabel2Trans().get("s" + prevLabel);
				Assert.isNotNull(prevTransition);
				prevTarget = prevTransition.getTargetState();
				if (prevTarget instanceof TransitionalState) {
					TransitionalState ts = (TransitionalState) prevTarget;
					if (ts == srcState) {
						continuous = true;
					}
				}
			} else {
				continuous = true;
			}
		} else {
			continuous = true;
		}

		if (("s" + prevLabel).equals(value)) {
			// We wait until included use case ends.
			return;
		}
		
		Transition old_t = t;
		if (!continuous) {
			t = gen.findTransition(prevTarget, t.getTargetState());
			if (t != null) {
				UseCaseStep s = t.getRelatedStep();
				if (s != null) {
					String label = "s" + s.getLabel();
					if (!gen.getLabel2Trans().containsKey(label)) {
						gen.getLabel2Trans().put(label, t);
					}
				}
			} else {
				t = old_t;
			}
		}
		
		Step step = null;

		if (branchingStep.containsKey(ucTrans)) {
			step = branchingStep.get(ucTrans);
			branchingStep.remove(ucTrans);
		} else {
			step = SwprojFactory.eINSTANCE.createStep();
		}
		
		UseCaseStep s = t.getRelatedStep();
		if (s != null) {
			step.setUcStep(s);
			step.setLabel(t.getRelatedStep().getLabel());
			step.setContent(t.getRelatedStep().getContent());
		}
		
		if (!"".equals(step.getLabel()))
			ucTrans.getSteps().add(step);
	}
	
	private static void processIncludedUseCase(String varName, String value, NuSMVProj nusmvProject,
			CounterExample counterExample, HashMap<UseCaseTransition, Step> branchingStep) {		
		String baseId = getFirstId(varName);
		String nextId = getNextId(varName);
		
		Assert.isNotNull(baseId);
		Assert.isNotNull(nextId);
		
		UseCase baseUc = nusmvProject.getUseCaseById(baseId);		
		NuSMVGenerator baseGen = nusmvProject.getGeneratorById(baseId);		
		UseCase includedUc = baseGen.getIncludedUseCases().get(getFirstNumber(nextId) - 1);
		UseCaseTransition ucTrans = null;
		
		for (UseCaseTransition t: counterExample.getUseCaseTransitions()) {
			if (baseUc == t.getUseCase()) {
				ucTrans = t;
			}
		}
		
		if (ucTrans == null) {
			ucTrans = SwprojFactory.eINSTANCE.createUseCaseTransition();
			ucTrans.setUseCase(baseUc);
			counterExample.getUseCaseTransitions().add(ucTrans);
		}
		

		Step premadeStep = branchingStep.get(ucTrans);
		
		while (hasIncludedIds(nextId)) {
			baseUc = includedUc;
			baseId = uc2id(baseUc);
			Assert.isNotNull(premadeStep);
			ucTrans = premadeStep.getUseCaseTransition();
			premadeStep = branchingStep.get(ucTrans);
			nextId = getNextId(nextId);			
			baseGen = nusmvProject.getGeneratorById(baseId);			
			includedUc = baseGen.getIncludedUseCases().get(getFirstNumber(nextId) - 1);
		}
		
		if (premadeStep == null) {
			premadeStep = SwprojFactory.eINSTANCE.createStep();
			UseCaseTransition newTrans = SwprojFactory.eINSTANCE.createUseCaseTransition();
			newTrans.setUseCase(includedUc);
			premadeStep.setUseCaseTransition(newTrans);
			if (ucTrans != null) {
				branchingStep.put(ucTrans, premadeStep);
			}
		}
		
		ucTrans = premadeStep.getUseCaseTransition();
		NuSMVGenerator gen = nusmvProject.getGeneratorById(uc2id(includedUc));
		Transition t = gen.getLabel2Trans().get(value);
		
		TransitionalState srcState = t.getSourceState();
		String prevLabel = null;
		boolean continuous = false;

		State prevTarget = null;
		List<Step> stepPath = ucTrans.getSteps();
		if (!stepPath.isEmpty()) {
			prevLabel = stepPath.get(stepPath.size() - 1).getLabel();
			Transition prevTransition = null;
			if (prevLabel != null) {
				prevTransition = gen.getLabel2Trans().get("s" + prevLabel);
				Assert.isNotNull(prevTransition);
				prevTarget = prevTransition.getTargetState();
				if (prevTarget instanceof TransitionalState) {
					TransitionalState ts = (TransitionalState) prevTarget;
					if (ts == srcState) {
						continuous = true;
					}
				}
			} else {
				continuous = true;
			}
		} else {
			continuous = true;
		}
		
		if (("s" + prevLabel).equals(value)) {
			// We wait until included use case ends.
			return;
		}
		
		Transition old_t = t;
		if (!continuous) {
			t = gen.findTransition(prevTarget, t.getTargetState());
			if (t != null) {
				UseCaseStep s = t.getRelatedStep();
				if (s != null) {
					String label = "s" + s.getLabel();
					if (!gen.getLabel2Trans().containsKey(label)) {
						gen.getLabel2Trans().put(label, t);
					}
				}
			} else {
				t = old_t;
			}
		}

		Step step = null;

		if (branchingStep.containsKey(ucTrans)) {
			step = branchingStep.get(ucTrans);
			branchingStep.remove(ucTrans);
		} else {
			step = SwprojFactory.eINSTANCE.createStep();
		}
		
		UseCaseStep s = t.getRelatedStep();
		if (s != null) {
			step.setUcStep(s);
			step.setLabel(t.getRelatedStep().getLabel());
			step.setContent(t.getRelatedStep().getContent());
		}
		
		if (!"".equals(step.getLabel()))
			ucTrans.getSteps().add(step);
	}

}