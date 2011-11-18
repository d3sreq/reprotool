package reprotool.ling;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressConstants;
import org.eclipse.ui.statushandlers.StatusManager;

import reprotool.ling.analyser.Analyser;
import reprotool.ling.analyser.MatchSentence;
import reprotool.ling.tools.Parser;
import reprotool.ling.tools.Tagger;
import reprotool.ling.tools.Tokenizer;
import reprotool.model.usecase.UseCaseStep;

/**
 * @author ofiala
 * 
 */
public class LingTools {
	
	
	public static void init() {
		Parser.start();		
	}

	/**
	 * Ling tools pipeline
	 * 
	 * @param originalSentence
	 * @return parserSentence
	 */
	public static String parseLingSentence(String originalSentence) {
		
 		String tokenizedSentence = "";
		String taggedSentence = "";
		String parserSentence = "";
		
		// calling tokenizer 
		tokenizedSentence = Tokenizer.getTokens(originalSentence);
		// calling tagger 
		taggedSentence = Tagger.mxposToLisp(Tagger.getMXPOST(tokenizedSentence));
		// calling parser 
		parserSentence = Parser.getString(taggedSentence);
		
		return parserSentence;
	}	
	
	/**
	 * Runs all linguistic tools
	 * 
	 * @param originalSentence
	 * @return
	 */
	public static Sentence parseSentence(String originalSentence) {
		
 		String tokenizedSentence = "";
		String taggedSentence = "";
		String parsedSentence = "";
		
		// calling tokenizer 
		tokenizedSentence = Tokenizer.getTokens(originalSentence.trim());
		System.out.println("Tokenizer: " + tokenizedSentence);
		// calling tagger 
		taggedSentence = Tagger.mxposToLisp(Tagger.getMXPOST(tokenizedSentence));
		System.out.println("Tagger: " + taggedSentence);
		// calling parser 
		parsedSentence = Parser.getString(taggedSentence);
		System.out.println("Parser: " + parsedSentence);
		
		// parsing into a Sentence object
		Sentence sentence = Parser.parseSentence(parsedSentence);
		
		return sentence;
	}
	
	/**
	 * Runs all linguistic tools
	 * 
	 * @param editingDomain
	 * @param ucs
	 * @return CompoundCommand all commands at model objects
	 */
	public static CompoundCommand analyseUseCaseStep(EditingDomain editingDomain, UseCaseStep ucs) {
		// gets UseCaseStep string 
		String sentenceString = ucs.getContent();
		// gets sentence object
		Sentence sentence = LingTools.parseSentence(sentenceString);
		/*
		LingJob job = new LingJob("Linguistics tools", sentenceString);
		//job.setProperty(IProgressConstants.ACTION_PROPERTY, gotoAction);		
		job.schedule();	

		while(!job.getResult().isOK()){
			System.out.println(job.getResult().isOK());
		}
		
		System.out.println(job.getState());
		
		Sentence sentence = job.getSentence();	*/	
		
		if(!MatchSentence.matchSentence(sentenceString, sentence)){
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error during matching UseCaseStep.content to Sentence object", null);
			StatusManager.getManager().handle(status, StatusManager.LOG);
		}

		CompoundCommand command = Analyser.analyseTree(editingDomain, ucs, sentence);
		System.out.println("Linguistics - created command - END.");
		
		return command;
	}	
	
	
	
	public static void initJob() {
		Job job = new Job("Linguistics tools initialization") {
		    @Override
		    public IStatus run(IProgressMonitor monitor) {
		    	setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
		    	try{
		    		monitor.beginTask("MXPost tagger initialization....", 100);
		    		monitor.worked(1);
		    		Tagger.getMXPOST("Open application");	
		    		monitor.worked(5);		    		
		    		
		    		monitor.beginTask("Parser initialization....", 100);
		    		monitor.worked(10);
		    		Parser.start();	
		    		
			    	if(monitor.isCanceled()){
			    		return Status.CANCEL_STATUS;
			    	}
			    	monitor.worked(100);
		    	} catch (Exception e){}
		    	finally{
		    		monitor.done();
		    	}
		    	return Status.OK_STATUS;
		    }
		};
		IAction showReportAction = new Action("Results") {
			public void run() {
				// all tools 
				MessageBox mb = new MessageBox( PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.ICON_INFORMATION | SWT.OK);
				mb.setText("Linguistics tools initialization");
				mb.setMessage("Parser inicialization: " + (Parser.isReady() ? "OK" : "Error" ) + "\n");
				mb.open();
			}
		};
		job.setProperty(IProgressConstants.ACTION_PROPERTY, showReportAction);		
		job.schedule();	
	}	
	
}
