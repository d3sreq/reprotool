package reprotool.ide.parsetree;

import java.util.ArrayList;
import java.util.List;
import reprotool.model.linguistic.SentenceNode;

public class NodeModelContentProvider {
	private SentenceNode sentence;
	
	public List<SentenceNode> getNodes() {
		List<SentenceNode> list = new ArrayList<SentenceNode>();
		return buildNodesList(sentence, list);
	}
	
	public void setRootNode(SentenceNode rootNode) {
		sentence = rootNode;
	}
	
	public SentenceNode getRootNode() {
		return sentence;
	}
	
	private List<SentenceNode> buildNodesList(SentenceNode node, List<SentenceNode> list) {
		list.add(node);
		
		for (SentenceNode i: node.getChildFragments()) {
			buildNodesList(i, list);
		}
		
		return list;
	}

}
