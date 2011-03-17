package reprotool.ide.parsetree;

import java.util.ArrayList;
import java.util.List;

import reprotool.model.linguistic.EWordType;
import reprotool.model.linguistic.LinguisticFactory;
import reprotool.model.linguistic.SentenceNode;
import reprotool.model.linguistic.Word;
import reprotool.model.linguistic.impl.LinguisticFactoryImpl;

public class NodeModelContentProvider {
	private SentenceNode sentence;
	
	public NodeModelContentProvider() {
		LinguisticFactory factory = LinguisticFactoryImpl.init();
		
		sentence = factory.createSentenceNode();
		sentence.setType("sentence");
		
		SentenceNode verbPhrase = factory.createSentenceNode();
		verbPhrase.setType("verb phrase");
		
		SentenceNode nounPhrase = factory.createSentenceNode();
		nounPhrase.setType("noun phrase");
		
		sentence.getChildFragments().add(nounPhrase);
		sentence.getChildFragments().add(verbPhrase);
		
		Word seller = factory.createWord();
		seller.setWordStr("Seller");
		seller.setType("Subject");
		seller.setWordType(EWordType.SUBJECT);
		
		Word submits = factory.createWord();
		submits.setWordStr("submits");
		submits.setType("verb");
		submits.setWordType(EWordType.VERB);
		
		nounPhrase.getChildFragments().add(seller);
		verbPhrase.getChildFragments().add(submits);
		
		SentenceNode nounPhrase2 = factory.createSentenceNode();
		nounPhrase2.setType("noun phrase");
		
		verbPhrase.getChildFragments().add(nounPhrase2);

		Word item = factory.createWord();
		item.setWordStr("item");
		item.setType("Representative o.");
		item.setWordType(EWordType.REPRESENTATIVE_OBJECT);
		
		Word desc = factory.createWord();
		desc.setWordStr("description");
		desc.setType("Representative o.");
		desc.setWordType(EWordType.REPRESENTATIVE_OBJECT);
		
		nounPhrase2.getChildFragments().add(item);
		nounPhrase2.getChildFragments().add(desc);
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
