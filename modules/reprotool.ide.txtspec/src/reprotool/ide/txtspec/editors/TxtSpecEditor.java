package reprotool.ide.txtspec.editors;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;

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
import org.eclipse.jface.text.projection.ProjectionDocumentManager;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
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
	private AnnotationModel annotations;
	private SourceViewer viewer = null;
	private ProjectionDocumentManager manager;
	private ProjectionDocument projectionDocument;
	private ProjectionDocument txtspecDocument;
	private static Node RootNode;
	private IDocument masterDocument;
    
//    private static String[] Nodes;
//    private static int count=0;
//    private static int index=0;
	
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
		//masterDocument.set(documentContent);
		ValidateUpdate();
	}
	
	public IDocument getDocument()
	{
		return projectionDocument.getMasterDocument();
	}
	
	@Override
	public void createPartControl(Composite parent)
	{
        viewer = new SourceViewer(parent, null, SWT.V_SCROLL);
        initializeTextEditor();
        ValidateUpdate(); 
	}

	private void initializeTextEditor() 
    { 
        viewer.configure(new SourceViewerConfiguration());
        manager = new ProjectionDocumentManager();
        projectionDocument=(ProjectionDocument) manager.createSlaveDocument(masterDocument);
        txtspecDocument=(ProjectionDocument) manager.createSlaveDocument(projectionDocument);
        
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
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			dbFactory.setNamespaceAware(true);
			
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
	}
	
	private void Update() throws BadLocationException
    {      
		
        annotations = new AnnotationModel();
        projectionDocument.addMasterDocumentRange(0, masterDocument.getLength());
         
        int flag=1,a=0,b=0;char ch;
        int c=masterDocument.get().indexOf("<");
        
        while(flag==1)
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
        				projectionDocument.removeMasterDocumentRange(a, b-a+1);
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
        			break;
        		case '?':
        		case '!':
        		default :
        			projectionDocument.removeMasterDocumentRange(a, c-a);
        			break;
        	}
        }
    	Annotation anno;
    	int count=-1,chars_deleted=0;
        c=masterDocument.get().indexOf("<");

        txtspecDocument.addMasterDocumentRange(0, projectionDocument.getLength());
        viewer.setDocument(txtspecDocument,annotations);
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
        				chars_deleted+=b-a+1;
        				count--;
        				if(c-b-1>0)
    					{
        					anno=new Annotation(getAnnotationType(count),false,masterDocument.get().substring(b+1, c));
        					annotations.addAnnotation(anno, new Position(b+1-chars_deleted,c-b-1));
    					}
            			break;
        			}
        			else if(masterDocument.get().substring(a+2,b).trim().equals("spec"))
        			{
        				chars_deleted+=b-a+1;
        				count--;
        				flag=1;
        				break;
        			}
        		case 's':
        			if(!masterDocument.get().substring(a+1,b).startsWith("spec "))
    				{
    					count++;
    					if(c-b-1>0)
    					{
    						anno=new Annotation(getAnnotationType(count),false,masterDocument.get().substring(b+1, c));
    						annotations.addAnnotation(anno, new Position(b+1-chars_deleted,c-b-1));
    					}
    					break;
    				}
        		case 'e':
        			count++;
    				chars_deleted+=b-a+1;
        			if(c-b-1>0)
					{
	    				anno=new Annotation(getAnnotationType(count),false,masterDocument.get().substring(b+1, c));
	    				annotations.addAnnotation(anno, new Position(b+1-chars_deleted,c-b-1));
					}
        			break;
        		case '?':
        		case '!':
        		default :
    				chars_deleted+=c-a;
        			break;
        	}
        }
    }
	
//    private static void findlength(Node RootNode) {
//
//		NodeList nList = RootNode.getChildNodes();
//		int i;
//		
//		for (i = 0, count += 1; i < nList.getLength(); i++) {
//			index++;
//			findlength(nList.item(i));
//		}
//		count--;
//		return;
//	}
//    
//    private static void restructureTree(Node RootNode) 
//    {
//		NodeList nList = RootNode.getChildNodes();
//		int i;
//		String S;
//		
//		for (i = 0, count += 1; i < nList.getLength(); i++) {
//			S=""+nList.item(i).getNodeValue();
//			Nodes[index++]=Nodes[index]+S;
//			restructureTree(nList.item(i));
//		}
//		count--;
//		return;
//	}

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