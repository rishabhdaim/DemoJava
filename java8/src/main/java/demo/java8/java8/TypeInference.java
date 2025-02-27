/**
 * 
 */
package demo.java8.java8;

/**
 * @author Rishabh.Daim
 *
 */
public class TypeInference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Value<String> value = new Value<>();
		// The type parameter of Value.defaultValue()is inferred and is not
		// required to be provided. In Java 7, the same example will not compile
		// and should be rewritten to Value.< String >defaultValue().
		System.out.println(value.getOrDefault("22", Value.defaultValue()));
	}

	private static class Value<T> {
		public static <T> T defaultValue() {
			return null;
		}

		public T getOrDefault(T value, T defaultValue) {
			return value != null ? value : defaultValue;
		}
	}
}