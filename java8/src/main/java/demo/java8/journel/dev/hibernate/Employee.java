/**
 * 
 */
package demo.java8.journel.dev.hibernate;

import java.util.Date;

/**
 * @author Rishabh.Daim
 *
 */
public class Employee {

	
	private int id;
	private String name;
	private String role;
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
}
