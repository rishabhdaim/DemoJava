/**
 * 
 */
package javageeks.dp.decorator;

/**
 * @author Rishabh.Daim
 *
 */
public class Cheese extends PizzaDecorator {
		
	private final Pizza pizza;

	/**
	 * @param pizza
	 */
	public Cheese(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String getDesc() {
		return pizza.getDesc() + ", Cheese (20.72)";
	}
	
	@Override
	public double getPrice() {
		return pizza.getPrice() + 20.72;
	}
	
}
