/**
 * 
 */
package xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * @author rishabh.daim
 * 
 */
public class StaxXMLStreamWriter {

	/**
	 * @param args
	 * @throws XMLStreamException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			XMLStreamException {
		String fileName = "employeeStax.xml";
		String rootElement = "Employees";
		StaxXMLStreamWriter xmlStreamWriter = new StaxXMLStreamWriter();
		Map<String, String> elementsMap = new HashMap<String, String>();
		elementsMap.put("id", "1");
		elementsMap.put("name", "Pankaj");
		elementsMap.put("age", "29");
		elementsMap.put("role", "Java Developer");
		elementsMap.put("gender", "Male");
		xmlStreamWriter.writeXML(fileName, rootElement, elementsMap);
	}

	/**
	 * @param fileName
	 * @param rootElement
	 * @param elementsMap
	 * @throws XMLStreamException
	 * @throws FileNotFoundException
	 */
	private void writeXML(String fileName, String rootElement,
			Map<String, String> elementsMap) throws FileNotFoundException,
			XMLStreamException {
		XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter xmlStreamWriter = xmlOutputFactory
				.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
		// start writing xml file
		xmlStreamWriter.writeStartDocument("UTF-8", "1.0");
		xmlStreamWriter.writeCharacters("\n");
		xmlStreamWriter.writeStartElement(rootElement);
		// write id as attribute
		xmlStreamWriter.writeAttribute("id", elementsMap.get("id"));
		// write other elements
		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeStartElement("name");
		xmlStreamWriter.writeCharacters("\n\t\t" + elementsMap.get("name"));
		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeEndElement();
		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeStartElement("age");
		xmlStreamWriter.writeCharacters("\n\t\t" + elementsMap.get("age"));
		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeEndElement();
		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeStartElement("gender");
		xmlStreamWriter.writeCharacters("\n\t\t" + elementsMap.get("gender"));
		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeEndElement();
		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeStartElement("role");
		xmlStreamWriter.writeCharacters("\n\t\t" + elementsMap.get("role"));
		xmlStreamWriter.writeCharacters("\n\t");
		xmlStreamWriter.writeEndElement();

		// write end tag of Employee element
		xmlStreamWriter.writeCharacters("\n");
		xmlStreamWriter.writeEndElement();

		// write end document
		xmlStreamWriter.writeEndDocument();
		// flush data to file and close writer
		xmlStreamWriter.flush();
		xmlStreamWriter.close();
	}
}