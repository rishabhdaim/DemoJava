/**
 * 
 */
package demo.java.javageeks.dp.chainofresponsibility;

/**
 * @author rishabh.daim
 * 
 */
public class Dollar10Dispenser implements DispenseChain {

	/*
	 * (non-Javadoc)
	 * 
	 * @see chain.of.responsedp.DispenseChain#setNextChain(chain.of.responsedp.
	 * DispenseChain)
	 */
	@Override
	public void setNextChain(DispenseChain nextChain) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * chain.of.responsedp.DispenseChain#dispense(chain.of.responsedp.Currency)
	 */
	@Override
	public void dispense(Currency cur) {
		int num = cur.getAmount() / 10;
		System.out.println("Dispensing " + num + " 10$ note");
	}
}