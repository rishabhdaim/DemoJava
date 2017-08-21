/**
 * 
 */
package javageeks.dp.bridge;

/**
 * @author Rishabh.Daim
 *
 */
public class ParkingSensor implements Product {

	private final String productName;

	public ParkingSensor(String productName) {
		this.productName = productName;
	}

	@Override
	public String productName() {
		return productName;
	}

	@Override
	public void produce() {
		System.out.println("Producing Parking Sensor System");
	}

}
