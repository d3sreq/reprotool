package reprotool.ide.editors.project;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class ItemsSectionPart extends SectionPart {
	private Table table;
	private TableViewer tableViewer;

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
		
		ToolBar toolBar = new ToolBar(section, SWT.HORIZONTAL | SWT.FLAT | SWT.LEFT_TO_RIGHT | SWT.DOUBLE_BUFFERED);
		toolkit.adapt(toolBar);
		toolkit.paintBordersFor(toolBar);
		section.setTextClient(toolBar);
		
		ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		toolItem.setText("New Item");
	}

	/**
	 * Fill the section.
	 */
	private void createClient(Section section, FormToolkit toolkit) {
		section.setText("New SectionPart");
		Composite container = toolkit.createComposite(section);

		section.setClient(container);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		toolkit.paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("New Column");
	
	}
	public TableViewer getTableViewer() {
		return tableViewer;
	}
}
