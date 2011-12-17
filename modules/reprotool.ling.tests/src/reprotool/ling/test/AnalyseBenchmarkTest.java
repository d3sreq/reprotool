package reprotool.ling.test;

import static org.junit.Assert.*;
import org.junit.Test;

import reprotool.ling.benchmark.AnalyseBenchmark;

/**
 * @author ofiala
 * 
 */
public class AnalyseBenchmarkTest {

	// loading file
	@Test
	public final void testLoad() {
		
		int sentences = 0;
		
		AnalyseBenchmark ab = new AnalyseBenchmark();
		ab.loadData();
		sentences = ab.getSentenceCount();
			
		assertTrue(sentences > 17);
	}

	// parsing selected sentence
	@Test
	public final void testParse() {

		boolean parsed = false;
		
		AnalyseBenchmark ab = new AnalyseBenchmark();
		ab.loadData();
		parsed = ab.parse(14);
		
		assertTrue(parsed);
	}
	
	// parsing all sentences
	@Test
	public final void testParseAll() {

		boolean parsed = false;
		
		AnalyseBenchmark ab = new AnalyseBenchmark();
		ab.loadData();
		parsed = ab.parseAll();
		
		assertTrue(parsed);
	}
	
	// parsing all sentences
	@Test
	public final void testAnalyseAll() {

		boolean analysed = false;
		
		AnalyseBenchmark ab = new AnalyseBenchmark();
		ab.loadData();
		// parse first
		if(ab.parseAll()) {
			analysed = ab.analyseAll();
		}
		assertTrue(analysed);
	}
	
	// print stats
	@Test
	public final void testResults() {

		String stats = "";
		
		AnalyseBenchmark ab = new AnalyseBenchmark();
		ab.loadData("one.csv");
		// parse first
		if(ab.parseAll()) {
			ab.analyseAll();
			stats = ab.getResults();
		}
		System.out.println(stats);
		assertTrue(stats.length() > 10);
	}
}
