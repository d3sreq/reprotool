package reprotool.ide.views;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.IProgressConstants;

import reprotool.ling.wordnet.WordNet;

public class LinguisticToolsView extends ViewPart {

	public static final String ID = "cz.cuni.mff.reprotool.ide.views.LinguisticToolsView"; //$NON-NLS-1$

	public LinguisticToolsView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);

		// TODO wireframe only
		treeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
            public void dispose() {
	            // TODO Auto-generated method stub
	            
            }

			@Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	            // TODO Auto-generated method stub
	            
            }

			@Override
            public Object[] getElements(Object inputElement) {
	            return new String[] { "tokenizer [running]", "parser [running]", "tagger [running]"
	            		, "bad: " + WordNet.getAntonyms("bad").toString()
	            };
            }
  		
			
			@Override
            public Object[] getChildren(Object parentElement) {
	            // TODO Auto-generated method stub
	            return null;
            }

			@Override
            public Object getParent(Object element) {
	            // TODO Auto-generated method stub
	            return null;
            }

			@Override
            public boolean hasChildren(Object element) {
	            // TODO Auto-generated method stub
	            return false;
            }
			
		});

		// TODO wireframe only
		treeViewer.setInput(new Object());
		
		createActions();
		initializeToolBar();
		initializeMenu();
		
		externalJob();
		testJob();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
//		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
//		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	/**
	 * External job.
	 */
	private void externalJob() {
		Job job = new Job("External job") {
		    @Override
		    public IStatus run(IProgressMonitor monitor) {
		    	setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
		    	try{
			    	monitor.beginTask("Ping....", 100);
		    		String[] cmd = {"/bin/sh", "-c", "ping -c10 www.seznam.cz"};
		    		Process p = Runtime.getRuntime().exec(cmd);
		    		BufferedReader in = new BufferedReader(  
		    				new InputStreamReader(p.getInputStream()));  
		    		String line = null;  
		    		while ((line = in.readLine()) != null) {  
		    			//System.out.println(line);  
				    	monitor.worked(10);
				    	monitor.subTask(line.concat("test"));
		    		}
		    	} catch (Exception e){
	    			e.printStackTrace();  		    		
		    	}
		    	finally{
		    		monitor.done();
		    	}
		    	return Status.OK_STATUS;
		    }
		};
		job.schedule();	
	}	

	/**
	 * Dummy test job.
	 */
	private void testJob() {
		Job job = new Job("Test job") {
		    @Override
		    public IStatus run(IProgressMonitor monitor) {
		    	setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
		    	try{
			    	monitor.beginTask("Init....", 100);
			        Thread.sleep(2000);    
			    	monitor.worked(20);
			        Thread.sleep(2000);    
			    	monitor.worked(20);
			        Thread.sleep(2000);    
			    	monitor.worked(20);
			    	monitor.subTask("Sub...");
			        Thread.sleep(2000);    
			    	monitor.worked(50);
			    	
			    	if(monitor.isCanceled()){
			    		return Status.CANCEL_STATUS;
			    	}
			        Thread.sleep(2000);  
			    	monitor.worked(100);
		    	} catch (Exception e){}
		    	finally{
		    		monitor.done();
		    	}
		    	return Status.OK_STATUS;
		    }
		};
		IAction gotoAction = new Action("Results") {
			public void run() {
		         // Show the results
			}
		};
		job.setProperty(IProgressConstants.ACTION_PROPERTY, gotoAction);		
		job.schedule();	
	}	
	
	@Override
	public void setFocus() {
		// Set the focus
	}
}
