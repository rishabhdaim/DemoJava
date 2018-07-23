/**
 * 
 */
package concurrent;

/**
 * @author rishabh.daim
 * 
 */
public class Customer {
	private int id;
	private String name;

	public Customer(int i, String n) {
		this.id = i;
		this.name = n;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
}