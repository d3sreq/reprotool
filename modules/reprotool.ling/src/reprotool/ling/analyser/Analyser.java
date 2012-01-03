package reprotool.ling.analyser;

import java.util.ArrayList;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import reprotool.ling.LingConfig;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.Word;
import reprotool.model.linguistic.action.*;
import reprotool.model.linguistic.actionpart.ActionpartFactory;
import reprotool.model.linguistic.actionpart.SentenceActionParam;
import reprotool.model.linguistic.actionpart.SentenceActivity;
import reprotool.model.linguistic.actionpart.SentenceActor;
import reprotool.model.linguistic.actionpart.TextRange;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.ConceptualObject;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;

/**
 * @author ofiala
 * 
 */
public class Analyser {
	// find subject
	static Word subject = null;
	// find verb
	static Word mainverb = null;
	// find objects
	static ArrayList<Word> indirectobjects = null;
	static ArrayList<Word> objects = null;
	
	// actors
	static EList<Actor> actors = null;

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
	 * @param editingDomain 
	 * @param ucs UseCaseStep
	 * @param sentence input sentence
	 * @return CompoundCommand
	 */
	public static CompoundCommand analyseTree(EditingDomain editingDomain,
			UseCaseStep ucs, Sentence sentence) {

		Boolean definedAction = false;
		Analyser.editingDomain = editingDomain;
		
		compoundCommand = new CompoundCommand();

		// check input variables
		if (sentence.getSentenceTree() == null) {
			// wrong input - do nothing
			return compoundCommand;
		}
		
		// clear current use case step TextRanges
		for (TextRange removetr : ucs.getTextNodes()) {
			RemoveCommand removeCommand = new RemoveCommand(editingDomain, ucs,
					UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, removetr);
			compoundCommand.append(removeCommand);
		}
		
		// get all actors
		actors = ucs.getSoftwareProjectShortcut().getActors();
		boolean addActor = true;
		for (Actor act1 : LingConfig.actors) {
			for (Actor act2 : actors) {
				if (act1.getName().equalsIgnoreCase(act2.getName()))
					addActor = false;
			}
			// not duplicated
			if (addActor)
				actors.add(act1);
		}

		// FIND ALL IMPORTANT WORDS
		// find subject
		subject = FindConstituent.findSubject(sentence, actors);
		// find main verb
		mainverb = FindConstituent.findMainVerb(sentence);

		// find objects
		indirectobjects = FindConstituent.findIndirectObject(sentence, actors);
		if (indirectobjects != null && indirectobjects.size() > 0) {
			objects = FindConstituent.findRepresentativeObject(sentence,
					(SentenceNode) indirectobjects.get(0).getParent());
		} else {
			objects = FindConstituent.findRepresentativeObject(sentence, null);
		}

		// FIND ACTION
		if (subject == null) {
			// detection of UseCaseInclude action
			if (!definedAction)
				definedAction = definedAction && detectInclude(ucs, sentence);
			// detection of GOTO action
			if (!definedAction)
				definedAction = definedAction && detectGoto(ucs, sentence);
			// detection of ABORT/TERMINATION action
			if (!definedAction) {
				boolean abort = detectAbort(sentence);
				if (abort) {
					// set abort action
					AbortUseCase action = afactory.createAbortUseCase();
					SetCommand setCommand = new SetCommand(editingDomain, ucs,
							UsecasePackage.Literals.USE_CASE_STEP__ACTION,
							action);
					compoundCommand.append(setCommand);
					definedAction = true;
				}
			}
			
		} else {
			// INTERNAL ACTION - we have subject
			// also TO and FROM
			if (indirectobjects == null || indirectobjects.size() == 0) {
				if ("system".equals(subject.getLemma())) {
					// internal action in system
					compoundCommand.append(setInternalAction(ucs));
					definedAction = true;	
				} else {
					// actor is making something - ToSystem
					compoundCommand.append(setToSystem(ucs));
					definedAction = true;
				}
			} else {
				// we have indirect objects
				// searching system in indirect objects
				boolean toSystem = false;
				for (Word word : indirectobjects) {
					if ("system".equals(word.getLemma())) {
						toSystem = true;
						break;
					}
				}
				if (toSystem) {
					if ("system".equals(subject.getLemma())) {
						// internal action - from system to system
						compoundCommand.append(setInternalAction(ucs));
						definedAction = true;
					} else {
						// from actor to system
						compoundCommand.append(setToSystem(ucs));
						definedAction = true;
					}
				} else {
					// to actor					
					if ("system".equals(subject.getLemma())) {
						// from system to actor
						compoundCommand.append(setFromSystem(ucs));
						definedAction = true;
					} else {
						// from actor to actor -> bad -> unknown
					}
				}

			}
		}
		// internal action

		// THE REST
		if (!definedAction) {
			Unknown action = afactory.createUnknown();
			SetCommand setCommand = new SetCommand(editingDomain, ucs,
					UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
			compoundCommand.append(setCommand);
			definedAction = true;
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
			if (word.getLemma() != null
					&& LingConfig.abortVerbs.contains(word.getLemma())) {
				found = true;
				break;
			}
		}
		// set result
		return found;
	}

	private static boolean detectInclude(UseCaseStep ucs, Sentence sentence) {
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
			}
		}
		
