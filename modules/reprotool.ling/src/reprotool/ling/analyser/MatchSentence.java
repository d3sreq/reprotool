package reprotool.ling.analyser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import reprotool.ling.Sentence;
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
			// working strings
			String rest = sentenceString.substring(position + restLength);
			// length of word in original string
			int length = 0;
			// length of whitespaces
			int spaceLength = 0;
			
			if(rest.startsWith(word.getText())){
				// find first whitespace or punctuation after word.length				
				Matcher match = Pattern.compile("([a-zA-Z0-9\']+)").matcher(rest);
				if (match.find()) {
					length = match.group(0).length();

					word.setContentStart(position);
					word.setContentLength(restLength + length);				
				}	
				
			} else { // unknown characters / strings mismatch
				result = false;
			}

			// Sentence.word is shorter than word in original string -> tagger divided them
			if(length > (restLength + word.getText().length())) {
				// start again at same word
				restLength = restLength + word.getText().length();
				//restLength = 
			} else { // non divided words	
				restLength = 0;
				// skip whitespaces and similar
				Matcher match = Pattern.compile("([^a-zA-Z0-9\']+)").matcher(rest.substring(length));
				if (match.find()) {
					spaceLength = match.group(0).length();
					length += spaceLength; 
				}	
	
				position = position + length;
			}
			
		}
		
		return result;
	}
	
}
