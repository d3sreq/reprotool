package reprotool.fm.nusmv.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import reprotool.fm.nusmv.Activator;
import reprotool.fm.nusmv.NuSMVWrapper;

public class CheckCTL implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if(sel instanceof TreeSelection) {
			TreeSelection tsel = (TreeSelection) sel;
			IFile file = (IFile) tsel.getFirstElement();
			
			NuSMVWrapper nusmv = Activator.getDefault().getNuSMVWrapper();
			nusmv.clearConsole();
			nusmv.loadModelFile( file );
			nusmv.checkInlineCTLSpec();
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
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}
	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
