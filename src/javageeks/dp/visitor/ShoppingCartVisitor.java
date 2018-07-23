/**
 * 
 */
package javageeks.dp.visitor;

/**
 * @author rishabh.daim
 * 
 */
public interface ShoppingCartVisitor {
	
	int visit(Book book);

	int visit(Fruit fruit);
}