package reprotool.ide.editors.counterExample;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import reprotool.model.swproj.CounterExample;
import reprotool.model.swproj.Step;
import reprotool.model.swproj.UseCaseTransition;
import reprotool.model.swproj.presentation.SwprojEditor;

public class CExmpEditor extends SwprojEditor {
	public CExmpEditor() {
		addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
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
					if (!selection.isEmpty()) {
						((LTSContentOutlinePage) contentOutlinePage).handleEditorUCStepSelected(selection);
					}
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
	
	public void setLTSSelection(ISelection selection) {
		selectionViewer.setSelection(selection);
	}
	
	
	@Override
	public void handleContentOutlineSelection(ISelection selection) {
		/* Not implemented */
	}
}