package demo.java8.journel.dev;

public class Bar {
	public Bar(String a, String b) {
		System.out.println("Bar Constructor >>> " + a + " " + b);
	}

	public void printCL() {
		System.out.println("Bar ClassLoader: " + Bar.class.getClassLoader());
	}
}