package reprotool.ide.parsetree;


import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

public class NodeContentProvider extends ArrayContentProvider implements
		IGraphEntityContentProvider {

	@Override
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof TreeNode) {
			TreeNode node = (TreeNode) entity;
			
			if (node.getChildren() != null) {
				return node.getChildren().toArray();
			}
			
			return null;
		}
		
		throw new RuntimeException("Type not supported");
	}

}
