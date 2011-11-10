package reprotool.fm.nusmv.lang.validation;

import org.eclipse.xtext.validation.Check;

import reprotool.fm.nusmv.lang.nuSmvInputLanguage.Model;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.Module;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.NuSmvInputLanguagePackage;
 

public class NuSmvInputLanguageJavaValidator extends AbstractNuSmvInputLanguageJavaValidator {

	static final public String MISSING_MAIN_MODULE = "NuSmvInputLanguageJavaValidator.1";
	static final public String PARAMETERS_NOT_ALLOWED = "NuSmvInputLanguageJavaValidator.2";
	
	@Check
	public void checkModelContainsMainModule(Model nusmvModel) {
		for (Module module : nusmvModel.getModules()) {
			if(module.getName().equals("main"))
				return;
		}
		error("Main module is missing", NuSmvInputLanguagePackage.Literals.MODEL__MODULES, MISSING_MAIN_MODULE);
	}

	@Check
	public void checkMainModuleWithoutParams(Module module) {
		if(module.getName().equals("main") && !module.getParams().isEmpty())
			error("Parameters in main module are not allowed", NuSmvInputLanguagePackage.Literals.MODULE__PARAMS, PARAMETERS_NOT_ALLOWED);
	}

}
