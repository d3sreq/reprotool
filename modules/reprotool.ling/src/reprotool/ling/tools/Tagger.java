package reprotool.ling.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.Bundle;

import reprotool.ling.Activator;
import reprotool.ling.Tool;

/**
 * @author ofiala
 *
 */
public class Tagger extends Tool{
	
	static boolean runs = false;
	// is already running
	static boolean running = false;
	// tool IO
	static InputStream input;
	static ByteArrayOutputStream baos;
	// standard IO
	static PrintStream stdout = System.out;
	static InputStream stdin = System.in;
	
	public String run(String text) {
		return getMXPOST(text);
	}

	/**
	 * Was running?
	 * 
	 * @return
	 */
	public static boolean isInicialized(){
		return runs;
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
		/*
		// locating external model
		try{
			path = Platform.getPreferencesService().getString("reprotool.ide", "mxpostModel", "/tagger.project", null);
		} catch (NullPointerException e){
			String rootPath;
			try {
				rootPath = new java.io.File(Tagger.class.getResource("/").toURI()).getParentFile().getParent();
			} catch (URISyntaxException e1) {
				rootPath = new java.io.File(Tagger.class.getResource("/").getPath()).getParentFile().getParent();
			}
			path = rootPath + "/reprotool.tools.mxpost/data/tagger.project";
		}*/
		
		
		// locating external model
    	Bundle bundle = Platform.getBundle("reprotool.tools.mxpost");
    	URL modelFileURL = bundle.getEntry("data/tagger.project");
	    try {
	    	path = new File(FileLocator.resolve(modelFileURL).toURI()).toString();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		
		// model exist validation
		File modelFile = new java.io.File(path);
		// run external tool MXPOST
		
		try {
			if(modelFile.exists() && !running){
				// running just for case job scheduling fails
				running = true;
				tagger.TestTagger.main(new String[] {path});
				running = false;
			} 
		} catch (Exception e) {
			// almost no control over external tool errors (model must be valid)
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "External tagger fails during initialization", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}	
		
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

    
    
	/**
	 * Method for testing tagger
	 * just parse one sentence.
	 */
	public static void start() {
		String sentence = "Administrator sends messages .";
		
		String result = getMXPOST(sentence);
		if(result.length() > 15) {
			runs = true;
		}
	}

	public static boolean isRunning() {
		return running;
	}  
        
}
