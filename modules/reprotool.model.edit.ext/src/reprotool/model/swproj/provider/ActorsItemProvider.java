package reprotool.model.swproj.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;

import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.swproj.SwprojPackage;

public class ActorsItemProvider extends TransientSoftwareProjectItemProvider {
	public ActorsItemProvider(AdapterFactory adapterFactory, SoftwareProject softwareProject) {
		super(adapterFactory, softwareProject);
	}
	
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS);
		}
		return childrenFeatures;
	}
	
	@Override
	public String getText(Object object) {
		// TODO
		return "Actors";
	}
	
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		newChildDescriptors.add(createChildParameter(SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS, SwprojFactory.eINSTANCE.createActor()));
	}
}
