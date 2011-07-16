package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
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
		EObject selected = (EObject)editor.getSelectedObject();
		if (selected == null)
			return null;
		
		editor.saveUndoState();
		
		EObject clone = EcoreUtil.copy(selected);
		if (selected instanceof UseCaseStep) {
			Scenario parent = (Scenario)selected.eContainer();
			// add new step just after the selected step
			parent.getSteps().add(parent.getSteps().indexOf(selected)+1, (UseCaseStep)clone);
		} else if (selected instanceof Scenario) {
			UseCaseStep parent = (UseCaseStep)selected.eContainer();
			if (parent.getExtension().contains(selected))
				parent.getExtension().add((Scenario)clone);
			else
				parent.getVariation().add((Scenario)clone);
		}
		
		editor.fixDuplicateIDs();
		editor.setDirty();
		editor.setSelection(clone);
		return null;
	}
}
