package reprotool.uml.export.mapping

import org.eclipse.xtext.xbase.lib.Pair

import java.util.Map
import java.util.HashMap
import reprotool.model.swproj.SoftwareProject
import reprotool.model.usecase.UseCaseStep
import reprotool.model.usecase.Scenario
import reprotool.model.linguistic.action.UseCaseInclude

import org.eclipse.uml2.uml.Model
import org.eclipse.uml2.uml.UMLFactory
import org.eclipse.uml2.uml.Actor
import org.eclipse.uml2.uml.UseCase
import org.eclipse.uml2.uml.Association
import org.eclipse.uml2.uml.Include
import org.eclipse.uml2.uml.Property


public class UMLUCGen {
	private HashMap<reprotool.model.swproj.Actor, Actor> actorMap
	private HashMap<reprotool.model.usecase.UseCase, UseCase> useCaseMap
	UMLFactory factory
	Model model
	
	def <K,V> boolean operator_add(Map<K,V> map, Pair<K,V> pair) {
		map.put(pair.key, pair.value)
		return true
	}
	
	def private loadActors(SoftwareProject swproj) {
		swproj.actors.forEach([actor|
			val Actor a = factory.createActor();
			a.setPackage(model);
			a.setName(actor.getName());
			actorMap += actor -> a;
		]);
	}
	
	def private processUseCase(reprotool.model.usecase.UseCase u) {
		val UseCase uc = factory.createUseCase();
		useCaseMap.put(u, uc);
		uc.setName(u.getName());
		uc.setPackage(model);
		val Actor a = actorMap.get(u.getPrimaryActor());
		
		if (a == null) {
			return;
		}
		
		val Association link = factory.createAssociation();
		
		val Property p1 = factory.createProperty();
		p1.setName("src");
		p1.setType(a);
		link.getNavigableOwnedEnds().add(p1);
		
		val Property p2 = factory.createProperty();
		p2.setName("dst");
		p2.setType(uc);
		link.getNavigableOwnedEnds().add(p2);
		
		link.setPackage(model);		
	}

	def private processUseCaseStep(UseCaseStep step, UseCase srcUseCase) {
		if (step.getAction() instanceof UseCaseInclude) {
			val UseCaseInclude include = step.getAction() as UseCaseInclude;
			val reprotool.model.usecase.UseCase target = include.getIncludeTarget();
			val UseCase dst = useCaseMap.get(target);
			
			val Include incl = factory.createInclude();
			incl.setAddition(dst);
			srcUseCase.getIncludes().add(incl);
		}	
	}
	
	def private processScenario(Scenario scenario, UseCase u) {
		for (UseCaseStep step: scenario.getSteps()) {
			processUseCaseStep(step, u);
			step.extensions.forEach([ext|processScenario(ext, u)]);
			step.variations.forEach([variation|processScenario(variation, u)]);			
		}
	}
		
	def private processUseCaseInclude(reprotool.model.usecase.UseCase u) {
		processScenario(u.mainScenario, useCaseMap.get(u));
	}
	
	def public generateUMLUCModel(SoftwareProject swproj) {
		actorMap = new HashMap<reprotool.model.swproj.Actor, Actor>();
		useCaseMap = new HashMap<reprotool.model.usecase.UseCase, UseCase>();
		factory = UMLFactory::eINSTANCE;
		model = factory.createModel();
		
		loadActors(swproj);
		swproj.useCases.forEach([useCase|processUseCase(useCase)]);
		swproj.useCases.forEach([useCase|processUseCaseInclude(useCase)]);
		
		return model;		
	}
}