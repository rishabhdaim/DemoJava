/**
 * 
 */
package demo.java8.journel.dev.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Rishabh.Daim
 *
 */
@Entity
@Table(name="Items")
public class Items1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
	@SequenceGenerator(name="id_sequence", sequenceName="item_seq")
	@Column(name="id")
	private long id;
	
	@Column(name="item_id")
    private String itemId;
	
	@Column(name="item_total")
    private double itemTotal;
	
	@Column(name="quantity")
    private int quantity;
	
	@ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart1 cart1;
     
    //Hibernate requires no-args constructor
    public Items1(){}
     
    public Items1(String itemId, double total, int qty, Cart1 c){
        this.itemId=itemId;
        this.itemTotal=total;
        this.quantity=qty;
        this.cart1=c;
    }
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public double getItemTotal() {
        return itemTotal;
    }
    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Cart1 getCart() {
        return cart1;
    }
    public void setCart(Cart1 cart) {
        this.cart1 = cart;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Items [id=%s, itemId=%s, itemTotal=%s, quantity=%s]", id,
				itemId, itemTotal, quantity);
	}
    
}
