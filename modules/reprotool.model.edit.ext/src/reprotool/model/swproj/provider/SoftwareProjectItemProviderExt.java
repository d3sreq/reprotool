package reprotool.model.swproj.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IDisposable;

import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.provider.UseCasesItemProvider;

/**
 * @author jvinarek
 * 
 */
public class SoftwareProjectItemProviderExt extends SoftwareProjectItemProvider {

	private static final int ACTORS_INDEX = 0;
	private static final int USE_CASES_INDEX = 1;
	
	protected List children = null;

	public SoftwareProjectItemProviderExt(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public Collection<?> getChildren(Object object) {
		if (children == null) {
			SoftwareProject softwareProject = (SoftwareProject) object;
			children = new ArrayList();
			children.add(new UseCasesItemProvider(adapterFactory, softwareProject));
			children.add(new ActorsItemProvider(adapterFactory, softwareProject));
		}
		return children;
	}

	public Object getActors() {
		return children.get(ACTORS_INDEX);
	}

	public Object getUseCases() {
		return children.get(USE_CASES_INDEX);
	}

	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection) {
		return createWrappedCommand(super.createRemoveCommand(domain, owner, feature, collection), owner, feature);
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature, Collection<?> collection,
			int index) {
		return createWrappedCommand(super.createAddCommand(domain, owner, feature, collection, index), owner, feature);
	}

	protected Command createWrappedCommand(Command command, final EObject owner, final EStructuralFeature feature) {
		if (feature == SwprojPackage.eINSTANCE.getSoftwareProject_Actors()
				|| feature == SwprojPackage.eINSTANCE.getSoftwareProject_UseCases()) {
			return new CommandWrapper(command) {
				@Override
				public Collection<?> getAffectedObjects() {
					Collection<?> affected = super.getAffectedObjects();
					if (affected.contains(owner)) {
						affected = Collections
								.singleton(feature == SwprojPackage.eINSTANCE.getSoftwareProject_Actors() ? getActors()
										: getUseCases());
					}
					return affected;
				}
			};
		}
		return command;
	}
	
	/**
     * Disposes the non-modeled children.
     */
	@Override
	public void dispose() {
		super.dispose();
	    if (children != null) {
	      ((IDisposable)children.get(ACTORS_INDEX)).dispose();
	      ((IDisposable)children.get(USE_CASES_INDEX)).dispose();      
	    }
	}

}
