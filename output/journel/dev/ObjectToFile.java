package journel.dev;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectToFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee employee = new Employee(12, "daim", 23, 40000);
		try (FileOutputStream fileOutputStream = new FileOutputStream(
				"employee.ser");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(
						fileOutputStream);) {
			System.out.println(employee);
			objectOutputStream.writeObject(employee);
			System.out.println("done writing");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileInputStream fileInputStream = new FileInputStream(
				"employee.ser");
				ObjectInputStream objectInputStream = new ObjectInputStream(
						fileInputStream)) {
			Employee employee2 = (Employee) objectInputStream.readObject();
			System.out.println(employee2);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}