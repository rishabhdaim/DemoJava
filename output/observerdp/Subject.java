/**
 * 
 */
package observerdp;

/**
 * @author aa49442
 * 
 */
public interface Subject {
	/**
	 * @param observer
	 */
	void registerObserver(Observer observer);

	/**
	 * @param observer
	 */
	void removeObserver(Observer observer);

	/**
	 * 
	 */
	void notifyObservers();

}
