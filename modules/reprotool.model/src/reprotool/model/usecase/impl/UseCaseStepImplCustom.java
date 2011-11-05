package reprotool.model.usecase.impl;

import org.eclipse.emf.ecore.EObject;

import reprotool.model.swproj.SoftwareProject;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

public class UseCaseStepImplCustom extends UseCaseStepImpl {
	
	@Override
	public String getLabel() {
		EObject parent = this.eContainer();
		if ( !(parent instanceof Scenario) ) {
			return "";
		}
		
		Scenario scenario = (Scenario) parent;
		String stepIndex = Integer.toString( scenario.getSteps().indexOf(this) + 1 );
		
		return scenario.getLabel() + stepIndex;
	}

	@Override
	public SoftwareProject basicGetSoftwareProjectShortcut() {
		UseCase useCase = basicGetUseCaseShortcut();
		if (useCase == null) {
			return null;
		}

		SoftwareProject softwareProject = (SoftwareProject) useCase.eContainer();
		return softwareProject;
	}
	
	@Override
	public UseCase basicGetUseCaseShortcut() {
		UseCaseStep useCaseStep = this;
		while (true) {
			Scenario scenario = (Scenario) useCaseStep.eContainer();
			if (scenario == null) {
				return null; // dangling step without a scenario
			}

			EObject container = scenario.eContainer();
			if (container == null) {
				return null; // dangling scenario without a container
			}

			if (container instanceof UseCase) {
				break;
			} else { // container instanceof UseCaseStep
				useCaseStep = (UseCaseStep) container;
			}
		}

		Scenario scenario = (Scenario) useCaseStep.eContainer();
		UseCase useCase = (UseCase) scenario.eContainer();
		return useCase;
	}
	
	@Override
	public String getLabelWithContent() {
		return getLabel() + ". " + getContent();
	}
}
