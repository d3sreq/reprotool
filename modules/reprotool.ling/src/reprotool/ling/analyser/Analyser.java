package reprotool.ling.analyser;

import java.util.ArrayList;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import reprotool.ling.POSType;
import reprotool.ling.ParseTreeNode;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.Word;
import reprotool.ling.WordType;
import reprotool.model.linguistic.action.*;
import reprotool.model.linguistic.actionpart.ActionpartFactory;
import reprotool.model.linguistic.actionpart.TextRange;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;
import reprotool.model.usecase.UsecasePackage;


/**
 * @author ofiala
 * 
 */
public class Analyser {

	private static String[] gotoVerbs = { "continue", "repeat", "resume", "retry" };
	private static String[] terminateVerbs = {"terminate", "end"};
	private static String[] abortVerbs = {"abort"};
	
	/**
	 * Analyse tree nodes - relationships connect tree to ucs
	 * 
	 * @param ucs
	 *            UseCaseStep
	 * @param parsedTree
	 *            Tree
	 * @return UseCaseStep analysed_tree
	 */
	public static CompoundCommand analyseTree(EditingDomain editingDomain, UseCaseStep ucs, Sentence sentence) {
		// current node
		SentenceNode curNode = null;
		Boolean definedAction = false;
	
		CompoundCommand compoundCommand = new CompoundCommand();

		// find subject
		Word subject = null;
		// find objects
		SentenceNode indirectobject = null;
		boolean object = false;
		
		// check input variables
		if (sentence.getSentenceTree() == null) {
			// wrong input - do nothing
			return compoundCommand;
		}

		// FIND ALL IMPORTANT WORDS
		// find subject
		subject = Analyser.findSubject(sentence);
		// find objects
		indirectobject = Analyser.findIndirectObject(sentence);		
		object = Analyser.findRepresentativeObject(sentence, indirectobject);		
		
		// ACTORS
		// factory for creating
		SwprojFactory swfactory = SwprojFactory.eINSTANCE;
		// add subject as a new actor
		if(subject != null){
			EList<Actor> actors = ucs.getSoftwareProjectShortcut().getActors();
			Actor actor = swfactory.createActor();
			actor.setName(subject.getLemma());
			actor.setDescription(subject.getText());
			// add
			//actors.add(actor);
			// add command
			AddCommand addCommand = new AddCommand(editingDomain, ucs.getSoftwareProjectShortcut(), SwprojPackage.Literals.SOFTWARE_PROJECT__ACTORS, actor);
			compoundCommand.append(addCommand);	
		}
		
		// FIND ACTION
		// action type
		ActionFactory afactory = ActionFactory.eINSTANCE;
		ActionpartFactory apfactory = ActionpartFactory.eINSTANCE;

		// detection GOTO action
		int gotoVerbIndex = -1;
		int labelIndex = -1;
		// check all goto verbs
		for (int i = 0; i < sentence.getWords().size(); i++) {
			Word word = sentence.getWords().get(i);
			for (int g = 0; g < gotoVerbs.length; g++) {
				if (word.getText() != null && word.getText().equalsIgnoreCase(gotoVerbs[g])) {
					gotoVerbIndex = i;
					break;
				}
			}
			//if (Character.isDigit(word.charAt(0)) && Character.isDigit(word.charAt(word.length() - 1)))
			//	labelIndex = i;
		}

		// setting of the target
		if (gotoVerbIndex >= 0) {			
			
			//System.out.println("Goto");
			Goto action = afactory.createGoto();
			String targetLabel = "";
			
			//ucs.setAction(action);
			SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
			compoundCommand.append(setCommand);	
			
			//System.out.print("Goto target ");
			
			// finding target
			for (int i = gotoVerbIndex; i < sentence.getWords().size(); i++){
				Word word = sentence.getWords().get(i);
				//Word nextword = sentence.getWords().get(i + 1);
				// first number after verb
				if(word.isNumeral()){
				//if(nextword.isNumeral() && word.getPOS().toString().substring(0,2).equals("NN")){
					labelIndex = i;
					targetLabel = word.getText();
					
					System.out.print("Goto target :" + targetLabel + " labelIndex :" + labelIndex);
					break;
					/* TODO remove
					Matcher match = Pattern.compile("\\d").matcher(word.getText());
					if (match.find()) {
						labelIndex = i;
						partNumber = Integer.parseInt(match.group(0));
						System.out.println(match.group(0));

					}	*/				
				}
			}
			
			try{
				EList<UseCaseStep> lucs = ucs.getUseCaseShortcut().getAllUseCaseStepsShortcut();
				
				if(!targetLabel.isEmpty()){
					// set target of GOTO action (UseCaseStep) by label
					for(UseCaseStep actucs : lucs) {
						if(targetLabel.equals(actucs.getLabel())) {
							setCommand = new SetCommand(editingDomain, action, ActionPackage.Literals.GOTO__GOTO_TARGET, actucs);
							compoundCommand.append(setCommand);
						}
					}				
					
					// set and show target to user
					if(labelIndex > 0){
						TextRange tr = apfactory.createTextRange();
						tr.setStartPosition(sentence.getWords().get(labelIndex).getContentStart());
						tr.setLength(sentence.getWords().get(labelIndex).getContentLength());
						// for labels is lemma form allways same as text
						tr.setLemmaForm(sentence.getWords().get(labelIndex).getLemma());
						
						// removing TextRange at current position
						TextRange blockingtr = ucs.getTextNodeAt(tr.getStartPosition());
						if (blockingtr != null) {
							ucs.getTextNodes().remove(blockingtr);
						}
						
						AddCommand addCommand = new AddCommand(editingDomain, ucs, UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, tr);
						compoundCommand.append(addCommand);
					}
					
					definedAction = true;					
				}
				
			} catch (NullPointerException e){
				labelIndex = 0;
			}
			
			definedAction = true;
		} // end GOTO

		// ABORT and TERMINATION
		if (!definedAction){
			if (sentence.getWords().size() > 0) {
				for (int i = 0; i < sentence.getWords().size(); i++) {
					for (int t = 0; t < terminateVerbs.length; t++) {
						if (sentence.getWords().get(i).getText() != null && sentence.getWords().get(i).getText().equalsIgnoreCase(terminateVerbs[t])) {
							// ABORT vs TERMINATION
							AbortUseCase action = afactory.createAbortUseCase();
							//ucs.setAction(action);
							SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
							compoundCommand.append(setCommand);
							
							definedAction = true;
							break;
						}
					}
					for (int a = 0; a < abortVerbs.length; a++) {
						if (sentence.getWords().get(i).getText() != null && sentence.getWords().get(i).getText().equalsIgnoreCase(abortVerbs[a])) {
							AbortUseCase action = afactory.createAbortUseCase();
							//ucs.setAction(action);
							SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
							compoundCommand.append(setCommand);
							definedAction = true;
							break;
						}
					}
				}
			}
		} // end ABORT

		// INTERNAL ACTION
		// also TO and FROM
		if (!definedAction){
			if (indirectobject == null) {				
				InternalAction action = afactory.createInternalAction();
				SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
				compoundCommand.append(setCommand);										
			} else {
				// system actions?
				if (object) {
					// now we have both objects
					if (indirectobject.getWord().getLemma() == "system") {
						ToSystem action = afactory.createToSystem();
						SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
						compoundCommand.append(setCommand);	
					} else {
						FromSystem action = afactory.createFromSystem();
						SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
						compoundCommand.append(setCommand);	
					}
				}
				
			}

		}	
		
		// THE REST
		if (!definedAction){
			ToSystem action = afactory.createToSystem();
			//ucs.setAction(action);
			SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
			compoundCommand.append(setCommand);	

			// text range settings
			TextRange tr = apfactory.createTextRange();
			tr.setStartPosition(sentence.getWords().get(0).getContentStart());
			tr.setLength(sentence.getWords().get(0).getContentLength());
			tr.setLemmaForm(sentence.getWords().get(0).getLemma());

			// removing TextRange at current position
			TextRange blockingtr = ucs.getTextNodeAt(tr.getStartPosition());
			if (blockingtr != null) {
				ucs.getTextNodes().remove(blockingtr);
			}
			
			AddCommand addCommand = new AddCommand(editingDomain, ucs, UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, tr);
			compoundCommand.append(addCommand);
			//ucs.getTextNodes().add(tr);			
			
		}
 
		return compoundCommand;		
	}
	
	private static SentenceNode findIndirectObject(Sentence sentence) {
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

	private static boolean findRepresentativeObject(Sentence sentence, SentenceNode indirectobject) {
		// result
		boolean object = false;		
		// representative object must be in NP that is not indirect object NP
		ArrayList<SentenceNode> nounNodes = FindNode.getAllNounPhrases(FindNode.mainVerbPhrase(sentence.getSentenceTree()));
		// remove indirect object node
		// TODO warning if its not there
		boolean removed = nounNodes.remove(indirectobject);
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

	private static Word findSubject (Sentence sentence) {
		// result
		Word subject = null;		
		// current node
		SentenceNode curNode = null;
		
		// is there any determiner?
		for (Word word : sentence.getWords()) {	
			if (word.getPOS() == POSType.DETERMINER) {
				word.setType(WordType.SUBJECT);
				System.out.println("Subject: " + word.getLemma());
				subject = word;
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

}
