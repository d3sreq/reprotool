package reprotool.ide.editors.usecase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;

import reprotool.model.linguistic.actionpart.ActionPart;
import reprotool.model.linguistic.actionpart.Text;
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
		List<Text> textNodes = useCaseStep.getTextNodes();
		List<StyleRange> styleRangeList = new ArrayList<StyleRange>(textNodes.size());
		
		int start = 0;
		for (Text text : useCaseStep.getTextNodes()) {
			StyleRange styleRange = new StyleRange();
			styleRange.start = start;
			styleRange.length = text.getContent().length();
			
			ActionPart actionPart = text.getActionPart();
			if (actionPart != null) {
				// TODO jvinarek add additional styling
				styleRange.fontStyle = SWT.BOLD;
			}
			
			styleRangeList.add(styleRange);
			start += text.getContent().length();
		}
		
		event.styles = styleRangeList.toArray(new StyleRange[0]);
	}

}
