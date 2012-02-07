package reprotool.txtimport.importWizards;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class InputSelectionPage extends WizardPage {
	private boolean canGoNext = false;
	private CheckboxTableViewer ctv = null;
	
	public InputSelectionPage() {
        super("wizardPage");
        setTitle("Input selection");
        setDescription("Select the input directory that contains the use-cases you want to import.");
    }
	
	public boolean canFlipToNextPage() {
		return canGoNext;
	}
	
	List<String> getSeelctedUseCases() {
		List<String> result = new ArrayList<String>();
		for (Object obj: ctv.getCheckedElements()) {
			File f = (File) obj;
			result.add(f.getAbsolutePath());
		}
		return result;
	}
	
	private void updateNavigationButtons() {
		boolean redraw = false;
		if (ctv.getCheckedElements().length == 0) {
			if (canGoNext) {
				canGoNext = false;
				redraw = true;
			}
		} else {
			if (!canGoNext) {
				canGoNext = true;
				redraw = true;
			}
		}
		if (redraw) {
			getWizard().getContainer().updateButtons();
		}
	}

    public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		new Label(container, SWT.NONE).setText("Input directory:");
		
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		final Text inputDirTxt = new Text(container, SWT.BORDER);
		inputDirTxt.setLayoutData(gridData);
		
		Button button = new Button(container, SWT.PUSH);
		button.setText("Browse...");
        
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				DirectoryDialog dlg = new DirectoryDialog(container.getShell());
				dlg.setFilterPath(inputDirTxt.getText());
				dlg.setText("Select the input directory");
				String dir = dlg.open();
				if (dir != null) {
					inputDirTxt.setText(dir);
				}
			}
		});
		
		Label infoLabel = new Label(container, SWT.NONE);
		infoLabel.setText("Use-case files to import:");
		GridData gridData2 = new GridData();
        gridData2.horizontalSpan = 3;
		infoLabel.setLayoutData(gridData2);
		
		ctv = CheckboxTableViewer.newCheckList(container, SWT.BORDER);
		GridData ctvGridData = new GridData(GridData.FILL_BOTH);
		ctvGridData.horizontalSpan = 3;
		ctv.getTable().setLayoutData(ctvGridData);
		ctv.setContentProvider(new SrcFileContentProvider());
		ctv.setLabelProvider(new SrcFileLabelProvider());
		
		inputDirTxt.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				ctv.setInput(((Text) e.widget).getText());
				ctv.setAllChecked(true);
				updateNavigationButtons();
			}
		});
		
		ctv.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				updateNavigationButtons();
			}			
		});
	}
}