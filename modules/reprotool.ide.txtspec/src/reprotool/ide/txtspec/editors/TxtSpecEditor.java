package reprotool.ide.txtspec.editors;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.projection.ProjectionDocument;
import org.eclipse.jface.text.projection.ProjectionDocumentManager;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

public class TxtSpecEditor extends TextEditor {
	
	

//	public TxtSpecEditor(String DocumentContent) 
//	{
//		super();
//		idoc.set(DocumentContent);
//	}
	private Composite compo;
	private ColorManager colorManager;
	private TxtSpecDocumentProvider TSDocProv;
	private NewAnnotationModel annotations;
	private NewAnnotationSupport newAnnotationSupport;
	private NewAnnotationViewer viewer = null;
	private StyledText Text;
	private Annotation[] oldAnnotations;
	private IDocument masterDocument;
	private ProjectionDocumentManager manager;
	private ProjectionDocument projectionDocument;
	
	public TxtSpecEditor(IDocumentProvider iDocumentProvider) 
	{
		super.initializeEditor();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new TxtSpecConfiguration(colorManager,this));
		TSDocProv=new TxtSpecDocumentProvider();
		setDocumentProvider(TSDocProv);
	}

	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

	public void setDocument(String documentContent) {
		TSDocProv.setDocument(documentContent);
        try {
			update();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}//setDocumentProvider(TSDocProv);
	}
	
	public IDocument getMasterDocument()
	{
		return TSDocProv.getDocument();
	}
	
	
	
	/* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
     */
    public void createPartControl(Composite parent)
    {
    	super.createPartControl(parent);
    	Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new FormLayout());
        viewer = new NewAnnotationViewer(container, null, SWT.V_SCROLL);
        //viewer =(NewAnnotationViewer)getSourceViewer();
        
    	newAnnotationSupport = new NewAnnotationSupport(viewer,getAnnotationAccess(),getSharedColors());
		newAnnotationSupport.install();
		//turn projection mode on
		viewer.doOperation(NewAnnotationViewer.TOGGLE);

		IAnnotationModel model= viewer.getVisualAnnotationModel();	
		if (model instanceof IAnnotationModelExtension) {
			IAnnotationModelExtension extension= (IAnnotationModelExtension) model;
			annotations = (NewAnnotationModel) extension.getAnnotationModel(NewAnnotationSupport.NEW_ANNOTATION);
			//annotationModel.collapseAll(0, TSDocProv.getDocument().getLength()-1);
		}
		else
			annotations = null;

        
        FormData fd_text = new FormData();
        fd_text.bottom = new FormAttachment(100, 0);
        fd_text.right = new FormAttachment(100, 0);
        //fd_text.top = new FormAttachment(100, -105);
        fd_text.top = new FormAttachment(0);
        fd_text.left = new FormAttachment(0);
        Text=viewer.getTextWidget();
        
        Text.setLayoutData(fd_text);
//        Text.addExtendedModifyListener(new ExtendedModifyListener() {
//			public void modifyText(ExtendedModifyEvent e) 
//			{
//				handleExtendedModify(e);
//			}
//		});
        
        initializeTextEditor();
                
    	try {
			update();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}   
    }
//    	//super.createPartControl(parent);
//    	viewer =(NewAnnotationViewer)getSourceViewer();
//        
//    	newAnnotationSupport = new NewAnnotationSupport(viewer,getAnnotationAccess(),getSharedColors());
//		newAnnotationSupport.install();
//		
//		//turn projection mode on
//		viewer.doOperation(NewAnnotationViewer.TOGGLE);
//		
//		IAnnotationModel model= viewer.getVisualAnnotationModel();	
//		if (model instanceof IAnnotationModelExtension) {
//			IAnnotationModelExtension extension= (IAnnotationModelExtension) model;
//			annotationModel = (NewAnnotationModel) extension.getAnnotationModel(NewAnnotationSupport.NEW_ANNOTATION);
//			//annotationModel.collapseAll(0, TSDocProv.getDocument().getLength()-1);
//		}
//		else
//			annotationModel = null;
        
