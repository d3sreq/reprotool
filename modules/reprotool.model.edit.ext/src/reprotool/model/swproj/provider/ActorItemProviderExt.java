package reprotool.model.swproj.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;

import reprotool.model.edit.ext.common.ReprotoolEditExtPlugin;
import reprotool.model.swproj.Actor;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Extension of generated ActorItemProvider class.
 * 
 * @author jvinarek
 * 
 */
public class ActorItemProviderExt extends ActorItemProvider {

	public static final String ACTOR_ITEM_PROVIDER_ANNOTATION = "ACTOR_ITEM_PROVIDER_ANNOTATION";
	
	@Inject
	public ActorItemProviderExt(@Named(ACTOR_ITEM_PROVIDER_ANNOTATION) AdapterFactory adapterFactory) {
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
	
	@Override
	public Object getImage(Object object) {
		return ReprotoolEditExtPlugin.INSTANCE.getImage("full/obj16/user.png");
	}
	
	@Override
	public String getText(Object object) {
		String label = ((Actor) object).getName();
		return label == null || label.length() == 0 ? "<unnamed actor>" : label;
	}

}
