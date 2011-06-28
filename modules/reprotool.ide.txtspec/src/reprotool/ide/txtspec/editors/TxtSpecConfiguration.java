package reprotool.ide.txtspec.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class TxtSpecConfiguration extends SourceViewerConfiguration {

	private TxtSpecDoubleClickStrategy doubleClickStrategy;
	private TxtSpecTagScanner tagScanner;
	private TxtSpecScanner scanner;
	private ColorManager colorManager;
	private TxtSpecEditor TSEditor;

	public TxtSpecConfiguration(ColorManager colorManager,TxtSpecEditor TSEditor) {
		this.colorManager = colorManager;
		this.TSEditor = TSEditor;
	}
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {
			IDocument.DEFAULT_CONTENT_TYPE,
			TxtSpecPartitionScanner.XML_COMMENT,
			TxtSpecPartitionScanner.XML_TAG};
	}
	public ITextDoubleClickStrategy getDoubleClickStrategy(
		ISourceViewer sourceViewer,
		String contentType) {
		if (doubleClickStrategy == null)
			doubleClickStrategy = new TxtSpecDoubleClickStrategy();
		return doubleClickStrategy;
	}

	protected TxtSpecScanner getTxtSpecScanner() {
		if (scanner == null) {
			scanner = new TxtSpecScanner(colorManager);
			scanner.setDefaultReturnToken(
				new Token(
					new TextAttribute(
						colorManager.getColor(IXMLColorConstants.DEFAULT))));
		}
		return scanner;
	}
	protected TxtSpecTagScanner getTxtSpecTagScanner() {
		if (tagScanner == null) {
			tagScanner = new TxtSpecTagScanner(colorManager);
			
			TextAttribute textAttr = new TextAttribute(
					colorManager.getColor(IXMLColorConstants.TAG) );
			
			tagScanner.setDefaultReturnToken(
				new Token(textAttr));
		}
		return tagScanner;
	}

	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr =
			new DefaultDamagerRepairer(getTxtSpecTagScanner());
		reconciler.setDamager(dr, TxtSpecPartitionScanner.XML_TAG);
		reconciler.setRepairer(dr, TxtSpecPartitionScanner.XML_TAG);
		
//		dr = new DefaultDamagerRepairer(getTxtSpecScanner());
//		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
//		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		NonRuleBasedDamagerRepairer ndr =
			new NonRuleBasedDamagerRepairer(
				new TextAttribute(
					colorManager.getColor(IXMLColorConstants.XML_COMMENT)));
		reconciler.setDamager(ndr, TxtSpecPartitionScanner.XML_COMMENT);
		reconciler.setRepairer(ndr, TxtSpecPartitionScanner.XML_COMMENT);

		return reconciler;
	}
	/* (non-Javadoc)
     * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getContentAssistant(org.eclipse.jface.text.source.ISourceViewer)
     */
    public IContentAssistant getContentAssistant(ISourceViewer sourceViewer)
    {
        ContentAssistant assistant = new ContentAssistant();
        assistant.setContentAssistProcessor(new TxtSpecContentAssistantProcessor(),IDocument.DEFAULT_CONTENT_TYPE);
        assistant.enableAutoActivation(true);
        
        return assistant;
    }
    /* (non-Javadoc)
     * @see org.eclipse.jface.text.source.SourceViewerConfiguration#getReconciler(org.eclipse.jface.text.source.ISourceViewer)
     */
    
	public IReconciler getReconciler(ISourceViewer sourceViewer)
    {
        TxtSpecReconcilingStrategy strategy = new TxtSpecReconcilingStrategy();
        strategy.setEditor(TSEditor);
        
        MonoReconciler reconciler = new MonoReconciler(strategy,false);
        
        return reconciler;
    }
}
