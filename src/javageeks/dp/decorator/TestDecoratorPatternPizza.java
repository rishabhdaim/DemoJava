/**
 * 
 */
package javageeks.dp.decorator;

import java.text.DecimalFormat;

/**
 * @author Rishabh.Daim
 *
 */
public class TestDecoratorPatternPizza {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DecimalFormat dformat = new DecimalFormat("#.##");

		Pizza pizza = new SimplyVegPizza();
		pizza = new RomaTomatoes(pizza);
		pizza = new GreenOlives(pizza);
		pizza = new Spinach(pizza);
		pizza = new Broccoli(pizza);
		pizza = new Cheese(pizza);
		System.out.println("Desc: " + pizza.getDesc());
		System.out.println("Price: " + dformat.format(pizza.getPrice()));

		pizza = new SimplyNonVegPizza();
		pizza = new Meat(pizza);
		pizza = new Cheese(pizza);
		pizza = new FetaCheese(pizza);
		pizza = new Ham(pizza);
		System.out.println("Desc: " + pizza.getDesc());
		System.out.println("Price: " + dformat.format(pizza.getPrice()));
	}

}
