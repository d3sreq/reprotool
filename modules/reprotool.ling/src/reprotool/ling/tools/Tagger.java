package reprotool.ling.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;


import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;


import reprotool.ling.Activator;
import reprotool.ling.LingJob;

public class Tagger {
	/**
	 * Returns tokens from given text
	 *
	 * @return String part-of-speech_tagged_text 
	 */	
    public static String getMXPOST(String originalText) {	
		String path = "";
		String text = "";
	
		// locating external model
		try{
			path = Platform.getPreferencesService().getString("reprotool.ide", "mxpostModel", "/tagger.project", null);
		} catch (NullPointerException e){
			// URL to the root ("/") of the plugin-path
			/*
			URL pluginURL = Activator.getContext().getBundle().getEntry("/");
			// resolving URL
	        try {
	        	pluginURL = FileLocator.toFileURL(pluginURL);
	        }
	        catch(IOException ex) {
	            ex.printStackTrace();
	        }
	        String rootPath = pluginURL.getPath();

			rootPath = new java.io.File(rootPath).getParentFile().getParent();
			*/
			//"D:\Projects\ReProTool\SVN\trunk/tools/MXPost_tagger/tagger.project";	
			String rootPath = "D:/Projects/ReProTool/SVN/trunk";
			path = rootPath + "/tools/MXPost_tagger/tagger.project";
		}
		
		try{
			InputStream input = new ByteArrayInputStream(originalText.getBytes("UTF-8"));
			System.setIn(input); 
		} catch (UnsupportedEncodingException e){}
	
		// set output stream
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		System.setOut(ps);
		
		// run external tool MXPOST
		tagger.TestTagger.main(new String[] {path});

		try{
			text = baos.toString("UTF-8");
		} catch (UnsupportedEncodingException e){}
		
		return text;
	}	
    
	/**
	 * Returns tokens from given text
	 *
	 * @return String part-of-speech_tagged_text 
	 */	
    public static String jobGetMXPOST(String originalText) {	
    	String text = "";
		
    	LingJob job = new LingJob("MX POS tagger", originalText, null);
    	 
    	job.schedule();
    	
    	text = job.returnText();
		
		return text;
	}    
        
}
