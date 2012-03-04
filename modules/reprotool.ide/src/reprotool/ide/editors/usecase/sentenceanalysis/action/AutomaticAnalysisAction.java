package reprotool.ide.editors.usecase.sentenceanalysis.action;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import reprotool.ide.Activator;
import reprotool.ide.editors.usecase.UsecaseEMFEditor;
import reprotool.ling.LingTools;
import reprotool.model.usecase.UseCaseStep;

/**
 * 
 * @author jvinarek
 *
 */
public class AutomaticAnalysisAction extends BaseSelectionListenerAction {

	private ImageDescriptor imageDescriptor;
	private IAction refreshEditorAction;
	
	public AutomaticAnalysisAction(String text, IAction refreshEditorAction) {
		super(text);
		imageDescriptor = Activator.getImageDescriptor("icons/lightning-16x16.png");
		this.refreshEditorAction = refreshEditorAction;
	}
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		// icon from http://www.softplatz.net/Downloads/Desktop/Icons-Cursors/Free-PI-Diagona-Icons-Pack.html
		return imageDescriptor;
	}

	@Override
	public void run() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection == null) {
			return;
		}
		
		Object elem = selection.getFirstElement();
		if (elem == null) {
			return;
		}
		
		if (!(elem instanceof UseCaseStep)) {
			return;
		}
		
		UseCaseStep useCaseStep = (UseCaseStep)elem;
		EditingDomain editingDomain = getEditingDomain();
		
		CompoundCommand command = LingTools.analyseUseCaseStep(editingDomain, useCaseStep);
		editingDomain.getCommandStack().execute(command);
		
		refreshEditorAction.run();
	}
	
	private EditingDomain getEditingDomain() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		
		IEditorPart editorPart = page.getActiveEditor();

		if (!(editorPart instanceof UsecaseEMFEditor)) {
			return null;
		}
		UsecaseEMFEditor usecaseEMFEditor = (UsecaseEMFEditor)editorPart;
		EditingDomain editingDomain = usecaseEMFEditor.getEditingDomain();
		
        return editingDomain; 
	}
}
