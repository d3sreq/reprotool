/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.provider;

import reprotool.model.usecase.provider.UseCaseItemProvider;
import reprotool.model.usecase.provider.UseCaseStepItemProvider;
import reprotool.model.usecase.provider.UsecaseItemProviderAdapterFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author jvinarek
 * 
 */
@Singleton
public class UsecaseItemProviderAdapterFactoryExt extends UsecaseItemProviderAdapterFactory {
	
	@Inject(optional=true)
	public void setUseCaseItemProvider(UseCaseItemProvider useCaseItemProvider) {
		this.useCaseItemProvider = useCaseItemProvider;
	}
	
	@Inject(optional=true)
	public void setUseCaseStepItemProvider(UseCaseStepItemProvider useCaseStepItemProvider) {
		this.useCaseStepItemProvider = useCaseStepItemProvider;
	}
	
	@Inject(optional=true)
	public void setScenarioItemProvider(ScenarioItemProvider scenarioItemProvider) {
		this.scenarioItemProvider = scenarioItemProvider;
	}
	
}
