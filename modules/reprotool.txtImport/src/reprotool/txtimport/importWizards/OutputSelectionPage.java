package reprotool.txtimport.importWizards;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class OutputSelectionPage extends WizardPage {
	private boolean canFinishExisting = false;
	private boolean canFinishNew = false;
	private boolean createNewProj = false;
	
	private Text existingProjTxt = null;
	private Text newProjNameTxt = null;
	
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
		if (createNewProj || (existingProjTxt == null)) {
			return null;
		}
		
		return existingProjTxt.getText();
	}
	
	String newProjectName() {
		if (useExistingProj() || (newProjNameTxt == null)) {
			return null;
		}
		
		return newProjNameTxt.getText();
	}
	
	private boolean projectExists(String projName) {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		IProject project = ws.getRoot().getProject(projName);
		return project.exists();
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
        
        final Label newProjNameLbl = new Label(container, SWT.NONE);
        newProjNameLbl.setText("Project name:");
        newProjNameTxt = new Text(container, SWT.BORDER);
        GridData gridData4 = new GridData(96, SWT.DEFAULT);
        System.out.println("Size: " + existingProjTxt.getSize());
        newProjNameTxt.setLayoutData(gridData4);

        newProjNameTxt.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				String newProjName = ((Text) e.widget).getText();
				if ((newProjName == null) || (newProjName.isEmpty()) || (projectExists(newProjName))) {
					if (canFinishNew) {
						canFinishNew = false;
						updateFinishButton();
					}
					return;
				}
				if (!canFinishNew) {
					canFinishNew = true;
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
				
				newProjNameLbl.setEnabled(true);
				newProjNameTxt.setEnabled(true);
				
				updateFinishButton();
			}
		});
        
        existingBtn.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				createNewProj = false;
				
				newProjNameLbl.setEnabled(false);
				newProjNameTxt.setEnabled(false);
				
				existingProjTxt.setEnabled(true);
				existingProjLbl.setEnabled(true);
				existingProjBtn.setEnabled(true);
				
				updateFinishButton();
			}
		});
        
        existingBtn.setSelection(true);
        
		newProjNameLbl.setEnabled(false);
		newProjNameTxt.setEnabled(false);
		
		existingProjTxt.setEnabled(true);
		existingProjLbl.setEnabled(true);
		existingProjBtn.setEnabled(true);		
    }
}