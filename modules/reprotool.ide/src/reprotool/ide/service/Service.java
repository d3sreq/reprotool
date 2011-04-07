package reprotool.ide.service;

import org.eclipse.swt.widgets.Shell;

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
		bank.getChildrenActors().add(clerk);
		bank.getChildrenActors().add(owner);
		project.getActors().add(bank);
		
		// non-compound actor
		Actor customer = factory.createActor();
		customer.setName("Customer");
		project.getActors().add(customer);
		
		// TODO - use case steps
		UseCase useCase1 = factory.createUseCase();
		useCase1.setName("Use case with owner as PA");
		useCase1.setPrimaryActor(owner);
		UseCaseStep uc1step1 = factory.createUseCaseStep();
		uc1step1.setDesc("first step");
		UseCaseStep uc1step2 = factory.createUseCaseStep();
		uc1step2.setDesc("second step");
		useCase1.getUseCaseSteps().add(uc1step1);
		useCase1.getUseCaseSteps().add(uc1step2);
		project.getRequirements().add(useCase1);
		
		UseCase useCase2 = factory.createUseCase();
		useCase2.setName("Use case with clerk as PA");
		useCase2.setPrimaryActor(clerk);
		project.getRequirements().add(useCase2);
	}

	public Actor createActor() {
		return factory.createActor();
	}
	
}