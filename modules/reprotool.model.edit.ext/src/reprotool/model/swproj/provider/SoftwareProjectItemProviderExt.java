package reprotool.model.swproj.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;

import reprotool.model.swproj.SoftwareProject;

public class SoftwareProjectItemProviderExt extends SoftwareProjectItemProvider {

	public SoftwareProjectItemProviderExt(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	protected List children = null;

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
		// TODO - use constant instead of "0"
		return children.get(0);
	}

	public Object getUseCases() {
		// TODO - use constant instead of "0"
		return children.get(1);
	}

}
