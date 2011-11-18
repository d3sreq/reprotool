package reprotool.fm.nusmv.lang.validation;

import org.eclipse.xtext.validation.Check;

import reprotool.fm.nusmv.lang.nuSmvLang.MainModule;
import reprotool.fm.nusmv.lang.nuSmvLang.Model;
import reprotool.fm.nusmv.lang.nuSmvLang.Module;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage;
 

public class NuSmvLangJavaValidator extends AbstractNuSmvLangJavaValidator {

	static final public String MISSING_MAIN_MODULE = "NuSmvLangJavaValidator.1";
	
	@Check
	public void checkModelContainsMainModule(Model nusmvModel) {
		for (Module module : nusmvModel.getModules()) {
			if(module instanceof MainModule)
				return;
		}
		error("Main module is missing", NuSmvLangPackage.Literals.MODEL__MODULES, MISSING_MAIN_MODULE);
	}
}
