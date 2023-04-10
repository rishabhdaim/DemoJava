/**
 * 
 */
package demo.java.javageeks.dp.decorator;

/**
 * @author rishabh.daim
 * 
 */
public class DecoratorPatternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final BasicCar c = new BasicCar();
		final Car sportsCar = new SportsCar(c);
		sportsCar.assemble();
		System.out.println();
		System.out.println("*****");
		final LuxuryCar luxuryCar = new LuxuryCar(c);
		Car sportsLuxuryCar = new SportsCar(luxuryCar);
		sportsLuxuryCar.assemble();
	}
}