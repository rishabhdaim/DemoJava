/**
 * 
 */
package demo.java.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import demo.java.xml.Employee;

/**
 * @author rishabh.daim
 * 
 */
public class ObjectToFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setAge(23);
		emp.setGender("Male");
		emp.setName("Rishu");
		try {
			FileOutputStream fos = new FileOutputStream("EmployeeObject.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// write object to file
			oos.writeObject(emp);
			System.out.println("Done");
			// closing resources
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}