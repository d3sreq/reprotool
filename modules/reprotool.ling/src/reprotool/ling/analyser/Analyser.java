package reprotool.ling.analyser;

import reprotool.ling.ParseTreeNode;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.Word;
import reprotool.ling.WordType;
import reprotool.model.linguistic.action.*;
import reprotool.model.linguistic.actionpart.ActionpartFactory;
import reprotool.model.linguistic.actionpart.TextRange;
import reprotool.model.usecase.UseCaseStep;


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
	public static UseCaseStep analyseTree(UseCaseStep ucs, Sentence sentence) {
		// ParsetreeFactory factory = ParsetreeFactory.eINSTANCE;
		SentenceNode curNode = sentence.getSentenceTree();
		Boolean definedAction = false;
/*
		Sentence sentence = LingFactoryImpl.eINSTANCE.createSentence();
		sentence.parseString(text);
*/		
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

		// detection GOTO action
		int gotoVerbIndex = -1;
		int labelIndex = -1;
		for (int i = 0; i < sentence.getWords().size(); i++) {
			String word = sentence.getWords().get(i).getText();
			for (int g = 0; g < gotoVerbs.length; g++) {
				if (word.equalsIgnoreCase(gotoVerbs[g])) {
					gotoVerbIndex = i;
					break;
				}
			}
			if (Character.isDigit(word.charAt(0))
					&& Character.isDigit(word.charAt(word.length() - 1)))
				labelIndex = i;
		}
		
		// setting of the target	
		if (gotoVerbIndex >= 0 && labelIndex >= 0) {
			// TODO oznaceni cile			
			Action action = afactory.createGoto();
			ucs.setAction(action);
			definedAction = true;
		}

		// ABORT and TERMINATION
		if (!definedAction){
			if (sentence.getWords().size() > 0) {
				for (int i = 0; i < sentence.getWords().size(); i++) {
					for (int t = 0; t < terminateVerbs.length; t++) {
						if (sentence.getWords().get(i).getText().equalsIgnoreCase(terminateVerbs[t])) {
							// ABORT vs TERMINATION
							Action action = afactory.createAbortUseCase();
							ucs.setAction(action);
							definedAction = true;
							break;
						}
					}
					for (int a = 0; a < abortVerbs.length; a++) {
						if (sentence.getWords().get(i).getText().equalsIgnoreCase(abortVerbs[a])) {
							Action action = afactory.createAbortUseCase();
							ucs.setAction(action);
							definedAction = true;
							break;
						}
					}
				}
			}
		}

		
		// THE REST
		if (!definedAction){
			Action action = afactory.createToSystem();
			ucs.setAction(action);
			
			ActionpartFactory apfactory = ActionpartFactory.eINSTANCE;
			TextRange tr = apfactory.createTextRange();
			tr.setStartPosition(0);
			tr.setLength(sentence.getWords().get(0).getText().length());
			ucs.getTextNodes().add(tr);
			
			
		}
		// goto example
/*		Action action = afactory.createGoto();
		ucs.setAction(action);
*/
		// final connection
/*		ucs.setParsedSentence(parsedTree);
*/ 
 
		return ucs;
		
	}

}