//      System.out.println(java.util.Arrays.toString(doc.get().split("<>")));
//        // XXX for testing - add example annotation to the second word
//        if (doc.get().split(" ").length > 1) 
//        {
//        	int start = doc.get().indexOf(" ")+1;
//       	 	int end = doc.get().indexOf(" ", start + 1);
//       	 	if (end == -1)
//       	 		end = doc.get().length();
//       	 	a = new NewAnnotation(ANNOTATION_TYPE, false, doc.get().substring(start, end));
//       	 	annotations.addAnnotation(a, new Position(start, end - start));
//       	 
//       	 	start = doc.get().indexOf("<") + 1;
//       	 	end = doc.get().indexOf(">", start + 1);
//       	 	if (end == -1)
//       	 		end = doc.get().length();
//       	 	b = new NewAnnotation(ANNOTATION_TYPE1, false, doc.get().substring(start, end));
//       	 	annotations.addAnnotation(b, new Position(start, end - start));  
    
    private void update() throws BadLocationException
    {        
		annotations = new NewAnnotationModel();
        annotations.connect(projectionDocument);
//		annotations.connect(masterDocument);
        
//      viewer.setDocument(masterDocument, annotations);
        viewer.setDocument(projectionDocument, annotations);
        projectionDocument.removeMasterDocumentRange(0, masterDocument.getLength());
		
    	NewAnnotation anno;
        int beg=0,end=0,start=0,finish=0,count=-1,flag=0,offset=0;
        count++;
        start=finish;
    	beg=masterDocument.get().indexOf(">",start)+1;
    	end=masterDocument.get().indexOf("<",beg);
    	finish=masterDocument.get().indexOf("<spec", beg);
    	if(finish==-1)
    	{
    		flag=1;
    		finish=masterDocument.get().length()-1;
    	}
    	anno=new NewAnnotation(ANNOTATION_TYPE,false,masterDocument.get().substring(start, finish));
//    	annotations.addAnnotation(anno, new Position(beg,end-beg));
    	
    	projectionDocument.addMasterDocumentRange(beg, end-beg);
		annotations.addAnnotation(anno, new Position(offset,end-beg));
    	offset+=end-beg;
    	
    	//System.out.print(count+" ");
    	count-=masterDocument.get().substring(start, finish).split("</e>").length-1;
    	//System.out.println(count  + doc.get().substring(beg,end));
    	
        while(flag==0)
        {
        	start=finish;
        	finish=masterDocument.get().indexOf("<e", start+1);
        	if(finish==-1)
        	{
        		flag=1;
        		finish=masterDocument.get().length()-1;
        	}
        	while(end<finish)
        	{
        		if(masterDocument.get().charAt(end+1)=='/')count--;
        		else if(masterDocument.get().charAt(end+1)=='e')count++;
    			beg=masterDocument.get().indexOf(">",start)+1;
            	end=masterDocument.get().indexOf("<",beg);
            	if(end==-1)end=finish;
        		while(end<finish && masterDocument.get().substring(beg, end).trim().isEmpty())
        		{
        			if(masterDocument.get().charAt(end+1)=='/')count--;
        			else if(masterDocument.get().charAt(end+1)=='e')count++;
        			beg=masterDocument.get().indexOf(">",end)+1;
                	end=masterDocument.get().indexOf("<",beg);
                	if(end==-1)end=finish;
        		}
        		if(end<=beg)
        		{
        			anno=new NewAnnotation(getAnnotationType(count),false,masterDocument.get().substring(start, finish+1));
        			annotations.addAnnotation(anno, new Position(offset,0));
//        			annotations.addAnnotation(anno, new Position(beg,0));
        		}
        		else
        		{
        			anno=new NewAnnotation(getAnnotationType(count),false,masterDocument.get().substring(start, end));
        			projectionDocument.addMasterDocumentRange(beg, end-beg);
					
        			annotations.addAnnotation(anno, new Position(offset,end-beg));
        			offset+=end-beg;
//        			annotations.addAnnotation(anno, new Position(beg,end-beg));
        			//System.out.println(count +" "+ doc.get().substring(beg, end));
        		}
        		start=end;
        	}
    	}
    }
    
    private String getAnnotationType(int count)
    {
    	switch(count)
    	{
    	case 0:return ANNOTATION_TYPE0;
    	case 1:return ANNOTATION_TYPE1;
    	case 2:return ANNOTATION_TYPE2;
    	case 3:return ANNOTATION_TYPE3;
    	case 4:return ANNOTATION_TYPE4;
    	case 5:return ANNOTATION_TYPE5;
    	default:return ANNOTATION_TYPE;
    	}
    }
    protected void handleExtendedModify(ExtendedModifyEvent e) 
    {
    	if (e.length == 0)
    		return;
    	else
    	{
    		NewAnnotation anno;
    		IDocument doc;
    		Iterator<NewAnnotation> itr=annotations.getAnnotationIterator(e.start,e.length,true,true);
    		doc=TSDocProv.getDocument(this.getEditorInput());
    		while(itr.hasNext()) 
    		{
    			anno = itr.next();
    			anno.setText(doc.get().substring(annotations.getPosition(anno).offset,
				annotations.getPosition(anno).offset+annotations.getPosition(anno).length));
    		} 
    		try {
				update();
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
    	}
	}
//	
//    public void updateFoldingStruct(ArrayList<Position> positions)
//	{
//		Annotation[] annotations = new Annotation[positions.size()];
//		
//		//this will hold the new annotations along
//		//with their corresponding positions
//		HashMap<NewAnnotation, Position> newAnnotations = new HashMap<NewAnnotation, Position>();
//		
//		for(int i =0;i<positions.size();i++)
//		{
//			NewAnnotation annotation = new NewAnnotation(true);
//			annotation.markDeleted(true);
//			//annotation.markCollapsed();
//			annotation.setRangeIndication(true);
//			
//			newAnnotations.put(annotation, positions.get(i));
//			
//			annotations[i]=annotation;
//		}
//		
//		annotationModel.modifyAnnotations(oldAnnotations,newAnnotations,null);
//		oldAnnotations=annotations;
//	}
	
    /* (non-Javadoc)
     * @see org.eclipse.ui.texteditor.AbstractTextEditor#createSourceViewer(org.eclipse.swt.widgets.Composite, org.eclipse.jface.text.source.IVerticalRuler, int)
     */
//    protected ISourceViewer createSourceViewer(Composite parent,
//            IVerticalRuler ruler, int styles)
//    {
//        ISourceViewer viewer = new NewAnnotationViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles);
//
//    	// ensure decoration support has been created and configured.
//    	getSourceViewerDecorationSupport(viewer);
//    	
//    	return viewer;
//    }

//	@Override
//	public void createPartControl(Composite parent)
//	{
//		Composite container = new Composite(parent, SWT.NONE);
//        container.setLayout(new FormLayout());
//        Text = new SourceViewer(container, null, SWT.V_SCROLL);
//        
//        FormData fd_text = new FormData();
//        fd_text.bottom = new FormAttachment(100, 0);
//        fd_text.right = new FormAttachment(100, 0);
//        //fd_text.top = new FormAttachment(100, -105);
//        fd_text.top = new FormAttachment(0);
//        fd_text.left = new FormAttachment(0);
//        Text.getTextWidget().setLayoutData(fd_text);
//
//        
//        initializeTextEditor();
//                       
//        Document doc = new Document();
//        doc.set(idoc.get());
//        AnnotationModel annotations = new AnnotationModel();
//        annotations.connect(doc);
//        Text.setDocument(doc, annotations);
//        Annotation a,b;
//        // XXX for testing - add example annotation to the second word
//        //if (doc.get().split(" ").length > 1) 
//        //{
//       	 int start = doc.get().indexOf(" ")+1;
//       	 int end = doc.get().indexOf(" ", start + 1);
//       	 if (end == -1)
//       		 end = doc.get().length();
//       	 a = new Annotation(ANNOTATION_TYPE, false, doc.get().substring(start, end));
//       	 annotations.addAnnotation(a, new Position(start, end - start));
//        
//       	 
//       	 start = doc.get().indexOf(" ", end + 1) + 1;
//       	 end = doc.get().indexOf(" ", start + 1);
//       	 if (end == -1)
//       		 end = doc.get().length();
//       	 b = new Annotation(ANNOTATION_TYPE1, false, doc.get().substring(start, end));
//       	 annotations.addAnnotation(b, new Position(start, end - start));   	 
//        //}
//       	 Iterator<Annotation> itr=annotations.getAnnotationIterator();
//       	 while(itr.hasNext()) {
//
//       		    b = (Annotation) itr.next(); 
//       		    System.out.print(b.getText());
//
//       		} 
//        Position p=annotations.getPosition(a);
//        System.out.println(p.offset);
//        
//	}

    private static final String ANNOTATION_TYPE = "reprotool.ide.txtspec.tag";
    private static final String KEY_TAG_COLOR_PREF = "tagColor";
    private static final String KEY_TAG_HIGHLIGHT_PREF = "tagHighlight";
    private static final String KEY_TAG_TEXT_PREF = "tagText";
	private static final String ANNOTATION_TYPE0 = "reprotool.ide.txtspec.tag0";
    private static final String KEY_TAG_COLOR_PREF0 = "tagColor0";
    private static final String KEY_TAG_HIGHLIGHT_PREF0 = "tagHighlight0";
    private static final String KEY_TAG_TEXT_PREF0 = "tagText0";
    private static final String ANNOTATION_TYPE1 = "reprotool.ide.txtspec.tag1";
    private static final String KEY_TAG_COLOR_PREF1 = "tagColor1";
    private static final String KEY_TAG_HIGHLIGHT_PREF1 = "tagHighlight1";
    private static final String KEY_TAG_TEXT_PREF1 = "tagText1";
    private static final String ANNOTATION_TYPE2 = "reprotool.ide.txtspec.tag2";
    private static final String KEY_TAG_COLOR_PREF2 = "tagColor2";
    private static final String KEY_TAG_HIGHLIGHT_PREF2 = "tagHighlight2";
    private static final String KEY_TAG_TEXT_PREF2 = "tagTex2";
    private static final String ANNOTATION_TYPE3 = "reprotool.ide.txtspec.tag3";
    private static final String KEY_TAG_COLOR_PREF3 = "tagColor3";
    private static final String KEY_TAG_HIGHLIGHT_PREF3 = "tagHighlight3";
    private static final String KEY_TAG_TEXT_PREF3 = "tagText3";
    private static final String ANNOTATION_TYPE4 = "reprotool.ide.txtspec.tag4";
    private static final String KEY_TAG_COLOR_PREF4 = "tagColor4";
    private static final String KEY_TAG_HIGHLIGHT_PREF4 = "tagHighlight4";
    private static final String KEY_TAG_TEXT_PREF4 = "tagTex4";
    private static final String ANNOTATION_TYPE5 = "reprotool.ide.txtspec.tag5";
    private static final String KEY_TAG_COLOR_PREF5 = "tagColor5";
    private static final String KEY_TAG_HIGHLIGHT_PREF5 = "tagHighlight5";
    private static final String KEY_TAG_TEXT_PREF5 = "tagText5";
    
    @SuppressWarnings("restriction")
	private void initializeTextEditor() 
    { 
        viewer.configure(new SourceViewerConfiguration());
        masterDocument=TSDocProv.getDocument();
        manager = new ProjectionDocumentManager();
        projectionDocument=(ProjectionDocument) manager.createSlaveDocument(masterDocument);
        
        SourceViewerDecorationSupport svds = new SourceViewerDecorationSupport(viewer, null, null, EditorsPlugin.getDefault().getSharedTextColors());
        AnnotationPreference ap = new AnnotationPreference();
        AnnotationPreference ap0 = new AnnotationPreference();
        AnnotationPreference ap1 = new AnnotationPreference();
        AnnotationPreference ap2 = new AnnotationPreference();
        AnnotationPreference ap3 = new AnnotationPreference();
        AnnotationPreference ap4 = new AnnotationPreference();
        AnnotationPreference ap5 = new AnnotationPreference();
        
        ap.setColorPreferenceKey(KEY_TAG_COLOR_PREF);
        ap.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF);
        ap.setTextPreferenceKey(KEY_TAG_TEXT_PREF);
        ap.setAnnotationType(ANNOTATION_TYPE);
        svds.setAnnotationPreference(ap);
        ap0.setColorPreferenceKey(KEY_TAG_COLOR_PREF0);
        ap0.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF0);
        ap0.setTextPreferenceKey(KEY_TAG_TEXT_PREF0);
        ap0.setAnnotationType(ANNOTATION_TYPE0);
        svds.setAnnotationPreference(ap0);
        ap1.setColorPreferenceKey(KEY_TAG_COLOR_PREF1);
        ap1.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF1);
        ap1.setTextPreferenceKey(KEY_TAG_TEXT_PREF1);
        ap1.setAnnotationType(ANNOTATION_TYPE1);
        svds.setAnnotationPreference(ap1);
        ap2.setColorPreferenceKey(KEY_TAG_COLOR_PREF2);
        ap2.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF2);
        ap2.setTextPreferenceKey(KEY_TAG_TEXT_PREF2);
        ap2.setAnnotationType(ANNOTATION_TYPE2);
        svds.setAnnotationPreference(ap2);
        ap3.setColorPreferenceKey(KEY_TAG_COLOR_PREF3);
        ap3.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF3);
        ap3.setTextPreferenceKey(KEY_TAG_TEXT_PREF3);
        ap3.setAnnotationType(ANNOTATION_TYPE3);
        svds.setAnnotationPreference(ap3);
        ap4.setColorPreferenceKey(KEY_TAG_COLOR_PREF4);
        ap4.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF4);
        ap4.setTextPreferenceKey(KEY_TAG_TEXT_PREF4);
        ap4.setAnnotationType(ANNOTATION_TYPE4);
        svds.setAnnotationPreference(ap4);
        ap5.setColorPreferenceKey(KEY_TAG_COLOR_PREF5);
        ap5.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF5);
        ap5.setTextPreferenceKey(KEY_TAG_TEXT_PREF5);
        ap5.setAnnotationType(ANNOTATION_TYPE5);
        svds.setAnnotationPreference(ap5);
        svds.install(EditorsPlugin.getDefault().getPreferenceStore());
    }


	
	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void init(IEditorSite site, IEditorInput input)
//			throws PartInitException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean isDirty() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isSaveAsAllowed() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void setFocus() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void setDocumentContent(String documentContent) {
//		// TODO Auto-generated method stub
//		idoc.set(documentContent);
//	}
}