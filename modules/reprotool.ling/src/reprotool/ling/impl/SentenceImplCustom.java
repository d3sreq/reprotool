package reprotool.ling.impl;

import reprotool.ling.Word;

/**
 * @author ofiala
 *
 */
public class SentenceImplCustom extends SentenceImpl {
	
	/* (non-Javadoc)
	 * @see reprotool.ling.impl.SentenceImpl#parseString(java.lang.String)
	 */
	/*
	/**
	 * Parse sentence string from PennTreeBank syntax to Sentence object
	 *
	 * @return Boolean success 
	 */	
	/*
	@Override
	public boolean parseString(String sentenceString) {
    	if (!sentenceString.isEmpty()){
	    	for (String word : sentenceString.split("\\s+")) {
	    		Word wordObj =LingFactory.eINSTANCE.createWord();
	    		wordObj.parseString(word);
	    	    words.add(wordObj);
	    	}
	    	return true;
    	}
    	return false;
	}	*/
	
	/**
	 * Recreates sentence string.
	 *
	 * @return String string representation of sentence 
	 */	
	@Override
    public String toString(){
    	String sentence = "";
    	for (Word word : words) {
    		sentence += word.getText() + " ";
    	}
    	return sentence;
    }
	
	/**
	 * Remove changes made by tokenizer. 
	 *
	 * @return void
	 */	
	@Override
    public void beforeTokenizer(){
    	for (Word word : words) {
    		if(word.getText() == null)
    			continue;
    		if(word.getText().equals(""))
    			continue;
    		if(word.getText().toUpperCase().trim().equals("-LRB-"))
    			word.setText("(");
    		if(word.getText().toUpperCase().trim().equals("-RRB-"))
    			word.setText(")");
    	}
    }	
	
	/**
	 * Returns negation of a given text
	 *
	 * @return String negation 
	 */	
/*    public Sentence getNegation() {
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
	*/
}
