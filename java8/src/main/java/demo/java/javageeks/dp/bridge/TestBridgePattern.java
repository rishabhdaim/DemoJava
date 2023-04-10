/**
 * 
 */
package demo.java.javageeks.dp.bridge;

/**
 * @author Rishabh.Daim
 *
 */
public class TestBridgePattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Product product = new CentralLocking("Central Locking System");
		Product product2 = new GearLocking("Gear Locking System");
		Product product3 = new ParkingSensor("Parking SensorSystem");
		Car car = new BigWheel(product, "BigWheel xz model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		System.out.println();
		car = new BigWheel(product2, "BigWheel xz model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		System.out.println();
		car = new BigWheel(product3, "BigWheel xz model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		System.out.println();
		car = new Motoren(product, "Motoren lm model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		System.out.println();
		car = new Motoren(product2, "Motoren lm model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
		System.out.println();
		car = new Motoren(product3, "BigWheel xz model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
	}

}
