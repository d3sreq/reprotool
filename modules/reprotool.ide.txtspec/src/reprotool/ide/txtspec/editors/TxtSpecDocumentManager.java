package reprotool.ide.txtspec.editors;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.projection.ProjectionDocumentManager;

public class TxtSpecDocumentManager extends ProjectionDocumentManager {
	
	/*
	 * @see org.eclipse.jface.text.IDocumentListener#documentChanged(org.eclipse.jface.text.DocumentEvent)
	 */
	@Override
	public void documentChanged(DocumentEvent event) {
		fireDocumentEvent(false, event);
	}

	/*
	 * @see org.eclipse.jface.text.IDocumentListener#documentAboutToBeChanged(org.eclipse.jface.text.DocumentEvent)
	 */
	@Override
	public void documentAboutToBeChanged(DocumentEvent event) {
		fireDocumentEvent(true, event);
	}
}
