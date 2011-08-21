package reprotool.model.swproj.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;

import reprotool.model.swproj.SoftwareProject;
import reprotool.model.usecase.provider.UseCasesItemProvider;

/**
 * @author jvinarek
 * 
 */
public class SoftwareProjectItemProviderExt extends SoftwareProjectItemProvider {

	protected List children = null;

	public SoftwareProjectItemProviderExt(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public Collection getChildren(Object object) {
		if (children == null) {
			SoftwareProject softwareProject = (SoftwareProject) object;
			children = new ArrayList();
			children.add(new UseCasesItemProvider(adapterFactory,
					softwareProject));
			children.add(new ActorsItemProvider(adapterFactory, softwareProject));
		}
		return children;
	}

	public Object getActors() {
		// TODO - jvinarek - use constant instead of "0"
		return children.get(0);
	}

	public Object getUseCases() {
		// TODO - jvinarek - use constant instead of "1"
		return children.get(1);
	}

}
