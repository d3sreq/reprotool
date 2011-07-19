package reprotool.ide.editors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import reprotool.ide.adapter.UseCaseContentOutlinePage;
import reprotool.ide.commands.ClipboardHandler;
import reprotool.model.swproj.Actor;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.impl.UsecaseFactoryImpl;

public class UseCaseEditor extends EditorPart implements ITabbedPropertySheetPageContributor {

	public static final String ID = "cz.cuni.mff.reprotool.ide.editors.UseCaseEditor"; //$NON-NLS-1$

	// the usecase to edit
	private UseCase usecase = null;

	private ResourceSet resourceSet = null;
	
	private Menu insertStepMenu;
	private Menu insertActorMenu;

	public final static String STEP_ESCAPE_SEQ = "##";
	public final static String ACTOR_ESCAPE_SEQ = "%%";
	private TreeViewer treeViewer = null;
	private SourceViewer sentenceText = null;
	private AnnotatedDocument sentenceDoc = null;
	public class AnnotatedDocument {
		private Document doc;
		private AnnotationModel model;
		public AnnotatedDocument(String raw) {
			doc = new Document(raw);
			model = new AnnotationModel();
			model.connect(doc);
			
			sentenceText.setDocument(doc, model);
			parseSentence(doc, model, usecase);
		}
		public String getPlainText() {
			return doc.get();
		}
		public String getAnnotatedText() {
			@SuppressWarnings("rawtypes")
			Iterator i = model.getAnnotationIterator();
			ArrayList<Annotation> anns = new ArrayList<Annotation>();
			while (i.hasNext())
				anns.add((Annotation)i.next());
			// sort by descending position so we can safely replace from end to beginning
			Collections.sort(anns, new Comparator<Annotation>() {
				@Override
				public int compare(Annotation a, Annotation b) {
					if (model.getPosition(a).offset < model.getPosition(b).offset)
						return 1;
					else
						return -1;
				}
			});
			StringBuffer sb = new StringBuffer(doc.get());
			for (Annotation a : anns) {
				Position pos = model.getPosition(a);
				if (pos.length == 0) { // deleted
					model.removeAnnotation(a);
					continue;
				}
				if (a.getType().equals(ANNOTATION_TYPE_STEP)) {
					//System.out.println("substr "+sb.substring(pos.offset, pos.offset+pos.length));
					sb.replace(pos.offset, pos.offset+pos.length, STEP_ESCAPE_SEQ+a.getText()+STEP_ESCAPE_SEQ);
					//System.out.println("replaced "+a.getText());
				} else if (a.getType().equals(ANNOTATION_TYPE_ACTOR)) {
					sb.replace(pos.offset, pos.offset+pos.length, ACTOR_ESCAPE_SEQ+a.getText()+ACTOR_ESCAPE_SEQ);
				}
			}
			
			sb = replaceImplicitReferences(sb);
			return sb.toString();
		}
		/** Finds substrings like "#1b2" or "step 1b2" and replaces them with annotated references. */
		private StringBuffer replaceImplicitReferences(StringBuffer sb) {
			StringBuffer res = new StringBuffer();
			Pattern stepRef = Pattern.compile("#((?:[1-9]+[a-z]?)+[1-9]?)|step ((?:[1-9]+[a-z]?)+[1-9]?)");
			Matcher m = stepRef.matcher(sb);
			while (m.find()) {
				if (m.group(1) != null) {
					UseCaseStep step = findStepByLabel(usecase.getMainScenario(), m.group(1));
					if (step != null)
						m.appendReplacement(res, STEP_ESCAPE_SEQ+step.getID()+STEP_ESCAPE_SEQ);
				} else if (m.group(2) != null) {
					UseCaseStep step = findStepByLabel(usecase.getMainScenario(), m.group(2));
					if (step != null)
						m.appendReplacement(res, "step "+STEP_ESCAPE_SEQ+step.getID()+STEP_ESCAPE_SEQ);
				}
			}
			m.appendTail(res);
			
			return res;
		}
	};
	/** Resolves references in sentence tags and creates annotations */
	public static void parseSentence(Document doc, AnnotationModel model, UseCase uc) {
		Pattern stepRef = Pattern.compile(STEP_ESCAPE_SEQ+"(_[^\\s]+?)"+STEP_ESCAPE_SEQ+"|"+ACTOR_ESCAPE_SEQ+"(.+?)"+ACTOR_ESCAPE_SEQ);
		Matcher m = stepRef.matcher(doc.get());
		StringBuffer plain = new StringBuffer();
		Map<Annotation, Position> annotations = new HashMap<Annotation, Position>();
		while (m.find()) {
			// find next step reference
			if (m.group(1) != null) {
				String id = m.group(1);
				// find label of the referenced step
				UseCaseStep ref = getStepByID(uc, id);
				String label = "[invalid]";
				if (ref != null)
					label = ref.getLabel();
				// replace the reference with the label
				m.appendReplacement(plain, label);
				// add an annotation for the label
				Annotation a = new Annotation(ANNOTATION_TYPE_STEP, false, id);
				annotations.put(a, new Position(plain.length()-label.length(), label.length()));
			} else if (m.group(2) != null) {
				String name = m.group(2);
				m.appendReplacement(plain, name);
				Annotation a = new Annotation(ANNOTATION_TYPE_ACTOR, false, name);
				annotations.put(a, new Position(plain.length()-name.length(), name.length()));
			}
		}
		m.appendTail(plain);
		doc.set(plain.toString());
		for (Annotation key : annotations.keySet())
			model.addAnnotation(key, annotations.get(key));
	}
	
