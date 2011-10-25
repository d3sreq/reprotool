package reprotool.ide.editors.usecase;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;

import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCase;
import reprotool.model.usecase.UseCaseStep;

/**
 * Contains label provider classes used in Use case editor.
 * 
 * @author jvinarek
 * 
 */
public class UsecaseEMFLabelProvider {

	/**
	 * Base class for label providers.
	 * 
	 * @author jvinarek
	 *
	 */
	public static class DefaultUsecaseLabelProvider extends StyledCellLabelProvider {
		
		@Override
		public void update(ViewerCell cell) {
			Object cellObject = cell.getElement();

			if (cellObject instanceof UseCase) {
				updateUseCase(cell, (UseCase) cellObject);
			} else if (cellObject instanceof Scenario) {
				updateScenario(cell, (Scenario) cellObject);	
			} else if (cellObject instanceof UseCaseStep) {
				updateUseCaseStep(cell, (UseCaseStep) cellObject);
			} else {
				updateDefault(cell, cellObject);
			}
		}
		
		protected void updateUseCase(ViewerCell cell, UseCase useCase) {
			updateDefault(cell, useCase);
		}

		protected void updateScenario(ViewerCell cell, Scenario scenario) {
			updateDefault(cell, scenario);			
		}
		
		protected void updateUseCaseStep(ViewerCell cell, UseCaseStep useCaseStep) {
			updateDefault(cell, useCaseStep);			
		}
		
		protected void updateDefault(ViewerCell cell, Object cellObject) {
			cell.setText("");
		}
	}
	
	/**
	 * Provides labels for "Label" column.
	 * 
	 * @author jvinarek
	 *
	 */
	public static class LabelColumnProvider extends DefaultUsecaseLabelProvider {
		@Override
		protected void updateDefault(ViewerCell cell, Object cellObject) {
			// dummy example implementation
			StyledString styledString = new StyledString();
			styledString.append("(X)", StyledString.COUNTER_STYLER);
	
			cell.setText(styledString.getString());
			cell.setStyleRanges(styledString.getStyleRanges());
		}
		
		@Override
		protected void updateScenario(ViewerCell cell, Scenario scenario) {
			StyledString styledString = new StyledString();
			styledString.append(scenario.getLabel(), StyledString.COUNTER_STYLER);
	
			cell.setText(styledString.getString());
			cell.setStyleRanges(styledString.getStyleRanges());
		}
		
		@Override
		protected void updateUseCaseStep(ViewerCell cell, UseCaseStep useCaseStep) {
			StyledString styledString = new StyledString();
			styledString.append(useCaseStep.getLabel(), StyledString.COUNTER_STYLER);
	
			cell.setText(styledString.getString());
			cell.setStyleRanges(styledString.getStyleRanges());
		}
		
	}
	
	/**
	 * Provides labels for "Text" ("Step") column.
	 * 
	 * @author jvinarek
	 *
	 */
	public static class TextColumnProvider extends DefaultUsecaseLabelProvider {
		@Override
		protected void updateUseCase(ViewerCell cell, UseCase useCase) {
			cell.setText(useCase.getName());
		}
		
		@Override
		protected void updateScenario(ViewerCell cell, Scenario scenario) {
			String content;
			if (scenario.getScenarioGuard() == null) {
				// TODO jvinarek - move to resource file
				content = "Main scenario";
			} else {
				content = scenario.getScenarioGuard().getContent();
			}
			
			cell.setText(content);			
		}
		
		@Override
		protected void updateUseCaseStep(ViewerCell cell, UseCaseStep useCaseStep) {
			cell.setText(useCaseStep.getContent());
			cell.setStyleRanges(UseCaseStepStyler.style(useCaseStep));
		}
		
	}
}