package reprotool.ling.analyser;

import java.util.ArrayList;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import reprotool.ling.LingConfig;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.Word;
import reprotool.model.linguistic.action.*;
import reprotool.model.linguistic.actionpart.ActionpartFactory;
import reprotool.model.linguistic.actionpart.TextRange;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.swproj.SwprojPackage;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;


/**
 * @author ofiala
 * 
 */
public class Analyser {
	// find subject
	static Word subject = null;
	// find objects
	static ArrayList<Word> indirectobjects = null;
	static ArrayList<Word> objects = null;
	
	// factories
	// action type
	static ActionFactory afactory = ActionFactory.eINSTANCE;
	static ActionpartFactory apfactory = ActionpartFactory.eINSTANCE;
	// factory for creating
	static SwprojFactory swfactory = SwprojFactory.eINSTANCE;
	
	// result
	static EditingDomain editingDomain = null;
	static CompoundCommand compoundCommand = new CompoundCommand();
	
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

		Boolean definedAction = false;
		Analyser.editingDomain = editingDomain;
		
		// check input variables
		if (sentence.getSentenceTree() == null) {
			// wrong input - do nothing
			return compoundCommand;
		}

		// get all actors
		EList<Actor> actors = ucs.getSoftwareProjectShortcut().getActors();
		actors.addAll(LingConfig.actors);
		
		// FIND ALL IMPORTANT WORDS
		// find subject
		subject = FindConstituent.findSubject(sentence, actors);
		// find objects
		indirectobjects = FindConstituent.findIndirectObject(sentence, actors);	
		if (indirectobjects != null && indirectobjects.size() > 1) {
			objects = FindConstituent.findRepresentativeObject(sentence, (SentenceNode)indirectobjects.get(0).getParent());			
		} else {
			objects = FindConstituent.findRepresentativeObject(sentence, null);				
		}
			
		// FIND ACTION
		// detection of GOTO action
		if (!definedAction) definedAction = definedAction && detectGoto(ucs, sentence);
		// detection of ABORT/TERMINATION action
		if (!definedAction) {
			boolean abort = detectAbort(sentence);
			if(abort) {
				// set abort action
				AbortUseCase action = afactory.createAbortUseCase();
				SetCommand setCommand = new SetCommand(editingDomain, ucs,
						UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
				compoundCommand.append(setCommand);
				definedAction = true;
			}
		}

		// INTERNAL ACTION
		// also TO and FROM
		if (!definedAction){
			if (indirectobjects == null || indirectobjects.size() == 0) {				
				InternalAction action = afactory.createInternalAction();
				SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
				compoundCommand.append(setCommand);										
			} else {
				// system actions
				if(subject != null && "system".equals(subject.getLemma())) {
					if ("system".equals(((Word)indirectobjects.get(0)).getLemma())) {
						InternalAction action = afactory.createInternalAction();
						SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
						compoundCommand.append(setCommand);	
					} else {						
						FromSystem action = afactory.createFromSystem();
						SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
						compoundCommand.append(setCommand);	
					}
				} 
				
				if (!definedAction && objects.size() > 0) {
					// now we have both objects
					if ("system".equals(((Word)indirectobjects.get(0)).getLemma())) {
						ToSystem action = afactory.createToSystem();
						SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
						compoundCommand.append(setCommand);	
					}
				}
				
			}

		}	
		
		// THE REST
		if (!definedAction){
			// default set to InternalAction
			InternalAction action = afactory.createInternalAction();
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
	
	public static boolean detectAbort(Sentence sentence) {
		// result
		boolean found = false;
		
		// empty sentence
		if (sentence.getWords().size() <= 0) {
			return found;
		}
		for (Word word : sentence.getWords()) {
			// abort verbs
			if (word.getLemma() != null	&& LingConfig.abortVerbs.contains(word.getLemma())) {
				found = true;
				break;
			}
		}
		// set result
		return found;
	}



	private static boolean detectGoto(UseCaseStep ucs, Sentence sentence) {
		// result
		boolean found = false;
		
		// detection GOTO action
		int gotoVerbIndex = -1;
		int labelIndex = -1;
		// check all goto verbs
		for (int i = 0; i < sentence.getWords().size(); i++) {
			Word word = sentence.getWords().get(i);
			if (LingConfig.gotoVerbs.contains(word.getLemma())) {
				gotoVerbIndex = i;
				break;
			}// TODO test jeslti to prochazi stejne
			/*for (String verb : LingConfig.gotoVerbs) {
				if (word.getText() != null && word.getText().equalsIgnoreCase(verb) {
					gotoVerbIndex = i;
					break;
				}
			}*/
		}

		// setting of the target
		if (gotoVerbIndex >= 0) {			
			Goto action = afactory.createGoto();
			String targetLabel = "";

			SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
			compoundCommand.append(setCommand);	
			
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
						// for labels is lemma form always same as text
						tr.setLemmaForm(sentence.getWords().get(labelIndex).getLemma());
						
						// removing TextRange at current position
						TextRange blockingtr = ucs.getTextNodeAt(tr.getStartPosition());
						if (blockingtr != null) {
							ucs.getTextNodes().remove(blockingtr);
						}
						
						AddCommand addCommand = new AddCommand(editingDomain, ucs, UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, tr);
						compoundCommand.append(addCommand);
					}
					
					found = true;					
				}
				
			} catch (NullPointerException e){
				labelIndex = 0;
			}
			
			found = true;
		} 
		// set result
		return found;
	}
}
