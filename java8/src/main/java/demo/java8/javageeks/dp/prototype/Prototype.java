/**
 * 
 */
package demo.java8.javageeks.dp.prototype;

/**
 * @author Rishabh.Daim
 *
 */
public interface Prototype extends Cloneable {
	
	AccessControl clone() throws CloneNotSupportedException;
}
