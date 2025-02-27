/**
 * 
 */
package demo.java8.javageeks.dp.state;

/**
 * @author rishabh.daim
 * 
 */
public class TVRemote {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TVContext context = new TVContext();
		State tvStartState = new TVStartState();
		State tvStopState = new TVStopState();
		context.setTvState(tvStartState);
		context.doAction();
		context.setTvState(tvStopState);
		context.doAction();
		
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}