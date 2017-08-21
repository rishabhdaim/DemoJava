/**
 * 
 */
package journel.dev.hibernate;

/**
 * @author Rishabh.Daim
 *
 */
public class Customer {
	
	private long id;
    private String name;
    private String email;
    private String address;
    
    private Txn txn;
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
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public final String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public final void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the txn
	 */
	public final Txn getTxn() {
		return txn;
	}
	/**
	 * @param txn the txn to set
	 */
	public final void setTxn(Txn txn) {
		this.txn = txn;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, email=%s, address=%s]",
				id, name, email, address);
	}
}
