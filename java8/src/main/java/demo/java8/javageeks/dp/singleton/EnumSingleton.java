/**
 * 
 */
package demo.java8.javageeks.dp.singleton;

/**
 * @author rishabh.daim
 * 
 */
public enum EnumSingleton {
	INSTANCE;

	public static void doSomething() {
		System.out.println("enum..");
	}
}