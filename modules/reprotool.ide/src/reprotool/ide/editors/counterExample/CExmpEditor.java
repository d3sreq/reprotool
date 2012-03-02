package reprotool.ide.editors.counterExample;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import reprotool.ide.editors.usecase.UsecaseEMFEditor;
import reprotool.model.swproj.CounterExample;
import reprotool.model.swproj.Step;
import reprotool.model.swproj.UseCaseTransition;
import reprotool.model.swproj.presentation.SwprojEditor;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

public class CExmpEditor extends SwprojEditor {
	public CExmpEditor() {
		addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				try {
					if (event.getSelection() instanceof IStructuredSelection) {
						IStructuredSelection sel = (IStructuredSelection) event.getSelection();
						Collection<?> col = ((IStructuredSelection)sel).toList();
						List<Step> selection = new ArrayList<Step>();
						Iterator<?> it = col.iterator();
						while(it.hasNext()) {
							Object obj = it.next();
							if (obj instanceof Step) {
								Step s = (Step) obj;
								selection.add(s);
							} else if (obj instanceof UseCaseTransition) {
								UseCaseTransition t = (UseCaseTransition) obj;
								selection.addAll(t.getSteps());
							}
						}
						if ((!selection.isEmpty()) && (contentOutlinePage != null)) {
							((LTSContentOutlinePage) contentOutlinePage).handleEditorUCStepSelected(selection);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	@Override
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {
			Resource resource = editingDomain.getResourceSet().getResources().get(0);
			Object obj = resource.getContents().get(0);
			CounterExample ce = (CounterExample) obj;
			contentOutlinePage = new LTSContentOutlinePage(ce, this);
		}
		
		return contentOutlinePage;
	}
	
	@Override
	public void handleChangedResources() {
		super.handleChangedResources();
		if (contentOutlinePage != null) {
			Resource resource = editingDomain.getResourceSet().getResources().get(0);
			Object obj = resource.getContents().get(0);
			CounterExample ce = (CounterExample) obj;
			((LTSContentOutlinePage) contentOutlinePage).reloadLTSGraph(ce);
		}
		
		IEditorReference[] editors = PlatformUI.getWorkbench().getActiveWorkbenchWindow().
				getActivePage().getEditorReferences();
		
		for (IEditorReference editorRef: editors) {
			IEditorPart editor = editorRef.getEditor(false);
			if (editor instanceof UsecaseEMFEditor) {
				((UsecaseEMFEditor) editor).remapBindings();							
			}
		}
	}
	
	public void setLTSSelection(ISelection selection) {
		selectionViewer.setSelection(selection);
	}
	
	
	@Override
	public void handleContentOutlineSelection(ISelection selection) {
		/* Not implemented */
	}
	
	@Override
	public void createPages() {
		super.createPages();
		
		selectionViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				ISelection selection = event.getSelection();
				if (!selection.isEmpty() && selection instanceof StructuredSelection) {
					StructuredSelection structuredSelection = (StructuredSelection) selection;

					Object first = structuredSelection.getFirstElement();
					if (first instanceof Step) {
						Step step = (Step) first;
						UseCaseStep ucStep = step.getUcStep();
						UseCaseTransition t = null;
						Assert.isTrue(step.eContainer() instanceof UseCaseTransition);
						t = (UseCaseTransition) step.eContainer();
						UseCase u = t.getUseCase();
						EditorUtils.openUseCaseEditor(getSite().getPage(), u, ucStep, getEditorInput(), getEditingDomain());
					}
				}
			}
		});
	}
}