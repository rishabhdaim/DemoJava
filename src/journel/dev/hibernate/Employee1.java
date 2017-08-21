/**
 * 
 */
package journel.dev.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



/**
 * @author Rishabh.Daim
 *
 */
@Entity
@Table(name="EMPLOYEE", uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Employee1 {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
	@SequenceGenerator(name="id_sequence", sequenceName="emp_seq")
	@Column(name="ID", nullable=false, unique=true, length=10)
	private int id;
	
	@Column(name="NAME", length=20)
	private String name;
	
	@Column(name="ROLE", length=30)
	private String role;
	
	@Column(name="insert_time")
	private Date insertTime;
	
	
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
	 * @return the role
	 */
	public final String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public final void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the insertTime
	 */
	public final Date getInsertTime() {
		return insertTime;
	}
	/**
	 * @param insertTime the insertTime to set
	 */
	public final void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Employee1 [id=%s, name=%s, role=%s, insertTime=%s]", id, name,
				role, insertTime);
	}
}
