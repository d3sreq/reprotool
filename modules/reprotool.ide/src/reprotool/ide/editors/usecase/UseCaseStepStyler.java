package reprotool.ide.editors.usecase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;

import reprotool.model.linguistic.actionpart.ActionPart;
import reprotool.model.linguistic.actionpart.TextRange;
import reprotool.model.usecase.UseCaseStep;

/**
 * @author jvinarek
 *
 */
public class UseCaseStepStyler {
	
	/**
	 * Returns {@link StyleRange}s for given useCaseStep.
	 * 
	 * @param useCaseStep
	 * @return 
	 */
	public static StyleRange[] style(UseCaseStep useCaseStep) {
		List<StyleRange> styleRangeList = new ArrayList<StyleRange>();
		
		for (TextRange text : useCaseStep.getTextNodes()) {
			ActionPart actionPart = text.getActionPart();
			if (actionPart != null) {
				// TODO jvinarek add additional styling
				StyleRange styleRange = new StyleRange();
				styleRange.start = text.getStartPosition();
				styleRange.length = text.getLength();
				
				styleRange.borderStyle = SWT.BORDER_SOLID;
				
				styleRangeList.add(styleRange);
			}
		}
		
		return styleRangeList.toArray(new StyleRange[0]);
	}
	
}
