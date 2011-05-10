package reprotool.ide.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.EditorPart;

import reprotool.ide.service.Service;
import reprotool.model.specification.UseCase;
import reprotool.model.specification.UseCaseStep;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class UseCaseEditor extends EditorPart {

	public static final String ID = "cz.cuni.mff.reprotool.ide.editors.UseCaseEditor"; //$NON-NLS-1$
	
	private static final String LABEL_PROPERTY = "label";
	private static final String SENTENCE_PROPERTY = "sentence";
	private static final String TYPE_PROPERTY = "type";
	private static final String PARSED_PROPERTY = "parsed";
	
	// the usecase to edit
	private UseCase usecase = null;
	
	private TreeViewer treeViewer = null;
	
	public static UseCaseEditor getUseCaseEditor() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		
		IEditorPart editor = page.getActiveEditor();
		if (editor != null && editor instanceof UseCaseEditor)
			return (UseCaseEditor)editor;
		else
			return null;
	}

	public UseCaseEditor() {
		// TODO XXX always uses first usecase for testing
		usecase = Service.INSTANCE.getSoftwareProject().getUseCases().get(0);
	}
	
	public UseCase getEditedUseCase() {
		return usecase;
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
		treeViewer.setAutoExpandLevel(2);
		
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
		
		TreeColumn trclmnLabel = new TreeColumn(tree, SWT.NONE);
		trclmnLabel.setWidth(100);
		trclmnLabel.setText("Label");
		
		TreeColumn trclmnStepText = new TreeColumn(tree, SWT.NONE);
		trclmnStepText.setWidth(333);
		trclmnStepText.setText("Step text");
		
		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnType = treeViewerColumn.getColumn();
		trclmnType.setWidth(139);
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
		
		UseCaseStepTreeProvider provider = new UseCaseStepTreeProvider();
		treeViewer.setContentProvider(provider);
		treeViewer.setLabelProvider(provider);
		
		treeViewer.setCellModifier(new ICellModifier() {
			public boolean canModify(Object element, String property) {
				return SENTENCE_PROPERTY.equals(property) || LABEL_PROPERTY.equals(property);
			}

			public Object getValue(Object element, String property) {
				UseCaseStep step = (UseCaseStep)element;
				if (SENTENCE_PROPERTY.equals(property))
					return step.getSentence();
				else if (LABEL_PROPERTY.equals(property)) {
					if (step.getLabel() == null)
						return "";
					else
						return step.getLabel();
				} else
					return null;
			}

			public void modify(Object element, String property, Object value) {
				UseCaseStep step = (UseCaseStep)(((TreeItem)element).getData());
				if (SENTENCE_PROPERTY.equals(property)) {
					step.setSentence(value.toString());
					treeViewer.update(step, new String[] {SENTENCE_PROPERTY});
				} else if (LABEL_PROPERTY.equals(property)) {
					final String label = value.toString();
					if (label.isEmpty() || label.equals("none"))
						step.setLabel(null);
					else
						step.setLabel(label);
					treeViewer.update(step, new String[] {LABEL_PROPERTY});
				}
				showSelectedStep();
			}
		});
		treeViewer.setColumnProperties(new String[] {LABEL_PROPERTY, SENTENCE_PROPERTY, TYPE_PROPERTY, PARSED_PROPERTY});
		treeViewer.setCellEditors(new CellEditor[] {new TextCellEditor(treeViewer.getTree()), new TextCellEditor(treeViewer.getTree()), null, null });
		
		TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
		treeColumn.setWidth(24);
		treeColumn.setText("*");
		
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
}
