//package reprotool.model.usecase.provider;
//
//import java.util.Collection;
//
//import org.eclipse.emf.common.notify.AdapterFactory;
//import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.ecore.EStructuralFeature;
//
//import com.google.inject.Inject;
//
//import reprotool.model.linguistic.actionpart.Text;
//import reprotool.model.usecase.Scenario;
//import reprotool.model.usecase.UseCaseStep;
//import reprotool.model.usecase.UsecasePackage;
//
///**
// * @author jvinarek
// *
// */
//public class ScenarioItemProviderExt extends ScenarioItemProvider {
//
//	@Inject
//	public ScenarioItemProviderExt(AdapterFactory adapterFactory) {
//		super(adapterFactory);
//	}
//
//	@Override
//	public String getText(Object object) {
//		Scenario scenario = (Scenario)object;
//		String label = getString("_UI_Scenario_type");
//		
//		EObject parent = scenario.eContainer();
//		if (parent instanceof UseCaseStep) {
//			if (scenario.getScenarioGuard() != null) {
//				label += " " + scenario.getLabel();
//				
//				StringBuffer stringBuffer = new StringBuffer();
//				for (Text text : scenario.getScenarioGuard().getTextNodes()) {
//					stringBuffer.append(text.getContent());
//				}
//				
//				if (stringBuffer.length() != 0) {
//					label += " " + stringBuffer;
//				}
//			}
//		} else {
//			label += " " + "Main scenario";
//		}
//		
//		return label;
//	}
//	
//	@Override
//	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
//		if (childrenFeatures == null) {
//			super.getChildrenFeatures(object);
//			childrenFeatures.remove(UsecasePackage.Literals.SCENARIO__SCENARIO_GUARD);
//		}
//		return childrenFeatures;
//	}
//	
//}
