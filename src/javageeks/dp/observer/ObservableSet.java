/**
 * 
 */
package javageeks.dp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rishabh.daim
 * 
 */
public class ObservableSet implements Subject {

	private final List<Observer> observers = new ArrayList<Observer>();
	private final List<Integer> integers = new ArrayList<Integer>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see observerdp.Subject#registerObserver(observerdp.Observer)
	 */
	@Override
	public void registerObserver(Observer observer) {
		synchronized (observers) {
			observers.add(observer);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see observerdp.Subject#removeObserver(observerdp.Observer)
	 */
	@Override
	public void removeObserver(Observer observer) {
		synchronized (observers) {
			observers.remove(observer);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see observerdp.Subject#notifyObservers()
	 */
	@Override
	public void notifyObservers() {
		synchronized (observers) {
			for (Observer observer : observers) {
				observer.update(0);
			}
		}
	}

	public void notifyObservers(int i) {
		synchronized (observers) {
			for (Observer observer : observers) {
				observer.added(this, i);
			}
		}
	}

	public void add(int i) {
		boolean b = integers.add(i);
		if (b)
			notifyObservers(i);
	}
}
