/**
 * 
 */
package java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rishabh.Daim
 *
 */
public class TestCar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// The first type of method references is constructor reference with the
		// syntax Class::new or alternatively, for generics, Class< T >::new.
		// Please notice that the constructor has no arguments

		Car car = Car.create(Car::new);
		List<Car> cars = Arrays.asList(car);

		// The second type is reference to static method with the syntax
		// Class::static_method. Please notice that the method accepts exactly
		// one parameter of type Car.

		cars.forEach(Car::collide);

		// The third type is reference to instance method of arbitrary object of
		// specific type with the syntax Class::method. Please notice, no
		// arguments are accepted by the method.

		cars.forEach(Car::repair);

		// And the last, fourth type is reference to instance method of
		// particular class instance the syntax instance::method. Please notice
		// that method accepts exactly one parameter of type Car.

		cars.forEach(car::follow);
	}
}