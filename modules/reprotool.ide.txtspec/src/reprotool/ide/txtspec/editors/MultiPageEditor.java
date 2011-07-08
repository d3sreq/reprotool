package reprotool.ide.txtspec.editors;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.osgi.framework.Bundle;

/**
 * <li>page 0 contains a xml editor.
 * <li>page 1 contains a txtspec editor.
 * </ul>
 */
public class MultiPageEditor extends MultiPageEditorPart implements
		IResourceChangeListener {

	/** the txtspec editor used in page 1 */
	private TxtSpecEditor TSEditor;
	
	/** the xml editor used in page 0 */
	private XMLEditor xmlEditor;

	/**
	 * Creates a multi-page editor example.
	 */
	public MultiPageEditor() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	void createPage0() {
		try {
			xmlEditor = new XMLEditor();
			int index = addPage(xmlEditor, getEditorInput());
			setPageText(index, xmlEditor.getTitle() + " (Xml View)");
			IDocument inputDocument = xmlEditor.getDocumentProvider()
					.getDocument(xmlEditor.getEditorInput());
			String documentContent = inputDocument.get();
			if (documentContent.isEmpty()) {
				documentContent = "";
				Bundle bundle = Platform.getBundle("reprotool.ide.txtspec");
				URL url = bundle.getResource("schema/default.txtspec.xml");
				try {
					InputStream ir = url.openStream();
					InputStreamReader isr = new InputStreamReader(ir);
					BufferedReader br = new BufferedReader(isr);
					String append;
					if ((documentContent = (br.readLine())) != null)
						;
					while ((append = (br.readLine())) != null)
						documentContent += ("\n" + append);
					br.close();
				} catch (Exception e) {
					System.err.println(e.getMessage() + " " + e.getCause().toString());
				}
				documentContent = documentContent.trim();
				xmlEditor.setDocument(documentContent);
			}			
		} catch (PartInitException e) {
			ErrorDialog.openError(getSite().getShell(),
					"Error creating xml text editor", null, e.getStatus());
		}
	}

	void createPage1() 
	{
		try 
		{
			TSEditor = new TxtSpecEditor(xmlEditor.getDocument());
			int index = addPage(TSEditor, getEditorInput());
			setPageText(index, TSEditor.getTitle() + " (TextSpec View)");
		} 
		catch (PartInitException e) 
		{
			ErrorDialog.openError(getSite().getShell(),"Error creating TextSpec Editor", null, e.getStatus());
		}
	}
	
	/**
	 * Creates the pages of the multi-page editor.
	 */
	protected void createPages() {
		createPage0();
		createPage1();
	}

	/**
	 * The <code>MultiPageEditorPart</code> implementation of this
	 * <code>IWorkbenchPart</code> method disposes all nested editors.
	 * Subclasses may extend.
	 */
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}

	/**
	 * Saves the multi-page editor's document.
	 */
	public void doSave(IProgressMonitor monitor) {
		getEditor(0).doSave(monitor);
		TSEditor.ValidateUpdate();
	}

	/**
	 * Saves the multi-page editor's document as another file. Also updates the
	 * text for page 0's tab, and updates this multi-page editor's input to
	 * correspond to the nested editor's.
	 */
	public void doSaveAs() {
		IEditorPart editor = getEditor(0);
		editor.doSaveAs();
		setPageText(1, editor.getTitle());
		setInput(editor.getEditorInput());
	}

	/*
	 * (non-Javadoc) Method declared on IEditorPart
	 */
	public void gotoMarker(IMarker marker) {
		setActivePage(1);
		IDE.gotoMarker(getEditor(1), marker);
	}

	/**
	 * The <code>MultiPageEditorExample</code> implementation of this method
	 * checks that the input is an instance of <code>IFileEditorInput</code>.
	 */
	public void init(IEditorSite site, IEditorInput editorInput)
			throws PartInitException {
		if (!(editorInput instanceof IFileEditorInput))
			throw new PartInitException(
					"Invalid Input: Must be IFileEditorInput");
		super.init(site, editorInput);
	}

	/*
	 * (non-Javadoc) Method declared on IEditorPart.
	 */
	public boolean isSaveAsAllowed() {
		return true;
	}

	/**
	 * Calculates the contents of page 2 when the it is activated.
	 */
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);
		if (newPageIndex == 1) {
			IDocument inputDocument = xmlEditor.getDocumentProvider()
					.getDocument(xmlEditor.getEditorInput());
			String documentContent = inputDocument.get();
			TSEditor.setDocument(documentContent);
		}else 
			if (newPageIndex == 0) {
				IDocument inputDocument = xmlEditor.getDocumentProvider()
					.getDocument(xmlEditor.getEditorInput());
				String documentContent = inputDocument.get();
				if (documentContent.isEmpty()) {
				documentContent = "";
				Bundle bundle = Platform.getBundle("reprotool.ide.txtspec");
				URL url = bundle.getResource("schema/default.txtspec.xml");
				try {
					InputStream ir = url.openStream();
					InputStreamReader isr = new InputStreamReader(ir);
					BufferedReader br = new BufferedReader(isr);
					String append;
					if ((documentContent = (br.readLine())) != null);
					while ((append = (br.readLine())) != null)
						documentContent += ("\n" + append);
					br.close();
				} catch (Exception e) {
					System.err.println(e.getMessage() + " "+ e.getCause().toString());
				}
				documentContent = documentContent.trim();
			}
			xmlEditor.setDocument(documentContent);			
		} 
	}

	/**
	 * Closes all project files on project close.
	 */
	public void resourceChanged(final IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.PRE_CLOSE) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow()
							.getPages();
					for (int i = 0; i < pages.length; i++) {
						if (((FileEditorInput) xmlEditor.getEditorInput())
								.getFile().getProject()
								.equals(event.getResource())) {
							IEditorPart editorPart = pages[i].findEditor(xmlEditor
									.getEditorInput());
							pages[i].closeEditor(editorPart, true);
						}
					}
				}
			});
		}
	}
}
