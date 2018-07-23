/**
 * 
 */
package javageeks.dp.composite;

/**
 * @author rishabh.daim
 * 
 */
public class Circle implements Shape {

	/*
	 * (non-Javadoc)
	 * 
	 * @see compositedp.Shape#draw(java.lang.String)
	 */
	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Circle with color " + fillColor);
	}

}
