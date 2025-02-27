/**
 * 
 */
package demo.java8.javageeks.dp.template;

/**
 * @author rishabh.daim
 * 
 */
public abstract class HouseTemplateImpl implements HouseTemplate {

	// template method, final so subclasses can't override
	@Override
	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built.");
	}

	protected abstract void buildWalls();

	protected abstract void buildPillars();

	// default implementation
	public final void buildWindows() {
		System.out.println("Building Glass Windows");
	}

	// default implementation
	public final void buildFoundation() {
		System.out
				.println("Building foundation with cement,iron rods and sand");
	}

}
