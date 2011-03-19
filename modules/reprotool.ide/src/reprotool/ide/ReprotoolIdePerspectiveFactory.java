package reprotool.ide;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IFolderLayout;

public class ReprotoolIdePerspectiveFactory implements IPerspectiveFactory {
	
	public ReprotoolIdePerspectiveFactory() {
	}

	public void createInitialLayout(IPageLayout myLayout) {
		{
			IFolderLayout folderLayout = myLayout.createFolder("folder", IPageLayout.BOTTOM, 0.66f, IPageLayout.ID_EDITOR_AREA);
			folderLayout.addView("cz.cuni.mff.reprotool.ide.view_parsed_tree");
			folderLayout.addView("cz.cuni.mff.reprotool.ide.views.view_linguistic_tools");
		}
		{
			IFolderLayout folderLayout = myLayout.createFolder("folder_1", IPageLayout.RIGHT, 0.66f, IPageLayout.ID_EDITOR_AREA);
			folderLayout.addView("cz.cuni.mff.reprotool.ide.uc_step_view");
			folderLayout.addView("cz.cuni.mff.reprotool.ide.view_project");
			folderLayout.addView("cz.cuni.mff.reprotool.ide.uc_step_view");
		}
	}

}
