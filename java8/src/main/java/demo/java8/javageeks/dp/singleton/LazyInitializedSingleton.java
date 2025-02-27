/**
 * 
 */
package demo.java8.javageeks.dp.singleton;

/**
 * @author rishabh.daim
 * 
 */
public class LazyInitializedSingleton {
	private static LazyInitializedSingleton instance;

	private LazyInitializedSingleton() {
	}

	public static LazyInitializedSingleton getInstance() {
		if (instance == null) {
			instance = new LazyInitializedSingleton();
		}
		return instance;
	}
}