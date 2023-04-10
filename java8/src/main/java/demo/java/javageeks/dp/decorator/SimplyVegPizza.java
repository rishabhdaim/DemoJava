/**
 * 
 */
package demo.java.javageeks.dp.decorator;

/**
 * @author Rishabh.Daim
 *
 */
public class SimplyVegPizza implements Pizza {

	/* (non-Javadoc)
	 * @see javageeks.dp.decorator.Pizza#getDesc()
	 */
	@Override
	public String getDesc() {
		return "SimplyVegPizza (230)";
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.decorator.Pizza#getPrice()
	 */
	@Override
	public double getPrice() {
		return 230;
	}
}
