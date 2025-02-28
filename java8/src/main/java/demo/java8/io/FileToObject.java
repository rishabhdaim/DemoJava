/**
 * 
 */
package demo.java8.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import demo.java8.xml.Employee;

/**
 * @author rishabh.daim
 * 
 */
public class FileToObject {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		FileInputStream is = new FileInputStream("EmployeeObject.ser");
		ObjectInputStream ois = new ObjectInputStream(is);
		Employee emp = (Employee) ois.readObject();
		ois.close();
		is.close();
		System.out.println(emp.toString());
	}
}