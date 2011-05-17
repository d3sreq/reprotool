package reprotool.ling;

import reprotool.model.linguistic.EWordType;
import reprotool.model.linguistic.LinguisticFactory;
import reprotool.model.linguistic.NounPhraseNode;
import reprotool.model.linguistic.SentenceNode;
import reprotool.model.linguistic.VerbPhraseNode;
import reprotool.model.linguistic.Word;
import reprotool.model.linguistic.impl.LinguisticFactoryImpl;

public class LingTools implements ILingTools {

	@Override
	public SentenceNode parseSentence(String sentence) {
		String[] words = sentence.split(" ");
		LinguisticFactory factory = LinguisticFactoryImpl.init();
		
		SentenceNode rootNode = factory.createSentenceNode();
	
		VerbPhraseNode verbPhrase = factory.createVerbPhraseNode();
		
		NounPhraseNode nounPhrase = factory.createNounPhraseNode();
		
		rootNode.getChildNodes().add(nounPhrase);
		rootNode.getChildNodes().add(verbPhrase);
		
		Word seller = factory.createWord();
		seller.setWordStr(words[0]);
		seller.setWordType(EWordType.SUBJECT);
		
		Word submits = factory.createWord();
		submits.setWordStr(words[1]);
		submits.setWordType(EWordType.VERB);
		
		nounPhrase.getChildNodes().add(seller);
		verbPhrase.getChildNodes().add(submits);
		
		NounPhraseNode nounPhrase2 = factory.createNounPhraseNode();
		
		verbPhrase.getChildNodes().add(nounPhrase2);

		Word item = factory.createWord();
		item.setWordStr(words[2]);
		item.setWordType(EWordType.REPRESENTATIVE_OBJECT);
		
		Word desc = factory.createWord();
		
		if (words.length >= 4) {
			desc.setWordStr(words[3]);
		} else {
			desc.setWordStr("dummy");
		}
		
		desc.setWordType(EWordType.REPRESENTATIVE_OBJECT);
		
		nounPhrase2.getChildNodes().add(item);
		nounPhrase2.getChildNodes().add(desc);

		return rootNode;
	}

}
