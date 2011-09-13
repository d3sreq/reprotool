package reprotool.ling.analyser;

import reprotool.model.linguistic.action.Action;
import reprotool.model.linguistic.action.ActionFactory;
import reprotool.model.linguistic.parsetree.EWordType;
import reprotool.model.linguistic.parsetree.InnerParseNode;
import reprotool.model.linguistic.parsetree.ParseNode;
import reprotool.model.linguistic.parsetree.SentenceNode;
import reprotool.model.linguistic.parsetree.Word;
import reprotool.model.usecase.UseCaseStep;

public class Analyser {


    /**
	 * Analyse tree nodes - relationships
	 * connect tree to ucs
     * 
     * @param ucs UseCaseStep
     * @param parsedTree Tree
     * @return UseCaseStep analysed_tree
     */
    public static UseCaseStep analyseTree(UseCaseStep ucs,SentenceNode parsedTree) {
    	
		//ParsetreeFactory factory = ParsetreeFactory.eINSTANCE;
		SentenceNode curNode = parsedTree;
    	
    	// tree analyse
		boolean subject = true;
		InnerParseNode node = null;
		
		// TODO zatim nastrel ohodnoceni vsech NP
		for (ParseNode pnode : curNode.getChildNodes()) {
			node = (InnerParseNode) pnode;
			if(node.eClass().getName().equals("NounPhrase")){
				if(subject) {
					if(node.getChildNodes().get(0).getClass().getName() == "Word"){
						((Word)node.getChildNodes().get(0)).setWordType(EWordType.SUBJECT);
						subject = false;
					}
				} else {
					if(node.getChildNodes().get(0).getClass().getName() == "Word"){
						((Word)node.getChildNodes().get(0)).setWordType(EWordType.REPRESENTATIVE_OBJECT);
					}
				}
			}
			//System.out.print(node.eClass().eClass().getName());
			//if(node.toString());
		}
    	
    	// action type
    	ActionFactory afactory = ActionFactory.eINSTANCE;
    	Action action = afactory.createGoto();
    	ucs.setAction(action);
    	
    	// final connection
    	ucs.setParsedSentence(parsedTree);
    	return ucs;
    }
	
}
