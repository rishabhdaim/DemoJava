/**
 * 
 */
package demo.java8.javageeks.dp.state;

/**
 * @author Rishabh.Daim
 *
 */
public class RoboticOn implements RoboticState {
	
	private final Robot robot;
	
	/**
	 * @param robot
	 */
	public RoboticOn(Robot robot) {
		this.robot = robot;
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.state.RoboticState#walk()
	 */
	@Override
	public void walk() {
		System.out.println("Robot is walking");
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.state.RoboticState#cook()
	 */
	@Override
	public void cook() {
		System.out.println("Robot is Cooking");
		robot.setRoboticState(robot.getRoboticCook());
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.state.RoboticState#off()
	 */
	@Override
	public void off() {
		robot.setRoboticState(robot.getRoboticOff());
		System.out.println("Robot is Switched Off");
	}

}
