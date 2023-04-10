/**
 * 
 */
package demo.java.journel.dev.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author Rishabh.Daim
 *
 */
@Entity
@Table(name="TRANSACTION")
public class Txn1 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
	@SequenceGenerator(name="id_sequence", sequenceName="txn_seq")
	@Column(name="txn_id", unique=true, nullable=false)
	private long id;
	
	@Column(name="txn_date")
	private Date date;
	
	@Column(name="txn_total")
	private double total;
	
	@OneToOne(mappedBy="txn")
	@Cascade(value=CascadeType.SAVE_UPDATE)
	private Customer1 customer;
	/**
	 * @return the id
	 */
	public final long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public final void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the date
	 */
	public final Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public final void setDate(Date date) {
		this.date = date;
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
	 * @return the customer
	 */
	public final Customer1 getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public final void setCustomer(Customer1 customer) {
		this.customer = customer;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String
				.format("Txn1 [id=%s, date=%s, total=%s]", id, date, total);
	}
}
