/**
 * 
 */
package demo.java8.javageeks.dp.observer;

/**
 * @author rishabh.daim
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