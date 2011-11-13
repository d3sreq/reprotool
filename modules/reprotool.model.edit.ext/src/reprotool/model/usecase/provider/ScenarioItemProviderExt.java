package reprotool.model.usecase.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import reprotool.model.edit.ext.annotation.ScenarioItemProviderAnnotation;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UsecasePackage;

import com.google.inject.Inject;
import com.google.inject.name.Named;



/**
 * @author jvinarek
 *
 */
public class ScenarioItemProviderExt extends ScenarioItemProvider {

	public static final String CUSTOM_CHILDREN_FEATURES_KEY = "CUSTOM_CHILDREN_FEATURES_ScenarioItemProvider";
	
	private List<EReference> customChildrenFeatures = null;
	
	@Inject
	public ScenarioItemProviderExt(@ScenarioItemProviderAnnotation AdapterFactory adapterFactory) {
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
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection) {
		// scenario must have at least one step
		// disable delete if there is only one step left
		if (feature == UsecasePackage.Literals.SCENARIO__STEPS) {
			Scenario scenario = (Scenario)owner;
			if (scenario.getSteps().size() == 1) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		
		return super.createRemoveCommand(domain, owner, feature, collection);
	}
	
	//
	// Guice setters
	//
	
	@Inject(optional=true)
	public void setCustomChildrenFeatures(@Named(CUSTOM_CHILDREN_FEATURES_KEY) List<EReference> customChildrenFeatures) {
		this.customChildrenFeatures = customChildrenFeatures;
	}
	
}
