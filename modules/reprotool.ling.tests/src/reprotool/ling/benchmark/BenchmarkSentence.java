package reprotool.ling.benchmark;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import reprotool.ling.LingConfig;
import reprotool.ling.LingTools;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceNode;
import reprotool.ling.Word;
import reprotool.ling.analyser.FindConstituent;
import reprotool.ling.benchmark.AnalyseBenchmark.ActionCode;
import reprotool.ling.impl.SentenceImpl;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SwprojFactory;

/**
 * @author ofiala
 * 
 */
public class BenchmarkSentence extends SentenceImpl {
	// basic parameters
	private String id = "";
	private String sentence = "";
	private EList<Actor> actors = new BasicEList<Actor>(LingConfig.actors);
	
	// same object for given and analysed results
	class BenchmarkResults {
		public int subjectNumber = 0;
		public String verbLemma = "";
		public int objectNumber = 0;
		public int indirectObjectNumber = 0;
		public ActionCode actionCode = ActionCode.X;
	}
	// results and stats
	BenchmarkResults inResults = new BenchmarkResults();
	BenchmarkResults outResults = new BenchmarkResults();
	
	// is it parsed?
	private boolean parsed = false;
	// is it analysed?
	private boolean analysed = false;
	
	public BenchmarkSentence(String line) {
		// parse csv line
		String[] fields = line.split(";");
		// minimum arguments we need
		if (fields.length >= 5) {

			id = fields[0];
			sentence = fields[1];
			// add all new actors
			for(String acstr : fields[2].split(",")) {
				Actor ac = SwprojFactory.eINSTANCE.createActor();
				ac.setName(acstr);
				actors.add(ac);
			}
			inResults.subjectNumber = Integer.parseInt(fields[3]);
			inResults.verbLemma = fields[4];
			// we have more
			if (fields.length >= 6) {
				try {
					inResults.objectNumber = Integer.parseInt(fields[5]);
				} catch (NumberFormatException e) {
					inResults.objectNumber = 0;
				}
				if (fields.length >= 7) {
					try {
						inResults.indirectObjectNumber = Integer.parseInt(fields[6]);
					} catch (NumberFormatException e) {
						inResults.indirectObjectNumber = 0;
					}
					if (fields.length == 8)
						try {
							inResults.actionCode = ActionCode.valueOf(fields[7]);
						} catch (IllegalArgumentException e) {
							inResults.actionCode = ActionCode.X;
						}
				}
			}
	
		}
	}

	/**
	 * Get ID string of current sentence
	 * 
	 * @return id string
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Was this sentence analysed?
	 * 
	 * @return analysed
	 */
	public boolean isAnalysed(){
		return analysed;
	}
	
	/**
	 * Was this sentence parsed?
	 * 
	 * @return parsed
	 */
	public boolean isParsed(){
		return parsed;
	}
	
	/**
	 * Parse and fill parent Sentence object
	 * 
	 * @return boolean parsing success
	 */
	public boolean parse() {
		// parent object
		Sentence sentenceObject = LingTools.parseSentence(sentence);
		
		if (sentenceObject == null) {
			return false;
		} else {
			// move created structures
			words = sentenceObject.getWords();
			sentenceTree = sentenceObject.getSentenceTree();
			passive = sentenceObject.isPassive();
			// set stat variable
			parsed = true;
			return true;
		}
	}
	
	/**
	 * Convert sentence object to string
	 * 
	 * @return String all sentence variables
	 */
	public String toString() {
		// result
		String result = "ID: " + id + " SENTENCE: " + sentence + " SUBJECT: "
				+ inResults.subjectNumber + " VERB: " + inResults.verbLemma + " OBJECT: "
				+ inResults.objectNumber + " INDIRECT_OBJECT: " + inResults.indirectObjectNumber
				+ " ACTION: " + inResults.actionCode;
		return result;
	}

	/**
	 * Analyse Sentence object
	 * 
	 * @return boolean analyse success
	 */
	public boolean analyse() {
		// success - just in case of crash
		boolean result = true;
		// yet not parsed
		if (this.getSentenceTree() == null)
			return false;
		// find subjects
		Word word = FindConstituent.findSubject(this);
		if (word != null) {
			int i = this.getWords().indexOf(word);
			if (i >= 0) {
				// data words counting from 1
				this.outResults.subjectNumber = i + 1;
			}
		}
		// find verbs
		word = FindConstituent.findMainVerb(this);
		if (word != null) {
			int i = this.getWords().indexOf(word);
			if (i >= 0) {
				// ignore case just for wrong data input
				this.outResults.verbLemma = word.getLemma();
			}
		}
		// find objects
		// find indirect object
		ArrayList<Word> words = FindConstituent.findIndirectObject(this, actors);
		// mark indirect object
		if (words.size() > 0) {
			// first object
			word = words.get(0);
			int i = this.getWords().indexOf(word);
			if (i >= 0) {
				// ignore case just for wrong data input
				this.outResults.indirectObjectNumber = i + 1;
			}
			// find representative objects
			words = FindConstituent.findRepresentativeObject(this, (SentenceNode)words.get(0).getParent());
		} else {
			words = FindConstituent.findRepresentativeObject(this, null);
		}
		// add representative objects
		if (words.size() > 0) {
			// first object
			word = words.get(0);
			int i = this.getWords().indexOf(word);
			if (i >= 0) {
				// ignore case just for wrong data input
				this.outResults.objectNumber = i + 1;
			}
		}

		return result;
	}
}