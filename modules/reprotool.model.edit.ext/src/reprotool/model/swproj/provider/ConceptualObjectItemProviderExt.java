package reprotool.model.swproj.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Extension of generated ConceptualObjectItemProvider class.
 * 
 * @author jvinarek
 * 
 */
public class ConceptualObjectItemProviderExt extends ConceptualObjectItemProvider {

	public static final String CONCEPTUAL_OBJECT_ITEM_PROVIDER_ANNOTATION = "CONCEPTUAL_OBJECT_ITEM_PROVIDER_ANNOTATION";
	
	@Inject
	public ConceptualObjectItemProviderExt(@Named(CONCEPTUAL_OBJECT_ITEM_PROVIDER_ANNOTATION) AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Returns parent node.
	 * 
	 * @return Non-model "Conceptual Objects" node
	 */
	@Override
	public Object getParent(Object object) {
		Object softwareProject = super.getParent(object);
		SoftwareProjectItemProviderExt softwareProjectItemProviderExt = (SoftwareProjectItemProviderExt) adapterFactory
				.adapt(softwareProject, IEditingDomainItemProvider.class);

		return softwareProjectItemProviderExt != null ? softwareProjectItemProviderExt.getConceptualObjects() : null;
	}

}
