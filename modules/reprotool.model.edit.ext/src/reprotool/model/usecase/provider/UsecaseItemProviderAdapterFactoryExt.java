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

}
