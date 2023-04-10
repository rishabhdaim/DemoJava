package demo.java.demo;

/**
 * Java program to demonstrate class loading and initialization in Java.
 */
public class ClassInitializationTest {

	public static void main(String args[]) throws InterruptedException {

		//NotUsed o = null; // this class is not used, should not be initialized
		//new Child();
		//Child t = new Child(); // initializing sub class, should trigger super
								// class initialization
		System.err.println(Child.STRING);
		System.out.println(Child.string);
		//System.out.println((Object) o == (Object) t);
	}
}

/**
 * Super class to demonstrate that Super class is loaded and initialized before
 * Subclass.
 */
class Parent {
	
	public final static String string = "parent";
	static {
		System.out.println("static block of Super class is initialized");
	}
	{
		System.out.println("non static blocks in super class is initialized");
	}
}

/**
 * Java class which is not used in this program, consequently not loaded by JVM
 */
class NotUsed {
	static {
		System.out.println("NotUsed Class is initialized ");
	}
}

/**
 * Sub class of Parent, demonstrate when exactly sub class loading and
 * initialization occurs.
 */
class Child extends Parent {
	static {
		System.out.println("static block of Sub class is initialized in Java ");
	}
	
	public final static String s = "private";
	public final static String STRING = s;
	{
		System.out.println("non static blocks in sub class is initialized");
	}
}
