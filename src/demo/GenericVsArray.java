package demo;

public class GenericVsArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Holder<Integer> numbers = new Holder<Integer>(10);
		numbers.add(101);
		System.out.println("Get: " + numbers.get(0));
		numbers.add(104);
		System.out.println("Get: " + numbers.get(1));
	}

	/**
	 * Generic Holder for holding contents of different object type Generic in
	 * Java eliminates casting required while calling get(index) from client
	 * code
	 * 
	 * @param <T>
	 */
	private static class Holder<T> {
		private T[] contents;
		private int index = 0;

		@SuppressWarnings("unchecked")
		public Holder(int size) {
			// contents = new T[size]; //compiler error - generic array creation
			contents = (T[]) new Object[size]; // workaround - casting Object[]
												// to generic Type
		}

		public void add(T content) {
			contents[index++] = content;
		}

		public T get(int index) {
			return contents[index];
		}
	}

}
