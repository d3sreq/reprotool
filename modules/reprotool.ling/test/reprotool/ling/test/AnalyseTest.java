package reprotool.ling.test;

import static org.junit.Assert.*;

import org.junit.Test;

import reprotool.ling.analyser.Analyser;
import reprotool.model.linguistic.parsetree.NounPhraseNode;
import reprotool.model.linguistic.parsetree.ParsetreeFactory;
import reprotool.model.linguistic.parsetree.SentenceNode;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;

public class AnalyseTest {

	// first sentence
	@Test
	public final void testAnalyseTree() {
		
		UsecaseFactory ucfactory = UsecaseFactory.eINSTANCE;		
		UseCaseStep ucs1 = ucfactory.createUseCaseStep();
		UseCaseStep ucs2 = ucfactory.createUseCaseStep();
		
		ParsetreeFactory factory = ParsetreeFactory.eINSTANCE;
		SentenceNode rootNode = factory.createSentenceNode();
		
		NounPhraseNode nounPhrase = factory.createNounPhraseNode();
		rootNode.getChildNodes().add(nounPhrase);
		nounPhrase.setParentNode(rootNode);

		nounPhrase = factory.createNounPhraseNode();
		rootNode.getChildNodes().add(nounPhrase);
		nounPhrase.setParentNode(rootNode);
		
		ucs1.setParsedSentence(rootNode);
		
		ucs2 = Analyser.analyseTree(ucs1, rootNode);
		
		assertEquals(ucs1, ucs2);
	}

	
}
