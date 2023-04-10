/**
 * 
 */
package demo.java.javageeks.dp.iterator;

/**
 * @author Rishabh.Daim
 *
 */
public class Shape {

	private final int id;
	private final String name;

	/**
	 * @param id
	 * @param name
	 */
	public Shape(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Shape [id=");
		builder.append(id);
		builder.append(", ");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
		}
		builder.append("]");
		return builder.toString();
	}
}
