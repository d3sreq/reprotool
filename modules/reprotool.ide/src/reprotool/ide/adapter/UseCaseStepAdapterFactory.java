package reprotool.ide.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

import reprotool.model.usecase.UseCaseStep;

@SuppressWarnings("rawtypes")
public class UseCaseStepAdapterFactory implements IAdapterFactory {
	private static final Class[] SUPPORTED_ADAPTERS = { IPropertySource.class };

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (IPropertySource.class.equals(adapterType)) {
			return new UseCaseStepPropertySource((UseCaseStep) adaptableObject);
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return SUPPORTED_ADAPTERS;
	}
}
