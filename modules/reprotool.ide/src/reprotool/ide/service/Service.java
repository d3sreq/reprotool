package reprotool.ide.service;

import reprotool.model.specification.IActor;
import reprotool.model.specification.ISoftwareProject;
import reprotool.model.specification.ISpecificationFactory;
import reprotool.model.specification.IUseCase;
import reprotool.model.specification.impl.SpecificationFactory;

/**
 * Service layer class for interaction between model and view.
 * TODO - jvinarek - proof of concept.
 * 
 * @author jvinarek
 *
 */
public enum Service {
	INSTANCE;

	private ISpecificationFactory factory = new SpecificationFactory();
	
	public ISoftwareProject getProject() {
		ISoftwareProject project = factory.createSoftwareProject();
		
		project.setDescription("Simple project describing bank processes.");
		project.setName("Bank");
		
		// actors
		// bank - compound actor
		IActor clerk = factory.createActor();
		clerk.setName("Clerk");
		
		IActor owner = factory.createActor();
		owner.setName("Owner");
		
		IActor bank = factory.createActor();
		bank.setName("Bank");
		bank.getChildrenActors().add(clerk);
		bank.getChildrenActors().add(owner);
		project.getActors().add(bank);
		
		// non-compound actor
		IActor customer = factory.createActor();
		customer.setName("Customer");
		project.getActors().add(customer);
		
		// TODO - use case steps
		IUseCase useCase1 = factory.createUseCase();
		useCase1.setName("Use case with owner as PA");
		useCase1.setPrimaryActor(owner);
		project.getUseCases().add(useCase1);
		
		IUseCase useCase2 = factory.createUseCase();
		useCase2.setName("Use case with clerk as PA");
		useCase2.setPrimaryActor(clerk);
		project.getUseCases().add(useCase2);
		
		return project;
	}
	
}