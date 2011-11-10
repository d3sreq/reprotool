package reprotool.ling.test;

import static org.junit.Assert.*;

import org.junit.Test;

import reprotool.ling.LingFactory;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.analyser.Analyser;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;

/**
 * @author ofiala
 * 
 */

public class AnalyseTest {

	// first sentence
	@Test
	public final void testAnalyseTree() {
		
		UsecaseFactory ucfactory = UsecaseFactory.eINSTANCE;		
		UseCaseStep ucs1 = ucfactory.createUseCaseStep();
		UseCaseStep ucs2 = ucfactory.createUseCaseStep();
		
		Sentence sentence = LingFactory.eINSTANCE.createSentence();
		
		LingFactory factory = LingFactory.eINSTANCE;
		SentenceNode rootNode = factory.createSentenceNode();
		
		SentenceNode nounPhrase = factory.createSentenceNode();
		rootNode.getChildren().add(nounPhrase);
		nounPhrase.setParent(rootNode);

		nounPhrase = factory.createSentenceNode();
		rootNode.getChildren().add(nounPhrase);
		nounPhrase.setParent(rootNode);
		
		//ucs1.setParsedSentence(rootNode);
		
		sentence.setSentenceTree(rootNode);
		ucs2 = Analyser.analyseTree(ucs1, sentence);
		
		assertEquals(ucs1, ucs2);
	}

	
}
