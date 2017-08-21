/**
 * 
 */
package javageeks.dp.bridge;

/**
 * @author aa49442
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