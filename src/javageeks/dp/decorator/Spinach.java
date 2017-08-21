/**
 * 
 */
package javageeks.dp.decorator;

/**
 * @author Rishabh.Daim
 *
 */
public class Spinach extends PizzaDecorator {
		
	private final Pizza pizza;

	/**
	 * @param pizza
	 */
	public Spinach(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String getDesc() {
		return pizza.getDesc() + ", Spinach (7.92)";
	}
	
	@Override
	public double getPrice() {
		return pizza.getPrice() + 7.92;
	}
	
}
