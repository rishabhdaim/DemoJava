/**
 * 
 */
package javageeks.dp.chainofresponsibility;

/**
 * @author aa49442
 * 
 */
public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);

	void dispense(Currency cur);

}