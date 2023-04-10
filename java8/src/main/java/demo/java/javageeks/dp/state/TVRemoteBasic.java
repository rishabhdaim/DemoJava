/**
 * 
 */
package demo.java.javageeks.dp.state;

/**
 * @author rishabh.daim
 * 
 */
public class TVRemoteBasic {
	private String state;

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	public void doAction() {
		if (state.equalsIgnoreCase("ON"))
			System.out.println("TV is turned ON");
		else if (state.equalsIgnoreCase("OFF"))
			System.out.println("TV is turned OFF");
	}

	public static void main(String[] args) {
		TVRemoteBasic remote = new TVRemoteBasic();
		remote.setState("ON");
		remote.doAction();
		remote.setState("OFF");
		remote.doAction();
	}
}