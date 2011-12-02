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
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.SaveOptions.Builder;

import reprotool.fm.nusmv.Activator;
import reprotool.fm.nusmv.lang.NuSmvLangStandaloneSetup;
import reprotool.fm.nusmv.lang.nuSmvLang.NuSmvLangFactory;
import reprotool.fm.nusmv.mapping.NuSMVProj;
import reprotool.model.swproj.SoftwareProject;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;


public class SwprojToSMV implements IHandler {

	final private MessageConsoleStream consoleOut = Activator.getDefault().findConsole().newMessageStream();
	
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
		
		// show the console
		consoleOut.getConsole().clearConsole();
		consoleOut.getConsole().activate();

		EObject rootEObj = resource.getContents().get(0);
		
		if( ! (rootEObj instanceof SoftwareProject) ) {
			consoleOut.println("NOT a Software Project : " + rootEObj);
			return null;
		}

		final SoftwareProject swproj = (SoftwareProject) rootEObj;
		consoleOut.println("FOUND Software Project : " + swproj);

		// configuring injector
		Injector injector = Guice.createInjector( new AbstractModule() {
			@Override
			protected void configure() {
				bind(NuSmvLangFactory.class).toInstance(NuSmvLangFactory.eINSTANCE);
				bind(SoftwareProject.class).toInstance(swproj);
				bind(MessageConsoleStream.class).toInstance(consoleOut);
			}
		});
		
		NuSMVProj nusmvProj = injector.getInstance(NuSMVProj.class);
		nusmvProj.transformSoftwareProject();
		Activator.getDefault().setNuSMVProject(nusmvProj); //TODO: why do we use the Activator to keep the nusmvProj reference ?
		
		URI outputUri = uri.appendFileExtension("nusmv");
		consoleOut.println("Will be saved to : " + CommonPlugin.resolve(outputUri).path());
		
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