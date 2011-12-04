package reprotool.ide.editors.usecase;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;

import reprotool.ide.editors.project.ItemsSectionPart;

/**
 * Composite containing TreeViewer with use case steps. Class is expected to be
 * modified with visual editor (window builder pro).
 * 
 * @author jvinarek
 * 
 */
public class UsecaseEMFEditorComposite extends Composite {

	private TreeViewer treeViewer;

	private final TreeViewerColumn labelColumn;
	private final TreeViewerColumn textColumn;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private final Form form;
	private final UseCasePropertiesSectionPart useCasePropertiesSectionPart;
	private final ItemsSectionPart precedingUseCasesPart;
	
	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public UsecaseEMFEditorComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		form = formToolkit.createForm(this);
		formToolkit.paintBordersFor(form);
		formToolkit.decorateFormHeading(form);
		form.setText("Use case");
		form.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = formToolkit.createComposite(form.getBody(), SWT.NONE);
		formToolkit.paintBordersFor(composite);
		composite.setLayout(new GridLayout(2, false));
		
		useCasePropertiesSectionPart = new UseCasePropertiesSectionPart(composite, formToolkit, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		Section sctnUseCaseProperties = useCasePropertiesSectionPart.getSection();
		sctnUseCaseProperties.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		formToolkit.paintBordersFor(sctnUseCaseProperties);
		
		precedingUseCasesPart = new ItemsSectionPart(composite, formToolkit, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		Section sctnNewSectionpart = precedingUseCasesPart.getSection();
		sctnNewSectionpart.setText("Preceding use cases");
		sctnNewSectionpart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		formToolkit.paintBordersFor(sctnNewSectionpart);

		treeViewer = new TreeViewer(composite, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		tree.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);

		labelColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		labelColumn.getColumn().setWidth(130);
		labelColumn.getColumn().setText("Label");

		textColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		textColumn.getColumn().setWidth(400);
		textColumn.getColumn().setText("Text");
	}

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	public TreeViewerColumn getLabelColumn() {
		return labelColumn;
	}

	public TreeViewerColumn getTextColumn() {
		return textColumn;
	}
	
	public Form getForm() {
		return form;
	}

	public UseCasePropertiesSectionPart getUseCasePropertiesSectionPart() {
		return useCasePropertiesSectionPart;
	}

	public ItemsSectionPart getPrecedingUseCasesPart() {
		return precedingUseCasesPart;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
