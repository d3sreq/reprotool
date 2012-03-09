package reprotool.ide.utils;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import reprotool.ide.editors.project.ProjectEditor;
import reprotool.ide.editors.usecase.UsecaseEMFEditor;
import reprotool.model.usecase.Condition;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;

/**
 * Helper methods
 * 
 * @author jvinarek
 *
 */
public class Utils {
	
	/**
	 * Adds focus listener to control changing selection provider to the given
	 * selection provider on {@link FocusAdapter#focusGained(FocusEvent)}.
	 * 
	 * @param selectionProviderIntermediate "wrapper" to set selection provider into  
	 * @param control control gaining focus
	 * @param provider provider to be set into {@code selectionProviderIntermediate} 
	 */
	public static void addSelectionFocusListener(final SelectionProviderIntermediate selectionProviderIntermediate, Control control, final ISelectionProvider provider) {
		control.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				selectionProviderIntermediate.setSelectionProviderDelegate(provider);
			}
		});
	}
	
	
	private static IWorkbenchPage getPage() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
		return window.getActivePage();
	}
	
	/**
	 * @return Active {@link UsecaseEMFEditor} or <code>null</code> if another (or none) editor 
	 * 	is active
	 */
	public static UsecaseEMFEditor getEMFEditor() {
		IWorkbenchPage page = getPage();
		IEditorPart editorPart = page.getActiveEditor();
	
		if (!(editorPart instanceof UsecaseEMFEditor)) {
			return null;
		}
		return (UsecaseEMFEditor)editorPart;
	}
	
	/**
	 * @return Active {@link ProjectEditor} or <code>null</code> if another (or none) editor 
	 * 	is active
	 */
	public static ProjectEditor getProjectEditor() {
		IWorkbenchPage page = getPage();
		IEditorPart editorPart = page.getActiveEditor();
	
		if (!(editorPart instanceof ProjectEditor)) {
			return null;
		}
		return (ProjectEditor)editorPart;
	}


	/**
	 * Returns first selected object if it has specified type 
	 * (or is subclass of the specified type) otherwise returns <code>null</code>
	 * 
	 * @param clazz type of the selection
	 * @return selection of the given type or <code>null</code>
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getSelectedObject(Class<T> clazz) {
		ISelection selection = getPage().getSelection();
		if (!(selection instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection structuredSelection = (IStructuredSelection)selection;
		Object firstElement = structuredSelection.getFirstElement();
		Class<?> selectionClass = firstElement.getClass();
		if (!(clazz.isAssignableFrom(selectionClass))) {
			return null;
		}
		
		return (T) firstElement; 
	}
	
	/**
	 * Creates {@link Scenario} with first {@link UseCaseStep} and set {@link Condition}.
	 * 
	 * @return created {@link Scenario}
	 */
	public static Scenario createFilledScenario() {
		Scenario scenario = UsecaseFactory.eINSTANCE.createScenario();
		Condition condition = UsecaseFactory.eINSTANCE.createCondition();
		scenario.setScenarioGuard(condition);
		
		UseCaseStep firstUseCaseStep = UsecaseFactory.eINSTANCE.createUseCaseStep();
		scenario.getSteps().add(firstUseCaseStep);
		return scenario;
	}
}
