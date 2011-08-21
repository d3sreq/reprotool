package reprotool.model.swproj.provider;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import reprotool.model.swproj.SoftwareProject;

public class TransientSoftwareProjectItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, 
		IItemLabelProvider, IItemPropertySource {

	public TransientSoftwareProjectItemProvider(AdapterFactory adapterFactory, SoftwareProject softwareProject) {
		super(adapterFactory);
		softwareProject.eAdapters().add(this);
	}
	
	@Override
	public Collection getChildren(Object object) {
		return super.getChildren(target);
	}
	
	@Override
	public Object getParent(Object object) {
		return target;
	}

}
