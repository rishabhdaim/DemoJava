/**
 * 
 */
package demo.java8.javageeks.dp.state;

/**
 * @author Rishabh.Daim
 *
 */
public class RoboticCook implements RoboticState {
	
	private final Robot robot;
	
	/**
	 * @param robot
	 */
	public RoboticCook(Robot robot) {
		this.robot = robot;
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.state.RoboticState#walk()
	 */
	@Override
	public void walk() {
		System.out.println("Robot is walking");
		robot.setRoboticState(robot.getRoboticOn());
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.state.RoboticState#cook()
	 */
	@Override
	public void cook() {
		System.out.println("Robot is Cooking");
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.state.RoboticState#off()
	 */
	@Override
	public void off() {
		System.out.println("Cannot switched off while cooking...");
	}

}
