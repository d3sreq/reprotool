package reprotool.fm.nusmv.mapping

import com.google.inject.Inject
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.eclipse.core.runtime.Assert
import org.eclipse.emf.common.util.EList
import org.eclipse.ui.console.MessageConsoleStream
import reprotool.fm.nusmv.FormulaUtils
import reprotool.fm.nusmv.AnnotationEntry
import reprotool.fm.nusmv.NuSMVGenerator
import reprotool.fm.nusmv.lang.nuSmvLang.ModuleElement
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangFactory
import reprotool.model.swproj.SoftwareProject
import reprotool.model.usecase.UseCase
import reprotool.model.usecase.annotate.TemporalAnnotationGroup
import reprotool.model.usecase.annotate.TemporalLogicFormula
import reprotool.model.utils.xtend.ReprotoolMappingExtensions
import reprotool.model.usecase.annotate.CTLFormula
import reprotool.model.usecase.annotate.LTLFormula

/**
 * This class is responsible for model to model transformation of the
 * Reprotool project to he NuSMV model.
 * 
 * @author rudo, viliam simko
 */
public class NuSMVProj {

	@Inject extension ReprotoolMappingExtensions
	@Inject private MessageConsoleStream consoleOut
	@Inject private NuSmvLangFactory factory
	@Inject private SoftwareProject swproj
		
	private List<NuSMVGenerator> generators
	private List<TemporalLogicFormula> formulas
	private HashMap<String, TemporalLogicFormula> expanded2Formula
	private List<String> expandedCTLFormulas
	private List<String> expandedLTLFormulas
	
	private HashMap<String, List<AnnotationEntry>> globalTracker
	private HashMap<UseCase, NuSMVGenerator> uc2gen
	
	def public initializeSoftwareProject() {
		Assert::isNotNull(factory)
		Assert::isNotNull(swproj)
				
		// prepare generators
		generators = new ArrayList<NuSMVGenerator>();
		generators += swproj.useCases.map([
			consoleOut.println("[NuSMV] Found usecase " + name)
			new NuSMVGenerator(it)
		])
				
		// prepare formulas
		formulas = new ArrayList<TemporalLogicFormula>();
		formulas += swproj.annotationGroups
			.filter( typeof(TemporalAnnotationGroup) )
			.map( annotGroup | annotGroup.formulas )
			.flatten
					
		// cleanup helper structures
		globalTracker = new HashMap<String, List<AnnotationEntry>>()
		uc2gen = new HashMap<UseCase, NuSMVGenerator>()
		expanded2Formula = new HashMap<String, TemporalLogicFormula>()
		expandedCTLFormulas = new ArrayList<String>()
		expandedLTLFormulas = new ArrayList<String>()

		uc2gen += generators.map([ it.useCase -> it ])
		
		processAnnotations()
		loadIncludedAnnotations()
		loadTLFormulas()
	}
	
	def public getSoftwareProject() {
		return swproj
	}

	def public getFormula(String f) {
		expanded2Formula.get(f)
	}
		
	def public getUseCaseById(String id) {
		generators.findFirst([useCaseId.equals(id)]).useCase
	}
	
	def public getGeneratorById(String id) {
		generators.findFirst([useCaseId.equals(id)])
	}
	
	def public containsCTLFormulas() {
		return (!expandedCTLFormulas.empty)		
	}
	
	def public containsLTLFormulas() {
		return (!expandedLTLFormulas.empty)
	}
		
	def public getModel() {
		$(factory.createModel) [
			modules += getMainModule()
			modules += generators.map([ fillAutomaton(uc2gen); module ])
		]
	}
	
	def private addTraceAnnotation(String tag, EList<ModuleElement> moduleElement) {
		moduleElement += $(factory.createVariableDeclaration) [
			vars += $(factory.createVarBody) [
				varId = tag
				type = factory.createBooleanType()
			]
		]
		
		moduleElement += $(factory.createInitConstraint) [
			initExpr = tag + " in FALSE"
		]
		
		moduleElement += $(factory.createAssignConstraint) [
			bodies += $(factory.createNextBody) [
				varId = tag
				nextExpr = "case\n" +
					globalTracker.get(tag).filter([aEntry|(!aEntry.states.isEmpty())]).map([aEntry |
						aEntry.states.map([
							"\t\tx" + aEntry.automatonID + ".s=" + it + "_ : TRUE;"
						]).join("\n")
					]).join("\n") +
					"\n\t\tTRUE : " + tag + ";\n\tesac"
			]
		]
	}
	
