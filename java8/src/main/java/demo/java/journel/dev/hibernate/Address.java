/**
 * 
 */
package demo.java.journel.dev.hibernate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "Address")
@Access(value=AccessType.FIELD)
@NamedQueries({ @NamedQuery(name = "@HQL_GET_ALL_ADDRESS", query = "from Address") })
@NamedNativeQueries({ @NamedNativeQuery(name = "@SQL_GET_ALL_ADDRESS", query = "select emp_id, address_line1, city, zipcode from Address") })
public class Address {

	@Id
    @Column(name = "emp_id", unique = true, nullable = false)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = { @Parameter(name = "property", value = "employee") })
    private int id;
 
    @Column(name = "address_line1")
    private String addressLine1;
 
    @Column(name = "zipcode")
    private String zipcode;
 
    @Column(name = "city")
    private String city;
 
    @OneToOne
    @PrimaryKeyJoinColumn
    private Employee2 employee;

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
	 * @return the addressLine1
	 */
	public final String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public final void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the zipcode
	 */
	public final String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public final void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the city
	 */
	public final String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public final void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the employee
	 */
	public final Employee2 getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public final void setEmployee(Employee2 employee) {
		this.employee = employee;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Address [id=%s, addressLine1=%s, zipcode=%s, city=%s]", id,
				addressLine1, zipcode, city);
	}
    
    
}
