/**
 * 
 */
package javageeks.dp.composite;

/**
 * @author aa49442
 * 
 */
public class TestCompositePattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shape tri = new Triangle();
		Shape tri1 = new Triangle();
		Shape sqaure = new Square();
		Shape cir = new Circle();
		Drawing drawing = new Drawing();
		drawing.add(tri1);
		drawing.add(tri1);
		drawing.add(cir);
		drawing.add(sqaure);
		drawing.draw("Red");
		drawing.clear();
		drawing.add(tri);
		drawing.add(cir);
		drawing.draw("Green");
	}
}