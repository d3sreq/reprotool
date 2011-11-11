package reprotool.ling;

import reprotool.ling.tools.Parser;
import reprotool.ling.tools.Tagger;
import reprotool.ling.tools.Tokenizer;

/**
 * @author ofiala
 * 
 */
public class LingTools {

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
	 * Runs all linguistic tools
	 * 
	 * @param originalSentence
	 * @return
	 */
	public static Sentence parseSentence(String originalSentence) {
		
 		String tokenizedSentence = "";
		String taggedSentence = "";
		String parsedSentence = "";
		
		// calling tokenizer 
		tokenizedSentence = Tokenizer.getTokens(originalSentence);
		// calling tagger 
		taggedSentence = Tagger.getMXPOST(tokenizedSentence);
		// calling parser 
		parsedSentence = Parser.getString(taggedSentence);
		
		// parsing into a Sentence object
		Sentence sentence = Parser.parseSentence(parsedSentence);
		
		return sentence;
	}

}
