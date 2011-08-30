package reprotool.ide.adapter;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import reprotool.ide.editors.UseCaseEditor;
import reprotool.model.usecase.Scenario;
import reprotool.model.usecase.UseCaseStep;

public class ScenarioPropertySource extends AbstractPropertySection {
	
	private Scenario scenario;
	private CCombo typeCombo;
	
	@Override
	public void createControls(final Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		typeCombo = getWidgetFactory().createCCombo(composite);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100);
		data.top = new FormAttachment(0);
		typeCombo.setLayoutData(data);
		
		typeCombo.add("extension");
		typeCombo.add("variation");
		typeCombo.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UseCaseEditor editor = UseCaseEditor.getActiveUseCaseEditor();
				boolean setVariation = typeCombo.getSelectionIndex() == 1;
				editor.saveUndoState();
				UseCaseStep parent = (UseCaseStep)scenario.eContainer();
				// TODO - jvinarek - fix
//				if (setVariation) {
//					parent.getExtension().remove(scenario);
//					parent.getVariation().add(scenario);
//				} else {
//					parent.getVariation().remove(scenario);
//					parent.getExtension().add(0, scenario);
//				}
				editor.setDirty();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		CLabel actorLabel = getWidgetFactory().createCLabel(composite, "Type:");
		data = new FormData();
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(typeCombo, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(typeCombo, 0, SWT.CENTER);
		actorLabel.setLayoutData(data);
	}
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		scenario = (Scenario)((IStructuredSelection)selection).getFirstElement();
	}
	
	@Override
	public void refresh() {
		UseCaseStep parent = (UseCaseStep)scenario.eContainer();
		// TODO - jvinarek - fix
//		typeCombo.select(parent.getExtension().contains(scenario) ? 0 : 1);
	}
}
