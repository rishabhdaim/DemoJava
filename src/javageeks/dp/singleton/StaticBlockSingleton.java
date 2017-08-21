/**
 * 
 */
package javageeks.dp.singleton;

/**
 * @author aa49442
 * 
 */
public class StaticBlockSingleton {

	private static final StaticBlockSingleton instance;
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException(
					"Exception occured in creating singleton instance");
		}
	}

	public StaticBlockSingleton getInstance() {
		return instance;
	}
}