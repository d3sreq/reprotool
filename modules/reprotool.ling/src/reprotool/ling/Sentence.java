package reprotool.ling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sentence {
	public List<Word> words = new ArrayList<Word>();

	/**
	 * Parse sentence string from PennTreeBank syntax
	 *
	 * @return void
	 */		
	public Sentence(String originalSentence) {
    	if (!originalSentence.isEmpty()){
	    	for (String word : originalSentence.split("\\s+")) {
	    	    this.words.add(new Word(word));
	    	}
    	}
	}	
	
	
	/**
	 * Parse whole sentence to Sentence object
	 *
	 * @return Boolean success 
	 */	
    public Boolean parse(String originalSentence) {
    	if (!originalSentence.isEmpty()){
	    	for (String word : originalSentence.split(" ")) {
	    	    words.add(new Word(word));
	    	}
	    	return true;
    	}
    	return false;
    }
	

    public String toString(){
    	String sentence = "";
    	for (Word word : words) {
    		//JOptionPane.showMessageDialog(null, word.text,"Text Message",0);
    		sentence += word.text + " ";
    	}
    	return sentence;
    }

	/**
	 * Returns negation of a given text
	 *
	 * @return String negation 
	 */	
    public Sentence getNegation() {
    	Sentence negation = this;
    	int count_not = 0;
    	int count_no = 0;
    	//int count_vv = 0;
    	int has_neg = 0;
    	       
    	// preprocessing
        for (Iterator<Word> iword = negation.words.iterator(); iword.hasNext();) {
        	Word word = iword.next();
    		if(word.text.equals("n't")){        	
    			count_not++;
    		}
    		if(word.text.equals("no")){        	
    			count_no++;
    		}
    		if(word.negation.isEmpty()){        	
    			has_neg++;
    		}
        	//JOptionPane.showMessageDialog(null, word.text,"Text Message",0);
        }
        if((count_not + count_no) > 0){
        	// removing
            for (Iterator<Word> iword = negation.words.iterator(); iword.hasNext();) {
            	Word word = iword.next();
        		if(word.text.equals("n't")||word.text.equals("no")){   
        			iword.remove();
        		}
            }       	
        } else if (has_neg > 0){
        	Iterator<Word> iword = negation.words.iterator();
        	Boolean goon = true;
        	while(iword.hasNext() && goon){
        		Word word = iword.next();
        		
        		if(!word.negation.isEmpty()){ 
        			word.negate();
        			goon = false;
        		}       		
        	}
        }
    	return negation;
    }
    
    
    
}