		// setting of the target
		if (gotoVerbIndex >= 0) {
			for(Word word : objects) {
				if("usecase".equals(word.getLemma())){
					labelIndex = sentence.getWords().indexOf(word);
					break;
				}
			}
		}
		
		if(labelIndex > -1 && sentence.getWords().size() > labelIndex && sentence.getWords().get(labelIndex) != null) {
			Word label = sentence.getWords().get(labelIndex);
			int index = Integer.parseInt(label.getLemma());
			if(label.isNumeral() && ucs.getSoftwareProjectShortcut().getUseCases().size() > index) {
				compoundCommand.append(setUseCaseInclude(ucs, ucs.getSoftwareProjectShortcut().getUseCases().get(index)));
			}
		}
		
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
			}
		}

		// setting of the target
		if (gotoVerbIndex >= 0) {
			Goto action = afactory.createGoto();
			String targetLabel = "";

			SetCommand setCommand = new SetCommand(editingDomain, ucs,
					UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
			compoundCommand.append(setCommand);

			// finding target
			for (int i = gotoVerbIndex; i < sentence.getWords().size(); i++) {
				Word word = sentence.getWords().get(i);
				// first number after verb
				if (word.isNumeral()) {
					labelIndex = i;
					targetLabel = word.getText();
					break;
				}
			}

			try {
				EList<UseCaseStep> lucs = ucs.getUseCaseShortcut()
						.getAllUseCaseStepsShortcut();

				if (!targetLabel.isEmpty()) {
					// set target of GOTO action (UseCaseStep) by label
					for (UseCaseStep actucs : lucs) {
						if (targetLabel.equals(actucs.getLabel())) {
							setCommand = new SetCommand(editingDomain, action,
									ActionPackage.Literals.GOTO__GOTO_TARGET,
									actucs);
							compoundCommand.append(setCommand);
						}
					}

					// set and show target to user
					if (labelIndex > 0) {
						TextRange tr = apfactory.createTextRange();
						tr.setStartPosition(sentence.getWords().get(labelIndex)
								.getContentStart());
						tr.setLength(sentence.getWords().get(labelIndex)
								.getContentLength());
						// for labels is lemma form always same as text
						tr.setLemmaForm(sentence.getWords().get(labelIndex)
								.getLemma());

						// removing TextRange at current position
						TextRange blockingtr = ucs.getTextNodeAt(tr
								.getStartPosition());
						if (blockingtr != null) {
							ucs.getTextNodes().remove(blockingtr);
						}

						AddCommand addCommand = new AddCommand(
								editingDomain,
								ucs,
								UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES,
								tr);
						compoundCommand.append(addCommand);
					}

					found = true;
				}

			} catch (NullPointerException e) {
				labelIndex = 0;
			}

			found = true;
		}
		// set result
		return found;
	}
	
	private static Command setInternalAction(UseCaseStep ucs) {
		
		InternalAction action = afactory.createInternalAction();
		
		if (mainverb != null) {
			// text range settings
			TextRange tr = apfactory.createTextRange();
			tr.setStartPosition(mainverb.getContentStart());
			tr.setLength(mainverb.getContentLength());
			tr.setLemmaForm(mainverb.getLemma());
			tr.setPosTag(mainverb.getPOS().getLiteral());

			// action part settings
			SentenceActivity sactivity = apfactory.createSentenceActivity();
			sactivity.setText(tr);
			action.setSentenceActivity(sactivity);
			// adding text range to model
			AddCommand addCommand = new AddCommand(editingDomain, ucs,
					UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, tr);
			compoundCommand.append(addCommand);
		}
		
		setActionParams(ucs, action);
		
		SetCommand setCommand = new SetCommand(editingDomain, ucs,
				UsecasePackage.Literals.USE_CASE_STEP__ACTION,
				action);
		return setCommand;
	}
	
	private static Command setUseCaseInclude(UseCaseStep ucs, UseCase uc) {
		
		UseCaseInclude action = afactory.createUseCaseInclude();
		
		if (mainverb != null) {
			// text range settings
			TextRange tr = apfactory.createTextRange();
			tr.setStartPosition(mainverb.getContentStart());
			tr.setLength(mainverb.getContentLength());
			tr.setLemmaForm(mainverb.getLemma());
			tr.setPosTag(mainverb.getPOS().getLiteral());

			// action part settings
			SentenceActivity sactivity = apfactory.createSentenceActivity();
			sactivity.setText(tr);
			if(uc != null){
				action.setIncludeTarget(uc);
			}
			// adding text range to model
			AddCommand addCommand = new AddCommand(editingDomain, ucs,
					UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, tr);
			compoundCommand.append(addCommand);
		}
		
		setActionParams(ucs, action);
		
		SetCommand setCommand = new SetCommand(editingDomain, ucs,
				UsecasePackage.Literals.USE_CASE_STEP__ACTION,
				action);
		return setCommand;
	}
	
	
	private static Command setToSystem(UseCaseStep ucs) {
		ToSystem action = afactory.createToSystem();

		if (subject != null) {
			// text range settings
			TextRange tr = apfactory.createTextRange();
			tr.setStartPosition(subject.getContentStart());
			tr.setLength(subject.getContentLength());
			tr.setLemmaForm(subject.getLemma());
			tr.setPosTag(subject.getPOS().getLiteral());

			// action part settings
			SentenceActor sactor = apfactory.createSentenceActor();
			for (Actor ac : actors) {
				if (ac.getName().equalsIgnoreCase(subject.getLemma())) {
					sactor.setActor(ac);
				}
			}
			sactor.setText(tr);
			tr.setActionPart(sactor);
			action.setSender(sactor);
			// adding text range to model
			AddCommand addCommand = new AddCommand(editingDomain, ucs,
					UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, tr);
			compoundCommand.append(addCommand);
		}
		
		if (mainverb != null) {
			// text range settings
			TextRange tr = apfactory.createTextRange();
			tr.setStartPosition(mainverb.getContentStart());
			tr.setLength(mainverb.getContentLength());
			tr.setLemmaForm(mainverb.getLemma());
			tr.setPosTag(mainverb.getPOS().getLiteral());

			// action part settings
			SentenceActivity sactivity = apfactory.createSentenceActivity();
			sactivity.setText(tr);
			tr.setActionPart(sactivity);
			action.setSentenceActivity(sactivity);
			// adding text range to model
			AddCommand addCommand = new AddCommand(editingDomain, ucs,
					UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, tr);
			compoundCommand.append(addCommand);
		}
		
		setActionParams(ucs, action);
		
		SetCommand setCommand = new SetCommand(
				editingDomain,
				ucs,
				UsecasePackage.Literals.USE_CASE_STEP__ACTION,
				action);
		
		return setCommand;
	}
	
	private static Command setFromSystem(UseCaseStep ucs) {
		FromSystem action = afactory.createFromSystem();
		
		if (indirectobjects != null && indirectobjects.size() > 0) {
			for (Word iobject : indirectobjects) {
				// text range settings
				TextRange tr = apfactory.createTextRange();
				tr.setStartPosition(iobject.getContentStart());
				tr.setLength(iobject.getContentLength());
				tr.setLemmaForm(iobject.getLemma());
				tr.setPosTag(iobject.getPOS().getLiteral());
		
				// action part settings
				SentenceActor ioactor = apfactory.createSentenceActor();
				for (Actor ac : actors) {
					if (ac.getName().equalsIgnoreCase(subject.getLemma())) {
						ioactor.setActor(ac);
					}
				}
				ioactor.setText(tr);
				tr.setActionPart(ioactor);
				action.setReceiver(ioactor);
				// adding text range to model
				AddCommand addCommand = new AddCommand(editingDomain, ucs,
						UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES,
						tr);
				compoundCommand.append(addCommand);
			}
		}
				
		if (mainverb != null) {
			// text range settings
			TextRange tr = apfactory.createTextRange();
			tr.setStartPosition(mainverb.getContentStart());
			tr.setLength(mainverb.getContentLength());
			tr.setLemmaForm(mainverb.getLemma());
			tr.setPosTag(mainverb.getPOS().getLiteral());

			// action part settings
			SentenceActivity sactivity = apfactory.createSentenceActivity();
			sactivity.setText(tr);
			tr.setActionPart(sactivity);
			action.setSentenceActivity(sactivity);
			// adding text range to model
			AddCommand addCommand = new AddCommand(editingDomain, ucs,
					UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, tr);
			compoundCommand.append(addCommand);
		}	
		
		setActionParams(ucs, action);
		
		SetCommand setCommand = new SetCommand(editingDomain, ucs,
				UsecasePackage.Literals.USE_CASE_STEP__ACTION,
				action);
		compoundCommand.append(setCommand);
		return setCommand;
	}

	private static void setActionParams(UseCaseStep ucs, Action action) {
		// connect objects to textranges
		if (objects != null && objects.size() > 0) {
			for (Word object : objects) {
				// text range settings
				TextRange tr = apfactory.createTextRange();
				tr.setStartPosition(object.getContentStart());
				tr.setLength(object.getContentLength());
				tr.setLemmaForm(object.getLemma());
				tr.setPosTag(object.getPOS().getLiteral());

				// action part settings
				SentenceActionParam aparam = apfactory
						.createSentenceActionParam();
				ConceptualObject cobject = swfactory.createConceptualObject();
				cobject.setName(object.getLemma());
				aparam.setConceptualObject(cobject);
				tr.setActionPart(aparam);
				// adding action param
				AddCommand addCommand = new AddCommand(editingDomain, action,
						ActionPackage.Literals.ACTION__ACTION_PARAM,
						aparam);
				compoundCommand.append(addCommand);
				// adding conceptual object
				ucs.getSoftwareProjectShortcut().getConceptualObjects().add(cobject);
				// todo duplicity
				// adding text range to model
				addCommand = new AddCommand(editingDomain, ucs,
						UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES,
						tr);
				compoundCommand.append(addCommand);
			}
		}
		
	}
}
