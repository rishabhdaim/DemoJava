/**
 * 
 */
package demo.java8.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author rishabh.daim
 * 
 */
public class XPathQueryExample {

	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws XPathExpressionException
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document document = documentBuilder.parse("employee.xml");
		// Create XPathFactory object
		XPathFactory xpathFactory = XPathFactory.newInstance();
		// Create XPath object
		XPath xpath = xpathFactory.newXPath();
		String name = getEmployeeNameById(document, xpath, 4);
		System.out.println("Employee Name with ID 4: " + name);

		List<String> names = getEmployeeNameWithAge(document, xpath, 30);
		System.out.println("Employees with 'age>30' are:"
				+ Arrays.toString(names.toArray()));
		List<String> femaleEmps = getFemaleEmployeesName(document, xpath);
		System.out.println("Female Employees names are:"
				+ Arrays.toString(femaleEmps.toArray()));
	}

	/**
	 * @param document
	 * @param xpath
	 * @return
	 * @throws XPathExpressionException
	 */
	private static List<String> getFemaleEmployeesName(Document document,
			XPath xpath) throws XPathExpressionException {
		List<String> list = new ArrayList<String>();
		// create XPathExpression object
		XPathExpression xPathExpression = xpath
				.compile("/Employees/Employee[gender='Female']/name/text()");
		// evaluate expression result on XML document
		NodeList nodes = (NodeList) xPathExpression.evaluate(document,
				XPathConstants.NODESET);
		for (int i = 0; i < nodes.getLength(); i++)
			list.add(nodes.item(i).getNodeValue());
		return list;
	}

	/**
	 * @param document
	 * @param xpath
	 * @param age
	 * @return
	 * @throws XPathExpressionException
	 */
	private static List<String> getEmployeeNameWithAge(Document document,
			XPath xpath, int age) throws XPathExpressionException {
		List<String> list = new ArrayList<String>();
		// create XPathExpression object
		XPathExpression xPathExpression = xpath
				.compile("/Employees/Employee[age>" + age + "]/name/text()");
		// evaluate expression result on XML document
		NodeList nodes = (NodeList) xPathExpression.evaluate(document,
				XPathConstants.NODESET);
		for (int j = 0; j < nodes.getLength(); j++)
			list.add(nodes.item(j).getNodeValue());
		return list;
	}

	/**
	 * @param document
	 * @param xpath
	 * @param id
	 * @return
	 * @throws XPathExpressionException
	 */
	private static String getEmployeeNameById(Document document, XPath xpath,
			int id) throws XPathExpressionException {
		String name = null;
		// create XPathExpression object
		XPathExpression xPathExpression = xpath
				.compile("/Employees/Employee[@id=" + id + "]/name/text()");
		// evaluate expression result on XML document
		name = (String) xPathExpression.evaluate(document,
				XPathConstants.STRING);
		return name;
	}
}