/**
 * 
 */
package demo.java8.javageeks.dp.iterator;

import java.util.Iterator;

/**
 * @author Rishabh.Daim
 *
 */
public class ShapeIterator implements Iterator<Shape> {
	
	private final Shape[] shapes;
	private int pos;
	
	public ShapeIterator(final Shape[] shapes) {
		this.shapes = shapes;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		
		if (pos >= shapes.length || shapes[pos] == null)
			return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public Shape next() {
		return shapes[pos++];
	}
	
	@Override
	public void remove() {
		if (pos <= 0) {
			throw new IllegalStateException();
		}
		
		if (shapes[pos-1] != null) {
			for (int i = pos-1, n = shapes.length; i < n-1;i++) {
				shapes[i] = shapes[i+1];
			}
			shapes[shapes.length-1] = null;
		}
	}

}
