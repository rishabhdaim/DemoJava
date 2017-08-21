/**
 * 
 */
package javageeks.dp.flyweight;

/**
 * @author Rishabh.Daim
 *
 */
public class CPlatform implements Platform {

	public CPlatform() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("CPlatform object created");
	}

	@Override
	public void execute(Code code) {
		System.out.println("Compiling and executing C code.");
	}
}
