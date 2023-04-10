/**
 * 
 */
package demo.java.journel.dev.hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Rishabh.Daim
 *
 */
@Entity
@Table(name="Cart")
public class Cart1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
	@SequenceGenerator(name="id_sequence", sequenceName="cart_seq")
	@Column(name="cart_id")
	private long id;
	
	@Column(name="total")
    private double total;
	
	@Column(name="name")
    private String name;
	
	@OneToMany(mappedBy="cart1")
    private Set<Items1> items;
     
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
    public Set<Items1> getItems() {
        return items;
    }
    public void setItems(Set<Items1> items) {
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
