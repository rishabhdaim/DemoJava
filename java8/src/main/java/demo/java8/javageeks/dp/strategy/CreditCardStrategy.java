/**
 * 
 */
package demo.java8.javageeks.dp.strategy;

/**
 * @author rishabh.daim
 * 
 */
public class CreditCardStrategy implements PaymentStrategy {

	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	/**
	 * @param name
	 * @param cardNumber
	 * @param cvv
	 * @param dateOfExpiry
	 */
	public CreditCardStrategy(String name, String cardNumber, String cvv,
			String dateOfExpiry) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.dateOfExpiry = dateOfExpiry;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategydp.PaymentStrategy#pay(int)
	 */
	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid with credit/debit card");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CreditCardStrategy [name=" + name + ", cardNumber="
				+ cardNumber + ", cvv=" + cvv + ", dateOfExpiry="
				+ dateOfExpiry + "]";
	}
}