	public static String getPlainSentence(UseCaseStep step) {
		if (step.getSentence().contains(UseCaseEditor.ACTOR_ESCAPE_SEQ) || step.getSentence().contains(UseCaseEditor.STEP_ESCAPE_SEQ)) {
			Document d = new Document(step.getSentence());
			UseCaseEditor.parseSentence(d, new AnnotationModel(), UseCaseEditor.getUseCase(step));
			return d.get();
		}
		else
			return step.getSentence();
	}

	private boolean dirty = false;

	private TabbedPropertySheetPage propertySheetPage;
	private UseCaseContentOutlinePage outlinePage;
	
	/**
	 * Stores the object in the clipboard and implements cut/copy/paste actions
	 */
	private Clipboard clipboard;
	public class Clipboard {
		boolean isVariation; // when pasting a Scenario, we have to remember if it was a variation or an extension
		EObject clipboardItem;
		public void doCut() {
			if (getSelectedObject() == null)
				return;
			EObject selected = (EObject)getSelectedObject();
			clipboardItem = EcoreUtil.copy(selected);
			if (selected instanceof Scenario)
				isVariation = ((UseCaseStep)selected.eContainer()).getVariation().contains(selected);
			runCommand("org.eclipse.ui.edit.delete");
		}
		
		public void doCopy() {
			if (getSelectedObject() == null)
				return;
			EObject selected = (EObject)getSelectedObject();
			if (selected instanceof Scenario)
				isVariation = ((UseCaseStep)selected.eContainer()).getVariation().contains(selected);
			clipboardItem = EcoreUtil.copy(selected);
		}
		
		public void doPaste() {
			if (clipboardItem == null)
				return;
			saveUndoState();
			
			EObject selected = (EObject)getSelectedObject();
			if (clipboardItem instanceof Scenario) {
				if (selected instanceof Scenario)
					insertScenario((UseCaseStep)selected.eContainer(), (Scenario)clipboardItem);
				else if (selected instanceof UseCaseStep)
					insertScenario((UseCaseStep)selected, (Scenario)clipboardItem);
			} else if (clipboardItem instanceof UseCaseStep) {
				if (selected instanceof Scenario)
					((Scenario)selected).getSteps().add((UseCaseStep)clipboardItem);
				else if (selected instanceof UseCaseStep) {
					Scenario parent = (Scenario)selected.eContainer();
					// add new step just after the selected step
					UseCaseStep step = (UseCaseStep)clipboardItem;
					parent.getSteps().add(parent.getSteps().indexOf(selected)+1, step);
				}
			}
			
			fixDuplicateIDs();
			clipboardItem = EcoreUtil.copy(clipboardItem);
			setDirty();
		}
		
