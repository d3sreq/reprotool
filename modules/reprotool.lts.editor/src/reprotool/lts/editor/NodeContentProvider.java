package reprotool.lts.editor;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphContentProvider;

import reprotool.model.lts.StateMachine;
import reprotool.model.lts.Transition;

public class NodeContentProvider implements IGraphContentProvider {
	
	private static final String TYPE_NOT_SUPPORTED = "Type not supported";

	@Override
	public Object[] getElements(Object input) {
		if (input instanceof StateMachine) {
			StateMachine machine = (StateMachine) input;
			return machine.getAllTransitions().toArray();
		}
		
		throw new RuntimeException(TYPE_NOT_SUPPORTED);
	}

	@Override
	public Object getSource(Object edge) {
		if (edge instanceof Transition) {
			return ((Transition) edge).getSource();
		}
		
		throw new RuntimeException(TYPE_NOT_SUPPORTED);
	}
	
	@Override
	public Object getDestination(Object edge) {
		if (edge instanceof Transition) {
			return ((Transition) edge).getTarget();
		}
		
		throw new RuntimeException(TYPE_NOT_SUPPORTED);
	}

	
	@Override
	public void dispose() {
	}
	
	
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}
}
