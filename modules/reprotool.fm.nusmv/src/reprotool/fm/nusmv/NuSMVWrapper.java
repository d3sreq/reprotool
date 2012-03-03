package reprotool.fm.nusmv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipselabs.nusmvtools.counterexample.CounterExampleType;
import org.eclipselabs.nusmvtools.counterexample.DocumentRoot;
import org.eclipselabs.nusmvtools.counterexample.NodeType;
import org.eclipselabs.nusmvtools.counterexample.StateType;
import org.eclipselabs.nusmvtools.counterexample.ValueType;
import org.eclipselabs.nusmvtools.counterexample.util.CounterexampleResourceFactoryImpl;
import org.eclipselabs.nusmvtools.nusmv4j.CLibrary;
import org.eclipselabs.nusmvtools.nusmv4j.NuSMV4J;
import org.eclipselabs.nusmvtools.nusmv4j.NusmvLibrary;
import org.eclipselabs.nusmvtools.nusmv4j.NusmvLibrary.PropDb_TAG;
import org.eclipselabs.nusmvtools.nusmv4j.NusmvLibrary.Prop_TAG;
import org.eclipselabs.nusmvtools.nusmv4j.NusmvLibraryUtil;

import reprotool.fm.nusmv.mapping.NuSMVProj;
import reprotool.model.swproj.CounterExample;
import reprotool.model.swproj.Step;
import reprotool.model.swproj.SwprojFactory;
import reprotool.model.swproj.UseCaseTransition;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.annotate.TemporalLogicFormula;


public class NuSMVWrapper {

	private static final String COUNTER_EXAMPLE_FILE = "counterexample.xml";
	
	private NusmvLibrary nusmvLib;

	private MessageConsole con = Activator.getDefault().findConsole();
	private MessageConsoleStream out = con.newMessageStream();
	private NuSMVProj nusmvProject;
	private CounterExample counterExample;
	private HashMap<UseCaseTransition, Step> branchingStep = new HashMap<UseCaseTransition, Step>();
	private File errFile;
	
	public NuSMVWrapper() {		
		nusmvLib = NuSMV4J.INSTANCE().getNusmvLibrary();
		counterExample = SwprojFactory.eINSTANCE.createCounterExample();
				
		out.println("NuSMV native library build date : " + nusmvLib.NuSMVCore_get_build_date().getString(0));
		out.println("NuSMV native library version    : " + nusmvLib.NuSMVCore_get_library_version().getString(0));
		out.println("Generated JNA interface version : " + NusmvLibrary.NUSMV_LIBRARY_VERSION);
		
		execCommand("set default_trace_plugin 4");
		out.println("(this message is shown only when nusmv is initialized)");
		out.println("------------------------------------------------------");
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
        execCommand("read_model -i \"" + absoluteFileLocation + "\"");
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
	final public boolean checkInlineSpec(NuSMVProj nusmvProj, LogicFormulaType formulaType) {
	    switch (formulaType) {
		case CTL:
		    out.println("Checking all inline CTLSPEC");
		    break;
		case LTL:
		    out.println("Checking all inline LTLSPEC");
		    break;
		}
	    
		errFile = new File("reprotool_nusmv_stderr.txt");
        
        NusmvLibrary.nusmv_stderr.set(nusmvLib.CmdOpenFile(errFile.getName()));
	    nusmvProject = nusmvProj;
	    counterExample.getUseCaseTransitions().clear();
	    counterExample.setFormula(null);
	    counterExample.setProject(nusmvProject.getSoftwareProject());
	    branchingStep.clear();
	    
	    boolean counterExampleGenerated = true;
	    
		execCommand("reset");
		execCommand("go");
		
		switch (formulaType) {
		case CTL:
			execCommand("check_ctlspec -o " + COUNTER_EXAMPLE_FILE);
			break;
		case LTL:
			execCommand("check_ltlspec -o " + COUNTER_EXAMPLE_FILE);
			break;
		}
		
		try {
			File origFile = new File(COUNTER_EXAMPLE_FILE);
			
			if( ! origFile.exists() ) {
				out.println("no counterexample generated");
				CLibrary.INSTANCE.fflush(NusmvLibrary.nusmv_stderr.get());
				
				if (errFile.length() > 0) {
					BufferedReader in = new BufferedReader(new FileReader(errFile));
					String line;
					out.println("\nERROR(S) FOUND IN THE INPUT NUSMV FILE !!!");
					while ((line = in.readLine()) != null) {
						out.println(line);
					}
				}
				
				errFile.delete();
				return false;
			}
			
			BufferedReader reader = new BufferedReader( new FileReader(origFile));
			File tmpFile = File.createTempFile(COUNTER_EXAMPLE_FILE, ".xml");
			BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile));
			
			String line;
			while( null != (line = reader.readLine()) ) {
				if (line.contains("</counter-example>")) {
					writer.write(line);
					writer.newLine();
					break;
				}
				if( ! line.startsWith("-- ") ) {
					writer.write(line);
					writer.newLine();
				} else {
					out.println(line);
					if (line.matches("-- specification .* is false")) {
						Pattern myPattern = Pattern.compile("-- specification (.*) is false");
						Matcher m = myPattern.matcher(line);
						if (m.find()) {
							String expandedFormula = m.group(1);
							String s = expandedFormula;
							expandedFormula = expandedFormula.replaceAll("\\s+", "");
							expandedFormula = expandedFormula.replaceAll("[()]", "");
							TemporalLogicFormula tf = nusmvProject.getFormula(expandedFormula);
							Assert.isNotNull(tf);
							counterExample.setFormula(tf);
							counterExample.setCause(tf.getDescription() + " [" + s + "]");
						}
					}
				}
			}
			writer.close();
			reader.close();
			origFile.delete();
			
			if(tmpFile.length() > 0) {
				String str = tmpFile.toURI().toString();
				displayCounterExampleFile(str);
			} else {
				out.println("empty counterexample generated");
				counterExampleGenerated = false;
			}
			tmpFile.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		errFile.delete();
		return counterExampleGenerated;
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
	    	return;
	    }
	    execCommand("show_traces -a -o \"" + COUNTER_EXAMPLE_FILE + "\"");
	    displayCounterExampleFile(COUNTER_EXAMPLE_FILE);
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

