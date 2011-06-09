package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;

import reprotool.ide.editors.UseCaseEditor;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;

public class DeleteStep extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		UseCaseEditor editor = UseCaseEditor.getActiveUseCaseEditor();
		if (editor == null || editor.getSelectedObject() == null)
			return null;
		editor.saveUndoState();
		
		Object selected = editor.getSelectedObject();
		if (selected instanceof UseCaseStep) {
			UseCaseStep step = (UseCaseStep)selected;
			Scenario scen = (Scenario)step.eContainer();
			scen.getSteps().remove(step);
			checkEmptyScenario(scen);
		} else if (selected instanceof Scenario) {
			UseCaseStep parent = (UseCaseStep)((EObject)selected).eContainer();
			parent.getExtension().remove(selected);
			parent.getVariation().remove(selected);
		}
		
		editor.setDirty();
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