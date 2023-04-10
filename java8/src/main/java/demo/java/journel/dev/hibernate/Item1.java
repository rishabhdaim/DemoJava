/**
 * 
 */
package demo.java.journel.dev.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Rishabh.Daim
 *
 */
@Entity
@Table(name="ITEM")
public class Item1 {
	
	@Id
    @Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
	@SequenceGenerator(name="id_sequence", sequenceName="item_seq")
	private int id;
	
	@Column(name="item_price")
    private double price;
	
	@Column(name="item_desc")
    private String description;
 
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

}
