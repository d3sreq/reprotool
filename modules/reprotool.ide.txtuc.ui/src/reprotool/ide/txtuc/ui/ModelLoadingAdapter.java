package reprotool.ide.txtuc.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Inject;
import reprotool.ide.txtuc.txtUseCase.UseCase;

@SuppressWarnings("rawtypes")
public class ModelLoadingAdapter implements IAdapterFactory {	
	@Inject
	private XtextResourceSetProvider resourceSetProvider;
	
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == UseCase.class) {
			if (adaptableObject instanceof URI) {
				URI uri = (URI) adaptableObject;
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(uri.segment(1));
				System.out.println("Project name: " + project.getName());
				XtextResourceSet resourceSet = (XtextResourceSet) resourceSetProvider.get(project);
				resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
				Resource resource = resourceSet.getResource(uri, true);
				UseCase model = (UseCase) resource.getContents().get(0);
				return model;
			}
		}
		return null;
	}
	
	@Override
	public Class[] getAdapterList() {
		return new Class[] {UseCase.class};
	}
}