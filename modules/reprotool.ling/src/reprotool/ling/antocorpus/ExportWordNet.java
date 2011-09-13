package reprotool.ling.antocorpus;

import java.util.Iterator;
import java.util.List;

import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.item.Pointer;
import reprotool.ling.wordnet.WordNet;

public class ExportWordNet {
	
	/**
	 * Exports all antonym word pairs from WordNet dictionary to AntoCorpus instance
	 * 
	 * @param path Location of WordNet dictionary
	 * @param corpus AntoCorpus instance
	 */
	public static void export(String path, AntoCorpus corpus) {
		int count = 0;
		int sum = 0;
		//String p
		
		if(!WordNet.open(path)){
			String rootPath = new java.io.File(ExportWordNet.class.getResource("/").getPath()).getParentFile().getParent();
			path = rootPath + "\\..\\tools\\WordNet-3.0\\dict";
			WordNet.open(path);
		}
		
		WordNet.open(path);
		System.err.println( "AntoCorpus export start." );
		
		count = exportPOS(corpus,POS.NOUN,"NN");
		sum += count;
		System.err.println( "Exported " + count + " nouns." );

		count = exportPOS(corpus,POS.ADJECTIVE,"JJ");
		sum += count;
		System.err.println( "Exported " + count + " adjectives." );
		
		count = exportPOS(corpus,POS.VERB,"VB");
		sum += count;
		System.err.println( "Exported " + count + " verbs." );
	    
		WordNet.close();
		
		System.err.println( "Exported " + sum + " word pairs." );
	    System.err.println( "AntoCorpus export done!" );
	}
	
	/**
	 * Export word pairs for selected POS (depends on 'pos' variable)
	 * 
	 * @param corpus Existing instance of AntoCorpus
	 * @param pos One of WordNet POS enum value
	 * @param tagPOS Penn Treebank Tag
	 * @return Number of added AntoWords
	 */
	private static int exportPOS(AntoCorpus corpus, POS pos, String tagPOS) {
		Iterator<IIndexWord> iter = WordNet.dict.getIndexWordIterator(POS.NOUN);
		IWordID curID;
		List<IWordID> antIDs;
		IWord curWord;
		int count = 0;
		
	    iter = WordNet.dict.getIndexWordIterator(pos);
	    while ( iter.hasNext() ){
	    	curID = iter.next().getWordIDs().get(0);
	    	curWord = WordNet.dict.getWord(curID);	    	    		
	    	antIDs = curWord.getRelatedWords(Pointer.ANTONYM);
	    	
	    	//if((antIDs.size() != 0)&&(antIDs.get(0) != null)){
	    	if(antIDs.size() != 0){
		    	count++;
	    		corpus.addAntoWord(curWord.getLemma(), WordNet.dict.getWord(antIDs.get(0)).getLemma(), tagPOS);
	    	}
	    }
	    return count;
	}
	
}
