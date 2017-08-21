/**
 * 
 */
package javageeks.dp.decorator;

/**
 * @author Rishabh.Daim
 *
 */
public class RomaTomatoes extends PizzaDecorator {
		
	private final Pizza pizza;

	/**
	 * @param pizza
	 */
	public RomaTomatoes(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String getDesc() {
		return pizza.getDesc() + ", RomaTomatoes (5.20)";
	}
	
	@Override
	public double getPrice() {
		return pizza.getPrice() + 5.20;
	}
	
}
