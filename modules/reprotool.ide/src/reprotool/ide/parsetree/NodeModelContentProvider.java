package reprotool.ide.parsetree;

import java.util.ArrayList;
import java.util.List;

import reprotool.ling.ILingTools;
import reprotool.ling.LingTools;
import reprotool.model.linguistic.SentenceNode;

public class NodeModelContentProvider {
	private SentenceNode sentence;
	private ILingTools lingTools;
	
	public NodeModelContentProvider() {
		lingTools = new LingTools();
	}
	
	public void loadSentence(String s) {
		sentence = lingTools.parseSentence(s);
	}
	
	public List<SentenceNode> getNodes() {
		List<SentenceNode> list = new ArrayList<SentenceNode>();
		return buildNodesList(sentence, list);
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
