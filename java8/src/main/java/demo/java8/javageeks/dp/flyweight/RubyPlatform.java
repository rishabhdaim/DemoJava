/**
 * 
 */
package demo.java8.javageeks.dp.flyweight;

/**
 * @author Rishabh.Daim
 *
 */
public class RubyPlatform implements Platform {

	public RubyPlatform() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("RubyPlatform object created");
	}

	@Override
	public void execute(Code code) {
		System.out.println("Compiling and executing Ruby code.");
	}
}
