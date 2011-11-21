package reprotool.fm.nusmv.commands;

import java.io.IOException;

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
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.SaveOptions.Builder;

import reprotool.fm.nusmv.Activator;
import reprotool.fm.nusmv.lang.NuSmvLangStandaloneSetup;
import reprotool.fm.nusmv.mapping.NuSMVProj;
import reprotool.model.swproj.SoftwareProject;


public class SwprojToSMV implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if( ! (sel instanceof TreeSelection) )
			return null;
		
		TreeSelection tsel = (TreeSelection) sel;
		IFile ifile = (IFile) tsel.getFirstElement();			
		final ResourceSet rs = new ResourceSetImpl();
		
		// Converting IFile to URI: see http://wiki.eclipse.org/index.php/EMF/FAQ#How_do_I_map_between_an_EMF_Resource_and_an_Eclipse_IFile.3F
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
		System.out.println("FOUND SWPROJ : " + swproj);
		MessageConsole con = Activator.getDefault().findConsole();

		NuSMVProj nusmvProj = null;
		try {
			nusmvProj = new NuSMVProj();
			nusmvProj.NuSMVProj_init(swproj);
		} catch (RuntimeException e) {
			MessageConsoleStream out = con.newMessageStream();
			con.activate();
			out.println("Error: " + e.getMessage());
			return null;
		}
		
		con.clearConsole();
		Activator.getDefault().setNuSMVProject(nusmvProj);
		
		URI outputUri = uri.appendFileExtension("nusmv");
		System.out.println("Will be saved to : " + CommonPlugin.resolve(outputUri).path());
		
		// serialization of the model
		NuSmvLangStandaloneSetup.doSetup(); // activates the correct parser/serializer
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource res = resourceSet.createResource(outputUri);
		
		res.getContents().add(nusmvProj.getModel());

		try {
			// we need to setup options that enable formatting of the result code
			Builder builder = SaveOptions.newBuilder();
			builder.format();
			
			// serializing the code into a file and formatting
			res.save( builder.getOptions().toOptionsMap() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}
}