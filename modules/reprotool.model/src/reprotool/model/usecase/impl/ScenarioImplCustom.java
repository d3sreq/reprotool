package reprotool.model.usecase.impl;

import org.eclipse.emf.ecore.EObject;
import reprotool.model.usecase.UseCaseStep;

public class ScenarioImplCustom extends ScenarioImpl {

	@Override
	public String getLabel() {
		
		EObject scenarioParent = this.eContainer();
		if (!(scenarioParent instanceof UseCaseStep))
			return ""; // child elements depend on this value
		
		UseCaseStep parentUseCaseStep = (UseCaseStep) scenarioParent;
		
		// find scenario among extensions 
		int labelIndex = parentUseCaseStep.getExtensions().indexOf(this);

		// find scenario among variations
		if (labelIndex == -1) {
			labelIndex = parentUseCaseStep.getVariations().indexOf(this);

			if (labelIndex != -1)
				labelIndex += parentUseCaseStep.getExtensions().size();
		}
		
		// label still not found
		if (labelIndex == -1)
			return ""; // child elements depend on this value

		// now we can finally return the correct label
		return parentUseCaseStep.getLabel() + String.valueOf( (char)('a' + labelIndex) );
	}
}
