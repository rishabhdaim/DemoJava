/**
 * 
 */
package demo.java8.java8;

import java.util.Arrays;

/**
 * @author Rishabh.Daim
 *
 */
public class DemoLambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// In its simplest form, a lambda could be represented as a
		// comma-separated list of parameters, the �> symbol and the body. For
		// example:
		Arrays.asList(1, 2, 3, 4, 5, 6, 7).forEach(
				e -> System.out.print(e + " "));
		System.out.println();

		// Please notice the type of argument e is being inferred by the
		// compiler. Alternatively, you may explicitly provide the type of the
		// parameter, wrapping the definition in brackets. For example:
		Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i").forEach(
				(String e) -> System.out.print(e + " "));

		System.out.println();
		// In case lambda�s body is more complex, it may be wrapped into square
		// brackets, as the usual function definition in Java. For example:

		Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).forEach(e -> {

			System.out.print(e + " ");
			System.out.print("after addition- ");
			System.out.print(e + 10 + ", ");
		});

		System.out.println();
		// Lambdas may reference the class members and local variables
		// (implicitly making them effectively final if they are not). For
		// example, those two snippet are equivalent:

		final String seperator = " , ";

		Arrays.asList("q", "w", "e", "r", "t", "y").forEach(
				e -> System.out.print(e + seperator));
		System.out.println();

		// Lambdas may return a value. The type of the return value will be
		// inferred by compiler. The return statement is not required if the
		// lambda body is just a one-liner. The two code snippets below are
		// equivalent:

		Arrays.asList("z", "x", "c", "v", "b").sort(
				(e1, e2) -> e1.compareTo(e2));

		Arrays.asList("z", "x", "c", "v", "b").sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			return result;
		});
	}
}