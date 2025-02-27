/**
 * 
 */
package demo.java8.javageeks.dp.state;

/**
 * @author rishabh.daim
 * 
 */
public class TVContext implements State {

	private State tvState;

	/**
	 * @return the tvState
	 */
	public State getTvState() {
		return tvState;
	}

	/**
	 * @param tvState
	 *            the tvState to set
	 */
	public void setTvState(State tvState) {
		this.tvState = tvState;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see statedp.State#doAction()
	 */
	@Override
	public void doAction() {
		this.tvState.doAction();
	}
}