package reprotool.ide.editors.project;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import reprotool.model.usecase.UseCase;

public class UseCaseEditorInput implements IEditorInput {

	private final UseCase useCase;
	private final IEditorInput parentEditorInput;
	private final BasicCommandStack commandStack;
	private final EditingDomain editingDomain;

	public UseCase getUseCase() {
		return useCase;
	}

	public UseCaseEditorInput(UseCase useCase, IEditorInput editorInput, BasicCommandStack commandStack, EditingDomain editingDomain) {
		this.useCase = useCase;
		this.parentEditorInput = editorInput;
		this.commandStack = commandStack;
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

	public BasicCommandStack getCommandStack() {
		return commandStack;
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}
	
	

}
