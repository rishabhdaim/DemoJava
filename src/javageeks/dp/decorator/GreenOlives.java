/**
 * 
 */
package javageeks.dp.decorator;

/**
 * @author Rishabh.Daim
 *
 */
public class GreenOlives extends PizzaDecorator {
		
	private final Pizza pizza;

	/**
	 * @param pizza
	 */
	public GreenOlives(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String getDesc() {
		return pizza.getDesc() + ", GreenOlives (5.47)";
	}
	
	@Override
	public double getPrice() {
		return pizza.getPrice() + 5.47;
	}
	
}
