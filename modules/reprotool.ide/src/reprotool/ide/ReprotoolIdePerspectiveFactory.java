package reprotool.ide;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class ReprotoolIdePerspectiveFactory implements IPerspectiveFactory {
	
	public ReprotoolIdePerspectiveFactory() {
	}

	public void createInitialLayout(IPageLayout myLayout) {
		// moved the definition of views to the Extensions section in the plugin.xml
	}

}
