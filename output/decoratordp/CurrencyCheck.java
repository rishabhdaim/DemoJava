package decoratordp;

public class CurrencyCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Currency curr = new Dollar();

		System.out
				.println(curr.getDescription() + " dollar. " + curr.cost(2.0));

		curr = new USDDecorator(curr);
		System.err.println(curr.getDescription() + " dollar. " + curr.cost(5));

	}

}
