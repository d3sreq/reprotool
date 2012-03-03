package reprotool.ide.editors.usecase;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;
import reprotool.model.usecase.UsecasePackage;

/**
 * Adds new use case step after currently selected use case step in the
 * currently selected {@link UsecaseEMFEditor}.
 * 
 * @author jvinarek
 * 
 */
public class AddUseCaseStepStepHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get selected use case step 
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		
		IEditorPart editorPart = page.getActiveEditor();

		if (!(editorPart instanceof UsecaseEMFEditor)) {
			return null;
		}
		UsecaseEMFEditor usecaseEMFEditor = (UsecaseEMFEditor)editorPart;
		EditingDomain editingDomain = usecaseEMFEditor.getEditingDomain();
			
		ISelection selection = page.getSelection();
		if (!(selection instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection structuredSelection = (IStructuredSelection)selection;
		if (!(structuredSelection.getFirstElement() instanceof UseCaseStep)) {
			return null;
		}
		
		UseCaseStep useCaseStep = (UseCaseStep)structuredSelection.getFirstElement();

		// add new use case step after selected step
		addStepSibling(editingDomain, useCaseStep);
		
		// TODO - change selection to added step

		return null;
	}
	
	private void addStepSibling(EditingDomain editingDomain, UseCaseStep useCaseStep) {
		UseCaseStep newStep = UsecaseFactory.eINSTANCE.createUseCaseStep();
		Scenario scenario = (Scenario)useCaseStep.eContainer();
		int index = scenario.getSteps().indexOf(useCaseStep) + 1;
		
		AddCommand addCommand = new AddCommand(editingDomain, scenario, UsecasePackage.Literals.SCENARIO__STEPS, newStep, index);
		editingDomain.getCommandStack().execute(addCommand);
	}

}
