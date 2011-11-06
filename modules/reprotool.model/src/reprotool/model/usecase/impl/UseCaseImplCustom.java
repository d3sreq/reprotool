package reprotool.model.usecase.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;

public class UseCaseImplCustom extends UseCaseImpl {

	@Override
	public EList<UseCaseStep> getAllUseCaseStepsShortcut() {
		return getStepsFromScenario(this.getMainScenario());
	}
	
	private EList<UseCaseStep> getStepsFromScenario(Scenario scenario) {
		EList<UseCaseStep> list = new BasicEList<UseCaseStep>();  
		
		// check is needed, exception was thrown when deleting use case or actor
		if (scenario != null) {
			list.addAll(scenario.getSteps());
			// TODO - jvinarek - add recursion, get steps from extensions & variations. 
		}
		
		return list;
	}
	
}
