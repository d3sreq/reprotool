package reprotool.ide.adapter;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import reprotool.model.usecase.UseCase;

/**
 * Content of the outline view used to show details of the use case.
 * 
 * @author jvinarek
 *
 */
public class UseCaseContentOutlinePage implements IContentOutlinePage {

	private UseCase useCase;
	private Composite container;
	
	public UseCaseContentOutlinePage(UseCase adaptableObject) {
		this.useCase = adaptableObject;
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		
		Label lblUseCaseNameLabel = new Label(container, SWT.NONE);
		lblUseCaseNameLabel.setText("Use case name:");
		
		Label lblUseCaseName = new Label(container, SWT.NONE);
		lblUseCaseName.setText(useCase.getName() == null ? "" : useCase.getName());
		
		// empty row
		new Label(container, SWT.NONE);
		
		Label lblPrimaryActorLabel = new Label(container, SWT.NONE);
		lblPrimaryActorLabel.setText("Primary actor:");
		
		Label lblPrimaryActor = new Label(container, SWT.NONE);
		String primaryActorText = "";
		
//		useCase.getPrimaryActor().eResource().load(Collections.EMPTY_MAP);
		if (useCase.getPrimaryActor() != null && useCase.getPrimaryActor().getName() != null) {
			primaryActorText = useCase.getPrimaryActor().getName();
		}
		
		lblPrimaryActor.setText(primaryActorText);
	}
	
	@Override
	public void dispose() {
	}

	@Override
	public Control getControl() {
		return container;
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
	}

	@Override
	public ISelection getSelection() {
		return null;
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
	}

	@Override
	public void setSelection(ISelection selection) {
	}

}
