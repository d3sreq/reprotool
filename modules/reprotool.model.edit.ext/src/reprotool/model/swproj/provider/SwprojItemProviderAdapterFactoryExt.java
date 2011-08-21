package reprotool.model.swproj.provider;

import org.eclipse.emf.common.notify.Adapter;

public class SwprojItemProviderAdapterFactoryExt extends
		SwprojItemProviderAdapterFactory {

	public SwprojItemProviderAdapterFactoryExt() {
		super();
	}
	
	@Override
	public Adapter createSoftwareProjectAdapter() {
		return new SoftwareProjectItemProviderExt(this);
	}

}
