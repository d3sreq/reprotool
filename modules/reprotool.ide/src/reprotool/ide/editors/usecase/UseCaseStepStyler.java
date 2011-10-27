package reprotool.ide.editors.usecase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;

import reprotool.model.linguistic.actionpart.ActionPart;
import reprotool.model.linguistic.actionpart.Text;
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
		
		int start = 0;
		for (Text text : useCaseStep.getTextNodes()) {
			
			ActionPart actionPart = text.getActionPart();
			if (actionPart != null) {
				// TODO jvinarek add additional styling
				StyleRange styleRange = new StyleRange();
				styleRange.start = start;
				styleRange.length = text.getContent().length();
				
				styleRange.borderStyle = SWT.BORDER_SOLID;
				
				styleRangeList.add(styleRange);
			}
			
			start += text.getContent().length();
		}
		
		return styleRangeList.toArray(new StyleRange[0]);
	}
	
}
