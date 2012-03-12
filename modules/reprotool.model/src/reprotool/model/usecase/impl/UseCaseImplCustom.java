package reprotool.model.usecase.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreEList;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

public class UseCaseImplCustom extends UseCaseImpl {

	@Override
	public EList<UseCaseStep> getAllUseCaseStepsShortcut() {
		ArrayList<UseCaseStep> steps = new ArrayList<UseCaseStep>();
		getStepsFromScenario(this.getMainScenario(), steps);
		return new EcoreEList.UnmodifiableEList<UseCaseStep>(this,
                UsecasePackage.eINSTANCE.getUseCase_AllUseCaseStepsShortcut(),
                steps.size(), steps.toArray());
	}
	
	private void getStepsFromScenario(Scenario scenario, List<UseCaseStep> result) {
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
