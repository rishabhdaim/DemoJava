/**
 * 
 */
package demo.java.javageeks.dp.bridge;

/**
 * @author rishabh.daim
 * 
 */
public class Triangle extends Shape {

	public Triangle(Color color) {
		super(color);
	}

	@Override
	public void applyColor() {
		System.out.print("Triangle filled with");
		color.aaplyColor();
	}
}