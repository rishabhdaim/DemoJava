/**
 * 
 */
package demo.java.javageeks.dp.state;

/**
 * @author Rishabh.Daim
 *
 */
public class Robot implements RoboticState {
	
	private RoboticState roboticOn;
	private RoboticState roboticOff;
	private RoboticState roboticCook;
	private RoboticState roboticStandby;
	
	/**
	 * current state
	 */
	private RoboticState state;
	
	/**
	 * @param roboticOn
	 * @param roboticOff
	 * @param roboticCook
	 */
	public Robot() {
		this.roboticOn = new RoboticOn(this);
		this.roboticOff = new RoboticOff(this);
		this.roboticCook = new RoboticCook(this);
		this.roboticStandby = new RoboticStandby(this);
		
		this.state = roboticOn;
	}

	@Override
	public void walk() {
		this.state.walk();
		setState(getRoboticStandby());
	}

	@Override
	public void cook() {
		this.state.cook();
		setState(getRoboticStandby());
	}

	@Override
	public void off() {
		this.state.off();
	}

	/**
	 * @return the roboticOn
	 */
	public final RoboticState getRoboticOn() {
		return roboticOn;
	}

	/**
	 * @param roboticOn the roboticOn to set
	 */
	public final void setRoboticOn(RoboticState roboticOn) {
		this.roboticOn = roboticOn;
	}

	/**
	 * @return the roboticOff
	 */
	public final RoboticState getRoboticOff() {
		return roboticOff;
	}

	/**
	 * @param roboticOff the roboticOff to set
	 */
	public final void setRoboticOff(RoboticState roboticOff) {
		this.roboticOff = roboticOff;
	}

	/**
	 * @return the roboticCook
	 */
	public final RoboticState getRoboticCook() {
		return roboticCook;
	}

	/**
	 * @param roboticCook the roboticCook to set
	 */
	public final void setRoboticCook(RoboticState roboticCook) {
		this.roboticCook = roboticCook;
	}

	/**
	 * @return the state
	 */
	public final RoboticState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public final void setState(RoboticState state) {
		this.state = state;
	}
	
	/**
	 * @param state the state to set
	 */
	public final void setRoboticState(RoboticState state) {
		this.state = state;
	}

	/**
	 * @return the roboticStandby
	 */
	public RoboticState getRoboticStandby() {
		return roboticStandby;
	}

	/**
	 * @param roboticStandby the roboticStandby to set
	 */
	public void setRoboticStandby(RoboticState roboticStandby) {
		this.roboticStandby = roboticStandby;
	}

}
