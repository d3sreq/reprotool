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
	 * Is this word a noun?
	 *
	 * @return Boolean result
	 */	
	@Override
	public boolean isNoun()
	{
		POSType pos = this.getPOS();
		// determiner excluded
		if (pos.getLiteral().startsWith("NN")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * Is this word a verb?
	 * including modal verbs
	 * 
	 * @return Boolean result
	 */	
	@Override
	public boolean isVerb()
	{
		POSType pos = this.getPOS();
		// include MD - modal
		if (pos.getLiteral().startsWith("VB") || pos == POSType.MODAL) {
			return true;
		} else {
			return false;
		}
		
	}
}
