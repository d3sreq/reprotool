package reprotool.ling.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;

import is2.data.SentenceData09;
import reprotool.ling.Activator;
import reprotool.ling.Sentence;
import reprotool.ling.Tool;
import reprotool.ling.Word;

/**
 * @author ofiala
 *
 */
public class Lemmatizer extends Tool {

	static boolean runs = false;
	static is2.lemmatizer.Lemmatizer lemmatizer = null;
    static is2.lemmatizer.Options optionsLemmatizer = null;
	
	/**
	 * Get lemma form of each sentence
	 *
	 * @return String lemmas 
	 */	
	public String run(String text) {
		return getString(text);
	}
	
	// main method
    public static String getString(String originalText) {
    	String lemmatizedText = "";
    	
    	// running at blank data
    	if(originalText.isEmpty()) {
    		return lemmatizedText;
    	}
    	
    	if (runs){ // get response from tool
    		// is still running in memory TODO
    	} else { // load models first time
    		start();
    	}
    	
    	// lemmatization
    	lemmatizedText = lemmatize(originalText); 
    	
    	// returning lemmata
        return lemmatizedText;
    }  
    
    
	// main method
    public static Sentence getSentence(Sentence sentence) {
    	// running at blank data
    	if(sentence == null || sentence.getWords().isEmpty()) {
    		return sentence;
    	}
    	
    	if (runs){ // get response from tool
    		// is still running in memory TODO
    	} else { // load models first time
    		start();
    	}
    	
    	// lemmatization
    	sentence = lemmatize(sentence); 
    	
    	// returning lemmata
        return sentence;
    } 
    
	/**
	 * Was running?
	 * 
	 * @return
	 */
	public static boolean isInicialized(){
		return runs;
	}
    
    public static synchronized boolean start () {
    	String modelFile = "";

		// locating external model
		try{
			modelFile = Platform.getPreferencesService().getString("reprotool.ide", "lemmatizerModel", "/lemma-eng.model", null);
    	} catch (NullPointerException e){
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Wrong location of lemmatizer model file", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
			String rootPath = new java.io.File(Parser.class.getResource("/").getPath()).getParentFile().getParent();
			modelFile = rootPath + "/../tools/mate-tools/lemma-eng.model";
    	}   	
    	
        // location of the model - options
		try {
			optionsLemmatizer = new is2.lemmatizer.Options(new String[] {"-model", modelFile});
		} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error during loading lemmatizer model", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}
		
		// loading model
        try {
			lemmatizer = new is2.lemmatizer.Lemmatizer(optionsLemmatizer);
			runs = true;
		} catch (FileNotFoundException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Lemmatizer model not found", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error during lemmatizer model initialization", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}
        
		return runs;  
    }
    
    private static String lemmatize(String originalText) {
    	String lemmatizedText = "";       

        // create a data container for a sentence
        SentenceData09 sentenceData = new SentenceData09();
        sentenceData.init(originalText.split("\\s+"));
    	
        // lemmatize a sentence
        lemmatizer.lemmatize(optionsLemmatizer, sentenceData);

        // output the lemmata
        for (String l : sentenceData.lemmas) lemmatizedText = lemmatizedText + " " + l;
  	
    	return lemmatizedText.trim();
    }    
    
    private static Sentence lemmatize(Sentence sentence) {
    	ArrayList<String> forms = new ArrayList<String>();

        // create a data container for a sentence
    	SentenceData09 sentenceData = new SentenceData09();
		forms.add("<root>");
    	for(Word word : sentence.getWords()) forms.add(word.getText());
        sentenceData.init(forms.toArray(new String[0]));
        // lemmatize a sentence
        lemmatizer.lemmatize(optionsLemmatizer, sentenceData);
        // output the lemmata
        for (int i = 1; i < sentenceData.length(); i++) {
        	// are arrays still corresponding?
        	// beware of <root> node
        	if(sentenceData.forms[i].contentEquals(sentence.getWords().get(i - 1).getText())) {
        		// fill word lemma form
        		sentence.getWords().get(i - 1).setLemma(sentenceData.lemmas[i]);
        	} else {
    			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Lemmatizer error - words not corresponding: " + sentence.getWords().get(i).getText() + " " + sentenceData.forms[i], null);
    			StatusManager.getManager().handle(status, StatusManager.LOG);
        	}        	
        }
  	
    	return sentence;
    }     
}
