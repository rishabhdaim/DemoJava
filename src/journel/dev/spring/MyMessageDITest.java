/**
 * 
 */
package journel.dev.spring;

/**
 * @author Rishabh.Daim
 *
 */
public class MyMessageDITest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String msg = "Hi rishu";
        String email = "rishu@abc.com";
        String phone = "8800640514";
        String name = "rishabh";
        MessageServiceInjector injector = null;
        Consumer app = null;
         
        //Send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);
         
        //Send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
        
        // Send Fb ping
        injector = new FbServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, name);
	}
}
