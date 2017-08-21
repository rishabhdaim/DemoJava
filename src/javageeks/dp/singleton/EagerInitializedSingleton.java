/**
 * 
 */
package javageeks.dp.singleton;

import java.io.Serializable;

/**
 * @author aa49442
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