package reprotool.model.swproj.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;

import reprotool.model.edit.ext.annotation.ActorItemProviderAnnotation;

import com.google.inject.Inject;

/**
 * Extension of generated ActorItemProvider class.
 * 
 * @author jvinarek
 * 
 */
public class ActorItemProviderExt extends ActorItemProvider {

	@Inject
	public ActorItemProviderExt(@ActorItemProviderAnnotation AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Returns parent node.
	 * 
	 * @return Non-model "Actors" node
	 */
	@Override
	public Object getParent(Object object) {
		Object softwareProject = super.getParent(object);
		SoftwareProjectItemProviderExt softwareProjectItemProviderExt = (SoftwareProjectItemProviderExt) adapterFactory
				.adapt(softwareProject, IEditingDomainItemProvider.class);

		return softwareProjectItemProviderExt != null ? softwareProjectItemProviderExt.getActors() : null;
	}

}
