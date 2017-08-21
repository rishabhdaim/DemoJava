/**
 * 
 */
package javageeks.dp.visitor;

/**
 * @author aa49442
 * 
 */
public class Book implements ItemElement {
	private final int price;
	private final String isbnNumber;

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return the isbnNumber
	 */
	public String getIsbnNumber() {
		return isbnNumber;
	}

	/**
	 * @param price
	 * @param isbnNumber
	 */
	public Book(int price, String isbnNumber) {
		super();
		this.price = price;
		this.isbnNumber = isbnNumber;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}