package reprotool.ide.service;

import org.eclipse.emf.ecore.EObject;

import reprotool.ling.LingTools;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.swproj.impl.SwprojFactoryImpl;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecaseFactory;
import reprotool.model.usecase.impl.UsecaseFactoryImpl;

/**
 * Service layer class for interaction between model and view.
 * TODO - also implement loading data from some example XMI file that was created using the generated editor
 * 
 * @author jvinarek
 */
public enum Service {
	INSTANCE;

	private SwprojFactory swprojFactory = new SwprojFactoryImpl();
	private UsecaseFactory ucFactory = new UsecaseFactoryImpl();
	
	private SoftwareProject project;
	
	public SoftwareProject getSoftwareProject() {
		if (project == null) { 
			initProject();
		}
		
		return project;
	}
	
	private void initProject() {
		project = swprojFactory.createSoftwareProject();
		
		project.setDescription("Simple project describing bank processes.");
		project.setName("Bank");
		
		// actors
		// ================================================
		// bank - compound actor
		Actor clerk = swprojFactory.createActor();
		clerk.setName("Clerk");
		
		Actor owner = swprojFactory.createActor();
		owner.setName("Owner");
		
		Actor bank = swprojFactory.createActor();
		bank.setName("Bank");
//		bank.getChildrenActors().add(clerk);
//		bank.getChildrenActors().add(owner);
		project.getActors().add(bank);
		
		// non-compound actor
		Actor customer = swprojFactory.createActor();
		customer.setName("Customer");
		project.getActors().add(customer);
		
		/*
		 * LingTools is just a temporary stupid implementation of a sentence parsing
		 * and tree building.
		 * When the real linguistic tools are added to this project, they will be used. 
		 */
		LingTools lingTools = new LingTools();
		
		UseCase uc;
		UseCaseStep step;
		Scenario scen;
		Scenario extscen; // scenario representing an extension
		Scenario varscen; // scenario representing a variation
		
		// example use-case #1
		// ================================================
		uc = ucFactory.createUseCase();
		uc.setName("Use case with owner as PA");
		uc.setPrimaryActor(owner);
		
		scen = ucFactory.createScenario();
		uc.setMainScenario(scen);
		
		// step 1
		step = ucFactory.createUseCaseStep();
		step.setSentence("Seller submits item description");
		step.setParsedSentence(lingTools.parseSentence(step.getSentence()));
		scen.getSteps().add(step);
		
		// step 2
		step = ucFactory.createUseCaseStep();
		step.setSentence("System validates the description");
		step.setParsedSentence(lingTools.parseSentence(step.getSentence()));
		scen.getSteps().add(step);

		// extension scenario from step 2
		extscen = ucFactory.createScenario();
		step.getExtension().add(extscen);
		
		// variation scenario from step 2
		varscen = ucFactory.createScenario();
		step.getVariation().add(varscen);

		// step 2a
		step = ucFactory.createUseCaseStep();
		step.setSentence("Item not valid");
		step.setParsedSentence(lingTools.parseSentence(step.getSentence()));
		extscen.getSteps().add(step);
		
		// step 2a1
		step = ucFactory.createUseCaseStep();
		step.setSentence("Use case aborted");
		step.setParsedSentence(lingTools.parseSentence(step.getSentence()));
		extscen.getSteps().add(step);
		
		// step 2b
		step = ucFactory.createUseCaseStep();
		step.setSentence("Price assessment available");
		step.setParsedSentence(lingTools.parseSentence(step.getSentence()));
		varscen.getSteps().add(step);

		// step 2b1
		step = ucFactory.createUseCaseStep();
		step.setSentence("System provides seller with a price assessment");
		step.setParsedSentence(lingTools.parseSentence(step.getSentence()));
		varscen.getSteps().add(step);

		project.getUseCases().add(uc);

		// example use-case #2
		// ================================================
		uc = ucFactory.createUseCase();
		uc.setName("Use case with clerk as PA");
		uc.setPrimaryActor(clerk);
		project.getUseCases().add(uc);
	}

	public Actor createActor() {
		return swprojFactory.createActor();
	}

	public EObject createSoftwareProject() {
		return swprojFactory.createSoftwareProject();
	}

}