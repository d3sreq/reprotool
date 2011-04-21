package reprotool.ide.editors;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.wb.rcp.databinding.UseCaseStepLabelProvider;

import reprotool.ide.service.Service;
import reprotool.model.specification.UseCase;
import reprotool.model.specification.UseCaseStep;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class UseCaseEditor extends EditorPart implements ITreeContentProvider {

	public static final String ID = "cz.cuni.mff.reprotool.ide.editors.UseCaseEditor"; //$NON-NLS-1$
	
	// the usecase to edit
	private UseCase usecase = null;
	
	private TreeViewer treeViewer = null;

	public UseCaseEditor() {
		// TODO XXX always uses first usecase for testing
		usecase = Service.INSTANCE.getSoftwareProject().getUseCases().get(0);
	}
	
	public UseCaseStep getSelectedStep() {
		if (treeViewer.getSelection().isEmpty())
			return null;
		else
			return (UseCaseStep)((IStructuredSelection)treeViewer.getSelection()).getFirstElement();
	}
	
	public void showSelectedStep()
	{
		if (treeViewer.getSelection().isEmpty())
			return;
		IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
		try {
			handlerService.executeCommand("commands.showStep", null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FormLayout());
		
		treeViewer = new TreeViewer(container, SWT.BORDER|SWT.FULL_SELECTION);
		
		Tree tree = treeViewer.getTree();
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				UseCaseEditor editor = (UseCaseEditor) page.getActiveEditor();
				editor.showSelectedStep();
			}
		});
		FormData fd_tree = new FormData();
		fd_tree.bottom = new FormAttachment(100, -50);
		fd_tree.right = new FormAttachment(100, 0);
		fd_tree.top = new FormAttachment(0);
		fd_tree.left = new FormAttachment(0);
		tree.setLayoutData(fd_tree);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		
		TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
		treeColumn.setWidth(53);
		treeColumn.setText("*");
		
		TreeColumn trclmnMark = new TreeColumn(tree, SWT.NONE);
		trclmnMark.setWidth(62);
		trclmnMark.setText("Mark");
		
		TreeColumn trclmnStepText = new TreeColumn(tree, SWT.NONE);
		trclmnStepText.setWidth(245);
		trclmnStepText.setText("Step text");
		
		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnType = treeViewerColumn.getColumn();
		trclmnType.setWidth(112);
		trclmnType.setText("Type");
		
		Composite composite = new Composite(container, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(tree, 5);
		fd_composite.bottom = new FormAttachment(100);
		fd_composite.right = new FormAttachment(100);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		composite.setLayout(null);
		
		Button button = new Button(composite, SWT.NONE);
		button.setBounds(7, 7, 70, 29);
		button.setText("Up");
		
		Button button_1 = new Button(composite, SWT.NONE);
		button_1.setBounds(83, 7, 70, 29);
		button_1.setText("Down");
		
		Button button_2 = new Button(composite, SWT.NONE);
		button_2.setBounds(159, 7, 70, 29);
		button_2.setText("Add");
		
		Button button_3 = new Button(composite, SWT.NONE);
		button_3.setBounds(235, 7, 70, 29);
		button_3.setText("Delete");
		
		treeViewer.setContentProvider(this);
		treeViewer.setLabelProvider(new UseCaseStepLabelProvider());
		
		treeViewer.setCellModifier(new ICellModifier() {
			public boolean canModify(Object element, String property) {
				return "text".equals(property);
			}

			public Object getValue(Object element, String property) {
				return ((UseCaseStep)element).getDesc();
			}

			public void modify(Object element, String property, Object value) {
				UseCaseStep step = (UseCaseStep)(((TreeItem)element).getData());
				step.setDesc(value.toString());
				treeViewer.update(step, new String[] {"text"});
				showSelectedStep();
			}
		});
		treeViewer.setColumnProperties(new String[] {"parsed", "mark", "text", "type"});
		treeViewer.setCellEditors(new CellEditor[] { null, null ,new TextCellEditor(treeViewer.getTree()), null });
		
		treeViewer.setInput(usecase);
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// Initialize the editor part
		setSite(site);
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{
	}

	@Override
	public Object[] getElements(Object inputElement)
	{
		return ((UseCase)inputElement).getUseCaseSteps().toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement)
	{
		UseCaseStep step = (UseCaseStep)parentElement;
		List<UseCaseStep> ret = step.getExtensions();
		ret.addAll(step.getVariations());
		return ret.toArray();
	}

	@Override
	public Object getParent(Object element)
	{
		UseCaseStep step = (UseCaseStep)element;
		return step.getParentStep();
	}

	@Override
	public boolean hasChildren(Object element)
	{
		UseCaseStep step = (UseCaseStep)element;
		return !(step.getExtensions().isEmpty() && step.getVariations().isEmpty());
	}
}
