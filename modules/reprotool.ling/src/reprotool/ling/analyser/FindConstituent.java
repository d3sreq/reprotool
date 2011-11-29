package reprotool.ling.analyser;

import java.util.ArrayList;

import reprotool.ling.NodeType;
import reprotool.ling.POSType;
import reprotool.ling.ParseTreeNode;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.SentenceType;
import reprotool.ling.Word;
import reprotool.ling.WordType;

/**
 * @author ofiala
 * 
 */
public class FindConstituent {

	/**
	 * Method finds an indirect object i sentence
	 * 
	 * @param sentence sentence object to analyse
	 * @return SentenceNode / null if not found
	 */
	public static SentenceNode findIndirectObject(Sentence sentence) {
		// have we one?
		boolean indirectobject = false;		
		// result
		SentenceNode ionode = null;	
		// indirect object must be in NP that is in VP
		ArrayList<SentenceNode> nounNodes = FindNode.getNounPhrases(FindNode.mainVerbPhrase(sentence.getSentenceTree()));
		
		for (SentenceNode curNode : nounNodes) {
			// get nouns
			ArrayList<Word> nouns = FindWord.getNouns(curNode);
			// mark all non possessive nouns as indirect object
			for (Word word : nouns) {
				if (word.getPOS() != POSType.POSSESSIVE_ENDING) {
					// must be a noun
					word.setType(WordType.INDIRECT_OBJECT);
					if (!indirectobject) {
						// return node where is first indirect object
						ionode = curNode;
					}
					indirectobject = true;
				}
			}
		}

		return ionode;
	}

	/**
	 * Method finds an representative object in sentence
	 * 
	 * @param sentence sentence object to analyse
	 * @return boolean - found
	 */
	public static boolean findRepresentativeObject(Sentence sentence, SentenceNode indirectobject) {
		// result
		boolean object = false;		
		// representative object must be in NP that is not indirect object NP
		ArrayList<SentenceNode> nounNodes = FindNode.getAllNounPhrases(FindNode.mainVerbPhrase(sentence.getSentenceTree()));
		// remove indirect object node
		boolean removed = nounNodes.remove(indirectobject);
		if (!removed) {
			// sentence was changed during process
		}
		// do the work
		for(SentenceNode node : nounNodes) {
			// find all noun phrases
			ArrayList<Word> nouns = FindWord.getNouns(node);
			for (Word word : nouns) {
				// mark node
				word.setType(WordType.REPRESENTATIVE_OBJECT);
				object = true;
			}
		}

		return object;
	}

	/**
	 * Method finds subject in sentence
	 * 
	 * @param sentence sentence object to analyse
	 * @return SentenceNode / null if not found
	 */
	public static Word findSubject (Sentence sentence) {
		// result
		Word subject = null;		
		// current node
		SentenceNode curNode = null;
		
		boolean passive = isPassive(sentence);
		if (passive) {

			
		}
		
		// is there any determiner?
		/*
		for (Word word : sentence.getWords()) {	
			if (word.getPOS() == POSType.DETERMINER) {
				word.setType(WordType.SUBJECT);
				System.out.println("Subject: " + word.getLemma());
				subject = word;
			}
		}	*/
		
		// find determiner in head NP
		if (subject == null) {
			curNode = (SentenceNode)FindNode.mainNounPhrase(sentence.getSentenceTree());
			// NounPhrase not found - try harder to find
			if(curNode == null) {
				curNode = sentence.getSentenceTree();
				// get higher noun in a tree
				// better - get all noun and their high
				for (ParseTreeNode node : curNode.getChildren()) {
					if(node instanceof Word && ((Word)node).isNoun()) {
						((Word)node).setType(WordType.SUBJECT);
						System.out.println("Subject: " + ((Word)node).getLemma());
						subject = (Word)node;
						break;
					}
				}
			} else {
				// easier way - find main noun
				for(ParseTreeNode node : curNode.getChildren()) {
					// we need noun
					if (node instanceof Word && ((Word)node).getPOS().getLiteral().startsWith("NN")) {
						((Word)node).setType(WordType.SUBJECT);
						System.out.println("Subject: " + ((Word)node).getLemma());
						subject = (Word)node;
						break;
					}
				}
			}
		}
		return subject;
	}

	private static boolean isPassive(Sentence sentence) {
		// current node
		SentenceNode curNode = null;
		// NP in PP (with (IN by)) whole in VP
		curNode = FindNode.mainVerbPhrase(sentence.getSentenceTree());
		if (curNode != null) {
			curNode = FindNode.mainVerbPhrase(curNode);
			// children - PP
			if (curNode != null && curNode instanceof SentenceNode) {
				for(ParseTreeNode node : ((SentenceNode)curNode).getChildren()) {
					if (node instanceof SentenceNode && ((SentenceNode)curNode).getType() == SentenceType.PREPOSITION_PHRASE) {
						if (FindWord.contains("by", node))
							return true;
					}
				}
			}
		}

		return false;
	}
}