		private void insertScenario(UseCaseStep step, Scenario scen) {
			if (isVariation)
				step.getVariation().add(scen);
			else
				step.getExtension().add(scen);
		}
	};
	public Clipboard getClipboard() {
		return clipboard;
	}
	private IHandlerActivation[] clipboardHandlers;

	public void fixDuplicateIDs() {
		ArrayList<String> ids = new ArrayList<String>();
		List<UseCaseStep> steps = getSteps(usecase.getMainScenario());
		for (UseCaseStep s : steps) {
			if (ids.contains(s.getID()))
				s.setID(EcoreUtil.generateUUID());
			ids.add(s.getID());
		}
	}

	// global actions for toolbar contribution
	private IAction undoAction;
	private IAction redoAction;
	private UndoStack undoStack;

	/**
	 * Maintains a stack of undo and redo states of the usecase.
	 */
	class UndoStack {
		/** Maximum amount of saved usecase states */
		static final int MAX_UNDO_DEPTH = 20;
		private LinkedList<UseCase> undoStack;
		private LinkedList<UseCase> redoStack;

		public UndoStack() {
			undoStack = new LinkedList<UseCase>();
			redoStack = new LinkedList<UseCase>();
			undoAction.setEnabled(false);
			redoAction.setEnabled(false);
		}

		/**
		 * Save the state of the usecase for undo operation
		 */
		public void snapshot() {
			undoStack.add(EcoreUtil.copy(usecase));
			if (undoStack.size() > MAX_UNDO_DEPTH)
				undoStack.removeFirst();
			redoStack.clear();
			undoAction.setEnabled(true);
			redoAction.setEnabled(false);
		}

		public void undo() {
			if (undoStack.isEmpty())
				return;
			redoStack.addFirst(usecase);
			usecase = EcoreUtil.copy(undoStack.removeLast());
			undoAction.setEnabled(!undoStack.isEmpty());
			redoAction.setEnabled(true);
			treeViewer.setInput(usecase);
			treeViewer.getTree().setFocus();
			setDirty();
		}

		public void redo() {
			if (redoStack.isEmpty())
				return;
			undoStack.add(usecase);
			usecase = EcoreUtil.copy(redoStack.removeFirst());
			redoAction.setEnabled(!redoStack.isEmpty());
			undoAction.setEnabled(true);
			treeViewer.setInput(usecase);
			treeViewer.getTree().setFocus();
			setDirty();
		}
	}

	/**
	 * Saves a snapshot of the usecase for undo operation - to be called before
	 * any change to the usecase
	 */
	public void saveUndoState() {
		undoStack.snapshot();
	}

