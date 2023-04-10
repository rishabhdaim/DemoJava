/**
 * 
 */
package demo.java.javageeks.dp.visitor;

/**
 * @author rishabh.daim
 * 
 */
interface ShoppingCartVisitor {
	
	int visit(Book book);

	int visit(Fruit fruit);

	int visit(Fuel fuel);
}