/**
 * 
 */
package demo.java8.java8;

/**
 * @author Rishabh.Daim
 *
 */
public interface Defaulable {

	// Interfaces now allow default methods, the implementer may or may not
	// implement (override) them.

	default void defaultMethod() {
		System.out.println("default implementation detials..");
	}
}
