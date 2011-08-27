package reprotool.model.usecase.provider;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

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
	
	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {
		if (new AddCommand(domain, (EObject) owner, SwprojPackage.Literals.SOFTWARE_PROJECT__USE_CASES, collection).canExecute()) {
			return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
		}
		return UnexecutableCommand.INSTANCE;
	}
}
