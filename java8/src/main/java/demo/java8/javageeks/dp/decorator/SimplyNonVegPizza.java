/**
 * 
 */
package demo.java8.javageeks.dp.decorator;

/**
 * @author Rishabh.Daim
 *
 */
public class SimplyNonVegPizza implements Pizza {

	@Override
	public String getDesc() {
		return "SimplyNonVegPizza (350)";
	}

	@Override
	public double getPrice() {
		return 350;
	}
}
