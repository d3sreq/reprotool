package reprotool.ling.wordnet;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.item.Pointer;

public class WordNet {

	/**
	 * Returns antonyms for given word
	 *
	 * @return List<String> antonyms 
	 */
    public static List<String> getAntonyms(String inWord) {	
		
		String path = Platform.getPreferencesService().getString("reprotool.ide", "wordnetDictionary", "/dict", null);
		List<String> antonyms = new ArrayList<String>();
		
		// check URL
    	URL url = null;
    	try{ 
    		url = new URL("file", null, path); 
    	} 
    	catch(MalformedURLException e){ e.printStackTrace(); }
    	if(url == null) return antonyms;
    	
		// construct the dictionary and open it
		IDictionary dict = new Dictionary(url);

		dict.open();
	
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
	
	/*
	 * testing purpose
	 */
    public static String testString() {
    	return "testString";
    }

}
