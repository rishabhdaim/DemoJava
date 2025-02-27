/**
 * 
 */
package demo.java8.javageeks.dp.serializationproxy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @author rishabh.daim
 * 
 */
public class TestProxy {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Period period = new Period(new Date(12345678l), new Date());

		System.out.println(period);

		FileOutputStream outputStream = new FileOutputStream("proxy.ser");
		ObjectOutputStream oos = new ObjectOutputStream(outputStream);
		// oos.defaultWriteObject();
		oos.writeObject(period);

		FileInputStream inputStream = new FileInputStream("proxy.ser");
		ObjectInputStream ois = new ObjectInputStream(inputStream);
		// ois.defaultReadObject();
		Period period2 = (Period) ois.readObject();
		System.out.println(period2);
	}
}
