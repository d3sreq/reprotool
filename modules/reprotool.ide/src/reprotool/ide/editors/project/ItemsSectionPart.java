package reprotool.ide.editors.project;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class ItemsSectionPart extends SectionPart {
	private Table table;
	private TableViewer tableViewer;
	private ToolBarManager toolBarManager;

	/**
	 * Create the SectionPart.
	 * @param parent
	 * @param toolkit
	 * @param style
	 */
	public ItemsSectionPart(Composite parent, FormToolkit toolkit, int style) {
		super(parent, toolkit, style);
		Section section = getSection();

		createClient(getSection(), toolkit);
		createSectionToolbar(section, toolkit);
	}
	
	/**
	 * Inspired by {@link org.eclipse.pde.internal.ui.editor.feature.RequiresSection}
	 */
	private void createSectionToolbar(Section section, FormToolkit toolkit) {

		toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(section);

		toolBarManager.update(true);
		section.setTextClient(toolbar);
	}

	/**
	 * Fill the section.
	 */
	private void createClient(Section section, FormToolkit toolkit) {
		section.setText("New SectionPart");
		Composite container = toolkit.createComposite(section);

		section.setClient(container);
		
		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		toolkit.paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("New Column");
		
		TableColumnLayout layout = new TableColumnLayout();
		container.setLayout(layout);
		layout.setColumnData(tblclmnNewColumn, new ColumnWeightData(100));
	}
	
	public TableViewer getTableViewer() {
		return tableViewer;
	}

	public ToolBarManager getToolBarManager() {
		return toolBarManager;
	}
	
}
