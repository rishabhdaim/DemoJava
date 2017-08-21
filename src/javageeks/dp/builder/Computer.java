/**
 * 
 */
package javageeks.dp.builder;

/**
 * @author aa49442
 * 
 */
public class Computer {

	// required parameters..
	private final String hdd;
	private final String ram;

	// optional paramaters..
	private boolean isGraphisCardPresent;
	private boolean isBluetoothEnabled;

	public Computer(ComputerBuilder computerBuilder) {
		this.hdd = computerBuilder.hdd;
		this.ram = computerBuilder.ram;
		this.isBluetoothEnabled = computerBuilder.isBluetoothEnabled;
		this.isGraphisCardPresent = computerBuilder.isGraphisCardPresent;
	}

	/**
	 * @return the hdd
	 */
	public String getHdd() {
		return hdd;
	}

	/**
	 * @return the ram
	 */
	public String getRam() {
		return ram;
	}

	/**
	 * @return the isGraphisCardPresent
	 */
	public boolean getIsGraphisCardPresent() {
		return isGraphisCardPresent;
	}

	/**
	 * @return the isBluetoothEnabled
	 */
	public boolean getIsBluetoothEnabled() {
		return isBluetoothEnabled;
	}

	// Builder Class

	public static class ComputerBuilder {
		// required parameters
		private String hdd;
		private String ram;

		// optional parameters
		private boolean isGraphisCardPresent;
		private boolean isBluetoothEnabled;

		/**
		 * @param hdd
		 * @param ram
		 */
		public ComputerBuilder(String hdd, String ram) {
			super();
			this.hdd = hdd;
			this.ram = ram;
		}

		public ComputerBuilder setGraphisCard(boolean isGraphisCardPresent) {
			this.isGraphisCardPresent = isGraphisCardPresent;
			return this;
		}

		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}

		public Computer build() {
			return new Computer(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Computer [hdd=" + hdd + ", ram=" + ram
				+ ", isGraphisCardPresent=" + isGraphisCardPresent
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}
}