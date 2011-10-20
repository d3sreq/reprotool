package reprotool.model.usecase.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import reprotool.model.edit.ext.annotation.UseCaseStepItemProviderAnnotation;
import reprotool.model.linguistic.actionpart.Text;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author jvinarek
 *
 */
public class UseCaseStepItemProviderExt extends UseCaseStepItemProvider {

	public static final String REMOVED_CHILDREN_FEATURES_KEY = "REMOVED_CHILDREN_FEATURES_UseCaseStepItemProvider";
	
	private List<EReference> removedChildrenFeatures = null;
	
	@Inject
	public UseCaseStepItemProviderExt(@UseCaseStepItemProviderAnnotation AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			if (removedChildrenFeatures != null) {
				childrenFeatures.removeAll(removedChildrenFeatures);
			}
		}
		return childrenFeatures;
	}
	
	/**
	 * Overriden to prevent call to {@link ItemProviderAdapter} method which casts proxy to {@link ComposeableAdapterFactory}
	 * and causes {@link ClassCastException}
	 */
	@Override
	public Object getCreateChildImage(Object owner, Object feature, Object child, Collection<?> selection) {
		return null;
	}
	
	@Inject(optional=true)
	public void setRemovedChildrenFeatures(@Named(REMOVED_CHILDREN_FEATURES_KEY) List<EReference> removedChildrenFeatures) {
		this.removedChildrenFeatures = removedChildrenFeatures;
	}
}
