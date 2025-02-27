/**
 * 
 */
package demo.java8.javageeks.dp.observer;

/**
 * @author rishabh.daim
 * 
 */
public interface Observer {
	/**
	 * @param interest
	 */
	void update(float interest);

	void added(Subject subject, int i);
}
