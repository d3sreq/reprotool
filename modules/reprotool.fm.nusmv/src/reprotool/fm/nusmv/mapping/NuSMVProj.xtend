package reprotool.fm.nusmv.mapping

import java.util.List
import java.util.ArrayList
import java.util.HashMap

import org.eclipse.core.runtime.Assert
import org.eclipse.emf.common.util.EList

import reprotool.fm.nusmv.NuSMVGenerator
import reprotool.fm.nusmv.AnnotationEntry

import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangFactory
import reprotool.fm.nusmv.lang.nuSmvLang.MainModule
import reprotool.fm.nusmv.lang.nuSmvLang.Model
import reprotool.fm.nusmv.lang.nuSmvLang.ModuleElement

import reprotool.model.swproj.SoftwareProject

import reprotool.model.usecase.UseCase
import reprotool.model.usecase.annotate.TemporalLogicFormula
import reprotool.model.usecase.annotate.AnnotationGroup
import reprotool.model.usecase.annotate.TemporalAnnotationGroup
import reprotool.model.usecase.annotate.TemporalAnnotation


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
		return expanded2Formula.get(f);
	}
		
	def public getUseCaseById(String id) {
		for (NuSMVGenerator nusmv: generators) {
			if (nusmv.useCaseId.equals(id)) {
				return nusmv.useCase;
			}
		}
		
		return null;
	}
	
	def public getGeneratorById(String id) {
		for (NuSMVGenerator nusmv: generators) {
			if (nusmv.useCaseId.equals(id)) {
				return nusmv;
			}
		}
		
		return null;
	}
		
	def public getModel() {
		var Model nusmvModel = $(factory.createModel) [
			modules += getMainModule()
			
			for (NuSMVGenerator nusmv: generators) {
				nusmv.fillAutomaton(uc2gen);
				modules += nusmv.module;
			}
		];
		
		return nusmvModel;
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
				
				var StringBuffer nextStr = new StringBuffer();
				nextStr.append("case\n");		
				for (AnnotationEntry aEntry : globalTracker.get(tag)) {
					for (String state: aEntry.states) {
						nextStr.append("\t\tx" + aEntry.automatonID + ".s=" + state + "_ : TRUE;\n");
					}
				}
				nextStr.append("\t\tTRUE : " + tag + ";\n\tesac");
		
				nextExpr = nextStr.toString()
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
						
						var StringBuffer nextStr = new StringBuffer();
						nextStr.append("FALSE\n");
						for (AnnotationEntry aEntry: globalTracker.get(tag)) {
							nextStr.append("\t\t| x" + aEntry.automatonID + ".s in {" );
							var int c3 = 0;
							for (String state: aEntry.states) {
								if (c3 > 0) {
									nextStr.append(",");
								}
								c3 = c3 + 1;
								nextStr.append(state + "_");
							}
							nextStr.append("}\n");
						}
				
						nextExpr = nextStr.toString()
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
					nextExpr = "case p=none : {"
						+ generators.join(", ", [g|g.useCaseId] )
						+ "}; TRUE : none; esac"
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
					nextExpr = "case\n"
						+ generators.join(" | ", [g|"x" + g.useCaseId + "run"])
						+ " : FALSE;"
						+ "TRUE : TRUE;"
						+ "esac";
				]
			];
			
			// Create processes
			addProcesses(moduleElement);
			
			// Create annotations
			addAnnotations(moduleElement);
		];
	}	

	def private addProcesses(EList<ModuleElement> moduleElement) {
		for (NuSMVGenerator nusmv: generators) {
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
			
			
			var StringBuffer nextStr = new StringBuffer();
			if (
					(nusmv.useCase.precedingUseCases == null) ||
					(nusmv.useCase.precedingUseCases.isEmpty())
			) {
				nextStr.append("case\n\t\tp=p" + nusmv.useCaseId + " & idle & x" +
					nusmv.useCaseId + ".s = s0: TRUE;\n"
				);
				
			} else {
				nextStr.append("case\n\t\tp=p" + nusmv.useCaseId + " & idle & x" + nusmv.useCaseId +
					".s = s0"
				);
					
				for (UseCase pred: nusmv.useCase.precedingUseCases) {
					nextStr.append(" & x" + nusmv.uc2id(pred) + ".s = sFin");
				}
				nextStr.append(" : TRUE;\n");
			}				
			nextStr.append("\t\tTRUE : x" + nusmv.useCaseId + "run & x" +
				nusmv.useCaseId + ".s != sFin;\n\tesac"
			);
			val nextStr_final = nextStr.toString();
			
			
			moduleElement += $(factory.createAssignConstraint) [
				bodies += $(factory.createNextBody) [
					varId = "x" + nusmv.useCaseId + "run"
					nextExpr = nextStr_final
				]
			];					
		}
	}

	def public NuSMVProj_init(SoftwareProject swproj) {
		factory = NuSmvLangFactory::eINSTANCE;
				
		var List<NuSMVGenerator> generators = new ArrayList<NuSMVGenerator>();

		for (UseCase useCase : swproj.useCases) {
			println("Found usecase " + useCase.name);
			var NuSMVGenerator nusmv = new NuSMVGenerator(useCase);
			generators.add(nusmv);
		}
		
		var List<TemporalLogicFormula> formulas = new ArrayList<TemporalLogicFormula>();
		
		for (AnnotationGroup aGrp: swproj.annotationGroups) {
			if (aGrp instanceof TemporalAnnotationGroup) {
				var TemporalAnnotationGroup tGrp = aGrp as TemporalAnnotationGroup;
				formulas.addAll(tGrp.formulas);
			}
		}
		
		this.swproj = swproj;
		this.generators = generators;
		this.formulas = formulas;
		
		globalTracker = new HashMap<String, List<AnnotationEntry>>();
		uc2gen = new HashMap<UseCase, NuSMVGenerator>();
		expanded2Formula = new HashMap<String, TemporalLogicFormula>();
		expandedFormulas = new ArrayList<String>();
		
		processAnnotations();
		for (NuSMVGenerator nusmv: generators) {
			uc2gen.put(nusmv.useCase, nusmv);
		}
		
		loadIncludedAnnotations();
		loadCTLFormulas();
	}
	
	def private loadIncludedAnnotations() {
		for (NuSMVGenerator nusmv: generators) {
			var int c = 0;
			for (UseCase uc: nusmv.includedUseCases) {
				c = c + 1;
				val String label = Integer::toString(c);
				val NuSMVGenerator g = uc2gen.get(uc);
				val List<UseCase> ucList = new ArrayList<UseCase>();
				ucList.add(uc);
				addPath(g, nusmv.useCaseId + ".y" + label, ucList);
			}
		}
	}
	
	def private addPath(NuSMVGenerator g, String id, List<UseCase> ucList) {
		val HashMap<String, AnnotationEntry> annotationTracker = g.annotationsTracker;
		for (String tag: annotationTracker.keySet()) {
			var List<AnnotationEntry> list = globalTracker.get(tag);
			if (list == null) {
				Assert::isTrue(false);
				list = new ArrayList<AnnotationEntry>();
				globalTracker.put(tag, list);
			}
			val AnnotationEntry a = new AnnotationEntry(annotationTracker.get(tag));
			a.automatonID = id;
			list.add(a);
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
		for (TemporalLogicFormula formula: formulas) {
			Assert::isTrue(formula.eContainer() instanceof TemporalAnnotationGroup);
			val TemporalAnnotationGroup tGrp = formula.eContainer() as TemporalAnnotationGroup;
			val List<String> annotations = new ArrayList<String>();
			for (TemporalAnnotation annot: tGrp.members) {
				annotations.add(annot.name);
			}
			
			val List<String> annotatedVars = getAnnotatedVars(annotations);
			
			for (String variable: annotatedVars) {
				var String f = formula.getFormula();
				for (TemporalAnnotation annot: tGrp.members) {
					if (f.contains(annot.name)) {
						val String varName = annot.name + "_" + variable;
						f = f.replaceAll(annot.name, varName);
						if (!globalTracker.containsKey(varName)) {
							val List<AnnotationEntry> dummy = new ArrayList<AnnotationEntry>();
							globalTracker.put(varName, dummy);
						}
					}
				}
				var String normalised = f.replaceAll("\\s+", "");
				normalised = normalised.replaceAll("[()]", "");
				expanded2Formula.put(normalised, formula);
				expandedFormulas.add(f);
			}	
		}
	}	
	
	def private List<String> getAnnotatedVars(List<String> annotations) {
		val List<String> vars = new ArrayList<String>();	
		for (String tag: globalTracker.keySet()) {
			for (String annotName: annotations) {
				if (tag.startsWith(annotName)) {
					val String variable = tag.substring(annotName.length() + 1);
					if (!vars.contains(variable)) {
						vars.add(variable);
					}
				}
			}
		}
		
		return vars;
	}

	def private processAnnotations() {
		for (NuSMVGenerator nusmv: generators) {
			val HashMap<String, AnnotationEntry> localTracker = nusmv.annotationsTracker;
			if (localTracker != null) {
				for (String tag: localTracker.keySet()) {
					var List<AnnotationEntry> list = globalTracker.get(tag);
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