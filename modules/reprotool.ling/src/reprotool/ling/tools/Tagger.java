package reprotool.ling.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.runtime.Platform;

import reprotool.ling.Tool;

/**
 * @author ofiala
 *
 */
public class Tagger extends Tool{
	
	
	public String run(String text) {
		return getMXPOST(text);
	}
	
	/**
	 * Returns tokens from given text
	 *
	 * @return String part-of-speech_tagged_text 
	 */	
    public static String getMXPOST(String originalText) {	
		String path = "";
		String text = "";
		
		PrintStream stdout = System.out;
		InputStream stdin = System.in;
		
		// locating external model
		try{
			path = Platform.getPreferencesService().getString("reprotool.ide", "mxpostModel", "/tagger.project", null);
		} catch (NullPointerException e){
			String rootPath = new java.io.File(Tagger.class.getResource("/").getPath()).getParentFile().getParent();
			path = rootPath + "/../tools/MXPost_tagger/tagger.project";
		}
	
		try{
			InputStream input = new ByteArrayInputStream(originalText.getBytes("UTF-8"));
			System.setIn(input); 
		} catch (UnsupportedEncodingException e){}
		
		// set output stream
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		//System.setErr(ps);
		
		// run external tool MXPOST
		tagger.TestTagger.main(new String[] {path});		

		try{
			text = baos.toString("UTF-8");
		} catch (UnsupportedEncodingException e){}

		// reset to standard output
		System.setOut(stdout);
		// reset to standard input
		System.setIn(stdin);
		
		return text.trim();
	}	
    
    
	/**
	 * Converts MXPOS format to WSJ Penn Treebank lisp style
	 * @param word_POS word_POS ...
	 * @return String ((word (POS)) (word (POS)) ...) 
	 */	
    public static String mxposToLisp(String mxposStyle) {
    	String[] parts;
    	String lispStyle = "";
		
    	lispStyle = "(";
    	for (String word : mxposStyle.split(" ")) {
    		parts = word.split("_");
    		if (parts.length == 2) {
    			lispStyle += "(" + parts[0] + " (" + parts[1] + ")) "; 
    		} else {
    			lispStyle += "(" + word + " (" + word + ")) "; 
    		}
    	}
    	lispStyle += ")";
    	
		return lispStyle.trim();
	}  
        
}
