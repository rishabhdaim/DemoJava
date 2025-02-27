/**
 * 
 */
package demo.java8.javageeks.dp.visitor;

/**
 * @author rishabh.daim
 * 
 */
public interface ItemElement {

	int accept(ShoppingCartVisitor visitor);
}
