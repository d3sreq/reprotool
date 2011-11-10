package reprotool.fm.nusmv.lang.validation;

import org.eclipse.xtext.validation.Check;

import reprotool.fm.nusmv.lang.nuSmvInputLanguage.MainModule;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.Model;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.Module;
import reprotool.fm.nusmv.lang.nuSmvInputLanguage.NuSmvInputLanguagePackage;
 

public class NuSmvInputLanguageJavaValidator extends AbstractNuSmvInputLanguageJavaValidator {

	static final public String MISSING_MAIN_MODULE = "NuSmvInputLanguageJavaValidator.1";
	@Check
	public void checkModelContainsMainModule(Model nusmvModel) {
		for (Module module : nusmvModel.getModules()) {
			if(module instanceof MainModule)
				return;
		}
		error("Main module is missing", NuSmvInputLanguagePackage.Literals.MODEL__MODULES, MISSING_MAIN_MODULE);
	}
}
