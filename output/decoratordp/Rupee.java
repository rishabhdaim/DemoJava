package decoratordp;

public class Rupee extends Currency {

	private double value;

	@Override
	public double cost(double value) {
		this.value = value;
		return this.value;
	}

	public Rupee() {
		description = "indian rupees";
	}

}
