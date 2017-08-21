/**
 * 
 */
package javageeks.dp.visitor;

/**
 * @author aa49442
 * 
 */
public interface ShoppingCartVisitor {
	
	int visit(Book book);

	int visit(Fruit fruit);
}