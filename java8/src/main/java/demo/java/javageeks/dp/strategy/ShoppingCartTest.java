/**
 * 
 */
package demo.java.javageeks.dp.strategy;

/**
 * @author rishabh.daim
 * 
 */
public class ShoppingCartTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		Item item1 = new Item("1234", 10);
		Item item2 = new Item("5678", 40);
		Item item3 = new Item("asdf", 234);

		cart.addItem(item1);
		cart.addItem(item2);
		cart.addItem(item3);

		// pay by paypal
		cart.pay(new PaypalStrategy("rishabhdaim1991", "daim"));
		// pay by credit card..
		cart.pay(new CreditCardStrategy("rishu daim", "123456789", "123",
				"09/2014"));
		// pay by cash
		cart.pay(new CashOnDelivery());
	}
}