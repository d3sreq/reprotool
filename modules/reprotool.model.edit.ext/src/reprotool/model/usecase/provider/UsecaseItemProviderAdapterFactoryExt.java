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

	@Inject
	UsecaseItemProviderAdapterFactoryExt(UseCaseItemProvider useCaseItemProvider, UseCaseStepItemProvider useCaseStepItemProvider) {
		this.useCaseItemProvider = useCaseItemProvider;
		this.useCaseStepItemProvider = useCaseStepItemProvider;
	}
	
}
