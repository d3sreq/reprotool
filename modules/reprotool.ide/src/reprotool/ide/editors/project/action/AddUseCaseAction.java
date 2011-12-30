package reprotool.ide.editors.project.action;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import reprotool.ide.editors.project.ProjectEditor;
import reprotool.ide.editors.project.ProjectEditorPart;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UsecaseFactory;

/**
 * Opens dialog with actor dialog and adds conceptual object using EMF command if user hits "OK".
 * 
 * @author jvinarek
 */
public class AddUseCaseAction extends AbstractAddAction {

	private SoftwareProject softwareProject;
	private EditingDomain editingDomain;
	private ProjectEditorPart projectEditorPart;
	private ProjectEditor projectEditor;

	public AddUseCaseAction(EditingDomain editingDomain, SoftwareProject softwareProject, ProjectEditorPart projectEditorPart, ProjectEditor projectEditor) {
		super("Add use case");
		this.editingDomain = editingDomain;
		this.softwareProject = softwareProject;
		this.projectEditorPart = projectEditorPart;
		this.projectEditor = projectEditor;
	}

	@Override
	public void run() {
		// add use case
		UseCase useCase = UsecaseFactory.eINSTANCE.createUseCase();
		Command addCommand = new AddCommand(editingDomain, softwareProject, SwprojPackage.Literals.SOFTWARE_PROJECT__USE_CASES, useCase);
		editingDomain.getCommandStack().execute(addCommand);
		
		// open use case editor
		URI uri = EcoreUtil.getURI(useCase);
		URIEditorInput input = new URIEditorInput(uri);

		IWorkbenchPage page = projectEditorPart.getSite().getPage();
		IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry()
				.findEditor("org.eclipselabs.reprotool.ide.UseCaseEmfEditor");

		try {
			// TODO jvinarek - workaround, resource is saved before use case
			// editor opens
			// to ensure that use case editor can retrieve use case from passed
			// URIEditorInput.
			
			projectEditor.doSave(new NullProgressMonitor());
			page.openEditor(input, desc.getId());
		} catch (PartInitException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
