/**
 * 
 */
package demo.java.java8;

/**
 * @author Rishabh.Daim
 *
 */
@FunctionalInterface
public interface DemoFunctionalInterface {

	void add(int a, int b);

	default int multiply(int a, int b) {
		return a * b;
	}

	/**
	 * @return
	 */
	public String toString();

	public boolean equals(Object o);
}
