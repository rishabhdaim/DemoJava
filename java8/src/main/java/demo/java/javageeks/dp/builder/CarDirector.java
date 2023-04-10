/**
 * 
 */
package demo.java.javageeks.dp.builder;

/**
 * @author Rishabh.Daim
 *
 */
public class CarDirector {

	private final CarBuilder carBuilder;

	public CarDirector(CarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}

	public void build() {
		carBuilder.buildBodyStyle();
		carBuilder.buildPower();
		carBuilder.buildEngine();
		carBuilder.buildBreaks();
		carBuilder.buildSeats();
		carBuilder.buildWindows();
		carBuilder.buildFuelType();
	}
}
