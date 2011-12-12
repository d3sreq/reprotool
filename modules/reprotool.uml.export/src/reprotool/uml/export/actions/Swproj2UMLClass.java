package reprotool.uml.export.actions;

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
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;

import reprotool.model.swproj.SoftwareProject;
import reprotool.uml.export.mapping.UMLGen;

public class Swproj2UMLClass implements IWorkbenchWindowActionDelegate {
	private ISelection sel;
	
	@Override
	public void run(IAction action) {
		if( ! (sel instanceof TreeSelection) )
			return;
		
		TreeSelection tsel = (TreeSelection) sel;
		IFile ifile = (IFile) tsel.getFirstElement();			
		final ResourceSet rs = new ResourceSetImpl();
		
		final URI uri = URI.createPlatformResourceURI(ifile.getFullPath().toString(), true);
		final Resource resource = rs.getResource(uri, true);
		
		if(resource.getContents().size() == 0)
			return;
		
		EObject rootEObj = resource.getContents().get(0);
		
		if( ! (rootEObj instanceof SoftwareProject) ) {
			System.out.println("NOT a SWPROJ : " + rootEObj);
			return;
		}
		SoftwareProject swproj = (SoftwareProject) rootEObj;
		
		UMLFactory factory = UMLFactory.eINSTANCE;
		Model model = factory.createModel();
				
		UMLGen umlGenerator = new UMLGen();
		umlGenerator.generateUMLModel(swproj, model);
		
		final URI umlUri = URI.createPlatformResourceURI(
			ifile.getFullPath().addFileExtension("class").addFileExtension(UMLResource.FILE_EXTENSION).toString(),
			true
		);
		
		Resource res = new ResourceSetImpl().createResource(umlUri);
        res.getContents().add(model);

		try {
			res.save(null);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		sel = selection;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}

}
