package demo.java8.journel.dev;

public class ClassLoaderTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("restriction")
	public static void main(String[] args) {
		System.out.println("class loader for HashMap: "
				+ java.util.HashMap.class.getClassLoader());
		System.out.println("class loader for this class: "
				+ ClassLoaderTest.class.getClassLoader());
//		System.out.println(OracleDriver.class.getClassLoader());
	}
}