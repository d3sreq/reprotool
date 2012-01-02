package reprotool.ling.benchmark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;

import reprotool.ling.Activator;
import reprotool.ling.tools.Parser;

/**
 * @author ofiala
 * 
 */
public class AnalyseBenchmark {
	// default file name
	String fileName = "data.csv";
	// loaded sentences
	ArrayList<BenchmarkSentence> sentences = new ArrayList<BenchmarkSentence>();
	
	public enum ActionCode {
		GOTO,
		ABORT,
		INTERNAL,
		FROM,
		TO,
		INCLUDE,
		X;
	}


	/**
	 * Analyse selected loaded sentence
	 * 
	 * @return boolean success at sentence
	 */
	public boolean analyse (int i) {
		return sentences.get(i).analyse();
	}
	
	/**
	 * Analyse all loaded sentences
	 * 
	 * @return boolean success at all sentences
	 */
	public boolean analyseAll() {
		// result
		boolean result = true;
		for (BenchmarkSentence bs : sentences) {
			result = result && bs.analyse();
		}
		return result;
	}
	
	public String getResults () {
		// result
		String result;
		// errors
		String error = "";
		// subjects stats
		DecimalFormat formatter = new DecimalFormat(".00");
		int subjects = 0;
		float foundSubjects = 0;
		for (BenchmarkSentence bs : sentences) {
			subjects++;
			if (bs.outResults.subjectNumber == bs.inResults.subjectNumber)
				foundSubjects++;
			else
				error += bs.getId() + ": input subjectNumber: "
						+ bs.inResults.subjectNumber
						+ " output subjectNumber: "
						+ bs.outResults.subjectNumber + "\n";
		}
		result = "SUBJECTS: " + "Count: " + subjects + " Found: "
				+ (int)foundSubjects + " | "
				+ formatter.format((foundSubjects * 100) / subjects) + "%\n";
		result += error;

		// verbs stats
		int verbs = 0;
		float foundVerbs = 0;
		error = "";
		for (BenchmarkSentence bs : sentences) {
			verbs++;
			if (bs.inResults.verbLemma
					.equalsIgnoreCase(bs.outResults.verbLemma))
				foundVerbs++;
			else
				error += bs.getId() + ": input verbLemma: \""
						+ bs.inResults.verbLemma + "\" output verbLemma: \""
						+ bs.outResults.verbLemma + "\"\n";
		}		
		result += "VERBS: " + "Count: " + verbs + " Found: " + (int)foundVerbs
				+ " | " + formatter.format((foundVerbs * 100) / verbs) + "%\n";
		result += error;

		//indirects objects stats
		int iobjects = 0;
		float ifoundObjects = 0;
		error = "";
		for (BenchmarkSentence bs : sentences) {
			iobjects++;
			if (bs.outResults.indirectObjectNumber == bs.inResults.indirectObjectNumber)
				ifoundObjects++;
			else
				error += bs.getId() + ": input indirectObjectNumber: "
						+ bs.inResults.indirectObjectNumber
						+ " output indirectObjectNumber: "
						+ bs.outResults.indirectObjectNumber + "\n";
		}	
		result += "INDIRECT_OBJECTS: " + "Count: " + iobjects + " Found: " + (int)ifoundObjects + " | " + formatter.format((ifoundObjects * 100)/iobjects) + "%\n";
		result += error;
		
		// objects stats
		int objects = 0;
		float foundObjects = 0;
		error = "";
		for (BenchmarkSentence bs : sentences) {
			objects++;
			if (Arrays.equals(bs.outResults.objectNumbers,bs.inResults.objectNumbers))
				foundObjects++;
			else {
				// string operations for better output
				String inOb = "";
				for (int a : bs.inResults.objectNumbers){
					inOb = inOb + a + ",";
				}
				if (inOb.endsWith(",")) inOb = inOb.substring(0, inOb.length()-1);
				String outOb = "";
				for (int a : bs.outResults.objectNumbers){
					outOb = outOb + a + ",";
				}
				if (outOb.endsWith(",")) outOb = outOb.substring(0, outOb.length()-1);
				error += bs.getId() + ": input objectNumbers: "
						+ inOb + " output objectNumbers: "
						+ outOb + "\n";
			}
		}	
		result += "OBJECTS: " + "Count: " + objects + " Found: " + (int)foundObjects + " | " + formatter.format((foundObjects * 100)/objects) + "%\n";
		result += error;
		
		//indirects objects stats
		int actions = 0;
		float foundActions = 0;
		error = "";
		for (BenchmarkSentence bs : sentences) {
			actions++;
			if (bs.outResults.actionCode == bs.inResults.actionCode)
				foundActions++;
		}
		result += "ACTIONS: " + "Count: " + actions + " Found: " + (int)foundActions + " | " + formatter.format((foundActions * 100)/actions) + "%\n";
		//result += error;
		
		// sum
		int count = subjects + verbs + iobjects + objects;
		float found = foundSubjects + foundVerbs + ifoundObjects + foundObjects; 
		result += "TOTAL: " + "Count: " + count + " Found: " + (int)found + " | " + formatter.format((found * 100)/count) + "%\n";
	
		return result;
	}
	
	/**
	 * Number of loaded sentences
	 * 
	 * @return int number of loaded sentences
	 */
	public int getSentenceCount() {
		return sentences.size();
	}
	
	public boolean loadData () {
		return loadData("");
	}	
	
	public boolean loadData (String path) {
		// success
		boolean result = false;
		
		// input
		if (path.isEmpty()) {
			String rootPath;
			try {
				rootPath = new java.io.File(Parser.class.getResource("/").toURI()).getParentFile().getParent();
			} catch (URISyntaxException e) {
				rootPath = new java.io.File(Parser.class.getResource("/").getPath()).getParentFile().getParent();
			}
			path = rootPath + "/../tools/benchmark/" + fileName;
		} else if (!path.contains("/")) {
			fileName = path;
			String rootPath;
			try {
				rootPath = new java.io.File(Parser.class.getResource("/").toURI()).getParentFile().getParent();
			} catch (URISyntaxException e) {
				rootPath = new java.io.File(Parser.class.getResource("/").getPath()).getParentFile().getParent();
			}
			path = rootPath + "/../tools/benchmark/" + fileName;			
		}
		
		File dataFile = new File(path);
		try {
			InputStream in = new FileInputStream(dataFile);
			String line;
			// buffering
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			boolean body = false;
			while ((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
					if(body) {
						BenchmarkSentence bs = new BenchmarkSentence(line);
						sentences.add(bs);
					} else {
						// skip heading of table
						body = true;
					}
				}

			}
			br.close();

		} catch (FileNotFoundException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Benchmark data file not found", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Benchmark data file I/O error", e);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}
		
		return result;
	}

	/**
	 * Parse all loaded sentences
	 * 
	 * @return boolean success at all sentences
	 */
	public boolean parseAll() {
		// result
		boolean result = true;
		for (BenchmarkSentence bs : sentences) {
			result = result && bs.parse();
		}
		return result;
	}

	/**
	 * Parse selected loaded sentence
	 * 
	 * @return boolean success at sentence
	 */
	public boolean parse(int i) {
		return sentences.get(i).parse();
	}
	
}
