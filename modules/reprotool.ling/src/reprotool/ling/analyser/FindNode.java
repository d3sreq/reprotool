package reprotool.ling.analyser;

import java.util.ArrayList;

import reprotool.ling.ParseTreeNode;
import reprotool.ling.SentenceNode;
import reprotool.ling.SentenceType;

/**
 * Class for finding selected nodes in a tree
 * 
 * @author ofiala
 *
 */
public class FindNode {

	/**
	 * Find main NounPhrase in a Sentence
	 * Could be the highest NounPhrase in a tree or its child
	 * @param rootNode SentenceNode object to analyze
	 * @return found SentenceNode or null
	 */
	public static SentenceNode mainNounPhrase(SentenceNode rootNode) {	
		return mainPhrase(rootNode, SentenceType.NOUN_PHRASE , true);
	}
	
	/**
	 * Find main VerbPhrase in a Sentence
	 * Could be the highest VerbPhrase in a tree or its child
	 * @param rootNode SentenceNode object to analyze
	 * @return found SentenceNode or null
	 */
	public static SentenceNode mainVerbPhrase(SentenceNode rootNode) {	
		return mainPhrase(rootNode, SentenceType.VERB_PHRASE, true);
	}
	
	/**
	 * Find main child VerbPhrase in a Sentence (couldn't be rootNode)
	 * Could be the highest VerbPhrase in a tree or its child
	 * @param rootNode SentenceNode object to analyze
	 * @return found SentenceNode or null
	 */
	public static SentenceNode mainChildVerbPhrase(SentenceNode rootNode) {	
		return mainPhrase(rootNode, SentenceType.VERB_PHRASE, false);
	}
	
	/**
	 * Find main Phrase of actual type
	 * @param rootNode SentenceNode object to analyze
	 * @param type SentenceType of wanted node
	 * @return found SentenceNode or null
	 */
	private static SentenceNode mainPhrase(SentenceNode rootNode, SentenceType type, boolean self) {		
		// result
		SentenceNode resultNode = null;
		
		// find first Phrase (highest = biggest)		
		if(self && rootNode.getType() == type) {
			// its the root
			resultNode = rootNode;
		} else {
			// first Phrase of given type 
			for (ParseTreeNode node : rootNode.getChildren()) {
				// always could be Word
				if (node instanceof SentenceNode && ((SentenceNode)node).getType() == type) {
					resultNode = (SentenceNode)node;
					break;
				}
			}
		}
		
		// sometimes can Phrase have only one child - again Phrase of same type
		if(resultNode != null && resultNode.getChildren().size() == 1 && resultNode.getChildren().get(0) != null && resultNode.getChildren().get(0) instanceof SentenceNode &&((SentenceNode) resultNode.getChildren().get(0)).getType() == type) {
			resultNode = (SentenceNode)resultNode.getChildren().get(0);
		} else {
			resultNode = (SentenceNode)resultNode;
		}
		return resultNode;
	}
	
	/**
	 * Find direct child NounPhrases
	 * @param rootNode SentenceNode object to analyze
	 * @return found ArrayList<SentenceNode> or null
	 */
	public static ArrayList<SentenceNode> getNounPhrases(SentenceNode rootNode) {	
		return getPhrases(rootNode, SentenceType.NOUN_PHRASE);
	}

	/**
	 * Find direct child PrepositionPhrases
	 * @param rootNode SentenceNode object to analyze
	 * @return found ArrayList<SentenceNode> or null
	 */
	public static ArrayList<SentenceNode> getPrepositionPhrases(SentenceNode rootNode) {	
		return getPhrases(rootNode, SentenceType.PREPOSITION_PHRASE);
	}
	
	/**
	 * Find direct child VerbPhrases
	 * @param rootNode SentenceNode object to analyze
	 * @return found ArrayList<SentenceNode> or null
	 */
	public static ArrayList<SentenceNode> getVerbPhrases(SentenceNode rootNode) {	
		return getPhrases(rootNode, SentenceType.VERB_PHRASE);
	}
	
	/**
	 * Find direct child Phrases of actual type
	 * @param rootNode SentenceNode object to analyze
	 * @param type SentenceType of wanted node
	 * @return found ArrayList<SentenceNode> or null
	 */
	private static ArrayList<SentenceNode> getPhrases(SentenceNode rootNode, SentenceType type) {	 
		// result list
		ArrayList<SentenceNode> resultNodes = new ArrayList<SentenceNode>();	
		
		if(rootNode != null) {
			// all Phrases of given type (just direct children) 
			for (ParseTreeNode node : rootNode.getChildren()) {
				// always could be Word
				if (node instanceof SentenceNode && ((SentenceNode)node).getType() == type) {
					resultNodes.add((SentenceNode)node);
				}
			}
		}
		return resultNodes;
	}
	
	/**
	 * Find all child NounPhrases
	 * @param rootNode SentenceNode object to analyze
	 * @return found ArrayList<SentenceNode> or null
	 */
	public static ArrayList<SentenceNode> getAllNounPhrases(SentenceNode rootNode) {	 
		// result list
		ArrayList<SentenceNode> resultNodes = new ArrayList<SentenceNode>();	
		
		if(rootNode != null) {
			// all NounPhrases 
			for (ParseTreeNode node : rootNode.getChildren()) {
				// always could be Word
				if (node instanceof SentenceNode) {
					// need NounPhrase
					if (((SentenceNode) node).getType() == SentenceType.NOUN_PHRASE) {
						resultNodes.add((SentenceNode)node);
					} else { // different NodeType - go deeper
						// recursion is there - add all of them
						for (SentenceNode pnode : getAllNounPhrases((SentenceNode)node)) {
							resultNodes.add(pnode);
						}
					}
				}
			}
		}
		return resultNodes;
	}

}
