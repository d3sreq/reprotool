package reprotool.ide.views;

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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.IProgressConstants;

import reprotool.ling.wordnet.WordNet;
import reprotool.ling.tools.*;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class LinguisticToolsView extends ViewPart {

	public static final String ID = "cz.cuni.mff.reprotool.ide.views.LinguisticToolsView"; //$NON-NLS-1$
	private Text txtTextTestovaci;
	private Text textInput;
	private Text textTokenizer;

	public LinguisticToolsView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		
		textInput = new Text(parent, SWT.BORDER);
		textInput.setText("asj hasd hja!sjk hd didn't sd564!f6sd5");
		
		Button btnAnalyze = new Button(parent, SWT.NONE);
		btnAnalyze.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textTokenizer.setText(Tokenizer.getTokens(textInput.getText()).toString());
			}
		});
		
		btnAnalyze.setText("Analyze");
		
		textTokenizer = new Text(parent, SWT.BORDER);
		GroupLayout gl_parent = new GroupLayout(parent);
		gl_parent.setHorizontalGroup(
			gl_parent.createParallelGroup(GroupLayout.LEADING)
				.add(gl_parent.createSequentialGroup()
					.addContainerGap()
					.add(gl_parent.createParallelGroup(GroupLayout.LEADING)
						.add(textInput, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
						.add(btnAnalyze)
						.add(textTokenizer, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_parent.setVerticalGroup(
			gl_parent.createParallelGroup(GroupLayout.LEADING)
				.add(gl_parent.createSequentialGroup()
					.addContainerGap()
					.add(textInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(btnAnalyze)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(textTokenizer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(373, Short.MAX_VALUE))
		);
		parent.setLayout(gl_parent);
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		txtTextTestovaci = new Text(container, SWT.BORDER);
		txtTextTestovaci.setText("text testovaci");
		
		TreeViewer treeViewer = new TreeViewer(container, SWT.BORDER);
		//TreeViewer treeViewer = new TreeViewer(containertnNewButton = new Button(container, SWT.NONE);
		//btnNewB	treeViewer.setContentProvider(new ITreeContentProvider() {

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
				/* TODO: vysvetlit navratovoui hodnotu
	            return new String[] { "tokenizer [running]", "parser [running]", "tagger [running]"
	            		, "bad: " + WordNet.getAntonyms("bad").toString(),
	            		Tokenizer.getTokens("asj hasd hja!sjk hd didn't sd564!f6sd5").toString()
	            };*/
	            return new String[] { "tokenizer [running]", "parser [running]", "tagger [running]" };
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
			    	// ukazka vypisu z externi aplikace
		    		/* String[] cmd = {"/bin/sh", "-c", "ping -c10 www.seznam.cz"};
		    		Process p = Runtime.getRuntime().exec(cmd);
		    		BufferedReader in = new BufferedReader(  
		    				new InputStreamReader(p.getInputStream()));  
		    		String line = null;  
		    		while ((line = in.readLine()) != null) {  
		    			//System.out.println(line);  
				    	monitor.worked(10);
				    	monitor.subTask(line.concat("test"));
		    		}*/
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
