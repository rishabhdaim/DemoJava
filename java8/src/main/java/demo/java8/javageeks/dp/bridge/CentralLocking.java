/**
 * 
 */
package demo.java8.javageeks.dp.bridge;

/**
 * @author Rishabh.Daim
 *
 */
public class CentralLocking implements Product {

	private final String productName;

	public CentralLocking(String productName) {
		this.productName = productName;
	}

	@Override
	public String productName() {
		return productName;
	}

	@Override
	public void produce() {
		System.out.println("Producing Central Locking System");
	}

}
