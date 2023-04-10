/**
 * 
 */
package demo.java.java8;

import java.util.function.Supplier;

/**
 * @author Rishabh.Daim
 *
 */
public interface DefaulableFactory {

	// Interfaces now allow static methods
	static Defaulable create(Supplier<Defaulable> supplier) {
		return supplier.get();
	}
}
