package reprotool.ide.wizards.project;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import org.eclipse.core.internal.resources.File;

import reprotool.ide.service.Service;

public class ProjectWizard extends Wizard implements INewWizard {

	private static final String WIZARD_PAGE_TITLE = "New Reprotool Project";
	private static final String WIZARD_PAGE_DESCRIPTION = "Create a new Reprotool Project.";
	private static final String WIZARD_PAGE_NAME = "NewReprotoolProject";
	private IWorkbench workbench;
	private IStructuredSelection selection;
	WizardNewProjectCreationPage wizardPage;

	public ProjectWizard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		// TODO - jvinarek - add title and banner
		setWindowTitle("New Reprotool project");
		// setWindowTitle(MessageUtil.getString("New_Readme_File"));
		// setDefaultPageImageDescriptor(ReadmeImages.README_WIZARD_BANNER);

	}

	@Override
	public boolean performFinish() {

		// test
		// final IProject projectHandle = wizardPage.getProjectHandle();
		// java.net.URI projectURI = (!wizardPage.useDefaults()) ? wizardPage
		// .getLocationURI() : null;
		// IWorkspace workspace = ResourcesPlugin.getWorkspace();
		// final IProjectDescription desc = workspace
		// .newProjectDescription(projectHandle.getName());
		// desc.setLocationURI(projectURI);
		// test - end

		try {
			// Remember the file.
			//
//			final IFile modelFile = getModelFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(IProgressMonitor progressMonitor) {
					try {
						// Create project
						//
						IProject projectHandle = wizardPage.getProjectHandle();
						java.net.URI projectURI = (!wizardPage.useDefaults()) ? wizardPage.getLocationURI() : null;
						// java.net.URI projectURI =
						// wizardPage.getLocationURI();

						IWorkspace workspace = ResourcesPlugin.getWorkspace();

						// TODO - jvinarek description
						IProjectDescription desc = workspace.newProjectDescription(projectHandle.getName());
						desc.setLocationURI(projectURI);

						projectHandle.create(desc, progressMonitor);

						// Create a resource set
						//
						ResourceSet resourceSet = new ResourceSetImpl();

						// Get the URI of the model file.
						//
						// URI fileURI1 =
						// URI.createPlatformResourceURI(modelFile
						// .getFullPath().toString(), true);
						// URI test1 =
						// URI.createFileURI(modelFile.getFullPath().toString());
						// URI fileURI =
						// URI.createFileURI("c:\\tmp\\xx.ucproj");
						URI fileURI = URI.createFileURI(projectHandle.getLocation().toString() + "/project.ucproj");

						// URI fileURI = URI.createURI(projectURI.toString()
						// + "\\" + "project.ucproj");

						// URI fileURI = URI.createURI(projectURI.toString()
						// + "\\" + "project.ucproj");

						// Create a resource for this file.
						//
						Resource resource = resourceSet.createResource(fileURI);

						// Add the initial model object to the contents.
						//
						EObject rootObject = createInitialModel();
						if (rootObject != null) {
							resource.getContents().add(rootObject);
						}

						// Save the contents of the resource to the file system.
						//
						Map<Object, Object> options = new HashMap<Object, Object>();
						// TODO - jvinarek - add encoding ?
						// options.put(XMLResource.OPTION_ENCODING,
						// initialObjectCreationPage.getEncoding());
						resource.save(options);
						
						// open project
						projectHandle.open(progressMonitor);
					} catch (Exception exception) {
						// TODO - jvinarek - log
						// ReprotoolEditorPlugin.INSTANCE.log(exception);
						throw new RuntimeException(exception);
					} finally {
						progressMonitor.done();
					}
				}
			};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
//
//			File modelFile = null;
//			
//			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
//			IWorkbenchPage page = workbenchWindow.getActivePage();
//			final IWorkbenchPart activePart = page.getActivePart();
//			if (activePart instanceof ISetSelectionTarget) {
//				final ISelection targetSelection = new StructuredSelection(modelFile);
//				getShell().getDisplay().asyncExec(new Runnable() {
//					public void run() {
//						((ISetSelectionTarget) activePart).selectReveal(targetSelection);
//					}
//				});
//			}
//
//			// Open an editor on the new file.
//			//
//			try {
//				page.openEditor(new FileEditorInput(modelFile),
//						workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString()).getId());
//			} catch (PartInitException exception) {
//				// TODO - jvinarek - open error dialog
//				MessageDialog.openError(workbenchWindow.getShell(), "Open editor problem", exception.getMessage());
//				// MessageDialog.openError(workbenchWindow.getShell(),
//				//
//				//
//				// ReprotoolEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"),
//				// exception.getMessage());
//				return false;
//			}

			return true;
		} catch (Exception exception) {
			// TODO - jvinarek - log
			exception.printStackTrace();
			return false;
		}
	}

	private IFile getModelFile(URI fileUri) {
		// IPath path = wizardPage.getLocationPath();
		// IPath path = wizardPage.getProjectHandle().getFullPath();
		IPath path = new Path("c:\\tmp\\zzz.test");
		String projectFileName = "project.ucproj";
		// IFile result =
		// ResourcesPlugin.getWorkspace().getRoot().getFile(path.append(projectFileName));
		// test
		IFile result = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		return result;
		
//		IFile file = new File
//		return 
	}

	@Override
	public void addPages() {
		wizardPage = new WizardNewProjectCreationPage(WIZARD_PAGE_NAME);
		wizardPage.setDescription(WIZARD_PAGE_DESCRIPTION);
		wizardPage.setTitle(WIZARD_PAGE_TITLE);
		addPage(wizardPage);
	}

	/**
	 * Get the file from the page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	// public IFile getModelFile() {
	// return wizardPage.getModelFile();
	// }

	// TODO - jvinarek - change
	private EObject createInitialModel() {
		return Service.INSTANCE.createSoftwareProject();
	}

}
