package reprotool.fm.nusmv.lang.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public class AbstractNuSmvLangJavaValidator extends AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangPackage.eINSTANCE);
		return result;
	}

}
