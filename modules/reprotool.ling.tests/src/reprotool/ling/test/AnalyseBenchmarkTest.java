package reprotool.ling.test;

import static org.junit.Assert.assertTrue;
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
			
		assertTrue(sentences > 1);
	}
	
	// parsing sentences
	@Test
	public final void testParse() {

		boolean parsed = false;
		
		AnalyseBenchmark ab = new AnalyseBenchmark();
		ab.loadData();
		parsed = ab.parseAll();
		
		assertTrue(parsed);
	}
}
