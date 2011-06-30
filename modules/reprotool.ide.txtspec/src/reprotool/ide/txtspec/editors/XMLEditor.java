package reprotool.ide.txtspec.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.editors.text.TextEditor;

public class XMLEditor extends TextEditor {

	private ColorManager colorManager;
	private XMLDocumentProvider XMLDocProv;
	
	public XMLEditor() {
		super.initializeEditor();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		XMLDocProv = new XMLDocumentProvider();
		setDocumentProvider(XMLDocProv);
	}

	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

	public void setDocument(String documentContent) {
		XMLDocProv.setDocument(documentContent);
    	setDocumentProvider(XMLDocProv);
	}
	
	public IDocument getDocument()
	{
		return XMLDocProv.getDocument();
	}
}
