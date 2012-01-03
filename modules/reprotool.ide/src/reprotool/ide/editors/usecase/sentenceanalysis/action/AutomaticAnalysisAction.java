package reprotool.ide.editors.usecase.sentenceanalysis.action;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import reprotool.ide.Activator;
import reprotool.ling.LingTools;
import reprotool.model.usecase.UseCaseStep;

/**
 * 
 * @author jvinarek
 *
 */
public class AutomaticAnalysisAction extends BaseSelectionListenerAction {

	private ImageDescriptor imageDescriptor;
	private IAction refreshEditorAction;
	
	public AutomaticAnalysisAction(String text, IAction refreshEditorAction) {
		super(text);
		imageDescriptor = Activator.getImageDescriptor("icons/lightning-16x16.png");
		this.refreshEditorAction = refreshEditorAction;
	}
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		// icon from http://www.softplatz.net/Downloads/Desktop/Icons-Cursors/Free-PI-Diagona-Icons-Pack.html
		return imageDescriptor;
	}

	@Override
	public void run() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection == null) {
			return;
		}
		
		Object elem = selection.getFirstElement();
		if (elem == null) {
			return;
		}
		
		if (!(elem instanceof UseCaseStep)) {
			return;
		}
		
		UseCaseStep useCaseStep = (UseCaseStep)elem;
		EditingDomain editingDomain = getEditingDomain(useCaseStep);
		
		CompoundCommand command = LingTools.analyseUseCaseStep(editingDomain, useCaseStep);
		editingDomain.getCommandStack().execute(command);
		
		refreshEditorAction.run();
	}
	
	private EditingDomain getEditingDomain(EObject eobject) {
		ResourceSet resourceSet = eobject.eResource().getResourceSet();
		// TODO - jvinarek - use guava validation ?
		assert(resourceSet instanceof IEditingDomainProvider);
		EditingDomain editingDomain = ((IEditingDomainProvider)resourceSet).getEditingDomain(); 
        return editingDomain; 
	}
}
