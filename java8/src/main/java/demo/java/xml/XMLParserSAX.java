/**
 * 
 */
package demo.java.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * @author rishabh.daim
 * 
 */
public class XMLParserSAX {

	/**
	 * @param args
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		MyHandler myHandler = new MyHandler();
		saxParser.parse(new File("employee.xml"), myHandler);
		// Get Employees list
		List<Employee> empList = myHandler.getEmpList();
		// print employee information
		for (Employee emp : empList)
			System.out.println(emp);
	}
}