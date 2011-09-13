package reprotool.ling;



import reprotool.ling.tools.Parser;
import reprotool.ling.tools.Tagger;
import reprotool.ling.tools.Tokenizer;
import reprotool.ling.analyser.*;
import reprotool.model.linguistic.parsetree.EWordType;
import reprotool.model.linguistic.parsetree.NounPhraseNode;
import reprotool.model.linguistic.parsetree.ParsetreeFactory;
import reprotool.model.linguistic.parsetree.SentenceNode;
import reprotool.model.linguistic.parsetree.VerbPhraseNode;
import reprotool.model.linguistic.parsetree.Word;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;

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

	/**
	 * Ling tools pipeline
	 * 
	 * @param originalSentence
	 * @return parserSentence
	 */
	public static String parseLingSentence(String originalSentence) {
		
 		String tokenizedSentence = "";
		String taggedSentence = "";
		String parserSentence = "";
		
		// calling tokenizer 
		tokenizedSentence = Tokenizer.getTokens(originalSentence);
		// calling tagger 
		taggedSentence = Tagger.getMXPOST(tokenizedSentence);
		// calling parser 
		parserSentence = Parser.getString(taggedSentence);
		
		return parserSentence;
	}	
	
	/**
	 * Ling tools pipeline with analyzer
	 * 
	 * @param originalSentence
	 * @return SentenceNode Tree
	 */
	public static SentenceNode parseLingSentenceTree(String originalSentence) {
		
 		String tokenizedSentence = "";
		String taggedSentence = "";
		String parserSentence = "";

		ParsetreeFactory factory = ParsetreeFactory.eINSTANCE;
		SentenceNode rootNode = factory.createSentenceNode();
		UsecaseFactory ucfactory = UsecaseFactory.eINSTANCE;		
		UseCaseStep ucs = ucfactory.createUseCaseStep();
		
		// ling tools
		// calling tokenizer 
		tokenizedSentence = Tokenizer.getTokens(originalSentence);
		// calling tagger 
		taggedSentence = Tagger.getMXPOST(tokenizedSentence);
		// calling parser 
		parserSentence = Parser.getString(taggedSentence);
		// creating tree
		rootNode = Parser.getTree(parserSentence);
		
		// analyser
		ucs = Analyser.analyseTree(ucs, rootNode);
		
		return rootNode;
	}	
}
