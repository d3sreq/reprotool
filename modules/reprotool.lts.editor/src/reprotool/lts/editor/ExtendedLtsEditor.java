package reprotool.lts.editor;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.ZestStyles;
import reprotool.model.lts.StateMachine;
import reprotool.model.lts.presentation.LtsEditor;

/**
 * This is extended LTS editor build upon the generated LtsEditor
 */
public class ExtendedLtsEditor extends LtsEditor {

	private GraphViewer viewer;
	
	public void showGraph(StateMachine machine) {
		viewer.setInput(machine);
		viewer.getGraphControl().setNodeStyle(ZestStyles.NODES_NO_ANIMATION);
		viewer.applyLayout();
	}
	
	@Override
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {
			Resource resource = editingDomain.getResourceSet().getResources().get(0);
			Object obj = resource.getContents().get(0);
			StateMachine machine = (StateMachine) obj;			

			contentOutlinePage = new LTSContentOutlinePage(machine);
			
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
	
	public void handleContentOutlineSelection(ISelection selection) {
		/* Not implemented */
	}
	
}