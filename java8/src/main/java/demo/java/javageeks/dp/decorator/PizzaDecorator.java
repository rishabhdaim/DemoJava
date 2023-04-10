/**
 * 
 */
package demo.java.javageeks.dp.decorator;

/**
 * @author Rishabh.Daim
 *
 */
public abstract class PizzaDecorator implements Pizza {

	/* (non-Javadoc)
	 * @see javageeks.dp.decorator.Pizza#getDesc()
	 */
	@Override
	public String getDesc() {
		return "Toppings";
	}

	/* (non-Javadoc)
	 * @see javageeks.dp.decorator.Pizza#getPrice()
	 */
	@Override
	public double getPrice() {
		return 0;
	}

}
