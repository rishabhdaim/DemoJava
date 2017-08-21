/**
 * 
 */
package journel.dev.hibernate;

import java.util.Date;

/**
 * @author Rishabh.Daim
 *
 */
public class Txn {
	
	private long id;
	private Date date;
	private double total;
	private Customer customer;
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
	public final Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public final void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Txn [id=%s, date=%s, total=%s]", id, date, total);
	}
}
