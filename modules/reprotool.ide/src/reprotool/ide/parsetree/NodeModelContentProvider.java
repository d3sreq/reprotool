package reprotool.ide.parsetree;

import java.util.ArrayList;
import java.util.List;

public class NodeModelContentProvider {
	private List<TreeNode> nodes;
	
	public NodeModelContentProvider() {
		nodes = new ArrayList<TreeNode>();
		
		TreeNode child1 = new TreeNode("Seller", null);
		nodes.add(child1);
		TreeNode child2 = new TreeNode("submits", null);
		nodes.add(child2);
		TreeNode child3 = new TreeNode("item", null);
		nodes.add(child3);
		TreeNode child4 = new TreeNode("description", null);
		nodes.add(child4);
		
		List<TreeNode> children1 = new ArrayList<TreeNode>();
		children1.add(child1);
		TreeNode phrase1 = new TreeNode("Noun phrase", children1);
		nodes.add(phrase1);
		
		List<TreeNode> children2 = new ArrayList<TreeNode>();
		children2.add(child3);
		children2.add(child4);
		TreeNode phrase2 = new TreeNode("Noun phrase", children2);
		nodes.add(phrase2);
		
		List<TreeNode> children3 = new ArrayList<TreeNode>();
		children3.add(child2);
		children3.add(phrase2);
		TreeNode phrase3 = new TreeNode("Verb phrase", children3);
		nodes.add(phrase3);
		
		List<TreeNode> children4 = new ArrayList<TreeNode>();
		children4.add(phrase1);
		children4.add(phrase3);
		TreeNode sentence = new TreeNode("Sentence", children4);
		nodes.add(sentence);
	}
	
	public List<TreeNode> getNodes(){
		return nodes;
	}

}
