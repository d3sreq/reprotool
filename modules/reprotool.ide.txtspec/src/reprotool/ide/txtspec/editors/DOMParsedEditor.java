package reprotool.ide.txtspec.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class DOMParsedEditor extends TextEditor {

	private ColorManager colorManager;
	private DOMParsedDocumentProvider DOMParsedDocProv;

	public DOMParsedEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		DOMParsedDocProv = new DOMParsedDocumentProvider();
		setDocumentProvider(DOMParsedDocProv);
	}

	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

	public void setDocument(String content) {
		DOMParsedDocProv.setDocument(content);
		setDocumentProvider(DOMParsedDocProv);
	}
}
