// FIXME ofiala
//
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import reprotool.ling.tools.Parser;
//import reprotool.ling.tools.Tagger;
//import reprotool.ling.tools.Tokenizer;
//import reprotool.model.linguistic.parsetree.NounPhraseNode;
//import reprotool.model.linguistic.parsetree.ParsetreeFactory;
//import reprotool.model.linguistic.parsetree.SentenceNode;
//import reprotool.model.linguistic.parsetree.VerbPhraseNode;
//import reprotool.model.linguistic.parsetree.Word;
//
//public class ParseTest {
//
//	// first sentence
//	@Test
//	public final void testTokenizer1() {
//		String sentence = "Administrator sends messages.";
//		
//		assertEquals("Administrator sends messages .", Tokenizer.getTokens(sentence));
//	}
//		
//	@Test
//	public final void testTagger1() {
//		String sentence = "Administrator sends messages .";
//		
//		assertEquals("Administrator_NNP sends_VBZ messages_NNS ._.", Tagger.getMXPOST(sentence));
//	}
//
//	@Test
//	public final void testTaggerLisp1() {
//		String sentence = "Administrator sends messages .";
//		String lisp = "";
//		lisp = Tagger.mxposToLisp(Tagger.getMXPOST(sentence));
//		
//		assertEquals("((Administrator (NNP)) (sends (VBZ)) (messages (NNS)) (. (.)) )", lisp);
//	}
//	
//	@Test
//	public final void testParserString1() {
//		String sentence = "((Administrator (NNP)) (sends (VBZ)) (messages (NNS)) (. (.)) )";
//		
//		assertEquals("(S (NP (NNP Administrator)) (VP (VBZ sends) (NP (NNS messages))) (. .))", Parser.getString(sentence));
//	}
//	
//	@Test
//	public final void testParserTree1() {
//		String sentence = "(S (NP (NNP Administrator)) (VP (VBZ sends ) (NP (NNS messages))))";
//		
//		ParsetreeFactory factory = ParsetreeFactory.eINSTANCE;
//		SentenceNode rootNode = factory.createSentenceNode();
//		
//		NounPhraseNode nounPhrase = factory.createNounPhraseNode();
//		rootNode.getChildNodes().add(nounPhrase);
//		nounPhrase.setParentNode(rootNode);
//		
//		Word curWord = factory.createWord();	
//		curWord.setWordPOS("NNP");
//		curWord.setWordStr("Administrator");
//		nounPhrase.getChildNodes().add(curWord);
//		
//		VerbPhraseNode verbPhrase = factory.createVerbPhraseNode();
//		rootNode.getChildNodes().add(verbPhrase);
//		verbPhrase.setParentNode(rootNode);
//
//		curWord = factory.createWord();	
//		curWord.setWordPOS("VBZ");
//		curWord.setWordStr("sends");
//		verbPhrase.getChildNodes().add(curWord);
//		
//		nounPhrase = factory.createNounPhraseNode();
//		verbPhrase.getChildNodes().add(nounPhrase);
//		nounPhrase.setParentNode(verbPhrase);
//		
//		curWord = factory.createWord();	
//		curWord.setWordPOS("NNS");
//		curWord.setWordStr("messages");
//		nounPhrase.getChildNodes().add(curWord);
//		
//		SentenceNode parsedNode = Parser.getTree(sentence);
//
//		// TODO vypsani stromu do stringu
//		assertSame(rootNode, parsedNode);
//	}
//	
//	// second sentence
//	@Test
//	public final void testTokenizer2() {
//		String sentence = "User uses top view in a client.";
//		
//		assertEquals("User uses top view in a client .", Tokenizer.getTokens(sentence));
//	}
//	
//	@Test
//	public final void testTagger2() {
//		String sentence = "User uses top view in a client .";
//		
//		assertEquals("User_NNP uses_VBZ top_JJ view_NN in_IN a_DT client_NN ._.", Tagger.getMXPOST(sentence));
//	}
//
//	
//	@Test
//	public final void testTaggerLisp2() {
//		String sentence = "User uses top view in a client .";
//		String lisp = "";
//		lisp = Tagger.mxposToLisp(Tagger.getMXPOST(sentence));
//		
//		assertEquals("((User (NNP)) (uses (VBZ)) (top (JJ)) (view (NN)) (in (IN)) (a (DT)) (client (NN)) (. (.)) )", lisp);
//	}	
//	
//	@Test
//	public final void testParserString2() {
//		String sentence = "((User (NNP)) (uses (VBZ)) (top (JJ)) (view (NN)) (in (IN)) (a (DT)) (client (NN)) (. (.)) )";
//		
//		assertEquals("(S (NP (NNP User)) (VP (VBZ uses) (NP (JJ top) (NN view)) (PP (IN in) (NP (DT a) (NN client)))) (. .))", Parser.getString(sentence));
//	}
//	
//	
//}
