/**
 * 
 */
package demo.java8.javageeks.dp.decorator;

/**
 * @author rishabh.daim
 * 
 */
public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.print(" Adding features of Luxury Car.");
	}
}
