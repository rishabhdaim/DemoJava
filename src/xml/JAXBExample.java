/**
 * 
 */
package xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author rishabh.daim
 * 
 */
public class JAXBExample {

	private static final String FILE_NAME = "jaxb-emp.xml";

	/**
	 * @param args
	 * @throws JAXBException
	 */
	public static void main(String[] args) throws JAXBException {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setAge(25);
		emp.setName("Pankaj");
		emp.setGender("Male");
		emp.setRole("Developer");
		emp.setPassword("sensitive");

		jaxbObjectToXML(emp);
		Employee empFromFile = jaxbXMLToObject();
		System.out.println(empFromFile.toString());
	}

	/**
	 * @return
	 * @throws JAXBException
	 */
	private static Employee jaxbXMLToObject() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Employee employee = (Employee) unmarshaller.unmarshal(new File(
				FILE_NAME));
		return employee;
	}

	/**
	 * @param emp
	 * @throws JAXBException
	 */
	private static void jaxbObjectToXML(Employee emp) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		// for pretty-print XML in JAXB
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// Write to System.out for debugging
		// m.marshal(emp, System.out);
		// Write to File
		marshaller.marshal(emp, new File(FILE_NAME));
	}

}
