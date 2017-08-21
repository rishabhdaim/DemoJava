/**
 * 
 */
package journel.dev.hibernate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author Rishabh.Daim
 *
 */
@Entity
@Table(name="MyEmployee")
@Access(value=AccessType.FIELD)
@NamedQueries({ @NamedQuery(name = "@HQL_GET_ALL_EMPLOYEE", query = "from Employee2"), @NamedQuery(name = "@HQL_GET_EMPLOYEE_BY_ID", query = "from Employee2 where emp_id = :id") ,@NamedQuery(name = "@HQL_GET_EMPLOYEE_BY_SALARY", query = "from Employee2 where emp_salary > :salary")})
public class Employee2 {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
	@SequenceGenerator(name="id_sequence", sequenceName="emp_seq")
	@Column(name = "emp_id")
    private int id;
 
    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_salary")
    private double salary;
 
    @OneToOne(mappedBy = "employee")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Address address;

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
	 * @return the salary
	 */
	public final double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public final void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the address
	 */
	public final Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public final void setAddress(Address address) {
		this.address = address;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Employee2 [id=%s, name=%s, salary=%s, address=%s]", id, name,
				salary, address);
	}
	
}
