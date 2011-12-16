package reprotool.ling.analyser;

import java.util.ArrayList;

import reprotool.ling.ParseTreeNode;
import reprotool.ling.SentenceNode;
import reprotool.ling.Word;

/**
 * Class for finding selected words in a tree
 * 
 * @author ofiala
 *
 */
public class FindWord {

	/**
	 * Find all nouns in given tree
	 * @param rootNode SentenceNode object to analyze
	 * @return found ArrayList<Word> or null
	 */
	public static ArrayList<Word> getAllNouns(SentenceNode rootNode) {
		// result list
		ArrayList<Word> resultWords = new ArrayList<Word>();
		// go through all children
		for(ParseTreeNode pnode : rootNode.getChildren()) {
			if (pnode instanceof Word) {
				// need noun
				if (((Word) pnode).isNoun())
					resultWords.add((Word)pnode);
			} else { // node - go deeper
				// recursion is there - add all of them
				for (Word word : getAllNouns((SentenceNode)pnode)) {
					resultWords.add(word);
				}
			}
		}
		return resultWords;
	}
	
	/**
	 * Find all nouns (direct children) in given node
	 * @param rootNode SentenceNode object to analyze
	 * @return found ArrayList<Word> or null
	 */
	public static ArrayList<Word> getNouns(SentenceNode rootNode) {
		// result list
		ArrayList<Word> resultWords = new ArrayList<Word>();
		// go through all children
		for(ParseTreeNode pnode : rootNode.getChildren()) {
			if (pnode instanceof Word) {
				// need noun
				if (((Word) pnode).isNoun())
					resultWords.add((Word)pnode);
			}
		}
		return resultWords;
	}
	

	/**
	 * Find all verbs in given tree
	 * @param rootNode SentenceNode object to analyze
	 * @return found ArrayList<Word> or null
	 */
	public static ArrayList<Word> getVerbs(SentenceNode rootNode) {
		// result list
		ArrayList<Word> resultWords = new ArrayList<Word>();
		// go through all children
		for(ParseTreeNode pnode : rootNode.getChildren()) {
			if (pnode instanceof Word) {
				// need noun
				if (((Word) pnode).isVerb())
					resultWords.add((Word)pnode);
			} else { // node - go deeper
				// recursion is there
				for (Word word : getVerbs((SentenceNode)pnode)) {
					resultWords.add(word);
				}
			}
		}
		return resultWords;
	}
	
	/**
	 * Find all words (direct children) in given node
	 * @param rootNode SentenceNode object to analyze
	 * @return found ArrayList<Word> or null
	 */
	public static ArrayList<Word> getWords(SentenceNode rootNode) {
		// result list
		ArrayList<Word> resultWords = new ArrayList<Word>();
		// go through all children
		for(ParseTreeNode pnode : rootNode.getChildren()) {
			if (pnode instanceof Word) {
				resultWords.add((Word)pnode);
			}
		}
		return resultWords;
	}
	
	
	/**
	 * Search direct node children for given lemma
	 * 
	 * @param rootNode SentenceNode object to analyze
	 * @return boolean found
	 */
	public static boolean containsLemma(String lemma, ParseTreeNode rootNode) {
		// invalid input
		if (lemma.isEmpty() || rootNode == null)
			return false;
		
		for(ParseTreeNode node : rootNode.getChildren()) {
			// Word and same strings
			if (node instanceof Word && ((Word) node).getLemma() != null && ((Word) node).getLemma().equals(lemma)) {
				return true;
			}
		}
		return false;
	}
	
}
