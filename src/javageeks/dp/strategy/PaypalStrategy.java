/**
 * 
 */
package javageeks.dp.strategy;

/**
 * @author rishabh.daim
 * 
 */
public class PaypalStrategy implements PaymentStrategy {

	private String emailId;
	private String password;

	/**
	 * @param emailId
	 * @param password
	 */
	public PaypalStrategy(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategydp.PaymentStrategy#pay(int)
	 */
	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using Paypal.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaypalStrategy [emailId=" + emailId + ", password=" + password
				+ "]";
	}
}
