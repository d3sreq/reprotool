package reprotool.fm.nusmv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NuSMVProject {
	private List<NuSMVGenerator> generators;
	
	/**
	 * Global tracker of annotations in the whole project.
	 */
	private HashMap<String, List<AnnotationEntry>> globalTracker;
	
	public NuSMVProject (List<NuSMVGenerator> generators) {
		this.generators = generators;
		globalTracker = new HashMap<String, List<AnnotationEntry>>();
	}
	
	public String getHeader() {
		StringBuffer buf = new StringBuffer();
		
		buf.append("MODULE main\n\n");
		buf.append("	-- FairnessConstraint\n");
		
		for (NuSMVGenerator nusmv: generators) {
			buf.append("	FAIRNESS p=p" + nusmv.getUseCaseId() + ";\n");			
		}
		buf.append("\n");
		
		buf.append("	VAR p : {none,");
		int c = 0;
		for (NuSMVGenerator nusmv: generators) {
			buf.append("p" + nusmv.getUseCaseId());
			c++;
			if (c < generators.size()) {
				buf.append(",");
			}
		}
		buf.append("};\n");
		
		buf.append("	INIT p in none;\n");
		buf.append("	ASSIGN next(p) := case\n");
		buf.append("		p=none : {");
		
		c = 0;
		for (NuSMVGenerator nusmv: generators) {
			buf.append("p" + nusmv.getUseCaseId());
			c++;
			if (c < generators.size()) {
				buf.append(",");
			}
		}
		buf.append("};\n");
		
		buf.append("		TRUE : none;\n");
		buf.append("	esac;\n\n");
		
		return buf.toString();
	}
	
	public String getAutomata() {
		StringBuffer buf = new StringBuffer();
		
		int c = 0;
		for (NuSMVGenerator nusmv: generators) {
			c++;
			buf.append(nusmv.getAutomaton());
			if (c < generators.size()) {
				buf.append("\n\n");
			}
		}

		return buf.toString();
	}
	
	public String getProcesses() {
		StringBuffer buf = new StringBuffer();
		
		for (NuSMVGenerator nusmv: generators) {
			buf.append(nusmv.getProcess() + "\n\n");
		}

		return buf.toString();
	}
	
	public String getAnnotations() {
		processAnnotations();
		
		StringBuffer buf = new StringBuffer();
		
		for (String tag: globalTracker.keySet()) {
			buf.append("	VAR " + tag + " : boolean;\n");
			buf.append("	INIT " + tag + " in FALSE;\n");
			buf.append("	ASSIGN next(" + tag + ") := FALSE\n");
			
			for (AnnotationEntry aEntry: globalTracker.get(tag)) {
				buf.append("		| x" + aEntry.automatonID + ".s in {" );
				int c = 0;
				for (String state: aEntry.states) {
					if (c > 0) {
						buf.append(",");
					}
					c++;
					buf.append(state);
				}
				buf.append("}\n");
			}
			buf.append("		;\n\n");
		}
		
		return buf.toString();
	}
	
	private void processAnnotations() {
		for (NuSMVGenerator nusmv: generators) {
			HashMap<String, AnnotationEntry> localTracker = nusmv.getAnnotationsTracker();
			if (localTracker == null) {
				continue;
			}
			for (String tag: localTracker.keySet()) {
				List<AnnotationEntry> list = globalTracker.get(tag);
				if (list == null) {
					list = new ArrayList<AnnotationEntry>();
					globalTracker.put(tag, list);
				}
				list.add(localTracker.get(tag));
			}
		}
	}
}