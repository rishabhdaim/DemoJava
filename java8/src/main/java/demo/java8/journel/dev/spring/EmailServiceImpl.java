/**
 * 
 */
package demo.java8.journel.dev.spring;

/**
 * @author Rishabh.Daim
 *
 */
public class EmailServiceImpl implements MessageService {

	/* (non-Javadoc)
	 * @see journel.dev.spring.MessageService#sendMessage(java.lang.String, java.lang.String)
	 */
	@Override
	public void sendMessage(String msg, String rec) {
		System.out.println("Email sent to "+rec+ " with Message="+msg);
	}

}
