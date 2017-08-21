/**
 * 
 */
package journel.dev.hibernate;

import java.util.Set;

/**
 * @author Rishabh.Daim
 *
 */
public class Cart {
	
	private long id;
    private double total;
    private String name;
    private Set<Items> items;
     
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<Items> getItems() {
        return items;
    }
    public void setItems(Set<Items> items) {
        this.items = items;
    }
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("Cart [id=%s, total=%s, name=%s]", id, total, name);
	}
}
