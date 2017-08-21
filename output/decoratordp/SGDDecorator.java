package decoratordp;

public class SGDDecorator extends Decorator {
	private Currency currency;

	public SGDDecorator(Currency currency) {
		super();
		this.currency = currency;
	}

	@Override
	public String getDescription() {
		return this.currency.getDescription()
				+ " it's singapore dollar..";
	}

	@Override
	public double cost(double value) {
		return 45.45 * value;
	}

}
