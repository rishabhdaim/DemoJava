/**
 * 
 */
package demo.java.javageeks.dp.flyweight;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Fly weight interface
 * 
 * @author rishabh.daim
 * 
 */
public interface Shape {

	public void draw(Graphics g, int x, int y, int width, int height, Color color);
}