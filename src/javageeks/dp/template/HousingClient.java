/**
 * 
 */
package javageeks.dp.template;

/**
 * @author aa49442
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