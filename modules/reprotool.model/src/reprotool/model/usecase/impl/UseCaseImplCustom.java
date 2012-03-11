package reprotool.model.usecase.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;

public class UseCaseImplCustom extends UseCaseImpl {

	@Override
	public EList<UseCaseStep> getAllUseCaseStepsShortcut() {
		EList<UseCaseStep> result = new BasicEList<UseCaseStep>();
		getStepsFromScenario(this.getMainScenario(), result);
		return result;
	}
	
	private void getStepsFromScenario(Scenario scenario, EList<UseCaseStep> result) {
		// check is needed, exception was thrown when deleting actor
		if (scenario == null) {
			return;
		}
		
		for (UseCaseStep step : scenario.getSteps()) {
			result.add(step);
			
			for (Scenario extScenario : step.getExtensions()) {
				getStepsFromScenario(extScenario, result);
			}
			
			for (Scenario varScenario : step.getVariations()) {
				getStepsFromScenario(varScenario, result);
			}
		}
	}
	
	
}
