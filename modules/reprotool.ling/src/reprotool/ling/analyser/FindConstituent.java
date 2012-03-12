package reprotool.ling.analyser;

import java.util.ArrayList;

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
	public static ArrayList<Word> findIndirectObject(Sentence sentence, ArrayList<Actor> actors) {
		// have we one?
		//boolean indirectobject = false;	
		// count objects
		int count = 0;
		// result
		ArrayList<Word> words = new ArrayList<Word>();	
		// indirect object must be in NP that is in VP
		ArrayList<SentenceNode> nounNodes = FindNode.getAllNounPhrases(FindNode.mainVerbPhrase(sentence.getSentenceTree()));
		
		// count all predicted objects
		for (SentenceNode curNode : nounNodes) {
			// get nouns
			ArrayList<Word> nouns = FindWord.getNouns(curNode);
			if (nouns.size() > 0)
				count++;
		}
		
		if (count > 1) {
			for (SentenceNode curNode : nounNodes) {
				// get nouns
				ArrayList<Word> nouns = FindWord.getNouns(curNode);
				// there must be more than one object to have representative
				for (Word word : nouns) {
					// mark all non possessive nouns as indirect object
					if (word.getPOS() != POSType.POSSESSIVE_ENDING) {
						// must be already actor
						for (Actor ac : actors) {
							if (ac.getName() != null && ac.getName().equalsIgnoreCase(word.getLemma())) {
								// must be a noun
								word.setType(WordType.INDIRECT_OBJECT);
								words.add(word);
							}
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
			// get last noun in one node (rest should be wrong adjectives)
			if (nouns.size() > 0) {
				// try conjunctions (noun just before conjunction)
				for (Word noun : nouns) {
					int index = sentence.getWords().indexOf(noun);
					if ((index >= 0)
							&& (index < sentence.getWords().size() - 1)
							&& (sentence.getWords().get(index + 1).getPOS() == POSType.COORDINATING_CONJUNCTION)) {
						noun.setType(WordType.REPRESENTATIVE_OBJECT);
						objects.add(noun);	
					}
				}
				// try last
				Word word = nouns.get(nouns.size()-1);
				if(!objects.contains(word)) {
					word.setType(WordType.REPRESENTATIVE_OBJECT);
					//System.out.println("Object: " + word.getLemma());
					objects.add(word);	
				}
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
	public static Word findSubject (Sentence sentence, ArrayList<Actor> actors) {
		// result
		Word subject = null;		
		// current node
		SentenceNode curNode = null;
		// must be an actor?
		boolean isActor = LingConfig.isSubjectActor;
		
		// try to switch  object and subject in passive
		if (sentence.isPassive()) {
			ArrayList<Word> objects = findRepresentativeObject(sentence, null);
			if(objects.size() == 1) {
				subject = objects.get(0);				
			}
		}
		
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
						subject = (Word)node;
						break;
					}
				}
			} else {
				// easier way - find main noun
				for(ParseTreeNode node : curNode.getChildren()) {
					// we need noun
					if (node instanceof Word && ((Word)node).getPOS().getLiteral().startsWith("NN")) {
						subject = (Word)node;
						break;
					}
				}
			}
		}
		
		if (subject != null) {
			if(isActor) {
				for (Actor ac : actors) {
					//System.out.println(ac.getName());
					if ((ac.getName() != null) && ac.getName().equalsIgnoreCase((subject).getLemma())) {
						subject.setType(WordType.SUBJECT);
						return subject;
					}
				}
			} else {
//				System.out.println("Subject: " + subject.getLemma());	
				subject.setType(WordType.SUBJECT);
				return subject;
			}
		}
		
		// was already set?
		return null;
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
