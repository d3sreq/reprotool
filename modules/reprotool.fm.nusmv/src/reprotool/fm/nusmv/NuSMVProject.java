package reprotool.fm.nusmv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.core.runtime.Assert;

import reprotool.fm.nusmv.lang.nuSmvInputLanguage.AssignConstraint;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.BooleanType;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.CTLExpression;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.CtlSpecification;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.EnumType;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.FairnessExpression;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.InitConstraint;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.MainModule;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.Model;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.NextBody;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.NextExpression;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.NuSmvInputLanguageFactory;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.VarBody;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.VariableDeclaration;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.annotate.AnnotationGroup;
import reprotool.model.usecase.annotate.TemporalAnnotation;
import reprotool.model.usecase.annotate.TemporalAnnotationGroup;
import reprotool.model.usecase.annotate.TemporalLogicFormula;

public class NuSMVProject {
	private List<NuSMVGenerator> generators;
	private NuSmvInputLanguageFactory factory;
	private SoftwareProject swproj;
	
	/**
	 * Global tracker of annotations in the whole project.
	 */
	private HashMap<String, List<AnnotationEntry>> globalTracker;
	
	private HashMap<UseCase, NuSMVGenerator> uc2gen = new HashMap<UseCase, NuSMVGenerator>();
	private HashMap<String, TemporalLogicFormula> expanded2Formula =
			new HashMap<String, TemporalLogicFormula>();
	private List<String> expandedFormulas = new ArrayList<String>();
	private List<TemporalLogicFormula> formulas;
	
	public Model getModel() {
		Model nusmvModel = factory.createModel();
		MainModule mainModule = getMainModule();
		nusmvModel.getModules().add(mainModule);
		for (NuSMVGenerator nusvm: generators) {
			nusvm.fillAutomaton(uc2gen);
			nusmvModel.getModules().add(nusvm.getModule());
		}
		return nusmvModel; 
	}
	
	private void addHeader(MainModule module) {
		StringBuffer varList = new StringBuffer();
		
		int c = 0;
		for (NuSMVGenerator nusvm: generators) {
			FairnessExpression fairness = factory.createFairnessExpression();
			fairness.setFairnessExpr("p=p" + nusvm.getUseCaseId());
			module.getModuleElement().add(fairness);
			if (c > 0) {
				varList.append(",");
			}
			c++;
			varList.append("p" + nusvm.getUseCaseId());
		}
		
		VariableDeclaration pVar = factory.createVariableDeclaration();
		pVar.setVar("VAR");
		
		VarBody pBody = factory.createVarBody();
		pBody.setId("p");
		
		EnumType pType = factory.createEnumType();
		pType.getVal().add("none");
		for (NuSMVGenerator nusmv: generators) {
			pType.getVal().add("p" + nusmv.getUseCaseId());
		}
		pBody.setType(pType);
		
		pVar.getVars().add(pBody);
		module.getModuleElement().add(pVar);
		
		InitConstraint initConstraint = factory.createInitConstraint();
		initConstraint.setInitExpression("p in none");
		module.getModuleElement().add(initConstraint);
		
		AssignConstraint assignConstraint = factory.createAssignConstraint();
		NextBody nextBody = factory.createNextBody();
		nextBody.setVar("p");
		
		NextExpression nextExpression = factory.createNextExpression();
		nextExpression.setSimpleExpression("case\n\t\tp=none : {" +
			varList + "};\n\t\tTRUE : none;\n\tesac");
		nextBody.setNext(nextExpression);
		assignConstraint.getBodies().add(nextBody);
		module.getModuleElement().add(assignConstraint);
	}
	
	private MainModule getMainModule() {
		MainModule mainModule = factory.createMainModule();
		mainModule.setName("main");
		
		addCTLFormulas(mainModule);
		addHeader(mainModule);
		addProcesses(mainModule);
		addAnnotations(mainModule);
		
		return mainModule;
	}
	
	private void addProcesses(MainModule module) {		
		for (NuSMVGenerator nusmv: generators) {
			nusmv.addProcess(module);
		}
	}
	
