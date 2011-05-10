package reprotool.ide.service;

import reprotool.model.specification.Actor;
import reprotool.model.specification.SoftwareProject;
import reprotool.model.specification.SpecificationFactory;
import reprotool.model.specification.UseCase;
import reprotool.model.specification.UseCaseStep;
import reprotool.model.specification.impl.SpecificationFactoryImpl;

/**
 * Service layer class for interaction between model and view.
 * TODO - jvinarek - proof of concept.
 * 
 * @author jvinarek
 *
 */
public enum Service {
	INSTANCE;

	private SpecificationFactory factory = new SpecificationFactoryImpl();
	
	private SoftwareProject project;
	
	public SoftwareProject getSoftwareProject() {
		if (project == null) { 
			initProject();
		}
		
		return project;
	}
	
	private void initProject() {
		project = factory.createSoftwareProject();
		
		project.setDescription("Simple project describing bank processes.");
		project.setName("Bank");
		
		// actors
		// bank - compound actor
		Actor clerk = factory.createActor();
		clerk.setName("Clerk");
		
		Actor owner = factory.createActor();
		owner.setName("Owner");
		
		Actor bank = factory.createActor();
		bank.setName("Bank");
//		bank.getChildrenActors().add(clerk);
//		bank.getChildrenActors().add(owner);
		project.getActors().add(bank);
		
		// non-compound actor
		Actor customer = factory.createActor();
		customer.setName("Customer");
		project.getActors().add(customer);
		
		UseCase useCase1 = factory.createUseCase();
		useCase1.setName("Use case with owner as PA");
		useCase1.setPrimaryActor(owner);
		UseCaseStep uc1step1 = factory.createUseCaseStep();
		uc1step1.setSentence("Seller submits item description");
		UseCaseStep uc1step2 = factory.createUseCaseStep();
		uc1step2.setSentence("System validates the description");
		uc1step1.setNextStep(uc1step2);
		UseCaseStep uc1step2a = factory.createUseCaseStep();
		uc1step2a.setSentence("Item not valid");
		uc1step2.getExtensions().add(uc1step2a);
		UseCaseStep uc1step2a1 = factory.createUseCaseStep();
		uc1step2a1.setSentence("Use case aborted");
		uc1step2a.setNextStep(uc1step2a1);
		UseCaseStep uc1step2b = factory.createUseCaseStep();
		uc1step2b.setSentence("Price assessment available");
		uc1step2.getVariations().add(uc1step2b);
		UseCaseStep uc1step2b1 = factory.createUseCaseStep();
		uc1step2b1.setSentence("System provides seller with a price assessment");
		uc1step2b.setNextStep(uc1step2b1);
		UseCaseStep uc1step2b1a = factory.createUseCaseStep();
		uc1step2b1a.setSentence("Some variation.");
		uc1step2b.getVariations().add(uc1step2b1a);
		UseCaseStep uc1step2b1b = factory.createUseCaseStep();
		uc1step2b1b.setSentence("Some extension.");
		uc1step2b.getExtensions().add(uc1step2b1b);
		
		useCase1.getUseCaseSteps().add(uc1step1);
		useCase1.getUseCaseSteps().add(uc1step2);
		project.getUseCases().add(useCase1);
		
		UseCase useCase2 = factory.createUseCase();
		useCase2.setName("Use case with clerk as PA");
		useCase2.setPrimaryActor(clerk);
		project.getUseCases().add(useCase2);
	}

	public Actor createActor() {
		return factory.createActor();
	}

	public SoftwareProject createSoftwareProject() {
		return factory.createSoftwareProject();
	}
	
}