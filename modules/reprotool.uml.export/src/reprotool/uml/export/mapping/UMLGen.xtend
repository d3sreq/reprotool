package reprotool.uml.export.mapping

import org.eclipse.xtext.xbase.lib.Pair

import java.util.Map
import java.util.List
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
import reprotool.model.linguistic.action.InternalAction
import reprotool.model.linguistic.actionpart.SentenceActionParam
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.BasicEList


/**
 * This class is responsible for model to model transformation of the reprotool
 * project model to the UML class diagram model.
 *
 * @author rudo
 */
public class UMLGen {
	private HashMap<Actor, org.eclipse.uml2.uml.Class> actor2UML
	private org.eclipse.uml2.uml.Class umlSystem
	
	def <K,V> boolean operator_add(Map<K,V> map, Pair<K,V> pair) {
		map.put(pair.key, pair.value)
		return true
	}
	
	def private loadActors(SoftwareProject swproj, Model model) {
		swproj.actors.forEach([actor|actor2UML +=
				actor -> 
				model.createOwnedClass(actor.getName(), false)
		]);
		
		val Actor system =
			swproj.actors.findFirst([actor|actor.name.toLowerCase.equals("system")])
			
		if (system == null) {
			umlSystem = model.createOwnedClass("system", false);
		} else {
			umlSystem = actor2UML.get(system)
		}
	}
	
	def private processUseCaseStep(UseCaseStep step) {
		if (step.getAction() instanceof ToSystem) {
			val ToSystem action = step.getAction() as ToSystem;
			if (action.getSentenceActivity() != null) {
				val Actor actor = action.sender.actor;
				val List<SentenceActionParam> params = action.actionParam
				val EList<String> eParamNames = new BasicEList<String>(
					params.map([param|param.text.content])
				)
				val TextRange text = action.sentenceActivity.text;
				if ((text != null) && (text.content != null) && (!text.content.isEmpty())) {
					if (actor2UML.containsKey(actor)) {
						actor2UML.get(actor).createOwnedOperation(text.content, eParamNames, null);
					}
				}
			}
		}
		
		if (step.getAction() instanceof InternalAction) {
			val InternalAction action = step.getAction() as InternalAction;
			if (action.getSentenceActivity() != null) {
				val List<SentenceActionParam> params = action.actionParam
				val EList<String> eParamNames = new BasicEList<String>(
					params.map([param|param.text.content])
				)
				val TextRange text = action.sentenceActivity.text;
				if ((text != null) && (text.content != null) && (!text.content.isEmpty())) {
					if (umlSystem != null) {
						umlSystem.createOwnedOperation(text.content, eParamNames, null);
					}
				}
			}
		}
		
		if (step.getAction() instanceof FromSystem) {
			val FromSystem action = step.getAction() as FromSystem;
			if (action.getSentenceActivity() != null) {
				val List<SentenceActionParam> params = action.actionParam
				val EList<String> eParamNames = new BasicEList<String>(
					params.map([param|param.text.content])
				)
				val TextRange text = action.sentenceActivity.text;
				if ((text != null) && (text.content != null) && (!text.content.isEmpty())) {
					if (umlSystem != null) {
						umlSystem.createOwnedOperation(text.content, eParamNames, null);
					}
				}
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