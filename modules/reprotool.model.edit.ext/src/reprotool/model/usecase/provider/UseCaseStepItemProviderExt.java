package reprotool.model.usecase.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

import reprotool.model.linguistic.actionpart.Text;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

/**
 * @author jvinarek
 *
 */
public class UseCaseStepItemProviderExt extends UseCaseStepItemProvider {

	public UseCaseStepItemProviderExt(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		UseCaseStep useCaseStep = (UseCaseStep)object;
		String label = useCaseStep.getLabel();
		label = label == null || label.length() == 0 ?
			getString("_UI_UseCaseStep_type") :
			getString("_UI_UseCaseStep_type") + " " + label;
			
		StringBuffer stringBuffer = new StringBuffer();
		for (Text text : useCaseStep.getTextNodes()) {
			stringBuffer.append(text.getContent());
		}
		
		if (stringBuffer.length() != 0) {
			label += " " + stringBuffer;
		}
			
		return label;
	}
	
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.remove(UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES);
		}
		return childrenFeatures;
	}
}
