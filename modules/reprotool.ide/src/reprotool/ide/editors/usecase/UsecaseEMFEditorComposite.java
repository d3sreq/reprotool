package reprotool.ide.editors.usecase;

import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

/**
 * Composite containing TreeViewer with use case steps and editor
 * to change use case step. 
 * Class is expected to be modified with visual editor (window builder pro).
 * 
 * @author jvinarek
 *
 */
public class UsecaseEMFEditorComposite extends Composite {

	private TreeViewer treeViewer;
	private TextViewer textViewer;
	
	private TreeViewerColumn labelColumn;
	private TreeViewerColumn textColumn;
	
	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public UsecaseEMFEditorComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);

		treeViewer = new TreeViewer(sashForm, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		
		labelColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		labelColumn.getColumn().setWidth(100);
		labelColumn.getColumn().setText("Label");
		
		textColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		textColumn.getColumn().setWidth(400);
		textColumn.getColumn().setText("Text");

		textViewer = new TextViewer(sashForm, SWT.BORDER);
		sashForm.setWeights(new int[] { 215, 82 });

	}

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	public TextViewer getTextViewer() {
		return textViewer;
	}
	
	public TreeViewerColumn getLabelColumn() {
		return labelColumn;
	}

	public TreeViewerColumn getTextColumn() {
		return textColumn;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
