package reprotool.ide.editors.usecase.sentenceanalysis.action;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.progress.IProgressConstants;
import org.eclipse.ui.progress.IProgressService;
import org.eclipse.ui.statushandlers.StatusManager;

import reprotool.ide.Activator;
import reprotool.ide.editors.usecase.UsecaseEMFEditor;
import reprotool.ling.LingTools;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

/**
 * 
 * @author jvinarek
 * 
 */
public class AutomaticAnalysisAllAction extends BaseSelectionListenerAction {

	private ImageDescriptor imageDescriptor;
	private IAction refreshEditorAction;

	public AutomaticAnalysisAllAction(String text, String tooltip, IAction refreshEditorAction) {
		super(text);
		imageDescriptor = Activator.getImageDescriptor("icons/table-lightning-16x16.png");
		this.setToolTipText(tooltip);
		this.refreshEditorAction = refreshEditorAction;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// icon from
		// http://www.softplatz.net/Downloads/Desktop/Icons-Cursors/Free-PI-Diagona-Icons-Pack.html
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

		UseCaseStep useCaseStep = (UseCaseStep) elem;
		final UseCase useCase = useCaseStep.getUseCaseShortcut();
		final EditingDomain editingDomain = getEditingDomain();

		// run analysis in separate thread to prevent UI blocking
		// - open modal dialog to prevent model change
		IWorkbench wb = PlatformUI.getWorkbench();
		IProgressService ps = wb.getProgressService();
		try {
			ps.run(true, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor pm) {
					final CompoundCommand command = LingTools.analyseUseCase(editingDomain, useCase);
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							editingDomain.getCommandStack().execute(command);
							refreshEditorAction.run();
						}
					});
				}
			});
		} catch (InvocationTargetException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error ling. tools analysis", e);
			StatusManager.getManager().handle(status, StatusManager.BLOCK | StatusManager.LOG);
		} catch (InterruptedException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error ling. tools analysis", e);
			StatusManager.getManager().handle(status, StatusManager.BLOCK | StatusManager.LOG);
		}
	}

	private EditingDomain getEditingDomain() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow window = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();

		IEditorPart editorPart = page.getActiveEditor();

		if (!(editorPart instanceof UsecaseEMFEditor)) {
			return null;
		}
		UsecaseEMFEditor usecaseEMFEditor = (UsecaseEMFEditor) editorPart;
		EditingDomain editingDomain = usecaseEMFEditor.getEditingDomain();

		return editingDomain;
	}
}
