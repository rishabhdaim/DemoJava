/**
 * 
 */
package demo.java8.javageeks.dp.singleton;

/**
 * @author rishabh.daim
 * 
 */
public class BillPughSingleton {
	private BillPughSingleton() {
	}

	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}