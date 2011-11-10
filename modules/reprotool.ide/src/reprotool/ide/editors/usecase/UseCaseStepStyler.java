package reprotool.ide.editors.usecase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import reprotool.model.linguistic.action.Goto;
import reprotool.model.linguistic.action.ToSystem;
import reprotool.model.linguistic.action.UseCaseInclude;
import reprotool.model.linguistic.actionpart.ActionPart;
import reprotool.model.linguistic.actionpart.SentenceActionParam;
import reprotool.model.linguistic.actionpart.SentenceActivity;
import reprotool.model.linguistic.actionpart.SentenceActor;
import reprotool.model.linguistic.actionpart.TextRange;
import reprotool.model.usecase.UseCaseStep;

/**
 * @author jvinarek
 *
 */
public class UseCaseStepStyler {
	
	private static Color senderColor = new Color(Display.getCurrent(), 197, 197, 255);
	private static Color activityColor = new Color(Display.getCurrent(), 197, 255, 245);
	private static Color receiverColor = new Color(Display.getCurrent(), 242, 242, 170);
	private static Color paramColor = new Color(Display.getCurrent(), 255, 223, 187);
	private static Color gotoColor = new Color(Display.getCurrent(), 230, 230, 230);
	private static Color includeUseCaseColor = new Color(Display.getCurrent(), 247, 191, 252);
	private static Color unboundBorderColor = new Color(Display.getCurrent(), 255, 0, 0);
	
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
			
			StyleRange styleRange = new StyleRange();
			styleRange.start = text.getStartPosition();
			styleRange.length = text.getLength();
			
			
			if (actionPart == null) {
				styleRange.borderStyle = SWT.BORDER_DASH;
				styleRange.borderColor = unboundBorderColor;
			} else {
				styleRange.borderStyle = SWT.BORDER_SOLID;
				
				if (actionPart instanceof SentenceActor) {
					// sender or receiver
					if (actionPart.eContainer() instanceof ToSystem) {
						styleRange.background = senderColor;
					} else {
						styleRange.background = receiverColor;
					}
				} else if (actionPart instanceof SentenceActivity) {
					styleRange.background = activityColor;
				} else if (actionPart instanceof SentenceActionParam) {
					styleRange.background = paramColor;
				} else if (actionPart instanceof Goto) {
					styleRange.background = gotoColor;
				} else if (actionPart instanceof UseCaseInclude) {
					styleRange.background = includeUseCaseColor;
				}
			}
				
			styleRangeList.add(styleRange);
			
		}
		
		return styleRangeList.toArray(new StyleRange[0]);
	}
	
	
	
}
