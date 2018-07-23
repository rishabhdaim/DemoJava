/**
 * 
 */
package javageeks.dp.visitor;

/**
 * @author rishabh.daim
 * 
 */
public interface ItemElement {

	int accept(ShoppingCartVisitor visitor);
}
