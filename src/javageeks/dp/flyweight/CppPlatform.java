/**
 * 
 */
package javageeks.dp.flyweight;

/**
 * @author Rishabh.Daim
 *
 */
public class CppPlatform implements Platform {

	public CppPlatform() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Cpp Platform object created");
	}

	@Override
	public void execute(Code code) {
		System.out.println("Compiling and executing Cpp code.");
	}
}
