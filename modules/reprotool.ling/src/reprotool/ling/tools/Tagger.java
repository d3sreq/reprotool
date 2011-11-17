package reprotool.ling.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;

import org.eclipse.core.runtime.Platform;

import reprotool.ling.Tool;

/**
 * @author ofiala
 *
 */
public class Tagger extends Tool{
	
	static boolean runs = false;
	// tool IO
	static InputStream input;
	static ByteArrayOutputStream baos;
	// standard IO
	static PrintStream stdout = System.out;
	static InputStream stdin = System.in;
	// tagger
	//Thread tagger; 
	
	public String run(String text) {
		return getMXPOST(text);
	}
	
	
	private static boolean start () {
		String path = "";
		String text = "";
		
		// locating external model
		try{
			path = Platform.getPreferencesService().getString("reprotool.ide", "mxpostModel", "/tagger.project", null);
		} catch (NullPointerException e){
			String rootPath = new java.io.File(Tagger.class.getResource("/").getPath()).getParentFile().getParent();
			path = rootPath + "/../tools/MXPost_tagger/tagger.project";
		}

		/*
		 * http://www.java2s.com/Code/Java/SWT-JFace-Eclipse/SWTandThread.htm
		 *     final Thread applicationThread = new Thread("applicationThread") {
      public void run() {
        System.out.println("Hello from thread: \t" + Thread.currentThread().getName());
        display.syncExec(print);
        System.out.println("Bye from thread: \t" + Thread.currentThread().getName());
      }
    };
		 */
		
/*		
		PushbackInputStream pushIn = new PushbackInputStream(System.in);
		System.setIn(pushIn);
	*/	

		
/*	
		try{
			input = new ByteArrayInputStream("new window".getBytes("UTF-8"));
			System.setIn(input); 

		} catch (UnsupportedEncodingException e){}

		try {
			input.read("open window".getBytes("UTF-8"));
		} catch (IOException e1) { }
*/
		
		// set output stream
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		//System.setOut(ps);
		//System.setErr(ps);

	/*	
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		System.setIn(writer);
		
		try {
			writer.write("TEST\n");
			writer.flush();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	*/
		
	    PipedInputStream pin = new PipedInputStream();  
	    PipedOutputStream pout = new PipedOutputStream();
		try {
			pout = new PipedOutputStream(pin);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
	   
	    PrintStream out = new PrintStream(pout);  
//	    BufferedReader in = new BufferedReader(new InputStreamReader(pin));  
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
	   
	    out.println("Hello World!");  
	    out.flush();  
/*	   
	    try {
			System.out.println("Text written: " + in.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
*/
		
		// run external tool MXPOST
		tagger.TestTagger.main(new String[] {path});	
		
	    out.println("Hello World!");  
	    out.flush();  
		
/*		
		try {
			pushIn.read("new door".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		}
*/
		try {
			System.in.read("new door\n".getBytes());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		}	
		
/*		
		try {
			input.read("close window".getBytes("UTF-8"));
		} catch (IOException e1) { }
	*/	
		
/*		try{
			text = baos.toString("UTF-8");
		} catch (UnsupportedEncodingException e){}
		if(text.isEmpty()){
			runs = true;			
		}
*/
		// reset to standard output
		System.setOut(stdout);
		// reset to standard input
		System.setIn(stdin);
				
		return runs;
	}
	
	private static String tagg (String originalText) {
    	String result = null;
    	
		// set input stream
		try{
			input = new ByteArrayInputStream(originalText.getBytes("UTF-8"));
			System.setIn(input); 
		} catch (UnsupportedEncodingException e){}		
		// set output stream
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		// run external tool MXPOST
		//tagger.TestTagger.main(new String[] {path});	
		
		try{
			result = baos.toString("UTF-8");
		} catch (UnsupportedEncodingException e){}
		
		// reset to standard output
		System.setOut(stdout);
		// reset to standard input
		System.setIn(stdin);
		
		return result.trim();
	}
	
	/**
	 * Returns tokens from given text
	 *
	 * @return String part-of-speech_tagged_text 
	 */		
	// main method
    public static String getMXPOSTNew(String originalText) {
    	String taggedText = "";
    	// TODO divide start and tagg
    	if (runs){ // get response from tool
    		taggedText = tagg(originalText);   			
    		
    	} else { // load models
    		if(start()){    			
    			//taggedText = tagg(originalText);    
    		} else {
    			System.err.println("Tagger not ready during tagging.");
    		}
    	}
        return taggedText;
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
