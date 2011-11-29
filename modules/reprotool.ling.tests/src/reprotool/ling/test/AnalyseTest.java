package reprotool.ling.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import reprotool.ling.LingFactory;
import reprotool.ling.LingTools;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.Word;
import reprotool.ling.analyser.Analyser;
import reprotool.ling.analyser.FindConstituent;
import reprotool.ling.analyser.MatchSentence;
import reprotool.ling.tools.Parser;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;

/**
 * @author ofiala
 * 
 */
public class AnalyseTest {

	// whole sentence
	@Test
	public final void testAnalyse1() {
		// input
		String sentenceString = "System provides the seller with a prise assessment.";
		// result
		String result = "";

		// parse
		Sentence sentence = LingTools.parseSentence(sentenceString);
		// analyse
		Word word = FindConstituent.findSubject(sentence);
		if (word != null) 
			result += "SUBJECT: " + word.getLemma() + " ";

		word = FindConstituent.findMainVerb(sentence);
		if (word != null) 
			result += "VERB: " + word.getLemma() + " ";

		ArrayList<Word> inobjs = FindConstituent.findIndirectObject(sentence);
		ArrayList<Word> words = null;
		// found indirect objects
		if (inobjs.size() > 0)
			words = FindConstituent.findRepresentativeObject(sentence, (SentenceNode)inobjs.get(0).getParent());			
		else
			words = FindConstituent.findRepresentativeObject(sentence, null);
		
		if(words.size() > 0){
			result += "OBJECT: ";
			for (Word iword : words) 
				result += iword.getLemma() + " ";
		}
		
		if(inobjs.size() > 0){
			result += "INDIRECT_OBJECT: ";
			for (Word iword : inobjs) 
				result += iword.getLemma() + " ";
		}		
		
		System.out.println(result);
		
		assertTrue(result.length() > 15);
	}
	
	@Test
	public final void testAnalyse2() {
		// input
		String sentenceString = "System provides a prise assessment to the seller. ";
		// result
		String result = "";

		// parse
		Sentence sentence = LingTools.parseSentence(sentenceString);
		// analyse
		Word word = FindConstituent.findSubject(sentence);
		if (word != null) 
			result += "SUBJECT: " + word.getLemma() + " ";

		word = FindConstituent.findMainVerb(sentence);
		if (word != null) 
			result += "VERB: " + word.getLemma() + " ";

		ArrayList<Word> inobjs = FindConstituent.findIndirectObject(sentence);
		ArrayList<Word> words = null;
		// found indirect objects
		if (inobjs.size() > 0)
			words = FindConstituent.findRepresentativeObject(sentence, (SentenceNode)inobjs.get(0).getParent());			
		else
			words = FindConstituent.findRepresentativeObject(sentence, null);
		
		if(words.size() > 0){
			result += "OBJECT: ";
			for (Word iword : words) 
				result += iword.getLemma() + " ";
		}
		
		if(inobjs.size() > 0){
			result += "INDIRECT_OBJECT: ";
			for (Word iword : inobjs) 
				result += iword.getLemma() + " ";
		}		
		
		System.out.println(result);
		
		assertTrue(result.length() > 15);
	}
	
