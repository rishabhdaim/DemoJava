/**
 * 
 */
package demo.java.javageeks.dp.flyweight;

/**
 * @author Rishabh.Daim
 *
 */
public class JavaPlatform implements Platform {

	public JavaPlatform() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("JavaPlatform object created");
	}

	@Override
	public void execute(Code code) {
		System.out.println("Compiling and executing Java code.");
	}
}
