package reprotool.ide.adapter;

import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import reprotool.ide.editors.UseCaseEditor;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;

public class ScenarioPropertySource implements IPropertySource {
	private static final String ID_DESCRIPTION = "description";
	private static final String ID_TYPE = "type";
	
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
            IPropertyDescriptor type = new ComboBoxPropertyDescriptor(ID_TYPE, "Scenario type", new String[] {"variation", "extension"});
            propertyDescriptors = new IPropertyDescriptor[] { desc, type };
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
		} else if (id.equals(ID_TYPE)) {
			UseCaseStep parent = (UseCaseStep)scen.eContainer();
			return parent.getExtension().contains(scen) ? 1:0;
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
		if (getPropertyValue(id).equals(value))
			return;
		UseCaseEditor editor = UseCaseEditor.getActiveUseCaseEditor();
		if (id.equals(ID_TYPE)) {
			boolean setVariation = value.equals(0);
			editor.saveUndoState();
			editor.setDirty();
			UseCaseStep parent = (UseCaseStep)scen.eContainer();
			if (setVariation) {
				parent.getExtension().remove(scen);
				parent.getVariation().add(scen);
			} else {
				parent.getVariation().remove(scen);
				parent.getExtension().add(scen);
			}
			editor.refresh();
		}
	}

}
