/**
 * 
 */
package javageeks.dp.bridge;

/**
 * @author aa49442
 * 
 */
public abstract class Shape {

	// Composition - implementor
	protected Color color;

	/**
	 * @param color
	 *            constructor with implementor as input argument
	 */
	public Shape(Color color) {
		super();
		this.color = color;
	}

	abstract public void applyColor();
}