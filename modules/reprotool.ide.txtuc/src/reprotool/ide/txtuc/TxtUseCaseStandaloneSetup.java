
package reprotool.ide.txtuc;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class TxtUseCaseStandaloneSetup extends TxtUseCaseStandaloneSetupGenerated{

	public static void doSetup() {
		new TxtUseCaseStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

