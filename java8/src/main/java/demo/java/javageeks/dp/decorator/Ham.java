/**
 * 
 */
package demo.java.javageeks.dp.decorator;

/**
 * @author Rishabh.Daim
 *
 */
public class Ham extends PizzaDecorator {
		
	private final Pizza pizza;

	/**
	 * @param pizza
	 */
	public Ham(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String getDesc() {
		return pizza.getDesc() + ", Ham (18.12)";
	}
	
	@Override
	public double getPrice() {
		return pizza.getPrice() + 18.12;
	}
	
}
