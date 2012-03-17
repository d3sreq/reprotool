package reprotool.ide.editors.usecase;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import reprotool.ide.utils.Utils;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;

/**
 * 
 * 
 * @author jvinarek
 *
 */
public class EditStepHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		UsecaseEMFEditor usecaseEMFEditor = Utils.getEMFEditor();
		if (usecaseEMFEditor == null) {
			return null;
		}
		
		UseCaseStep useCaseStep = Utils.getSelectedObject(UseCaseStep.class);
		if (useCaseStep != null) {
			usecaseEMFEditor.editObject(useCaseStep);
			return null;
		}
		
		Scenario scenario = Utils.getSelectedObject(Scenario.class);
		if (scenario != null) {
			usecaseEMFEditor.editObject(scenario);
		}
		
		return null;
	}
	
}
