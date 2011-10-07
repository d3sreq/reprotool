package reprotool.ling;

import reprotool.ling.tools.Parser;
import reprotool.ling.tools.Tagger;
import reprotool.ling.tools.Tokenizer;

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
}
