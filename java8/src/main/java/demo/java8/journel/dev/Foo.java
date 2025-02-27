package demo.java8.journel.dev;

public class Foo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Foo Constructor >>> " + args[0] + " " + args[1]);
		Bar bar = new Bar(args[0], args[1]);
		bar.printCL();
	}

	public static void printCL() {
		System.out.println("Foo ClassLoader: " + Foo.class.getClassLoader());
	}
}
