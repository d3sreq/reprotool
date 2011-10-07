package reprotool.ling;

import java.util.Iterator;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressConstants;

import reprotool.ling.tools.Tagger;
import reprotool.ling.tools.Tokenizer;

public class LingJob extends Job {
	 private String originalText;
	 private String resutlText;
	 private IAction resultAction;
	 private Object lingobject;
	 
	/**
	  * Public constructor LingJob
	  *
	  * @param name job name
	  * @param classifier Classifier to be trained
	  */
	 public LingJob(String name, String inputText, Object lingobject) {
	 	super(name);
	 	this.originalText = inputText;
	 	this.resutlText = "";
	 	this.lingobject = lingobject;
	 	
	 	
	 	// clickable result of the job
	 	this.resultAction = new Action("Results") {
			public void run() {
		        // Show the results
				// Use this to open a Shell in the UI thread
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						MessageDialog.openInformation(
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
								"MX POS tagger results", "INPUT:\n" + originalText + "\n\nOUTPUT:\n" + resutlText);
						
					}
				});
				//JOptionPane.showMessageDialog(null, "input: " + originalText + "\noutput: " + resutlText,"MX POS tagger",JOptionPane.INFORMATION_MESSAGE);
			}
		};
	 }	 
	 
	 @Override
	 protected IStatus run(IProgressMonitor monitor) {

 		setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
 		setProperty(IProgressConstants.ACTION_PROPERTY, resultAction);
 		String tokenizedText = "";
		String innerText = "";
		String verb = "test_VBR";
		String noun = "test_NN";
    	try{
    		if(lingobject == null) {
    			JOptionPane.showMessageDialog(null, "null object","Object check",0);
    		}
    		// calling tokenizer 
    		tokenizedText = Tokenizer.getTokens(originalText);
    		// calling tagger 
    		innerText = Tagger.getMXPOST(tokenizedText);
    		
    		JOptionPane.showMessageDialog(null, innerText,"Text Message",0);
    		
			//WordNet.open();
			
			Sentence sentence = new Sentence(innerText);

        	Iterator<WordLing> iword = sentence.words.iterator();
        	Boolean goon = true;
        	int i = 0;
        	for(i = 0; (goon && i<sentence.words.size()); i++){
        		if(sentence.words.get(i).POS.contains("VBP")){ 
        			verb = sentence.words.get(i).text;
        			goon = false;
        		}       		
        		if(sentence.words.get(i).POS.contains("NN")){ 
        			noun = sentence.words.get(i).text;
        		} 
        	}
			
			/*Sentence negation = sentence.getNegation();
			textNegation.setText(negation.toString());
			//JOptionPane.showMessageDialog(null, sentence.words.get(0).text,"Text Message",0);
			WordNet.close();  */  		    		
    		
    		
    	} catch (Exception e){
			e.printStackTrace();  		    		
    	}
    	finally{
    		resutlText = innerText;
    		//IViewRegistry viewRegistry = PlatformUI.getWorkbench().getViewRegistry();
    		//descr = PlatformUI.getWorkbench().getViewRegistry().find("cz.cuni.mff.reprotool.ide.views.LinguisticToolsView"); 
    		//return (descr != null) ? descr.getLabel() : null; 
    		
    		//PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()["cz.cuni.mff.reprotool.ide.views.LinguisticToolsView"].close();
    		
    		monitor.done();
    	}    	
    	return Status.OK_STATUS;
    	    	
	 }

	 public String returnText(){
		 return this.resutlText;
	 }
	 
	}