/**
 * 
 */
package javageeks.dp.template;

/**
 * @author aa49442
 * 
 */
public class WoodenHouse extends HouseTemplateImpl {

	/*
	 * (non-Javadoc)
	 * 
	 * @see templatedp.HouseTemplate#buildWalls()
	 */
	@Override
	public void buildWalls() {
		System.out.println("Building Wooden Walls");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see templatedp.HouseTemplate#buildPillars()
	 */
	@Override
	public void buildPillars() {
		System.out.println("Building Pillars with Wood coating");
	}
}