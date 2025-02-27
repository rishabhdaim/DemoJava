/**
 * 
 */
package demo.java8.java8;

/**
 * @author Rishabh.Daim
 *
 */
@FunctionalInterface
public interface ComplexFunctionalInterface extends DemoFunctionalInterface {

	default void doSomething() {
		System.out.println("done");
	}
}
