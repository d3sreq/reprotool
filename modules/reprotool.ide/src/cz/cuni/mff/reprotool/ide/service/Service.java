package cz.cuni.mff.reprotool.ide.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;

import cz.cuni.mff.reprotool.model.project.Actor;
import cz.cuni.mff.reprotool.model.project.ProjectFactory;
import cz.cuni.mff.reprotool.model.project.impl.ProjectFactoryImpl;

/**
 * Service layer class for interaction between model and view.
 * TODO - jvinarek - proof of concept.
 * 
 * @author jvinarek
 *
 */
public enum Service {
	INSTANCE;

	private ProjectFactory factory = new ProjectFactoryImpl();
	private WritableList actors;
	
	private void init() {
		List<Actor> actorsList = new ArrayList<Actor>();
		
		Actor clerk = factory.createActor();
		clerk.setName("Clerk");
		actorsList.add(clerk);
		
		Actor customer = factory.createActor();
		customer.setName("Customer");
		actorsList.add(customer);
		
		actors = new WritableList(actorsList, Actor.class);
	}
	
	public WritableList getActors() {
		if (actors == null) {
			init();
		}
		return actors;
	}
	
}
