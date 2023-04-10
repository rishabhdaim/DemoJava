/**
 * 
 */
package demo.java.javageeks.dp.bridge;

/**
 * @author rishabh.daim
 * 
 */
public class Circle extends Shape {

	public Circle(Color color) {
		super(color);
	}

	@Override
	public void applyColor() {
		System.out.print("Circle filled with");
		color.aaplyColor();
	}
}