/**
 * 
 */
package demo.java.javageeks.dp.flyweight;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * This is fly weight factory to create and store fly weight instances
 * 
 * @author rishabh.daim
 * 
 */
public class ShapeFactory {

	private static final Map<ShapeType, Shape> shapes = Maps.newConcurrentMap();

	public static Shape getShape(ShapeType type) {
		if (type == null)
			throw new NullPointerException("shape can't be null..");
		Shape shapeImpl = shapes.get(type);
		if (shapeImpl == null) {
			if (type.equals(ShapeType.OVAL_FILL))
				shapeImpl = new Oval(true);
			else if (type.equals(ShapeType.OVAL_NOFILL))
				shapeImpl = new Oval(false);
			else if (type.equals(ShapeType.LINE))
				shapeImpl = new Line();
			else if (ShapeType.RECT_FILL.equals(type))
				shapeImpl = new Rectangle(true);
			else if (ShapeType.RECT_NON_FILL.equals(type))
				shapeImpl = new Rectangle(false);

			shapes.put(type, shapeImpl);
		}
		return shapeImpl;
	}
}