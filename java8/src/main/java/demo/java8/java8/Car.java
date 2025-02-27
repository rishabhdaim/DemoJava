/**
 * 
 */
package demo.java8.java8;

import java.util.function.Supplier;

/**
 * @author Rishabh.Daim
 *
 */
public class Car {

	public static Car create(Supplier<Car> supplier) {
		return supplier.get();
	}

	public static void collide(Car car) {
		System.out.println("colliding with : " + car.toString());
	}

	public void follow(Car car) {
		System.out.println("following the : " + car.toString());
	}

	public void repair() {
		System.out.println("repaired : " + this.toString());
	}
}
