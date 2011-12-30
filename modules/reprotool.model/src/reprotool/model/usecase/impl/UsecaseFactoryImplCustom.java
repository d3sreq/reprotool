package reprotool.model.usecase.impl;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;

/**
 * @author jvinarek
 *
 */
public class UsecaseFactoryImplCustom extends UsecaseFactoryImpl {
	
	@Override
	public UseCase createUseCase() {
		// creates use case with main scenario and one use case step
		UseCase useCase = super.createUseCase();
		Scenario scenario = createScenario();
		UseCaseStep useCaseStep = UsecaseFactory.eINSTANCE.createUseCaseStep();
		useCase.setMainScenario(scenario);
		scenario.getSteps().add(useCaseStep);
		return useCase;
	}
}
