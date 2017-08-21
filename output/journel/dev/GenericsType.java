package journel.dev;

public class GenericsType<T> {

	private T t;

	public T get() {
		return this.t;
	}

	public void set(T t1) {
		this.t = t1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericsType<String> g1 = new GenericsType<>();
		g1.set("rishabh"); // valid
		GenericsType<String> g2 = new GenericsType<>();
		g2.set("rishabh");

		boolean isEqual = GenericsType.<String> isEqual(g1, g2);
		// above statement can be written simply as
		isEqual = GenericsType.isEqual(g1, g2);
		// This feature, known as type inference, allows you to invoke a generic
		// method as an ordinary method, without specifying a type between angle
		// brackets.
		// Compiler will infer the type that is needed
		System.out.println(isEqual);
	}

	// Generics in method
	public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {
		return g1.get().equals(g2.get());
	}

	public static <T extends Comparable<T>> int compare(T t1, T t2) {
		return t1.compareTo(t2);
	}
}