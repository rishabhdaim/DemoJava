/**
 * 
 */
package demo.java.javageeks.dp.template;

/**
 * @author rishabh.daim
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