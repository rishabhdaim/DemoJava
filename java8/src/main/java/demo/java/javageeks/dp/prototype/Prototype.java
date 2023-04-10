/**
 * 
 */
package demo.java.javageeks.dp.prototype;

/**
 * @author Rishabh.Daim
 *
 */
public interface Prototype extends Cloneable {
	
	AccessControl clone() throws CloneNotSupportedException;
}
