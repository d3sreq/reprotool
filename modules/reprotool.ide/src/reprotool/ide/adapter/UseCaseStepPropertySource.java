package reprotool.ide.adapter;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import reprotool.ide.editors.UseCaseEditor;
import reprotool.ide.views.TokenWizard;
import reprotool.model.swproj.Actor;

public class UseCaseStepPropertySource extends AbstractPropertySection {
	
	private Text tokenText;
	private CCombo actorCombo;
	private CCombo actionCombo;
	
	@Override
	public void createControls(final Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		FormData data;

		Button tokenButton = getWidgetFactory().createButton(composite, "...", SWT.NONE);
		data = new FormData();
		data.right = new FormAttachment(100);
		data.top = new FormAttachment(0);
		tokenButton.setLayoutData(data);
		
		tokenButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				TokenWizard tw = new TokenWizard(parent.getShell(), SWT.NONE);
				tw.open();
			}
		});

		tokenText = getWidgetFactory().createText(composite, "#exampleToken");
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(tokenButton, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(tokenButton, 0, SWT.CENTER);
		tokenText.setLayoutData(data);

		CLabel tokenLabel = getWidgetFactory().createCLabel(composite, "Token:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(tokenText, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(tokenText, 0, SWT.CENTER);
		tokenLabel.setLayoutData(data);
		
		
		actorCombo = getWidgetFactory().createCCombo(composite);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100);
		data.top = new FormAttachment(tokenText, ITabbedPropertyConstants.VSPACE);
		actorCombo.setLayoutData(data);
		
		UseCaseEditor editor = UseCaseEditor.getActiveUseCaseEditor();
		for (Actor a : editor.getProjectActors()) {
			actorCombo.add(a.getName());
		}
		actorCombo.add("dummy actor 1");
		actorCombo.add("dummy actor 2");
		actorCombo.select(0);

		CLabel actorLabel = getWidgetFactory().createCLabel(composite, "Actor:");
		data = new FormData();
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(actorCombo, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(actorCombo, 0, SWT.CENTER);
		actorLabel.setLayoutData(data);
		
		
		actionCombo = getWidgetFactory().createCCombo(composite);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100);
		data.top = new FormAttachment(actorCombo, ITabbedPropertyConstants.VSPACE);
		actionCombo.setLayoutData(data);
		
		actionCombo.add("action type 1");
		actionCombo.add("action type 2");
		actionCombo.select(0);

		CLabel actionLabel = getWidgetFactory().createCLabel(composite, "Action:");
		data = new FormData();
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(actionCombo, -ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(actionCombo, 0, SWT.CENTER);
		actionLabel.setLayoutData(data);

		Button parseButton = getWidgetFactory().createButton(composite, "Parse this step", SWT.NONE);
		data = new FormData();
		data.left = new FormAttachment(0);
		data.right = new FormAttachment(100);
		data.top = new FormAttachment(actionLabel, ITabbedPropertyConstants.VSPACE);
		parseButton.setLayoutData(data);
		
		parseButton.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				// start linguistic analysis here
			}
		});
	}
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
	}
	
	@Override
	public void refresh() {
	}
}
