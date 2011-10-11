package reprotool.model.usecase.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;

import reprotool.model.swproj.provider.SoftwareProjectItemProviderExt;

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

}
