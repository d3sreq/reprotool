package reprotool.ide.editors;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
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
import org.eclipse.ui.part.FileEditorInput;

import reprotool.ide.service.Service;
import reprotool.ling.LingTools;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

public class UseCaseEditor extends EditorPart {

	public static final String ID = "cz.cuni.mff.reprotool.ide.editors.UseCaseEditor"; //$NON-NLS-1$
	
	private static final String LABEL_PROPERTY = "label";
	private static final String SENTENCE_PROPERTY = "sentence";
	private static final String TYPE_PROPERTY = "type";
	private static final String PARSED_PROPERTY = "parsed";
	
	/*
	 * LingTools is just a temporary stupid implementation of a sentence parsing
	 * and tree building.
	 * When the real linguistic tools are added to this project, they will be used. 
	 */
	private static final LingTools lingTools = new LingTools();
	
	// the usecase to edit
	private UseCase usecase = null;
	
	private ResourceSet resourceSet = null;
	
	private TreeViewer treeViewer = null;
	
	private boolean dirty = false;
	
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
	}
	
	public UseCase getEditedUseCase() {
		return usecase;
	}
	
	public UseCaseStep getSelectedStep() {
		if (treeViewer.getSelection().isEmpty())
			return null;
		
		Object element = ((IStructuredSelection)treeViewer.getSelection()).getFirstElement();
		
		if(element instanceof UseCaseStep)
			return (UseCaseStep) element;
		
		return null;
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
		treeViewer.setAutoExpandLevel(4);
		
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
				return (element instanceof UseCaseStep) && (SENTENCE_PROPERTY.equals(property) || LABEL_PROPERTY.equals(property));
			}

			public Object getValue(Object element, String property) {
				if(element instanceof UseCaseStep) {
					UseCaseStep step = (UseCaseStep)element;
					if (SENTENCE_PROPERTY.equals(property))
						return step.getSentence();
					else if (LABEL_PROPERTY.equals(property)) {
						if (step.getLabel() == null)
							return "";
						else
							return step.getLabel();
					}
				}
				return "";
			}

			public void modify(Object element, String property, Object value) {
				Object item = ((TreeItem)element).getData();
				if (item instanceof UseCaseStep) {
					UseCaseStep step = (UseCaseStep)item;
					if (SENTENCE_PROPERTY.equals(property) && !step.getSentence().equals(value.toString())) {
						step.setSentence(value.toString());
						treeViewer.update(step, new String[] {SENTENCE_PROPERTY});
						//step.setParsedSentence(lingTools.parseSentence(step.getSentence()));
						setDirty(true);
					} else if (LABEL_PROPERTY.equals(property) && !step.getLabel().equals(value.toString())) {
						final String label = value.toString();
						if (label.isEmpty())
							step.setLabel(null);
						else
							step.setLabel(label);
						treeViewer.update(step, new String[] {LABEL_PROPERTY});
						setDirty(true);
					}
					showSelectedStep();
				}
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
        Resource resource = resourceSet.getResource(URI.createURI(getInputFilePath()), true);
        try {
				final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
				saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
                resource.save(saveOptions);
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        setDirty(false);
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}
	
	private String getInputFilePath() {
		return ((FileEditorInput)getEditorInput()).getFile().getFullPath().toString();
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// Initialize the editor part
		setSite(site);
		setInputWithNotify(input);
		setPartName(input.getName());
		
		if ( ! (input instanceof FileEditorInput))
			throw new PartInitException("UseCaseEditor input must be FileEditorInput");
		
        resourceSet = new ResourceSetImpl();
        Resource resource = resourceSet.getResource(URI.createURI(getInputFilePath()), true);
        
        // for testing
        //resource.getContents().set(0, Service.INSTANCE.getSoftwareProject().getUseCases().get(0));
		if ( resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof UseCase))
			throw new PartInitException("File does not contain a use case");
		
        usecase = (UseCase)resource.getContents().get(0);
	}

	private void setDirty(boolean state) {
		dirty = state;
		firePropertyChange(PROP_DIRTY);
	}
	
	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
}
