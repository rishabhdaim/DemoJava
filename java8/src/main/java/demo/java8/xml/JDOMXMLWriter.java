/**
 * 
 */
package demo.java8.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @author rishabh.daim
 * 
 */
public class JDOMXMLWriter {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Pankaj", 25, "Male", "Java Developer"));
		empList.add(new Employee(2, "Mona", 34, "Female", "Manager"));
		empList.add(new Employee(3, "Dave", 45, "Male", "Support"));
		String fileName = "employees.xml";
		writeFileUsingJDOM(empList, fileName);
	}

	/**
	 * @param empList
	 * @param fileName
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void writeFileUsingJDOM(List<Employee> empList,
			String fileName) throws FileNotFoundException, IOException {
		Document doc = new Document();
		doc.setRootElement(new Element("Employees", Namespace
				.getNamespace("http://www.journaldev.com/employees")));
		for (Employee emp : empList) {
			Element employee = new Element("Employee");
			employee.setAttribute("id", "" + emp.getId());
			employee.addContent(new Element("age").setText("" + emp.getAge()));
			employee.addContent(new Element("name").setText(emp.getName()));
			employee.addContent(new Element("gender").setText(emp.getGender()));
			employee.addContent(new Element("role").setText(emp.getRole()));
			doc.getRootElement().addContent(employee);
		}
		// JDOM document is ready now, lets write it to file now
		XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
		// output xml to console for debugging
		// xmlOutputter.output(doc, System.out);
		xmlOutputter.output(doc, new FileOutputStream(fileName));
	}
}