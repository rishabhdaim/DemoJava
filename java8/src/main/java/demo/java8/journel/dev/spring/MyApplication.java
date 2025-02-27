/**
 * 
 */
package demo.java8.journel.dev.spring;

/**
 * @author Rishabh.Daim
 *
 */
public class MyApplication {
	private final EmailService email = new EmailService();

	public void processMessages(String msg, String rec) {
		// do some msg validation, manipulation logic etc
		this.email.sendEmail(msg, rec);
	}
}
