package reprotool.ide;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class ReprotoolIdePerspectiveFactory implements IPerspectiveFactory {
	
	public ReprotoolIdePerspectiveFactory() {
	}

	public void createInitialLayout(IPageLayout myLayout) {
		{
			IFolderLayout folderLayout = myLayout.createFolder("folder", IPageLayout.BOTTOM, 0.66f, IPageLayout.ID_EDITOR_AREA);
			folderLayout.addView("cz.cuni.mff.reprotool.ide.view_parsed_tree");
			folderLayout.addView("cz.cuni.mff.reprotool.ide.views.view_linguistic_tools");
			folderLayout.addView("org.eclipse.ui.views.ProgressView");
		}
		{
			IFolderLayout folderLayout = myLayout.createFolder("folder_1", IPageLayout.RIGHT, 0.66f, IPageLayout.ID_EDITOR_AREA);
			folderLayout.addView("cz.cuni.mff.reprotool.ide.uc_step_view");
		}
		{
			IFolderLayout folderLayout = myLayout.createFolder("folder_2", IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
			folderLayout.addView("org.eclipse.ui.navigator.ProjectExplorer");
		}
	}

}
