package demo.java.demo;

public class TestClassPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.class.path"));
		System.out.println();

		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("java.home"));
		
		System.out.println(System.getProperty("java.ext.dirs"));
		System.out.println(System.getProperty("sun.boot.class.path"));
	}
}