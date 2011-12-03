package reprotool.ling;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import com.google.common.collect.Lists;

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
	public static ArrayList<String> gotoVerbs = Lists.newArrayList("continue", "repeat", "resume", "retry");
	// ABORT ACTION
	public static ArrayList<String> abortVerbs = Lists.newArrayList("abort", "terminate", "end");
			//new ArrayList<String>();
	
	// default actors
	public static EList<Actor> actors = new BasicEList<Actor>();
	
	public LingConfig() {
		// continue verbs
		gotoVerbs.add("continue");
		gotoVerbs.add("repeat");
		gotoVerbs.add("resume");
		gotoVerbs.add("retry");
		
		// abort verbs
		abortVerbs.add("abort");
		abortVerbs.add("terminate");		
		abortVerbs.add("end");
		
		// default actors
		Actor ac = SwprojFactory.eINSTANCE.createActor();
		ac.setName("system");
		actors.add(ac);
		ac = SwprojFactory.eINSTANCE.createActor();
		ac.setName("user");
		actors.add(ac);
	}

}
