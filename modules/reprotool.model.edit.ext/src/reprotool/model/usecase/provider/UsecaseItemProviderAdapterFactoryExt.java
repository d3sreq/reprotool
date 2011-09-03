/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package reprotool.model.usecase.provider;

import org.eclipse.emf.common.notify.Adapter;

/**
 * @author jvinarek
 * 
 */
public class UsecaseItemProviderAdapterFactoryExt extends UsecaseItemProviderAdapterFactory {

	public UsecaseItemProviderAdapterFactoryExt() {
		super();
	}

	@Override
	public Adapter createUseCaseAdapter() {
		return new UseCaseItemProviderExt(this);
	}

}
