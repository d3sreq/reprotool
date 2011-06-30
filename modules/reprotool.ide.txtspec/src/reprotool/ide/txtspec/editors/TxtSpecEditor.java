package reprotool.ide.txtspec.editors;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.projection.ProjectionDocument;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

@SuppressWarnings("restriction")
public class TxtSpecEditor extends TextEditor {

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
	
	private ColorManager colorManager;
	private NewAnnotationModel annotations;
	private NewAnnotationViewer viewer = null;
	private TxtSpecDocumentManager manager;
	private ProjectionDocument projectionDocument;
	private static Node RootNode;
	private IDocument masterDocument;
    
    private static String[] Nodes;
    private static int count=0;
    private static int index=0;
	
	public TxtSpecEditor(IDocument document) 
	{
		super.initializeEditor();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		masterDocument=document;
	}

	public void dispose() 
	{
		colorManager.dispose();
		super.dispose();
	}

	public void setDocument(String documentContent) 
	{
		masterDocument.set(documentContent);
		ValidateUpdate();
	}
	
	public IDocument getDocument()
	{
		return projectionDocument.getMasterDocument();
	}
	
	@Override
	public void createPartControl(Composite parent)
	{
        viewer = new NewAnnotationViewer(parent, null, SWT.V_SCROLL);
        initializeTextEditor();
        ValidateUpdate(); 
	}

