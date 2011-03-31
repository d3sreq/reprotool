package reprotool.ide.editors;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class UseCaseTable extends Composite {
	private Table table;
	// TODO better way to find the clicked widget
	public boolean focus = false;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public UseCaseTable(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(this, SWT.NONE);
		TableColumnLayout tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);
		
		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e)
			{
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				UseCaseEditor editor = (UseCaseEditor) page.getActiveEditor();
				focus = true;
				editor.showSelectedStep();
			}
			@Override
			public void mouseUp(MouseEvent e)
			{
				focus = false;
			}
		});
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableViewerColumn tickColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumnAnalysisResult = tickColumn.getColumn();
		tcl_composite.setColumnData(tableColumnAnalysisResult, new ColumnPixelData(30, false, true));
		
		TableViewerColumn markColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnMark = markColumn.getColumn();
		tcl_composite.setColumnData(tblclmnMark, new ColumnPixelData(60, true, true));
		tblclmnMark.setText("Mark");
		
		TableViewerColumn stepTextColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnStepText = stepTextColumn.getColumn();
		tcl_composite.setColumnData(tblclmnStepText, new ColumnWeightData(1, ColumnWeightData.MINIMUM_WIDTH, true));
		tblclmnStepText.setText("Step text");
		
		TableViewerColumn arrowColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tableColumnAddExtension = arrowColumn.getColumn();
		tcl_composite.setColumnData(tableColumnAddExtension, new ColumnPixelData(30, false, true));
		
		// steps for testing
		TableItem step1 = new TableItem(table, SWT.NONE);
		step1.setText(new String[] {"x", "1", "first step sentence"});
		TableItem step2 = new TableItem(table, SWT.NONE);
		step2.setText(new String[] {"x", "2", "second step sentence"});
		TableItem step3 = new TableItem(table, SWT.NONE);
		step3.setText(new String[] {"x", "3", "third step sentence"});
	}
	
	// TODO return the UseCaseStep instead of String
	public String selectedStep() {
		return table.getItem(table.getSelectionIndex()).getText(2);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
