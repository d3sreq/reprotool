package reprotool.ling.analyser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import reprotool.ling.ParseTreeNode;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.Word;
import reprotool.ling.WordType;
import reprotool.model.linguistic.action.*;
import reprotool.model.linguistic.actionpart.ActionpartFactory;
import reprotool.model.linguistic.actionpart.TextRange;
import reprotool.model.usecase.UseCaseStep;
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
		// ParsetreeFactory factory = ParsetreeFactory.eINSTANCE;
		SentenceNode curNode = sentence.getSentenceTree();
		Boolean definedAction = false;
/*
		Sentence sentence = LingFactoryImpl.eINSTANCE.createSentence();
		sentence.parseString(text);
*/		
	
		CompoundCommand compoundCommand = new CompoundCommand();

		
		// tree analyse
		boolean subject = true;
		SentenceNode node = null;

		// TODO zatim nastrel ohodnoceni vsech NP
		for (ParseTreeNode pnode : curNode.getChildren()) {
			node = (SentenceNode) pnode;
			if (node.eClass().getName().equals("NounPhrase")) {
				if (subject) {
					if (node.getChildren().get(0).getClass().getName() == "Word") {
						((Word) node.getChildren().get(0))
								.setType(WordType.SUBJECT);
						subject = false;
					}
				} else {
					if (node.getChildren().get(0).getClass().getName() == "Word") {
						((Word) node.getChildren().get(0))
								.setType(WordType.REPRESENTATIVE_OBJECT);
					}
				}
			}
			// System.out.print(node.eClass().eClass().getName());
			// if(node.toString());
		}

		// action type
		ActionFactory afactory = ActionFactory.eINSTANCE;
		ActionpartFactory apfactory = ActionpartFactory.eINSTANCE;
		
		// detection GOTO action
		int gotoVerbIndex = -1;
		int labelIndex = -1;
		for (int i = 0; i < sentence.getWords().size(); i++) {
			Word word = sentence.getWords().get(i);
			for (int g = 0; g < gotoVerbs.length; g++) {
				if (word.getText().equalsIgnoreCase(gotoVerbs[g])) {
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
			
			//ucs.setAction(action);
			SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
			compoundCommand.append(setCommand);			
			
			// finding target
			for (int i = gotoVerbIndex; i < sentence.getWords().size(); i++){
				Word word = sentence.getWords().get(i);
				if(word.isNumeral() && word.getPOS().toString().substring(0,2).equals("NN")){
					System.out.println("Goto target");
					Matcher match = Pattern.compile("\\d").matcher(word.getText());
					if (match.find()) {
						labelIndex = i;
						//String partNumber = match.group(1);
						System.out.println(match.group(0));
						System.out.println(match.group(1));
					}					

					//Pattern.compile("Won \' t").matcher(text).replaceAll("Won* n\'t");
				}
			}
			//TextRange tr = apfactory.createTextRange();			
			//action.setGotoTarget(value);
			//EList<UseCaseStep> lucs = ucs.getUseCaseShortcut().getAllUseCaseStepsShortcut();
			
			// TODO
			//setCommand = new SetCommand(editingDomain, action, ActionPackage.Literals.GOTO__GOTO_TARGET, lucs.get(0));
			//compoundCommand.append(setCommand);
			
			definedAction = true;
		}

		// ABORT and TERMINATION
		if (!definedAction){
			if (sentence.getWords().size() > 0) {
				for (int i = 0; i < sentence.getWords().size(); i++) {
					for (int t = 0; t < terminateVerbs.length; t++) {
						if (sentence.getWords().get(i).getText().equalsIgnoreCase(terminateVerbs[t])) {
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
						if (sentence.getWords().get(i).getText().equalsIgnoreCase(abortVerbs[a])) {
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
		}

		
		// THE REST
		if (!definedAction){
			ToSystem action = afactory.createToSystem();
			//ucs.setAction(action);
			SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
			compoundCommand.append(setCommand);	

			TextRange tr = apfactory.createTextRange();
			tr.setStartPosition(0);
//			System.out.print(sentence.getWords().get(0).getText().length());
//			tr.setLength(sentence.getWords().get(0).getText().length());
			tr.setLength(2);
			ucs.getTextNodes().add(tr);
			
			
		}
		// goto example
/*		Action action = afactory.createGoto();
		ucs.setAction(action);
*/
		// final connection
/*		ucs.setParsedSentence(parsedTree);
*/ 
 
		return compoundCommand;
		
	}

}