		final String loopStart = counterExample.getLoops().trim();
		
		out.println("FAILED : " + counterExample.getDesc());
		for (NodeType node : counterExample.getNode()) {
			
			for (StateType state : node.getState()) {
				final String stateId = state.getId().trim();
				out.println("  State: " + stateId + " = " + (stateId.equals(loopStart) ? "Loop starts here" : ""));
				for (ValueType var : state.getValue()) {
					if (!"FALSE".equals(var.getValue()))
						out.println("    - " + var.getVariable() + " = "
								+ var.getValue());
					if (var.getVariable().matches("x.*\\.s")) {
						NuSMVParser.processVariable(var.getVariable(), var.getValue(),
								nusmvProject, this.counterExample, branchingStep);
					}
				}
			}
		}
		if( ! loopStart.isEmpty()) {
			out.println("Loops to state " + loopStart);
		}
	}
		
	public CounterExample getCounterExample() {		
		if (!branchingStep.isEmpty()) {
			for (UseCaseTransition ucTrans : branchingStep.keySet()) {
				Step step = branchingStep.get(ucTrans);
				Step pred = null;
				Assert.isNotNull(ucTrans);
				
				if (ucTrans.getSteps().isEmpty()) {
					Scenario s = (Scenario) ucTrans.getUseCase().getMainScenario();
					UseCaseStep missingStep = s.getSteps().get(0);
					Assert.isNotNull(missingStep);
					step.setUcStep(missingStep);
					ucTrans.getSteps().add(step);
					
				} else {
					for (Step s: ucTrans.getSteps()) {
						if (s == step) {
							break;
						}
						pred = s;
					}
					Assert.isNotNull(pred);
					Assert.isTrue(pred.getUcStep().eContainer() instanceof Scenario);
					Scenario s = (Scenario) pred.getUcStep().eContainer();
					int i = s.getSteps().indexOf(pred.getUcStep());
					UseCaseStep missingStep = s.getSteps().get(i + 1);
					Assert.isNotNull(missingStep);
					step.setUcStep(missingStep);
					ucTrans.getSteps().add(step);
				}
			}
		}
		
		return counterExample;
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
