package reprotool.ling.tools;

import java.util.regex.Pattern;

import reprotool.ling.Tool;

/**
 * @author ofiala
 *
 */
public class Tokenizer extends Tool{

	
	public String run(String text) {
		return getTokens(text);
	}
	
	/**
	 * Returns tokens from given text
	 *
	 * @return List<String> tokens 
	 */	
    public static String getTokens(String originalText) {	
    	String tokens = "";
		String text = originalText;
		
		// running at blank data
    	if(originalText.isEmpty()) {
    		return originalText;
    	}
		
		//separate alphabetical tokens
		text = Pattern.compile("([a-zA-Z]+)").matcher(text).replaceAll(" $1 ");
		
		// separate punctation
		text = Pattern.compile("([^ !])(!+)").matcher(text).replaceAll("$1 $2");
	
		// stems English elisions, except for the ambiguous cases of 's and 'd
		text = Pattern.compile("Won \' t").matcher(text).replaceAll("Won* n\'t");
		text = Pattern.compile("Can \' t").matcher(text).replaceAll("Can* n\'t");
		text = Pattern.compile("Shan \' t").matcher(text).replaceAll("Shan* n\'t");
		text = Pattern.compile("won \' t").matcher(text).replaceAll("won* n\'t");
		text = Pattern.compile("can \' t").matcher(text).replaceAll("can* n\'t");
		text = Pattern.compile("shan \' t").matcher(text).replaceAll("shan* n\'t");
		text = Pattern.compile("n ' t").matcher(text).replaceAll(" n't");
		
		// whitespaces cleanup
		text = Pattern.compile("[ ]+").matcher(text).replaceAll(" ");
		
		//tokens = Arrays.asList(text.trim().split("\\s+"));
		tokens = text.trim();
		
		return tokens;
	}		
}
