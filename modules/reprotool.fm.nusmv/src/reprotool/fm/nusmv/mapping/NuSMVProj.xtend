package reprotool.fm.nusmv.mapping

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.eclipse.core.runtime.Assert
import org.eclipse.emf.common.util.EList
import reprotool.fm.nusmv.AnnotationEntry
import reprotool.fm.nusmv.NuSMVGenerator
import reprotool.fm.nusmv.lang.nuSmvLang.ModuleElement
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangFactory
import reprotool.model.swproj.SoftwareProject
import reprotool.model.usecase.UseCase
import reprotool.model.usecase.annotate.AnnotationGroup
import reprotool.model.usecase.annotate.TemporalAnnotationGroup
import reprotool.model.usecase.annotate.TemporalLogicFormula


public class NuSMVProj {
	private NuSmvLangFactory factory
	private SoftwareProject swproj
	private List<NuSMVGenerator> generators
	private List<TemporalLogicFormula> formulas
	private HashMap<String, TemporalLogicFormula> expanded2Formula
	private List<String> expandedFormulas
	
	private HashMap<String, List<AnnotationEntry>> globalTracker
	private HashMap<UseCase, NuSMVGenerator> uc2gen
		
	def private <T> T $(T m, (T)=>void init ) {
		init.apply(m)
		return m
	}
	
	def public getSoftwareProject() {
		return swproj;
	}
	
	def public getFormula(String f) {
		expanded2Formula.get(f);
	}
		
	def public getUseCaseById(String id) {
		generators.findFirst([useCaseId.equals(id)]).useCase;
	}
	
	def public getGeneratorById(String id) {
		generators.findFirst([useCaseId.equals(id)]);
	}
		
