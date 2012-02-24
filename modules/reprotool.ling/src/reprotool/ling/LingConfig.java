package reprotool.ling;

import java.util.ArrayList;

import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SwprojFactory;

/**
 * Class holding all linguistic analyse configuration
 * 
 * Special actions verb lists: 
 * continueVerbs - list of all default verbs for CONTINUE action
 * abortVerbs - list of all default verbs for ABORT action
 * 
 * Default actors 
 * actors - list
 *  
 * @author ofiala
 * 
 */
public class LingConfig {
	
	// special actions verb lists
	// GOTO ACTION
	public static ArrayList<String> gotoVerbs = defaultGotoVerbs();
	// ABORT ACTION
	public static ArrayList<String> abortVerbs = defaultAbortVerbs();
	
	// default actors
	public static ArrayList<Actor> actors = defaultActors();
	
	// must be aSubject in actors list?
	public static final boolean isSubjectActor = true;
	
	/**
	 * Static method for setting Goto action verbs
	 * "continue", "repeat", "resume", "retry"
	 *  
	 * @return filled list
	 */
	private static ArrayList<String> defaultGotoVerbs() {
		ArrayList<String> result = new ArrayList<String>();
		// continue verbs
		result.add("continue");
		result.add("goto");
		result.add("repeat");
		result.add("resume");
		result.add("retry");
		result.add("include");
		return result;
	}
	
	/**
	 * Static method for setting Abort action verbs
	 * "abort", "terminate", "end"
	 *  
	 * @return filled list
	 */
	private static ArrayList<String> defaultAbortVerbs() {
		ArrayList<String> result = new ArrayList<String>();
		// abort verbs
		result.add("abort");
		result.add("terminate");		
		result.add("end");
		return result;
	}
	
	/**
	 * Static method for filling predefined basic actors
	 * "system", "user"
	 *  
	 * @return filled list
	 */
	private static ArrayList<Actor> defaultActors() {
	
		ArrayList<Actor> result = new ArrayList<Actor>();
		// default actors
		Actor ac = SwprojFactory.eINSTANCE.createActor();
		ac.setName("system");
		result.add(ac);
		ac = SwprojFactory.eINSTANCE.createActor();
		ac.setName("user");
		result.add(ac);
		return result;
	}
}
