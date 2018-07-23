/**
 * 
 */
package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 * @author rishabh.daim
 * 
 */
public class StaxXMLReader {

	/**
	 * @param args
	 * @throws XMLStreamException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			XMLStreamException {
		String fileName = "employee.xml";
		List<Employee> empList = parseXML(fileName);
		for (Employee emp : empList) {
			System.out.println(emp.toString());
		}
	}

	private static List<Employee> parseXML(String fileName)
			throws FileNotFoundException, XMLStreamException {
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLEventReader xmlEventReader = xmlInputFactory
				.createXMLEventReader(new FileInputStream(fileName));
		while (xmlEventReader.hasNext()) {
			XMLEvent xmlEvent = xmlEventReader.nextEvent();
			if (xmlEvent.isStartElement()) {
				StartElement startElement = xmlEvent.asStartElement();
				if (startElement.getName().getLocalPart()
						.equalsIgnoreCase("Employee")) {
					emp = new Employee();
					// Get the 'id' attribute from Employee element
					Attribute idAttr = startElement
							.getAttributeByName(new QName("id"));
					if (idAttr != null)
						emp.setId(Integer.parseInt(idAttr.getValue()));
				}
				// set the other varibles from xml elements
				else if (startElement.getName().getLocalPart().equals("age")) {
					xmlEvent = xmlEventReader.nextEvent();
					emp.setAge(Integer.parseInt(xmlEvent.asCharacters()
							.getData()));
				} else if (startElement.getName().getLocalPart().equals("name")) {
					xmlEvent = xmlEventReader.nextEvent();
					emp.setName(xmlEvent.asCharacters().getData());
				} else if (startElement.getName().getLocalPart()
						.equals("gender")) {
					xmlEvent = xmlEventReader.nextEvent();
					emp.setGender(xmlEvent.asCharacters().getData());
				} else if (startElement.getName().getLocalPart().equals("role")) {
					xmlEvent = xmlEventReader.nextEvent();
					emp.setRole(xmlEvent.asCharacters().getData());
				}
			}

			// if Employee end element is reached, add employee object to list
			if (xmlEvent.isEndElement()) {
				EndElement endElement = xmlEvent.asEndElement();
				if (endElement.getName().getLocalPart().equals("Employee"))
					empList.add(emp);
			}
		}
		return empList;
	}
}