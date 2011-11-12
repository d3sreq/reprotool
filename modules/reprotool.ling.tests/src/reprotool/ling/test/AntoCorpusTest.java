package reprotool.ling.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import reprotool.ling.antocorpus.AntoCorpus;
import reprotool.ling.antocorpus.AntoWord;
//import reprotool.ling.antocorpus.ExportWordNet;

/**
 * @author ofiala
 * 
 */

public class AntoCorpusTest {
	String corpusFile = "../../tools/AntoCorpus/corpus.xml";

	@Test
	public final void testAntoCorpus() {
		//String corpusFile = "corpus.xml";
		AntoCorpus corpus = new AntoCorpus(corpusFile);
		
		assertEquals(corpusFile, corpus.getCorpusFile());
	}
	
	@Test
	public final void testLoadAntoCorpus() {
		//String corpusFile = "corpus.xml";
		AntoCorpus corpus = new AntoCorpus(corpusFile);
		corpus.loadCorpus();

		assertTrue(corpus.length() > 2);
	}
	
	@Test
	public final void testGenerateCorpus() {
		//String corpusFile = "../../corpus.xml";
		AntoCorpus corpus = new AntoCorpus(corpusFile);
		
		corpus.addAntoWord("male", "female", "NN");
		corpus.addAntoWord("big", "small", "JJ");
		
		try {
			corpus.writeCorpus();
		} catch (Exception e) {}
		
		File f = new File(corpusFile);

		assertTrue(f.exists());
	}
	
//	/**
//	 * Address path doesn't need to be valid
//	 */
//	@Test
//	public final void testExportWordNet() {
//		AntoCorpus corpus = new AntoCorpus(corpusFile);
//		
//		ExportWordNet.export("D:\\Projects\\ReProTool\\SVN\\trunk\\tools\\WordNet-3.0\\dict", corpus);
//
//		try {
//			corpus.writeCorpus();
//		} catch (Exception e) {}
//		
//		assertTrue(corpus.length() > 1000);
//	}

	@Test
	public final void testFindAntoWord() {
		AntoCorpus corpus = new AntoCorpus(corpusFile);
		AntoWord word = new AntoWord();
		
		corpus.loadCorpus();
		
		word = corpus.findWord("ability");
		
		assertNotNull(word);
	}
	
	@Test
	public final void findAntonym() {
		AntoCorpus corpus = new AntoCorpus(corpusFile);
		
		corpus.loadCorpus();
		
		assertEquals("inability", corpus.findAntonym("ability"));
	}
	
	@Test
	public final void findAntonym2() {
		AntoCorpus corpus = new AntoCorpus(corpusFile);
		
		corpus.loadCorpus();
		
		assertEquals("ability", corpus.findAntonym("inability"));
	}
	
	@Test
	public final void findAntonym3() {
		AntoCorpus corpus = new AntoCorpus(corpusFile);
		
		corpus.loadCorpus();
		
		assertEquals("", corpus.findAntonym("reinability"));
	}
}
