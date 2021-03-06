package reprotool.model.swproj.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import reprotool.model.edit.ext.common.ReprotoolEditExtPlugin;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.provider.ReprotoolEditPlugin;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Extension of generated {@link SoftwareProjectItemProvider} class.
 * 
 * @author jvinarek
 * 
 */
public class SoftwareProjectItemProviderExt extends SoftwareProjectItemProvider {

	public static final String SOFTWARE_PROJECT_ITEM_PROVIDER_ANNOTATION = "SOFTWARE_PROJECT_ITEM_PROVIDER_ANNOTATION";
	
	private static final int ACTORS_INDEX = 0;
	private static final int USE_CASES_INDEX = 1;
	private static final int CONCEPTUAL_OBJECTS_INDEX = 2;

	protected List<ItemProviderAdapter> children = null;

	@Inject
	public SoftwareProjectItemProviderExt(@Named(SOFTWARE_PROJECT_ITEM_PROVIDER_ANNOTATION) AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Collection<?> getChildren(Object object) {
		// TODO jvinarek - replace with DI
		if (children == null) {
			SoftwareProject softwareProject = (SoftwareProject) object;
			children = new ArrayList<ItemProviderAdapter>();
			children.add(new ActorsItemProvider(adapterFactory, softwareProject));
			children.add(new UseCasesItemProvider(adapterFactory, softwareProject));			
			children.add(new ConceptualObjectsItemProvider(adapterFactory, softwareProject));
		}
		return children;
	}

	public Object getActors() {
		return children.get(ACTORS_INDEX);
	}

	public Object getUseCases() {
		return children.get(USE_CASES_INDEX);
	}
	
	public Object getConceptualObjects() {
		return children.get(CONCEPTUAL_OBJECTS_INDEX);
	}

	@Override
	public Object getImage(Object object) {
		return ReprotoolEditExtPlugin.INSTANCE.getImage("full/obj16/book.png");
	}
	
	@Override
	public String getText(Object object) {
		String label = ((SoftwareProject) object).getName();
		return label == null || label.length() == 0 ? "<unnamed project>" : label;
	}
	
	/**
	 * Disposes the non-modeled children.
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (children != null) {
			((IDisposable) children.get(ACTORS_INDEX)).dispose();
			((IDisposable) children.get(USE_CASES_INDEX)).dispose();
			((IDisposable) children.get(CONCEPTUAL_OBJECTS_INDEX)).dispose();
		}
	}

	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection) {
		return createWrappedCommand(super.createRemoveCommand(domain, owner, feature, collection), owner, feature);
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection, int index) {
		return createWrappedCommand(super.createAddCommand(domain, owner, feature, collection, index), owner, feature);
	}

	protected Command createWrappedCommand(Command command, final EObject owner, final EStructuralFeature feature) {
		if (feature == SwprojPackage.eINSTANCE.getSoftwareProject_Actors()
				|| feature == SwprojPackage.eINSTANCE.getSoftwareProject_UseCases()
				|| feature == SwprojPackage.eINSTANCE.getSoftwareProject_ConceptualObjects()) {
			
			Command wrapper = new CommandWrapper(command) {
				
				@Override
				public Collection<?> getAffectedObjects() {
					Collection<?> affected = super.getAffectedObjects();
					if (affected.contains(owner)) {
						if (feature == SwprojPackage.eINSTANCE.getSoftwareProject_Actors()) {
							affected = Collections.singleton(getActors());
						} else if (feature == SwprojPackage.eINSTANCE.getSoftwareProject_UseCases()) {
							affected = Collections.singleton(getUseCases());
						} else {
							affected = Collections.singleton(getConceptualObjects());
						}
					}
					return affected;
				}
				
			};
			
			return wrapper;
		}
		return command;
	}
	
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}
	
	/**
	 * Common base class for non-model nodes.
	 * 
	 * @author jvinarek
	 *
	 */
	public static class TransientSoftwareProjectItemProvider extends ItemProviderAdapter implements
			IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
			IItemPropertySource {

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
		protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
				Collection<?> collection) {
			return createWrappedCommand(super.createRemoveCommand(domain, owner, feature, collection), owner);
		}

		@Override
		protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
				Collection<?> collection, int index) {
			return createWrappedCommand(super.createAddCommand(domain, owner, feature, collection, index), owner);
		}

