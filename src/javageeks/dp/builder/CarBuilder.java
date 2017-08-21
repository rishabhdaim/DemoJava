/**
 * 
 */
package javageeks.dp.builder;

/**
 * @author Rishabh.Daim
 *
 */
public interface CarBuilder {

	public void buildBodyStyle();

	public void buildPower();

	public void buildEngine();

	public void buildBreaks();

	public void buildSeats();

	public void buildWindows();

	public void buildFuelType();

	public Car buildCar();
}
