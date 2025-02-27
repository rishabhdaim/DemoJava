/**
 * 
 */
package demo.java8.javageeks.dp.state;

/**
 * @author Rishabh.Daim
 *
 */
public class TestStatePattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.walk();
		robot.cook();
		robot.walk();
		robot.off();
		robot.walk();
		robot.off();
		robot.cook();
	}

}
