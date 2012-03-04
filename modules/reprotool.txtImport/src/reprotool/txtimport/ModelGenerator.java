package reprotool.txtimport;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Injector;

import reprotool.ide.txtuc.txtUseCase.UseCase;
import reprotool.ide.txtuc.ui.internal.TxtUseCaseActivator;

public class ModelGenerator {	
	final private Injector injector = TxtUseCaseActivator
	        .getInstance().getInjector(TxtUseCaseActivator.REPROTOOL_IDE_TXTUC_TXTUSECASE);
	
	public UseCase getUseCase(URI txtUCResource) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(txtUCResource.segment(1));
		System.out.println("Project name: " + project.getName());
		XtextResourceSet resourceSet = (XtextResourceSet) injector.getInstance(XtextResourceSetProvider.class).get(project);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.getResource(txtUCResource, true);
		UseCase model = (UseCase) resource.getContents().get(0);
		return model;
	}
}