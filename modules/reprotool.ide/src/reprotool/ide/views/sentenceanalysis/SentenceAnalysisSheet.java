package reprotool.ide.views.sentenceanalysis;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.views.ViewsPlugin;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;

/**
 * Enables user to set details of the use case step (action).
 * 
 * @author jvinarek
 * 
 */
public class SentenceAnalysisSheet extends PageBookView {

	public static final String ID = "reprotool.ide.views.sentenceanalysis.SentenceAnalysisSheet"; //$NON-NLS-1$

	/**
     * The initial selection when the property sheet opens
     */
    private ISelection bootstrapSelection;
	
	@Override
	protected IPage createDefaultPage(PageBook book) {
		
//		IPageBookViewPage page = (IPageBookViewPage) ViewsPlugin.getAdapter(this, ISentenceAnalysisSheetPage.class, false);
//		if (page == null) {
			MessagePage messagePage = new MessagePage();
			messagePage.setMessage("Not interested in this part");
			IPageBookViewPage page = messagePage;
//		}
		initPage(page);
		page.createControl(book);
		return page;
	}
	
	@Override
    protected PageRec doCreatePage(IWorkbenchPart part) {
		// Get a custom property sheet page but not if the part is also a
		// SentenceAnalysisView. In this case the child property sheet would
		// accidentally reuse the parent's property sheet page.
    	if(part instanceof SentenceAnalysisSheet) {
    		return null;
    	}
        ISentenceAnalysisSheetPage page = (ISentenceAnalysisSheetPage) ViewsPlugin.getAdapter(part,
        		ISentenceAnalysisSheetPage.class, false);
        if (page != null) {
            if (page instanceof IPageBookViewPage) {
				initPage((IPageBookViewPage) page);
			}
            page.createControl(getPageBook());
            return new PageRec(part, page);
        }

        // Use the default page
        return null;
    }

	@Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec pageRecord) {
		pageRecord.page.dispose();
	}

	@Override
	protected IWorkbenchPart getBootstrapPart() {
		IWorkbenchPage page = getSite().getPage();
        if (page != null) {
            bootstrapSelection = page.getSelection();
            return page.getActivePart();
        }
        return null;
	}

	@Override
	protected boolean isImportant(IWorkbenchPart part) {
		// Don't interfere with other sentence analysis views
    	String partID = part.getSite().getId();
		boolean isSentenceAnalysisView = getSite().getId().equals(partID);
		return !isSentenceAnalysisView;
	}
}
