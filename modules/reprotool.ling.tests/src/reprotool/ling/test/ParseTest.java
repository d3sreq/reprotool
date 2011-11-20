package reprotool.ling.test;

import static org.junit.Assert.*;

/**
 * @author ofiala
 * 
 */

import org.junit.Test;

import reprotool.ling.LingFactory;
import reprotool.ling.POSType;
import reprotool.ling.SentenceNode;
import reprotool.ling.Word;
import reprotool.ling.tools.Lemmatizer;
import reprotool.ling.tools.Parser;
import reprotool.ling.tools.Tagger;
import reprotool.ling.tools.Tokenizer;

public class ParseTest {

	// testing threads
	@Test
	public final void testTaggerStreams() {
		String sentence = "Administrator opens view 1 .";
		String lisp = "";
		
		System.out.println("Tagger streams test 1");

		lisp = Tagger.getMXPOST(sentence);

		System.out.println("Tagger streams test 2");
		lisp = Tagger.getMXPOST(sentence + "huh");
		System.out.println("Tagger streams test 3");
		
		assertEquals("((Administrator (NNP)) (opens (VBZ)) (view (NN)) (1 (CD)) (.huh (.)) )", Tagger.mxposToLisp(lisp));
	}
	
	// testing goto
	@Test
	public final void testTaggerLispNumeral() {
		String sentence = "Administrator opens view 1 .";
		String lisp = "";
		lisp = Tagger.mxposToLisp(Tagger.getMXPOST(sentence));
		
		assertEquals("((Administrator (NNP)) (opens (VBZ)) (view (NN)) (1 (CD)) (. (.)) )", lisp);
	}
	
	@Test
	public final void testParserStringNumeral() {
		String sentence = "((Administrator (NNP)) (opens (VBZ)) (view (NN)) (1 (CD)) (. (.)) )";
		
		assertEquals("(S (NP (NNP Administrator)) (VP (VBZ opens) (NP (NN view) (CD 1))) (. .))", Parser.getString(sentence));
	}

	// first sentence
	@Test
	public final void testTokenizer1() {
		String sentence = "Administrator sends messages.";
		
		assertEquals("Administrator sends messages .", Tokenizer.getTokens(sentence));
	}

	@Test
	public final void testTagger1() {
		String sentence = "Administrator sends messages .";
		
		assertEquals("Administrator_NNP sends_VBZ messages_NNS ._.", Tagger.getMXPOST(sentence));
	}
	
	@Test
	public final void testTaggerLisp1() {
		String sentence = "Administrator sends messages .";
		String lisp = "";
		lisp = Tagger.mxposToLisp(Tagger.getMXPOST(sentence));
		
		assertEquals("((Administrator (NNP)) (sends (VBZ)) (messages (NNS)) (. (.)) )", lisp);
	}
	
	@Test
	public final void testParserString1() {
		String sentence = "((Administrator (NNP)) (sends (VBZ)) (messages (NNS)) (. (.)) )";
		
		assertEquals("(S (NP (NNP Administrator)) (VP (VBZ sends) (NP (NNS messages))) (. .))", Parser.getString(sentence));
	}
	
	@Test
	public final void testParserTree1() {
		String sentenceString = "(S (NP (NNP Administrator)) (VP (VBZ sends ) (NP (NNS messages))))";
		
		LingFactory factory = LingFactory.eINSTANCE;
		SentenceNode rootNode = factory.createSentenceNode();
		
		SentenceNode nounPhrase = factory.createSentenceNode();
		rootNode.getChildren().add(nounPhrase);
		nounPhrase.setParent(rootNode);
		
		Word curWord = factory.createWord();	
		curWord.setPOS(POSType.get("NNP"));
		curWord.setText("Administrator");
		nounPhrase.getChildren().add(curWord);
		
		SentenceNode verbPhrase = factory.createSentenceNode();
		rootNode.getChildren().add(verbPhrase);
		verbPhrase.setParent(rootNode);

		curWord = factory.createWord();	
		curWord.setPOS(POSType.get("VBZ"));
		curWord.setText("sends");
		verbPhrase.getChildren().add(curWord);
		
		nounPhrase = factory.createSentenceNode();
		verbPhrase.getChildren().add(nounPhrase);
		nounPhrase.setParent(verbPhrase);
		
		curWord = factory.createWord();	
		curWord.setPOS(POSType.get("NNS"));
		curWord.setText("messages");
		nounPhrase.getChildren().add(curWord);
		
		SentenceNode node = Parser.parseTree(Parser.getString(sentenceString));
		
		// TODO vypsani stromu do stringu
		assertSame(rootNode, node);
	}
	
	// second sentence
	@Test
	public final void testTokenizer2() {
		String sentence = "User uses top view in a client.";
		
		assertEquals("User uses top view in a client .", Tokenizer.getTokens(sentence));
	}
	
	@Test
	public final void testTagger2() {
		String sentence = "User uses top view in a client .";
		
		assertEquals("User_NNP uses_VBZ top_JJ view_NN in_IN a_DT client_NN ._.", Tagger.getMXPOST(sentence));
	}
	
	@Test
	public final void testTaggerLisp2() {
		String sentence = "User uses top view in a client .";
		String lisp = "";
		lisp = Tagger.mxposToLisp(Tagger.getMXPOST(sentence));
		
		assertEquals("((User (NNP)) (uses (VBZ)) (top (JJ)) (view (NN)) (in (IN)) (a (DT)) (client (NN)) (. (.)) )", lisp);
	}	
	
	@Test
	public final void testParserString2() {
		String sentence = "((User (NNP)) (uses (VBZ)) (top (JJ)) (view (NN)) (in (IN)) (a (DT)) (client (NN)) (. (.)) )";
		
		assertEquals("(S (NP (NNP User)) (VP (VBZ uses) (NP (JJ top) (NN view)) (PP (IN in) (NP (DT a) (NN client)))) (. .))", Parser.getString(sentence));
	}

	// complex label like 3a1
	@Test
	public final void testTokenizerLabel1() {
		String sentence = "Continue to 3a1";
		
		assertEquals("Continue to 3 a 1", Tokenizer.getTokens(sentence));
	}
	
	@Test
	public final void testTaggerLispLabel1() {
		String sentence = "Continue to 3 a 1";
		String lisp = "";
		lisp = Tagger.mxposToLisp(Tagger.getMXPOST(sentence));
		
		assertEquals("((Continue (NNP)) (to (TO)) (3 (CD)) (a (DT)) (1 (CD)) )", lisp);
	}		
	
	@Test
	public final void testParserStringLabel1() {
		String sentence = "((Continue (NNP)) (to (TO)) (3 (CD)) (a (DT)) (1 (CD)) )";
		
		assertEquals("(NP (NP (NNP Continue)) (PP (TO to) (NP (NP (CD 3)) (NP (QP (DT a) (CD 1))))))", Parser.getString(sentence));
	}
	
	// lemmata
	@Test
	public final void testLemmatizer1() {
		String sentence = "Administrator sends messages .";
		
		assertEquals("administrator send message .", Lemmatizer.getString(sentence));
	}
	
}
