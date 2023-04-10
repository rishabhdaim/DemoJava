/**
 * 
 */
package demo.java.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * @author rishabh.daim
 * 
 */
public class StaxXMLWriter {

	/**
	 * @param args
	 * @throws XMLStreamException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			XMLStreamException {
		String fileName = "employeeStax.xml";
		String rootElement = "Employee";
		StaxXMLWriter xmlWriter = new StaxXMLWriter();
		Map<String, String> elementsMap = new HashMap<String, String>();
		elementsMap.put("name", "Pankaj");
		elementsMap.put("age", "29");
		elementsMap.put("role", "Java Developer");
		elementsMap.put("gender", "Male");
		xmlWriter.writeXML(fileName, rootElement, elementsMap);
	}

	/**
	 * @param fileName
	 * @param rootElement
	 * @param elementsMap
	 * @throws FileNotFoundException
	 * @throws XMLStreamException
	 */
	private void writeXML(String fileName, String rootElement,
			Map<String, String> elementsMap) throws FileNotFoundException,
			XMLStreamException {
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		XMLEventWriter xmlEventWriter = xmlOutputFactory.createXMLEventWriter(
				new FileOutputStream(fileName), "UTF-8");
		// For Debugging - below code to print XML to Console
		// XMLEventWriter xmlEventWriter =
		// xmlOutputFactory.createXMLEventWriter(System.out);
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");

		StartDocument startDocument = eventFactory.createStartDocument();
		xmlEventWriter.add(startDocument);
		xmlEventWriter.add(end);
		StartElement configStartElement = eventFactory.createStartElement("",
				"", rootElement);
		xmlEventWriter.add(configStartElement);
		xmlEventWriter.add(end);
		// Write the element nodes
		Set<String> elementNodes = elementsMap.keySet();
		for (String key : elementNodes)
			createNode(xmlEventWriter, key, elementsMap.get(key));
		xmlEventWriter.add(eventFactory.createEndElement("", "", rootElement));
		xmlEventWriter.add(end);
		xmlEventWriter.add(eventFactory.createEndDocument());
		xmlEventWriter.close();
		System.out.println("done");
	}

	/**
	 * @param xmlEventWriter
	 * @param key
	 * @param value
	 * @throws XMLStreamException
	 */
	private void createNode(XMLEventWriter xmlEventWriter, String key,
			String value) throws XMLStreamException {
		XMLEventFactory xmlEventFactory = XMLEventFactory.newInstance();
		XMLEvent end = xmlEventFactory.createDTD("\n");
		XMLEvent tab = xmlEventFactory.createDTD("\t");
		StartElement startElement = xmlEventFactory.createStartElement("", "",
				key);
		xmlEventWriter.add(tab);
		xmlEventWriter.add(startElement);
		// Create Content..
		Characters characters = xmlEventFactory.createCharacters(value);
		xmlEventWriter.add(characters);
		// Create End node
		EndElement endElement = xmlEventFactory.createEndElement("", "", key);
		xmlEventWriter.add(endElement);
		xmlEventWriter.add(end);
	}
}