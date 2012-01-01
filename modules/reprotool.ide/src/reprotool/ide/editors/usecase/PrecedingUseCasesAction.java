package reprotool.ide.editors.usecase;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UsecasePackage;

public class PrecedingUseCasesAction extends Action {

	private ImageDescriptor imageDescriptor;
	private ILabelProvider labelProvider;
	private UseCase useCase;
	private EditingDomain editingDomain;
	
	public PrecedingUseCasesAction(EditingDomain editingDomain, UseCase useCase, ILabelProvider labelProvider) {
		super("Edit preceding use cases");
		this.labelProvider = labelProvider;
		this.useCase = useCase;
		this.editingDomain = editingDomain;
		imageDescriptor = PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD);
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return imageDescriptor;
	}
	
	@Override
	public void run() {
		List<UseCase> choceOfValues = useCase.getSoftwareProjectShortcut().getUseCases();
		
		FeatureEditorDialog dialog = new FeatureEditorDialog(Display.getCurrent().getActiveShell(),
                labelProvider,
                useCase,
                UsecasePackage.Literals.USE_CASE__PRECEDING_USE_CASES,
                "TODO - display name",
                choceOfValues); 
				
        if (dialog.open() == Window.OK) {
        	@SuppressWarnings("unchecked")
			List<UseCase> precedingUseCases = (List<UseCase>) dialog.getResult();
        	
        	Command setCommand = new SetCommand(editingDomain, useCase, UsecasePackage.Literals.USE_CASE__PRECEDING_USE_CASES, precedingUseCases);
    		editingDomain.getCommandStack().execute(setCommand);
        }
	}
}
