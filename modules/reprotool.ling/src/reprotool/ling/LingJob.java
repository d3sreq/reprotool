package reprotool.ling;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.progress.IProgressConstants;

import reprotool.ling.tools.Tagger;

public class LingJob extends Job {
	 private String originalText;
	 private String resutlText;
	 private IAction resultAction;
	 
	/**
	  * Public constructor LingJob
	  *
	  * @param name job name
	  * @param classifier Classifier to be trained
	  */
	 public LingJob(String name, String inputText) {
	 	super(name);
	 	this.originalText = inputText;
	 	this.resutlText = "";
	 	
	 	// clickable result of the job
	 	this.resultAction = new Action("Results") {
			public void run() {
		         // Show the results
				JOptionPane.showMessageDialog(null, "input: " + originalText + "\noutput: " + resutlText,"MX POS tagger",JOptionPane.INFORMATION_MESSAGE);
			}
		};
	 }	 
	 
	 @Override
	 protected IStatus run(IProgressMonitor monitor) {

 		setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
 		setProperty(IProgressConstants.ACTION_PROPERTY, resultAction);
		String innerText = "";
    	try{
    		// calling tagger (whole work)
    		innerText = Tagger.getMXPOST(originalText);
    	} catch (Exception e){
			e.printStackTrace();  		    		
    	}
    	finally{
    		resutlText = innerText;
    		monitor.done();
    	}    	
    	return Status.OK_STATUS;
    	    	
	 }

	 public String returnText(){
		 return this.resutlText;
	 }
	 
	}