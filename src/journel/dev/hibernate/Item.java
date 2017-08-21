/**
 * 
 */
package journel.dev.hibernate;

import java.util.Set;

/**
 * @author Rishabh.Daim
 *
 */
public class Item {
	
	private int id;
    private double price;
    private String description;
 
    private Set<Carts> carts;

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
	 * @return the price
	 */
	public final double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public final void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the carts
	 */
	public final Set<Carts> getCarts() {
		return carts;
	}

	/**
	 * @param carts the carts to set
	 */
	public final void setCarts(Set<Carts> carts) {
		this.carts = carts;
	}
    
}
