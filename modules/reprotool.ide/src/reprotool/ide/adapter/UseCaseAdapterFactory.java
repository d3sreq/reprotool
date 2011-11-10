package reprotool.ide.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import reprotool.model.usecase.UseCase;

/**
 * Adapter factory to show {@link UseCase} object in outline view.
 * 
 * @author jvinarek
 *
 */
@SuppressWarnings("rawtypes")
public class UseCaseAdapterFactory implements IAdapterFactory {

	private static final Class[] SUPPORTED_ADAPTERS = { IContentOutlinePage.class };

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (IContentOutlinePage.class.equals(adapterType)) {
			return new UseCaseContentOutlinePage((UseCase)adaptableObject);
		}
		return null;
	}
	
	@Override
	public Class[] getAdapterList() {
		return SUPPORTED_ADAPTERS;
	}

}
