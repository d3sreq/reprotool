package reprotool.ling;

import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	// The plug-in ID
	public static final String PLUGIN_ID = "reprotool.ling"; //$NON-NLS-1$
	
	// The shared instance
	private static Activator plugin;
	
	public static BundleContext getContext() {
		return context;
	}

	
	/**
	 * Creating a new console within the running Eclipse instance.
	 * @param name
	 * @return 
	 */
	public MessageConsole findConsole() {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager consoleManager = plugin.getConsoleManager();

		for (IConsole console : consoleManager.getConsoles()) {
			if (PLUGIN_ID.equals(console.getName())) {
				return (MessageConsole) console;
			}
		}

		MessageConsole console = new MessageConsole(PLUGIN_ID, null);
		consoleManager.addConsoles(new IConsole[] { console });

		return console;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		Activator.context = null;
	}
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
