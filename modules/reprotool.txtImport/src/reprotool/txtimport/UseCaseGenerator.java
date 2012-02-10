package reprotool.txtimport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.Assert;

import reprotool.ide.txtuc.txtUseCase.ExtVarBlock;
import reprotool.ide.txtuc.txtUseCase.ExtVarStep;
import reprotool.ide.txtuc.txtUseCase.MainScenarioStep;
import reprotool.model.usecase.Condition;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;

public class UseCaseGenerator {
	private reprotool.ide.txtuc.txtUseCase.UseCase iUseCase;
	private UseCase oUseCase;
	private HashMap<String, Scenario> label2Scenario = new HashMap<String, Scenario>();
	private HashMap<String, UseCaseStep> label2UCStep = new HashMap<String, UseCaseStep>();
	private List<ScenarioMapper> strayScenarios = new ArrayList<ScenarioMapper>();
	
	public UseCaseGenerator(reprotool.ide.txtuc.txtUseCase.UseCase u) {
		iUseCase = u;
	}
	
	private void processExtVarBlock(ExtVarBlock block, UsecaseFactory factory, boolean extension) {
		strayScenarios.clear();
		
		for (reprotool.ide.txtuc.txtUseCase.Condition cond: block.getConditions()) {
			Scenario extVarScenario = factory.createScenario();
			Condition c = factory.createCondition();
			c.setContent(cond.getText());
			extVarScenario.setScenarioGuard(c);
			
			String stepLabel = cond.getLabel().substring(0, cond.getLabel().length() - 1);
			UseCaseStep step = label2UCStep.get(stepLabel);
			
			if (step != null) {
				if (extension) {
					step.getExtensions().add(extVarScenario);
				} else {
					step.getVariations().add(extVarScenario);
				}
			} else {
				strayScenarios.add(new ScenarioMapper(extVarScenario, stepLabel));
			}
			
			label2Scenario.put(cond.getLabel(), extVarScenario);
			System.out.println("Scenario label:" + cond.getLabel());
		}
		
		for (ExtVarStep step: block.getSteps()) {
			StringBuffer content = new StringBuffer();
			for (String s: step.getText()) {
				content.append(s);
			}
			UseCaseStep ucStep = factory.createUseCaseStep();
			ucStep.setContent(content.toString());
			
			String scenarioLabel = step.getLabel().substring(0, step.getLabel().length() - 1);
			Scenario scenario = label2Scenario.get(scenarioLabel);
			Assert.isNotNull(scenario);
			scenario.getSteps().add(ucStep);
			
			label2UCStep.put(step.getLabel(), ucStep);			
			System.out.println("Step label: " + step.getLabel());
		}
		
		for (ScenarioMapper sMapper: strayScenarios) {
			Scenario s = sMapper.getScenario();
			String stepLabel = sMapper.getLabel();
			UseCaseStep ucStep = label2UCStep.get(stepLabel);
			Assert.isNotNull(ucStep);
			if (extension) {
				ucStep.getExtensions().add(s);
			} else {
				ucStep.getVariations().add(s);
			}
			System.out.println("Attaching stray scenario to step with label: " + ucStep.getLabel());
		}		
	}
	
	public reprotool.model.usecase.UseCase generateUseCase() {
		UsecaseFactory factory = reprotool.model.usecase.UsecaseFactory.eINSTANCE;
		oUseCase = factory.createUseCase();
		oUseCase.setName(iUseCase.getName());
		Scenario mainScenario = factory.createScenario();
		
		for (MainScenarioStep step : iUseCase.getMainScenarioBlock().getSteps()) {
			StringBuffer content = new StringBuffer();
			for (String s: step.getText()) {
				content.append(s);
			}
			UseCaseStep ucStep = factory.createUseCaseStep();
			ucStep.setContent(content.toString());
			mainScenario.getSteps().add(ucStep);
			
			label2UCStep.put(ucStep.getLabel(), ucStep);			
			System.out.println("Step label: " + ucStep.getLabel());
		}
		
		oUseCase.setMainScenario(mainScenario);
		
		processExtVarBlock(iUseCase.getExtensionsBlock(), factory, true);
		processExtVarBlock(iUseCase.getVariationsBlock(), factory, false);
		
		return oUseCase;
	}
}

class ScenarioMapper {
	private Scenario s;
	private String l;
	
	ScenarioMapper(Scenario scenario, String label) {
		l = label;
		s = scenario;
	}
	
	Scenario getScenario() {
		return s;
	}
	
	String getLabel() {
		return l;
	}
}