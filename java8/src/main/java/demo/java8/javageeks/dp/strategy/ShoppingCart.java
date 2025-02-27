/**
 * 
 */
package demo.java8.javageeks.dp.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rishabh.daim
 * 
 */
public class ShoppingCart {

	// List of items
	List<Item> items;

	public ShoppingCart() {
		items = new ArrayList<>();
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void removeItem(Item item) {
		this.items.remove(item);
	}

	public int calculateTotal() {
		int sum = 0;
		for (Item item : items) {
			sum += item.getPrice();
		}
		return sum;
	}

	public void pay(PaymentStrategy paymentMethod) {
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}