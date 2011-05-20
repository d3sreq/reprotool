package reprotool.ide.txtspec.editors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class XMLDocumentProvider extends FileDocumentProvider {

	private IDocument document;
	protected IDocument createDocument(Object element) throws CoreException {
		document = super.createDocument(element);
		if (document != null) {
			IDocumentPartitioner partitioner =
				new FastPartitioner(
					new XMLPartitionScanner(),
					new String[] {
						XMLPartitionScanner.XML_TAG,
						XMLPartitionScanner.XML_COMMENT });
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
			//document.set(new String((new ReadXMLFile()).OVPO()));
		}
		return document;
	}
	public IDocument getDocument()
	{
		return document;
	}
	public void setDocument(String content)
	{
		document.set(content);
	}
}