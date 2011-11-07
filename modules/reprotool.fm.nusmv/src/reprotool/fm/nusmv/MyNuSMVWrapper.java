package reprotool.fm.nusmv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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


public class MyNuSMVWrapper {

	private static final String COUNTER_EXAMPLE_FILE = "counterexample.xml";

	private NusmvLibrary nusmvLib;

	private MessageConsole con = findConsole(Activator.PLUGIN_ID);
	private MessageConsoleStream out = con.newMessageStream();
	private List<String> stateTrace = new ArrayList<String>();
	private boolean testResult = false;
	
	public MyNuSMVWrapper() {
		nusmvLib = NuSMV4J.INSTANCE().getNusmvLibrary();
		
		// disable console output from NuSMV
	    //NusmvLibrary.nusmv_stdout.set(nusmvLib.CmdOpenFile( new File("/dev/null").getAbsolutePath() ));
		
		out.println("NuSMV native library build date : " + nusmvLib.NuSMVCore_get_build_date().getString(0));
		out.println("NuSMV native library version    : " + nusmvLib.NuSMVCore_get_library_version().getString(0));
		out.println("Generated JNA interface version : " + NusmvLibrary.NUSMV_LIBRARY_VERSION);
		
		execCommand("set default_trace_plugin 4");
		out.println("(this message is shown only when nusmv is initialized)");
		out.println("------------------------------------------------------");
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
	 * Loads the SMV code from given IFile
	 * 
	 * @param file
	 */
	final public void loadModelFile(IFile file) {
		loadModelFile( file.getLocation().toOSString() );
	}
	
	/**
	 * Loads the SMV code from a file specified by absolute path in the local
	 * file system.
	 * 
	 * @param absoluteFileLocation
	 */
	final public void loadModelFile(String absoluteFileLocation) {
		out.println("Reading SMV model from:" + absoluteFileLocation );
		execCommand("reset");
        execCommand("read_model -i " + absoluteFileLocation);
	}
	
	/**
	 * @param command NuSMV command
	 */
	final public void execCommand(String command) {
		System.out.println("Executing NuSMV command: " + command);
		NusmvLibraryUtil.executeCommand(nusmvLib, command);
	}
	
	/**
	 * Checks all CTL formulae written within the SMV code as CTLSPEC.
	 */
	final public void checkInlineCTLSpec() {
		
	    out.println("Checking all inline CTLSPEC");
	    
		execCommand("reset");
		execCommand("go");
		execCommand("check_ctlspec -o " + COUNTER_EXAMPLE_FILE);
		try {
			File origFile = new File(COUNTER_EXAMPLE_FILE);
			
			if( ! origFile.exists() ) {
				out.println("no counterexample generated, perhaps syntax error");
				return;
			}
			
			BufferedReader reader = new BufferedReader( new FileReader(origFile));
			File tmpFile = File.createTempFile(COUNTER_EXAMPLE_FILE, ".xml");
			BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile));
			
			String line;
			while( null != (line = reader.readLine()) ) {
				if( ! line.startsWith("-- ") ) {
					writer.write(line);
					writer.newLine();
				} else {
					out.println(line);
				}
			}
			writer.close();
			reader.close();
			origFile.delete();
			if(tmpFile.length() > 0) {
				displayCounterExampleFile( "file://" + tmpFile.getAbsolutePath() );
			} else
				out.println("empty counterexample generated");
			tmpFile.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Check CTL specification and print counter-example.
	 * @param ctlSpec CTL formula to be checked
	 * @param description Textual description of the formula
	 * @throws Exception 
	 */
	final public void checkCTLSpec(String ctlDescr, String ctlSpec) throws Exception {

	    out.print("Checking: " + ctlDescr + " .. ");
	    
		execCommand("reset");
		execCommand("go");

		execCommand("check_ctlspec -p \"" + ctlSpec + "\"");
		collectCheckerResults();
	}

	/**
	 * Collects counterexample from the model-checker.
	 * @throws Exception
	 */
	public void collectCheckerResults() throws Exception {
		PropDb_TAG db = nusmvLib.PropPkg_get_prop_database();
		
		if( nusmvLib.PropDb_get_size(db) == 0)
			throw new Exception("NuSMV error, see STDERR");
		
	    final Prop_TAG prop = nusmvLib.PropDb_get_last( db );
	    
	    String status = nusmvLib.Prop_get_status_as_string(prop).getString(0);
	    if( "True".equals(status) )
	    {

	    	out.println("OK");
	    	testResult = true;
	    	return;
	    }
	    testResult = false;
	    execCommand("show_traces -a -o " + COUNTER_EXAMPLE_FILE);
	    
	    stateTrace.clear();
	    displayCounterExampleFile(COUNTER_EXAMPLE_FILE);

	}
	
	public boolean getTestResult() {
		return testResult;
	}
	
	private void displayCounterExampleFile(String fileName) {
		// open the generated XML file containing the counter-example as EMF
		// model
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xml", new CounterexampleResourceFactoryImpl());
		final URI uri = URI.createURI(fileName);
		final ResourceSet rs = new ResourceSetImpl();
		final Resource resource = rs.getResource(uri, true);
		
		try {
			resource.load(null);
		} catch (IOException e) {
			out.print(e.getMessage());
			return;
		}

		// now we have got the EMF model
		final CounterExampleType counterExample = ((DocumentRoot) resource
				.getContents().get(0)).getCounterExample();

		out.println("FAILED : " + counterExample.getDesc());
		for (NodeType node : counterExample.getNode()) {
			for (StateType state : node.getState()) {
				out.println("  State: " + state.getId() + " = ");
				for (ValueType var : state.getValue()) {
					if (!"FALSE".equals(var.getValue()))
						out.println("    - " + var.getVariable() + " = "
								+ var.getValue());
					if (var.getVariable().equals("x1.s")) {
						if (stateTrace.isEmpty()) {
							stateTrace.add(var.getValue());
						} else {
							String lastState = stateTrace.get(stateTrace.size() - 1);
							if (!var.getValue().equals(lastState)) {
								stateTrace.add(var.getValue());
							}
						}
					}
				}
			}
		}
	}
	
	public List<String> getStateTrace() {
		return stateTrace;
	}
	
	/**
	 * Clears the console view.
	 */
	final public void clearConsole() {
		con.activate();
		con.clearConsole();
	}

	/**
	 * Print the message to the console view.
	 * @param message
	 */
	final public void printMessage(String message) {
		out.println(message);
	}

}
