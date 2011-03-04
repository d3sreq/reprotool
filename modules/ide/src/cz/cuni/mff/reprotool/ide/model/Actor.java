package cz.cuni.mff.reprotool.ide.model;

/**
 * TODO jvinarek - proof of concept, model classes should be in separate EMF project.  
 * 
 * @author jvinarek
 *
 */
public class Actor {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Actor(String name) {
		this.name = name;
	}
}
