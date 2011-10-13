package reprotool.ide.editors.usecase;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * Composite containing TreeViewer with use case steps.
 * Class is expected to be modified with visual editor (window builder pro).
 * 
 * @author jvinarek
 * 
 */
public class UsecaseEMFEditorComposite extends Composite {

	private TreeViewer treeViewer;

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

		treeViewer = new TreeViewer(this, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);

		labelColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		labelColumn.getColumn().setWidth(100);
		labelColumn.getColumn().setText("Label");

		textColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		textColumn.getColumn().setWidth(400);
		textColumn.getColumn().setText("Text");

	}

	public TreeViewer getTreeViewer() {
		return treeViewer;
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
