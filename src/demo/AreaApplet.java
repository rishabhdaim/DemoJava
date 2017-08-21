package demo;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AreaApplet extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Rectangle r;

	@Override
	public void init() {
		int i = 10;
		int j = 5;
		r = new Rectangle(i, j);
		super.init();
	}

	@Override
	public void paint(Graphics g) {
		g.drawString("The rectangle's area is " + RectangleArea.area(r), 10, 10);
		super.paint(g);
	}
}