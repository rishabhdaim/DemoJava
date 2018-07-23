/**
 * 
 */
package javageeks.dp.chainofresponsibility;

/**
 * @author rishabh.daim
 * 
 */
public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);

	void dispense(Currency cur);

}