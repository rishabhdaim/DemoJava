/**
 * 
 */
package demo.java8.java8;

/**
 * @author Rishabh.Daim
 *
 */
public class TestJava8Interface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
		defaulable.defaultMethod();

		defaulable = DefaulableFactory.create(OverridableImpl::new);
		defaulable.defaultMethod();
	}
}