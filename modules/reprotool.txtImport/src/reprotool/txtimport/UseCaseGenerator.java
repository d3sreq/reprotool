package reprotool.txtimport;

import reprotool.ide.txtuc.txtUseCase.MainScenarioStep;
import reprotool.ide.txtuc.txtUseCase.UseCase;
//import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;

public class UseCaseGenerator {
	UseCase iUseCase;
	reprotool.model.usecase.UseCase oUseCase;
	
	public UseCaseGenerator(UseCase u) {
		iUseCase = u;
	}
	
	public reprotool.model.usecase.UseCase generateUseCase() {
		reprotool.model.usecase.UsecaseFactory factory = reprotool.model.usecase.UsecaseFactory.eINSTANCE;
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
		}
		
		oUseCase.setMainScenario(mainScenario);
		
		return oUseCase;
	}
}