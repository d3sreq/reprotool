package reprotool.ling.impl;

import reprotool.ling.Word;

/**
 * @author ofiala
 *
 */
public class SentenceImplCustom extends SentenceImpl {
	
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
		if(words == null)
			return;
		
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
}
