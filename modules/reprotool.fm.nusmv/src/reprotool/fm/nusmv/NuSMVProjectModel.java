package reprotool.fm.nusmv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.core.runtime.Assert;

import reprotool.fm.nusmv.lang.nuSmvInputLanguage.AssignConstraint;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.BooleanType;
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
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.annotate.TemporalAnnotation;
import reprotool.model.usecase.annotate.TemporalAnnotationGroup;
import reprotool.model.usecase.annotate.TemporalLogicFormula;

public class NuSMVProjectModel {
	private List<NuSMVGeneratorModel> generators;
	private NuSmvInputLanguageFactory factory;
	
	/**
	 * Global tracker of annotations in the whole project.
	 */
	private HashMap<String, List<AnnotationEntry>> globalTracker;
	
	private HashMap<UseCase, NuSMVGeneratorModel> uc2gen = new HashMap<UseCase, NuSMVGeneratorModel>();
	private List<TemporalLogicFormula> formulas;
	
	public Model getModel() {
		Model nusmvModel = factory.createModel();
		MainModule mainModule = getMainModule(nusmvModel);
		nusmvModel.getModules().add(mainModule);
		for (NuSMVGeneratorModel nusvm: generators) {
			nusvm.fillAutomaton(uc2gen);
			nusmvModel.getModules().add(nusvm.getModule());
		}
		return nusmvModel; 
	}
	
	private MainModule getMainModule(Model model) {
		MainModule mainModule = factory.createMainModule();
		mainModule.setName("main");
		StringBuffer varList = new StringBuffer();
		
		int c = 0;
		for (NuSMVGeneratorModel nusvm: generators) {
			FairnessExpression fairness = factory.createFairnessExpression();
			fairness.setFairnessExpr("p=p" + nusvm.getUseCaseId());
			mainModule.getModuleElement().add(fairness);
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
		for (NuSMVGeneratorModel nusmv: generators) {
			pType.getVal().add("p" + nusmv.getUseCaseId());
		}
		pBody.setType(pType);
		
		pVar.getVars().add(pBody);
		mainModule.getModuleElement().add(pVar);
		
		InitConstraint initConstraint = factory.createInitConstraint();
		initConstraint.setInitExpression("p in none");
		mainModule.getModuleElement().add(initConstraint);
		
		AssignConstraint assignConstraint = factory.createAssignConstraint();
		NextBody nextBody = factory.createNextBody();
		nextBody.setVar("p");
		
		NextExpression nextExpression = factory.createNextExpression();
		nextExpression.setSimpleExpression("case\n\t\tp=none : {" +
			varList + "};\n\t\tTRUE : none;\n\tesac");
		nextBody.setNext(nextExpression);
		assignConstraint.getBodies().add(nextBody);
		mainModule.getModuleElement().add(assignConstraint);
		
		addProcesses(mainModule, model);
		addAnnotations(mainModule);
		
		return mainModule;
	}
	
	private void addProcesses(MainModule module, Model model) {		
		for (NuSMVGeneratorModel nusmv: generators) {
			nusmv.addProcess(module, model);
		}
	}
	
	public NuSMVProjectModel (List<NuSMVGeneratorModel> generators) {
		factory = NuSmvInputLanguageFactory.eINSTANCE;
		this.generators = generators;
		
		globalTracker = new HashMap<String, List<AnnotationEntry>>();
		
		processAnnotations();
		for (NuSMVGeneratorModel nusvm: generators) {
			uc2gen.put(nusvm.getUseCase(), nusvm);
		}
		
		for (NuSMVGeneratorModel nusmv: generators) {
			int c = 0;
			for (UseCase uc: nusmv.getIncludedUseCases()) {
				c++;
				String label = Integer.toString(c);
				NuSMVGeneratorModel g = uc2gen.get(uc);
				HashMap<String, AnnotationEntry> annotationTracker = g.getAnnotationsTracker();
				for (String tag: annotationTracker.keySet()) {
					List<AnnotationEntry> list = globalTracker.get(tag);
					if (list == null) {
						Assert.isTrue(false);
						list = new ArrayList<AnnotationEntry>();
						globalTracker.put(tag, list);
					}
					AnnotationEntry a = new AnnotationEntry(annotationTracker.get(tag));
					a.automatonID = nusmv.getUseCaseId() + ".y" + label;
					list.add(a);
				}
			}
		}
	}
	
	public String getFormulas() {
		StringBuffer buf = new StringBuffer();
		
		for (TemporalLogicFormula formula: formulas) {
			Assert.isTrue(formula.eContainer() instanceof TemporalAnnotationGroup);
			TemporalAnnotationGroup tGrp = (TemporalAnnotationGroup) formula.eContainer();
			List<String> annotations = new ArrayList<String>();
			for (TemporalAnnotation annot: tGrp.getMembers()) {
//				System.out.println("Replacing " + annot.getName() + " in formula " + formula.getFormula());
				annotations.add(annot.getName());
			}
//			annot.getName() si vlozim do pola annotations (bude mat napriklad {open, close})
//			funkcia getAnnotatedVars(List<String> annotations) mi vrati prislusne premenne
//			(Ak je v global trackeri open_x, close_y, tak vrati list {x,y})
//			List<String> annotatedVars = getAnnotatedVars(annotations);
			
//			for (String var: annotatedVars) {
//				String f = formula.getFormula();
//				for (TemporalAnnotation annot: tGrp.getMembers()) {
//					System.out.println("Replacing " + annot.getName() + " in formula " + formula.getFormula());
//					f = f.replaceAll(annot.getName(), annot.getName + "_" + var);
//				}
//				System.out.println(f);
//			}
		}
		
		return buf.toString();
	}
	
//	public String getAutomata() {
//		StringBuffer buf = new StringBuffer();
//		
//		int c = 0;
//		for (NuSMVGeneratorModel nusmv: generators) {
//			c++;
//			buf.append(nusmv.getAutomaton());
//			if (c < generators.size()) {
//				buf.append("\n\n");
//			}
//		}
//
//		return buf.toString();
//	}
	
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
		for (NuSMVGeneratorModel nusmv: generators) {
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