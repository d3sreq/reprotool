package utils;

import java.util.Collection;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CommandParameter;

/**
 * @author jvinarek
 *
 */
public class Utils {
	
	public static void removeCommandParameter(Collection<Object> newChildDescriptors, EReference removedReference) {
		CommandParameter toRemove = null;

		for (Object descriptor : newChildDescriptors) {
			CommandParameter param = (CommandParameter) descriptor;
			if (param.getFeature() == removedReference) {
				toRemove = param;
			}
		}

		newChildDescriptors.remove(toRemove);
	}
}
