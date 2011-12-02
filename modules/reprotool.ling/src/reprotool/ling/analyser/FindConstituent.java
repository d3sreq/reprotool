package reprotool.ling.analyser;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;

import reprotool.ling.LingConfig;
import reprotool.ling.POSType;
import reprotool.ling.ParseTreeNode;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.Word;
import reprotool.ling.WordType;
import reprotool.model.swproj.Actor;

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
	public static ArrayList<Word> findIndirectObject(Sentence sentence, EList<Actor> actors) {
		// have we one?
		//boolean indirectobject = false;		
		// result
		ArrayList<Word> words = new ArrayList<Word>();	
		// indirect object must be in NP that is in VP
		ArrayList<SentenceNode> nounNodes = FindNode.getNounPhrases(FindNode.mainVerbPhrase(sentence.getSentenceTree()));
		
		for (SentenceNode curNode : nounNodes) {
			// get nouns
			ArrayList<Word> nouns = FindWord.getNouns(curNode);
			// mark all non possessive nouns as indirect object
			for (Word word : nouns) {
				if (word.getPOS() != POSType.POSSESSIVE_ENDING) {
					// must be already actor
					for (Actor ac : actors) {
						// TODO objects have same parent ?
						if (ac.getName().equalsIgnoreCase(word.getLemma())) {
							// must be a noun
							word.setType(WordType.INDIRECT_OBJECT);
							words.add(word);
							/*if (!indirectobject) {
								// return node where is first indirect object
								ionode = curNode;
							}*/
							//indirectobject = true;
						}
					}
				}
			}
		}

		return words;
	}

	/**
	 * Method finds an representative object in sentence
	 * 
	 * @param sentence sentence object to analyse
	 * @return boolean - found
	 */
	public static ArrayList<Word> findRepresentativeObject(Sentence sentence, SentenceNode indirectobject) {
		// result
		ArrayList<Word> objects = new ArrayList<Word>();		
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
				System.out.println("Object: " + word.getLemma());
				objects.add(word);
			}
		}

		return objects;
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
		
		if (sentence.isPassive()) {
			System.out.println("passive");
			//findRepresentativeObject(sentence, curNode);
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

	
	/**
	 * Method finds main verb in sentence
	 * 
	 * @param sentence sentence object to analyse
	 * @return SentenceNode / null if not found
	 */
	public static Word findMainVerb (Sentence sentence) {
		// result
		Word verb = null;		
		// current node
		SentenceNode curNode = null;
		curNode = (SentenceNode)FindNode.mainVerbPhrase(sentence.getSentenceTree());
		if (curNode != null) {
			if(!sentence.isPassive()) {
				for (Word word : FindWord.getVerbs(curNode)) {
					// get first not modal verb
					if (word.isVerb() && word.getPOS() != POSType.MODAL) {
						verb = word;
						break;
					}
				}
			} else { // passive
				boolean foundBe = false;
				for (Word word : FindWord.getVerbs(curNode)) {
					// get first not modal verb and not BE and must be in past participle
					if (word.isVerb() && word.getPOS() != POSType.MODAL) {
						if (word.getLemma().equals("be")) {
							foundBe = true;
						} else {
							if (foundBe && word.getPOS() == POSType.VERB_PAST_PARTICIPLE) {
								verb = word;
								break;
							}
						}		
						
					}
				}
			}
		}
		// try special action verbs
		if(verb == null) {
			for (Word word : sentence.getWords()) {
				if (LingConfig.gotoVerbs.contains(word.getLemma()) || LingConfig.abortVerbs.contains(word.getLemma())) {
					verb = word;
					break;
				}
			}
		}
		return verb;
	}
	
	public static boolean getPassive(Sentence sentence) {
		// current node
		SentenceNode curNode = null;
		// NP in PP (with (IN by)) whole in VP
		curNode = FindNode.mainVerbPhrase(sentence.getSentenceTree());
		if (curNode != null) {
			// second VP
			curNode = FindNode.mainChildVerbPhrase(curNode);
			// children must be PP
			if (curNode != null) {
				ArrayList<SentenceNode> nodes = FindNode.getPrepositionPhrases(curNode);
				
				// lemma "by" 
				if (nodes.size() > 0) {
					if (FindWord.containsLemma("by", nodes.get(0)))
						return true;	
				}
			}
		}

		return false;
	}
}
