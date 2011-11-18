package reprotool.ling.analyser;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
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
		ParseTreeNode node = null;

		// TODO zatim nastrel ohodnoceni vsech NP
		for (ParseTreeNode pnode : curNode.getChildren()) {
			//node = (SentenceNode) pnode;
			node = pnode;
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
		} // end ABORT

		// INTERNAL ACTION
		if (!definedAction){
			/*
			InternalAction action = afactory.createInternalAction();
			SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
			compoundCommand.append(setCommand);	
			*/	
		}	
		
		// THE REST
		if (!definedAction){
			ToSystem action = afactory.createToSystem();
			//ucs.setAction(action);
			SetCommand setCommand = new SetCommand(editingDomain, ucs, UsecasePackage.Literals.USE_CASE_STEP__ACTION, action);
			compoundCommand.append(setCommand);	

			// text range settings
			TextRange tr = apfactory.createTextRange();
			tr.setStartPosition(0);
			tr.setStartPosition(sentence.getWords().get(0).getContentStart());
			tr.setLength(sentence.getWords().get(0).getContentLength());

			
			AddCommand addCommand = new AddCommand(editingDomain, ucs, UsecasePackage.Literals.PARSEABLE_ELEMENT__TEXT_NODES, tr);
			compoundCommand.append(addCommand);
			//ucs.getTextNodes().add(tr);			
			
		}
 
		return compoundCommand;		
	}

}
