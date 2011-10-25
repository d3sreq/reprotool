package reprotool.ide.editors.usecase;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.SWTResourceManager;

/**
 * Composite containing TreeViewer with use case steps. Class is expected to be
 * modified with visual editor (window builder pro).
 * 
 * @author jvinarek
 * 
 */
public class UsecaseEMFEditorComposite extends Composite {

	private TreeViewer treeViewer;

	private TreeViewerColumn labelColumn;
	private TreeViewerColumn textColumn;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtUseCaseName;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public UsecaseEMFEditorComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Form frmNewForm = formToolkit.createForm(this);
		formToolkit.paintBordersFor(frmNewForm);
		frmNewForm.setText("Use case");
		frmNewForm.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = formToolkit.createComposite(frmNewForm.getBody(), SWT.NONE);
		formToolkit.paintBordersFor(composite);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));

		treeViewer = new TreeViewer(composite, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);

		labelColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		labelColumn.getColumn().setWidth(130);
		labelColumn.getColumn().setText("Label");

		textColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		textColumn.getColumn().setWidth(400);
		textColumn.getColumn().setText("Text");

		Composite composite_1 = formToolkit.createComposite(frmNewForm.getHead(), SWT.NONE);
		frmNewForm.setHeadClient(composite_1);
		formToolkit.paintBordersFor(composite_1);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		txtUseCaseName = formToolkit.createText(composite_1, "New Text", SWT.NONE);
		txtUseCaseName.setText("XX Use case name XX");
		txtUseCaseName.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND));
		txtUseCaseName.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.BOLD));

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

	public Text getTxtUseCaseName() {
		return txtUseCaseName;
	}
}