	def private addAnnotations(EList<ModuleElement> moduleElement) {
		var boolean cont;
		for (tag: globalTracker.keySet()) {
			cont = false;
			
			if (tag.matches("trace_.*")) {
				addTraceAnnotation(tag, moduleElement);
				cont = true
			}
			
			if (tag.matches("on_.*")) {
				cont = true
			}
		
			if (!cont) {				
				// Create declaration for annotation variable
				moduleElement += $(factory.createVariableDeclaration) [
					vars += $(factory.createVarBody) [
						varId = tag
						type = factory.createBooleanType()
					]
				]
				
				// Initialize annotation variable
				moduleElement += $(factory.createInitConstraint) [
					initExpr = tag + " in FALSE"
				]

				// Create assignment for annotation variable
				moduleElement += $(factory.createAssignConstraint) [
					bodies += $(factory.createNextBody) [
						varId = tag
						nextExpr = "FALSE\n" +
							globalTracker.get(tag).map( aEntry |
								"\t\t| x" + aEntry.automatonID + ".s in {" +
								aEntry.states.join(",", [ it + "_"]) +
								"}\n"
							).join;
					]
				]
			}
		}
	}
	
	def private getMainModule() {
		$(factory.createMainModule) [
			name = "main"
			
			// Create CTL formulas
			moduleElement += expandedCTLFormulas.map( formula |
				$(factory.createCtlSpecification) [
					ctlExpr = formula
				]
			)
			
			// Create LTL formulas
			moduleElement += expandedLTLFormulas.map( formula |
				$(factory.createLtlSpecification) [
					ltlExpr = formula
				]
			)
			
			// Create fairness expressions
			moduleElement += generators.map( g |
				$(factory.createFairnessExpression) [
					fairnessExpr = "p=p" + g.useCaseId;
				]
			)
			
			// Create p variable declaration
			moduleElement += $(factory.createVariableDeclaration) [
				vars += $(factory.createVarBody) [
					varId = "p"
					type = $(factory.createEnumType) [
						value += "none"
						value += generators.map(g|"p" + g.useCaseId)
					]
				]
			]
		
			// Create initialization for the p variable
			moduleElement += $(factory.createInitConstraint) [
				initExpr = "p in none"
			]

			// Create assignment for the p variable
			moduleElement += $(factory.createAssignConstraint) [
				bodies += $(factory.createNextBody) [
					varId = "p"
					nextExpr = "case\n" + 
						"		p=none : {" +
						generators.join(", ", ["p" + useCaseId] ) + "};\n" +
						"		TRUE : none;\n" +
						"	esac"
				]
			]
			
			// Create idle variable declaration
			moduleElement += $(factory.createVariableDeclaration) [
				vars += $(factory.createVarBody) [
					varId = "idle"
					type = factory.createBooleanType
				]
			]
			
			// Create idle variable initialization
			moduleElement += $(factory.createInitConstraint) [
				initExpr = "idle in TRUE"
			]
			
			// Create idle variable assignment
			moduleElement += $(factory.createAssignConstraint) [
				bodies += $(factory.createNextBody) [
					varId = "idle"
					nextExpr = "case\n" +
						"		" + generators.join(" | ", [g|"x" + g.useCaseId + "run"]) + " : FALSE;\n" +
						"		TRUE : TRUE;\n" +
						"	esac";
				]
			]
			
			// Create processes
			addProcesses(moduleElement);
			
			// Create annotations
			addAnnotations(moduleElement);
		]
	}	

