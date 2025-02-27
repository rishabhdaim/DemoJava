/**
 * 
 */
package demo.java8.javageeks.dp.decorator;

/**
 * @author Rishabh.Daim
 *
 */
public class Broccoli extends PizzaDecorator {
		
	private final Pizza pizza;

	/**
	 * @param pizza
	 */
	public Broccoli(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String getDesc() {
		return pizza.getDesc() + ", Broccoli (9.25)";
	}
	
	@Override
	public double getPrice() {
		return pizza.getPrice() + 9.25;
	}
	
}
