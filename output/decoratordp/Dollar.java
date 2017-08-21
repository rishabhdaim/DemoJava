package decoratordp;

public class Dollar extends Currency {
	private double value;

	public Dollar() {
		description = "Dollar";
	}

	public double cost(double v) {
		value = v;
		return value;

	}

}
