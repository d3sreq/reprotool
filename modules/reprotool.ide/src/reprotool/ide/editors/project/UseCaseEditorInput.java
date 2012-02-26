package reprotool.ide.editors.project;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class UseCaseEditorInput implements IEditorInput {

	private final URI useCaseURI;
	private final IEditorInput parentEditorInput;
	private final EditingDomain editingDomain;

	public UseCaseEditorInput(URI useCaseURI, IEditorInput editorInput, EditingDomain editingDomain) {
		this.useCaseURI = useCaseURI;
		this.parentEditorInput = editorInput;
		this.editingDomain = editingDomain;
	}

	@Override
	public Object getAdapter(Class adapter) {
		return parentEditorInput.getAdapter(adapter);
	}

	@Override
	public boolean exists() {
		return parentEditorInput.exists();
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return parentEditorInput.getImageDescriptor();
	}

	@Override
	public String getName() {
		return parentEditorInput.getName();
	}

	@Override
	public IPersistableElement getPersistable() {
		//return parentEditorInput.getPersistable();
		return null;
	}

	@Override
	public String getToolTipText() {
		return parentEditorInput.getToolTipText();
	}

	public URI getUseCaseURI() {
		return useCaseURI;
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	

}
