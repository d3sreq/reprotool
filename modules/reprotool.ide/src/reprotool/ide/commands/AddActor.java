package reprotool.ide.commands;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import reprotool.ide.dialogs.ActorDetail;
import reprotool.model.swproj.Actor;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.swproj.impl.SwprojFactoryImpl;

/**
 * Command to add actor to project. Used in project explorer
 * 
 * @author jvinarek
 * 
 */
public class AddActor extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IStructuredSelection selection = (IStructuredSelection)HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (!selection.isEmpty()) {
			SoftwareProject softwareProject = (SoftwareProject) selection.getFirstElement();
			
			Shell shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();
			
			Actor newActor = SwprojFactoryImpl.eINSTANCE.createActor();
			List<Actor> possibleParents = softwareProject.getActors();
			
			ActorDetail actorDetail = new ActorDetail(shell, newActor, possibleParents);
			
			if (actorDetail.open() == Window.OK) {
				softwareProject.getActors().add(newActor);
				
				try {
					final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
					saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
							Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
					softwareProject.eResource().save(saveOptions);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

}
