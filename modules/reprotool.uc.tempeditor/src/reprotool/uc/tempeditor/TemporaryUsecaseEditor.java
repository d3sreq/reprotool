package reprotool.uc.tempeditor;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.presentation.UsecaseEditor;

public class TemporaryUsecaseEditor extends UsecaseEditor {
	
	
	@Override
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {
			Resource resource = editingDomain.getResourceSet().getResources().get(0);
			Object obj = resource.getContents().get(0);
			UseCase uc = (UseCase) obj;
			Scenario s = uc.getMainScenario();
			contentOutlinePage = new LTSContentOutlinePage(s, getAdapterFactory());
			
			// Listen to selection so that we can handle it is a special way.
			//
			contentOutlinePage.addSelectionChangedListener
				(new ISelectionChangedListener() {
					 // This ensures that we handle selections correctly.
					 //
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
