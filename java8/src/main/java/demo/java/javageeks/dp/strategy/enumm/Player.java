/**
 * 
 */
package demo.java.javageeks.dp.strategy.enumm;

/**
 * @author Rishabh.Daim
 *
 */
public class Player {
	
	private Strategy strategy;

	/**
	 * @param strategy
	 */
	public Player(Strategy strategy) {
		this.setStrategy(strategy);
	}

	/**
	 * @return the strategy
	 */
	public Strategy getStrategy() {
		return strategy;
	}

	/**
	 * @param strategy the strategy to set
	 */
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void play() {
		strategy.play();
	}
	
}
