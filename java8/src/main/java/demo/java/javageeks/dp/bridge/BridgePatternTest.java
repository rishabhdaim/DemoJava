/**
 * 
 */
package demo.java.javageeks.dp.bridge;

/**
 * @author rishabh.daim
 * 
 */
public class BridgePatternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape shape = new Triangle(new RedColor());
		shape.applyColor();
		shape = new Triangle(new GreenColor());
		shape.applyColor();
		shape = new Triangle(new BlackColor());
		shape.applyColor();
		shape = new Circle(new RedColor());
		shape.applyColor();
		shape = new Circle(new BlackColor());
		shape.applyColor();
	}
}