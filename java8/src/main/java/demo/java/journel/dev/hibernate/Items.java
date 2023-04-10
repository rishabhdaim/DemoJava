/**
 * 
 */
package demo.java.journel.dev.hibernate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Rishabh.Daim
 *
 */
public class Items {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
	@SequenceGenerator(name="id_sequence", sequenceName="item_seq")
	private long id;
	
	@Column(name="item_id")
    private String itemId;
	
	@Column(name="item_total")
    private double itemTotal;
	
	@Column(name="quantity")
    private int quantity;
    private Cart cart;
     
    //Hibernate requires no-args constructor
    public Items(){}
     
    public Items(String itemId, double total, int qty, Cart c){
        this.itemId=itemId;
        this.itemTotal=total;
        this.quantity=qty;
        this.cart=c;
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
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
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
