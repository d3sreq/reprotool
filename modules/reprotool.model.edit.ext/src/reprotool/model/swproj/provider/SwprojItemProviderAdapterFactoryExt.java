package reprotool.model.swproj.provider;

import org.eclipse.emf.common.notify.Adapter;

/**
 * @author jvinarek
 * 
 */
public class SwprojItemProviderAdapterFactoryExt extends
		SwprojItemProviderAdapterFactory {

	public SwprojItemProviderAdapterFactoryExt() {
		super();
	}

	@Override
	public Adapter createSoftwareProjectAdapter() {
		return new SoftwareProjectItemProviderExt(this);
	}

	@Override
	public Adapter createActorAdapter() {
		return new ActorItemProviderExt(this);
	}

}
