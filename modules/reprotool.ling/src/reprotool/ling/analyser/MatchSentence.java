package reprotool.ling.analyser;

import reprotool.ling.LingFactory;
import reprotool.ling.Sentence;
import reprotool.ling.SentenceRegion;
import reprotool.ling.Word;

/**
 * @author ofiala
 *
 */
public class MatchSentence {

	/**
	 * Matches Sentence.words to corresponding words in originalString
	 * 
	 * @param sentenceString - original string from UseCaseStep.content
	 * @param sentence - sentence object filled with words
	 * @return true on success
	 */
	public static boolean matchSentence(String sentenceString, Sentence sentence) {
		boolean result = true;
		// position of current word (not Word object) in original string
		int position = 0;
		// length of first part of last word
		int restLength = 0;		
		
		if(sentence == null || sentence.getWords() == null)
			return false;
		
		for(Word word : sentence.getWords()){
			// skip damaged words
			if(word.getText() == null) continue;
			// working string
			String rest = sentenceString.substring(position + restLength);
			// length of word in original string
			int length = 0;
			
			// skip all bad characters encoutered
			while(rest.length() > 0 && !rest.startsWith(word.getText())){
				rest = rest.substring(1);
				position++;
			}
			
			if(rest.startsWith(word.getText())){
				
				length = word.getText().length();

				word.setContentStart(position);
				word.setContentLength(restLength + length);					
				
			} else { // unknown characters / strings mismatch
				result = false;
			}

			// Sentence.word is shorter than word in original string -> tagger divided them
			if(length > (restLength + word.getText().length())) {
				// start again at same word
				restLength = restLength + word.getText().length();
				//restLength = 
			} else { // non divided words	
				position = position + length;
			}
			
		}
		
		return result;
	}
	
	/**
	 * Detects regions in originalString and store them in Sentence.regions 
	 * 
	 * @param sentenceString - original string from UseCaseStep.content
	 * @param sentence - sentence object filled with words
	 * @return true on success
	 */	
	public static boolean matchSentenceRegions(String sentenceString, Sentence sentence) {
		String[] delimiters = { "'", "\"" };
		boolean result = false;
		for(String del : delimiters){
			int count = characterCount(sentenceString,del);
			if(count > 0 && count % 2 == 0){
				int last = 0;
				int even = 1;
				// text contains regions
				for (int index = sentenceString.indexOf(del);index >= 0;index = sentenceString.indexOf(del, index + 1)){
					if(even % 2 == 0){
						SentenceRegion reg = LingFactory.eINSTANCE.createSentenceRegion();
						reg.setContentStart(last + 1);
						reg.setContentLength(index - last - 1);
						reg.setText(sentenceString.substring(reg.getContentStart(), reg.getContentStart() + reg.getContentLength()).toLowerCase());
						sentence.getRegions().add(reg);
					}
					last = index;	
					even++;
				}
				//sentenceString.subSequence(beginIndex, endIndex)
			}
		}
		
		return result;
	}
	
	/**
	 * Counts number of characters in string
	 * 
	 * @param sentenceString - original string 
	 * @param character - to find
	 * @return number of characters
	 */
	private static int characterCount(String sentenceString, String character){
		// add to end for split purpose
		String s = sentenceString + " .";
		int badOcc = 0;
		//s.lenght() - s.replaceAll("[^,]","").length();  
		int occ = s.split(character).length - 1;
		// remove possessive usage of '
		if(character == "'"){			
			badOcc = s.split("'s ").length - 1;
		}		
		return occ - badOcc;
	}
}
