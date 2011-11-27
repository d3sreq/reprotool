package reprotool.ling;

//import reprotool.ling.wordnet.WordNet;

/** 
 * !!!DEPRECATED
 * 
 * @author ofiala
 * 
 */
public class WordLing {
	public String original = "";
	public String text = "";
	public String POS = "";
	public Boolean interpunction = false;
	public String negation = "";
	
	public WordLing() {
		this.original = ""; 
		this.text = "";  
        this.POS = "";
        this.interpunction = false;
        this.negation = "";
	}
	
	/**
	 * Parse word string from PennTreeBank syntax
	 *
	 * @return void
	 */		
//	public WordLing(String originalWord) {
//    	String[] parts = originalWord.split("_");
//    	List<String> antonyms = new ArrayList<String>();
//    	
//    	if(!parts[0].isEmpty()){
//    		this.original = originalWord;
//    		this.text = parts[0]; 
//    		this.interpunction = Pattern.matches("[,.!?]", this.text);
//			
//        	if(!parts[1].isEmpty()){
//        		this.POS = parts[1];  
//        	}
//    		
//    		String pos = "noun";
//    		if(this.POS == "IN")
//    			//pos = "adverb";
//    			pos = "adjective";
// 
//    		antonyms = WordNet.getAntonyms(this.text, pos);
//    		if(!antonyms.isEmpty()){
//    			this.negation = antonyms.get(0);
//    		}
//    		
//
//    	}
//	}
	
	
	/**
	 * Parse word string from PennTreeBank syntax
	 *
	 * @return Boolean success
	 */	
    public Boolean parse(String originalWord) {
    	String[] parts = originalWord.split("_");
    	if(!parts[0].isEmpty()){
    		this.original = originalWord;
    		this.text = parts[0];  
        	if(!parts[1].isEmpty()){
        		this.POS = parts[1];  
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
    public Boolean negate() {
    	if(!this.negation.isEmpty()){
			String temp = this.text;
			this.text = this.negation;
			this.negation = temp;
			return true;
    	}
    	return false;
    }
    
    
}
