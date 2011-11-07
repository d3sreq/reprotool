package reprotool.fm.nusmv.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lts2.impl.LTSGeneratorImpl;

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
import reprotool.fm.nusmv.Module;
import reprotool.fm.nusmv.NuSMVGenerator;
import reprotool.fm.nusmv.NuSMVProject;
import reprotool.fm.nusmv.NusmvFactory;
import reprotool.fm.nusmv.Scheduler;
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
	 * Helper function same as implode() in PHP.
	 * @param delimiter
	 * @param array
	 * @return String containing elements of the array delimited by the given string
	 */
	private String implode(String delimiter, Object[] array) {
		if (array.length > 0) {
			StringBuffer sb = new StringBuffer();
			sb.append(array[0]);
			for (int i = 1; i < array.length; i++) {
				sb.append(delimiter);
				sb.append(array[i]);
			}
			return sb.toString();
		}
		return "";
	}
	
	@SuppressWarnings("rawtypes")
	private String implode(String delimiter, Collection collection) {
		return implode(delimiter, collection.toArray() );
	}
	
	/**
	 * Helper method that derives identifier of a use-case.
	 * @param useCase
	 * @return The derived identifier 
	 */
	private String uc2id(UseCase useCase) {
		return useCase.getName().replaceAll(" +", "_");
	}
	
	private String[] ucs2ids(Collection<UseCase> list) {
		String[] outstr = new String[list.size()];
		UseCase[] ucs = new UseCase[list.size()];
		ucs = list.toArray( ucs );
		assert ucs.length == outstr.length;
		
		for (int i = 0; i < outstr.length; i++) {
			outstr[i] = uc2id( ucs[i] );
		}
		return outstr;
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

			Scheduler scheduler = NusmvFactory.eINSTANCE.createScheduler();
			for (UseCase useCase : swproj.getUseCases()) {
				Module module = NusmvFactory.eINSTANCE.createModule();
				scheduler.getModules().add(module);
				module.setAdjacentUseCase(useCase);
				System.out.println("Found usecase " + useCase.getName());
				
				LTSGeneratorImpl lts = new LTSGeneratorImpl();
				lts.processUseCase(useCase);
				NuSMVGenerator nusmv = new NuSMVGenerator(lts.getLabelTransitionSystem(), uc2id(useCase));
				generators.add(nusmv);
			}
			
			NuSMVProject nuSMVProj = new NuSMVProject(generators);
						
			String fileName = CommonPlugin.resolve(uri).path() + ".smv";			
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
			
//			String outFilename = ifile.getFullPath().toOSString() + ".smv";
//			
//			try {
//				PrintWriter out = new PrintWriter( outFilename );
//				out.println("MODULE main");
//				
//				String[] ucIds = ucs2ids(swproj.getUseCases());
//				out.print("VAR p : {none, " + implode(", ", ucIds ));
//				
//				out.println("};");
//				
//				out.println("INIT p in none;");
//				out.println("ASSIGN next(p) := case");
//				out.print("p = none : {");
//				
//				for (UseCase useCase : swproj.getUseCases()) {
//					String ucId = "UC_" + useCase.getName().replaceAll(" +", "_");
//					out.print(", p" + ucId );
//					//p = none : {p1,p3,p4,p5};
//				}
//				out.println("};");
//				out.println("TRUE : none;");
//				out.println("esac;");
//				
//				for (UseCase useCase : swproj.getUseCases()) {
//					
//					String ucId = "UC_" + useCase.getName().replaceAll(" +", "_");
//					
//					out.println();
//					out.println("-- ==============================================");
//					out.println("FAIRNESS p=p"+ucId+";");
//					out.println("VAR x"+ucId+" : "+ucId+"(self, run"+ucId+");");
//					out.println("VAR run"+ucId+" : boolean;");
//					out.println("INIT run"+ucId+" in FALSE;");
//					out.println("ASSIGN next(run"+ucId+") := case");
//					out.println("  p=p"+ucId+" : TRUE;");
//					out.println("  TRUE : run"+ucId+";");
//					out.println("esac;");
//					out.println();
//					out.println("MODULE " + ucId + "(top, run)");
//					out.println("VAR s : {s0,s1,sFin};");
//					out.println("INIT s in s0;");
//					out.println("ASSIGN next(s) := case");
//					out.println("  s=s0 & !run : s0; -- waiting");
//					out.println("  s=s0 & run : s1;  -- started");
//					out.println("  s=sFin : sFin;");
//					out.println("esac;");
//				}
//				out.close();
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
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
