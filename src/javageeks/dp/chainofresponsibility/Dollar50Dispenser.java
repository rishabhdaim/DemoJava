/**
 * 
 */
package javageeks.dp.chainofresponsibility;

/**
 * @author aa49442
 * 
 */
public class Dollar50Dispenser implements DispenseChain {

	private DispenseChain chain;

	/*
	 * (non-Javadoc)
	 * 
	 * @see chain.of.responsedp.DispenseChain#setNextChain(chain.of.responsedp.
	 * DispenseChain)
	 */
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * chain.of.responsedp.DispenseChain#dispense(chain.of.responsedp.Currency)
	 */
	@Override
	public void dispense(Currency cur) {
		if (cur.getAmount() >= 50) {
			int num = cur.getAmount() / 50;
			int rem = cur.getAmount() % 50;
			System.out.println("Dispensing " + num + " 50$ note");
			if (rem != 0)
				this.chain.dispense(new Currency(rem));
		} else
			this.chain.dispense(cur);
	}
}