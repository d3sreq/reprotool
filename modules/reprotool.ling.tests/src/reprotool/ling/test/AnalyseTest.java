package reprotool.ling.test;

import org.junit.Test;

public class AnalyseTest {

	// first sentence
	@Test
	public final void testAnalyseTree() {
		
		String sentence = "Administrator send message.";
		
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
		
		ucs2 = Analyser.analyseTree(ucs1, rootNode, sentence);
		
		assertEquals(ucs1, ucs2);
	}

	
}
