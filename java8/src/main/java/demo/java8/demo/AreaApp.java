package demo.java8.demo;

import java.awt.Rectangle;

public class AreaApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 10;
		int j = 5;
		Rectangle rectangle = new Rectangle(i, j);

		System.out.println("rectangle area is : "
				+ RectangleArea.area(rectangle));
	}

}
