package reprotool.fm.nusmv;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import reprotool.fm.nusmv.mapping.NuSMVProj;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "reprotool.fm.nusmv"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	NuSMVWrapper nusmvWrapper;
	NuSMVProj nusmvProject;
	
	final public NuSMVWrapper getNuSMVWrapper() {
		if(nusmvWrapper == null)
			nusmvWrapper = new NuSMVWrapper();

		return nusmvWrapper;
	}
	
	public NuSMVProj getNuSMVProject() {
		return nusmvProject;
	}
	
	public void setNuSMVProject(NuSMVProj nusmvProject) {
		this.nusmvProject = nusmvProject;
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
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
