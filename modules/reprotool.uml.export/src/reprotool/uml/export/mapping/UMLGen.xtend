package reprotool.uml.export.mapping

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.uml2.uml.Model
import org.eclipse.xtext.xbase.lib.Pair
import reprotool.model.linguistic.action.Communication
import reprotool.model.linguistic.action.FromSystem
import reprotool.model.linguistic.action.InternalAction
import reprotool.model.linguistic.action.ToSystem
import reprotool.model.linguistic.actionpart.TextRange
import reprotool.model.swproj.Actor
import reprotool.model.swproj.SoftwareProject
import reprotool.model.usecase.Scenario
import reprotool.model.usecase.UseCase
import reprotool.model.usecase.UseCaseStep

/**
 * This class is responsible for model to model transformation of the reprotool
 * project model to the UML class diagram model.
 *
 * @author rudo, jvinarek
 */
public class UMLGen {
	private HashMap<Actor, org.eclipse.uml2.uml.Class> actor2UML
	private HashMap<Actor, ArrayList<String>> actor2Ops
	private org.eclipse.uml2.uml.Class umlSystem
	private List<String> systemOps
	
	def <K,V> boolean operator_add(Map<K,V> map, Pair<K,V> pair) {
		map.put(pair.key, pair.value)
		return true
	}
	
	def private loadActors(SoftwareProject swproj, Model model) {
		swproj.actors.forEach([
			actor2UML += it -> model.createOwnedClass(it.getName(), false);
			actor2Ops += it -> new ArrayList<String>();
		]);
		
		val Actor system =
			swproj.actors.findFirst([it.name.toLowerCase.equals("system")])
			
		if (system == null) {
			umlSystem = model.createOwnedClass("system", false);
		} else {
			umlSystem = actor2UML.get(system)
		}
	}
	
	def private processUseCaseStep(UseCaseStep step) {
		if (step.action instanceof ToSystem) {
			val ToSystem action = step.action as ToSystem;
			val Actor actor = action.sender.actor;
			
			if (action.sentenceActivity != null && actor2UML.containsKey(actor)) {
				addOperation(action, actor2UML.get(actor), actor2Ops.get(actor))
			}
		}
		
		if (step.action instanceof InternalAction || step.action instanceof FromSystem) {
			val Communication action = step.action as Communication;
			
			if (action.sentenceActivity != null) {
				addOperation(action, umlSystem, systemOps)
			}
		}
	}
	
	def private void addOperation(Communication action, org.eclipse.uml2.uml.Class actorClass, List<String> actorOperationNames) {
		// create list of parameter names
		val EList<String> eParamNames = new BasicEList<String>(
			action.actionParam.map([it.text.content.toCamelCase])
		)

		val TextRange text = action.sentenceActivity.text;
		if (text.contentPresent) {
			// create operation name
			val opName = createOperationName(text.content, eParamNames)
			
			// add operation parameters
			if (!actorOperationNames.contains(opName)) {
				actorClass.createOwnedOperation(opName, eParamNames, null);
				actorOperationNames.add(opName);
			}
		}
	}
	
	def private createOperationName(String actionName, List<String> paramNames) {
		var opName = actionName
		if (!paramNames.empty) {
			opName = (opName + " " + paramNames.get(0)).toCamelCase
		}
		opName
	}
	
	def private contentPresent(TextRange textRange) {
		textRange != null 
		&& textRange.content != null 
		&& !textRange.content.empty
	}
	
	def private processScenario(Scenario scenario) {
		for (UseCaseStep step: scenario.getSteps()) {
			processUseCaseStep(step);
			step.extensions.forEach([it.processScenario]);
			step.variations.forEach([it.processScenario]);			
		}
	}
	
	def private processUseCase(UseCase uc) {
		processScenario(uc.getMainScenario());
	}
	
	def public generateUMLModel(SoftwareProject swproj, Model model) {
		actor2UML = new HashMap<Actor, org.eclipse.uml2.uml.Class>();
		actor2Ops = new HashMap<Actor, ArrayList<String>>();
		systemOps = new ArrayList<String>();
		loadActors(swproj, model);
		swproj.useCases.forEach([it.processUseCase]);
	}
	
	def private toCamelCase(String input) {
		input.split("\\s+").map([toFirstUpper]).reduce(s1, s2 | s1 + s2).toFirstLower
	}
}