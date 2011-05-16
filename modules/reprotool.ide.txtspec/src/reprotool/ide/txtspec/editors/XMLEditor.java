package reprotool.ide.txtspec.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class XMLEditor extends TextEditor {

	private ColorManager colorManager;
	private XMLDocumentProvider XMLDocProv;

	public XMLEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		XMLDocProv = new XMLDocumentProvider();
		setDocumentProvider(XMLDocProv);
	}

	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

	public void setDocument(String content) {
//		XMLDocProv.setDocument(content);
		setDocumentProvider(XMLDocProv);
	}
}
