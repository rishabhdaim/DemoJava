/**
 * 
 */
package demo.java8.journel.dev.hibernate;

import java.util.Set;

/**
 * @author Rishabh.Daim
 *
 */
public class Carts {
	
	private int id;
    private double total;
 
    private Set<Item> items;

	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the total
	 */
	public final double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public final void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the items
	 */
	public final Set<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public final void setItems(Set<Item> items) {
		this.items = items;
	}
    
}