	public NuSMVProject (SoftwareProject swproj) {
		factory = NuSmvInputLanguageFactory.eINSTANCE;
		
		List<NuSMVGenerator> generators = new ArrayList<NuSMVGenerator>();

		for (UseCase useCase : swproj.getUseCases()) {
			System.out.println("Found usecase " + useCase.getName());
			NuSMVGenerator nusmv = new NuSMVGenerator(useCase);
			generators.add(nusmv);
		}
		
		List<TemporalLogicFormula> formulas = new ArrayList<TemporalLogicFormula>();
		
		for (AnnotationGroup aGrp: swproj.getAnnotationGroups()) {
			if (!(aGrp instanceof TemporalAnnotationGroup)) {
				continue;
			}
			TemporalAnnotationGroup tGrp = (TemporalAnnotationGroup) aGrp;
			formulas.addAll(tGrp.getFormulas());
		}
		
		this.swproj = swproj;
		this.generators = generators;
		this.formulas = formulas;
		
		globalTracker = new HashMap<String, List<AnnotationEntry>>();
		
		processAnnotations();
		for (NuSMVGenerator nusvm: generators) {
			uc2gen.put(nusvm.getUseCase(), nusvm);
		}
		
		loadIncludedAnnotations();
		loadCTLFormulas();
	}
	
	private void loadIncludedAnnotations() {
		for (NuSMVGenerator nusvm: generators) {
			int c = 0;
			for (UseCase uc: nusvm.getIncludedUseCases()) {
				c++;
				String label = Integer.toString(c);
				NuSMVGenerator g = uc2gen.get(uc);
				addPath(g, nusvm.getUseCaseId() + ".y" + label);
			}
		}
	}
	
	private void addPath(NuSMVGenerator g, String id) {
		HashMap<String, AnnotationEntry> annotationTracker = g.getAnnotationsTracker();
		for (String tag: annotationTracker.keySet()) {
			List<AnnotationEntry> list = globalTracker.get(tag);
			if (list == null) {
				Assert.isTrue(false);
				list = new ArrayList<AnnotationEntry>();
				globalTracker.put(tag, list);
			}
			AnnotationEntry a = new AnnotationEntry(annotationTracker.get(tag));
			a.automatonID = id;
			list.add(a);
		}
		
		int c = 0;
		for (UseCase uc: g.getIncludedUseCases()) {
			c++;
			String label = Integer.toString(c);
			NuSMVGenerator gen = uc2gen.get(uc);
			addPath(gen, id + ".y" + label);
		}
	}
	
	private List<String> getAnnotatedVars(List<String> annotations) {
		List<String> vars = new ArrayList<String>();
		
		for (String tag: globalTracker.keySet()) {
			for (String annotName: annotations) {
				if (tag.startsWith(annotName)) {
					String var = tag.substring(annotName.length() + 1);
					if (!vars.contains(var)) {
						vars.add(var);
						break;
					}
				}
			}
		}
		
		return vars;
	}
	
	public UseCase getUseCaseById(String id) {
		for (NuSMVGenerator nusvm: generators) {
			if (nusvm.getUseCaseId().equals(id)) {
				return nusvm.getUseCase();
			}
		}
		
		return null;
	}
	
	public NuSMVGenerator getGeneratorById(String id) {
		for (NuSMVGenerator nusvm: generators) {
			if (nusvm.getUseCaseId().equals(id)) {
				return nusvm;
			}
		}
		
		return null;
	}
	
	public SoftwareProject getSoftwareProject() {
		return swproj;
	}
	
	public TemporalLogicFormula getFormula(String f) {
		return expanded2Formula.get(f);
	}
	
	private void loadCTLFormulas() {
		for (TemporalLogicFormula formula: formulas) {
			Assert.isTrue(formula.eContainer() instanceof TemporalAnnotationGroup);
			TemporalAnnotationGroup tGrp = (TemporalAnnotationGroup) formula.eContainer();
			List<String> annotations = new ArrayList<String>();
			for (TemporalAnnotation annot: tGrp.getMembers()) {
				annotations.add(annot.getName());
			}

			List<String> annotatedVars = getAnnotatedVars(annotations);
			
			for (String var: annotatedVars) {
				String f = formula.getFormula();
				for (TemporalAnnotation annot: tGrp.getMembers()) {
					if (f.contains(annot.getName())) {
						f = f.replaceAll(annot.getName(), annot.getName() + "_" + var);
					}
				}
				String normalised = f.replaceAll("\\s+", "");
				normalised = normalised.replaceAll("[()]", "");
				expanded2Formula.put(normalised, formula);
				expandedFormulas.add(f);
			}
		}	
	}
	
