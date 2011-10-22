package reprotool.model.swproj.provider;

import org.eclipse.emf.common.notify.Adapter;

import reprotool.model.swproj.provider.ActorItemProvider;
import reprotool.model.swproj.provider.SwprojItemProviderAdapterFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author jvinarek
 * 
 */
@Singleton
public class SwprojItemProviderAdapterFactoryExt extends SwprojItemProviderAdapterFactory {

	private FactorySoftwareProject factorySoftwareProject;

	@Override
	public Adapter createSoftwareProjectAdapter() {
		// TODO jvinarek - replace assert (with guava method ?)
		assert(factorySoftwareProject != null);
		return factorySoftwareProject.create(this);
	}
	
	@Inject(optional=true)
	public void setFactorySoftwareProject(FactorySoftwareProject factorySoftwareProject) {
		this.factorySoftwareProject = factorySoftwareProject;
	}
	
	@Inject(optional=true)
	public void setActorItemProvider(ActorItemProvider actorItemProvider) {
		this.actorItemProvider = actorItemProvider;
	}

	public interface FactorySoftwareProject {
		SoftwareProjectItemProvider create(SwprojItemProviderAdapterFactory adapterFactory);
	}
}
