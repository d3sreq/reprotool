package reprotool.ling.impl;

import java.util.regex.Pattern;

import reprotool.ling.POSType;

/**
 * @author ofiala
 *
 */
public class WordImplCustom extends WordImpl {
		
	/**
	 * Parse word string from PennTreeBank syntax
	 *
	 * @return Boolean success
	 */	
	@Override
	public boolean parseString(String wordString) {
    	String[] parts = wordString.split("_");
    	if(!parts[0].isEmpty()){
    		//this.original = wordString;
    		this.text = parts[0];  
    		this.interpunction = Pattern.matches("[,.!?]", this.text);
    		
        	if(!parts[1].isEmpty()){   
        		this.pos = POSType.get(parts[1]);
        		return true;
        	}
    	}
    	return false;
    }
	
	/**
	 * Switch text and negation
	 *
	 * @return Boolean success
	 */	
/*    public Boolean negate() {
    	if(!this.negation.isEmpty()){
			String temp = this.text;
			this.text = this.negation;
			this.negation = temp;
			return true;
    	}
    	return false;
    }
    */
}
