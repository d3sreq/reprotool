package reprotool.fm.nusmv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class is used for expanding CTL/LTL formulas.
 * 
 * @author rudo
 */
public class FormulaUtils {
	
	/**
	 * Helper function that returns the position of the longest string in a list.
	 * 
	 * @param list The input list
	 * @return The position of the longest string in the list
	 */
	private static int longestString(List<String> list) {
		if ((list == null) || (list.isEmpty())) {
			return -1;
		}
		
		String longest = list.get(0);
		int m = 0;
		int i = 0;
		for (String s: list) {
			if (s.length() > longest.length()) {
				longest = s;
				m = i;
			}
			i++;
		}
		
		return m;
	}
	
	/**
	 * Expand the input formula for the given variable name and the given set
	 * of annotations.
	 * 
	 * @param formula The input formula
	 * @param varName The variable name for which we are expanding.
	 * @param annotations The list of annotations to check for expanding.
	 * @return The expanded formula.
	 */
	public static String expandFormula(String formula, String varName,
			List<String> annotations,
			HashMap<String, List<AnnotationEntry>> globalTracker)
	{
		List<String> workingAnnots = new ArrayList<String>(annotations);
		List<StrEntity> result = new ArrayList<StrEntity>();
		result.add(new StrEntity(formula));
		
		while (!workingAnnots.isEmpty()) {
			int longestAnnot = longestString(workingAnnots);
			
			// Process the longest annotations first.
			String annot = workingAnnots.remove(longestAnnot);
			
			if (!globalTracker.containsKey(annot + "_" + varName)) {
				List<AnnotationEntry> dummy = new ArrayList<AnnotationEntry>();
				globalTracker.put(annot + "_" + varName, dummy);
			}
			
			StrEntity workingEntity;
			
			do {
				workingEntity = null;
				for (StrEntity entity: result) {
					if (entity.canReplace() && (entity.getString().contains(annot))) {
						workingEntity = entity;
						break;
					}
				}
				
				// We found a match
				if (workingEntity != null) {
					String str = workingEntity.getString();
					int pos = str.indexOf(annot);
					String pre = null;
					String post = null;
					if (pos > 0) {
						pre = str.substring(0, pos);
					}
					post = str.substring(pos + annot.length());
					
					StrEntity preEntity = null;
					StrEntity postEntity = null;
					
					if ((pre != null) && (!pre.isEmpty())) {
						preEntity = new StrEntity(pre);
					}
					if ((post != null) && (!post.isEmpty())) {
						postEntity = new StrEntity(post);
					}
					
					// Expand the annotation with the variable name
					StrEntity midEntity = new StrEntity(annot + "_" + varName);
					midEntity.noReplace();
					
					int i = result.indexOf(workingEntity);
					result.remove(workingEntity);
					
					result.add(i, midEntity);
					
					if (postEntity != null) {
						result.add(i + 1, postEntity);
					}
					
					if (preEntity != null) {
						result.add(i, preEntity);
					}
				}
			} while (workingEntity != null);
		}
		
		StringBuffer expandedFormula = new StringBuffer();
		for (StrEntity entity: result) {
			expandedFormula.append(entity.getString());
		}
		
		return expandedFormula.toString();
	}

}

class StrEntity {
	private boolean canReplace;
	private String str;
	
	StrEntity(String s) {
		canReplace = true;
		str = s;
	}
	
	String getString() {
		return str;
	}
	
	boolean canReplace() {
		return canReplace;
	}
	
	void noReplace() {
		canReplace = false;
	}
}