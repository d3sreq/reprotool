package reprotool.uml.export.mapping

import org.eclipse.xtext.xbase.lib.Pair

import java.util.Map
import java.util.HashMap
import org.eclipse.uml2.uml.Model

import reprotool.model.linguistic.action.FromSystem
import reprotool.model.linguistic.action.ToSystem
import reprotool.model.linguistic.actionpart.TextRange
import reprotool.model.swproj.Actor
import reprotool.model.swproj.SoftwareProject
import reprotool.model.usecase.Scenario
import reprotool.model.usecase.UseCase
import reprotool.model.usecase.UseCaseStep


public class UMLGen {
	private HashMap<Actor, org.eclipse.uml2.uml.Class> actor2UML
	private org.eclipse.uml2.uml.Class umlSystem
	
	def <K,V> boolean operator_add(Map<K,V> map, Pair<K,V> pair) {
		map.put(pair.key, pair.value)
		return true
	}
	
	def private loadActors(SoftwareProject swproj, Model model) {
		umlSystem = model.createOwnedClass("system", false);
		swproj.actors.forEach([actor|actor2UML +=
				actor -> 
				model.createOwnedClass(actor.getName(), false)
		]);
	}
	
	def private processUseCaseStep(UseCaseStep step) {
		if (step.getAction() instanceof ToSystem) {
			val ToSystem action = step.getAction() as ToSystem;
			if (action.getSentenceActivity() != null) {
				val TextRange text = action.getSentenceActivity().getText();
				if (text != null) {
					umlSystem.createOwnedOperation(text.getContent(), null, null);
				}
			}
		}
		if (step.getAction() instanceof FromSystem) {
			val FromSystem action = step.getAction() as FromSystem;
			if (action.getSentenceActivity() != null) {
				val Actor actor = action.getReceiver().getActor();
				actor2UML.get(actor).createOwnedOperation(action.getSentenceActivity().getText().getContent(),
						null, null);
			}
		}
	}
	
	def private processScenario(Scenario scenario) {
		for (UseCaseStep step: scenario.getSteps()) {
			processUseCaseStep(step);
			step.extensions.forEach([ext|processScenario(ext)]);
			step.variations.forEach([variation|processScenario(variation)]);			
		}
	}
	
	def private processUseCase(UseCase uc) {
		processScenario(uc.getMainScenario());
	}
	
	def public generateUMLModel(SoftwareProject swproj, Model model) {
		actor2UML = new HashMap<Actor, org.eclipse.uml2.uml.Class>();
		loadActors(swproj, model);
		swproj.useCases.forEach([useCase|processUseCase(useCase)]);
	}
}