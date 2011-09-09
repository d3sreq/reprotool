package reprotool.ling.test;

import static org.junit.Assert.*;

import org.junit.Test;

import reprotool.ling.LingTools;

public class ParseTest {

	@Test
	public final void testParseLingSentence() {
		//fail("Not yet implemented"); 
		String sentence = "Need a car.";
		
		assertEquals("Need_RB a_DT car_NN ._.", LingTools.parseLingSentence(sentence).trim());
	}

}
