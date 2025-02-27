/**
 * 
 */
package demo.java8.javageeks.dp.iterator;

/**
 * @author Rishabh.Daim
 *
 */
public class TestIteratorPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShapeStorage storage = new ShapeStorage(10);
		storage.addShape("Polygon");
		storage.addShape("Hexagon");
		storage.addShape("Circle");
		storage.addShape("Rectangle");
		storage.addShape("Square");
		ShapeIterator iterator = new ShapeIterator(storage.getShapes());
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("Apply removing while iterating...");
		iterator = new ShapeIterator(storage.getShapes());
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			iterator.remove();
		}
	}

}
