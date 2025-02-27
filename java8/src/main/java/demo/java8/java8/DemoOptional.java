/**
 * 
 */
package demo.java8.java8;

import java.util.Optional;

/**
 * @author Rishabh.Daim
 *
 */
public class DemoOptional {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Optional<String> name = Optional.ofNullable(null);

		System.out.println("name is set? " + name.isPresent());
		System.out.println("name: " + name.orElseGet(() -> "rishu"));
		System.out.println(name.map(s -> "Hey " + s + "!").orElse(
				"Hey Stranger!"));

		System.out.println();
		name = Optional.ofNullable("daim");

		System.out.println("name is set? " + name.isPresent());
		System.out.println("name: " + name.orElseGet(() -> "rishu"));
		System.out.println(name.map(s -> "Hey " + s + "!").orElse(
				"Hey Stranger!"));
	}

}
