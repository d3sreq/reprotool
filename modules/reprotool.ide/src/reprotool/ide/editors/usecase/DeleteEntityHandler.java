package reprotool.ide.editors.usecase;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import reprotool.ide.utils.Utils;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.annotate.StepAnnotation;

/**
 * Abstract base class for the contained handlers.
 * 
 * @author jvinarek
 *
 */
public abstract class DeleteEntityHandler<T> extends AbstractHandler {
	
	/**
	 * Deletes scenario selected in {@link UsecaseEMFEditor}.
	 */
	public static class DeleteScenarioHandler extends DeleteEntityHandler<Scenario> {
	
		@Override
		public Command deleteEntityCommand(EditingDomain editingDomain, Scenario scenario) {
			return DeleteCommand.create(editingDomain, scenario);
		}

		@Override
		protected Class<Scenario> getSelectionClass() {
			return Scenario.class;
		}
		
	}
	
	/**
	 * Deletes use case step selected in {@link UsecaseEMFEditor}.
	 */
	public static class DeleteStepHandler extends DeleteEntityHandler<UseCaseStep> {
	
		@Override
		public Command deleteEntityCommand(EditingDomain editingDomain, UseCaseStep useCaseStep) {
			return DeleteCommand.create(editingDomain, useCaseStep);
		}

		@Override
		protected Class<UseCaseStep> getSelectionClass() {
			return UseCaseStep.class;
		}
		
	}
	
	/**
	 * Deletes scenario selected in {@link UsecaseEMFEditor}.
	 */
	public static class DeleteAnnotationHandler extends DeleteEntityHandler<StepAnnotation> {
	
		@Override
		public Command deleteEntityCommand(EditingDomain editingDomain, StepAnnotation annotation) {
			return DeleteCommand.create(editingDomain, annotation);
		}

		@Override
		protected Class<StepAnnotation> getSelectionClass() {
			return StepAnnotation.class;
		}
		
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		UsecaseEMFEditor usecaseEMFEditor = Utils.getEMFEditor();
		if (usecaseEMFEditor == null) {
			return null;
		}
		
		T selectedObject = Utils.getSelectedObject(getSelectionClass());
		if (selectedObject == null) {
			return null;
		}
		EditingDomain editingDomain = usecaseEMFEditor.getEditingDomain();
		
		Command command = deleteEntityCommand(editingDomain, selectedObject);
		editingDomain.getCommandStack().execute(command);
		
		// TODO - change selection to added step

		return null;
	}
	
	public abstract Command deleteEntityCommand(EditingDomain editingDomain, T selectedObject);

	protected abstract Class<T> getSelectionClass();
}
