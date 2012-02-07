package reprotool.txtimport.importWizards;

import java.io.File;
import java.io.FileFilter;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;


public class SrcFileContentProvider implements IStructuredContentProvider {
	private static final Object[] EMPTY = new Object[] {};
	
	public Object[] getElements(Object arg0) {
		File file = new File((String) arg0);
		
		if (file.isDirectory()) {
			return file.listFiles(new FileFilter() {
				public boolean accept(File pathName) {
					return pathName.getName().endsWith(".txtuc");
				}
			});
		}
		
		return EMPTY;
	}

	public void dispose() {}
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {}
}