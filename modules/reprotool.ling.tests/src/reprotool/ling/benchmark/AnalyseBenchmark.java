package reprotool.ling.benchmark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

	public boolean loadData () {
		return loadData("");
	}	
	
	public boolean loadData (String path) {
		// success
		boolean result = false;
		
		// input
		if (path.isEmpty()) {
				String rootPath = new java.io.File(Parser.class.getResource("/").getPath()).getParentFile().getParent();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
}
