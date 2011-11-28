package reprotool.ling.benchmark;

import reprotool.ling.LingTools;
import reprotool.ling.Sentence;
import reprotool.ling.benchmark.AnalyseBenchmark.ActionCode;
import reprotool.ling.impl.SentenceImpl;

/**
 * @author ofiala
 * 
 */
public class BenchmarkSentence extends SentenceImpl {

	String id = "";
	String sentence = "";
	int subjectNumber = 0;
	String verbLemma = "";
	int objectNumber = 0;
	int indirectObjectNumber = 0;
	ActionCode actionCode = ActionCode.X;

	public BenchmarkSentence(String line) {
		// parse csv line
		String[] fields = line.split(";");
		// minimum arguments we need
		if (fields.length >= 4) {

			id = fields[0];
			sentence = fields[1];
			subjectNumber = Integer.parseInt(fields[2]);
			verbLemma = fields[3];
			// we have more
			if (fields.length >= 5) {
				objectNumber = Integer.parseInt(fields[4]);
				if (fields.length >= 6) {
					indirectObjectNumber = Integer.parseInt(fields[5]);
					if (fields.length == 7)
						actionCode = ActionCode.valueOf(fields[6]);
				}
			}
	
		}
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
				+ subjectNumber + " VERB: " + verbLemma + " OBJECT: "
				+ objectNumber + " INDIRECT_OBJECT: " + indirectObjectNumber
				+ " ACTION: " + actionCode;
		return result;
	}
}
