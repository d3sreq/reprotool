package reprotool.ling.benchmark;

import reprotool.ling.LingTools;
import reprotool.ling.Sentence;
import reprotool.ling.Word;
import reprotool.ling.analyser.Analyser;
import reprotool.ling.analyser.FindConstituent;
import reprotool.ling.benchmark.AnalyseBenchmark.ActionCode;
import reprotool.ling.impl.SentenceImpl;

/**
 * @author ofiala
 * 
 */
public class BenchmarkSentence extends SentenceImpl {
	// basic parameters
	private String id = "";
	private String sentence = "";
	
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
		if (fields.length >= 4) {

			id = fields[0];
			sentence = fields[1];
			inResults.subjectNumber = Integer.parseInt(fields[2]);
			inResults.verbLemma = fields[3];
			// we have more
			if (fields.length >= 5) {
				inResults.objectNumber = Integer.parseInt(fields[4]);
				if (fields.length >= 6) {
					inResults.indirectObjectNumber = Integer.parseInt(fields[5]);
					if (fields.length == 7)
						inResults.actionCode = ActionCode.valueOf(fields[6]);
				}
			}
	
		}
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
		// sucess
		boolean result = false;
		// yet not parsed
		if (this.getSentenceTree() == null)
			return false;
		// find subject
		Word word = FindConstituent.findSubject(this);
		int i = this.getWords().indexOf(word);
		if(i >= 0) {
			result = true;
			// data words counting from 1
			this.outResults.objectNumber = i + 1;
		}
		// TODO constituents
		return result;
	}
}
