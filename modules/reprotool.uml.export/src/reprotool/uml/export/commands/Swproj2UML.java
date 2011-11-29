package reprotool.uml.export.commands;

import java.util.HashMap;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;

import reprotool.model.linguistic.action.FromSystem;
import reprotool.model.linguistic.action.ToSystem;
import reprotool.model.linguistic.actionpart.TextRange;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

public class Swproj2UML implements IHandler {
	private HashMap<Actor, org.eclipse.uml2.uml.Class> actor2UML =
			new HashMap<Actor, org.eclipse.uml2.uml.Class>();
	
	private org.eclipse.uml2.uml.Class umlSystem;
	
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	
	private void loadActors(SoftwareProject swproj, Model model) {
		umlSystem = model.createOwnedClass("system", false);
		for (Actor actor : swproj.getActors()) {
			org.eclipse.uml2.uml.Class umlClass = 
				model.createOwnedClass(actor.getName(), false);
			actor2UML.put(actor, umlClass);
		}
	}
	
	private void processUseCaseStep(UseCaseStep step) {
		if (step.getAction() instanceof ToSystem) {
			ToSystem action = (ToSystem) step.getAction();
			if (action.getSentenceActivity() != null) {
				TextRange text = action.getSentenceActivity().getText();
				if (text != null) {
					umlSystem.createOwnedOperation(text.getContent(), null, null);
				}
			}
			return;
		}
		if (step.getAction() instanceof FromSystem) {
			FromSystem action = (FromSystem) step.getAction();
			if (action.getSentenceActivity() != null) {
				Actor actor = action.getReceiver().getActor();
				actor2UML.get(actor).createOwnedOperation(action.getSentenceActivity().getText().getContent(),
						null, null);
			}
			return;
		}
	}
	
	private void processScenario(Scenario scenario) {
		for (UseCaseStep step: scenario.getSteps()) {
			processUseCaseStep(step);
			for (Scenario ext: step.getExtensions()) {
				processScenario(ext);
			}
			for (Scenario var: step.getVariations()) {
				processScenario(var);
			}
		}
	}
	
	private void processUseCase(UseCase uc) {
		processScenario(uc.getMainScenario());
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if( ! (sel instanceof TreeSelection) )
			return null;
		
		TreeSelection tsel = (TreeSelection) sel;
		IFile ifile = (IFile) tsel.getFirstElement();			
		final ResourceSet rs = new ResourceSetImpl();
		
		final URI uri = URI.createPlatformResourceURI(ifile.getFullPath().toString(), true);
		final Resource resource = rs.getResource(uri, true);
		
		if(resource.getContents().size() == 0)
			return null;
		
		EObject rootEObj = resource.getContents().get(0);
		
		if( ! (rootEObj instanceof SoftwareProject) ) {
			System.out.println("NOT a SWPROJ : " + rootEObj);
			return null;
		}
		SoftwareProject swproj = (SoftwareProject) rootEObj;
		
		UMLFactory factory = UMLFactory.eINSTANCE;
		Model model = factory.createModel();
		
		loadActors(swproj, model);
		for (UseCase uc: swproj.getUseCases()) {
			processUseCase(uc);
		}
		
		final URI umlUri = URI.createPlatformResourceURI(
			ifile.getFullPath().addFileExtension(UMLResource.FILE_EXTENSION).toString(),
			true
		);
		
		Resource res = new ResourceSetImpl().createResource(umlUri);
        res.getContents().add(model);

		try {
			res.save(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
