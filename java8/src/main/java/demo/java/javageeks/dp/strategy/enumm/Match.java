/**
 * 
 */
package demo.java.javageeks.dp.strategy.enumm;

/**
 * @author Rishabh.Daim
 *
 */
public class Match {
	
	public static void main(String[] args) {
		// player is context here
		Player player = new Player(Strategy.T20);
		player.play();
		
		player.setStrategy(Strategy.ONE_DAY);
		player.play();
		
		player.setStrategy(Strategy.TEST);
		player.play();
	}
}
