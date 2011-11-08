package reprotool.fm.nusmv.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import reprotool.fm.nusmv.NuSMVGenerator;
import reprotool.fm.nusmv.NuSMVProject;
import reprotool.model.swproj.SoftwareProject;
import reprotool.model.usecase.UseCase;


public class SwprojToSMV implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	/**
	 * Helper method that derives identifier of a use-case.
	 * @param useCase
	 * @return The derived identifier 
	 */
	private String uc2id(UseCase useCase) {
		return useCase.getName().replaceAll(" +", "_");
	}
	
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if(sel instanceof TreeSelection) {
			TreeSelection tsel = (TreeSelection) sel;
			IFile ifile = (IFile) tsel.getFirstElement();			
			final ResourceSet rs = new ResourceSetImpl();
			
			// Converting IFile to URI: see http://wiki.eclipse.org/index.php/EMF/FAQ#How_do_I_map_between_an_EMF_Resource_and_an_Eclipse_IFile.3F
			final URI uri = URI.createPlatformResourceURI(ifile.getFullPath().toString(), true);
			final Resource resource = rs.getResource(uri, true);
			
			EObject rootEObj = resource.getContents().get(0);
			
			if( ! (rootEObj instanceof SoftwareProject) ) {
				System.out.println("NOT a SWPROJ : " + rootEObj);
			}

			SoftwareProject swproj = (SoftwareProject) rootEObj;
			System.out.println("FOUND SWPROJ : " + swproj);
			
			List<NuSMVGenerator> generators = new ArrayList<NuSMVGenerator>();

//			Scheduler scheduler = NusmvFactory.eINSTANCE.createScheduler();
//			for (UseCase useCase : swproj.getUseCases()) {
//				Module module = NusmvFactory.eINSTANCE.createModule();
//				scheduler.getModules().add(module);
//				module.setAdjacentUseCase(useCase);
//				System.out.println("Found usecase " + useCase.getName());
//				
//				LTSGenerator lts = new LTSGeneratorImpl();
//				lts.processUseCase(useCase);
//				NuSMVGenerator nusmv = new NuSMVGenerator(lts.getLabelTransitionSystem(), uc2id(useCase));
//				generators.add(nusmv);
//			}
			
			NuSMVProject nuSMVProj = new NuSMVProject(generators);
						
			String fileName = CommonPlugin.resolve(uri).path() + ".nusmv";			
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
				out.write(nuSMVProj.getHeader());
				out.write(nuSMVProj.getProcesses());
				out.write(nuSMVProj.getAnnotations());
				out.write(nuSMVProj.getAutomata());
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
			
//			NuSMVWrapper nusmv = Activator.getDefault().getNuSMVWrapper();
//			nusmv.clearConsole();
//			nusmv.loadModelFile( file );
//			nusmv.checkInlineCTLSpec();
		}
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
