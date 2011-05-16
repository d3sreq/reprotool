package reprotool.ide.txtspec.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class TxtSpecEditor extends TextEditor {

	private ColorManager colorManager;

	public TxtSpecEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}

	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
