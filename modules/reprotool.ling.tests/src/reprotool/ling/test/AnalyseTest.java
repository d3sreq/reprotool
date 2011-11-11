package reprotool.ling.test;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import reprotool.ling.LingFactory;
import reprotool.ling.LingTools;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.analyser.Analyser;
import reprotool.ling.tools.Parser;
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
		
		String sentenceString = "(S (NP (NNP Administrator)) (VP (VBZ continue ) (NP (NNS label1))))";
		//String sentenceString = "(S (NP (NNP Administrator)) (VP (VBZ sends ) (NP (NNS messages))))";
		
		UsecaseFactory ucfactory = UsecaseFactory.eINSTANCE;		
		UseCaseStep ucs1 = ucfactory.createUseCaseStep();
		UseCaseStep ucs2 = ucfactory.createUseCaseStep();
		
		//Sentence sentence = LingFactory.eINSTANCE.createSentence();
		
		LingFactory factory = LingFactory.eINSTANCE;
		SentenceNode rootNode = factory.createSentenceNode();
		
		SentenceNode nounPhrase = factory.createSentenceNode();
		rootNode.getChildren().add(nounPhrase);
		nounPhrase.setParent(rootNode);

		nounPhrase = factory.createSentenceNode();
		rootNode.getChildren().add(nounPhrase);
		nounPhrase.setParent(rootNode);
		
		//ucs1.setParsedSentence(rootNode);
		
		Sentence sentence = Parser.parseSentence(sentenceString);
		

		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createURI("test");
		rs.createResource(uri);
				
		//EditingDomain editingDomain = ((IEditingDomainProvider)rs).getEditingDomain(); 
		CompoundCommand command = Analyser.analyseTree(null, ucs1, sentence);
		command.execute();
		
		assertEquals(ucs1, ucs2);
	}

	// all tools together
	@Test
	public final void testParseSentence() {
		
		String sentenceString = "Administrator send messages.";
	
		
		Sentence sentence = LingTools.parseSentence(sentenceString);
				
		System.out.println(sentence.toString());
		assertTrue(sentence.toString().length() > 1);
	}
	
	// all tools together including analyse
	// like in a GUI
	@Test
	public final void testAnalyseUseCaseStep() {
		
		String sentenceString = "Administrator sends messages.";

		UsecaseFactory ucfactory = UsecaseFactory.eINSTANCE;		
		UseCaseStep ucs = ucfactory.createUseCaseStep();
		
		ucs.setContent(sentenceString);
		
		CompoundCommand command = LingTools.analyseUseCaseStep(null, ucs);
				
		assertTrue(command.getCommandList().size() > 1);
	}
	
}
