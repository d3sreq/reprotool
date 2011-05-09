package reprotool.ling;

import java.util.regex.Pattern;

public class Sentence {
	/**
	 * Returns negation of a given text
	 *
	 * @return String negation 
	 */	
    public static String getNegation(String originalText) {
    	String negation = originalText;
    	
    	/* erasing parts */
    	negation = Pattern.compile("n't_RB").matcher(negation).replaceAll("");
    	negation = Pattern.compile("no_DT").matcher(negation).replaceAll("");
    	
    	return negation;
    }
}
