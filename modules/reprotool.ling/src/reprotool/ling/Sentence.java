package reprotool.ling;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sentence {
	public List<WordLing> words = new ArrayList<WordLing>();

	/**
	 * Parse sentence string from PennTreeBank syntax
	 *
	 * @return void
	 */		
	public Sentence(String originalSentence) {
    	if (!originalSentence.isEmpty()){
	    	for (String word : originalSentence.split("\\s+")) {
	    	    this.words.add(new WordLing(word));
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
	    	    words.add(new WordLing(word));
	    	}
	    	return true;
    	}
    	return false;
    }
	

    public String toString(){
    	String sentence = "";
    	for (WordLing word : words) {
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
        for (Iterator<WordLing> iword = negation.words.iterator(); iword.hasNext();) {
        	WordLing word = iword.next();
    		if(word.text.equals("n't")||word.text.equals("not")){        	
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
            for (Iterator<WordLing> iword = negation.words.iterator(); iword.hasNext();) {
            	WordLing word = iword.next();
        		if(word.text.equals("n't")||word.text.equals("not")||word.text.equals("no")){   
        			iword.remove();
        		}
            }       	
        } else {
        	// positive sentence -> creating negative
        	Iterator<WordLing> iword = negation.words.iterator();
        	Boolean goon = true;
        	int i = 0;
        	for(i = 0; (goon && i<negation.words.size()); i++){
        		if(negation.words.get(i).POS.contains("VBP")){ 
        			goon = false;
        		}       		
        	}       	
        	if(!goon){
        		negation.words.add(i, new WordLing("not_RB"));
        	} else {
        		// last - logic negation (antonyms)
	        	if (has_neg > 0){
		        	iword = negation.words.iterator();
		        	goon = true;
		        	while(iword.hasNext() && goon){
		        		WordLing word = iword.next();
		        		
		        		if(!word.negation.isEmpty()){ 
		        			word.negate();
		        			goon = false;
		        		}       		
		        	}
	        	}
        	}
        }
    	return negation;
    }
    
    
    
}
