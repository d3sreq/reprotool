package reprotool.ide.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import reprotool.ide.editors.UseCaseEditor;

public class ClipboardHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		UseCaseEditor editor = UseCaseEditor.getActiveUseCaseEditor();
		if (editor == null)
			return null;
		
		if (event.getCommand().getId().equals("org.eclipse.ui.edit.copy"))
			editor.getClipboard().doCopy();
		else if (event.getCommand().getId().equals("org.eclipse.ui.edit.cut"))
			editor.getClipboard().doCut();
		else if (event.getCommand().getId().equals("org.eclipse.ui.edit.paste"))
			editor.getClipboard().doPaste();
		
		return null;
	}
}
