package reprotool.ling.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.progress.IProgressConstants;

import reprotool.ling.LingJob;

public class Tagger {
	/**
	 * Returns tokens from given text
	 *
	 * @return String part-of-speech_tagged_text 
	 */	
    public static String getMXPOST(String originalText) {	
		String path = Platform.getPreferencesService().getString("reprotool.ide", "mxpostModel", "/tagger.project", null);
		String text = "";
	
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
