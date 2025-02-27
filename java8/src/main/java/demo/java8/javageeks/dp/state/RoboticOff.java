/**
 * 
 */
package demo.java8.javageeks.dp.state;

/**
 * @author Rishabh.Daim
 *
 */
public class RoboticOff implements RoboticState {
	
	private final Robot robot;
	
	/**
	 * @param robot
	 */
	public RoboticOff(Robot robot) {
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
		System.out.println("Cannot cook at Off state.");
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.state.RoboticState#off()
	 */
	@Override
	public void off() {
		System.out.println("Already switched off...");
	}

}
