/**
 * 
 */
package demo.java8.javageeks.dp.visitor;

/**
 * @author rishabh.daim
 * 
 */
interface ShoppingCartVisitor {
	
	int visit(Book book);

	int visit(Fruit fruit);

	int visit(Fuel fuel);
}