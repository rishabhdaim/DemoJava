/**
 * 
 */
package xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.StAXEventBuilder;
import org.jdom2.input.StAXStreamBuilder;
import org.xml.sax.SAXException;

/**
 * @author aa49442
 * 
 */
public class JDOMXMLReader {

	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws JDOMException
	 * @throws XMLStreamException
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException, JDOMException, XMLStreamException {
		final String fileName = "employee.xml";
		// we can create JDOM Document from DOM, SAX and STAX Parser Builder
		// classes
		// Document jdomDoc = useDOMParser(fileName);
		// Document jdomDoc = useSAXParser(fileName);
		Document jdomDoc = useSTAXParser(fileName, "stream");
		Element root = jdomDoc.getRootElement();
		List<Element> empListElements = root.getChildren("Employee");
		List<Employee> empList = new ArrayList<>();
		for (Element empElement : empListElements) {
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(empElement.getAttributeValue("id")));
			emp.setAge(Integer.parseInt(empElement.getChildText("age")));
			emp.setName(empElement.getChildText("name"));
			emp.setRole(empElement.getChildText("role"));
			emp.setGender(empElement.getChildText("gender"));
			empList.add(emp);
		}
		// lets print Employees list information
		for (Employee emp : empList)
			System.out.println(emp);
	}

	// Get JDOM document from DOM Parser
	/**
	 * @param fileName
	 * @return
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	private static Document useDOMParser(String fileName)
			throws ParserConfigurationException, SAXException, IOException {
		// creating DOM Document
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		org.w3c.dom.Document document = documentBuilder.parse(fileName);
		DOMBuilder domBuilder = new DOMBuilder();
		return domBuilder.build(document);
	}

	// Get JDOM document from SAX Parser
	private static Document useSAXParser(String fileName) throws JDOMException,
			IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
		return saxBuilder.build(new File(fileName));
	}

	// Get JDOM Document from STAX Stream Parser or STAX Event Parser
	private static Document useSTAXParser(String fileName, String type)
			throws FileNotFoundException, XMLStreamException, JDOMException {
		if (type.equalsIgnoreCase("stream")) {
			StAXStreamBuilder staxBuilder = new StAXStreamBuilder();
			XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
			XMLStreamReader xmlStreamReader = xmlInputFactory
					.createXMLStreamReader(new FileInputStream(fileName));
			return staxBuilder.build(xmlStreamReader);
		}
		StAXEventBuilder staxBuilder = new StAXEventBuilder();
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLEventReader xmlEventReader = xmlInputFactory
				.createXMLEventReader(new FileInputStream(fileName));
		return staxBuilder.build(xmlEventReader);
	}
}