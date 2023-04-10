/**
 * 
 */
package demo.java.javageeks.dp.composite;

/**
 * @author rishabh.daim
 * 
 */
public class Square implements Shape {

	/*
	 * (non-Javadoc)
	 * 
	 * @see compositedp.Shape#draw(java.lang.String)
	 */
	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Square with color " + fillColor);
	}
}