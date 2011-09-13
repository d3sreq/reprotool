package reprotool.ling.antocorpus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Comment;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/*
 * Antonyms Corpus
 * 
 * part of ReproTool support tools
 * 
 * version 1.0
 * 
 * @author ofiala
 */
public class AntoCorpus {
	
	// data version
	private String version = "0.1";
	// version of the code
	private String coreversion = "1.0";
	private String corpusFile;
	private List<AntoWord> words;
	private int count;
	
	/**
	 * Constructor for AntoCorpus instance
	 * 
	 * @param corpusFile XML file for AntoCorpus
	 */
	public AntoCorpus(String corpusFile) {
		super();
		this.corpusFile = corpusFile;
		this.words = new ArrayList<AntoWord>();
		this.count = 0;
	}

	/**
	 *  Load AntoCorpus from XML file
	 */
	@SuppressWarnings({ "unchecked" })
	public void loadCorpus() {
		try {
			// create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			InputStream in = new FileInputStream(corpusFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			AntoWord word = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					// if we have a item element we create a new item
					if (startElement.getName().getLocalPart() == ("word")) {
						word = new AntoWord();
						// attribute to our object
						Iterator<Attribute> attributes = startElement.getAttributes();
						while (attributes.hasNext()) {
							Attribute attribute = attributes.next();
							if (attribute.getName().toString().equals("id")) {
								word.setId(Integer.parseInt(attribute.getValue()));
							}

						}
					}

					if (event.isStartElement()) {
						if (event.asStartElement().getName().getLocalPart()
								.equals("text")) {
							event = eventReader.nextEvent();
							word.setText(event.asCharacters().getData());
							continue;
						}
					}
					if (event.asStartElement().getName().getLocalPart()
							.equals("antonym")) {
						event = eventReader.nextEvent();
						word.setAntonym(event.asCharacters().getData());
						continue;
					}

					if (event.asStartElement().getName().getLocalPart()
							.equals("POS")) {
						event = eventReader.nextEvent();
						word.setPOS(event.asCharacters().getData());
						continue;
					}
				}
				// when we reach the end of an item element we add it to the list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == ("word")) {
						addAntoWord(word);
					}
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes AntoCorpus data into a XML file
	 * 
	 * @throws Exception
	 */
	public void writeCorpus() throws Exception {
		/*
		File f = new File(corpusFile);
		if(!f.exists()){
			f.createNewFile();
		}
		*/
		// create a XMLOutputFactory
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(corpusFile));
		
		writeCorpusStart(eventWriter);
		
		// write all words
    	for (AntoWord word : words) {
    		word.write(eventWriter);
    	}

		writeCorpusEnd(eventWriter);
		
	}

	/**
	 * Writes first part (header) of AutoCorpus XML file
	 * 
	 * @param eventWriter valid instance of XMLEventWriter
	 * @throws Exception XMLEventWriter error
	 */
	private void writeCorpusStart(XMLEventWriter eventWriter) throws Exception {
		// create a EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument("UTF-8");
		eventWriter.add(startDocument);
		eventWriter.add(end);
		// create comment
		Comment commnent = eventFactory.createComment("Antonyms Corpus ReProTool tools 2011");
		eventWriter.add(commnent);	
		eventWriter.add(end);
		// create corpus open tag
		StartElement corpusStartElement = eventFactory.createStartElement("","", "corpus");
		eventWriter.add(corpusStartElement);
		Attribute attr = eventFactory.createAttribute("version", this.version);
		eventWriter.add(attr);
		attr = eventFactory.createAttribute("coreversion", this.coreversion);
		eventWriter.add(attr);		
		eventWriter.add(end);
		eventWriter.add(tab);
		eventWriter.add(eventFactory.createStartElement("","", "words"));
		eventWriter.add(end);	
	}

	/**
	 * Writes last part (footer) of AutoCorpus XML file
	 * 
	 * @param eventWriter Valid instance of XMLEventWriter
	 * @throws Exception XMLEventWriter error
	 */
	public void writeCorpusEnd(XMLEventWriter eventWriter) throws Exception {
		// create a EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		
		eventWriter.add(tab);
		eventWriter.add(eventFactory.createEndElement("", "", "words"));
		eventWriter.add(end);
		eventWriter.add(eventFactory.createEndElement("", "", "corpus"));
		eventWriter.add(end);
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close();
	}
	
	public void addAntoWord(AntoWord word) {
		word.setId(count+1);
		
		if (this.words.add(word))
			count++;
	}
	
	public void addAntoWord(String word, String antonym, String POS) {
		AntoWord antoword = new AntoWord(word, antonym, POS);
		antoword.setId(count+1);		
		if (this.words.add(antoword))
			count++;
	}

	public AntoWord findWord(String word) {
		boolean found = false;
		AntoWord curWord = new AntoWord();
		
	    for ( Iterator<AntoWord> iter = words.listIterator(); !found && iter.hasNext(); ) {
	    	curWord = iter.next();
	    	if(word.equals(curWord.toString())){
	    		found = true;
	    	}
	    }
		if (found){
			return curWord;
		} else {
			return null;
		}
	}	
	
	/**
	 * Find antonym for input word
	 * 
	 * @param word Input word
	 * @return antonym 
	 */
	public String findAntonym(String word) {
		boolean found = false;
		boolean anto = false;
		AntoWord curWord = new AntoWord();
		
	    for ( Iterator<AntoWord> iter = words.listIterator(); !found && iter.hasNext(); ) {
	    	curWord = iter.next();
	    	if(word.equals(curWord.getText())){
	    		found = true;
	    	} else if(word.equals(curWord.getAntonym())){
	    		found = true;
	    		anto = true;
	    	}
	    }
		if (found){
			return anto ? curWord.getText() : curWord.getAntonym();
		} else {
			return "";
		}
	}
	
	
	/**
	 * Number of words
	 * 
	 * @return Number of AntoWords in corpus
	 */
	public int length() {
		return count;
	}
	
	// set a get functions
	public String getCorpusFile() {
		return corpusFile;
	}

	public void setCorpusFile(String corpusFile) {
		this.corpusFile = corpusFile;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
