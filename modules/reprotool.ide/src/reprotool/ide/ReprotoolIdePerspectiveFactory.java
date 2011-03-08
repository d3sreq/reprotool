package reprotool.ide;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IFolderLayout;

public class ReprotoolIdePerspectiveFactory implements IPerspectiveFactory {
	
	public ReprotoolIdePerspectiveFactory() {
	}

	public void createInitialLayout(IPageLayout myLayout) {
		{
			IFolderLayout mainLayout = myLayout.createFolder("folder", IPageLayout.RIGHT, 0.37f, "cz.cuni.mff.reprotool.ide.view_parsed_tree");
			mainLayout.addView("cz.cuni.mff.reprotool.ide.usecase_step_view");
		}
		{
			IFolderLayout folderLayout = myLayout.createFolder("folder", IPageLayout.BOTTOM, 0.72f, "cz.cuni.mff.reprotool.ide.view_parsed_tree");
			folderLayout.addView("cz.cuni.mff.reprotool.ide.views.view_linguistic_tools");
			folderLayout.addView("org.eclipse.ui.console.ConsoleView");
		}
	}

}
