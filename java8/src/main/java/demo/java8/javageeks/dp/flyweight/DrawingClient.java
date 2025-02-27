/**
 * 
 */
package demo.java8.javageeks.dp.flyweight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author rishabh.daim
 * 
 */
public class DrawingClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int WIDTH;
	private final int HEIGHT;
	private static final ShapeType[] shapes = { ShapeType.LINE,
			ShapeType.OVAL_FILL, ShapeType.OVAL_NOFILL, ShapeType.RECT_FILL,
			ShapeType.RECT_NON_FILL };
	private static final Color[] colors = { Color.RED, Color.GREEN,
			Color.YELLOW, Color.BLACK, Color.MAGENTA };

	/**
	 * @param wIDTH
	 * @param hEIGHT
	 * @throws HeadlessException
	 */
	public DrawingClient(int wIDTH, int hEIGHT) throws HeadlessException {
		super();
		WIDTH = wIDTH;
		HEIGHT = hEIGHT;

		Container contentPane = super.getContentPane();

		JButton startButton = new JButton("draw");
		final JPanel panel = new JPanel();

		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(startButton, BorderLayout.SOUTH);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g = panel.getGraphics();
				for (int i = 0; i < 40; ++i) {
					Shape shape = ShapeFactory.getShape(getRandomShape());
					shape.draw(g, getRandomX(), getRandomY(), getRandomWidth(),
							getRandomHeight(), getRandomColor());
				}
			}
		});
	}

	private ShapeType getRandomShape() {
		return shapes[(int) (Math.random() * shapes.length)];
	}

	private int getRandomX() {
		return (int) (Math.random() * WIDTH);
	}

	private int getRandomY() {
		return (int) (Math.random() * HEIGHT);
	}

	private int getRandomWidth() {
		return (int) (Math.random() * (WIDTH / 10));
	}

	private int getRandomHeight() {
		return (int) (Math.random() * (HEIGHT / 10));
	}

	private Color getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	public static void main(String[] args) {
		new DrawingClient(1800, 1000);
	}
}