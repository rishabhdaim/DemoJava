/**
 * 
 */
package javageeks.dp.composite;

/**
 * @author aa49442
 * 
 */
public class Triangle implements Shape {

	/*
	 * (non-Javadoc)
	 * 
	 * @see compositedp.Shape#draw(java.lang.String)
	 */
	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Triangle with color " + fillColor);
	}

}