	def private addProcesses(EList<ModuleElement> moduleElement) {
		
		for (nusmv: generators) {
			moduleElement += $(factory.createVariableDeclaration) [
				vars += $(factory.createVarBody) [
					varId = "x" + nusmv.useCaseId
					type = $(factory.createSyncrProcessType) [
						module = nusmv.module
						params += "self"
						params += "x" + nusmv.useCaseId + "run"
					]
				]
			];
			
			moduleElement += $(factory.createVariableDeclaration) [
				vars += $(factory.createVarBody) [
					varId = "x" + nusmv.useCaseId + "run"
					type = factory.createBooleanType()
				]
			];
			
			moduleElement += $(factory.createInitConstraint) [
				initExpr = "x" + nusmv.useCaseId + "run in FALSE"
			]
			
			moduleElement += $(factory.createAssignConstraint) [
				bodies += $(factory.createNextBody) [
					varId = "x" + nusmv.useCaseId + "run"
					if (
						(nusmv.useCase.precedingUseCases == null) ||
						(nusmv.useCase.precedingUseCases.isEmpty())
					) {
						nextExpr = "case\n" +
							"		p=p" + nusmv.useCaseId + " & idle & x" + nusmv.useCaseId +
							".s = s0 : TRUE;\n" +
							"		TRUE : x" + nusmv.useCaseId + "run & x" + nusmv.useCaseId +
							".s != sFin;\n" +
							"	esac"													
					} else {
						nextExpr = "case\n" +
							"		p=p" + nusmv.useCaseId + " & idle & x" + nusmv.useCaseId +
							".s = s0 & " +
							nusmv.useCase.precedingUseCases.join(" & ",
								["x" + nusmv.uc2id(it) + ".s = sFin"]) + " : TRUE;\n" +
							"		TRUE : x" + nusmv.useCaseId + "run & x" + nusmv.useCaseId +
							".s != sFin;\n" +
							"	esac"
					}
				]
			];
		}
	}

	def private loadIncludedAnnotations() {
		
		for (nusmv: generators) {
			var c = 0
			for (uc: nusmv.includedUseCases) {
				c = c + 1
				val label = Integer::toString(c)
				val NuSMVGenerator g = uc2gen.get(uc)
				
				if (g == null) {
					throw new RuntimeException("Include of unknown use case found.")
				}
							
				val ucList = new ArrayList<UseCase>()
				ucList += uc
				addPath(g, nusmv.useCaseId + ".y" + label, ucList)
			}
		}
	}
	
	def private addPath(NuSMVGenerator g, String id, List<UseCase> ucList) {
		val annotationTracker = g.annotationsTracker
		
		for (tag: annotationTracker.keySet()) {
			val list = globalTracker.get(tag)
			Assert::isNotNull(list)
			
			val AnnotationEntry a = new AnnotationEntry(annotationTracker.get(tag));
			a.automatonID = id
			list += a
		}
		
		var int c = 0;
		for (uc: g.includedUseCases) {
			if (!ucList.contains(uc)) {
				c = c + 1
				val label = Integer::toString(c)
				val gen = uc2gen.get(uc)
				ucList += uc
				addPath(gen, id + ".y" + label, ucList)
			} else {
				throw new RuntimeException("UseCases are recursively defined.")
			}
		}
	}
	
	def private loadTLFormulas() {
		for (formula: formulas) {
			Assert::isTrue(formula.eContainer() instanceof TemporalAnnotationGroup);
			val tGrp = formula.eContainer() as TemporalAnnotationGroup;
			
			val annotations = new ArrayList<String>()
			annotations += tGrp.members.map([name])
			
			val annotatedVars = getAnnotatedVars(annotations);
			
			for (variable: annotatedVars) {
				var f = FormulaUtils::expandFormula(
					formula.getFormula(),
					variable,
					annotations,
					globalTracker
				);
				
				val normalised = f.replaceAll("[()\\s]+", "")
				expanded2Formula += normalised -> formula
				
				if (formula instanceof CTLFormula) {
					expandedCTLFormulas += f
				} else if (formula instanceof LTLFormula) {
					expandedLTLFormulas += f
				}
			}	
		}
	}	
		
	def private List<String> getAnnotatedVars(List<String> annotations) {
		globalTracker.keySet.map([ tag |
			annotations
				.filter([ tag.startsWith(it) ])
				.map([it2 | tag.substring( it2.length + 1) ])
		])
		.flatten
		.toSet.toList // remove duplicates
	}

	def private processAnnotations() {
		generators
			.map([ annotationsTracker ]) // local trackers
			.filterNull
			.forEach( localTracker |
				localTracker.keySet().forEach([
					var list = globalTracker.get(it)
					if (list == null) {
						list = new ArrayList<AnnotationEntry>()
						globalTracker += it -> list
					}
					list += localTracker.get(it)
				])
			)
	}
}