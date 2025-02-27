/**
 * 
 */
package demo.java8.javageeks.dp.strategy.enumm;

/**
 * @author Rishabh.Daim
 *
 */
public enum Strategy {
	
	T20 {
		@Override
		public void play() {
			System.out.printf("In %s, If it's in the V, make sure it goes to tree %n", name());
		}
	}, ONE_DAY {
		@Override
		public void play() {
			System.out.printf("In %s, Push it for Single %n", name());
		}
	}, TEST {
		@Override
		public void play() {
			System.out.printf("In %s, Grind them hard %n", name());
		}
	};
	
	public abstract void play();
}
