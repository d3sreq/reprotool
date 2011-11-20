package reprotool.ling;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

import org.eclipse.ui.progress.IProgressConstants;
import org.eclipse.ui.PlatformUI;

import reprotool.ling.tools.Lemmatizer;
import reprotool.ling.tools.Parser;
import reprotool.ling.tools.Tagger;
import reprotool.ling.tools.Tokenizer;

/**
 * @author ofiala
 * 
 */
public class LingJob extends Job {

//	 private String resutlText;
	
	private IAction resultAction;
	
	private String originalSentence;	
	private Sentence sentence;
	// ling tools results
	String tokenizedSentence = "";
	String lemmatizedSentence = "";
	String taggedSentence = "";
	String parsedSentence = "";
	 
	/**
	  * Public constructor LingJob
	  *
	  * @param name job name
	  * @param classifier Classifier to be trained
	  */
	 public LingJob(String name, String originalSentence) {
	 	super(name + " \"" + originalSentence + "\"");
	 	this.originalSentence = originalSentence;
	 	
	 	// clickable result of the job
	 	this.resultAction = new Action("Results") {
			public void run() {
		        // Show the results
				// Use this to open a Shell in the UI thread
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						// all tools 
						MessageBox mb = new MessageBox( PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.ICON_INFORMATION | SWT.OK);
						mb.setText("Linguistics analyse results");
						mb.setMessage("Linguistics tools results:\n\n" +
								"Tokenizer result: " + (tokenizedSentence.isEmpty() ? "Error" : "\"" + tokenizedSentence + "\"\n" ) + 
								"Tagger result: " + (taggedSentence.isEmpty() ? "Error" : "\"" + taggedSentence + "\"\n" ) + 
								"Parser result: " + (parsedSentence.isEmpty() ? "Error" : "\"" + parsedSentence + "\"\n" ) + 
								"Lemmatizer result: " + (lemmatizedSentence.isEmpty() ? "Error" : "\"" + lemmatizedSentence + "\"\n" ) +
								"\n");
						mb.open();
					}
				});
			}
		};
	 }	 
	 
	 @Override
	 protected IStatus run(IProgressMonitor monitor) {

 		setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
 		setProperty(IProgressConstants.ACTION_PROPERTY, resultAction);

    	try{
    		long start = System.currentTimeMillis();
    		
    		// calling tokenizer 
    		tokenizedSentence = Tokenizer.getTokens(originalSentence.trim());
    		System.out.println("Tokenizer (" + (System.currentTimeMillis() - start) + "ms): " + tokenizedSentence);
    		
    		// calling tagger 
    		taggedSentence = Tagger.mxposToLisp(Tagger.getMXPOST(tokenizedSentence));
    		System.out.println("Tagger (" + (System.currentTimeMillis() - start) + "ms): " + taggedSentence);
    		
    		// calling parser 
    		parsedSentence = Parser.getString(taggedSentence);
    		System.out.println("Parser (" + (System.currentTimeMillis() - start) + "ms): " + parsedSentence);
    		
    		// parsing into a Sentence object
    		sentence = Parser.parseSentence(parsedSentence);   
    		
    		// calling lemmatizer 
    		sentence = Lemmatizer.getSentence(sentence);
    		for(Word word : sentence.getWords()) {
    			lemmatizedSentence += " " + word.getLemma();
    			lemmatizedSentence = lemmatizedSentence.trim();
    		}
    		System.out.println("Lemmatizer (" + (System.currentTimeMillis() - start) + "ms): " + lemmatizedSentence);
	 		
    	} catch (Exception e){
			e.printStackTrace();  		    		
    	}
    	finally{
    		monitor.done();
    	}    	
    	return Status.OK_STATUS;    	    	
	 }

	 public Sentence getSentence(){
		 return sentence;
	 }
	 
	}