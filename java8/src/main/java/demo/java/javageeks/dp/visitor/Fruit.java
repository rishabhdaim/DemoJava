/**
 * 
 */
package demo.java.javageeks.dp.visitor;

/**
 * @author rishabh.daim
 * 
 */
public class Fruit implements ItemElement {
	private final int pricePerKg;
	private final int weight;
	private final String name;

	/**
	 * @param pricePerKg
	 * @param weight
	 * @param name
	 */
	public Fruit(final int pricePerKg, final int weight, final String name) {
		super();
		this.pricePerKg = pricePerKg;
		this.weight = weight;
		this.name = name;
	}

	/**
	 * @return the pricePerKg
	 */
	public int getPricePerKg() {
		return pricePerKg;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

}
