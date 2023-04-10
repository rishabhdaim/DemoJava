/**
 * 
 */
package demo.java.threads;

/**
 * @author rishabh.daim
 * 
 */
public class Resource {

	public void doSomething() {
		// do some operation, DB read, write etc
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("done something..");
	}

	public void doLogging() {
		// logging, no need for thread safety
		System.out.println("done logging..");
	}
}
