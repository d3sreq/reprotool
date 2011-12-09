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
		if( ! (sel instanceof TreeSelection) )
			return;
		
		TreeSelection tsel = (TreeSelection) sel;
		IFile ifile = (IFile) tsel.getFirstElement();			
		ResourceSet rs = new ResourceSetImpl();
		
		URI uri = URI.createPlatformResourceURI(ifile.getFullPath().toString(), true);
		Resource resource = rs.getResource(uri, true);
		
		if(resource.getContents().size() == 0)
			return;
		
		EObject rootEObj = resource.getContents().get(0);
		
		if( ! (rootEObj instanceof SoftwareProject) ) {
			System.out.println("NOT a SWPROJ : " + rootEObj);
			return;
		}
		SoftwareProject swproj = (SoftwareProject) rootEObj;

		rs = new ResourceSetImpl();
		URI fileURI = URI.createPlatformResourceURI(
				ifile.getFullPath().addFileExtension("lts").toString(), true);
		resource = rs.createResource(fileURI);
		
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