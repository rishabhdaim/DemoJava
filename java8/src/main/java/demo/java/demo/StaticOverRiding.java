package demo.java.demo;

public class StaticOverRiding {
	// This static method cannot hide the instance method from Object, so had to
	// remove static keyword..
	public String toString() {
		System.out.println("Test foo called");
		return "";
	}

	public static void main(String args[]) {
		System.out.println(new StaticOverRiding().toString());
	}
}