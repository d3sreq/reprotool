package reprotool.ling.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osgi.framework.Bundle;

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
		if (originalText.isEmpty()) {
			return lemmatizedText;
		}

		if (runs) { // get response from tool
			// is still running in memory 
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
		if (sentence == null || sentence.getWords().isEmpty()) {
			return sentence;
		}

		if (runs) { // get response from tool
			// is still running in memory 
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
	public static boolean isInicialized() {
		return runs;
	}

	public static synchronized boolean start() {
		String modelFile = "";

		// locating external model
		Bundle bundle = Platform.getBundle("reprotool.tools.anna");
		// bundle not found - package damaged
		if(bundle == null) {
			System.err.println("Bundle \"reprotool.tools.anna\" not found!");
			return false;
		}
		URL fileURL = bundle.getEntry("data/lemma-eng.model");
		try {
			File file = new File(FileLocator.resolve(fileURL).toURI());
			modelFile = file.toString();
		} catch (Exception e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error during locating lemmatizer model", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}

		// location of the model - options
		try {
			System.out.println("Initialising lemmatiser");
			optionsLemmatizer = new is2.lemmatizer.Options(new String[] { "-model", modelFile });
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
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"Error during lemmatizer model initialization", e);
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
		for (String l : sentenceData.lemmas)
			lemmatizedText = lemmatizedText + " " + l;

		return lemmatizedText.trim();
	}

	private static Sentence lemmatize(Sentence sentence) {
		ArrayList<String> forms = new ArrayList<String>();

		// create a data container for a sentence
		SentenceData09 sentenceData = new SentenceData09();
		forms.add("<root>");
		for (Word word : sentence.getWords()) {
			// remove all null words (errors)
			if (word.getText() != null)
				forms.add(word.getText());
		}

		sentenceData.init(forms.toArray(new String[0]));
		// lemmatize a sentence
		lemmatizer.lemmatize(optionsLemmatizer, sentenceData);
		// in case of null words in sentence object
		int delay = 0;
		// output the lemmata
		for (int i = 1; i < sentenceData.length(); i++) {
			// skip null words in sentence
			while ((i - 1 + delay) < sentence.getWords().size()
					&& sentence.getWords().get(i - 1 + delay).getText() == null)
				delay++;
			// are arrays still corresponding?
			// beware of <root> node
			if (sentence.getWords().get(i - 1 + delay).getText() != null
					&& sentenceData.forms[i].contentEquals(sentence.getWords().get(i - 1 + delay).getText())) {
				// fill word lemma form
				sentence.getWords().get(i - 1 + delay).setLemma(sentenceData.lemmas[i]);
			} else {
				// C++ rulez
				//delay++;
				IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"Lemmatizer error - words not corresponding: " + sentence.getWords().get(i).getText() + " "
								+ sentenceData.forms[i], null);
				StatusManager.getManager().handle(status, StatusManager.LOG);
			}
		}

		return sentence;
	}
}
