/**
 * 
 */
package demo.java8.journel.dev.hibernate;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Rishabh.Daim
 *
 */
@Entity
@Table(name = "CARTS")
public class Carts1 {
	
	@Id
    @Column(name = "cart_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
	@SequenceGenerator(name="id_sequence", sequenceName="cart_seq")
	private int id;
	
	@Column(name = "cart_total")
    private double total;
 
	
	@ManyToMany(targetEntity = Item1.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "CART_ITEMS", 
                joinColumns = { @JoinColumn(name = "cart_id") }, 
                inverseJoinColumns = { @JoinColumn(name = "item_id") })
    private Set<Item1> items;

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
	public final Set<Item1> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public final void setItems(Set<Item1> items) {
		this.items = items;
	}
    
}
