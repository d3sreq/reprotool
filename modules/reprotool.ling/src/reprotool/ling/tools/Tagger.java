package reprotool.ling.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;

import reprotool.ling.Activator;
import reprotool.ling.Tool;

/**
 * @author ofiala
 *
 */
public class Tagger extends Tool{
	
	static boolean runs = false;
	// tool IO
	//static InputStream input;
	static ByteArrayOutputStream baos;
	static ByteArrayOutputStream err;
	// standard IO
	static InputStream stdin = System.in;
	static PrintStream stdout = System.out;
	static PrintStream stderr = System.err;
	// piped stream between threads
	static PipedInputStream pins;
	static PipedOutputStream pouts;
	// tagger thread
	static public TaggerThread tagger; 
	
	public String run(String text) {
		return getMXPOST(text);
	}
	
	/**
	 * Returns tokens from given text
	 *
	 * @return String part-of-speech_tagged_text 
	 */		
	// main method
    public static String getMXPOST(String originalText) {
    	String taggedText = "";

    	if (runs){ // get response from tool
    		taggedText = tagg(originalText);   			
    		
    	} else { // load models
    		// restart tagger
    		if(start()){    			
    			taggedText = tagg(originalText);    
    		} else {
    			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Tagger not ready during tagging", null);
    			StatusManager.getManager().handle(status, StatusManager.LOG);
    		}
    	}
        return taggedText;
    }	
    
	/**
	 * Is still running?
	 * 
	 * @return
	 */
	public static boolean isReady(){
		return tagger.isAlive();
	}    
    
	/**
	 * Was running?
	 * 
	 * @return boolean
	 */
	public static boolean isInicialized(){
		return runs;
	}
    

	/**
	 * Set all streams to standard streams
	 * 
	 * For repair purpose
	 */
	public static void resetStdStreams(){
		System.setIn(stdin);
		System.setOut(stdout);
		System.setErr(stderr);
	}
	
	public static boolean start () {

    	pins = new PipedInputStream();
    	try {
			pouts = new PipedOutputStream(pins);
		} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Tagger input stream error", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}
    	
		// set output stream
		baos = new ByteArrayOutputStream();
		// set output stream
		err = new ByteArrayOutputStream();
		
    	tagger = new TaggerThread(pins, baos, err);
    	tagger.start();

    	// wait till model loads
		try {
			while(!err.toString("UTF-8").trim().endsWith("Ratnaparkhi*")) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Tagger thread was interrupted during initialization", e);
					StatusManager.getManager().handle(status, StatusManager.LOG);
				}
			}
		} catch (UnsupportedEncodingException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Tagger after initialization test - wrong encoding", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}
		
		// reset used streams
		err.reset();
		System.setErr(stderr);
    	
		// finished loading model
		runs = true;
    	return runs;
	}
		
	private static String tagg (String originalText) {	
		String text = "";
		
		// make whole line
		if(!originalText.endsWith("\n")) originalText += "\n";
		
		// set output stream
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);

		try {
			pouts.write(originalText.getBytes("UTF-8"), 0, originalText.length());
		} catch (UnsupportedEncodingException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Tagger wrong encoding error during tagging", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Tagger stream error during tagging", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}		
	
		// waiting until TaggerThread returns sentence
		try {
			while(baos.toString("UTF-8").isEmpty()) {
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Tagger thread was interrupted during waiting for result", e);
					StatusManager.getManager().handle(status, StatusManager.LOG);
				}
			}
		} catch (UnsupportedEncodingException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Tagger wrong encoding error during waiting for result", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}
		
		try {
			text = baos.toString("UTF-8").trim();
		} catch (UnsupportedEncodingException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Tagger wrong encoding error during parsing result", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}

		// remove old strings
		baos.reset();
		
		// set standard streams
		//System.setIn(stdin);
		System.setOut(stdout);
		//System.setErr(stderr);
		return text;
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
