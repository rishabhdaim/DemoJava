/**
 * 
 */
package javageeks.dp.iterator;

import java.util.Arrays;

/**
 * @author Rishabh.Daim
 *
 */
public class ShapeStorage {
	
	private final Shape[] shapes;
	private int index;
	
	public ShapeStorage(final int n) {
		shapes = new Shape[n];
	}
	
	public void addShape(final String name) {
		int i = index++;
		shapes[i] = new Shape(i, name);
	}
	
	public Shape[] getShapes() {
		return shapes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShapeStorage [");
		if (shapes != null) {
			builder.append("shapes=");
			builder.append(Arrays.toString(shapes));
		}
		builder.append("]");
		return builder.toString();
	}
}
