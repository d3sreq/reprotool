package reprotool.txtimport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.ui.console.MessageConsoleStream;

import reprotool.ide.txtuc.txtUseCase.ExtVarBlock;
import reprotool.ide.txtuc.txtUseCase.ExtVarStep;
import reprotool.ide.txtuc.txtUseCase.ExtVarUnit;
import reprotool.ide.txtuc.txtUseCase.MainScenarioStep;
import reprotool.model.usecase.Condition;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;

public class UseCaseGenerator {
	private reprotool.ide.txtuc.txtUseCase.UseCase iUseCase;
	private UseCase oUseCase;
	private MessageConsoleStream logger;
	private HashMap<String, Scenario> label2Scenario = new HashMap<String, Scenario>();
	private HashMap<String, UseCaseStep> label2UCStep = new HashMap<String, UseCaseStep>();
	private List<ScenarioMapper> strayScenarios = new ArrayList<ScenarioMapper>();
	
	public UseCaseGenerator(reprotool.ide.txtuc.txtUseCase.UseCase u, MessageConsoleStream logger) {
		iUseCase = u;
		this.logger = logger;
	}
	
	private void processExtVarBlock(ExtVarBlock block, UsecaseFactory factory, boolean extension) {		
		for (ExtVarUnit unit: block.getUnits()) {
			reprotool.ide.txtuc.txtUseCase.Condition cond = unit.getCondition();
			Scenario extVarScenario = factory.createScenario();
			Condition c = factory.createCondition();
			c.setContent(cond.getText());
			extVarScenario.setScenarioGuard(c);
			
			String stepLabel = null;
			if (!cond.getLabel().isEmpty()) {
				stepLabel = cond.getLabel().substring(0, cond.getLabel().length() - 1);
			}
			
			UseCaseStep step = label2UCStep.get(stepLabel);
			
			if (step != null) {
				if (extension) {
					step.getExtensions().add(extVarScenario);
				} else {
					step.getVariations().add(extVarScenario);
				}
			} else {
				strayScenarios.add(new ScenarioMapper(extVarScenario, stepLabel, extension));
			}
			
			label2Scenario.put(cond.getLabel(), extVarScenario);
		}
		
		for (ExtVarUnit unit: block.getUnits()) {
			for (ExtVarStep step: unit.getSteps()) {
				StringBuffer content = new StringBuffer();
				int c = step.getText().size();
				int i = 0;
				for (String s: step.getText()) {
					content.append(s);
					if (i < c - 1) {
						content.append(' ');
					}
					i++;
				}
				UseCaseStep ucStep = factory.createUseCaseStep();
				ucStep.setContent(content.toString());
				
				String scenarioLabel = null;
				if (!step.getLabel().isEmpty()) {
					scenarioLabel = step.getLabel().substring(0, step.getLabel().length() - 1);
				}
				Scenario scenario = label2Scenario.get(scenarioLabel);
				if (scenario == null) {
					logger.println("[Import] Warning: Scenario with label \"" + scenarioLabel + "\" not found.");
					continue;
				}
				scenario.getSteps().add(ucStep);
				
				label2UCStep.put(step.getLabel(), ucStep);			
			}
		}
	}
	
	private void processStrayScenarios() {
		for (ScenarioMapper sMapper: strayScenarios) {
			Scenario s = sMapper.getScenario();
			String stepLabel = sMapper.getLabel();
			boolean extension = sMapper.getExtension();
			UseCaseStep ucStep = label2UCStep.get(stepLabel);
			if (ucStep == null) {
				logger.println("[Import] Warning: Use-case step with label \"" + stepLabel + "\" not found.");
				continue;
			}
			if (extension) {
				ucStep.getExtensions().add(s);
			} else {
				ucStep.getVariations().add(s);
			}
		}				
	}
	
	public reprotool.model.usecase.UseCase generateUseCase() {
		UsecaseFactory factory = UsecaseFactory.eINSTANCE;
		oUseCase = factory.createUseCase();
		oUseCase.setName(iUseCase.getName());
		
		StringBuffer desc = new StringBuffer();
		int c = iUseCase.getHeader().getDescription().size();
		int i = 0;
		for (String s: iUseCase.getHeader().getDescription()) {
			desc.append(s);
			if (i < c - 1) {
				desc.append(' ');
			}
			i++;
		}
		oUseCase.setDescription(desc.toString());
		
		Scenario mainScenario = factory.createScenario();
		
		for (MainScenarioStep step : iUseCase.getMainScenarioBlock().getSteps()) {
			StringBuffer content = new StringBuffer();
			
			c = step.getText().size();
			i = 0;
			for (String s: step.getText()) {
				content.append(s);
				if (i < c - 1) {
					content.append(' ');
				}
				i++;
			}
			UseCaseStep ucStep = factory.createUseCaseStep();
			ucStep.setContent(content.toString());
			mainScenario.getSteps().add(ucStep);
			
			label2UCStep.put(ucStep.getLabel(), ucStep);			
		}
		
		oUseCase.setMainScenario(mainScenario);
		
		if (iUseCase.getExtensionsBlock() != null) {
			processExtVarBlock(iUseCase.getExtensionsBlock(), factory, true);
		}
		
		if (iUseCase.getVariationsBlock() != null) {
			processExtVarBlock(iUseCase.getVariationsBlock(), factory, false);
		}
		
		processStrayScenarios();
		
		return oUseCase;
	}
}

class ScenarioMapper {
	private Scenario s;
	private String l;
	private boolean ext;
	
	ScenarioMapper(Scenario scenario, String label, boolean extension) {
		l = label;
		s = scenario;
		ext = extension;
	}
	
	Scenario getScenario() {
		return s;
	}
	
	String getLabel() {
		return l;
	}
	
	boolean getExtension() {
		return ext;
	}
}