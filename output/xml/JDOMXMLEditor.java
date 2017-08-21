/**
 * 
 */
package xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @author aa49442
 * 
 */
public class JDOMXMLEditor {

	/**
	 * @param args
	 * @throws IOException
	 * @throws JDOMException
	 */
	public static void main(String[] args) throws JDOMException, IOException {
		final Namespace ns = Namespace
				.getNamespace("http://www.journaldev.com/employees");
		// Get the JDOM document
		Document doc = useSAXParser("employees.xml");
		// Get list of Employee element
		Element rootElement = doc.getRootElement();
		List<Element> listEmpElement = rootElement.getChildren("Employee");
		// loop through to edit every Employee element
		for (Element empElement : listEmpElement) {
			// change the name to BLOCK letters
			String name = empElement.getChildText("name");
			if (name != null)
				empElement.getChild("name").setText(name.toUpperCase());
			// edit the ID attribute based on Gender
			String gender = empElement.getChildText("gender");
			if (gender != null && gender.equalsIgnoreCase("female")) {
				String id = empElement.getAttributeValue("id");
				empElement.getAttribute("id").setValue(id + "F");
			} else {
				String id = empElement.getAttributeValue("id");
				empElement.getAttribute("id").setValue(id + "M");
			}
			// remove gender element as it's not needed anymore
			empElement.removeChild("gender");
			// add salary element with default value to every employee
			empElement.addContent(new Element("salary").setText("1000"));
		}
		// document is processed and edited successfully, lets save it in new
		// file
		XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
		// output xml to console for debugging
		xmlOutputter.output(doc, System.out);
		xmlOutputter.output(doc, new FileOutputStream("employees_new.xml"));
	}

	/**
	 * @param string
	 * @return JDOM document from SAX Parser
	 * @throws IOException
	 * @throws JDOMException
	 */
	private static Document useSAXParser(String fileName) throws JDOMException,
			IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
		return saxBuilder.build(new File(fileName));
	}

}