		protected Command createWrappedCommand(Command command, final EObject owner) {
			return new CommandWrapper(command) {
				@Override
				public Collection<?> getAffectedObjects() {
					Collection<?> affected = super.getAffectedObjects();
					if (affected.contains(owner)) {
						affected = Collections.singleton(TransientSoftwareProjectItemProvider.this);
					}
					return affected;
				}
			};
		}

	}

	/**
	 * Non-model "Actors" node.
	 * 
	 * @author jvinarek
	 *
	 */
	public static class ActorsItemProvider extends TransientSoftwareProjectItemProvider {
		public ActorsItemProvider(AdapterFactory adapterFactory, SoftwareProject softwareProject) {
			super(adapterFactory, softwareProject);
		}

		@Override
		public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
			if (childrenFeatures == null) {
				super.getChildrenFeatures(object);
				childrenFeatures.add(SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS);
			}
			return childrenFeatures;
		}

		@Override
		public String getText(Object object) {
			return ReprotoolEditExtPlugin.INSTANCE.getString("SoftwareProjectItemProviderExt_Actors"); //$NON-NLS-1$
		}
		
		@Override
		public Object getImage(Object object) {
			return ReprotoolEditExtPlugin.INSTANCE.getImage("full/obj16/folder_user.png");
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
			if (new AddCommand(domain, (EObject) owner, SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS, collection)
					.canExecute()) {
				return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
			}
			return UnexecutableCommand.INSTANCE;
		}
	}
	
	/**
	 * Non-model "Conceptual objects" node.
	 * 
	 * @author jvinarek
	 *
	 */
	public static class ConceptualObjectsItemProvider extends TransientSoftwareProjectItemProvider {
		public ConceptualObjectsItemProvider(AdapterFactory adapterFactory, SoftwareProject softwareProject) {
			super(adapterFactory, softwareProject);
		}

		@Override
		public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
			if (childrenFeatures == null) {
				super.getChildrenFeatures(object);
				childrenFeatures.add(SwprojPackage.Literals.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS);
			}
			return childrenFeatures;
		}

		@Override
		public String getText(Object object) {
			return ReprotoolEditExtPlugin.INSTANCE.getString("SoftwareProjectItemProviderExt_ConceptualObjects"); //$NON-NLS-1$
		}
		
		@Override
		public Object getImage(Object object) {
			return ReprotoolEditExtPlugin.INSTANCE.getImage("full/obj16/folder_brick.png");
		}

		@Override
		protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
			super.collectNewChildDescriptors(newChildDescriptors, object);
			newChildDescriptors.add(createChildParameter(SwprojPackage.Literals.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS,
					SwprojFactory.eINSTANCE.createConceptualObject()));
		}

		@Override
		protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
				int operation, Collection<?> collection) {
			if (new AddCommand(domain, (EObject) owner, SwprojPackage.Literals.SOFTWARE_PROJECT__CONCEPTUAL_OBJECTS, collection)
					.canExecute()) {
				return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
			}
			return UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * Non-model "Use cases" node.
	 * 
	 * @author jvinarek
	 *
	 */
	public static class UseCasesItemProvider extends TransientSoftwareProjectItemProvider {
		public UseCasesItemProvider(AdapterFactory adapterFactory, SoftwareProject softwareProject) {
			super(adapterFactory, softwareProject);
		}

		@Override
		public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
			if (childrenFeatures == null) {
				super.getChildrenFeatures(object);
				childrenFeatures.add(SwprojPackage.Literals.SOFTWARE_PROJECT__USE_CASES);
			}
			return childrenFeatures;
		}

		@Override
		public String getText(Object object) {
			return ReprotoolEditExtPlugin.INSTANCE.getString("SoftwareProjectItemProviderExt_UseCases"); //$NON-NLS-1$
		}
		
		@Override
		public Object getImage(Object object) {
			return ReprotoolEditExtPlugin.INSTANCE.getImage("full/obj16/folder_page.png");
		}

		@Override
		protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
				int operation, Collection<?> collection) {
			if (new AddCommand(domain, (EObject) owner, SwprojPackage.Literals.SOFTWARE_PROJECT__USE_CASES, collection)
					.canExecute()) {
				return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
			}
			return UnexecutableCommand.INSTANCE;
		}
	}

}
