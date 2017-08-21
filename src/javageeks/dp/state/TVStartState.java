/**
 * 
 */
package javageeks.dp.state;

/**
 * @author aa49442
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