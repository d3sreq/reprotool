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

	private final FactorySoftwareProject factorySoftwareProject;

	@Inject
	SwprojItemProviderAdapterFactoryExt(FactorySoftwareProject factorySoftwareProject, ActorItemProvider actorItemProvider) {
		this.factorySoftwareProject = factorySoftwareProject;
		this.actorItemProvider = actorItemProvider;
	}

	@Override
	public Adapter createSoftwareProjectAdapter() {
		return factorySoftwareProject.create(this);
	}
	
	public interface FactorySoftwareProject {
		SoftwareProjectItemProvider create(SwprojItemProviderAdapterFactory adapterFactory);
	}
}
