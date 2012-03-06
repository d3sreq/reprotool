package reprotool.txtimport;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Injector;

import reprotool.ide.txtuc.txtUseCase.UseCase;
import reprotool.ide.txtuc.ui.internal.TxtUseCaseActivator;

public class ModelGenerator {	
	final private Injector injector = TxtUseCaseActivator
	        .getInstance().getInjector(TxtUseCaseActivator.REPROTOOL_IDE_TXTUC_TXTUSECASE);
	private MessageConsoleStream logger;
	
	public ModelGenerator(MessageConsoleStream logger) {
		this.logger = logger;
	}
	
	public UseCase getUseCase(URI txtUCResource) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(txtUCResource.segment(1));
		XtextResourceSet resourceSet = (XtextResourceSet) injector.getInstance(XtextResourceSetProvider.class).get(project);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.getResource(txtUCResource, true);
		Object model = null;
		
		try {
			model = resource.getContents().get(0);
		} catch (Exception e) {}
		
		if (model instanceof UseCase) {
			return (UseCase) model;
		}
		
		logger.println("[Import] Error: Use-case model load for " + txtUCResource + " failed!");
		return null;
	}
}