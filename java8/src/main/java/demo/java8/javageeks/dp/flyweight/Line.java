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
public class Line implements Shape {

	public Line() {
		System.out.println("Creating Line object");
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
	public void draw(Graphics g, int x, int y, int width, int height,
			Color color) {
		g.setColor(color);
		g.drawLine(x, y, width, height);
	}
}