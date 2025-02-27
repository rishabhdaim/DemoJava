/**
 * 
 */
package demo.java8.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author rishabh.daim
 * 
 */
public class StaxXMLStreamReader {

	private static boolean bName;
	private static boolean bAge;
	private static boolean bGender;
	private static boolean bRole;

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

	/**
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 * @throws XMLStreamException
	 */
	private static List<Employee> parseXML(String fileName)
			throws FileNotFoundException, XMLStreamException {
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLStreamReader xmlStreamReader = xmlInputFactory
				.createXMLStreamReader(new FileInputStream(fileName));
		int event = xmlStreamReader.getEventType();
		while (true) {
			switch (event) {
			case XMLStreamConstants.START_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("Employee")) {
					emp = new Employee();
					emp.setId(Integer.parseInt(xmlStreamReader
							.getAttributeValue(0)));
				} else if (xmlStreamReader.getLocalName().equals("name"))
					bName = true;
				else if (xmlStreamReader.getLocalName().equals("age"))
					bAge = true;
				else if (xmlStreamReader.getLocalName().equals("role"))
					bRole = true;
				else if (xmlStreamReader.getLocalName().equals("gender"))
					bGender = true;
				break;
			case XMLStreamConstants.CHARACTERS:
				if (bName) {
					emp.setName(xmlStreamReader.getText());
					bName = false;
				} else if (bAge) {
					emp.setAge(Integer.parseInt(xmlStreamReader.getText()));
					bAge = false;
				} else if (bGender) {
					emp.setGender(xmlStreamReader.getText());
					bGender = false;
				} else if (bRole) {
					emp.setRole(xmlStreamReader.getText());
					bRole = false;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("Employee"))
					empList.add(emp);
			}
			if (!xmlStreamReader.hasNext())
				break;
			event = xmlStreamReader.next();
		}
		return empList;
	}
}