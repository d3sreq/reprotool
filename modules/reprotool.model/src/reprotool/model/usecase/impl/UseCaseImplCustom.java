package reprotool.model.usecase.impl;

import org.eclipse.emf.common.util.EList;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;

public class UseCaseImplCustom extends UseCaseImpl {

	@Override
	public EList<UseCaseStep> getAllUseCaseStepsShortcut() {
		return getStepsFromScenario(this.getMainScenario());
	}
	
	private EList<UseCaseStep> getStepsFromScenario(Scenario scenario) {
		// check is needed, exception was thrown when deleting actor
		if (scenario == null) {
			return null;
		}
		
		// TODO - jvinarek - add recursion, get steps from extensions & variations. 
		return scenario.getSteps();
	}
	
}
