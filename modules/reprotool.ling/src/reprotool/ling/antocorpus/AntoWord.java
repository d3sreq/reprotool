package reprotool.ling.antocorpus;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class AntoWord {
	private String text = "";
	private String antonym = "";
	private String POS = "";
	private int id;

	public AntoWord() {
		super();
	}
	
	public AntoWord(String text) {
		super();
		this.text = text;
	}

	public AntoWord(String text, int id) {
		super();
		this.text = text;
		this.id = id;
	}
	
	public AntoWord(String text, String antonym, String POS) {
		super();
		this.text = text;
		this.antonym = antonym;
		this.POS = POS;
	}

	public AntoWord(String text, String antonym, String POS, int id) {
		super();
		this.text = text;
		this.antonym = antonym;
		this.POS = POS;
		this.id = id;
	}
		
	@Override
	public String toString() {
		return text;
	}

	public void write(XMLEventWriter eventWriter) throws XMLStreamException {
		// help variables
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t\t");
		
		// create AntoWord open tag
		StartElement wordStartElement = eventFactory.createStartElement("",
				"", "word");
		Attribute attr = eventFactory.createAttribute("id", Integer.toString(this.id));
		eventWriter.add(tab);
		eventWriter.add(wordStartElement);
		eventWriter.add(attr);
		
		eventWriter.add(end);
		
		// write properties
		if(!text.isEmpty()){ createNode(eventWriter,"text", text);}
		if(!antonym.isEmpty()){ createNode(eventWriter,"antonym", antonym);}
		if(!POS.isEmpty()){ createNode(eventWriter,"POS", POS);}
		eventWriter.add(tab);
		eventWriter.add(eventFactory.createEndElement("", "", "word"));
		eventWriter.add(end);
		
	}	
	
	private void createNode(XMLEventWriter eventWriter, String name,
			String value) throws XMLStreamException {

		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tabs = eventFactory.createDTD("\t\t\t");
		// Create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tabs);
		eventWriter.add(sElement);
		// Create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		// Create End node
		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAntonym() {
		return antonym;
	}

	public void setAntonym(String antonym) {
		this.antonym = antonym;
	}

	public String getPOS() {
		return POS;
	}

	public void setPOS(String pOS) {
		POS = pOS;
	}

	public int getId() {
		return id;
	}	
	public void setId(int id) {
		this.id = id;
	}
	
}
