package cz.cuni.mff.reprotool.ide;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IFolderLayout;

public class ReprotoolIdePerspectiveFactory implements IPerspectiveFactory {
	
	public ReprotoolIdePerspectiveFactory() {
	}

	public void createInitialLayout(IPageLayout myLayout) {
		myLayout.addView("cz.cuni.mff.reprotool.ide.view_parsed_tree", IPageLayout.RIGHT, 0.37f, IPageLayout.ID_EDITOR_AREA);
		{
			IFolderLayout folderLayout = myLayout.createFolder("folder", IPageLayout.BOTTOM, 0.72f, "cz.cuni.mff.reprotool.ide.view_parsed_tree");
			folderLayout.addView("cz.cuni.mff.reprotool.ide.views.view_linguistic_tools");
			folderLayout.addView("org.eclipse.ui.console.ConsoleView");
		}
	}

}
