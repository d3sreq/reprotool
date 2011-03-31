package reprotool.ide.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;

public class UseCaseEditor extends EditorPart {

	public static final String ID = "cz.cuni.mff.reprotool.ide.editors.UseCaseEditor"; //$NON-NLS-1$
	
	private UseCaseTable mainScenario = null;
	private UseCaseTable extensions = null;

	public UseCaseEditor() {
	}
	
	// TODO this will be fixed
	public String getSelectedStep() {
		UseCaseTable focused = null;
		if (mainScenario.focus)
			focused = mainScenario;
		else if (extensions.focus)
			focused = extensions;
		return focused.selectedStep();
	}
	
	public void showSelectedStep()
	{
		IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
		try {
			handlerService.executeCommand("commands.showStep", null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(container, SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		
		mainScenario = new UseCaseTable(composite, SWT.NONE);
		
		Label labelMainScenario = new Label(composite, SWT.NONE);
		labelMainScenario.setText("Main scenario");
		GroupLayout gl_composite = new GroupLayout(composite);
		gl_composite.setHorizontalGroup(
			gl_composite.createParallelGroup(GroupLayout.LEADING)
				.add(gl_composite.createSequentialGroup()
					.add(gl_composite.createParallelGroup(GroupLayout.LEADING)
						.add(gl_composite.createSequentialGroup()
							.addContainerGap()
							.add(labelMainScenario))
						.add(gl_composite.createSequentialGroup()
							.add(10)
							.add(mainScenario, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_composite.setVerticalGroup(
			gl_composite.createParallelGroup(GroupLayout.LEADING)
				.add(gl_composite.createSequentialGroup()
					.addContainerGap()
					.add(labelMainScenario)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(mainScenario, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
		);
		composite.setLayout(gl_composite);
		
		Composite composite_1 = new Composite(sashForm, SWT.NONE);
		
		Button btnUp = new Button(composite_1, SWT.NONE);
		btnUp.setText("Up");
		
		Button btnDown = new Button(composite_1, SWT.NONE);
		btnDown.setText("Down");
		
		Button btnAdd = new Button(composite_1, SWT.NONE);
		btnAdd.setText("Add");
		
		Button btnDelete = new Button(composite_1, SWT.NONE);
		btnDelete.setText("Delete");
//		btnDelete.setImage(getImage());
		
		extensions = new UseCaseTable(composite_1, SWT.NONE);
		
		Label labelExtensionsAndVariations = new Label(composite_1, SWT.NONE);
		labelExtensionsAndVariations.setText("Extensions and variations");
		GroupLayout gl_composite_1 = new GroupLayout(composite_1);
		gl_composite_1.setHorizontalGroup(
			gl_composite_1.createParallelGroup(GroupLayout.LEADING)
				.add(gl_composite_1.createSequentialGroup()
					.addContainerGap()
					.add(gl_composite_1.createParallelGroup(GroupLayout.LEADING)
						.add(extensions, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.add(gl_composite_1.createSequentialGroup()
							.add(btnUp, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(btnDown, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(btnAdd, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(btnDelete, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.add(labelExtensionsAndVariations))
					.addContainerGap())
		);
		gl_composite_1.setVerticalGroup(
			gl_composite_1.createParallelGroup(GroupLayout.LEADING)
				.add(GroupLayout.TRAILING, gl_composite_1.createSequentialGroup()
					.addContainerGap()
					.add(labelExtensionsAndVariations)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(extensions, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(gl_composite_1.createParallelGroup(GroupLayout.BASELINE)
						.add(btnUp)
						.add(btnDown)
						.add(btnAdd)
						.add(btnDelete))
					.addContainerGap())
		);
		composite_1.setLayout(gl_composite_1);
		sashForm.setWeights(new int[] {211, 260});

	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// Initialize the editor part
		setSite(site);
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
	
	private Image getDeleteImage() {
		return PlatformUI.getWorkbench().getSharedImages().getImage(org.eclipse.ui.ISharedImages.IMG_TOOL_DELETE);
	}
}
