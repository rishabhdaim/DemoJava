/**
 * 
 */
package demo.java8.javageeks.dp.template;

/**
 * @author rishabh.daim
 * 
 */
public class HousingClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HouseTemplate houseType = new WoodenHouse();
		// using template method
		houseType.buildHouse();
		System.out.println("************");
		houseType = new GlassHouse();
		houseType.buildHouse();
	}
}