package reprotool.ide.editors.usecase;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;

import reprotool.model.linguistic.actionpart.Text;
import reprotool.model.usecase.UseCaseStep;


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
			UseCaseStepLineStyleListener listener = new UseCaseStepLineStyleListener(useCaseStep);
			styledTextCellEditor.getText().addLineStyleListener(listener);
		}
		
		return styledTextCellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		if (element instanceof UseCaseStep) {
			
			UseCaseStep useCaseStep = (UseCaseStep)element;
			
			StringBuilder stringBuilder = new StringBuilder();
			for (Text text : useCaseStep.getTextNodes()) {
				stringBuilder.append(text.getContent());
			}
			
			return stringBuilder.toString();
		}
		
		return element;
	}

	@Override
	protected void setValue(Object element, Object value) {
		// TODO jvinarek
//		((Person) element).setFirstName(String.valueOf(value));
		
		viewer.refresh();
	}
}
