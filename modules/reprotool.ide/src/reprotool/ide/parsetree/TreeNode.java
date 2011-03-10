package reprotool.ide.parsetree;

import java.util.List;

public class TreeNode {
	private String text;
	private List<TreeNode> children;
	
	public TreeNode (String text, List<TreeNode> children) {
		this.text = text;
		this.children = children;
	}
	
	public List<TreeNode> getChildren() {
		return children;
	}
	
	public String getText() {
		return text;
	}
}
