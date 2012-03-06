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
		
		// putting space before bad characters
		text = Pattern.compile("\\(").matcher(text).replaceAll(" -LRB- ");
		text = Pattern.compile("\\)").matcher(text).replaceAll(" -RRB- ");
		
		// whitespaces cleanup
		text = Pattern.compile("[ ]+").matcher(text).replaceAll(" ");
		
		// remove bad characters - handled in next stages by SentenceRegions
		text = Pattern.compile("\"").matcher(text).replaceAll("");
		text = Pattern.compile(" ' ").matcher(text).replaceAll(" ");
		
		tokens = text.trim();		
		return tokens;
	}
    
	/**
	 * Returns sentence string with removed odd characters
	 *
	 * @return List<String> tokens 
	 */	
    public static String getSafeSentence(String originalText) {	
    	String result = "";
		String text = originalText;
		
		// running at blank data
    	if(originalText.isEmpty()) {
    		return originalText;
    	}    	
    	//text = text.replaceAll("[^\\p{Print}]", "");  
    	text = text.replaceAll("[^a-zA-Z0-9'\".,?!:;]", " ");
    	
		result = text.trim();    	
    	return result;
    }
    
}
