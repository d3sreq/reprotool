
package reprotool.fm.nusmv.lang;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class NuSmvInputLanguageStandaloneSetup extends NuSmvInputLanguageStandaloneSetupGenerated{

	public static void doSetup() {
		new NuSmvInputLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

