package reprotool.fm.nusmv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.core.runtime.Assert;

import reprotool.model.usecase.UseCase;

public class NuSMVProject {
	private List<NuSMVGenerator> generators;
	
	/**
	 * Global tracker of annotations in the whole project.
	 */
	private HashMap<String, List<AnnotationEntry>> globalTracker;
	
	private HashMap<UseCase, NuSMVGenerator> uc2gen = new HashMap<UseCase, NuSMVGenerator>();
	
	public NuSMVProject (List<NuSMVGenerator> generators) {
		this.generators = generators;
		globalTracker = new HashMap<String, List<AnnotationEntry>>();
		
		processAnnotations();
		for (NuSMVGenerator nusvm: generators) {
			uc2gen.put(nusvm.getUseCase(), nusvm);
		}
		
		for (NuSMVGenerator nusmv: generators) {
			int c = 0;
			for (UseCase uc: nusmv.getIncludedUseCases()) {
				c++;
				String label = Integer.toString(c);
				NuSMVGenerator g = uc2gen.get(uc);
				HashMap<String, AnnotationEntry> annotationTracker = g.getAnnotationsTracker();
				for (String tag: annotationTracker.keySet()) {
					List<AnnotationEntry> list = globalTracker.get(tag);
					if (list == null) {
						Assert.isTrue(false);
						list = new ArrayList<AnnotationEntry>();
						globalTracker.put(tag, list);
					}
					AnnotationEntry a = new AnnotationEntry(annotationTracker.get(tag));
					a.automatonID = nusmv.getUseCaseId() + ".y" + label;
					list.add(a);
				}
			}
		}
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