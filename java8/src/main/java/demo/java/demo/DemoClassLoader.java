package demo.java.demo;

public class DemoClassLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] is = {1,2,3,4,5};
		
		System.out.println(is.getClass().getClassLoader());
	}
}
