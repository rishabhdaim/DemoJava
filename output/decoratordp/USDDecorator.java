package decoratordp;

public class USDDecorator extends Decorator {
	private Currency currency;

	/* (non-Javadoc)
	 * @see decoratordp.Decorator#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.currency.getDescription() + " it's US dollar..";
	}

	@Override
	public double cost(double value) {
		return 61.65 * value;
	}

	public USDDecorator(Currency currency) {
		this.currency = currency;
	}

}