	// first sentence
	@Test
	public final void testAnalyseTree() {

		String sentenceString = "(S (NP (NNP Administrator)) (VP (VBZ continue) (NP (NN view) (CD 1))))";
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
	public final void testAnalyseUseCaseStep1() {
		
		String sentenceString = "Administrator sends messages.";

		UsecaseFactory ucfactory = UsecaseFactory.eINSTANCE;		
		UseCaseStep ucs = ucfactory.createUseCaseStep();
		
		ucs.setContent(sentenceString);
		
		CompoundCommand command = LingTools.analyseUseCaseStep(null, ucs);
				
		assertTrue(command.getCommandList().size() > 1);
	}
	
	@Test
	public final void testAnalyseUseCaseStep2() {
		
		String sentenceString = "Administrator continue view 1";

		UsecaseFactory ucfactory = UsecaseFactory.eINSTANCE;		
		UseCaseStep ucs = ucfactory.createUseCaseStep();
		
		ucs.setContent(sentenceString);
		
		CompoundCommand command = LingTools.analyseUseCaseStep(null, ucs);
				
		assertTrue(command.getCommandList().size() > 1);
	}
	
	// matching Sentence object and SentenceString (UseCaseStep.content)
	@Test
	public final void testMatch1() {
		String sentenceString = "Administrator sends messages";
		boolean result = false;
		
		LingFactory  factory = LingFactory.eINSTANCE;
		Sentence sentence = factory.createSentence();
				
		EList<Word> words = sentence.getWords();
		Word word = factory.createWord();
		word.setText("Administrator");
		words.add(word);
		word = factory.createWord();
		word.setText("sends");
		words.add(word);
		word = factory.createWord();
		word.setText("messages");
		words.add(word);
		
		result = MatchSentence.matchSentence(sentenceString, sentence);
		
		assertTrue(result);
	}

	@Test
	public final void testMatch2() {
		String sentenceString = "Administrator continue view 1";
		boolean result = false;
		
		LingFactory  factory = LingFactory.eINSTANCE;
		Sentence sentence = factory.createSentence();
				
		EList<Word> words = sentence.getWords();
		Word word = factory.createWord();
		word.setText("Administrator");
		words.add(word);
		word = factory.createWord();
		word.setText("continue");
		words.add(word);
		word = factory.createWord();
		word.setText("view");
		words.add(word);
		word = factory.createWord();
		word.setText("1");
		words.add(word);
		
		result = MatchSentence.matchSentence(sentenceString, sentence);
		
		assertTrue(result);
	}

	@Test
	public final void testMatch3() {
		String sentenceString = "Administrator continue view1";
		boolean result = false;
		
		LingFactory  factory = LingFactory.eINSTANCE;
		Sentence sentence = factory.createSentence();
				
		EList<Word> words = sentence.getWords();
		Word word = factory.createWord();
		word.setText("Administrator");
		words.add(word);
		word = factory.createWord();
		word.setText("continue");
		words.add(word);
		word = factory.createWord();
		word.setText("view");
		words.add(word);
		word = factory.createWord();
		word.setText("1");
		words.add(word);
		
		result = MatchSentence.matchSentence(sentenceString, sentence);
		
		assertTrue(result);
	}
	
	@Test
	public final void testMatch4() {
		String sentenceString = "Administrator continue step 1";
		boolean result = false;
		
		LingFactory  factory = LingFactory.eINSTANCE;
		Sentence sentence = factory.createSentence();
				
		EList<Word> words = sentence.getWords();
		Word word = factory.createWord();
		word.setText("Administrator");
		words.add(word);
		word = factory.createWord();
		word.setText("continue");
		words.add(word);
		word = factory.createWord();
		word.setText("step");
		words.add(word);
		word = factory.createWord();
		word.setText("1");
		words.add(word);
		
		result = MatchSentence.matchSentence(sentenceString, sentence);
		
		assertTrue(result);
	}
	
	@Test
	public final void testMatch5() {
		String sentenceString = "Administrator continue to view2";
		boolean result = false;
		
		LingFactory  factory = LingFactory.eINSTANCE;
		Sentence sentence = factory.createSentence();
				
		EList<Word> words = sentence.getWords();
		Word word = factory.createWord();
		word.setText("Administrator");
		words.add(word);
		word = factory.createWord();
		word.setText("continue");
		words.add(word);
		word = factory.createWord();
		word.setText("to");
		words.add(word);
		word = factory.createWord();
		word.setText("view");
		words.add(word);
		word = factory.createWord();
		word.setText("2");
		words.add(word);
		
		result = MatchSentence.matchSentence(sentenceString, sentence);
		
		assertTrue(result);
	}

	@Test
	public final void testMatchLabel() {
		String sentenceString = "3aa111";
		boolean result = false;
		
		LingFactory  factory = LingFactory.eINSTANCE;
		Sentence sentence = factory.createSentence();
				
		EList<Word> words = sentence.getWords();
		Word word = factory.createWord();
		word.setText("3");
		words.add(word);
		word = factory.createWord();
		word.setText("aa");
		words.add(word);
		word = factory.createWord();
		word.setText("111");
		words.add(word);
		
		result = MatchSentence.matchSentence(sentenceString, sentence);
		
		assertTrue(result);
	}
	
}
