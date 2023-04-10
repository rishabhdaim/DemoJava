/**
 * 
 */
package demo.java.javageeks.dp.flyweight;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author rishabh.daim
 * 
 */
public class Rectangle implements Shape {
	private boolean fill;

	/**
	 * @param fill
	 */
	public Rectangle(boolean fill) {
		super();
		this.fill = fill;
		System.out.println("Creating Oval object with fill= " + fill);
		try {
			Thread.sleep(3000);
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
	public void draw(Graphics g, int x, int y, int width, int height,
			Color color) {
		g.setColor(color);
		g.drawRect(x, y, width, height);
		if (fill)
			g.fillRect(x, y, width, height);
	}
}