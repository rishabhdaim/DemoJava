/**
 * 
 */
package demo.java8.xml;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 * @author rishabh.daim
 * 
 */
public class XMLValidation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out
				.println("EmployeeRequest.xml validates against Employee.xsd? "
						+ validateXMLSchema("Employee.xsd",
								"EmployeeRequest.xml"));
		System.out
				.println("EmployeeResponse.xml validates against Employee.xsd? "
						+ validateXMLSchema("Employee.xsd",
								"EmployeeResponse.xml"));
		System.out.println("employee.xml validates against Employee.xsd? "
				+ validateXMLSchema("Employee.xsd", "employee.xml"));
	}

	private static boolean validateXMLSchema(String xsdPath, String xmlPath) {
		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = schemaFactory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}
}