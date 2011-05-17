package reprotool.ling.wordnet;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.Platform;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.item.Pointer;

public class WordNet {
	
	private static IDictionary dict = null;

	/**
	 * Returns antonyms for given word
	 *
	 * @return List<String> antonyms 
	 */
    public static List<String> get_Antonyms(String inWord) {	
		
		String path = Platform.getPreferencesService().getString("reprotool.ide", "wordnetDictionary", "/dict", null);
		List<String> antonyms = new ArrayList<String>();
		
		if(inWord.isEmpty())
			return antonyms;
		
		// check URL
    	URL url = null;
    	try{ 
    		url = new URL("file", null, path); 
    	} 
    	catch(MalformedURLException e){ e.printStackTrace(); }
    	if(url == null) return antonyms;
    	
		// construct the dictionary and open it
		//IDictionary dict = new Dictionary(url);
    	dict = new Dictionary(url);
    	try{ dict.open(); 
    	} catch(Exception e) { return antonyms; } 

		// look up first sense of the word
		IIndexWord idxWord = dict.getIndexWord(inWord, POS.NOUN);
		IWordID wordID = idxWord.getWordIDs().get(0);
		IWord word = dict.getWord(wordID);

		for (IWordID antonym : word.getRelatedWords(Pointer.ANTONYM)) {
			antonyms.add(dict.getWord(antonym).getLemma());
		} 
		dict.close();
		
		return antonyms;
	}	
	
	/**
	 * Returns true if dictionary exists
	 *
	 * @return Boolean 
	 */
    public static Boolean validateDictionary(String path) {	
    	//return false;
    	
		// check URL
    	URL url = null;
    	try{ 
    		url = new URL("file", null, path); 
    	} 
    	catch(MalformedURLException e){ e.printStackTrace(); }
    	if(url == null) return false;
    	
		dict = new Dictionary(url);
    	try{     	
    		// construct the dictionary and open it
    		dict.open(); 
    	} 
    	catch(Exception e){ return false; }		

		dict.close();
		return true;			
	}    
    
	/*
	 * testing purpose
	 */
    public static String testString() {
    	return "testString";
    }

	/**
	 * Open if dictionary exists
	 *
	 * @return Boolean 
	 */
    public static Boolean open() {	

		String path = Platform.getPreferencesService().getString("reprotool.ide", "wordnetDictionary", "/dict", null);
   	
		// check URL
    	URL url = null;
    	try{ 
    		url = new URL("file", null, path); 
    	} 
    	catch(MalformedURLException e){ e.printStackTrace(); }
    	if(url == null) return false;
    	
		dict = new Dictionary(url);
    	try{     	
    		// construct the dictionary and open it
    		dict.open(); 
    	} 
    	catch(Exception e){ return false; }		

		return true;			
	}        

	/**
	 * Close if dictionary exists
	 *
	 * @return Boolean 
	 */
    public static Boolean close() {	
    	
    	if(dict.isOpen()) {
    		dict.close();
    		return true;
    	}
    	return false;	
	}   
 
    
	/**
	 * Returns antonyms for given word
	 *
	 * @return List<String> antonyms 
	 */
    public static List<String> getAntonyms(String inWord) {	
		List<String> antonyms = new ArrayList<String>();
	
		if(inWord.isEmpty())			
			return antonyms;

		if(!dict.isOpen())
			dict.open();		
		
		// look up first sense of the word
		IIndexWord idxWord = dict.getIndexWord(inWord, POS.NOUN);
		// bad err propagation in framework
		if(idxWord != null){
			IWordID wordID = idxWord.getWordIDs().get(0);
			IWord word = dict.getWord(wordID);
	
			for (IWordID antonym : word.getRelatedWords(Pointer.ANTONYM)) {
				antonyms.add(dict.getWord(antonym).getLemma());
			} 
		}
		return antonyms;
	}	  

	/**
	 * Returns antonyms for given word
	 *
	 * @return List<String> antonyms 
	 */
    public static List<String> getAntonyms(String inWord, String pos) {	
		List<String> antonyms = new ArrayList<String>();
	
		if(inWord.isEmpty())			
			return antonyms;

		if(!dict.isOpen())
			dict.open();	
		
		POS initPOS;
		if(pos == "verb"){
			initPOS = POS.VERB;			
		} else if (pos == "adjective"){
			initPOS = POS.ADJECTIVE;
		} else if (pos == "adverb"){
			initPOS = POS.ADVERB;
		} else {
			initPOS = POS.NOUN;
		}
				
		// look up first sense of the word
		IIndexWord idxWord = dict.getIndexWord(inWord, initPOS);
		// bad err propagation in framework
		if(idxWord != null){
			IWordID wordID = idxWord.getWordIDs().get(0);
			IWord word = dict.getWord(wordID);
	
			for (IWordID antonym : word.getRelatedWords(Pointer.ANTONYM)) {
				antonyms.add(dict.getWord(antonym).getLemma());
			} 
		}
		return antonyms;
	}    
    
}
