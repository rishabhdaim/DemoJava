/**
 * 
 */
package demo.java.javageeks.dp.memento;

/**
 * @author Rishabh.Daim
 *
 */
public class Memento {

	private final double x;
	private final double y;

	/**
	 * @param x
	 * @param y
	 */
	Memento(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	final double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	final double getY() {
		return y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Memento [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append("]");
		return builder.toString();
	}
}
