/**
 * 
 */
package demo.java8.javageeks.dp.state;

/**
 * @author rishabh.daim
 * 
 */
public class TVStopState implements State {

	/*
	 * (non-Javadoc)
	 * 
	 * @see statedp.State#doAction()
	 */
	@Override
	public void doAction() {
		System.out.println("TV is turned OFF");
	}
}