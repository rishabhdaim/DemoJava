/**
 * 
 */
package javageeks.dp.visitor;

/**
 * @author rishabh.daim
 * 
 */
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see visitordp.ShoppingCartVisitor#visit(visitordp.Book)
	 */
	@Override
	public int visit(Book book) {
		int cost = 0;
		// apply 5$ discount if book price is greater than 50
		if (book.getPrice() > 50)
			cost = book.getPrice() - 5;
		else
			cost = book.getPrice();
		System.out.println("Book ISBN::" + book.getIsbnNumber() + " cost =" + cost);
		return cost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see visitordp.ShoppingCartVisitor#visit(visitordp.Fruit)
	 */
	@Override
	public int visit(Fruit fruit) {
		int cost = fruit.getPricePerKg() * fruit.getWeight();
		System.out.println(fruit.getName() + " cost = " + cost);
		return cost;
	}
}