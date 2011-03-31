package reprotool.ling;

import reprotool.model.linguistic.EWordType;
import reprotool.model.linguistic.LinguisticFactory;
import reprotool.model.linguistic.SentenceNode;
import reprotool.model.linguistic.Word;
import reprotool.model.linguistic.impl.LinguisticFactoryImpl;

public class LingTools implements ILingTools {

	@Override
	public SentenceNode parseSentence(String sentence) {
		String[] words = sentence.split(" ");
		LinguisticFactory factory = LinguisticFactoryImpl.init();
		
		SentenceNode rootNode = factory.createSentenceNode();
		rootNode.setType("sentence");
		
		SentenceNode verbPhrase = factory.createSentenceNode();
		verbPhrase.setType("verb phrase");
		
		SentenceNode nounPhrase = factory.createSentenceNode();
		nounPhrase.setType("noun phrase");
		
		rootNode.getChildFragments().add(nounPhrase);
		rootNode.getChildFragments().add(verbPhrase);
		
		Word seller = factory.createWord();
		seller.setWordStr(words[0]);
		seller.setType("Subject");
		seller.setWordType(EWordType.SUBJECT);
		
		Word submits = factory.createWord();
		submits.setWordStr(words[1]);
		submits.setType("verb");
		submits.setWordType(EWordType.VERB);
		
		nounPhrase.getChildFragments().add(seller);
		verbPhrase.getChildFragments().add(submits);
		
		SentenceNode nounPhrase2 = factory.createSentenceNode();
		nounPhrase2.setType("noun phrase");
		
		verbPhrase.getChildFragments().add(nounPhrase2);

		Word item = factory.createWord();
		item.setWordStr(words[2]);
		item.setType("Representative o.");
		item.setWordType(EWordType.REPRESENTATIVE_OBJECT);
		
		Word desc = factory.createWord();
		desc.setWordStr(words[3]);
		desc.setType("Representative o.");
		desc.setWordType(EWordType.REPRESENTATIVE_OBJECT);
		
		nounPhrase2.getChildFragments().add(item);
		nounPhrase2.getChildFragments().add(desc);

		return rootNode;
	}

}
