/**
 * 
 */
package demo.java8.javageeks.dp.strategy;

/**
 * @author rishabh.daim
 * 
 */
public class CashOnDelivery implements PaymentStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategydp.PaymentStrategy#pay(int)
	 */
	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid by Cash On Delivery..");
	}
}