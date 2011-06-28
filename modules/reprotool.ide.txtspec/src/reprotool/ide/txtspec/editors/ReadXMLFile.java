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
import org.osgi.framework.Bundle;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ReadXMLFile {
	
	private static int count;
	private static String output;
	private static Node RootNode;

	ReadXMLFile() {
		output = "";
		count = -1;
	}

	@SuppressWarnings("unused")
	private static void removeTags(Node RootNode) {

		NodeList nList = RootNode.getChildNodes();
		int i, j;
		String whitespace;
		for (i = 0, count += 1; i < nList.getLength(); i++) {
			whitespace = "";
			if (nList.item(i).getNodeValue() != null) {
				whitespace += "\n";
				for (j = 0; j < count; j++)
					whitespace += "\t";
				// output=output+"\033[1;"+(47-count)+"m"+nList.item(i).getNodeValue();
				output = output
						+ nList.item(i).getNodeValue()
								.replace("\n", whitespace);
			}
			removeTags(nList.item(i));
		}
		count--;
		return;
	}

	private static void replaceTags(Node RootNode)
	{
		NodeList nList=RootNode.getChildNodes();
		Node currentNode;
		int i,j;
		for(i=0,count+=1;i<nList.getLength();i++)
		{
			currentNode=nList.item(i);
			if((currentNode.getNodeValue())!=null)
			{
				//for(j=0;j<count;j++)System.out.print("\t");
				//output=output+"\033[1;"+(47-count)+"m"+nList.item(i).getNodeValue();
				NamedNodeMap NNM=currentNode.getAttributes();
				output=output+"<e nid =\"" +count+"\"";
				if(NNM!=null)
				for(j=0;j<NNM.getLength();j++){
					output=output+NNM.item(j).getNodeValue();
				}
				output=output+">"+currentNode.getNodeValue()+"</e>";
			}
			replaceTags(nList.item(i));
		}
		count--;
		return;
	}

	
	// Validate Parse Output
	public String VPO(String XMLString) {

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
			inStream.setCharacterStream(new java.io.StringReader(XMLString));
			
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
			
			replaceTags(RootNode);
		
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
		return output;
	}
	
	public String Overwrite(String parsed,String XMLString) {

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
			inStream.setCharacterStream(new java.io.StringReader(XMLString));
			
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
		return output;
	}
}