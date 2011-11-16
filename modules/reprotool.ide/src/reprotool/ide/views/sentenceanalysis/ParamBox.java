package reprotool.ide.views.sentenceanalysis;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * Composite with table having 2 columns - text and combobox.
 * 
 * @author jvinarek
 *
 */
public class ParamBox extends Composite {
	private Group grpActionPart;
	private RowData rowData;
	private Table table;
	private TableColumn tblclmnNewColumn;
	private TableViewerColumn textColumn;
	private TableColumn tblclmnNewColumn_1;
	private TableViewerColumn comboColumn;
	private TableViewer tableViewer;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ParamBox(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		grpActionPart = new Group(this, SWT.NONE);
		// TODO jvinarek - move to property file
		grpActionPart.setText("Action param");
		grpActionPart.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(grpActionPart, SWT.NONE);
		TableColumnLayout tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);
		
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setSize(new Point(200, 0));
		table.setLinesVisible(true);
		
		textColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnNewColumn = textColumn.getColumn();
		tcl_composite.setColumnData(tblclmnNewColumn, new ColumnPixelData(100, true, true));
		tblclmnNewColumn.setText("Text");
		
		comboColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		tblclmnNewColumn_1 = comboColumn.getColumn();
		tcl_composite.setColumnData(tblclmnNewColumn_1, new ColumnPixelData(100, true, true));
		tblclmnNewColumn_1.setText("Conceptual object");

		// TODO - jvinarek - comment
		rowData = new RowData();
		setLayoutData(rowData);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	public Group getGrpActionPart() {
		return grpActionPart;
	}
	
	public void setVisibleAndInclude(boolean visibleAndInclude) {
		this.setVisible(visibleAndInclude);
		this.rowData.exclude = !visibleAndInclude;
	}
	
	public boolean getVisibleAndInclude() {
		return this.isVisible();
	}
	
	public TableViewer getTableViewer() {
		return tableViewer;
	}
	
	public TableViewerColumn getComboColumn() {
		return comboColumn;
	}

	public static class ComboColumnEditingSupport extends ObservableValueEditingSupport {

		private final ComboBoxViewerCellEditor cellEditor;
		private final IEMFValueProperty elementProperty;
		
		public ComboColumnEditingSupport(TableViewer tableViewer, DataBindingContext dbc, IEMFValueProperty elementProperty, ComboBoxViewerCellEditor cellEditor) {
			super(tableViewer, dbc);
			this.cellEditor = cellEditor;
			this.elementProperty = elementProperty;
		}

		@Override
		protected IObservableValue doCreateCellEditorObservable(CellEditor cellEditor) {
			return ViewersObservables.observeSingleSelection(this.cellEditor.getViewer()); 
		}

		@Override
		protected IObservableValue doCreateElementObservable(Object element, ViewerCell cell) {
			return elementProperty.observe(element);
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return cellEditor;
		}
		
	}
}
