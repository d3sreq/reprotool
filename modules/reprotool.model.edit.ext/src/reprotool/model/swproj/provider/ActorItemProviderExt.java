package reprotool.model.swproj.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;

/**
 * @author jvinarek
 *
 */
public class ActorItemProviderExt extends ActorItemProvider {

	public ActorItemProviderExt(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getParent(Object object) {
		Object softwareProject = super.getParent(object);
		SoftwareProjectItemProviderExt softwareProjectItemProviderExt = (SoftwareProjectItemProviderExt) adapterFactory
				.adapt(softwareProject, IEditingDomainItemProvider.class);
		
		return softwareProjectItemProviderExt != null ? softwareProjectItemProviderExt.getActors() : null;
	}

}
