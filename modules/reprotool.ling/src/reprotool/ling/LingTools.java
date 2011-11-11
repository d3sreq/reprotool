package reprotool.ling;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import reprotool.ling.analyser.Analyser;
import reprotool.ling.tools.Parser;
import reprotool.ling.tools.Tagger;
import reprotool.ling.tools.Tokenizer;
import reprotool.model.usecase.UseCaseStep;

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

	/**
	 * Runs all linguistic tools
	 * 
	 * @param editingDomain
	 * @param ucs
	 * @return CompoundCommand all commands at model objects
	 */
	public static CompoundCommand analyseUseCaseStep(EditingDomain editingDomain, UseCaseStep ucs) {
		
		String sentenceString = ucs.getContent();
		
		Sentence sentence = parseSentence(sentenceString);
		
		CompoundCommand command = Analyser.analyseTree(editingDomain, ucs, sentence);

		return command;
	}	
	
}
