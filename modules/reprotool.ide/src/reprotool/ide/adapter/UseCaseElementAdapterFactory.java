package reprotool.ide.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;

@SuppressWarnings("rawtypes")
public class UseCaseElementAdapterFactory implements IAdapterFactory {
	private static final Class[] SUPPORTED_ADAPTERS = { IPropertySource.class };

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (IPropertySource.class.equals(adapterType)) {
			if (adaptableObject instanceof UseCaseStep)
				return new UseCaseStepPropertySource((UseCaseStep) adaptableObject);
			else if (adaptableObject instanceof Scenario)
				return new ScenarioPropertySource((Scenario) adaptableObject);
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return SUPPORTED_ADAPTERS;
	}
}
