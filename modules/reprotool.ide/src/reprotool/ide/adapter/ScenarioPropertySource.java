package reprotool.ide.adapter;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import reprotool.model.usecase.Scenario;

public class ScenarioPropertySource implements IPropertySource {
	private static final String ID_DESCRIPTION = "description";
	
	private Scenario scen;
	private IPropertyDescriptor[] propertyDescriptors;
	
	public ScenarioPropertySource(Scenario scen) {
		this.scen = scen;
	}

	@Override
	public Object getEditableValue() {
		return null;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		if (propertyDescriptors == null) {
            IPropertyDescriptor desc = new PropertyDescriptor(ID_DESCRIPTION, "Description");
            propertyDescriptors = new IPropertyDescriptor[] { desc };
	    }
		return propertyDescriptors;
	}

	@Override
	public Object getPropertyValue(Object id) {
		if (id.equals(ID_DESCRIPTION)) {
			if (scen.getDescription() == null)
				return "";
			else
				return scen.getDescription();
		}
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
	}

}
