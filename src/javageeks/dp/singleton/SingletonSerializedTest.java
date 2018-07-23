/**
 * 
 */
package javageeks.dp.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author rishabh.daim
 * 
 */
public class SingletonSerializedTest {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton
				.getInstance();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"EagerInitializedSingleton.ser"));
		oos.writeObject(eagerInitializedSingleton);
		oos.close();

		// deserialize the class..
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"EagerInitializedSingleton.ser"));
		EagerInitializedSingleton eagerInitializedSingleton2 = (EagerInitializedSingleton) ois
				.readObject();
		ois.close();

		System.out.println(eagerInitializedSingleton.hashCode());
		System.out.println(eagerInitializedSingleton2.hashCode());
	}

}
