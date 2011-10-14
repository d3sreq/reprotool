package reprotool.model.usecase.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;

import reprotool.model.swproj.provider.SoftwareProjectItemProviderExt;
import reprotool.model.usecase.UsecasePackage;

/**
 * Extension of generated UseCaseItemProvider class.
 * 
 * @author jvinarek
 * 
 */
public class UseCaseItemProviderExt extends UseCaseItemProvider {

	public UseCaseItemProviderExt(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Returns parent node.
	 * 
	 * @return Non-model "Use cases" node
	 */
	@Override
	public Object getParent(Object object) {
		Object softwareProject = super.getParent(object);
		SoftwareProjectItemProviderExt softwareProjectItemProviderExt = (SoftwareProjectItemProviderExt) adapterFactory
				.adapt(softwareProject, IEditingDomainItemProvider.class);

		return softwareProjectItemProviderExt != null ? softwareProjectItemProviderExt.getUseCases() : null;
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.remove(UsecasePackage.Literals.USE_CASE__MAIN_SCENARIO);
		}
		return childrenFeatures;
	}
	
}
