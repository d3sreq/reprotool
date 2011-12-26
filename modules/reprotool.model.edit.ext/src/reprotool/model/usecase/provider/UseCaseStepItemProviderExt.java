package reprotool.model.usecase.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import reprotool.model.usecase.Condition;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;
import reprotool.model.usecase.UsecasePackage;
import utils.Utils;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author jvinarek
 *
 */
public class UseCaseStepItemProviderExt extends UseCaseStepItemProvider {

	public static final String USE_CASE_STEP_ITEM_PROVIDER_ANNOTATION = "USE_CASE_STEP_ITEM_PROVIDER_ANNOTATION";
	public static final String CUSTOM_CHILDREN_FEATURES_KEY = "CUSTOM_CHILDREN_FEATURES_UseCaseStepItemProvider";
	
	private List<EReference> customChildrenFeatures = null;
	
	@Inject
	public UseCaseStepItemProviderExt(@Named(USE_CASE_STEP_ITEM_PROVIDER_ANNOTATION) AdapterFactory adapterFactory) {
		super(adapterFactory);
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
	
	/**
	 * Overriden to prevent call to {@link ItemProviderAdapter} method which casts proxy to {@link ComposeableAdapterFactory}
	 * and causes {@link ClassCastException}
	 */
	@Override
	public Object getCreateChildImage(Object owner, Object feature, Object child, Collection<?> selection) {
		return null;
	}
	
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		
		// extensions & variations - add condition and first step to added extension / variation
		Utils.removeCommandParameter(newChildDescriptors, UsecasePackage.Literals.USE_CASE_STEP__EXTENSIONS);
		newChildDescriptors.add(createChildParameter(UsecasePackage.Literals.USE_CASE_STEP__EXTENSIONS,
				createFilledScenario()));
		
		Utils.removeCommandParameter(newChildDescriptors, UsecasePackage.Literals.USE_CASE_STEP__VARIATIONS);
		newChildDescriptors.add(createChildParameter(UsecasePackage.Literals.USE_CASE_STEP__VARIATIONS,
				createFilledScenario()));
	}
	
	private Scenario createFilledScenario() {
		Scenario scenario = UsecaseFactory.eINSTANCE.createScenario();
		Condition condition = UsecaseFactory.eINSTANCE.createCondition();
		scenario.setScenarioGuard(condition);
		
		UseCaseStep useCaseStep = UsecaseFactory.eINSTANCE.createUseCaseStep();
		scenario.getSteps().add(useCaseStep);
		
		return scenario;
	}

	//
	// Guice setters
	//
	
	@Inject(optional=true)
	public void setCustomChildrenFeatures(@Named(CUSTOM_CHILDREN_FEATURES_KEY) List<EReference> customChildrenFeatures) {
		this.customChildrenFeatures = customChildrenFeatures;
	}
}
