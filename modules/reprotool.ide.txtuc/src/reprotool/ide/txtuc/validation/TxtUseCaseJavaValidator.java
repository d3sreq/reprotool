package reprotool.ide.txtuc.validation;

import org.eclipse.xtext.validation.Check;

import reprotool.ide.txtuc.txtUseCase.MainScenarioBlock;
import reprotool.ide.txtuc.txtUseCase.MainScenarioStep;
import reprotool.ide.txtuc.txtUseCase.TxtUseCasePackage;
 

public class TxtUseCaseJavaValidator extends AbstractTxtUseCaseJavaValidator {

	/**
	 * Checks that steps in main scenario form consecutive sequence starting from "1".
	 * 
	 * @param mainScenario
	 */
	@Check
	public void checkMainScenarioLabelSequence(MainScenarioStep step) {
		MainScenarioBlock mainScenarioBlock = (MainScenarioBlock)step.eContainer();
		int expected = mainScenarioBlock.getSteps().indexOf(step) + 1;
		int found = Integer.parseInt(step.getLabel()); 
		if (found != expected) {
			String message = String.format("Expected step label \"%d\" found \"%d\"", expected, found);
			error(message, TxtUseCasePackage.Literals.MAIN_SCENARIO_STEP__LABEL);
		}
	}
	
	
	// TODO - ExtVarBlock - step labels form sequence (i.e. - 1a1, 1a3 <- missing 1a2)
	// TODO - ExtVarBlock - steps belong to condition (i.e. - 1a1, 1a2 after 2b <- steps should start with 2b)
	// TODO - conditions belong to step (i.e - steps 1-5, cond. 6a <- step 6 missing)
	// TODO - conditions letters form "sequence" (i.e. - found 1b but 1a is missing) 
	 
}
