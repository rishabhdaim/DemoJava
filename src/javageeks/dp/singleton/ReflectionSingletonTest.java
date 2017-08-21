/**
 * 
 */
package javageeks.dp.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author aa49442
 * 
 */
public class ReflectionSingletonTest {

	/**
	 * @param args
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		EagerInitializedSingleton eagerInitializedSingleton = EagerInitializedSingleton
				.getInstance();
		EagerInitializedSingleton eagerInitializedSingleton2 = null;

		Constructor<?>[] constructors = EagerInitializedSingleton.class
				.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			constructor.setAccessible(true);
			eagerInitializedSingleton2 = (EagerInitializedSingleton) constructor
					.newInstance();
			break;
		}
		System.out.println(eagerInitializedSingleton.hashCode());
		System.out.println(eagerInitializedSingleton2.hashCode());
	}
}