package reprotool.model.usecase.impl;

import reprotool.model.linguistic.actionpart.Text;
import reprotool.model.usecase.ParseableElement;

/**
 * Utility class containing static helper methods for model classes.
 * 
 * @author jvinarek
 *
 */
public class Utils {
	
	public static String getContent(ParseableElement parseableElement) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (Text text : parseableElement.getTextNodes()) {
			stringBuilder.append(text.getContent()); 
		}
		
		return stringBuilder.toString();
	}
	
}
