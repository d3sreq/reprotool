package reprotool.ide.editors.project;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class ItemsComposite extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	
	private Section section;
	private Table table;
	private TableViewer tableViewer;
	private ToolBarManager toolBarManager;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ItemsComposite(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		section = toolkit.createSection(this, Section.TITLE_BAR);
		toolkit.paintBordersFor(section);
		section.setText("New Section");
		section.setExpanded(true);
		
		Composite composite = toolkit.createComposite(section, SWT.NONE);
		toolkit.paintBordersFor(composite);
		section.setClient(composite);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
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
	
	public Section getSection() {
		return section;
	}

	public TableViewer getTableViewer() {
		return tableViewer;
	}

	public ToolBarManager getToolBarManager() {
		return toolBarManager;
	}
}
