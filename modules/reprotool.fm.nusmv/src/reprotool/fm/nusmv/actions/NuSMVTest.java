package reprotool.fm.nusmv.actions;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipselabs.nusmvtools.counterexample.CounterExampleType;
import org.eclipselabs.nusmvtools.counterexample.DocumentRoot;
import org.eclipselabs.nusmvtools.counterexample.NodeType;
import org.eclipselabs.nusmvtools.counterexample.StateType;
import org.eclipselabs.nusmvtools.counterexample.ValueType;
import org.eclipselabs.nusmvtools.counterexample.util.CounterexampleResourceFactoryImpl;
import org.eclipselabs.nusmvtools.nusmv4j.NuSMV4J;
import org.eclipselabs.nusmvtools.nusmv4j.NusmvLibrary;
import org.eclipselabs.nusmvtools.nusmv4j.NusmvLibrary.PropDb_TAG;
import org.eclipselabs.nusmvtools.nusmv4j.NusmvLibrary.Prop_TAG;
import org.eclipselabs.nusmvtools.nusmv4j.NusmvLibraryUtil;
import org.osgi.framework.Bundle;

import reprotool.fm.nusmv.Activator;
import reprotool.model.swproj.SoftwareProject;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class NuSMVTest implements IWorkbenchWindowActionDelegate {
	
	private NusmvLibrary nusmvLib;

	private static final String MODEL_FILE = "examples/uctest3.smv";
	private static final String COUNTER_EXAMPLE_FILE = "counterexample.xml";

	private MessageConsole con = findConsole(Activator.PLUGIN_ID);
	private MessageConsoleStream out = con.newMessageStream();
	
	/**
	 * Converts a file name relative to the bundle location to an absolute
	 * path to the file.
	 * 
	 * @param bundleFileString location relative to the bundle directory
	 * @return absolute path to the file within file system
	 */
	private String bundleFileToAbsoluteFile(String bundleFileString) {
		Bundle bundle = Platform.getBundle( Activator.PLUGIN_ID );
        URL fileURL = bundle.getEntry(bundleFileString);
        
		try {
			return FileLocator.resolve(fileURL).getFile();
		} catch (IOException e) {
			return fileURL.toExternalForm();
		}
	}
	
	/**
	 * The constructor.
	 */
	public NuSMVTest() {
		
		nusmvLib = NuSMV4J.INSTANCE().getNusmvLibrary();
		
		// disable console output from NuSMV
	    //NusmvLibrary.nusmv_stdout.set(nusmvLib.CmdOpenFile(new File("/dev/null").getAbsolutePath()));
		
		out.println("NuSMV native library build date : " + nusmvLib.NuSMVCore_get_build_date().getString(0));
		out.println("NuSMV native library version    : " + nusmvLib.NuSMVCore_get_library_version().getString(0));
		out.println("Generated JNA interface version : " + NusmvLibrary.NUSMV_LIBRARY_VERSION);
		
		String modelFile = bundleFileToAbsoluteFile(MODEL_FILE);
		
		out.println("Reading SMV code from:" + modelFile );
        execCommand("read_model -i " + modelFile);

		execCommand("set default_trace_plugin 4");
	}

	/**
	 * Creating a new console within the running Eclipse instance.
	 * @param name
	 * @return 
	 */
	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager consoleManager = plugin.getConsoleManager();

		for (IConsole console : consoleManager.getConsoles()) {
			if (name.equals(console.getName())) {
				return (MessageConsole) console;
			}
		}

		MessageConsole console = new MessageConsole(name, null);
		consoleManager.addConsoles(new IConsole[] { console });

		return console;
	}
	
	/**
	 * @param command NuSMV command
	 */
	private void execCommand(String command) {
		NusmvLibraryUtil.executeCommand(nusmvLib, command);
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		con.activate();
		con.clearConsole();
		
		execCommand("reset");
		execCommand("go");
		
		checkCTLSpec( "After 'open' there should always be 'close'",
				"AG(open_x -> AF(close_x))" );
		
		checkCTLSpec( "No multi-open without close",
				"AG(open_x -> AX(A[!open_x U close_x]))" );
		
		checkCTLSpec( "No multi-close without open",
				"AG(close_x -> AX(A[!close_x U open_x | !AF(close_x) ]))" );
		
		checkCTLSpec( "First 'open' then 'close'",
				"A[!close_x U open_x | !AF(close_x)]" );
		
		checkCTLSpec( "After 'create' there must be some branch containing 'use'",
				"AG( create_item -> EF(use_item) )" );
		
		checkCTLSpec( "Only one 'create'",
				"AG( create_item -> AX(AG(!create_item)) )" );
		
		checkCTLSpec( "No 'use' before 'create'",
				"A[ !use_item U create_item | !AF(use_item)]" );
		
	}
	
	/**
	 * Check CTL specification and print counter-example.
	 * @param ctlSpec CTL formula to be checked
	 * @param description Textual description of the formula
	 */
	private void checkCTLSpec(String ctlDescr, String ctlSpec) {

	    out.print("Checking: " + ctlDescr + " .. ");
		execCommand("check_ctlspec -p \"" + ctlSpec + "\"");

		PropDb_TAG db = nusmvLib.PropPkg_get_prop_database();
	    final Prop_TAG prop = nusmvLib.PropDb_get_last( db );
	    int traceId = nusmvLib.Prop_get_trace(prop);
	    
	    if(traceId == 0) {
	    	out.println("OK");
	    	return;
	    }
	    
	    execCommand("show_traces -o " + COUNTER_EXAMPLE_FILE + " " + traceId);

	    // open the generated XML file containing the counter-example as EMF model
	    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml", new CounterexampleResourceFactoryImpl());
	    final URI uri = URI.createURI(COUNTER_EXAMPLE_FILE);
	    final ResourceSet rs = new ResourceSetImpl();
	    final Resource resource = rs.getResource(uri, true);
	    try {
			resource.load(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// now we have got the EMF model
	    final CounterExampleType counterExample = ((DocumentRoot) resource.getContents().get(0)).getCounterExample();
	    
	    out.println("FAILED : " + counterExample.getDesc());
	    for (NodeType node : counterExample.getNode()) {
	    	for (StateType state : node.getState()) {
	    		out.println("  State: " + state.getId() + " = ");
				for (ValueType var : state.getValue()) {
					if( "TRUE".equals(var.getValue()) && ! var.getVariable().startsWith("x."))
						out.println( "    - " + var.getVariable() );
				}
			}
		}
	}
	
	/**
	 * TODO: load sample project from XMI and generate SMV code
	 * @return model of a software project from XMI
	 */
	private SoftwareProject generateTestingReprotoolModel() {
		
		ResourceSet resourceSet = new ResourceSetImpl();
		URI sampleModelUri = URI.createURI("examples/SampleSoftwareProject.xmi");
		Resource resource = resourceSet.getResource(sampleModelUri, true);

		return (SoftwareProject) resource.getContents().get(0);		
	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
	}
}