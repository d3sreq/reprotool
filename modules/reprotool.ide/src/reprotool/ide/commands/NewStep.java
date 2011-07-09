package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import reprotool.ide.editors.UseCaseEditor;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;
import reprotool.model.usecase.impl.UsecaseFactoryImpl;

public class NewStep extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		UseCaseEditor editor = UseCaseEditor.getActiveUseCaseEditor();
		if (editor == null)
			return null;
		
		editor.saveUndoState();
		
		UseCase uc = editor.getEditedUseCase();
		UsecaseFactory ucFactory = new UsecaseFactoryImpl();
		UseCaseStep newStep = ucFactory.createUseCaseStep();
		newStep.setSentence("New step");
		
		Object selected = editor.getSelectedObject();
		if (selected == null) {
			uc.getMainScenario().getSteps().add(newStep);
		} else if (selected instanceof UseCaseStep) {
			UseCaseStep step = (UseCaseStep)selected;
			Scenario parent = (Scenario)step.eContainer();
			// add new step just after the selected step
			parent.getSteps().add(parent.getSteps().indexOf(selected)+1, newStep);
		} else if (selected instanceof Scenario) {
			Scenario scen = (Scenario)selected;
			// add new step to the beginning
			scen.getSteps().add(0, newStep);
		}
		editor.setDirty();
		editor.setSelection(newStep);
		return null;
	}
}
