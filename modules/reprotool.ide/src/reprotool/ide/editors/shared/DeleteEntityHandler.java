package reprotool.ide.editors.shared;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import reprotool.ide.editors.project.ProjectEditor;
import reprotool.ide.editors.usecase.UsecaseEMFEditor;
import reprotool.ide.utils.Utils;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.ConceptualObject;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
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
		protected Class<Scenario> getSelectionClass() {
			return Scenario.class;
		}

		@Override
		protected EditingDomain getEditingDomain() {
			return getEMFEditorEditingDomain();
		}
		
	}
	
	/**
	 * Deletes use case step selected in {@link UsecaseEMFEditor}.
	 */
	public static class DeleteStepHandler extends DeleteEntityHandler<UseCaseStep> {
	
		@Override
		protected Class<UseCaseStep> getSelectionClass() {
			return UseCaseStep.class;
		}

		@Override
		protected EditingDomain getEditingDomain() {
			return getEMFEditorEditingDomain();
		}
		
	}
	
	/**
	 * Deletes scenario selected in {@link UsecaseEMFEditor}.
	 */
	public static class DeleteAnnotationHandler extends DeleteEntityHandler<StepAnnotation> {

		@Override
		protected Class<StepAnnotation> getSelectionClass() {
			return StepAnnotation.class;
		}

		@Override
		protected EditingDomain getEditingDomain() {
			return getEMFEditorEditingDomain();
		}
		
	}
	
	/**
	 * Deletes actor selected in {@link ProjectEditor}.
	 */
	public static class DeleteActorHandler extends DeleteEntityHandler<Actor> {

		@Override
		protected Class<Actor> getSelectionClass() {
			return Actor.class;
		}

		@Override
		protected EditingDomain getEditingDomain() {
			return getProjectEditorEditingDomain();
		}
		
	}
	
	/**
	 * Deletes conceptual object selected in {@link ProjectEditor}.
	 */
	public static class DeleteConceptualObjectHandler extends DeleteEntityHandler<ConceptualObject> {

		@Override
		protected Class<ConceptualObject> getSelectionClass() {
			return ConceptualObject.class;
		}

		@Override
		protected EditingDomain getEditingDomain() {
			return getProjectEditorEditingDomain();
		}
		
	}
	
	/**
	 * Deletes use case selected in {@link ProjectEditor}.
	 */
	public static class DeleteUseCaseHandler extends DeleteEntityHandler<UseCase> {

		@Override
		protected Class<UseCase> getSelectionClass() {
			return UseCase.class;
		}

		@Override
		protected EditingDomain getEditingDomain() {
			return getProjectEditorEditingDomain();
		}
		
	}
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		T selectedObject = Utils.getSelectedObject(getSelectionClass());
		if (selectedObject == null) {
			return null;
		}
		EditingDomain editingDomain = getEditingDomain();
		if (editingDomain == null) {
			return null;
		}
		
		Command command = deleteEntityCommand(editingDomain, selectedObject);
		editingDomain.getCommandStack().execute(command);
		
		// TODO - change selection to added step

		return null;
	}
	
	protected EditingDomain getEMFEditorEditingDomain() {
		UsecaseEMFEditor usecaseEMFEditor = Utils.getEMFEditor();
		if (usecaseEMFEditor == null) {
			return null;
		}
		return usecaseEMFEditor.getEditingDomain();
	}
	
	protected EditingDomain getProjectEditorEditingDomain() {
		ProjectEditor projectEditor = Utils.getProjectEditor();
		if (projectEditor == null) {
			return null;
		}
		return projectEditor.getEditingDomain();
	}
	
	public Command deleteEntityCommand(EditingDomain editingDomain, T selectedObject) {
		return DeleteCommand.create(editingDomain, selectedObject);
	}
	
	protected abstract Class<T> getSelectionClass();
	
	protected abstract EditingDomain getEditingDomain();
}
