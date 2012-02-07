package reprotool.txtimport.importWizards;

import java.io.File;

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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class OutputSelectionPage extends WizardPage {
	private boolean canFinishExisting = false;
	private boolean canFinishNew = false;
	private boolean canFinishNew2 = false;
	private boolean createNewProj = false;
	
	private Text existingProjTxt = null;
	
	public OutputSelectionPage() {
        super("outputSelectionPage");
        setTitle("Specify output");
        setDescription("Specify the output the wizard will produce");
    }
	
	private void updateFinishButton() {
		getWizard().getContainer().updateButtons();
	}
	
	boolean canFinish() {
		if (createNewProj) {
			return canFinishNew;
		} else {
			return canFinishExisting;
		}
	}
	
	boolean useExistingProj() {
		return (!createNewProj());
	}
	
	boolean createNewProj() {
		return createNewProj;
	}
	
	String existingProjectPath() {
		if (createNewProj) {
			return null;
		}
		
		return existingProjTxt.getText();
	}

    public void createControl(Composite parent) {
        final Composite container = new Composite(parent, SWT.NULL);
        setControl(container);

        container.setLayout(new GridLayout(3, false));
        
        GridData gridData1 = new GridData();
        gridData1.horizontalSpan = 3;
        
        GridData gridData2 = new GridData();
        gridData2.horizontalSpan = 3;
        
        Button existingBtn = new Button(container, SWT.RADIO);
        existingBtn.setText("Import the use-cases into an existing project");
        existingBtn.setLayoutData(gridData1);
        
        Button newProjBtn = new Button(container, SWT.RADIO);
        newProjBtn.setText("Import the use-cases into a new project");
        newProjBtn.setLayoutData(gridData2);
        
        final Label existingProjLbl = new Label(container, SWT.NONE);
        existingProjLbl.setText("Existing project:");
        
        GridData gridData3 = new GridData(GridData.FILL_HORIZONTAL);
        existingProjTxt = new Text(container, SWT.BORDER);
        existingProjTxt.setLayoutData(gridData3);
        
        existingProjTxt.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				boolean redraw = false;
				String projFileName = ((Text) e.widget).getText();
				if (projFileName == null) {
					return;
				}
				File projFile = new File(projFileName);
				if (
						(projFile.exists()) &&
						(projFile.isFile()) &&
						(projFileName.endsWith(".swproj"))
				) {
					if (!canFinishExisting) {
						canFinishExisting = true;
						redraw = true;
					}
				} else {
					if (canFinishExisting) {
						canFinishExisting = false;
						redraw = true;
					}
				}
				
				if (redraw) {
					updateFinishButton();
				}
			}
		});
        
        final Button existingProjBtn = new Button(container, SWT.PUSH);
        existingProjBtn.setText("Browse...");

        existingProjBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				FileDialog dlg = new FileDialog(container.getShell());
				dlg.setFilterExtensions(new String[] {"*.swproj"});
				dlg.setFilterPath(existingProjTxt.getText());
				dlg.setText("Select a reprotool project for import");
				String fileName = dlg.open();
				if (fileName != null) {
					existingProjTxt.setText(fileName);
				}
			}
		});
        
        final Label newProjDirLbl = new Label(container, SWT.NONE);
        newProjDirLbl.setText("Project directory:");
        
        GridData gridData4 = new GridData(GridData.FILL_HORIZONTAL);
        final Text newProjDirTxt = new Text(container, SWT.BORDER);
        newProjDirTxt.setLayoutData(gridData4);
         
        final Button newProjDirBtn = new Button(container, SWT.PUSH);
        newProjDirBtn.setText("Browse...");
        newProjDirBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				DirectoryDialog dlg = new DirectoryDialog(container.getShell());
				dlg.setFilterPath(newProjDirTxt.getText());
				dlg.setText("Select a project directory");
				String dirName = dlg.open();
				if (dirName != null) {
					newProjDirTxt.setText(dirName);
				}
			}
		});
        
        final Label newProjNameLbl = new Label(container, SWT.NONE);
        newProjNameLbl.setText("Project name:");
        final Text newProjNameTxt = new Text(container, SWT.BORDER);
        newProjNameTxt.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				String newProjName = ((Text) e.widget).getText();
				if ((newProjName == null) || (newProjName.isEmpty())) {
					if (canFinishNew) {
						canFinishNew = false;
						updateFinishButton();
					}
					return;
				}
				if (canFinishNew2 && (!canFinishNew)) {
					canFinishNew = true;
					updateFinishButton();
				}
			}
        });
        
        newProjDirTxt.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				boolean redraw = false;
				String projFileName = ((Text) e.widget).getText();
				if (projFileName == null) {
					return;
				}
				File projFile = new File(projFileName);
				if (
						(projFile.exists()) &&
						(projFile.isDirectory())
				) {
					canFinishNew2 = true;
					if (!canFinishNew) {
						if (!newProjNameTxt.getText().isEmpty()) {
							canFinishNew = true;
							redraw = true;
						}
					}
				} else {
					canFinishNew2 = false;
					if (canFinishNew) {
						canFinishNew = false;
						redraw = true;
					}
				}
				
				if (redraw) {
					updateFinishButton();
				}
			}
		});
        
        newProjBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				createNewProj = true;
				
				existingProjTxt.setEnabled(false);
				existingProjLbl.setEnabled(false);
				existingProjBtn.setEnabled(false);
				
				newProjDirLbl.setEnabled(true);
				newProjDirTxt.setEnabled(true);
				newProjDirBtn.setEnabled(true);
				newProjNameLbl.setEnabled(true);
				newProjNameTxt.setEnabled(true);
				
				updateFinishButton();
			}
		});
        
        existingBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				createNewProj = false;
				
				newProjDirLbl.setEnabled(false);
				newProjDirTxt.setEnabled(false);
				newProjDirBtn.setEnabled(false);
				newProjNameLbl.setEnabled(false);
				newProjNameTxt.setEnabled(false);
				
				existingProjTxt.setEnabled(true);
				existingProjLbl.setEnabled(true);
				existingProjBtn.setEnabled(true);
				
				updateFinishButton();
			}
		});
        
        existingBtn.setSelection(true);
        
        newProjDirLbl.setEnabled(false);
		newProjDirTxt.setEnabled(false);
		newProjDirBtn.setEnabled(false);
		newProjNameLbl.setEnabled(false);
		newProjNameTxt.setEnabled(false);
		
		existingProjTxt.setEnabled(true);
		existingProjLbl.setEnabled(true);
		existingProjBtn.setEnabled(true);
    }
}