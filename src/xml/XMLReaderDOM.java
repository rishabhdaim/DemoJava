/**
 * 
 */
package xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author aa49442
 * 
 */
public class XMLReaderDOM {

	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		File xmlFile = new File("employee.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document document = documentBuilder.parse(xmlFile);
		document.getDocumentElement().normalize();

		System.out.println("Root Element : "
				+ document.getDocumentElement().getNodeName());

		NodeList nodeList = document.getElementsByTagName("Employee");
		// now XML is loaded as Document in memory, lets convert it to Object
		// List
		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 0; i < nodeList.getLength(); i++)
			employees.add(getEmployee(nodeList.item(i)));

		// lets print Employee list information
		for (Employee employee : employees)
			System.out.println(employee);
	}

	private static Employee getEmployee(Node node) {
		// XMLReaderDOM domReader = new XMLReaderDOM();
		Employee emp = new Employee();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			emp.setName(getTagValue("name", element));
			emp.setAge(Integer.parseInt(getTagValue("age", element)));
			emp.setGender(getTagValue("gender", element));
			emp.setRole(getTagValue("role", element));
		}
		return emp;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0)
				.getChildNodes();
		Node node = (Node) nodeList.item(0);
		return node.getNodeValue();
	}
}