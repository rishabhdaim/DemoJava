/**
 * 
 */
package javageeks.dp.state;

/**
 * @author Rishabh.Daim
 *
 */
public class RoboticStandby implements RoboticState {
	
	private final Robot robot;
	
	/**
	 * @param robot
	 */
	public RoboticStandby(Robot robot) {
		this.robot = robot;
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.state.RoboticState#walk()
	 */
	@Override
	public void walk() {
		System.out.println("Robot is in standby mode");
		robot.setRoboticState(robot.getRoboticOn());
		System.out.println("Robot is walking");
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.state.RoboticState#cook()
	 */
	@Override
	public void cook() {
		System.out.println("Robot is in standby mode");
		robot.setRoboticState(robot.getRoboticCook());
		System.out.println("Robot is Cooking");
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.state.RoboticState#off()
	 */
	@Override
	public void off() {
		System.out.println("Robot is in standby mode");
		robot.setRoboticState(robot.getRoboticOff());
		System.out.println("Robot is switched off");
	}

}
