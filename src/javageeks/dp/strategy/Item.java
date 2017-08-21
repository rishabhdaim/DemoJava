/**
 * 
 */
package javageeks.dp.strategy;

/**
 * @author aa49442
 * 
 */
public class Item {

	private final String upcCode;
	private final int price;

	/**
	 * @param upcCode
	 * @param price
	 */
	public Item(String upcCode, int price) {
		super();
		this.upcCode = upcCode;
		this.price = price;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [upcCode=" + upcCode + ", price=" + price + "]";
	}

	/**
	 * @return the upcCode
	 */
	public String getUpcCode() {
		return upcCode;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
}