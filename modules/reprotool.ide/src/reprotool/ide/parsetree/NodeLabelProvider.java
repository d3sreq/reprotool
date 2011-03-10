package reprotool.ide.parsetree;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.zest.core.viewers.EntityConnectionData;

public class NodeLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof TreeNode) {
			TreeNode node = (TreeNode) element;
			return node.getText();
		}
		
		if (element instanceof EntityConnectionData) {
			return "";
		}
		
		throw new RuntimeException("Type not supported");
	}
	
	
}