	public void addCTLFormulas(MainModule module) {		
		for (String formula: expandedFormulas) {
			CtlSpecification ctlSpec = factory.createCtlSpecification();
			CTLExpression ctlExpr = factory.createCTLExpression();
			ctlExpr.setSimpleExpression(formula);
			ctlSpec.setCtlExpression(ctlExpr);
			module.getModuleElement().add(ctlSpec);			
		}
	}
		
	private void addTraceAnnotation(String tag, MainModule module) {
		VariableDeclaration tagVar = factory.createVariableDeclaration();
		tagVar.setVar("VAR");	
		VarBody tagBody = factory.createVarBody();
		tagBody.setId(tag);
		BooleanType tagType = factory.createBooleanType();
		tagBody.setType(tagType);
		tagVar.getVars().add(tagBody);
		module.getModuleElement().add(tagVar);
					
		InitConstraint initConstraint = factory.createInitConstraint();
		initConstraint.setInitExpression(tag + " in FALSE");
		module.getModuleElement().add(initConstraint);
		
		StringBuffer nextExpr = new StringBuffer();
		nextExpr.append("case\n");		
		
		for (AnnotationEntry aEntry : globalTracker.get(tag)) {
			for (String state: aEntry.states) {
				nextExpr.append("\t\tx" + aEntry.automatonID + ".s=" + state + " : TRUE;\n");
			}
		}
		nextExpr.append("\t\tTRUE : " + tag + ";\n\tesac");
		
		AssignConstraint assignConstraint = factory.createAssignConstraint();
		NextBody nextBody = factory.createNextBody();
		nextBody.setVar(tag);
		NextExpression nextExpression = factory.createNextExpression();
		nextExpression.setSimpleExpression(nextExpr.toString());
		nextBody.setNext(nextExpression);
		assignConstraint.getBodies().add(nextBody);
		module.getModuleElement().add(assignConstraint);
	}
	
	private void addAnnotations(MainModule module) {
		for (String tag: globalTracker.keySet()) {
			if (tag.matches("trace_.*")) {
				addTraceAnnotation(tag, module);
				continue;
			}
			
			if (tag.matches("on_.*")) {
				continue;
			}
				
			VariableDeclaration tagVar = factory.createVariableDeclaration();
			tagVar.setVar("VAR");	
			VarBody tagBody = factory.createVarBody();
			tagBody.setId(tag);
			BooleanType tagType = factory.createBooleanType();
			tagBody.setType(tagType);
			tagVar.getVars().add(tagBody);
			module.getModuleElement().add(tagVar);
						
			InitConstraint initConstraint = factory.createInitConstraint();
			initConstraint.setInitExpression(tag + " in FALSE");
			module.getModuleElement().add(initConstraint);
			
			StringBuffer nextExpr = new StringBuffer();
			
			nextExpr.append("FALSE\n");
			for (AnnotationEntry aEntry: globalTracker.get(tag)) {
				nextExpr.append("\t\t| x" + aEntry.automatonID + ".s in {" );
				int c = 0;
				for (String state: aEntry.states) {
					if (c > 0) {
						nextExpr.append(",");
					}
					c++;
					nextExpr.append(state);
				}
				nextExpr.append("}\n");
			}
			
			AssignConstraint assignConstraint = factory.createAssignConstraint();
			NextBody nextBody = factory.createNextBody();
			nextBody.setVar(tag);
			NextExpression nextExpression = factory.createNextExpression();
			nextExpression.setSimpleExpression(nextExpr.toString());
			nextBody.setNext(nextExpression);
			assignConstraint.getBodies().add(nextBody);
			module.getModuleElement().add(assignConstraint);
		}
	}
	
	private void processAnnotations() {
		for (NuSMVGenerator nusmv: generators) {
			HashMap<String, AnnotationEntry> localTracker = nusmv.getAnnotationsTracker();
			if (localTracker == null) {
				continue;
			}
			for (String tag: localTracker.keySet()) {
				List<AnnotationEntry> list = globalTracker.get(tag);
				if (list == null) {
					list = new ArrayList<AnnotationEntry>();
					globalTracker.put(tag, list);
				}
				list.add(localTracker.get(tag));
			}
		}
	}
}