/**
 * 
 */
package demo.java8.xml;

import java.io.File;
import java.io.IOException;

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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author rishabh.daim
 * 
 */
public class ModifyXMLDOM {

	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws TransformerException
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException, TransformerException {
		String filePath = "emps.xml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document doc = documentBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		// update attribute value
		updateAttributeValue(doc);
		// update Element value
		updateElementValue(doc);
		// delete element
		deleteElement(doc);
		// add new element
		addElement(doc);

		// write the updated document to file or console
		doc.getDocumentElement().normalize();
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("employee_updated.xml"));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);
		System.out.println("XML file updated successfully");
	}

	private static void addElement(Document doc) {
		NodeList employees = doc.getElementsByTagName("Employee");
		Element emp = null;
		// loop for each employee
		for (int i = 0; i < employees.getLength(); i++) {
			emp = (Element) employees.item(i);
			Element salaryElement = doc.createElement("salary");
			salaryElement.appendChild(doc.createTextNode("10000"));
			emp.appendChild(salaryElement);
		}
	}

	private static void deleteElement(Document doc) {
		NodeList employees = doc.getElementsByTagName("Employee");
		Element emp = null;
		// loop for each employee
		for (int i = 0; i < employees.getLength(); i++) {
			emp = (Element) employees.item(i);
			Node genderNode = emp.getElementsByTagName("gender").item(0);
			emp.removeChild(genderNode);
		}
	}

	private static void updateElementValue(Document doc) {
		NodeList employees = doc.getElementsByTagName("Employee");
		Element emp = null;
		// loop for each employee
		for (int i = 0; i < employees.getLength(); i++) {
			emp = (Element) employees.item(i);
			Node name = emp.getElementsByTagName("name").item(0)
					.getFirstChild();
			name.setNodeValue(name.getNodeValue().toUpperCase());
		}
	}

	private static void updateAttributeValue(Document doc) {
		NodeList employees = doc.getElementsByTagName("Employee");
		Element emp = null;
		// loop for each employee
		for (int i = 0; i < employees.getLength(); i++) {
			emp = (Element) employees.item(i);
			String gender = emp.getElementsByTagName("gender").item(0)
					.getFirstChild().getNodeValue();
			if (gender.equalsIgnoreCase("male"))
				emp.setAttribute("id", "M" + emp.getAttribute("id"));
			else
				emp.setAttribute("id", "F" + emp.getAttribute("id"));
		}
	}
}