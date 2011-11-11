package reprotool.ide.editors.usecase.action;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import reprotool.ide.Activator;
import reprotool.ling.LingTools;
import reprotool.ling.analyser.Analyser;
import reprotool.model.usecase.UseCaseStep;

/**
 * 
 * @author jvinarek
 *
 */
public class AutomaticAnalysisAction extends BaseSelectionListenerAction {

	private ImageDescriptor imageDescriptor;
	
	public AutomaticAnalysisAction(String text) {
		super(text);
		imageDescriptor = Activator.getImageDescriptor("icons/lightning-16x16.png");
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
		// TODO - jvinarek - test only
//		System.out.println(">> " + useCaseStep.getContent());
		
		EditingDomain editingDomain = getEditingDomain(useCaseStep);
		
		CompoundCommand command = LingTools.analyseUseCaseStep(editingDomain, useCaseStep);
		
		// TODO - notify listeners
		command.execute();
	}
	
	private EditingDomain getEditingDomain(EObject eobject) {
		ResourceSet resourceSet = eobject.eResource().getResourceSet();
		// TODO - jvinarek - use guava validation ?
		assert(resourceSet instanceof IEditingDomainProvider);
		EditingDomain editingDomain = ((IEditingDomainProvider)resourceSet).getEditingDomain(); 
        return editingDomain; 
	}
}
