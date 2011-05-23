package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import reprotool.ide.editors.UseCaseEditor;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.Scenario;

public class DeleteStep extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		UseCaseEditor editor = UseCaseEditor.getActiveUseCaseEditor();
		if (editor == null)
			return null;
		for (Object o : editor.getSelection()) {
			if (o instanceof UseCaseStep) {
				UseCaseStep step = (UseCaseStep)o;
				Scenario scen = (Scenario)step.eContainer();
				scen.getSteps().remove(step);
				checkEmptyScenario(scen);
			} else if (o instanceof Scenario) {
				checkEmptyScenario((Scenario)o);
			}
		}
		
		editor.refresh();
		return null;
	}

	private void checkEmptyScenario(Scenario scen) {
		// remove empty variation / extension
		if (scen.getSteps().isEmpty()) {
			if (scen.eContainer() instanceof UseCaseStep) {
				UseCaseStep parent = (UseCaseStep)scen.eContainer();
				parent.getExtension().remove(scen);
				parent.getVariation().remove(scen);
			}
		}
	}
}