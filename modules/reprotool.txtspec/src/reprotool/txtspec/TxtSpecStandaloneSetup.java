
package reprotool.txtspec;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TxtSpecStandaloneSetup extends TxtSpecStandaloneSetupGenerated{

	public static void doSetup() {
		new TxtSpecStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

