package reprotool.model.usecase.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;

import reprotool.model.edit.ext.common.TransientSoftwareProjectItemProvider;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.UsecaseFactory;

/**
 * @author jvinarek
 *
 */
public class UseCasesItemProvider extends TransientSoftwareProjectItemProvider {
	public UseCasesItemProvider(AdapterFactory adapterFactory, SoftwareProject softwareProject) {
		super(adapterFactory, softwareProject);
	}
	
	@Override
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SwprojPackage.Literals.SOFTWARE_PROJECT__USE_CASES);
		}
		return childrenFeatures;
	}
	
	@Override
	public String getText(Object object) {
		// TODO
		return "Use cases";
	}
	
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		newChildDescriptors.add(createChildParameter(SwprojPackage.Literals.SOFTWARE_PROJECT__USE_CASES, UsecaseFactory.eINSTANCE.createUseCase()));
	}
}