	public static UseCaseEditor getActiveUseCaseEditor() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window.getActivePage();
		if (page == null)
			return null;
		IEditorPart editor = page.getActiveEditor();
		if (editor != null && editor instanceof UseCaseEditor)
			return (UseCaseEditor) editor;
		else
			return null;
	}

	public UseCaseEditor() {
	}

	private void runCommand(String command) {
		IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
		try {
			handlerService.executeCommand(command, null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public UseCase getEditedUseCase() {
		return usecase;
	}

	public UseCaseStep getSelectedStep() {
		Object element = getSelectedObject();

		if (element instanceof UseCaseStep)
			return (UseCaseStep) element;

		return null;
	}

	public Object getSelectedObject() {
		if (treeViewer.getSelection().isEmpty())
			return null;

		return ((IStructuredSelection) treeViewer.getSelection()).getFirstElement();
	}

	public void showSelectedStep() {
		if (treeViewer.getSelection().isEmpty())
			return;
		runCommand("commands.showStep");
	}
	
	public void deleteItem(Object item) {
		if (item instanceof UseCaseStep) {
			UseCaseStep step = (UseCaseStep)item;
			Scenario scen = (Scenario)step.eContainer();
			scen.getSteps().remove(step);
			checkEmptyScenario(scen);
		} else if (item instanceof Scenario) {
			UseCaseStep parent = (UseCaseStep)((EObject)item).eContainer();
			parent.getExtension().remove(item);
			parent.getVariation().remove(item);
		}
		sentenceText.setDocument(new Document());
		refresh();
	}

	private void checkEmptyScenario(Scenario scen) {
		// remove empty variation / extension
		if (scen.getSteps().isEmpty()) {
			if (scen.eContainer() instanceof UseCaseStep) {
				UseCaseStep parent = (UseCaseStep)scen.eContainer();
				parent.getExtension().remove(scen);
				parent.getVariation().remove(scen);
			}
		}
	}

	/**
	 * Create contents of the editor part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FormLayout());

		treeViewer = new TreeViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		treeViewer.setAutoExpandLevel(4);

		Tree tree = treeViewer.getTree();
		FormData fd_tree = new FormData();
		fd_tree.bottom = new FormAttachment(100, -110);
		fd_tree.right = new FormAttachment(100, 0);
		fd_tree.top = new FormAttachment(0);
		fd_tree.left = new FormAttachment(0);
		tree.setLayoutData(fd_tree);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		

		initializeDragAndDrop();
		
		sentenceText = new SourceViewer(container, null, SWT.V_SCROLL);
		
		FormData fd_text = new FormData();
		fd_text.bottom = new FormAttachment(100, -50);
		fd_text.right = new FormAttachment(100, 0);
		fd_text.top = new FormAttachment(100, -105);
		fd_text.left = new FormAttachment(0);
		sentenceText.getTextWidget().setLayoutData(fd_text);
		
		initializeSentenceEditor();
		
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				Object selection = getSelectedObject();
				if (selection == null)
					return;
				showSelectedStep();
				
				//if (getSelectedStep() != null)
				//	System.out.println("step ID: "+getSelectedStep().getID());
				
				String raw;
				if (selection instanceof UseCaseStep)
					raw = getSelectedStep().getSentence();
				else
					raw = ((Scenario) getSelectedObject()).getDescription();
				sentenceDoc = new AnnotatedDocument(raw);
			}
		});

		TreeColumn trclmnLabel = new TreeColumn(tree, SWT.NONE);
		trclmnLabel.setWidth(100);
		trclmnLabel.setText("Label");

		TreeColumn trclmnStepText = new TreeColumn(tree, SWT.NONE);
		trclmnStepText.setWidth(300);
		trclmnStepText.setText("Step text");

		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnType = treeViewerColumn.getColumn();
		trclmnType.setWidth(139);
		trclmnType.setText("Type");

		Composite composite = new Composite(container, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(sentenceText.getTextWidget(), 5);
		fd_composite.bottom = new FormAttachment(100);
		fd_composite.right = new FormAttachment(100);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		composite.setLayout(null);

		Button button = new Button(composite, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("commands.stepUp");
			}
		});
		button.setBounds(7, 7, 70, 29);
		button.setText("Up");

		Button button_1 = new Button(composite, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("commands.stepDown");
			}
		});
		button_1.setBounds(83, 7, 70, 29);
		button_1.setText("Down");

		Button button_2 = new Button(composite, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("commands.newStep");
			}
		});
		button_2.setBounds(159, 7, 70, 29);
		button_2.setText("Add");

		Button button_3 = new Button(composite, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("org.eclipse.ui.edit.delete");
			}
		});
		button_3.setBounds(235, 7, 70, 29);
		button_3.setText("Delete");

		UseCaseStepTreeProvider provider = new UseCaseStepTreeProvider();
		treeViewer.setContentProvider(provider);
		treeViewer.setLabelProvider(provider);

		TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
		treeColumn.setWidth(24);
		treeColumn.setText("*");

		Menu menu = new Menu(tree);
		tree.setMenu(menu);

		MenuItem mntmNewStep = new MenuItem(menu, SWT.NONE);
		mntmNewStep.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("commands.newStep");
			}
		});
		mntmNewStep.setText("New step");

		MenuItem mntmDuplicateStep = new MenuItem(menu, SWT.NONE);
		mntmDuplicateStep.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("commands.duplicateStep");
			}
		});
		mntmDuplicateStep.setText("Duplicate step");

		MenuItem mntmAddExtension = new MenuItem(menu, SWT.NONE);
		mntmAddExtension.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("commands.addExtension");
			}
		});
		mntmAddExtension.setText("Add extension");

		MenuItem mntmAddVariation = new MenuItem(menu, SWT.NONE);
		mntmAddVariation.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("commands.addVariation");
			}
		});
		mntmAddVariation.setText("Add variation");

		MenuItem mntmDeleteStep = new MenuItem(menu, SWT.NONE);
		mntmDeleteStep.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("org.eclipse.ui.edit.delete");
			}
		});
		mntmDeleteStep.setText("Delete step");
		
		new MenuItem(menu, SWT.SEPARATOR);
		
		MenuItem mntmCut = new MenuItem(menu, SWT.NONE);
		mntmCut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("org.eclipse.ui.edit.cut");
			}
		});
		mntmCut.setText("Cut");
		
		MenuItem mntmCopy = new MenuItem(menu, SWT.NONE);
		mntmCopy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("org.eclipse.ui.edit.copy");
			}
		});
		mntmCopy.setText("Copy");
		
		MenuItem mntmPaste = new MenuItem(menu, SWT.NONE);
		mntmPaste.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				runCommand("org.eclipse.ui.edit.paste");
			}
		});
		mntmPaste.setText("Paste");

		clipboard = new Clipboard();
		
		initializeGlobalActions();
		undoStack = new UndoStack();
		IActionBars bars = getEditorSite().getActionBars();
		bars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
		bars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
		
		clipboardHandlers = new IHandlerActivation[3];
		activateClipboard();

		setTitle();

		getSite().setSelectionProvider(treeViewer);
		treeViewer.setInput(usecase);
	}
	
	private void activateClipboard() {
		IHandlerService hs = (IHandlerService) getSite().getService(IHandlerService.class);
		ClipboardHandler ch = new ClipboardHandler();
		clipboardHandlers[0] = hs.activateHandler("org.eclipse.ui.edit.copy", ch);
		clipboardHandlers[1] = hs.activateHandler("org.eclipse.ui.edit.cut", ch);
		clipboardHandlers[2] = hs.activateHandler("org.eclipse.ui.edit.paste", ch);
	}
	
	private void deactivateClipboard() {
		IHandlerService hs = (IHandlerService) getSite().getService(IHandlerService.class);
		for (int i = 0; i < clipboardHandlers.length; ++i)
			hs.deactivateHandler(clipboardHandlers[i]);
	}

	private void initializeDragAndDrop() {
		Transfer[] types = new Transfer[] { LocalSelectionTransfer.getTransfer() };
		int operations = DND.DROP_MOVE;

		final DragSource source = new DragSource(treeViewer.getTree(), operations);
		source.setTransfer(types);

		DropTarget target = new DropTarget(treeViewer.getTree(), operations);
		target.setTransfer(types);
		target.addDropListener(new ViewerDropAdapter(treeViewer) {
			@Override
			public void drop(DropTargetEvent event) {
				int location = determineLocation(event);
				EObject src = (EObject)getSelectedObject();
				EObject target = (EObject)determineTarget(event);
				switch (location) {
				case LOCATION_BEFORE:
					saveUndoState();
					deleteItem(src);
					Scenario cont = (Scenario)((UseCaseStep)target).eContainer();
					cont.getSteps().add(cont.getSteps().indexOf(target), (UseCaseStep)src);
					setDirty();
					break;
				case LOCATION_AFTER:
					saveUndoState();
					deleteItem(src);
					if (target instanceof UseCaseStep) {
						Scenario parent = (Scenario)((UseCaseStep)target).eContainer();
						parent.getSteps().add(parent.getSteps().indexOf(target)+1, (UseCaseStep)src);
					} else if (target instanceof Scenario)
						((Scenario)target).getSteps().add(0, (UseCaseStep)src);
					setDirty();
					break;
				case LOCATION_ON:
					if  (src instanceof Scenario && target instanceof UseCaseStep) {
						saveUndoState();
						Scenario scen = (Scenario)src;
						UseCaseStep parent = (UseCaseStep)scen.eContainer();
						if (parent.getVariation().contains(scen)) {
							((UseCaseStep)target).getVariation().add(scen);
							parent.getVariation().remove(scen);
						} else {
							((UseCaseStep)target).getExtension().add(scen);
							parent.getExtension().remove(scen);
						}
						setDirty();
					} else if (src instanceof UseCaseStep && target instanceof Scenario) {
						if (isTransitiveParent(src, target))
							return;
						saveUndoState();
						((Scenario)target).getSteps().add(EcoreUtil.copy((UseCaseStep)src));
						deleteItem(src);
						setDirty();
					}
					break;
				case LOCATION_NONE:
					saveUndoState();
					UseCaseStep step = (UseCaseStep)src;
					deleteItem(step);
					usecase.getMainScenario().getSteps().add(step);
					setDirty();
					break;
				}
			}

			@Override
			public boolean performDrop(Object data) {
				return true;
			}

			@Override
			public boolean validateDrop(Object target, int operation, TransferData transferType) {
				EObject src = (EObject)getSelectedObject();
				EObject tgt = (EObject)target;
				int location = getCurrentLocation();
				switch (location) {
				case LOCATION_BEFORE:
					if (src instanceof UseCaseStep && target instanceof UseCaseStep && !isTransitiveParent(src, tgt))
						return true;
					break;
				case LOCATION_ON:
					if (src == target || src.eContainer() == target || isTransitiveParent(src, tgt))
						return false;
					if ( (src instanceof Scenario && target instanceof UseCaseStep) || (src instanceof UseCaseStep && target instanceof Scenario) )
						return true;
					break;
				case LOCATION_AFTER:
					if (src instanceof UseCaseStep && !isTransitiveParent(src, tgt))
						return true;
					break;
				case LOCATION_NONE:
					if (src instanceof UseCaseStep)
						return true;
					break;
				}
				return false;
			}
		});
	}
	
	private boolean isTransitiveParent(EObject source, EObject target) {
		EObject parent = target;
		while (parent != null) {
			if (parent == source)
				return true;
			parent = parent.eContainer();
		}
		return false;
	}

	private static final String ANNOTATION_TYPE_STEP = "reprotool.ide.stepLabel";
	private static final String KEY_TAG_COLOR_PREF = "tagColor";
	private static final String KEY_TAG_HIGHLIGHT_PREF = "tagHighlight";
	private static final String KEY_TAG_TEXT_PREF = "tagText";

	private static final String ANNOTATION_TYPE_ACTOR = "reprotool.ide.actorLabel";
	private static final String KEY_TAG_COLOR_PREF_ACTOR = "actorTagColor";
	private static final String KEY_TAG_HIGHLIGHT_PREF_ACTOR = "actorTagHighlight";
	private static final String KEY_TAG_TEXT_PREF_ACTOR = "actorTagText";
	
	private void initializeSentenceEditor() {
		StyledText styledText = sentenceText.getTextWidget();
		
		Menu menu = new Menu(styledText);
		styledText.setMenu(menu);
		
		MenuItem mntmInsertStep = new MenuItem(menu, SWT.CASCADE);
		mntmInsertStep.setText("Insert step reference");
		
		insertStepMenu = new Menu(mntmInsertStep);
		mntmInsertStep.setMenu(insertStepMenu);
		
		MenuItem mntmInsertActor = new MenuItem(menu, SWT.CASCADE);
		mntmInsertActor.setText("Insert actor reference");
		
		insertActorMenu = new Menu(mntmInsertActor);
		mntmInsertActor.setMenu(insertActorMenu);
		insertActorMenu.addListener(SWT.Show, new Listener() {
			@Override
			public void handleEvent(Event event) {
				for (MenuItem i : insertStepMenu.getItems())
					i.dispose();
				List<Actor> actors = getProjectActors();
				for (Actor a : actors) {
					MenuItem m = new MenuItem(insertStepMenu, SWT.PUSH);
					m.setText(a.getName());
					m.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							MenuItem i = (MenuItem)e.widget;
							int start = sentenceText.getTextWidget().getCaretOffset();
							try {
								sentenceDoc.doc.replace(start, 0, i.getText());
							} catch (BadLocationException e1) {
								// should never happen
								e1.printStackTrace();
							}
							Annotation a = new Annotation(ANNOTATION_TYPE_ACTOR, false, i.getText());
							sentenceDoc.model.addAnnotation(a, new Position(start, i.getText().length()));
						}
					});
				}
			}
		});
		
		insertStepMenu.addListener(SWT.Show, new Listener() {
			@Override
			public void handleEvent(Event event) {
				for (MenuItem i : insertStepMenu.getItems())
					i.dispose();
				List<UseCaseStep> steps = getSteps(usecase.getMainScenario());
				for (UseCaseStep s : steps) {
					MenuItem m = new MenuItem(insertStepMenu, SWT.PUSH);
					m.setText(s.getLabel());
					m.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							MenuItem i = (MenuItem)e.widget;
							UseCaseStep step = findStepByLabel(usecase.getMainScenario(), i.getText());
							int start = sentenceText.getTextWidget().getCaretOffset();
							try {
								sentenceDoc.doc.replace(start, 0, step.getLabel());
							} catch (BadLocationException e1) {
								// should never happen
								e1.printStackTrace();
							}
							Annotation a = new Annotation(ANNOTATION_TYPE_STEP, false, step.getID());
							sentenceDoc.model.addAnnotation(a, new Position(start, step.getLabel().length()));
						}
					});
				}
			}
		});
		styledText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				deactivateClipboard();
				if (getSelectedObject() instanceof Scenario) {
					insertActorMenu.setEnabled(false);
					insertStepMenu.setEnabled(false);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				insertActorMenu.setEnabled(true);
				insertStepMenu.setEnabled(true);
				activateClipboard();
				Object selected = getSelectedObject();
				String newText = sentenceDoc.getAnnotatedText();
				if (selected instanceof UseCaseStep) {
					UseCaseStep step = (UseCaseStep)selected;
					if (step.getSentence() == null)
						step.setSentence("");
					if (! step.getSentence().equals(newText)) {
						saveUndoState();
						step.setSentence(newText);
						setDirty();
					}
				} else if (selected instanceof Scenario) {
					Scenario scen = (Scenario)selected;
					if (scen.getDescription() == null)
						scen.setDescription("");
					if (! scen.getDescription().equals(newText)) {
						saveUndoState();
						scen.setDescription(newText);
						setDirty();
					}
				}
			}
		});
		sentenceText.configure(new SourceViewerConfiguration());
		
		SourceViewerDecorationSupport svds = new SourceViewerDecorationSupport(sentenceText, null, null, EditorsPlugin.getDefault().getSharedTextColors());
		AnnotationPreference ap = new AnnotationPreference();
		ap.setColorPreferenceKey(KEY_TAG_COLOR_PREF);
		ap.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF);
		ap.setTextPreferenceKey(KEY_TAG_TEXT_PREF);
		ap.setAnnotationType(ANNOTATION_TYPE_STEP);
		svds.setAnnotationPreference(ap);
		svds.install(EditorsPlugin.getDefault().getPreferenceStore());
		
		svds = new SourceViewerDecorationSupport(sentenceText, null, null, EditorsPlugin.getDefault().getSharedTextColors());
		ap = new AnnotationPreference();
		ap.setColorPreferenceKey(KEY_TAG_COLOR_PREF_ACTOR);
		ap.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF_ACTOR);
		ap.setTextPreferenceKey(KEY_TAG_TEXT_PREF_ACTOR);
		ap.setAnnotationType(ANNOTATION_TYPE_ACTOR);
		svds.setAnnotationPreference(ap);
		svds.install(EditorsPlugin.getDefault().getPreferenceStore());
	}
	
	private List<UseCaseStep> getSteps(Scenario scen) {
		ArrayList<UseCaseStep> res = new ArrayList<UseCaseStep>();
		for (UseCaseStep step : scen.getSteps()) {
			res.add(step);
			for (Scenario s : step.getVariation())
				res.addAll(getSteps(s));
			for (Scenario s : step.getExtension())
				res.addAll(getSteps(s));
		}
		return res;
	}
	
	private UseCaseStep findStepByLabel(Scenario scen, String label) {
		for (UseCaseStep step : scen.getSteps()) {
			if (step.getLabel().equals(label))
				return step;
			UseCaseStep found = null;
			for (Scenario s : step.getVariation())
				found = findStepByLabel(s, label);
			if (found != null)
				return found;
			for (Scenario s : step.getExtension())
				found = findStepByLabel(s, label);
			if (found != null)
				return found;
		}
		return null;
	}

	private void initializeGlobalActions() {
		undoAction = new Action() {
			@Override
			public void run() {
				undoStack.undo();
			}
		};
		redoAction = new Action() {
			@Override
			public void run() {
				undoStack.redo();
			}
		};
	}

	@Override
	public void setFocus() {
		treeViewer.getTree().setFocus();
	}

	public void setSelection(Object selection) {
		treeViewer.setSelection(new TreeSelection(new TreePath(new Object[] { selection })));
		refreshPropertySheet();
	}

	public void refresh() {
		treeViewer.refresh();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		Resource resource = resourceSet.getResource(URI.createURI(getInputFilePath()), true);
		try {
			final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
			saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
			resource.save(saveOptions);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setDirty(false);
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	private String getInputFilePath() {
		return ((FileEditorInput) getEditorInput()).getFile().getFullPath().toString();
	}

	private void loadUseCase() throws PartInitException {
		Resource resource = resourceSet.getResource(URI.createURI(getInputFilePath()), true);

		if (resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof UseCase))
			throw new PartInitException("File does not contain a use case");

		usecase = (UseCase) resource.getContents().get(0);
		
		if (usecase.getMainScenario() == null)
			usecase.setMainScenario(new UsecaseFactoryImpl().createScenario());
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// Initialize the editor part
		setSite(site);
		setInputWithNotify(input);

		if (!(input instanceof FileEditorInput))
			throw new PartInitException("UseCaseEditor input must be FileEditorInput");

		resourceSet = new ResourceSetImpl();
		loadUseCase();
	}

	/**
	 * Displays the use case name in the editor tab title
	 */
	private void setTitle() {
		if (usecase.getName() == null || usecase.getName().equals(""))
			setPartName("Unnamed use case");
		else
			setPartName(usecase.getName());
	}

	private void setDirty(boolean state) {
		dirty = state;
		firePropertyChange(PROP_DIRTY);
		refresh();
	}

	public void setDirty() {
		setDirty(true);
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	// this method is here only to save the propertySheetPage reference to allow
	// manual refresh of the property view (refreshPropertySheet() method)
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IPropertySheetPage.class)) {
			if (propertySheetPage == null)
				propertySheetPage = new TabbedPropertySheetPage(this);
			return propertySheetPage;
		}
		
		if (IContentOutlinePage.class.equals(key)) {
			if (outlinePage  == null) {
				outlinePage = new UseCaseContentOutlinePage(this.usecase);
			}	
			return outlinePage;
		} 
		
		return super.getAdapter(key);
	}

	private void refreshPropertySheet() {
		if (propertySheetPage != null && propertySheetPage.getCurrentTab() != null)
			propertySheetPage.refresh();
	}

	@Override
	public String getContributorId() {
		return getSite().getId();
	}
	
	public UseCaseStep getStepByID(String id) {
		return searchForID(usecase.getMainScenario(), id);
	}
	public static UseCaseStep getStepByID(UseCase uc, String id) {
		return searchForID(uc.getMainScenario(), id);
	}
	private static UseCaseStep searchForID(Scenario root, String id) {
		for (UseCaseStep step : root.getSteps()) {
			if (step.getID().equals(id))
				return step;
			ArrayList<Scenario> children = new ArrayList<Scenario>();
			children.addAll(step.getExtension());
			children.addAll(step.getVariation());
			for (Scenario s : children) {
				UseCaseStep res = searchForID(s, id);
				if (res != null)
					return res;
			}
		}
		return null;
	}
	
	public List<Actor> getProjectActors() {
		if (usecase.getEnclosingProject() != null)
			return usecase.getEnclosingProject().getActors();
		else
			return new ArrayList<Actor>();
	}
	
	public static UseCase getUseCase(UseCaseStep step) {
		EObject c = step;
		while (c != null && !(c instanceof UseCase)) {
			c = c.eContainer();
		}
		return (UseCase)c;
	}
}
