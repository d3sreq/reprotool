package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.util.EcoreUtil;

import reprotool.ide.editors.UseCaseEditor;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;

public class DuplicateStep extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		UseCaseEditor editor = UseCaseEditor.getActiveUseCaseEditor();
		if (editor == null)
			return null;
		UseCaseStep selected = editor.getFirstSelectedStep();
		if (selected == null || ! (selected instanceof UseCaseStep))
			return null;
		
		// clone the EObject
		UseCaseStep newStep = EcoreUtil.copy(selected);
		
		Scenario parent = (Scenario)selected.eContainer();
		// add new step just after the selected step
		parent.getSteps().add(parent.getSteps().indexOf(selected)+1, newStep);
		editor.refresh();
		editor.setSelection(newStep);
		return null;
	}
}
