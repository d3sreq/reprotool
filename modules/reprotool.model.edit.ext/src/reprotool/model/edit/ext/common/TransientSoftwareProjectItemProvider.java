package reprotool.model.edit.ext.common;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import reprotool.model.lts.provider.ReprotoolEditPlugin;
import reprotool.model.swproj.SoftwareProject;

/**
 * @author jvinarek
 * 
 */
public class TransientSoftwareProjectItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	public TransientSoftwareProjectItemProvider(AdapterFactory adapterFactory, SoftwareProject softwareProject) {
		super(adapterFactory);
		softwareProject.eAdapters().add(this);
	}

	@Override
	public Collection<?> getChildren(Object object) {
		return super.getChildren(target);
	}

	@Override
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain, Object sibling) {
		return super.getNewChildDescriptors(target, editingDomain, sibling);
	}

	@Override
	public Object getParent(Object object) {
		return target;
	}

	@Override
	public ResourceLocator getResourceLocator() {
		// take resources from "edit" plugin
		return ReprotoolEditPlugin.INSTANCE;
	}

	@Override
	public Command createCommand(final Object object, final EditingDomain domain,
			Class<? extends Command> commandClass, CommandParameter commandParameter) {
		commandParameter.setOwner(target);
		return super.createCommand(target, domain, commandClass, commandParameter);
	}

	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EReference feature,
			Collection<?> collection) {
		return createWrappedCommand(super.createRemoveCommand(domain, owner, feature, collection), owner);
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EReference feature, Collection collection,
			int index) {
		return createWrappedCommand(super.createAddCommand(domain, owner, feature, collection, index), owner);
	}

	protected Command createWrappedCommand(Command command, final EObject owner) {
		return new CommandWrapper(command) {
			public Collection getAffectedObjects() {
				Collection affected = super.getAffectedObjects();
				if (affected.contains(owner)) {
					affected = Collections.singleton(TransientSoftwareProjectItemProvider.this);
				}
				return affected;
			}
		};
	}

}
