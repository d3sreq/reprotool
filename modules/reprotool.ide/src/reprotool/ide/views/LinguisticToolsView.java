package reprotool.ide.views;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

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

	@Override
	public void setFocus() {
		// Set the focus
	}
}
