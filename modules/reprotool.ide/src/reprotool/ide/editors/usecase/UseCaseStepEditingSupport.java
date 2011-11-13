package reprotool.ide.editors.usecase;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;

import reprotool.ide.utils.Utils;
import reprotool.model.usecase.Condition;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;
import reprotool.model.usecase.UsecasePackage;


/**
 * @author jvinarek
 *
 */
public class UseCaseStepEditingSupport extends EditingSupport {

	private final TreeViewer viewer;

	public UseCaseStepEditingSupport(TreeViewer viewer) {
		super(viewer);
		this.viewer = viewer;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		StyledTextCellEditor styledTextCellEditor = new StyledTextCellEditor(viewer.getTree());
		
		if (element instanceof UseCaseStep) {
			UseCaseStep useCaseStep = (UseCaseStep)element;		
			UseCaseStepStyledTextContent content = new UseCaseStepStyledTextContent(useCaseStep);
			
			// TODO - jvinarek - can this be set more like in another editors by getvalue ?
			styledTextCellEditor.getText().setContent(content);
			
			UseCaseStepLineStyleListener listener = new UseCaseStepLineStyleListener(useCaseStep);
			styledTextCellEditor.getText().addLineStyleListener(listener);
			
			MarkingService.getInstance().setEditorAndContent(content, styledTextCellEditor);
		}
		
		return styledTextCellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		// only use case steps 
		// or extension/variation conditions are editable. 
		//Conditions are not showed but their  text is editable via Scenario node.
		
		return (element instanceof UseCaseStep)
				|| ((element instanceof Scenario) && ((Scenario)element).getScenarioGuard() != null);
	}

	@Override
	protected Object getValue(Object element) {
		if (element instanceof UseCaseStep) {
			UseCaseStep useCaseStep = (UseCaseStep)element;
			return useCaseStep.getContent();
			
		} else if (element instanceof Scenario) {
			Scenario scenario = (Scenario)element;
			
			Assert.isTrue(scenario.getScenarioGuard() != null);			
			Condition cond = scenario.getScenarioGuard();
			
			return cond.getContent();
		}
		
		throw new IllegalStateException("Cannot get editation value for " + element);
	}

	@Override
	protected void setValue(Object element, Object value) {
		if (element instanceof Scenario) {
			Scenario scenario = (Scenario)element;
			
			Condition cond = scenario.getScenarioGuard();
			Assert.isTrue(cond != null);
			
			String newContent = (String)value;
			EditingDomain editingDomain = Utils.getEditingDomain(cond);
			SetCommand setCommand = new SetCommand(editingDomain, cond, UsecasePackage.Literals.PARSEABLE_ELEMENT__CONTENT, newContent);
			editingDomain.getCommandStack().execute(setCommand);
		}
		
		viewer.refresh();
	}
	
}
