/**
 * 
 */
package demo.java8.javageeks.dp.singleton;

import java.io.Serializable;

/**
 * @author rishabh.daim
 * 
 */
public class EagerInitializedSingleton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();

	// private constructor to avoid client applications to use constructor
	private EagerInitializedSingleton() {
	}

	public static EagerInitializedSingleton getInstance() {
		return INSTANCE;
	}

	protected Object readResolve() {
		return INSTANCE;
	}
}