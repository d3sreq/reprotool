package reprotool.uc.tempeditor;

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

import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.presentation.UsecaseEditor;

public class TemporaryUsecaseEditor extends UsecaseEditor {
	
	public TemporaryUsecaseEditor() {
		addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection sel = (IStructuredSelection) event.getSelection();
					Collection<?> col = ((IStructuredSelection)sel).toList();
					List<UseCaseStep> selection = new ArrayList<UseCaseStep>();
					Iterator<?> it = col.iterator();
					while(it.hasNext()) {
						Object obj = it.next();
						if (obj instanceof UseCaseStep) {
							UseCaseStep s = (UseCaseStep) obj;
							selection.add(s);
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
			UseCase uc = (UseCase) obj;
			contentOutlinePage = new LTSContentOutlinePage(uc);
			
			contentOutlinePage.addSelectionChangedListener
				(new ISelectionChangedListener() {
					 public void selectionChanged(SelectionChangedEvent event) {
						 handleContentOutlineSelection(event.getSelection());
					 }
				 });
		}
		
		return contentOutlinePage;
	}
		
	@Override
	public void handleContentOutlineSelection(ISelection selection) {
		/* Not implemented */
	}

}