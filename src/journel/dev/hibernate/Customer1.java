/**
 * 
 */
package journel.dev.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author Rishabh.Daim
 *
 */
@Entity
@Table(name="CUSTOMER")
public class Customer1 {
	
	@Id
	@Column(name="txn_id", unique=true, nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters={@Parameter(name="property", value="txn")})
	private long id;
	
	@Column(name="cust_name")
    private String name;
	
	@Column(name="cust_email")
    private String email;
	
	@Column(name="cust_address")
    private String address;
    
	@OneToOne
	@PrimaryKeyJoinColumn
    private Txn1 txn;
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
	public final Txn1 getTxn() {
		return txn;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Customer1 [id=%s, name=%s, email=%s, address=%s]", id, name,
				email, address);
	}
	/**
	 * @param txn the txn to set
	 */
	public final void setTxn(Txn1 txn) {
		this.txn = txn;
	}
}
