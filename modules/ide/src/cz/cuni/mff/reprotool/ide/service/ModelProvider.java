package cz.cuni.mff.reprotool.ide.service;

import java.util.ArrayList;
import java.util.List;

import cz.cuni.mff.reprotool.ide.model.Actor;

/**
 * TODO - jvinarek - proof of concept - class to provide data for view
 * 
 * @author jvinarek
 *
 */
public enum ModelProvider {
	INSTANCE;

	private List<Actor> actors;

	private ModelProvider() {
		actors = new ArrayList<Actor>();
		// Image here some fancy database access to read the persons and to
		// put them into the model
		actors.add(new Actor("Reiner"));
		actors.add(new Actor("Marie"));
		actors.add(new Actor("Holger"));
	}

	public List<Actor> getActors() {
		return actors;
	}
}
