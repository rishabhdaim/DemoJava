/**
 * 
 */
package javageeks.dp.chainofresponsibility;

/**
 * @author rishabh.daim
 * 
 */
public class Currency {

	private int amount;

	/**
	 * @param amount
	 */
	public Currency(int amount) {
		super();
		this.amount = amount;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Currency [amount=" + amount + "]";
	}
}