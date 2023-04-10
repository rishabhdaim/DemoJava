/**
 * 
 */
package demo.java.javageeks.dp.memento;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author Rishabh.Daim
 *
 */
public class CareTaker {
	
	private final Map<String, Memento> savePointMap = Maps.newConcurrentMap();
	
	public void saveMemento(final Memento memento, final String savePointName) {
		System.out.println("Saving memento " + memento.toString() + " with savePoint : " + savePointName);
		savePointMap.put(savePointName, memento);
	}
	
	public Memento getMemento(final String savePointName) {
		System.out.println("Getting memento with savePoint : " + savePointName);
		return savePointMap.get(savePointName);
	}
	
	public void clearSavePoints() {
		System.out.println("Clearing all save points");
		savePointMap.clear();
	}
}