	def public getModel() {
		$(factory.createModel) [
			modules += getMainModule()
			
			modules += generators.map([fillAutomaton(uc2gen); module]);
		];
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
					globalTracker.get(tag).map([aEntry |
						aEntry.states.map([
							"\t\tx" + aEntry.automatonID + ".s=" + it + "_ : TRUE;"
						]).join("\n")
					]).join("\n") +
					"\t\tTRUE : " + tag + ";\n\tesac"
			]
		];
	}
	
	def private addAnnotations(EList<ModuleElement> moduleElement) {
		var boolean cont = false;
		for (String tag: globalTracker.keySet()) {
			if (tag.matches("trace_.*")) {
				addTraceAnnotation(tag, moduleElement);
				cont = true;
			}
			
			if (tag.matches("on_.*")) {
				cont = true;
			}
		
			if (!cont) {
				// Create declaration for annotation variable
				moduleElement += $(factory.createVariableDeclaration) [
					vars += $(factory.createVarBody) [
						varId = tag
						type = factory.createBooleanType()
					]
				];
				
				// Initialize annotation variable
				moduleElement += $(factory.createInitConstraint) [
					initExpr = tag + " in FALSE"
				];

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
				];
			}
		}
	}
	def private getMainModule() {
		$(factory.createMainModule) [
			name = "main"
			
			// Create CTL formulas
			moduleElement += expandedFormulas.map( formula |
				$(factory.createCtlSpecification) [
					ctlExpr = formula
				]
			);
			
			// Create fairness expressions
			moduleElement += generators.map( g |
				$(factory.createFairnessExpression) [
					fairnessExpr = "p=p" + g.useCaseId;
				]
			);
			
			// Create p variable declaration
			moduleElement += $(factory.createVariableDeclaration) [
				vars += $(factory.createVarBody) [
					varId = "p"
					type = $(factory.createEnumType) [
						value += "none"
						value += generators.map(g|"p" + g.useCaseId);
					];
				];
			];
		
			// Create initialization for the p variable
			moduleElement += $(factory.createInitConstraint) [
				initExpr = "p in none"
			];	

			// Create assignment for the p variable
			moduleElement += $(factory.createAssignConstraint) [
				bodies += $(factory.createNextBody) [
					varId = "p"
					nextExpr = "case\n" + 
						"		p=none : {" +
						generators.join(", ", [g|"p" + g.useCaseId] ) + "};\n" +
						"		TRUE : none;\n" +
						"	esac"
				];	
			];
			
			// Create idle variable declaration
			moduleElement += $(factory.createVariableDeclaration) [
				vars += $(factory.createVarBody) [
					varId = "idle"
					type = factory.createBooleanType
				]
			];
			
			// Create idle variable initialization
			moduleElement += $(factory.createInitConstraint) [
				initExpr = "idle in TRUE"
			];
			
			// Create idle variable assignment
			moduleElement += $(factory.createAssignConstraint) [
				bodies += $(factory.createNextBody) [
					varId = "idle"
					nextExpr = "case\n" +
						"		" + generators.join(" | ", [g|"x" + g.useCaseId + "run"]) + " : FALSE;\n" +
						"		TRUE : TRUE;\n" +
						"	esac";
				]
			];
			
			// Create processes
			addProcesses(moduleElement);
			
			// Create annotations
			addAnnotations(moduleElement);
		];
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

	def public NuSMVProj_init(SoftwareProject swproj) {
		factory = NuSmvLangFactory::eINSTANCE;
				
		generators = new ArrayList<NuSMVGenerator>();
		generators += swproj.useCases.map([
			println("Found usecase " + name)
			new NuSMVGenerator(it)
		])
		
		var List<TemporalLogicFormula> formulas = new ArrayList<TemporalLogicFormula>();
		
		for (AnnotationGroup aGrp: swproj.annotationGroups) {
			if (aGrp instanceof TemporalAnnotationGroup) {
				var TemporalAnnotationGroup tGrp = aGrp as TemporalAnnotationGroup;
				formulas.addAll(tGrp.formulas);
			}
		}
		
		this.swproj = swproj;
		this.formulas = formulas;
		
		globalTracker = new HashMap<String, List<AnnotationEntry>>();
		uc2gen = new HashMap<UseCase, NuSMVGenerator>();
		expanded2Formula = new HashMap<String, TemporalLogicFormula>();
		expandedFormulas = new ArrayList<String>();
		
		processAnnotations();
		generators.forEach([
			uc2gen.put(it.useCase, it);
		]);
		
		loadIncludedAnnotations();
		loadCTLFormulas();
	}
	
	def private loadIncludedAnnotations() {
		for (nusmv: generators) {
			var c = 0
			for (uc: nusmv.includedUseCases) {
				c = c + 1
				val String label = Integer::toString(c)
				val NuSMVGenerator g = uc2gen.get(uc)
				
				val ucList = new ArrayList<UseCase>()
				ucList.add(uc)
				addPath(g, nusmv.useCaseId + ".y" + label, ucList)
			}
		}
	}
	
	def private addPath(NuSMVGenerator g, String id, List<UseCase> ucList) {
		val annotationTracker = g.annotationsTracker;
		
		for (String tag: annotationTracker.keySet()) {
			val list = globalTracker.get(tag);
			Assert::isNotNull(list);
			
			val AnnotationEntry a = new AnnotationEntry(annotationTracker.get(tag));
			a.automatonID = id;
			list += a;
		}
		
		var int c = 0;
		for (UseCase uc: g.includedUseCases) {
			if (!ucList.contains(uc)) {
				c = c + 1;
				val String label = Integer::toString(c);
				val NuSMVGenerator gen = uc2gen.get(uc);
				ucList.add(uc);
				addPath(gen, id + ".y" + label, ucList);
			} else {
				throw new RuntimeException("UseCases are recursively defined.");
			}
		}
	}
	
	def private loadCTLFormulas() {
		for (formula: formulas) {
			Assert::isTrue(formula.eContainer() instanceof TemporalAnnotationGroup);
			val tGrp = formula.eContainer() as TemporalAnnotationGroup;
			
			val annotations = new ArrayList<String>();
			annotations += tGrp.members.map([name]);
			
			val annotatedVars = getAnnotatedVars(annotations);
			
			for (variable: annotatedVars) {
				var f = formula.getFormula();
				for (annot: tGrp.members) {
					if (f.contains(annot.name)) {
						val varName = annot.name + "_" + variable;
						f = f.replaceAll(annot.name, varName);
						if (!globalTracker.containsKey(varName)) {
							val dummy = new ArrayList<AnnotationEntry>();
							globalTracker.put(varName, dummy);
						}
					}
				}
				
				val normalised = f.replaceAll("[()\\s]+", "");
				expanded2Formula.put(normalised, formula);
				expandedFormulas.add(f);
			}	
		}
	}	
	
	def private List<String> getAnnotatedVars(List<String> annotations) {
		val vars = new ArrayList<String>();
		for (tag: globalTracker.keySet()) {
			for (annotName: annotations) {
				if (tag.startsWith(annotName)) {
					val variable = tag.substring(annotName.length() + 1);
					if (!vars.contains(variable)) {
						vars += variable;
					}
				}
			}
		}
		
		return vars;
	}

	def private processAnnotations() {
		for (nusmv: generators) {
			val localTracker = nusmv.annotationsTracker;
			if (localTracker != null) {
				for (tag: localTracker.keySet()) {
					var list = globalTracker.get(tag);
					if (list == null) {
						list = new ArrayList<AnnotationEntry>();
						globalTracker.put(tag, list);
					}
					list.add(localTracker.get(tag));
				}
			}	
		}
	}
}