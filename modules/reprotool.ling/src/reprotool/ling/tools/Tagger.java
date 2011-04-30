package reprotool.ling.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.runtime.Platform;

public class Tagger {
	/**
	 * Returns tokens from given text
	 *
	 * @return String part-of-speech_tagged_text 
	 */	
    public static String getMXPOST(String originalText) {	
		String path = Platform.getPreferencesService().getString("reprotool.ide", "mxpostModel", "/tagger.project", null);
		
		String text = "";
		
		/*
		//create file object
		File file = new File("D://Projects//ReProTool//SVN//trunk//tools//MXPost_tagger//tagger.project//test.txt");
		// set input stream
		try {
			InputStream input = new FileInputStream(file);
			System.setIn(input); 
		} catch(FileNotFoundException e){}
		*/
	
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
}
