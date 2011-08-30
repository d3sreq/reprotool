package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import reprotool.ide.editors.UseCaseEditor;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;
import reprotool.model.usecase.impl.UsecaseFactoryImpl;

public class AddScenario extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		UseCaseEditor editor = UseCaseEditor.getActiveUseCaseEditor();
		if (editor == null)
			return null;
		UseCaseStep step = editor.getSelectedStep();
		if (step == null)
			return null;
		editor.saveUndoState();
		UsecaseFactory ucFactory = new UsecaseFactoryImpl();
		Scenario scen = ucFactory.createScenario();
		UseCaseStep newStep = ucFactory.createUseCaseStep();
		// TODO - jvinarek - fix 
//		newStep.setSentence("New step");
		scen.getSteps().add(newStep);
		// TODO - jvinarek - fix
//		if (event.getCommand().getId().equals("commands.addExtension"))
//			step.getExtension().add(scen);
//		else if (event.getCommand().getId().equals("commands.addVariation"))
//			step.getVariation().add(scen);
		editor.setDirty();
		editor.setSelection(newStep);
		return null;
	}

}
