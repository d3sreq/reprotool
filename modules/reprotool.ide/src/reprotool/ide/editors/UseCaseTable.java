package reprotool.ide.editors;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
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
import org.eclipse.wb.rcp.databinding.UseCaseStepLabelProvider;

import reprotool.model.specification.UseCase;
import reprotool.model.specification.UseCaseStep;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.emf.databinding.EMFObservables;
import reprotool.model.specification.SpecificationPackage.Literals;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

public class UseCaseTable extends Composite {
	private Table table;
	private TableViewer tableViewer;
	// TODO better way to find the clicked widget
	public boolean focus = false;
	
	private DataBindingContext m_bindingContext;
	private DataBindingContext my_bindingContext;
	
	private UseCase usecase = null;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public UseCaseTable(Composite parent, int style, UseCase uc) {
		super(parent, style);
		usecase = uc;
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(this, SWT.NONE);
		TableColumnLayout tcl_composite = new TableColumnLayout();
		composite.setLayout(tcl_composite);
		
		tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
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
		my_bindingContext = myinitDataBindings();
		m_bindingContext = initDataBindings();
	}
	
	public UseCaseStep selectedStep() {
		return (UseCaseStep)tableViewer.getElementAt(table.getSelectionIndex());
	}
	
	public void setUseCase(UseCase u) {
		usecase = u;
		tableViewer.refresh();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	protected DataBindingContext myinitDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);
		//
		// XXX this breaks the design view
		tableViewer.setLabelProvider(new UseCaseStepLabelProvider());
		//
		IObservableList usecaseUseCaseStepsObserveList = EMFObservables.observeList(Realm.getDefault(), usecase, Literals.USE_CASE__USE_CASE_STEPS);
		tableViewer.setInput(usecaseUseCaseStepsObserveList);
		//
		return bindingContext;
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), UseCaseStep.class, new String[]{"label", "desc"});
		tableViewer.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		//
		tableViewer.setInput(my_bindingContext.getBindings());
		//
		return bindingContext;
	}
}
