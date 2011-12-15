package reprotool.lts.export.actions;

import java.io.IOException;

import lts2.StateMachine;
import lts2.impl.LTSGeneratorImpl;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import reprotool.model.swproj.SoftwareProject;
import reprotool.model.usecase.UseCase;

public class Swproj2LTS implements IWorkbenchWindowActionDelegate {
	ISelection sel;

	@Override
	public void run(IAction action) {
		if (!(sel instanceof TreeSelection))
			return;

		// selected file
		final IFile selectedFile;
		{
			final TreeSelection tsel = (TreeSelection) sel;
			selectedFile = (IFile) tsel.getFirstElement();
		}

		// input resource containing a software project
		final SoftwareProject swproj;
		{
			final ResourceSet rs = new ResourceSetImpl();
			final URI uri = URI.createPlatformResourceURI(
					selectedFile.getFullPath().toString(), true);
			final Resource resource = rs.getResource(uri, true);

			if (resource.getContents().size() == 0)
				return;

			// root element inside the resource must be a SoftwareProject
			EObject rootEObj = resource.getContents().get(0);
			if (!(rootEObj instanceof SoftwareProject)) {
				System.out.println("NOT a SWPROJ : " + rootEObj);
				return;
			}
			swproj = (SoftwareProject) rootEObj;
		}

		// output resource representing the *.lts file
		{
			final ResourceSet rs = new ResourceSetImpl();
			final URI fileURI = URI.createPlatformResourceURI(selectedFile
					.getFullPath().addFileExtension("lts").toString(), true);
			final Resource resource = rs.createResource(fileURI);

			for (UseCase uc : swproj.getUseCases()) {
				LTSGeneratorImpl g = new LTSGeneratorImpl();
				g.processUseCase(uc);
				StateMachine machine = g.getLabelTransitionSystem();
				resource.getContents().add(machine);
			}

			try {
				resource.save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		sel = selection;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void init(IWorkbenchWindow window) {
	}
}