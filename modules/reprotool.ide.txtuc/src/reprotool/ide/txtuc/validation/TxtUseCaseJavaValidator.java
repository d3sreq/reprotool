package reprotool.ide.txtuc.validation;

import org.eclipse.xtext.validation.Check;

import reprotool.ide.txtuc.txtUseCase.Condition;
import reprotool.ide.txtuc.txtUseCase.ExtVarBlock;
import reprotool.ide.txtuc.txtUseCase.ExtVarStep;
import reprotool.ide.txtuc.txtUseCase.ExtVarUnit;
import reprotool.ide.txtuc.txtUseCase.MainScenarioBlock;
import reprotool.ide.txtuc.txtUseCase.MainScenarioStep;
import reprotool.ide.txtuc.txtUseCase.TxtUseCasePackage;
import reprotool.ide.txtuc.txtUseCase.UseCase;
 

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
	
	@Check
	public void checkExtVarLabelSequence(ExtVarStep step) {
		String stepLabel = step.getLabel();
		ExtVarUnit u = (ExtVarUnit) step.eContainer();
		if (u.getCondition() == null) {
			return;
		}
				
		String condLabel = u.getCondition().getLabel();
		
		if (!(stepLabel.startsWith(condLabel))) {
			String message = "Label of this step needs to start with the sequence \"" + condLabel + "\"";
			error(message, TxtUseCasePackage.Literals.EXT_VAR_STEP__LABEL);
			return;
		}
		
		int index = u.getSteps().indexOf(step);
		String ext = Integer.toString(index + 1);
		String expectedLabel = condLabel + ext;
		
		if (!stepLabel.equals(expectedLabel)) {
			String message = String.format("Expected step label \"%s\" found \"%s\"", expectedLabel, stepLabel);
			error(message, TxtUseCasePackage.Literals.EXT_VAR_STEP__LABEL);			
		}
	}
	
	@Check
	public void checkConditionLabel(Condition cond) {		
		String condLabel = cond.getLabel();
		String stepLabel = condLabel.substring(0, condLabel.length() - 1);
		ExtVarUnit u = (ExtVarUnit) cond.eContainer();
		ExtVarBlock extVarBlock = (ExtVarBlock) u.eContainer();
		UseCase uc = (UseCase) extVarBlock.eContainer();
		
		int counter = 0;
		if (uc.getExtensionsBlock() != null) {
			for (ExtVarUnit unit: uc.getExtensionsBlock().getUnits()) {
				Condition c = unit.getCondition();
				if (c.getLabel().equals(condLabel)) {
					counter++;
					if (counter > 1) {
						break;
					}
				}
			}
		}
		if (uc.getVariationsBlock() != null) {
			if (counter <= 1) {
				for (ExtVarUnit unit: uc.getVariationsBlock().getUnits()) {
					Condition c = unit.getCondition();
					if (c.getLabel().equals(condLabel)) {
						counter++;
					}
				}
			}
		}
		
		if (counter > 1) {
			String message = "The condition label " + condLabel + " has been used multiple times.";
			error(message, TxtUseCasePackage.Literals.CONDITION__LABEL);
			return;
		}
		
		Character lastChar = condLabel.charAt(condLabel.length() - 1);
		boolean found = false;
		
		if (lastChar == 'a') {
			found = true;
		}
		
		if ((!found) && (Character.isLetterOrDigit(lastChar))) {
			int value = (int) lastChar;
			Character prev = (char) (value - 1);
			String prevCondLabel = stepLabel + prev;
			for (ExtVarUnit unit: extVarBlock.getUnits()) {
				Condition c = unit.getCondition();
				if (prevCondLabel.equals(c.getLabel())) {
					found = true;
					break;
				}
			}
			
			if ((!found) && (extVarBlock == uc.getVariationsBlock())) {
				for (ExtVarUnit unit: uc.getExtensionsBlock().getUnits()) {
					Condition c = unit.getCondition();
					if (prevCondLabel.equals(c.getLabel())) {
						found = true;
						break;
					}
				}
			}
			
			if (!found) {
				String message = "The condition with label " + prevCondLabel + " is missing.";
				error(message, TxtUseCasePackage.Literals.CONDITION__LABEL);
				return;
			}
		}
		
		found = false;
		for (MainScenarioStep step: uc.getMainScenarioBlock().getSteps()) {
			if (step.getLabel().equals(stepLabel)) {
				found = true;
				break;
			}
		}
		
		if (!found && (uc.getExtensionsBlock() != null)) {
			outer: for (ExtVarUnit unit: uc.getExtensionsBlock().getUnits()) {
				for (ExtVarStep step: unit.getSteps()) {
					if (step.getLabel().equals(stepLabel)) {
						found = true;
						break outer;
					}
				}
			}
		}
		
		if (!found && (uc.getVariationsBlock() != null)) {
			outer: for (ExtVarUnit unit: uc.getVariationsBlock().getUnits()) {
				for (ExtVarStep step: unit.getSteps()) {
					if (step.getLabel().equals(stepLabel)) {
						found = true;
						break outer;
					}
				}
			}
		}
		
		if (!found) {
			String message = "The use-case does not contain a step with label " + stepLabel;
			error(message, TxtUseCasePackage.Literals.CONDITION__LABEL);
			return;
		}
	}	 
}