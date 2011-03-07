package cz.cuni.mff.reprotool.ide.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;

import reprotool.model.re.Actor;
import reprotool.model.re.ReFactory;
import reprotool.model.re.impl.ReFactoryImpl;

/**
 * Service layer class for interaction between model and view.
 * TODO - jvinarek - proof of concept.
 * 
 * @author jvinarek
 *
 */
public enum Service {
	INSTANCE;

	private ReFactory factory = new ReFactoryImpl();
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