package reprotool.ide.editors.usecase;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import reprotool.ide.utils.Utils;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;
import reprotool.model.usecase.UsecasePackage;
import reprotool.model.usecase.annotate.AnnotateFactory;
import reprotool.model.usecase.annotate.StepAnnotation;

/**
 * Abstract base class for the contained handlers.
 * 
 * @author jvinarek
 *
 */
public abstract class AddEntityHandler extends AbstractHandler {
	
	/**
	 * Adds new use case step after currently selected use case step in the
	 * currently selected {@link UsecaseEMFEditor}.
	 */
	public static class AddStepHandler extends AddEntityHandler {
	
		@Override
		public Command createAddEntityCommand(EditingDomain editingDomain, UseCaseStep useCaseStep) {
			UseCaseStep newStep = UsecaseFactory.eINSTANCE.createUseCaseStep();
			Scenario scenario = (Scenario)useCaseStep.eContainer();
			int index = scenario.getSteps().indexOf(useCaseStep) + 1;
			
			return new AddCommand(editingDomain, scenario, UsecasePackage.Literals.SCENARIO__STEPS, newStep, index);
		}
		
	}
	
	/**
	 * Adds extension of the currently selected use case step in the
	 * currently selected {@link UsecaseEMFEditor}.
	 */
	public static class AddExtensionHandler extends AddEntityHandler {
		
		@Override
		public Command createAddEntityCommand(EditingDomain editingDomain, UseCaseStep useCaseStep) {
			Scenario scenario = Utils.createFilledScenario();
			
			return new AddCommand(editingDomain, useCaseStep, UsecasePackage.Literals.USE_CASE_STEP__EXTENSIONS, scenario);
		}
		
	}
	
	/**
	 * Adds variation of the currently selected use case step in the
	 * currently selected {@link UsecaseEMFEditor}.
	 */
	public static class AddVariationHandler extends AddEntityHandler {
		
		@Override
		public Command createAddEntityCommand(EditingDomain editingDomain, UseCaseStep useCaseStep) {
			Scenario scenario = Utils.createFilledScenario();
			
			return new AddCommand(editingDomain, useCaseStep, UsecasePackage.Literals.USE_CASE_STEP__VARIATIONS, scenario);
		}
		
	}
	
	/**
	 * Adds step annotation to the currently selected use case step in the
	 * currently selected {@link UsecaseEMFEditor}.
	 */
	public static class AddAnnotationHandler extends AddEntityHandler {
		
		@Override
		public Command createAddEntityCommand(EditingDomain editingDomain, UseCaseStep useCaseStep) {
			StepAnnotation annotation = AnnotateFactory.eINSTANCE.createStepAnnotation();
			
			return new AddCommand(editingDomain, useCaseStep, UsecasePackage.Literals.PARSEABLE_ELEMENT__ANNOTATIONS, annotation);
		}
		
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		UsecaseEMFEditor usecaseEMFEditor = Utils.getEMFEditor();
		if (usecaseEMFEditor == null) {
			return null;
		}
		
		UseCaseStep useCaseStep = Utils.getSelectedObject(UseCaseStep.class);
		if (useCaseStep == null) {
			return null;
		}
		EditingDomain editingDomain = usecaseEMFEditor.getEditingDomain();
		
		Command command = createAddEntityCommand(editingDomain, useCaseStep);
		editingDomain.getCommandStack().execute(command);
		
		// TODO - change selection to added step

		return null;
	}
	
	public abstract Command createAddEntityCommand(EditingDomain editingDomain, UseCaseStep useCaseStep);

}
