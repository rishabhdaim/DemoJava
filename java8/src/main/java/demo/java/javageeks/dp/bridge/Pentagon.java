/**
 * 
 */
package demo.java.javageeks.dp.bridge;

/**
 * @author rishabh.daim
 * 
 */
public class Pentagon extends Shape {

	public Pentagon(Color color) {
		super(color);
	}

	@Override
	public void applyColor() {
		System.out.print("Pentagon filled with");
		color.aaplyColor();
	}
}