package reprotool.ide.parsetree;

import java.util.ArrayList;
import java.util.List;

import reprotool.model.linguistic.InnerParseNode;
import reprotool.model.linguistic.ParseNode;
import reprotool.model.linguistic.SentenceNode;

public class NodeModelContentProvider {
	private SentenceNode sentence;
	
	public List<ParseNode> getNodes() {
		List<ParseNode> list = new ArrayList<ParseNode>();
		return buildNodesList(sentence, list);
	}
	
	public void setRootNode(SentenceNode rootNode) {
		sentence = rootNode;
	}
	
	public SentenceNode getRootNode() {
		return sentence;
	}
	
	private List<ParseNode> buildNodesList(ParseNode node, List<ParseNode> list) {
		list.add(node);
		
		if(node instanceof InnerParseNode) {
			for (ParseNode i: ((InnerParseNode)node).getChildNodes()) {
				buildNodesList(i, list);
			}
		}
		
		return list;
	}

}
