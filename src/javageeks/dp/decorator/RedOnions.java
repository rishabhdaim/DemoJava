/**
 * 
 */
package javageeks.dp.decorator;

/**
 * @author Rishabh.Daim
 *
 */
public class RedOnions extends PizzaDecorator {
		
	private final Pizza pizza;

	/**
	 * @param pizza
	 */
	public RedOnions(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String getDesc() {
		return pizza.getDesc() + ", RedOnions (3.75)";
	}
	
	@Override
	public double getPrice() {
		return pizza.getPrice() + 3.75;
	}
	
}
