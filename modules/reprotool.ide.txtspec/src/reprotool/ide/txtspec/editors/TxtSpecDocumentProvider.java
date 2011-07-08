package reprotool.ide.txtspec.editors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class TxtSpecDocumentProvider extends FileDocumentProvider  {

	private IDocument Document;  
	
	protected IDocument createDocument(Object element) throws CoreException {
		Document = super.createDocument(element);
		if (Document != null) {
			IDocumentPartitioner partitioner =
				new FastPartitioner(
					new TxtSpecPartitionScanner(),
					new String[] {
						TxtSpecPartitionScanner.XML_TAG,
						TxtSpecPartitionScanner.XML_COMMENT });
			partitioner.connect(Document);
			Document.setDocumentPartitioner(partitioner);
		}
		return Document;
	}
	
//	public ProjectionDocument getSlaveDocument()
//	{
//		return projectionDocument;
//	}
	public void setDocument(String content)
	{
		Document.set(content);
	}
	public IDocument getDocument() {
		return Document;
	}

//	public ProjectionDocumentManager getProjectionDocumentManager() {
//		return manager;
//	}
}
