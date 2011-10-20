package reprotool.model.usecase.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

import reprotool.model.usecase.UsecasePackage;

import com.google.inject.Inject;

/**
 * @author jvinarek
 *
 */
public class ScenarioItemProviderExt extends ScenarioItemProvider {

	@Inject
	public ScenarioItemProviderExt(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.remove(UsecasePackage.Literals.SCENARIO__SCENARIO_GUARD);
		}
		return childrenFeatures;
	}
	
	
	
}
