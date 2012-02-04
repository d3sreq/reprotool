package reprotool.ide.editors.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.ui.IEditorPart;

/**
 * @author jvinarek
 *
 */
public class UnmarkDirtyService {

	public static final UnmarkDirtyService INSTANCE = new UnmarkDirtyService();
	private Map<CommandStack, List<IFirePropertyChange>> map = new WeakHashMap<CommandStack, List<IFirePropertyChange>>();

	private UnmarkDirtyService() {
	}

	public void add(CommandStack commandStack, IFirePropertyChange editorPart) {
		if (!map.containsKey(commandStack)) {
			map.put(commandStack, new ArrayList<IFirePropertyChange>());
		}
		
		map.get(commandStack).add(editorPart);
	}
	
	public void remove(CommandStack commandStack, IFirePropertyChange editorPart) {
		map.get(commandStack).remove(editorPart);
	}
	
	public void unmarkDirty(CommandStack commandStack) {
		for (IFirePropertyChange editorPart : map.get(commandStack)) {
			editorPart.firePropertyChange(IEditorPart.PROP_DIRTY);
		}
	}
}
