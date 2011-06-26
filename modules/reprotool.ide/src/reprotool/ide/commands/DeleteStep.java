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
		editor.deleteItem(editor.getSelectedObject());
		editor.setDirty();
		return null;
	}
}