package reprotool.fm.nusmv;

import java.util.ArrayList;
import java.util.List;

public class AnnotationEntry {
	String automatonID;
	List<String> states = new ArrayList<String>();
	
	public AnnotationEntry(AnnotationEntry a) {
		automatonID = a.automatonID;
		states = a.states;
	}
	
	public AnnotationEntry() {}
	
	public void setAutomatonID(String id) {
		automatonID = id;
	}
	
	public String getAutomatonID() {
		return automatonID;
	}
	
	public List<String> getStates() {
		return states;
	}
}
