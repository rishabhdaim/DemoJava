/**
 * 
 */
package javageeks.dp.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aa49442
 * 
 */
public class Drawing implements Shape {

	// collection of Shapes
	private List<Shape> shapes = new ArrayList<Shape>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see compositedp.Shape#draw(java.lang.String)
	 */
	@Override
	public void draw(String fillColor) {
		for (Shape shape : shapes)
			shape.draw(fillColor);
	}

	// adding shape to drawing
	public void add(Shape s) {
		this.shapes.add(s);
	}

	// removing shape from drawing
	public void remove(Shape s) {
		shapes.remove(s);
	}

	// removing all the shapes
	public void clear() {
		System.out.println("Clearing all the shapes from drawing");
		this.shapes.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Drawing [shapes=" + shapes + "]";
	}
}