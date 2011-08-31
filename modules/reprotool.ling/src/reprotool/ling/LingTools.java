package reprotool.ling;

import reprotool.model.linguistic.parsetree.EWordType;
import reprotool.model.linguistic.parsetree.NounPhraseNode;
import reprotool.model.linguistic.parsetree.ParsetreeFactory;
import reprotool.model.linguistic.parsetree.SentenceNode;
import reprotool.model.linguistic.parsetree.VerbPhraseNode;
import reprotool.model.linguistic.parsetree.Word;

public class LingTools implements ILingTools {

	@Override
	public SentenceNode parseSentence(String sentence) {
		String[] words = sentence.split(" ");
		ParsetreeFactory factory = ParsetreeFactory.eINSTANCE;		
		
		SentenceNode rootNode = factory.createSentenceNode();
		
		NounPhraseNode nounPhrase = factory.createNounPhraseNode();
		rootNode.getChildNodes().add(nounPhrase);

		Word seller = factory.createWord();
		seller.setWordStr(words[0]);
		seller.setWordType(EWordType.SUBJECT);
		
		nounPhrase.getChildNodes().add(seller);

		if (words.length == 1) {
			return rootNode;
		}
		
		
		VerbPhraseNode verbPhrase = factory.createVerbPhraseNode();
		rootNode.getChildNodes().add(verbPhrase);

		Word submits = factory.createWord();
		submits.setWordStr(words[1]);
		submits.setWordType(EWordType.VERB);
	
		verbPhrase.getChildNodes().add(submits);

		if (words.length == 2) {
			return rootNode;
		}
		
		NounPhraseNode nounPhrase2 = factory.createNounPhraseNode();
		verbPhrase.getChildNodes().add(nounPhrase2);

		Word item = factory.createWord();
		item.setWordStr(words[2]);
		item.setWordType(EWordType.REPRESENTATIVE_OBJECT);
		nounPhrase2.getChildNodes().add(item);

		if (words.length == 3) {
			return rootNode;
		}
		
		Word desc = factory.createWord();
		desc.setWordStr(words[3]);
		desc.setWordType(EWordType.REPRESENTATIVE_OBJECT);
		
		nounPhrase2.getChildNodes().add(desc);

		return rootNode;
	}

}
