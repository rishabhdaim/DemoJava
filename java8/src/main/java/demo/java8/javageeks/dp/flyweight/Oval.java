/**
 * 
 */
package demo.java8.javageeks.dp.flyweight;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author rishabh.daim
 * 
 */
public class Oval implements Shape {

	// intrinsic property
	private boolean fill;

	public Oval(boolean fill) {
		this.fill = fill;
		System.out.println("Creating Oval object with fill= " + fill);
		// adding time delay
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see flyweightdp.Shape#draw(java.awt.Graphics, int, int, int, int,
	 * java.awt.Color)
	 */
	@Override
	public void draw(Graphics circle, int x, int y, int width, int height,
			Color color) {
		circle.setColor(color);
		circle.drawOval(x, y, width, height);
		if (fill)
			circle.fillOval(x, y, width, height);
	}
}