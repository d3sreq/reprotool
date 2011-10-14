/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.provider;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;

/**
 * @author jvinarek
 * 
 */
public class UsecaseItemProviderAdapterFactoryExt extends UsecaseItemProviderAdapterFactory {

	private AdapterFactory secondAdapterFactory;
	
	public UsecaseItemProviderAdapterFactoryExt(AdapterFactory secondAdapterFactory) {
		super();
		this.secondAdapterFactory = secondAdapterFactory;
	}
	
	@Override
	public Adapter createUseCaseAdapter() {
		if (useCaseItemProvider == null) {
			useCaseItemProvider = new UseCaseItemProviderExt(secondAdapterFactory);
		}
		
		return useCaseItemProvider;
	}

//	@Override
//	public Adapter createScenarioAdapter() {
//		if (scenarioItemProvider == null) {
//			scenarioItemProvider = new ScenarioItemProviderExt(this);
//		}
//
//		return scenarioItemProvider;
//	}
	
	@Override
	public Adapter createUseCaseStepAdapter() {
		if (useCaseStepItemProvider == null) {
			useCaseStepItemProvider = new UseCaseStepItemProviderExt(this);
		}

		return useCaseStepItemProvider;
	}
	
}
