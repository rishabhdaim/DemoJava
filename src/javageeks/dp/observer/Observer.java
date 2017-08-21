/**
 * 
 */
package javageeks.dp.observer;

/**
 * @author aa49442
 * 
 */
public interface Observer {
	/**
	 * @param interest
	 */
	void update(float interest);

	void added(Subject subject, int i);
}
