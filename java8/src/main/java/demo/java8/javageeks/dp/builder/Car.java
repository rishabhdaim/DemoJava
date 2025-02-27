/**
 * 
 */
package demo.java8.javageeks.dp.builder;

/**
 * @author Rishabh.Daim
 *
 */
public class Car {
	private String bodyStyle;
	private String power;
	private String engine;
	private String breaks;
	private String seats;
	private String windows;
	private String fuelType;
	private final CarType carType;

	/**
	 * @param carType
	 */
	public Car(CarType carType) {
		this.carType = carType;
	}

	/**
	 * @param bodyStyle
	 *            the bodyStyle to set
	 */
	public final void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	/**
	 * @param power
	 *            the power to set
	 */
	public final void setPower(String power) {
		this.power = power;
	}

	/**
	 * @param engine
	 *            the engine to set
	 */
	public final void setEngine(String engine) {
		this.engine = engine;
	}

	/**
	 * @param breaks
	 *            the breaks to set
	 */
	public final void setBreaks(String breaks) {
		this.breaks = breaks;
	}

	/**
	 * @param seats
	 *            the seats to set
	 */
	public final void setSeats(String seats) {
		this.seats = seats;
	}

	/**
	 * @param windows
	 *            the windows to set
	 */
	public final void setWindows(String windows) {
		this.windows = windows;
	}

	/**
	 * @param fuelType
	 *            the fuelType to set
	 */
	public final void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	/**
	 * @return the bodyStyle
	 */
	public final String getBodyStyle() {
		return bodyStyle;
	}

	/**
	 * @return the power
	 */
	public final String getPower() {
		return power;
	}

	/**
	 * @return the engine
	 */
	public final String getEngine() {
		return engine;
	}

	/**
	 * @return the breaks
	 */
	public final String getBreaks() {
		return breaks;
	}

	/**
	 * @return the seats
	 */
	public final String getSeats() {
		return seats;
	}

	/**
	 * @return the windows
	 */
	public final String getWindows() {
		return windows;
	}

	/**
	 * @return the fuelType
	 */
	public final String getFuelType() {
		return fuelType;
	}

	/**
	 * @return the carType
	 */
	public final CarType getCarType() {
		return carType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [");
		if (bodyStyle != null) {
			builder.append("bodyStyle=");
			builder.append(bodyStyle);
			builder.append(", ");
		}
		if (power != null) {
			builder.append("power=");
			builder.append(power);
			builder.append(", ");
		}
		if (engine != null) {
			builder.append("engine=");
			builder.append(engine);
			builder.append(", ");
		}
		if (breaks != null) {
			builder.append("breaks=");
			builder.append(breaks);
			builder.append(", ");
		}
		if (seats != null) {
			builder.append("seats=");
			builder.append(seats);
			builder.append(", ");
		}
		if (windows != null) {
			builder.append("windows=");
			builder.append(windows);
			builder.append(", ");
		}
		if (fuelType != null) {
			builder.append("fuelType=");
			builder.append(fuelType);
			builder.append(", ");
		}
		if (carType != null) {
			builder.append("carType=");
			builder.append(carType);
		}
		builder.append("]");
		return builder.toString();
	}
}
