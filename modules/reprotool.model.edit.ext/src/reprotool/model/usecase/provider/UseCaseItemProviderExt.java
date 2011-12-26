package reprotool.model.usecase.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;

import reprotool.model.swproj.provider.SoftwareProjectItemProviderExt;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Extension of generated UseCaseItemProvider class.
 * 
 * @author jvinarek
 * 
 */
public class UseCaseItemProviderExt extends UseCaseItemProvider {

	public static final String USE_CASE_ITEM_PROVIDER_ANNOTATION = "USE_CASE_ITEM_PROVIDER_ANNOTATION";
	public static final String CUSTOM_CHILDREN_FEATURES_KEY = "CUSTOM_CHILDREN_FEATURES_UseCaseItemProvider";
	
	private List<EReference> customChildrenFeatures = null;
	
	@Inject
	public UseCaseItemProviderExt(@Named(USE_CASE_ITEM_PROVIDER_ANNOTATION) AdapterFactory adapterFactory) {
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
			if (customChildrenFeatures != null) {
				childrenFeatures.clear();
				childrenFeatures.addAll(customChildrenFeatures);
			}
		}
		return childrenFeatures;
	}
	
	public Object getCreateChildImage(Object owner, Object feature, Object child, Collection<?> selection) {
		return null;
	}
	
	//
	// Guice setters
	//
	
	@Inject(optional=true)
	public void setCustomChildrenFeatures(@Named(CUSTOM_CHILDREN_FEATURES_KEY) List<EReference> customChildrenFeatures) {
		this.customChildrenFeatures = customChildrenFeatures;
	}
	
}
