
package reprotool.fm.nusmv.lang;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class NuSmvLangStandaloneSetup extends NuSmvLangStandaloneSetupGenerated{

	public static void doSetup() {
		new NuSmvLangStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

