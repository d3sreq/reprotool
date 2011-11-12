package reprotool.ide.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;

/**
 * @author jvinarek
 *
 */
public class Utils {
	
	/**
	 * Retrieves {@link EditingDomain} for given {@link EObject}
	 * 
	 * @param eobject
	 * @return
	 */
	public static EditingDomain getEditingDomain(EObject eobject) {
		ResourceSet resourceSet = eobject.eResource().getResourceSet();
		// TODO - jvinarek - use guava validation ?
		assert(resourceSet instanceof IEditingDomainProvider);
		EditingDomain editingDomain = ((IEditingDomainProvider)resourceSet).getEditingDomain(); 
        return editingDomain; 
	}
	
}
