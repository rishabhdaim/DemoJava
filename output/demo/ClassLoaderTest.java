package demo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.err.println(String.class.getClassLoader());

		try {
			// printing ClassLoader of this class
			System.out
					.println("demo.ClassLoaderTest.getClass().getClassLoader() : "
							+ ClassLoaderTest.class.getClassLoader());

			// trying to explicitly load this class again using Extension class
			// loader
			Class.forName("demo.ClassLoaderTest", true, ClassLoaderTest.class
					.getClassLoader().getParent());
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE,
					null, ex);
			ex.printStackTrace();
		}

	}

}
