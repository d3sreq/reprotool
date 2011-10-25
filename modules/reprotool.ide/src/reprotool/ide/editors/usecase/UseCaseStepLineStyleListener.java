package reprotool.ide.editors.usecase;

import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;

import reprotool.model.usecase.UseCaseStep;

/**
 * @author jvinarek
 *
 */
public class UseCaseStepLineStyleListener implements LineStyleListener {

	private UseCaseStep useCaseStep;

	public UseCaseStepLineStyleListener(UseCaseStep useCaseStep) {
		this.useCaseStep = useCaseStep;
	}
	
	@Override
	public void lineGetStyle(LineStyleEvent event) {
		event.styles = UseCaseStepStyler.style(useCaseStep);
	}

}
