/**
 * 
 */
package demo.java8.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author rishabh.daim
 * 
 */
public class XMLWriterDOM {

	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws TransformerException
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			TransformerException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		// add elements to Document
		Element rootElement = document.createElementNS(
				"http://www.journaldev.com/employee", "Employees");
		// append root element to document
		document.appendChild(rootElement);
		// append first child element to root element
		rootElement.appendChild(getEmployee(document, "1", "Pankaj", "29",
				"Java Developer", "Male"));
		// append second child
		rootElement.appendChild(getEmployee(document, "2", "Lisa", "35",
				"Manager", "Female"));
		// append third child
		rootElement.appendChild(getEmployee(document, "3", "Rishu", "23",
				"Java Developer", "Male"));
		// for output to file, console
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		// for pretty print
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		DOMSource domSource = new DOMSource(document);

		// write to console or file
		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(new File("emps.xml"));

		// write data
		transformer.transform(domSource, console);
		transformer.transform(domSource, file);
		System.out.println("DONE");
	}

	private static Node getEmployee(Document doc, String id, String name,
			String age, String role, String gender) {
		Element employee = doc.createElement("Employee");
		// set id attribute
		employee.setAttribute("id", id);
		// create name element
		employee.appendChild(getEmployeeElements(doc, employee, "name", name));
		// create age element
		employee.appendChild(getEmployeeElements(doc, employee, "age", age));
		// create role element
		employee.appendChild(getEmployeeElements(doc, employee, "role", role));
		// create gender element
		employee.appendChild(getEmployeeElements(doc, employee, "gender",
				gender));
		return employee;
	}

	// utility method to create text node
	private static Node getEmployeeElements(Document doc, Element element,
			String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
}