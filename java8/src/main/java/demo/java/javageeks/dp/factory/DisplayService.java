/**
 * 
 */
package demo.java.javageeks.dp.factory;

/**
 * @author Rishabh.Daim
 *
 */
public interface DisplayService {
	
	/**
	 * default method introduced in JDK 1.8
	 */
	default void display() {
		XMLParser parser = getParser();
		String msg = parser.parse();
		System.out.println(msg);
	}

	XMLParser getParser();
}
