package reprotool.model.swproj.provider;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import reprotool.model.edit.ext.common.TransientSoftwareProjectItemProvider;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.swproj.SwprojPackage;

/**
 * @author jvinarek
 * 
 */
public class ActorsItemProvider extends TransientSoftwareProjectItemProvider {
	public ActorsItemProvider(AdapterFactory adapterFactory, SoftwareProject softwareProject) {
		super(adapterFactory, softwareProject);
	}

	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS);
		}
		return childrenFeatures;
	}

	@Override
	public String getText(Object object) {
		// TODO
		return "Actors";
	}

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		newChildDescriptors.add(createChildParameter(SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS,
				SwprojFactory.eINSTANCE.createActor()));
	}

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {
		if (new AddCommand(domain, (EObject) owner, SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS, collection).canExecute()) {
			return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
		}
		return UnexecutableCommand.INSTANCE;
	}
}
