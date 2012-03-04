package reprotool.ide.utils;

import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Control;

/**
 * @author jvinarek
 *
 */
public class Utils {
	
	/**
	 * Adds focus listener to control changing selection provider to the given
	 * selection provider on {@link FocusAdapter#focusGained(FocusEvent)}.
	 * 
	 * @param selectionProviderIntermediate "wrapper" to set selection provider into  
	 * @param control control gaining focus
	 * @param provider provider to be set into {@code selectionProviderIntermediate} 
	 */
	public static void addSelectionFocusListener(final SelectionProviderIntermediate selectionProviderIntermediate, Control control, final ISelectionProvider provider) {
		control.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				selectionProviderIntermediate.setSelectionProviderDelegate(provider);
			}
		});
	}
	
}
