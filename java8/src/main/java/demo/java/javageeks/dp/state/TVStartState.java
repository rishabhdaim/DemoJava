/**
 * 
 */
package demo.java.javageeks.dp.state;

/**
 * @author rishabh.daim
 * 
 */
public class TVStartState implements State {

	/*
	 * (non-Javadoc)
	 * 
	 * @see statedp.State#doAction()
	 */
	@Override
	public void doAction() {
		System.out.println("TV is turned ON");
	}
}