	private void initializeTextEditor() 
    { 
        viewer.configure(new SourceViewerConfiguration());
        manager = new TxtSpecDocumentManager();
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
	
	public void ValidateUpdate() 
	{
		try {
			ErrorHandler handler = new ErrorHandler() {
				public void warning(SAXParseException e) throws SAXException {
					String[] m = new String[3];
					m[0] = "[warning] " + e.getMessage();
					Writer writer = new StringWriter();
					PrintWriter printWriter = new PrintWriter(writer);
					e.printStackTrace(printWriter);
					m[1] = writer.toString();
					m[3] = "SAXParseException Warning";
					new ShowError(m).run();
				}
	
				public void error(SAXParseException e) throws SAXException {
					String[] m = new String[3];
					m[0] = "[error] " + e.getMessage();
					Writer writer = new StringWriter();
					PrintWriter printWriter = new PrintWriter(writer);
					e.printStackTrace(printWriter);
					m[1] = writer.toString();
					m[2] = "SAXParseException Error";
					new ShowError(m).run();
				}
	
				public void fatalError(SAXParseException e) throws SAXException {
					String[] m = new String[3];
					m[0] = "[fatal error] " + e.getMessage();
					Writer writer = new StringWriter();
					PrintWriter printWriter = new PrintWriter(writer);
					e.printStackTrace(printWriter);
					m[1] = writer.toString();
					m[2] = "SAXParseException FatalError";
					new ShowError(m).run();
					throw e;
				}
			};
			// File fXmlFile = new
			// File("/home/d/Apps/eclipse-emf/WORKSPACE/DOMParser/src/abc.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			dbFactory.setNamespaceAware(true);
			// ( gives error if switched on )dbFactory.setValidating(true);
	
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			dBuilder.setErrorHandler(handler);
			
			InputSource inStream = new InputSource();
			inStream.setCharacterStream(new java.io.StringReader(masterDocument.get()));
			
			Document doc = dBuilder.parse(inStream);
			
			RootNode = doc.getDocumentElement();
			RootNode.normalize();
	
			Schema schema = null;
			try {
				String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
				SchemaFactory factory = SchemaFactory.newInstance(language);
				
				Bundle bundle = Platform.getBundle("reprotool.ide.txtspec");
				URL url = bundle.getResource("schema/testxsd.xsd");
				
				schema = factory.newSchema(url);
				//schema = factory.newSchema(new File("/home/d/Apps/eclipse-emf/WORKSPACE/DOMParser/src/testxsd.xsd"));
			} catch (Exception e) {
				String[] m = new String[2];
				m[0] = "[error] " + e.getMessage();
				Writer writer = new StringWriter();
				PrintWriter printWriter = new PrintWriter(writer);
				e.printStackTrace(printWriter);
				m[1] = writer.toString();
				new ShowError(m).run();
			}
			Validator validator = schema.newValidator();
			validator.setErrorHandler(handler);
			validator.validate(new DOMSource(doc));
			
			Update();
		
		} catch (ParserConfigurationException e) {
			String[] m = new String[3];
			m[0] = e.getMessage();
			Writer writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter(writer);
			e.printStackTrace(printWriter);
			m[1] = writer.toString();
			m[2] = "ParseConfigurationException";
			new ShowError(m).run();
		} catch (SAXException e) {
			String[] m = new String[3];
			m[0] = e.getMessage();
			Writer writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter(writer);
			e.printStackTrace(printWriter);
			m[1] = writer.toString();
			m[2] = "SAXException";
			new ShowError(m).run();
		} catch (IOException e) {
			String[] m = new String[3];
			m[0] = e.getMessage();
			Writer writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter(writer);
			e.printStackTrace(printWriter);
			m[1] = writer.toString();
			m[2] = "IOException";
			new ShowError(m).run();
		} catch (Exception e) {
			String[] m = new String[3];
			m[0] = e.getMessage();
			Writer writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter(writer);
			e.printStackTrace(printWriter);
			m[1] = writer.toString();
			m[2] = "General Exception";
			new ShowError(m).run();
		}
		//return output;
	}
	
	private void Update() throws BadLocationException
    {      
    	findlength(RootNode);
		Nodes=new String[index];
		
		for(int i=0;i<index;i++)
		{
			Nodes[i]="";
		}
		
		index=0;
		count=0;
		restructureTree(RootNode);
//		System.out.println(index);
		
        annotations = new NewAnnotationModel();
        annotations.connect(projectionDocument);
//		annotations.connect(masterDocument);
        
//      viewer.setDocument(masterDocument, annotations);
        viewer.setDocument(projectionDocument, annotations);
//      projectionDocument.removeMasterDocumentRange(0, masterDocument.getLength());
        
        int flag=1,a=0,b=0,counter=0;char ch;
        
//        projectionDocument.removeMasterDocumentRange(0, masterDocument.getLength());
        
//        while(counter<index)
//        {
//        	System.out.print(Nodes[counter++]);
//        }
        
        
        while(flag==1)
        {
        	a=masterDocument.get().indexOf("<",b);
        	b=masterDocument.get().indexOf(">",a+1);
        	ch=masterDocument.get().substring(a+1, b).trim().charAt(0);
        	
        	switch(ch)
        	{
        		case '/':
        			if(masterDocument.get().substring(a+2,b).trim().equals("e"))
        			{
        				projectionDocument.removeMasterDocumentRange(a, b-a+1);
//            			b=b+1;
//            			a=masterDocument.get().indexOf("<",b);
//            			if(Nodes[counter++]!=null)
//            			masterDocument.replace(b, a-b+1, Nodes[counter-1]);
            			break;
        			}
        			else if(masterDocument.get().substring(a+2,b).trim().equals("spec"))
        			{
        				projectionDocument.removeMasterDocumentRange(a, b-a+1);
        				flag=0;
        				break;
        			}
        		case 's':
        			if(!masterDocument.get().substring(a+1,b).startsWith("spec "))break;
        		case 'e':
        			projectionDocument.removeMasterDocumentRange(a, b-a+1);
        			b=b+1;
//        			a=masterDocument.get().indexOf("<",b);
//        			System.out.println(counter);
//        			if(Nodes[counter++]!=null)
//        			masterDocument.replace(b, a-b+1, Nodes[counter-1]);
        			break;
        		case '?':
        		case '!':
        		default :
        			b=masterDocument.get().indexOf("<",b)-1;
        			projectionDocument.removeMasterDocumentRange(a, b-a+1);
        			break;
        	}
        }
    	NewAnnotation anno;
    	int count=-1;
        int c=masterDocument.get().indexOf("<");
        
        while(flag==0)
        {
        	a=c;
        	b=masterDocument.get().indexOf(">",a+1);
        	c=masterDocument.get().indexOf("<",b+1);
        	
        	ch=masterDocument.get().substring(a+1, b).trim().charAt(0);
        	
        	switch(ch)
        	{
        		case '/':
        			if(masterDocument.get().substring(a+2,b).trim().equals("e"))
        			{
        				count--;
        				if(c-b-1>0)
    					{
        					projectionDocument.addMasterDocumentRange(b+1, c-b-1);
        					anno=new NewAnnotation(getAnnotationType(count),false,masterDocument.get().substring(b+1, c));
//        					System.out.println("/:" + masterDocument.get().substring(b+1, c));
        					annotations.addAnnotation(anno, new Position(b+1,c-b-1));
    					}
//            			masterDocument.replace(b, a-b, Nodes[counter-1]);
//        				b=b+1;
//            			a=masterDocument.get().indexOf("<",b);
//            			if(Nodes[counter++]!=null)
//            			masterDocument.replace(b, a-b+1, Nodes[counter-1]);
            			break;
        			}
        			else if(masterDocument.get().substring(a+2,b).trim().equals("spec"))
        			{
        				count--;
        				flag=1;
        				System.out.println("flag changed");
        				break;
        			}
        		case 's':
        			if(!masterDocument.get().substring(a+1,b).startsWith("spec "))
    				{
    					count++;
    					if(c-b-1>0)
    					{
    						projectionDocument.addMasterDocumentRange(b+1, c-b-1);
    						anno=new NewAnnotation(getAnnotationType(count),false,masterDocument.get().substring(b+1, c));
    						annotations.addAnnotation(anno, new Position(b+1,c-b-1));
//            				System.out.println("S:" + masterDocument.get().substring(b+1, c));
    					}
    					break;
    				}
        		case 'e':
        			count++;
        			if(c-b-1>0)
					{
						projectionDocument.addMasterDocumentRange(b+1, c-b-1);
	    				anno=new NewAnnotation(getAnnotationType(count),false,masterDocument.get().substring(b+1, c));
	    				annotations.addAnnotation(anno, new Position(b+1,c-b-1));
//	    				System.out.println("E:" + masterDocument.get().substring(b+1, c));
					}
//        			b=b+1;
//        			a=masterDocument.get().indexOf("<",b);
//        			System.out.println(counter);
//        			if(Nodes[counter++]!=null)
//        			masterDocument.replace(b, a-b+1, Nodes[counter-1]);
        			break;
        		case '?':
        		case '!':
        		default :
        			break;
        	}
        }
    }
	
    private static void findlength(Node RootNode) {

		NodeList nList = RootNode.getChildNodes();
		int i;
		
		for (i = 0, count += 1; i < nList.getLength(); i++) {
			index++;
			findlength(nList.item(i));
		}
		count--;
		return;
	}
    
    private static void restructureTree(Node RootNode) 
    {
		NodeList nList = RootNode.getChildNodes();
		int i;
		String S;
		
		for (i = 0, count += 1; i < nList.getLength(); i++) {
			S=""+nList.item(i).getNodeValue();
			Nodes[index++]=Nodes[index]+S;
			restructureTree(nList.item(i));
		}
		count--;
		return;
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
}
//        	finish=masterDocument.get().indexOf("<e", start+1);
//        	if(finish==-1)
//        	{
//        		flag=1;
//        		finish=masterDocument.get().length()-1;
//        	}
//        	do
//        	{
//        		if(masterDocument.get().charAt(end+1)=='/')count--;
//        		else if(masterDocument.get().charAt(end+1)=='e')count++;
//    			beg=masterDocument.get().indexOf(">",start)+1;
//            	end=masterDocument.get().indexOf("<",beg);
//            	if(end==-1)end=finish;
//        		while(end<finish && masterDocument.get().substring(beg, end).trim().isEmpty())
//        		{
//        			if(masterDocument.get().charAt(end+1)=='/')count--;
//        			else if(masterDocument.get().charAt(end+1)=='e')count++;
//        			beg=masterDocument.get().indexOf(">",end)+1;
//                	end=masterDocument.get().indexOf("<",beg);
//                	if(end==-1)end=finish;
//        		}
////        		if(end<=beg)
////        		{
////        			anno=new NewAnnotation(getAnnotationType(count),false,masterDocument.get().substring(start, finish+1));
////        			annotations.addAnnotation(anno, new Position(offset,0));
//////        			annotations.addAnnotation(anno, new Position(beg,0));
////        		}
////        		else
//        		if(end>beg)
//        		{
//        			projectionDocument.addMasterDocumentRange(beg, end-beg);
////        			offsets[index][0]=end-beg + offsets[index-1][0];
//        			anno=new NewAnnotation(getAnnotationType(count),false,masterDocument.get().substring(start, end));
//        			annotations.addAnnotation(anno, new Position(beg,end-beg));
////        			annotations.addAnnotation(anno, new Position(beg,end-beg));
////        			System.out.println(count +" "+ doc.get().substring(beg, end));
//        		}
//        		start=end;
//        	}while(end<finish);
//        	start=finish;
//        for(int i=0;i<index-1;i++)
//        {
//        	anno=new NewAnnotation(getAnnotationType(offsets[i][1]),false,annotationTexts[i]);
//			annotations.addAnnotation(anno, new Position(offsets[i][0],offsets[i+1][0]-offsets[i][0]));
//        }
//	public void createPartControl(Composite parent)
//  {
//  	super.createPartControl(parent);
//  	Composite container = new Composite(parent, SWT.NONE);
//  	container.setLayout(new FormLayout());
//      viewer = new NewAnnotationViewer(parent, null, SWT.V_SCROLL);
      //viewer =(NewAnnotationViewer)getSourceViewer();
      
//  	newAnnotationSupport = new NewAnnotationSupport(viewer,getAnnotationAccess(),getSharedColors());
//		newAnnotationSupport.install();
//		//turn projection mode on
//		viewer.doOperation(NewAnnotationViewer.TOGGLE);

//		IAnnotationModel model= viewer.getVisualAnnotationModel();	
//		if (model instanceof IAnnotationModelExtension) {
//			IAnnotationModelExtension extension= (IAnnotationModelExtension) model;
//			annotations = (NewAnnotationModel) extension.getAnnotationModel(NewAnnotationSupport.NEW_ANNOTATION);
//			//annotationModel.collapseAll(0, TSDocProv.getDocument().getLength()-1);
//		}
//		else
//			annotations = null;

      
//      FormData fd_text = new FormData();
//      fd_text.bottom = new FormAttachment(100, 0);
//      fd_text.right = new FormAttachment(100, 0);
//      //fd_text.top = new FormAttachment(100, -105);
//      fd_text.top = new FormAttachment(0);
//      fd_text.left = new FormAttachment(0);
//      Text=viewer.getTextWidget();
//      Text.setLayoutData(fd_text);
//      
//      Text.setLayoutData(fd_text);
//      Text.addExtendedModifyListener(new ExtendedModifyListener() {
//			public void modifyText(ExtendedModifyEvent e) 
//			{
//				handleExtendedModify(e);
//			}
//		});
      
//      initializeTextEditor();
//      
//  	ValidateUpdate();   
//  }
    
   
	
//	/* (non-Javadoc)
//     * @see org.eclipse.ui.IWorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
//     */
//    public void createPartControl(Composite parent)
//    {
//    	super.createPartControl(parent);
//    	Composite container = new Composite(parent, SWT.NONE);
//        container.setLayout(new FormLayout());
//        viewer = new NewAnnotationViewer(container, null, SWT.V_SCROLL);
//        //viewer =(NewAnnotationViewer)getSourceViewer();
//        
//    	newAnnotationSupport = new NewAnnotationSupport(viewer,getAnnotationAccess(),getSharedColors());
//		newAnnotationSupport.install();
//		//turn projection mode on
//		viewer.doOperation(NewAnnotationViewer.TOGGLE);
//
//		IAnnotationModel model= viewer.getVisualAnnotationModel();	
//		if (model instanceof IAnnotationModelExtension) {
//			IAnnotationModelExtension extension= (IAnnotationModelExtension) model;
//			annotations = (NewAnnotationModel) extension.getAnnotationModel(NewAnnotationSupport.NEW_ANNOTATION);
//			//annotationModel.collapseAll(0, TSDocProv.getDocument().getLength()-1);
//		}
//		else
//			annotations = null;
//
//        
//        FormData fd_text = new FormData();
//        fd_text.bottom = new FormAttachment(100, 0);
//        fd_text.right = new FormAttachment(100, 0);
//        //fd_text.top = new FormAttachment(100, -105);
//        fd_text.top = new FormAttachment(0);
//        fd_text.left = new FormAttachment(0);
//        Text=viewer.getTextWidget();
//        
//        Text.setLayoutData(fd_text);
////        Text.addExtendedModifyListener(new ExtendedModifyListener() {
////			public void modifyText(ExtendedModifyEvent e) 
////			{
////				handleExtendedModify(e);
////			}
////		});
//        
//        initializeTextEditor();
//        
//    	try {
//			update();
//		} catch (BadLocationException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}   
//    }
//    	super.createPartControl(parent);
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
//            
//	public void Validate() {
//
//		try {
//			ErrorHandler handler = new ErrorHandler() {
//				public void warning(SAXParseException e) throws SAXException {
//					String[] m = new String[3];
//					m[0] = "[warning] " + e.getMessage();
//					Writer writer = new StringWriter();
//					PrintWriter printWriter = new PrintWriter(writer);
//					e.printStackTrace(printWriter);
//					m[1] = writer.toString();
//					m[3] = "SAXParseException Warning";
//					new ShowError(m).run();
//				}
//
//				public void error(SAXParseException e) throws SAXException {
//					String[] m = new String[3];
//					m[0] = "[error] " + e.getMessage();
//					Writer writer = new StringWriter();
//					PrintWriter printWriter = new PrintWriter(writer);
//					e.printStackTrace(printWriter);
//					m[1] = writer.toString();
//					m[2] = "SAXParseException Error";
//					new ShowError(m).run();
//				}
//
//				public void fatalError(SAXParseException e) throws SAXException {
//					String[] m = new String[3];
//					m[0] = "[fatal error] " + e.getMessage();
//					Writer writer = new StringWriter();
//					PrintWriter printWriter = new PrintWriter(writer);
//					e.printStackTrace(printWriter);
//					m[1] = writer.toString();
//					m[2] = "SAXParseException FatalError";
//					new ShowError(m).run();
//					throw e;
//				}
//			};
//			// File fXmlFile = new
//			// File("/home/d/Apps/eclipse-emf/WORKSPACE/DOMParser/src/abc.xml");
//			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			dbFactory.setNamespaceAware(true);
//			// ( gives error if switched on )dbFactory.setValidating(true);
//
//			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//			dBuilder.setErrorHandler(handler);
//			
//			InputSource inStream = new InputSource();
//			inStream.setCharacterStream(new java.io.StringReader(projectionDocument.getMasterDocument().get()));
//			
//			Document doc = dBuilder.parse(inStream);
//			
//			RootNode = doc.getDocumentElement();
//			RootNode.normalize();
//
//			Schema schema = null;
//			try {
//				String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
//				SchemaFactory factory = SchemaFactory.newInstance(language);
//				
//				Bundle bundle = Platform.getBundle("reprotool.ide.txtspec");
//				URL url = bundle.getResource("schema/testxsd.xsd");
//				
//				schema = factory.newSchema(url);
//				//schema = factory.newSchema(new File("/home/d/Apps/eclipse-emf/WORKSPACE/DOMParser/src/testxsd.xsd"));
//			} catch (Exception e) {
//				String[] m = new String[2];
//				m[0] = "[error] " + e.getMessage();
//				Writer writer = new StringWriter();
//				PrintWriter printWriter = new PrintWriter(writer);
//				e.printStackTrace(printWriter);
//				m[1] = writer.toString();
//				new ShowError(m).run();
//			}
//			Validator validator = schema.newValidator();
//			validator.setErrorHandler(handler);
//			validator.validate(new DOMSource(doc));
//			
//			//replaceTags(RootNode);
//		
//		} catch (ParserConfigurationException e) {
//			String[] m = new String[3];
//			m[0] = e.getMessage();
//			Writer writer = new StringWriter();
//			PrintWriter printWriter = new PrintWriter(writer);
//			e.printStackTrace(printWriter);
//			m[1] = writer.toString();
//			m[2] = "ParseConfigurationException";
//			new ShowError(m).run();
//		} catch (SAXException e) {
//			String[] m = new String[3];
//			m[0] = e.getMessage();
//			Writer writer = new StringWriter();
//			PrintWriter printWriter = new PrintWriter(writer);
//			e.printStackTrace(printWriter);
//			m[1] = writer.toString();
//			m[2] = "SAXException";
//			new ShowError(m).run();
//		} catch (IOException e) {
//			String[] m = new String[3];
//			m[0] = e.getMessage();
//			Writer writer = new StringWriter();
//			PrintWriter printWriter = new PrintWriter(writer);
//			e.printStackTrace(printWriter);
//			m[1] = writer.toString();
//			m[2] = "IOException";
//			new ShowError(m).run();
//		} catch (Exception e) {
//			String[] m = new String[3];
//			m[0] = e.getMessage();
//			Writer writer = new StringWriter();
//			PrintWriter printWriter = new PrintWriter(writer);
//			e.printStackTrace(printWriter);
//			m[1] = writer.toString();
//			m[2] = "General Exception";
//			new ShowError(m).run();
//		}
//		//return output;
//	}
//    
//    private void update() throws BadLocationException, IOException
//    {      
//        annotations = new NewAnnotationModel();
//        annotations.connect(projectionDocument);
////		annotations.connect(projectionDocument.getMasterDocument());
//        
////      viewer.setDocument(projectionDocument.getMasterDocument(), annotations);
//        viewer.setDocument(projectionDocument, annotations);
//        //projectionDocument.removeprojectionDocument.getMasterDocument()Range(0, projectionDocument.getMasterDocument().getLength());
//        //Validate();
//        
//    	NewAnnotation anno;
//        int beg=0,end=0,start=0,finish=0,count=0,flag=0,index=1,offset=0;
//        int[][] offsets=new int[projectionDocument.getMasterDocument().get().split("<").length][2];
//        String[] annotationTexts=new String[projectionDocument.getMasterDocument().get().split("<").length-1];
//        offsets[0][0]=0;
//        offsets[0][1]=0;
//        start=projectionDocument.getMasterDocument().get().indexOf("<spec");
//        
//        while(flag==0)
//        {
//        	finish=projectionDocument.getMasterDocument().get().indexOf("<e", start+1);
//        	if(finish==-1)
//        	{
//        		flag=1;
//        		finish=projectionDocument.getMasterDocument().get().length()-1;
//        	}
//        	do
//        	{
//        		if(projectionDocument.getMasterDocument().get().charAt(end+1)=='/')count--;
//        		else if(projectionDocument.getMasterDocument().get().charAt(end+1)=='e')count++;
//    			beg=projectionDocument.getMasterDocument().get().indexOf(">",start)+1;
//            	end=projectionDocument.getMasterDocument().get().indexOf("<",beg);
//            	if(end==-1)end=finish;
//        		while(end<finish && projectionDocument.getMasterDocument().get().substring(beg, end).trim().isEmpty())
//        		{
//        			if(projectionDocument.getMasterDocument().get().charAt(end+1)=='/')count--;
//        			else if(projectionDocument.getMasterDocument().get().charAt(end+1)=='e')count++;
//        			beg=projectionDocument.getMasterDocument().get().indexOf(">",end)+1;
//                	end=projectionDocument.getMasterDocument().get().indexOf("<",beg);
//                	if(end==-1)end=finish;
//        		}
////        		if(end<=beg)
////        		{
////        			anno=new NewAnnotation(getAnnotationType(count),false,projectionDocument.getMasterDocument().get().substring(start, finish+1));
////        			annotations.addAnnotation(anno, new Position(offset,0));
//////        			annotations.addAnnotation(anno, new Position(beg,0));
////        		}
////        		else
//        		if(end>beg)
//        		{
//        			projectionDocument.addprojectionDocument.getMasterDocument()Range(beg, end-beg);
////        			offsets[index][0]=end-beg + offsets[index-1][0];
//        			anno=new NewAnnotation(getAnnotationType(count),false,projectionDocument.getMasterDocument().get().substring(start, end));
//        			annotations.addAnnotation(anno, new Position(beg,end-beg));
////        			annotations.addAnnotation(anno, new Position(beg,end-beg));
////        			System.out.println(count +" "+ doc.get().substring(beg, end));
//        		}
//        		//System.in.read(); 
//        		start=end;
//        	}while(end<finish);
//        	start=finish;
//    	}
////        for(int i=0;i<index-1;i++)
////        {
////        	anno=new NewAnnotation(getAnnotationType(offsets[i][1]),false,annotationTexts[i]);
////			annotations.addAnnotation(anno, new Position(offsets[i][0],offsets[i+1][0]-offsets[i][0]));
////        }
//    }
//    
//    protected void handleExtendedModify(ExtendedModifyEvent e) 
//    {
//    	if (e.length == 0)
//    		return;
//    	else
//    	{
//    		NewAnnotation anno;
//    		IDocument doc;
//    		Iterator<NewAnnotation> itr=annotations.getAnnotationIterator(e.start,e.length,true,true);
//    		doc=TSDocProv.getDocument(this.getEditorInput());
//    		while(itr.hasNext()) 
//    		{
//    			anno = itr.next();
//    			anno.setText(doc.get().substring(annotations.getPosition(anno).offset,
//				annotations.getPosition(anno).offset+annotations.getPosition(anno).length));
//    		} 
//    		try {
//				update();
//			} catch (BadLocationException e1) {
//				e1.printStackTrace();
//			} catch (IOException E) {
//				E.printStackTrace();
//			}
//    	}
//	}
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
//	
//    /* (non-Javadoc)
//     * @see org.eclipse.ui.texteditor.AbstractTextEditor#createSourceViewer(org.eclipse.swt.widgets.Composite, org.eclipse.jface.text.source.IVerticalRuler, int)
//     */
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
//
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
//        //XXX for testing - add example annotation to the second word
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
//    
//    private void initializeTextEditor() 
//    { 
//        viewer.configure(new SourceViewerConfiguration());
//        projectionDocument.getMasterDocument()=TSDocProv.getDocument();
//        manager = new TxtSpecDocumentManager();
//        projectionDocument=(ProjectionDocument) manager.createSlaveDocument(projectionDocument.getMasterDocument());
//        
//        SourceViewerDecorationSupport svds = new SourceViewerDecorationSupport(viewer, null, null, EditorsPlugin.getDefault().getSharedTextColors());
//        AnnotationPreference ap = new AnnotationPreference();
//        AnnotationPreference ap0 = new AnnotationPreference();
//        AnnotationPreference ap1 = new AnnotationPreference();
//        AnnotationPreference ap2 = new AnnotationPreference();
//        AnnotationPreference ap3 = new AnnotationPreference();
//        AnnotationPreference ap4 = new AnnotationPreference();
//        AnnotationPreference ap5 = new AnnotationPreference();
//        
//        ap.setColorPreferenceKey(KEY_TAG_COLOR_PREF);
//        ap.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF);
//        ap.setTextPreferenceKey(KEY_TAG_TEXT_PREF);
//        ap.setAnnotationType(ANNOTATION_TYPE);
//        svds.setAnnotationPreference(ap);
//        ap0.setColorPreferenceKey(KEY_TAG_COLOR_PREF0);
//        ap0.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF0);
//        ap0.setTextPreferenceKey(KEY_TAG_TEXT_PREF0);
//        ap0.setAnnotationType(ANNOTATION_TYPE0);
//        svds.setAnnotationPreference(ap0);
//        ap1.setColorPreferenceKey(KEY_TAG_COLOR_PREF1);
//        ap1.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF1);
//        ap1.setTextPreferenceKey(KEY_TAG_TEXT_PREF1);
//        ap1.setAnnotationType(ANNOTATION_TYPE1);
//        svds.setAnnotationPreference(ap1);
//        ap2.setColorPreferenceKey(KEY_TAG_COLOR_PREF2);
//        ap2.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF2);
//        ap2.setTextPreferenceKey(KEY_TAG_TEXT_PREF2);
//        ap2.setAnnotationType(ANNOTATION_TYPE2);
//        svds.setAnnotationPreference(ap2);
//        ap3.setColorPreferenceKey(KEY_TAG_COLOR_PREF3);
//        ap3.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF3);
//        ap3.setTextPreferenceKey(KEY_TAG_TEXT_PREF3);
//        ap3.setAnnotationType(ANNOTATION_TYPE3);
//        svds.setAnnotationPreference(ap3);
//        ap4.setColorPreferenceKey(KEY_TAG_COLOR_PREF4);
//        ap4.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF4);
//        ap4.setTextPreferenceKey(KEY_TAG_TEXT_PREF4);
//        ap4.setAnnotationType(ANNOTATION_TYPE4);
//        svds.setAnnotationPreference(ap4);
//        ap5.setColorPreferenceKey(KEY_TAG_COLOR_PREF5);
//        ap5.setHighlightPreferenceKey(KEY_TAG_HIGHLIGHT_PREF5);
//        ap5.setTextPreferenceKey(KEY_TAG_TEXT_PREF5);
//        ap5.setAnnotationType(ANNOTATION_TYPE5);
//        svds.setAnnotationPreference(ap5);
//        svds.install(EditorsPlugin.getDefault().getPreferenceStore());
//    }